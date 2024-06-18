var contexto = window.location.pathname.substring(0,window.location.pathname.indexOf('/',2));
var pglogoff = window.location.origin+contexto+'/logoff.htm';
var principalUrl = window.location.origin+contexto+'/index.htm';
var listamsUbigeoUrl = contexto+"/rs/ctrlmsUbigeo/listamsUbigeo";
var insertmsUbigeoUrl = contexto+"/rs/ctrlmsUbigeo/salvarmsUbigeo";
var eliminarmsUbigeoUrl = contexto+"/rs/ctrlmsUbigeo/eliminarmsUbigeo";
var activarmsUbigeoUrl = contexto+"/rs/ctrlmsUbigeo/activarmsUbigeo";
var eliminarListamsUbigeoUrl = contexto+"/rs/ctrlmsUbigeo/eliminarListamsUbigeo";
var editarmsUbigeoUrl = contexto+"/rs/ctrlmsUbigeo/editarmsUbigeo/";
//var listaMsUbigeocodDptoCodDptoUrl = contexto+"/rs/ctrlmsUbigeo/listaMsUbigeoCodDptoCodDpto";
//var listaMsUbigeocodProvCodProvUrl = contexto+"/rs/ctrlmsUbigeo/listaMsUbigeoCodProvCodProv";
var descargarUrl = contexto+"/rs/ctrlmsUbigeo/descargar/";

///URLs CARGA DE ARCHIVOS
var insertDocUrl = contexto+"/rs/ctrlmsUbigeo/insertarchivo";
///FIN URLs CARGA DE ARCHIVOS

var listaCoddptosUrl = contexto+"/rs/ctrlmsUbigeo/listaCoddptos";
var listaCodprovUrl = contexto+"/rs/ctrlmsUbigeo/listaCodprov/";
var listaCoddistUrl = contexto+"/rs/ctrlmsUbigeo/listaCoddist/";


/**
 * 
 */
myapp = angular.module('MyApp');

myapp.config(function($routeProvider) {
	$routeProvider
	.when("/editar/:id", {
		templateUrl : "adminis/editarmsUbigeo.html",
		controller : "ctrlListamsUbigeo"
	})
	.when("/nuevo/:stipo", {
		templateUrl : "adminis/editarmsUbigeo.html",
		controller : "ctrlListamsUbigeo"
	})
	.otherwise({
		templateUrl : "adminis/vermsUbigeo.html",
		controller : "ctrlListamsUbigeo"  
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

myapp.controller('ctrlListamsUbigeo', ['$mdEditDialog', '$scope', '$timeout', '$http', '$mdDialog','$location','$routeParams', '$mdPanel',  function ($mdEditDialog, $scope, $timeout, $http, $mdDialog, $location, $routeParams, $mdPanel) {
	'use strict';

	$scope.limitOptions = [100, 500, 1000, 5000];
	$scope.query = {
			order: 'id',
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
		$scope.loadmsUbigeos();
	};

	$scope.logItem = function (item) {
		console.log(item.name, 'was selected');
	};

	$scope.logPagination = function (page, limit) {
		console.log('page: ', page);
		console.log('limit: ', limit);
		$scope.loadmsUbigeos();
	};
	$scope.creamsUbigeo = false;
	// ///////////////////////////////////////////
	$scope.datos = [];
	$scope.total = 0;

	$scope.loadmsUbigeos = function () {
		//$scope.promise = $timeout(function () {
		var surl = $scope.getURL();	    
		$scope.promise = $http.get(surl).then(function(res){
			$scope.datos = res.data.data;
			if(res.data.contador>0)
				$scope.total = res.data.contador;
			var tiempoenBD = res.data.tiempoenBD;
			var tiempoenproceso = res.data.tiempoenproceso;
			$scope.creamsUbigeo = res.data.creamodifica;
			console.log("data " +$scope.datos.length+" DE "+ $scope.total);
			console.log("Tiempo respuesta BD msUbigeo " +tiempoenBD+" Tiempo en Paginar "+tiempoenproceso);
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
						.title('Lista de Provincia')
						.textContent(dato)
						.ariaLabel('ERROR')
						.ok('OK')
				);
			}
		});			 
		//}, 500);
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
		///FILTRO
		const keys = Object.keys($scope.filtro);
		//console.log('Filtro Keys '+keys);
		var filtroparametro = "";
		Object.keys($scope.filtro).forEach(key => {
			//console.log(key);
			const valor = $scope.filtro[key];
			//console.log('Filtro Key '+key+' Valor '+valor);
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
		return listamsUbigeoUrl+$scope.getURLParametros();
	}

	$scope.editmsUbigeo = function () {
		$scope.nuevo = true;
		$scope.tipo = 0;
		var id = $routeParams.id;
		if(id){
			$scope.cargarmsUbigeo(id);
		}
		
		///CARGAR COMPLEMENTOS 
//		$scope.loadListaMsUbigeoCodDpto();//SELECT
//		$scope.loadListaMsUbigeoCodProv();//SELECT
		$scope.loadlistaCoddptos();
		var stipo = $routeParams.stipo;
		if($scope.isString(stipo)){
			$scope.msUbigeoModelo.tipo = Number(stipo);
			if($scope.isNumber($scope.msUbigeoModelo.tipo)){
				if($scope.msUbigeoModelo.tipo>2){
					$scope.msUbigeoModelo.tipoTxt="Distrito";
				}else if($scope.msUbigeoModelo.tipo>1){
					$scope.msUbigeoModelo.tipoTxt="Provincia";
				}else if($scope.msUbigeoModelo.tipo>0){
					$scope.msUbigeoModelo.tipoTxt="Departamento";
				}
			}
		}
	};

	$scope.filtro ={
			idTxt: null,
			codDptoTxt: null,
			codProvTxt: null,
			codDistrTxt: null,
			fechaCrea: null,
			fechaModif: null,
			estadoTxt: null,
			estado: null
	}; 

	$scope.seteestado = function(eestado) {
		if($scope.filtro.estado === eestado){
			$scope.filtro.estado = null;
		}else{
			$scope.filtro.estado = eestado;
		}
		$scope.loadmsUbigeos();
	};

	$scope.refrescarvista = function(ev){
		if(typeof(ev)=='undefined' || ev==null){

		}else{
			var keyCode = ev.which || ev.keyCode;
			if (keyCode === 13) {
				$scope.loadmsUbigeos();
			}else if (keyCode === 1) {
				$scope.loadmsUbigeos();
			}
		}
	};

	$scope.msUbigeoModelo = {
			id : {				
				codDpto: null,
				codProv: null,
				codDistr: null
			},
			codDpto: null,
			codProv: null,
			codDistr: null,
			fechaCrea: new Date(),
			fechaModif: new Date(),
			estado: null,
			descripcion: null,
			idubigeo: null,
			// ADICIONALES
			idTxt: null,
			codDptoTxt: null,
			codProvTxt: null,
			codDistrTxt: null,
			tipo: null,
			tipoTxt: null,
			estadoTxt: null,
			editopcion: 1
	};

	$scope.clearmsUbigeo = function(){
		$scope.msUbigeoModelo.id = null;
		$scope.msUbigeoModelo.codDpto = null;
		$scope.msUbigeoModelo.codProv = null;
		$scope.msUbigeoModelo.codDistr = null;
		$scope.msUbigeoModelo.fechaCrea = new Date();$scope.msUbigeoModelo.fechaModif = new Date();$scope.msUbigeoModelo.estado = null;
		$scope.msUbigeoModelo.descripcion = null;
		$scope.msUbigeoModelo.idubigeo = null;

		// ADICIONALES
		$scope.msUbigeoModelo.idTxt = null;
		$scope.msUbigeoModelo.codDptoTxt = null;
		$scope.msUbigeoModelo.codProvTxt = null;
		$scope.msUbigeoModelo.codDistrTxt = null;
		$scope.msUbigeoModelo.tipo = null;
		$scope.msUbigeoModelo.tipoTxt = null;
		$scope.msUbigeoModelo.estadoTxt = null;
		$scope.msUbigeoModelo.editopcion = 1;
	} 

	$scope.setMsUbigeoModelo = function(msUbigeoBk) {
		$scope.msUbigeoModelo.id = msUbigeoBk.id;
		$scope.msUbigeoModelo.codDpto = msUbigeoBk.codDpto;
		$scope.msUbigeoModelo.codProv = msUbigeoBk.codProv;
		$scope.msUbigeoModelo.codDistr = msUbigeoBk.codDistr;
		$scope.msUbigeoModelo.fechaCrea = msUbigeoBk.fechaCrea;
		if(!$scope.isNull($scope.msUbigeoModelo.fechaCrea) && !isNaN($scope.msUbigeoModelo.fechaCrea)){
			$scope.msUbigeoModelo.fechaCrea = new Date($scope.msUbigeoModelo.fechaCrea);
		}
		$scope.msUbigeoModelo.fechaModif = msUbigeoBk.fechaModif;
		if(!$scope.isNull($scope.msUbigeoModelo.fechaModif) && !isNaN($scope.msUbigeoModelo.fechaModif)){
			$scope.msUbigeoModelo.fechaModif = new Date($scope.msUbigeoModelo.fechaModif);
		}
		$scope.msUbigeoModelo.estado = msUbigeoBk.estado;
		$scope.msUbigeoModelo.descripcion = msUbigeoBk.descripcion;
		$scope.msUbigeoModelo.idubigeo = msUbigeoBk.idubigeo;

		// ADICIONALES

		$scope.msUbigeoModelo.idTxt = msUbigeoBk.idTxt;
		$scope.msUbigeoModelo.codDptoTxt = msUbigeoBk.codDptoTxt;
		$scope.msUbigeoModelo.codProvTxt = msUbigeoBk.codProvTxt;
		$scope.msUbigeoModelo.codDistrTxt = msUbigeoBk.codDistrTxt;
		$scope.msUbigeoModelo.tipo = msUbigeoBk.tipo;
		$scope.msUbigeoModelo.tipoTxt = msUbigeoBk.tipoTxt;
		$scope.msUbigeoModelo.estadoTxt = msUbigeoBk.estadoTxt;
		
		$scope.msUbigeoModelo.editopcion = msUbigeoBk.msUbigeoACL.editopcion;
	}
	// ////////////////////////////////////////////////
	$scope.editarMsUbigeo = function(ev, msUbigeoBk) {		  
		$scope.setMsUbigeoModelo(msUbigeoBk);		  
		$location.url('/editar/' + msUbigeoBk.idTxt);
		$scope.nuevo = false;
	}

	$scope.nuevoMsUbigeo = function(tipo) {
		$scope.clearmsUbigeo();
		$location.url('/nuevo/'+tipo);
		$scope.nuevo = true;		
	}

	$scope.cancelarMsUbigeo = function() {
		$scope.clearmsUbigeo();
		$location.url('/');
	}

	$scope.salvarMsUbigeo = function(ev){		
		ev.target.disabled = true;
		var datainsert = angular.toJson($scope.msUbigeoModelo);
		console.log("datainsert = "+datainsert);	
		$http.post(insertmsUbigeoUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
			var dato = res.data;

//			$scope.datos.push(dato); 
			$scope.total = $scope.datos.length;

			$scope.setMsUbigeoModelo(dato);

			$mdDialog.show(
					$mdDialog.alert()
					.parent(angular.element(document.body))
					.clickOutsideToClose(true)
					.title('Guardar Provincia')
					.textContent("distrito) resgistrado en el sistema Provincia se guardó correctamente.")
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
						.title('Guardar Provincia')
						.textContent(dato)
						.ariaLabel('ERROR')
						.ok('OK')
						.targetEvent(ev)
				);
			}
		});		

		ev.target.disabled = false;
	};

	$scope.eliminarmsUbigeo = function(ev,msUbigeoBk){		
		ev.target.disabled = true;
		$scope.setMsUbigeoModelo(msUbigeoBk);
		var datainsert = angular.toJson($scope.msUbigeoModelo);
		console.log("Eliminar = "+datainsert);	
		$http.post(eliminarmsUbigeoUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
			var dato = res.data;
			var instrumentos = $scope.datos;
			var index = $scope.datos.findIndex(obj => obj.id === dato.id);
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
						.title('Eliminar Provincia')
						.textContent(dato)
						.ariaLabel('ERROR')
						.ok('OK')
						.targetEvent(ev)
				);
			}
		});			        			        	
		ev.target.disabled = false;
	};

	$scope.activarmsUbigeo = function(ev,msUbigeoBk){		
		ev.target.disabled = true;
		$scope.setMsUbigeoModelo(msUbigeoBk);
		var datainsert = angular.toJson($scope.msUbigeoModelo);
		console.log("Activar = "+datainsert);	
		$http.post(activarmsUbigeoUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
			var dato = res.data;
			var instrumentos = $scope.datos;
			var index = $scope.datos.findIndex(obj => obj.id === dato.id);
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
						.title('Activar Provincia')
						.textContent(dato)
						.ariaLabel('ERROR')
						.ok('OK')
						.targetEvent(ev)
				);
			}
		});			        			        	
		ev.target.disabled = false;
	};

	$scope.eliminarListamsUbigeo = function(ev){		
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
				listaids.push($scope.selected[i].id);
			}
		} 

		var datainsert = angular.toJson(listaids);
		console.log("Elimiar = "+datainsert);	
		$http.post(eliminarListamsUbigeoUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
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
						.title('Eliminar Provincia')
						.textContent(dato)
						.ariaLabel('ERROR')
						.ok('OK')
						.targetEvent(ev)
				);
			}
		});			        			        	
		ev.target.disabled = false;
	};	

	$scope.cargarmsUbigeo = function(id){		
		var surl = editarmsUbigeoUrl+id;
		$http.get(surl).then(function(res){
			var dato = res.data;
			$scope.setMsUbigeoModelo(dato);
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
						.title('Cargar Provincia')
						.textContent(dato)
						.ariaLabel('ERROR')
						.ok('OK')
				);
			}			           
		});			        			        	
	};

	$scope.showConfirm = function(ev, msUbigeoBk) {
		var confirm = $mdDialog.confirm()
		.title('Activar Provincia')
		.textContent('Esta usted seguro de activar el registro?')
		.ariaLabel('Lucky day')
		.targetEvent(ev)
		.ok('Si')
		.cancel('No');

		$mdDialog.show(confirm).then(function () {
			$scope.status = 'SI';
			$scope.eliminarmsUbigeo(ev, msUbigeoBk);
		}, function () {
			$scope.status = 'NO';
		});
	};

	$scope.showConfirmActivar = function(ev, msUbigeoBk) {
		var confirm = $mdDialog.confirm()
		.title('Activar Provincia')
		.textContent('Esta usted seguro de activar el registro?')
		.ariaLabel('Lucky day')
		.targetEvent(ev)
		.ok('Si')
		.cancel('No');

		$mdDialog.show(confirm).then(function () {
			$scope.status = 'SI';
			$scope.activarmsUbigeo(ev, msUbigeoBk);
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
		.title('Eliminar Provincia')
		.textContent('Esta usted seguro de eliminar los '+tamanio+' registros seleccionados?')
		.ariaLabel('Lucky day')
		.targetEvent(ev)
		.ok('Si')
		.cancel('No');

		$mdDialog.show(confirm).then(function () {
			$scope.status = 'SI';
			$scope.eliminarListamsUbigeo(ev);
		}, function () {
			$scope.status = 'NO';
		});
	};		  
//	/ADICIONALES
//	SELECT INI
//	$scope.listaMsUbigeoCodDpto=[];
//	$scope.loadListaMsUbigeoCodDpto=function(){
//		$http.get(listaMsUbigeocodDptoCodDptoUrl).then(function(res){
//			$scope.listaMsUbigeoCodDpto = res.data; 
//		},
//		function error(errResponse) {
//			var dato;
//			if(errResponse && errResponse.data){
//				console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
//				dato = errResponse.data;
//			}
//			if(errResponse.message){ 
//				console.log("Message " + errResponse.message);
//				dato = errResponse.message;
//			}
//		});
//	};
//	$scope.changeCodDpto=function(){
//		///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
//	}
//	$scope.$watch('msUbigeoModelo.codDpto', function (newValue, oldValue) {
//		console.log('msUbigeoModelo.codDpto ' + newValue+' -- '+oldValue);
//		//CARGAR DATOS DEL SIGUIENTE SELECT
////		if($scope.isArray($scope.listaMsUbigeoCodDpto)){
////		var obj = $scope.listaMsUbigeoCodDpto.find(o => o.id === newValue);
////		if($scope.isObject(obj)){
////		$scope.msUbigeoModelo.codDptoTxt = obj.valor;
////		}
////		}
//	});
////	SELECT FIN                
////	SELECT INI
//	$scope.listaMsUbigeoCodProv=[];
//	$scope.loadListaMsUbigeoCodProv=function(){
//		$http.get(listaMsUbigeocodProvCodProvUrl).then(function(res){
//			$scope.listaMsUbigeoCodProv = res.data; 
//		},
//		function error(errResponse) {
//			var dato;
//			if(errResponse && errResponse.data){
//				console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
//				dato = errResponse.data;
//			}
//			if(errResponse.message){ 
//				console.log("Message " + errResponse.message);
//				dato = errResponse.message;
//			}
//		});
//	};
//	$scope.changeCodProv=function(){
//		///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
//	}
//	$scope.$watch('msUbigeoModelo.codProv', function (newValue, oldValue) {
//		console.log('msUbigeoModelo.codProv ' + newValue+' -- '+oldValue);
//		//CARGAR DATOS DEL SIGUIENTE SELECT
////		if($scope.isArray($scope.listaMsUbigeoCodProv)){
////		var obj = $scope.listaMsUbigeoCodProv.find(o => o.id === newValue);
////		if($scope.isObject(obj)){
////		$scope.msUbigeoModelo.codProvTxt = obj.valor;
////		}
////		}
//	});
//	SELECT FIN                

	$scope.listaMsUbigeoCoddpto=[];
	$scope.loadlistaCoddptos=function(){
		$http.get(listaCoddptosUrl).then(function(res){
			$scope.listaMsUbigeoCoddpto = res.data; 
		},
		function error(errResponse) {
			console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		});
	};
	
	$scope.listaMsUbigeoCodprov=[];
	$scope.loadlistaCodprov=function(){
		if($scope.msUbigeoModelo.codDpto){
		var surl = listaCodprovUrl+$scope.msUbigeoModelo.codDpto;
		$http.get(surl).then(function(res){
			$scope.listaMsUbigeoCodprov = res.data; 
		},
		function error(errResponse) {
			console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		});
		}else{
			$scope.listaMsUbigeoCodprov=[];
		}
	};
		
	$scope.listaMsUbigeoCoddist=[];
	$scope.loadlistaCoddist=function(){
		if($scope.msUbigeoModelo.codDpto &&
		$scope.msUbigeoModelo.codProv){
			var surl = listaCoddistUrl+$scope.msUbigeoModelo.codDpto+'/'+$scope.msUbigeoModelo.codProv;
		$http.get(surl).then(function(res){
			$scope.listaMsUbigeoCoddist = res.data; 
		},
		function error(errResponse) {
			console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		});
		}else{
			$scope.listaMsUbigeoCoddist=[];
		}
	};
	
	$scope.$watch('msUbigeoModelo.codDpto', function (newValue, oldValue) {
		console.log('msUbigeoModelo.codDpto ' + newValue+' -- '+oldValue);
		$scope.loadlistaCodprov();
	});
	
	$scope.$watch('msUbigeoModelo.codProv', function (newValue, oldValue) {
		console.log('msUbigeoModelo.codProv ' + newValue+' -- '+oldValue);
		$scope.loadlistaCoddist();
	});
	
	$scope.changeCoddpto=function(){
		$scope.msUbigeoModelo.codProv = null;
		$scope.msUbigeoModelo.codDistr = null;
	}
	
	$scope.changeCodprov=function(){
		$scope.msUbigeoModelo.codDistr = null;
	}

//	DESCARGAR
	$scope.descargar = function(){
		return descargarUrl+$scope.getURLParametros();
	}
//	/FIN ADICIONALES			 			 
	// ////////////////////////////////////////////////////////////////

	$scope.cancel = function() {
		$mdDialog.cancel();
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

	$scope.nuevo = ($scope.isNumber($scope.msUbigeoModelo.id) && $scope.msUbigeoModelo.id > 0);
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

	$scope.filtroMsUbigeo = function(toma){				
		const keys = Object.keys($scope.filtro);
		console.log('Filtro Keys '+keys);
		Object.keys($scope.filtro).forEach(key => {
			console.log(key);
			const valor = $scope.filtro[key];
			//console.log('Filtro Key '+key+' Valor '+valor);
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
