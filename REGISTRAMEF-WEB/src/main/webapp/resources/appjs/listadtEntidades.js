var contexto = window.location.pathname.substring(0,window.location.pathname.indexOf('/',2));
var pglogoff = window.location.origin+contexto+'/logoff.htm';
var principalUrl = window.location.origin+contexto+'/index.htm';
var listadtEntidadesUrl = contexto+"/rs/ctrldtEntidades/listadtEntidades";
var insertdtEntidadesUrl = contexto+"/rs/ctrldtEntidades/salvardtEntidades";
var eliminardtEntidadesUrl = contexto+"/rs/ctrldtEntidades/eliminardtEntidades";
var activardtEntidadesUrl = contexto+"/rs/ctrldtEntidades/activardtEntidades";
var eliminarListadtEntidadesUrl = contexto+"/rs/ctrldtEntidades/eliminarListadtEntidades";
var editardtEntidadesUrl = contexto+"/rs/ctrldtEntidades/editardtEntidades/";
var listaPrtParametrosidparametroIdTipoUrl = contexto+"/rs/ctrldtEntidades/listaPrtParametrosIdparametroIdTipo";
var listaPrtParametrosidparametroIdCaractUrl = contexto+"/rs/ctrldtEntidades/listaPrtParametrosIdparametroIdCaract";
var listaMsSisAdmistrativoidSistAdmiIdSistAdmiUrl = contexto+"/rs/ctrldtEntidades/listaMsSisAdmistrativoIdSistAdmiIdSistAdmi";
var descargarUrl = contexto+"/rs/ctrldtEntidades/descargar/";
var listaMsSedesidSedeIdSedeUrl = contexto+"/rs/ctrldtEntidades/listaMsSedesIdSedeIdSede";


///URLs CARGA DE ARCHIVOS
var insertDocUrl = contexto+"/rs/ctrldtEntidades/insertarchivo";
///FIN URLs CARGA DE ARCHIVOS

var descargarvistaUrl = contexto+"/rs/ctrldtEntidades/descargarvista";

/**
 * 
 */
myapp = angular.module('MyApp');

myapp.config(function($routeProvider) {
	$routeProvider
	.when("/editar/:idEntidad", {
		templateUrl : "adminis/editardtEntidades.html",
		controller : "ctrlListadtEntidades"
	})
	.when("/nuevo", {
		templateUrl : "adminis/editardtEntidades.html",
		controller : "ctrlListadtEntidades"
	})
	.otherwise({
		templateUrl : "adminis/verdtEntidades.html",
		controller : "ctrlListadtEntidades"  
	});
});

myapp.config(['$mdDateLocaleProvider', function ($mdDateLocaleProvider) {

	$mdDateLocaleProvider.months = ['enero', 'febrero', 'marzo','abril','mayo','junio','julio','agosto','septiembre','octubre','noviembre','diciembre'];
	$mdDateLocaleProvider.shortMonths = ['ene', 'feb', 'mar','abr','may','jun','jul','ago','sep','oct','nov','dic'];;
	$mdDateLocaleProvider.days = ['domingo','lunes', 'martes', 'miercoles','jueves','viernes','sabado'];
	$mdDateLocaleProvider.shortDays = ['Do','Lu', 'Ma', 'Mi','Ju','Vi','Sa'];

	$mdDateLocaleProvider.formatDate = function (date) {
		if(date==null)
			return "";
		var day = date.getDate();
		var monthIndex = date.getMonth();
		var year = date.getFullYear();

		return (day<10?'0'+day:day) + '/' + (monthIndex<9?'0'+(monthIndex + 1):(monthIndex + 1)) + '/' + year;

//		return date ? moment(date).format('DD/MM/YYYY') : '';
	};
	$mdDateLocaleProvider.parseDate = function (dateString) {
//		var m = moment(dateString, 'DD/MM/YYYY', true);
		var parts = dateString.split("/");
		var dt = new Date(parseInt(parts[2], 10),
				parseInt(parts[1], 10) - 1,
				parseInt(parts[0], 10));
		return dt ? dt:new Date(NaN);
//		return m.isValid() ? m.toDate() : new Date(NaN);
	};
}]);

myapp.controller('ctrlListadtEntidades', ['$mdEditDialog', '$scope', '$timeout', '$http', '$mdDialog','$location','$routeParams', '$mdPanel',  function ($mdEditDialog, $scope, $timeout, $http, $mdDialog, $location, $routeParams, $mdPanel) {
	'use strict';

	$scope.limitOptions = [100, 500, 1000, 5000];
	$scope.query = {
			order: 'idEntidad',
			limit: 100,
			page: 1
	};

	$scope.selected = [];
	$scope.options = {
			rowSelection: true,
			multiSelect: true,
			autoSelect: true,
			decapitate: false,
			largeEditDialog: false,
			boundaryLinks: true,
			limitSelect: true,
			pageSelect: true
	};

	$scope.principal=function(){
		window.location.href=principalUrl; 
	};	 

	$scope.logOrder = function (order) {
		console.log('order: ', order);
		$scope.loaddtEntidadess();
	};

	$scope.logItem = function (item) {
		console.log(item.name, 'was selected');
	};

	$scope.logPagination = function (page, limit) {
		console.log('page: ', page);
		console.log('limit: ', limit);
		$scope.loaddtEntidadess();
	};
	$scope.creadtEntidades = false;
	// ///////////////////////////////////////////
	$scope.datos = [];
	$scope.total = 0;

	$scope.loaddtEntidadess = function () {
		// $scope.promise = $timeout(function () {
		var surl = $scope.getURL();	    
		$scope.promise = $http.get(surl).then(function(res){
			$scope.datos = res.data.data;
			if(res.data.contador>0)
				$scope.total = res.data.contador;
			var tiempoenBD = res.data.tiempoenBD;
			var tiempoenproceso = res.data.tiempoenproceso;
			$scope.creadtEntidades = res.data.creamodifica;
			console.log("data " +$scope.datos.length+" DE "+ $scope.total);
			console.log("Tiempo respuesta BD dtEntidades " +tiempoenBD+" Tiempo en Paginar "+tiempoenproceso);
		},
		function error(errResponse) {
			var dato;
			if(errResponse && errResponse.data){
				console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
				dato = errResponse.data;
			}
			if(errResponse.message){ 
				console.log("Message " + errResponse.message);
				dato = errResponse.message;
			}			
			if(typeof(dato) != 'undefined'){
				$mdDialog.show(
						$mdDialog.alert()
						.parent(angular.element(document.body))
						.clickOutsideToClose(true)
						.title('Lista de Entidades')
						.textContent(dato)
						.ariaLabel('ERROR')
						.ok('OK')
				);
			}
		});			 
		// }, 500);
	};

	$scope.getURLParametros=function(){
		var elprimero = true;
		var order = ""; 
		if(!$scope.isNull($scope.query.order) && $scope.isString($scope.query.order)){
			if(elprimero){
				elprimero=false;
				order = "?order="+$scope.query.order;
			}else{
				order = "&order="+$scope.query.order;
			}
		}
		var limit ="";
		if(!$scope.isNull($scope.query.limit) && !isNaN($scope.query.limit)){
			if(elprimero){
				elprimero=false;
				limit = "?limit="+$scope.query.limit;
			}else{
				limit = "&limit="+$scope.query.limit;
			}
		}
		var page="";
		if(!$scope.isNull($scope.query.page) && !isNaN($scope.query.page)){
			if(elprimero){
				elprimero=false;
				page = "?page="+$scope.query.page;
			}else{
				page = "&page="+$scope.query.page;
			}
		}		    
		// /FILTRO
		const keys = Object.keys($scope.filtro);
		// console.log('Filtro Keys '+keys);
		var filtroparametro = "";
		Object.keys($scope.filtro).forEach(key => {
			// console.log(key);
			const valor = $scope.filtro[key];
			// console.log('Filtro Key '+key+' Valor '+valor);
			if(!$scope.isNull(valor) && ($scope.isString(valor) || $scope.isNumber(valor))){
				if(elprimero){
					elprimero=false;
					filtroparametro += "?"+key+"="+encodeURIComponent(valor);
				}else{
					filtroparametro += "&"+key+"="+encodeURIComponent(valor);
				}
			}
		});
		console.log('Parametros del URL: '+order+limit+page+filtroparametro);	 
		return order+limit+page+filtroparametro;
	}

	$scope.getURL=function(){		    	 
		return listadtEntidadesUrl+$scope.getURLParametros();
	}

	$scope.editdtEntidades = function () {
		$scope.nuevo = true;
		var idEntidad = $routeParams.idEntidad;
		if(idEntidad){
			$scope.cargardtEntidades(idEntidad);
		}
		// /CARGAR COMPLEMENTOS
		$scope.loadListaPrtParametrosIdTipo();// SELECT
		$scope.loadListaPrtParametrosIdCaract();// SELECT
		$scope.loadListaMsSisAdmistrativoIdSistAdmi();// SELECT
		$scope.loadListaMsSedesIdSede();//SELECT
	};

	$scope.filtro ={
			codEjec: null,
			razSocial: null,
			ruc: null,
			idTipo: null,
			codDpto: null,
			codProv: null,
			codDistr: null,
			idCaract: null,
			idSistAdmi: null,
			estado: null,

			estado: null
	}; 

	$scope.seteestado = function(eestado) {
		if($scope.filtro.estado === eestado){
			$scope.filtro.estado = null;
		}else{
			$scope.filtro.estado = eestado;
		}
		$scope.loaddtEntidadess();
	};

	$scope.refrescarvista = function(ev){
		if(typeof(ev)=='undefined' || ev==null){

		}else{
			var keyCode = ev.which || ev.keyCode;
			if (keyCode === 13) {
				$scope.loaddtEntidadess();
			}else if (keyCode === 1) {
				$scope.loaddtEntidadess();
			}
		}
	};

	$scope.dtEntidadesModelo = {
			idEntidad : null,
			codEjec: null,
			razSocial: null,
			ruc: null,
			idTipo: null,
			codDpto: null,
			codProv: null,
			codDistr: null,
			idCaract: null,
			idSistAdmi: null,
			estado: null,
			direccion: null,
			idpais: null,
			geozona: null,

			// ADICIONALES
			idTipoTxt: null,
			codDptoTxt: null,
			codProvTxt: null,
			codDistrTxt: null,
			idCaractTxt: null,
			idSistAdmiTxt: null,
			estadoTxt: null,
			idpaisTxt: null,
			dtEntidadSedesss: [],

			editopcion: 1
	};

	$scope.cleardtEntidades = function(){
		$scope.dtEntidadesModelo.idEntidad = null;
		$scope.dtEntidadesModelo.codEjec = null;
		$scope.dtEntidadesModelo.razSocial = null;
		$scope.dtEntidadesModelo.ruc = null;
		$scope.dtEntidadesModelo.idTipo = null;
		$scope.dtEntidadesModelo.codDpto = null;
		$scope.dtEntidadesModelo.codProv = null;
		$scope.dtEntidadesModelo.codDistr = null;
		$scope.dtEntidadesModelo.idCaract = null;
		$scope.dtEntidadesModelo.idSistAdmi = null;
		$scope.dtEntidadesModelo.estado = null;
		$scope.dtEntidadesModelo.direccion = null;
		$scope.dtEntidadesModelo.idpais = null;
		$scope.dtEntidadesModelo.geozona = null;

		// ADICIONALES
		$scope.dtEntidadesModelo.idTipoTxt = null;
		$scope.dtEntidadesModelo.codDptoTxt = null;
		$scope.dtEntidadesModelo.codProvTxt = null;
		$scope.dtEntidadesModelo.codDistrTxt = null;
		$scope.dtEntidadesModelo.idCaractTxt = null;
		$scope.dtEntidadesModelo.idSistAdmiTxt = null;
		$scope.dtEntidadesModelo.estadoTxt = null;
		$scope.dtEntidadesModelo.idpaisTxt = null;
		$scope.dtEntidadesModelo.dtEntidadSedesss= [];

		$scope.dtEntidadesModelo.editopcion = 1;
	} 

	$scope.setDtEntidadesModelo = function(dtEntidadesBk) {
		$scope.dtEntidadesModelo.idEntidad = dtEntidadesBk.idEntidad;
		$scope.dtEntidadesModelo.codEjec = dtEntidadesBk.codEjec;
		$scope.dtEntidadesModelo.razSocial = dtEntidadesBk.razSocial;
		$scope.dtEntidadesModelo.ruc = dtEntidadesBk.ruc;
		$scope.dtEntidadesModelo.idTipo = dtEntidadesBk.idTipo;
		$scope.dtEntidadesModelo.codDpto = dtEntidadesBk.codDpto;
		$scope.dtEntidadesModelo.codProv = dtEntidadesBk.codProv;
		$scope.dtEntidadesModelo.codDistr = dtEntidadesBk.codDistr;
		$scope.dtEntidadesModelo.idCaract = dtEntidadesBk.idCaract;
		$scope.dtEntidadesModelo.idSistAdmi = dtEntidadesBk.idSistAdmi;
		$scope.dtEntidadesModelo.estado = dtEntidadesBk.estado;
		$scope.dtEntidadesModelo.direccion = dtEntidadesBk.direccion;
		$scope.dtEntidadesModelo.idpais = dtEntidadesBk.idpais;
		$scope.dtEntidadesModelo.geozona = dtEntidadesBk.geozona;

		// ADICIONALES
		$scope.dtEntidadesModelo.idTipoTxt = dtEntidadesBk.idTipoTxt;
		$scope.dtEntidadesModelo.codDptoTxt = dtEntidadesBk.codDptoTxt;
		$scope.dtEntidadesModelo.codProvTxt = dtEntidadesBk.codProvTxt;
		$scope.dtEntidadesModelo.codDistrTxt = dtEntidadesBk.codDistrTxt;
		$scope.dtEntidadesModelo.idCaractTxt = dtEntidadesBk.idCaractTxt;
		$scope.dtEntidadesModelo.idSistAdmiTxt = dtEntidadesBk.idSistAdmiTxt;
		$scope.dtEntidadesModelo.estadoTxt = dtEntidadesBk.estadoTxt;
		$scope.dtEntidadesModelo.idpaisTxt = dtEntidadesBk.idpaisTxt;
		$scope.dtEntidadesModelo.dtEntidadSedesss = dtEntidadesBk.dtEntidadSedesss;
		if($scope.isNull($scope.dtEntidadesModelo.dtEntidadSedesss) || 
				!$scope.isArray($scope.dtEntidadesModelo.dtEntidadSedesss)){
			$scope.dtEntidadesModelo.dtEntidadSedesss= [];
		}

		$scope.dtEntidadesModelo.editopcion = dtEntidadesBk.dtEntidadesACL.editopcion;
	}
	// ////////////////////////////////////////////////
	$scope.editarDtEntidades = function(ev, dtEntidadesBk) {		  
		$scope.setDtEntidadesModelo(dtEntidadesBk);		  
		$location.url('/editar/' + $scope.dtEntidadesModelo.idEntidad);
		$scope.nuevo = false;
	}

	$scope.nuevoDtEntidades = function() {
		$scope.cleardtEntidades();
		$location.url('/nuevo');
		$scope.nuevo = true;
	}

	$scope.cancelarDtEntidades = function() {
		$scope.cleardtEntidades();
		$location.url('/');
	}

	$scope.salvarDtEntidades = function(ev){		
		ev.target.disabled = true;
		var datainsert = angular.toJson($scope.dtEntidadesModelo);
		console.log("datainsert = "+datainsert);	
		$http.post(insertdtEntidadesUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
			var dato = res.data;

//			$scope.datos.push(dato);
			$scope.total = $scope.datos.length;

			$scope.setDtEntidadesModelo(dato);

			$mdDialog.show(
					$mdDialog.alert()
					.parent(angular.element(document.body))
					.clickOutsideToClose(true)
					.title('Guardar Entidades')
					.textContent("del Entidades se guardó correctamente.")
					.ariaLabel('ERROR')
					.ok('OK')
					.targetEvent(ev)
			);

			$scope.nuevo = false;
		},
		function error(errResponse) {
			var dato;
			if(errResponse && errResponse.data){
				console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
				dato = errResponse.data;
			}
			if(errResponse.message){ 
				console.log("Message " + errResponse.message);
				dato = errResponse.message;
			}			
			if(typeof(dato) != 'undefined'){
				$mdDialog.show(
						$mdDialog.alert()
						.parent(angular.element(document.body))
						.clickOutsideToClose(true)
						.title('Guardar Entidades')
						.textContent(dato)
						.ariaLabel('ERROR')
						.ok('OK')
						.targetEvent(ev)
				);
			}
		});		

		ev.target.disabled = false;
	};

	$scope.eliminardtEntidades = function(ev,dtEntidadesBk){		
		ev.target.disabled = true;
		$scope.setDtEntidadesModelo(dtEntidadesBk);
		var datainsert = angular.toJson($scope.dtEntidadesModelo);
		console.log("Eliminar = "+datainsert);	
		$http.post(eliminardtEntidadesUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
			var dato = res.data;
			var instrumentos = $scope.datos;
			var index = $scope.datos.findIndex(obj => obj.idEntidad === dato.idEntidad);
			console.log("INDEX " + index);
			if(instrumentos.length>index){
				instrumentos.splice(index, 1);
				$scope.datos = instrumentos;
				$scope.total = $scope.datos.length;
			}	
		},
		function error(errResponse) {
			var dato;
			if(errResponse && errResponse.data){
				console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
				dato = errResponse.data;
			}
			if(errResponse.message){ 
				console.log("Message " + errResponse.message);
				dato = errResponse.message;
			}			
			if(typeof(dato) != 'undefined'){
				$mdDialog.show(
						$mdDialog.alert()
						.parent(angular.element(document.body))
						.clickOutsideToClose(true)
						.title('Eliminar Entidades')
						.textContent(dato)
						.ariaLabel('ERROR')
						.ok('OK')
						.targetEvent(ev)
				);
			}
		});			        			        	
		ev.target.disabled = false;
	};

	$scope.activardtEntidades = function(ev,dtEntidadesBk){		
		ev.target.disabled = true;
		$scope.setDtEntidadesModelo(dtEntidadesBk);
		var datainsert = angular.toJson($scope.dtEntidadesModelo);
		console.log("Activar = "+datainsert);	
		$http.post(activardtEntidadesUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
			var dato = res.data;
			var instrumentos = $scope.datos;
			var index = $scope.datos.findIndex(obj => obj.idEntidad === dato.idEntidad);
			console.log("INDEX " + index);
			if(instrumentos.length>index){
				instrumentos.splice(index, 1);
				$scope.datos = instrumentos;
				$scope.total = $scope.datos.length;
			}	
		},
		function error(errResponse) {
			var dato;
			if(errResponse && errResponse.data){
				console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
				dato = errResponse.data;
			}
			if(errResponse.message){ 
				console.log("Message " + errResponse.message);
				dato = errResponse.message;
			}			
			if(typeof(dato) != 'undefined'){
				$mdDialog.show(
						$mdDialog.alert()
						.parent(angular.element(document.body))
						.clickOutsideToClose(true)
						.title('Activar Entidades')
						.textContent(dato)
						.ariaLabel('ERROR')
						.ok('OK')
						.targetEvent(ev)
				);
			}
		});			        			        	
		ev.target.disabled = false;
	};

	$scope.eliminarListadtEntidades = function(ev){		
		ev.target.disabled = true;

		if(!$scope.isArray($scope.selected) || $scope.selected.length<=0){
			$mdDialog.show(
					$mdDialog.alert()
					.parent(angular.element(document.body))
					.clickOutsideToClose(true)
					.title('Eliminar')
					.textContent("NO SE HA SELECCIONADO REGISTROS PARA ELIMINAR... ")
					.ariaLabel('ERROR')
					.ok('OK')
					.targetEvent(ev)
			);
			ev.target.disabled = false;
			return;
		}else{
			for (var i = 0; i < $scope.selected.length; i++) {
				listaids.push($scope.selected[i].idEntidad);
			}
		} 

		var datainsert = angular.toJson(listaids);
		console.log("Elimiar = "+datainsert);	
		$http.post(eliminarListadtEntidadesUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
			var dato = res.data;
			$mdDialog.show(
					$mdDialog.alert()
					.parent(angular.element(document.body))
					.clickOutsideToClose(true)
					.title('Eliminar Registros')
					.textContent(dato)
					.ariaLabel('Eliminar')
					.ok('OK')
					.targetEvent(ev)
			);		
		},
		function error(errResponse) {
			var dato;
			if(errResponse && errResponse.data){
				console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
				dato = errResponse.data;
			}
			if(errResponse.message){ 
				console.log("Message " + errResponse.message);
				dato = errResponse.message;
			}			
			if(typeof(dato) != 'undefined'){
				$mdDialog.show(
						$mdDialog.alert()
						.parent(angular.element(document.body))
						.clickOutsideToClose(true)
						.title('Eliminar Entidades')
						.textContent(dato)
						.ariaLabel('ERROR')
						.ok('OK')
						.targetEvent(ev)
				);
			}
		});			        			        	
		ev.target.disabled = false;
	};	

	$scope.cargardtEntidades = function(idEntidad){		
		var surl = editardtEntidadesUrl+idEntidad;
		$http.get(surl).then(function(res){
			var dato = res.data;
			$scope.setDtEntidadesModelo(dato);
			$scope.nuevo = false;
		},
		function error(errResponse) {
			var dato;
			if(errResponse && errResponse.data){
				console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
				dato = errResponse.data;
			}
			if(errResponse.message){ 
				console.log("Message " + errResponse.message);
				dato = errResponse.message;
			}			
			if(typeof(dato) != 'undefined'){
				$mdDialog.show(
						$mdDialog.alert()
						.parent(angular.element(document.body))
						.clickOutsideToClose(true)
						.title('Cargar Entidades')
						.textContent(dato)
						.ariaLabel('ERROR')
						.ok('OK')
				);
			}			           
		});			        			        	
	};

	$scope.showConfirm = function(ev, dtEntidadesBk) {
		var confirm = $mdDialog.confirm()
		.title('Activar Entidades')
		.textContent('Esta usted seguro de activar el registro?')
		.ariaLabel('Lucky day')
		.targetEvent(ev)
		.ok('Si')
		.cancel('No');

		$mdDialog.show(confirm).then(function () {
			$scope.status = 'SI';
			$scope.eliminardtEntidades(ev, dtEntidadesBk);
		}, function () {
			$scope.status = 'NO';
		});
	};

	$scope.showConfirmActivar = function(ev, dtEntidadesBk) {
		var confirm = $mdDialog.confirm()
		.title('Activar Entidades')
		.textContent('Esta usted seguro de activar el registro?')
		.ariaLabel('Lucky day')
		.targetEvent(ev)
		.ok('Si')
		.cancel('No');

		$mdDialog.show(confirm).then(function () {
			$scope.status = 'SI';
			$scope.activardtEntidades(ev, dtEntidadesBk);
		}, function () {
			$scope.status = 'NO';
		});
	};

	$scope.showConfirmLista = function(ev) {
		var tamanio = 0;
		if(!$scope.isArray($scope.selected) || $scope.selected.length<=0){
			$mdDialog.show(
					$mdDialog.alert()
					.parent(angular.element(document.body))
					.clickOutsideToClose(true)
					.title('Eliminar')
					.textContent("NO SE HA SELECCIONADO REGISTROS PARA ELIMINAR... ")
					.ariaLabel('ERROR')
					.ok('OK')
					.targetEvent(ev)
			);
			return;
		}else{
			tamanio = $scope.selected.length;
		}

		var confirm = $mdDialog.confirm()
		.title('Eliminar Entidades')
		.textContent('Esta usted seguro de eliminar los '+tamanio+' registros seleccionados?')
		.ariaLabel('Lucky day')
		.targetEvent(ev)
		.ok('Si')
		.cancel('No');

		$mdDialog.show(confirm).then(function () {
			$scope.status = 'SI';
			$scope.eliminarListadtEntidades(ev);
		}, function () {
			$scope.status = 'NO';
		});
	};		  
//	/ADICIONALES
//	SELECT INI
	$scope.listaPrtParametrosIdTipo=[];
	$scope.loadListaPrtParametrosIdTipo=function(){
		$http.get(listaPrtParametrosidparametroIdTipoUrl).then(function(res){
			$scope.listaPrtParametrosIdTipo = res.data; 
		},
		function error(errResponse) {
			var dato;
			if(errResponse && errResponse.data){
				console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
				dato = errResponse.data;
			}
			if(errResponse.message){ 
				console.log("Message " + errResponse.message);
				dato = errResponse.message;
			}
		});
	};
	$scope.changeIdTipo=function(){
		// /BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
	}
	$scope.$watch('dtEntidadesModelo.idTipo', function (newValue, oldValue) {
		console.log('dtEntidadesModelo.idTipo ' + newValue+' -- '+oldValue);
		// CARGAR DATOS DEL SIGUIENTE SELECT
//		if($scope.isArray($scope.listaPrtParametrosIdTipo)){
//		var obj = $scope.listaPrtParametrosIdTipo.find(o => o.id === newValue);
//		if($scope.isObject(obj)){
//		$scope.prtParametrosModelo.idparametroTxt = obj.valor;
//		}
//		}
	});
//	SELECT FIN
//	SELECT INI
	$scope.listaPrtParametrosIdCaract=[];
	$scope.loadListaPrtParametrosIdCaract=function(){
		$http.get(listaPrtParametrosidparametroIdCaractUrl).then(function(res){
			$scope.listaPrtParametrosIdCaract = res.data; 
		},
		function error(errResponse) {
			var dato;
			if(errResponse && errResponse.data){
				console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
				dato = errResponse.data;
			}
			if(errResponse.message){ 
				console.log("Message " + errResponse.message);
				dato = errResponse.message;
			}
		});
	};
	$scope.changeIdCaract=function(){
		// /BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
	}
	$scope.$watch('dtEntidadesModelo.idCaract', function (newValue, oldValue) {
		console.log('dtEntidadesModelo.idCaract ' + newValue+' -- '+oldValue);
		// CARGAR DATOS DEL SIGUIENTE SELECT
//		if($scope.isArray($scope.listaPrtParametrosIdCaract)){
//		var obj = $scope.listaPrtParametrosIdCaract.find(o => o.id === newValue);
//		if($scope.isObject(obj)){
//		$scope.prtParametrosModelo.idparametroTxt = obj.valor;
//		}
//		}
	});
//	SELECT FIN
//	SELECT INI
	$scope.listaMsSisAdmistrativoIdSistAdmi=[];
	$scope.loadListaMsSisAdmistrativoIdSistAdmi=function(){
		$http.get(listaMsSisAdmistrativoidSistAdmiIdSistAdmiUrl).then(function(res){
			$scope.listaMsSisAdmistrativoIdSistAdmi = res.data; 
		},
		function error(errResponse) {
			var dato;
			if(errResponse && errResponse.data){
				console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
				dato = errResponse.data;
			}
			if(errResponse.message){ 
				console.log("Message " + errResponse.message);
				dato = errResponse.message;
			}
		});
	};
	$scope.changeIdSistAdmi=function(){
		// /BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
	}
	$scope.$watch('dtEntidadesModelo.idSistAdmi', function (newValue, oldValue) {
		console.log('dtEntidadesModelo.idSistAdmi ' + newValue+' -- '+oldValue);
		// CARGAR DATOS DEL SIGUIENTE SELECT
//		if($scope.isArray($scope.listaMsSisAdmistrativoIdSistAdmi)){
//		var obj = $scope.listaMsSisAdmistrativoIdSistAdmi.find(o => o.id ===
//		newValue);
//		if($scope.isObject(obj)){
//		$scope.msSisAdmistrativoModelo.idSistAdmiTxt = obj.valor;
//		}
//		}
	});
//	SELECT FIN

//	DESCARGAR
	$scope.descargar = function(){
		return descargarUrl+$scope.getURLParametros();
	}
////	INICIO AUXILIAR DtEntidadSedes 
	$scope.dtEntidadSedesModelo = {
			idEntiSed : null,
			idEntidad: null,
			idSede: null,

			// ADICIONALES
			idSedeTxt: null,
			
			editopcion: 1
	};

	$scope.setDtEntidadSedesModelo = function(dtEntidadSedesBk) {
		$scope.dtEntidadSedesModelo.idEntiSed = dtEntidadSedesBk.idEntiSed;
		$scope.dtEntidadSedesModelo.idEntidad = dtEntidadSedesBk.idEntidad;
		$scope.dtEntidadSedesModelo.idSede = dtEntidadSedesBk.idSede;

		// ADICIONALES
		$scope.dtEntidadSedesModelo.idSedeTxt = dtEntidadSedesBk.idSedeTxt;
		
		$scope.dtEntidadSedesModelo.editopcion =1;
	}

	$scope.isUltimoDtEntidadSedes = function(ev, indice){
		if(!$scope.isArray($scope.dtEntidadesModelo.dtEntidadSedesss))
			return true;
		if($scope.dtEntidadesModelo.dtEntidadSedesss.length==indice){
			return true;
		}
		return false;
	};

	$scope.addDtEntidadSedes = function(ev){		
		ev.target.disabled = true;
		var datoactual = Object.assign({}, $scope.dtEntidadSedesModelo);
		$scope.clearDtEntidadSedes();
		if($scope.isNull(datoactual.idEntiSed) || $scope.isUndefined(datoactual.idEntiSed)){
			datoactual.idEntiSed = $scope.generateRandomInteger(1000)*-1;
		}	
		if($scope.isArray($scope.dtEntidadesModelo.dtEntidadSedesss)){
			var objEncontrado = $scope.dtEntidadesModelo.dtEntidadSedesss.find(o => o.idEntiSed === datoactual.idEntiSed);
			if($scope.isObject(objEncontrado)){
				Object.assign(objEncontrado, datoactual);
				ev.target.disabled = false;
				return;
			}
		}	
		$scope.dtEntidadesModelo.dtEntidadSedesss.push(datoactual);	
		ev.target.disabled = false;
	};

	$scope.clearDtEntidadSedes = function(){
		$scope.dtEntidadSedesModelo.idEntiSed = null;
		$scope.dtEntidadSedesModelo.idEntidad = null;
		$scope.dtEntidadSedesModelo.idSede = null;

		// ADICIONALES
		$scope.dtEntidadSedesModelo.idSedeTxt = null;
		$scope.dtEntidadSedesModelo.editopcion = 1;
	};

	$scope.removerDtEntidadSedes = function(ev,item){
		var idx = $scope.dtEntidadesModelo.dtEntidadSedesss.indexOf(item);
		if (idx > -1) {
			$scope.dtEntidadesModelo.dtEntidadSedesss.splice(idx, 1);
		}
	};

	$scope.editarDtEntidadSedes = function(ev,item){
		var idx = $scope.dtEntidadesModelo.dtEntidadSedesss.indexOf(item);
		if (idx > -1) {
			$scope.setdtEntidadSedesModelo($scope.dtEntidadesModelo.dtEntidadSedesss[idx]);
		}
	};

	//SELECT INI
	$scope.listaMsSedesIdSede=[];
	$scope.loadListaMsSedesIdSede=function(){
		$http.get(listaMsSedesidSedeIdSedeUrl).then(function(res){
			$scope.listaMsSedesIdSede = res.data; 
		},
		function error(errResponse) {
			var dato;
			if(errResponse && errResponse.data){
				console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
				dato = errResponse.data;
			}
			if(errResponse.message){ 
				console.log("Message " + errResponse.message);
				dato = errResponse.message;
			}
		});
	};
	
	$scope.changeIdSede=function(){
        var dato = $scope.listaMsSedesIdSede.find(obj => obj.id === $scope.dtEntidadSedesModelo.idSede);
        if($scope.isObject(dato)){
        $scope.dtEntidadSedesModelo.idSedeTxt = dato.valor;
		console.log("$scope.dtEntidadSedesModelo.idSedeTxt " + $scope.dtEntidadSedesModelo.idSedeTxt);
        }
      };
	$scope.$watch('dtEntidadSedesModelo.idSede', function (newValue, oldValue) {
		console.log('dtEntidadSedesModelo.idSede ' + newValue+' -- '+oldValue);
	});
	//SELECT FIN                
 
//	/FIN ADICIONALES
	// ////////////////////////////////////////////////////////////////

	$scope.cancel = function() {
		$mdDialog.cancel();
	};
	// Generate a number between 0 and 10, including 10
	$scope.generateRandomInteger = function(max) {
		return Math.floor(Math.random() * max) + 1;
	};
	$scope.formatDate = function(dia){     
		if(typeof(dia)=='undefined' || dia==null)
			return "";
		var d = new Date(dia);
		var dformat = [ d.getFullYear(),
			("00" + (d.getMonth() + 1)).slice(-2),
			("00" + d.getDate()).slice(-2)				        	
			].join('-');
		var dHour = [ ("00" + d.getHours()).slice(-2),
			("00" + d.getMinutes()).slice(-2),
			("00" + d.getSeconds()).slice(-2)				        	
			].join(':');				        
		return dformat+" "+dHour;
	};	
	$scope.formatDMY = function(dia){     
		if(typeof(dia)=='undefined' || dia==null)
			return "";
		var d = new Date(dia);
		var dformat = [ ("00" + d.getDate()).slice(-2),
			("00" + (d.getMonth() + 1)).slice(-2),			
			d.getFullYear()
			].join('-');
		var dHour = [ ("00" + d.getHours()).slice(-2),
			("00" + d.getMinutes()).slice(-2),
			("00" + d.getSeconds()).slice(-2)				        	
			].join(':');				        
		return dformat;
	};
	$scope.formatYMD = function(dia){     
		if(typeof(dia)=='undefined' || dia==null)
			return "";
		var d = new Date(dia);
		var dformat = [ d.getFullYear(),
			("00" + (d.getMonth() + 1)).slice(-2),			
			("00" + d.getDate()).slice(-2)
			].join('-');
		var dHour = [ ("00" + d.getHours()).slice(-2),
			("00" + d.getMinutes()).slice(-2),
			("00" + d.getSeconds()).slice(-2)				        	
			].join(':');				        
		return dformat;
	};	
	$scope.formatDateMonth = function(dia){   
		if(typeof(dia)=='undefined' || dia==null)
			return "";
		var diaa = new Date(dia);
		var monthNames = ['ENERO', 'FEBRERO', 'MARZO','ABRIL','MAYO','JUNIO','JULIO','AGOSTO','SEPTIEMBRE','OCTUBRE','NOVIEMBRE','DICIEMBRE'];
		var monthIndex = diaa.getMonth();
		var monthName = monthNames[monthIndex]
		var year = diaa.getFullYear();

		return monthName+" DE "+year;
	};
	$scope.buildLocaleProvider = function(formatString) {
		return {
			formatDate: function(date) {
				if (date) return moment(date).format(formatString);
				else return null;
			},
			parseDate: function(dateString) {
				if (dateString) {
					var m = moment(dateString, formatString, true);
					return m.isValid() ? m.toDate() : new Date(NaN);
				} else return null;
			}
		};
	};  
	$scope.monthFormat = $scope.buildLocaleProvider("MMM-YYYY");		    

	// Returns if a value is really a number
	$scope.isNumber  = function(value) {
		return typeof value === 'number' && isFinite(value);
	};	

	$scope.nuevo = ($scope.isNumber($scope.dtEntidadesModelo.idEntidad) && $scope.dtEntidadesModelo.idEntidad > 0);
	$scope.edit  = true;


	$scope.toggle = function (item, list) {
		var idx = list.indexOf(item);
		if (idx > -1) {
			list.splice(idx, 1);
		}
		else {
			list.push(item);
		}
	};

	$scope.exists = function (item, list) {
		return list.indexOf(item) > -1;
	};

	$scope.filtroDtEntidades = function(toma){				
		const keys = Object.keys($scope.filtro);
		console.log('Filtro Keys '+keys);
		Object.keys($scope.filtro).forEach(key => {
			console.log(key);
			const valor = $scope.filtro[key];
			// console.log('Filtro Key '+key+' Valor '+valor);
			try{
				if(typeof(valor)!='undefined' && typeof(toma[key])!='undefined'){
					if(valor!=null && toma[key]!=null){
						if(isString(valor)){
							if(toma[key].toUpperCase().indexOf(valor.toUpperCase())<=-1){
								return false;
							};
						}else if(isNumber(valor)){
							const svalor = valor.toString();
							const stoma = toma[key].toString();
							if(stoma.indexOf(svalor)<=-1){
								return false;
							};
						}else {
							if(toma[key]===valor){
								return false;
							}
						}
					}else if($scope.filtro[key]!=null && toma[key]==null){
						return false;
					}
				}else if(typeof($scope.filtro[key])!='undefined' && typeof(toma[key])=='undefined'){
					return false;
				}
			}catch(e){
				console.log("Error = "+e);	
			}
		});
		return true;
	};

	// singers.sort(compareValues('band', 'desc'));
	$scope.compareValues = function(key, order = 'asc') {
		return function innerSort(a, b) {
			if (!a.hasOwnProperty(key) || !b.hasOwnProperty(key)) {
				// property doesn't exist on either object
				return 0;
			}
			const varA = (typeof a[key] === 'string')
			? a[key].toUpperCase() : a[key];
			const varB = (typeof b[key] === 'string')
			? b[key].toUpperCase() : b[key];

			var comparison = 0;
			if (varA > varB) {
				comparison = 1;
			} else if (varA < varB) {
				comparison = -1;
			}
			return (
					(order === 'desc') ? (comparison * -1) : comparison
			);
		};
	};

	$scope.formatDate = function(dia){     
		if(typeof(dia)=='undefined' || dia==null)
			return "";
		var d = new Date(dia);
		var dformat = [ d.getFullYear(),
			("00" + (d.getMonth() + 1)).slice(-2),
			("00" + d.getDate()).slice(-2)				        	
			].join('-');
		var dHour = [ ("00" + d.getHours()).slice(-2),
			("00" + d.getMinutes()).slice(-2),
			("00" + d.getSeconds()).slice(-2)				        	
			].join(':');				        
		return dformat+" "+dHour;
	};

	$scope.formatDateOnly = function(dia){     
		if(typeof(dia)=='undefined' || dia==null)
			return "";
		var d = new Date(dia);
		var dformat = [ d.getFullYear(),
			("00" + (d.getMonth() + 1)).slice(-2),
			("00" + d.getDate()).slice(-2)				        	
			].join('-');				        
		return dformat;
	};	

	// /////////////////////////////////////////////////////////////////
	$scope.estructuta = {
			caracteresespeciales : 'ñq°!"#$%&¡¿?* {}()',
			carcteresacentos: 'áéíóúÁÉÍÓÚ',
			caracteresdelInput: null,
	};


	// Returns if a value is a string
	$scope.isString  = function(value) {
		return typeof value === 'string' || value instanceof String;
	};

	// Returns if a value is an array
	$scope.isArray  = function(value) {
		return value && typeof value === 'object' && value.constructor === Array;
	};

	// Returns if a value is a function
	$scope.isFunction  = function(value) {
		return typeof value === 'function';
	};

	// Returns if a value is an object
	$scope.isObject  = function(value) {
		return value && typeof value === 'object' && value.constructor === Object;
	};

	// Returns if a value is null
	$scope.isNull = function(value) {
		return value === null;
	};

	$scope.isEmpty = function(string) {
		return typeof string === 'string' && string.length === 0;
	};

	// Returns if a value is undefined
	$scope.isUndefined  = function(value) {
		return typeof value === 'undefined';
	};

	// Returns if a value is a boolean
	$scope.isBoolean  = function(value) {
		return typeof value === 'boolean';
	};

	// Returns if a value is a regexp
	$scope.isRegExp  = function(value) {
		return value && typeof value === 'object' && value.constructor === RegExp;
	};

	// Returns if value is an error object
	$scope.isError  = function(value) {
		return value instanceof Error && typeof value.message !== 'undefined';
	};

	// Returns if value is a date object
	$scope.isDate  = function(value) {
		return value instanceof Date;
	};

	// Returns if a Symbol
	$scope.isSymbol  = function(value) {
		return typeof value === 'symbol';
	};

	$scope.invert_key_value = function(obj) {
		var result = {};
		var keys = $scope._keys(obj);
		for (var i = 0, length = keys.length; i < length; i++) {
			result[obj[keys[i]]] = keys[i];
		}
		return result;
	}

	$scope._keys = function(obj) 
	{
		if (!$scope.isObject(obj)) return [];
		if (Object.keys) return Object.keys(obj);
		var keys = [];
		for (var key in obj) if (_.has(obj, key)) keys.push(key);
		return keys;
	}

	$scope.isObject = function(obj) 
	{
		var type = typeof obj;
		return type === 'function' || type === 'object' && !!obj;
	}
	// $scope.promise = $timeout(function () {
	// }, 500);
}]);
