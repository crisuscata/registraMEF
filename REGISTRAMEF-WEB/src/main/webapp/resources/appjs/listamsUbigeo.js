var contexto = window.location.pathname.substring(0,window.location.pathname.indexOf('/',2));
var pglogoff = window.location.origin+contexto+'/logoff.htm';
var principalUrl = window.location.origin+contexto+'/index.htm';
var listamsUbigeoUrl = contexto+"/rs/ctrlmsUbigeo/listamsUbigeo";
var insertmsUbigeoUrl = contexto+"/rs/ctrlmsUbigeo/salvarmsUbigeo";
var eliminarmsUbigeoUrl = contexto+"/rs/ctrlmsUbigeo/eliminarmsUbigeo";
var activarmsUbigeoUrl = contexto+"/rs/ctrlmsUbigeo/activarmsUbigeo";
var eliminarListamsUbigeoUrl = contexto+"/rs/ctrlmsUbigeo/eliminarListamsUbigeo";
var editarmsUbigeoUrl = contexto+"/rs/ctrlmsUbigeo/editarmsUbigeo/";
// var listaMsUbigeocodDptoCodDptoUrl =
// contexto+"/rs/ctrlmsUbigeo/listaMsUbigeoCodDptoCodDpto";
// var listaMsUbigeocodProvCodProvUrl =
// contexto+"/rs/ctrlmsUbigeo/listaMsUbigeoCodProvCodProv";
// PURIBE 10012024 - INICIO
var listaMsUbigeocodDptoCodDptoUrl = contexto+"/rs/ctrlmsUbigeo/listaCoddptos";
var listaMsUbigeocodProvCodProvUrl = contexto+"/rs/ctrlmsUbigeo/listaCodprov";
var listaCoddistUrl = contexto+"/rs/ctrlmsUbigeo/listaCoddist/";
var descargarUrl = contexto+"/rs/ctrlmsUbigeo/descargar/";
// PURIBE 10012024 - FIN

// /URLs CARGA DE ARCHIVOS
var insertDocUrl = contexto+"/rs/ctrlmsUbigeo/insertarchivo";
// /FIN URLs CARGA DE ARCHIVOS

var listaCoddptosUrl = contexto+"/rs/ctrlmsUbigeo/listaCoddptos";
var listaCodprovUrl = contexto+"/rs/ctrlmsUbigeo/listaCodprov/";
var listaCoddistUrl = contexto+"/rs/ctrlmsUbigeo/listaCoddist/";


/**
 * 
 */
myapp = angular.module('MyApp');

// PURIBE 10012024 - INICIO
myapp.config(function($routeProvider) {
	  $routeProvider
	  .when("/editar/:codDpto/:codProv/:codDistr", {
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
 // PURIBE 10012024 - FIN

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

// return date ? moment(date).format('DD/MM/YYYY') : '';
	};
	$mdDateLocaleProvider.parseDate = function (dateString) {
// var m = moment(dateString, 'DD/MM/YYYY', true);
		var parts = dateString.split("/");
		var dt = new Date(parseInt(parts[2], 10),
				parseInt(parts[1], 10) - 1,
				parseInt(parts[0], 10));
		return dt ? dt:new Date(NaN);
// return m.isValid() ? m.toDate() : new Date(NaN);
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
	/* PURIBE 20012024 - INICIO */
	$scope.estado = 0;
	$scope.deshabilitarBoton = false;
	$scope.deshabilitarCombos = false;
	/* PURIBE 20012024 - FIN */

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
	// PURIBE 10012024 - INICIO
	$scope.tipo = 0;
	$scope.stipo = 0;
	 // PURIBE 10012024 - FIN

	$scope.loadmsUbigeos = function () {
		// $scope.promise = $timeout(function () {
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
		return listamsUbigeoUrl+$scope.getURLParametros();
	}

	// PURIBE 10012024 - INICIO
	//PURIBE 15012024 - INICIO
	$scope.editmsUbigeo = function () {
	    $scope.nuevo = true;
		var stipos = $routeParams.stipo ? $routeParams.stipo : 0;
		
		var codDpto = $routeParams.codDpto;
		var codProv = $routeParams.codProv;
		var codDistr = $routeParams.codDistr;


		if (codDpto == null && codDpto == undefined) {
		
			codDpto =0;
			console.log("codDpto es nulo o indefinido");
		} 
		
		if (codProv == null && codProv == undefined) {
		
			codProv =0;
			console.log("codProv es nulo o indefinido");
		} 
			if (codDistr == null && codDistr == undefined) {
				codDistr =0;
				console.log("codDistr es nulo o indefinido");
			} 

//PURIBE 16012024 - INICIO--
		if (stipos > 0)
		{	
			if  (stipos == 1){
				$scope.nombreDPTO = 'Departamento';
				$scope.tipo=1;
				$scope.msUbigeoModelo.id.codDpto = 0;
				
			}else if(stipos == 2)
				{
					$scope.nombreDPTO = 'Provincia';
					$scope.tipo=2;
					$scope.loadListaMsUbigeoCodDpto();	
					$scope.msUbigeoModelo.id.codProv = 0;
				}
			
				else if (stipos == 3)
				{
					$scope.nombreDPTO = 'Distrito';
					$scope.tipo=3;
					$scope.loadListaMsUbigeoCodDpto();
				//	$scope.loadListaMsUbigeoCodProv(codProv);
					$scope.msUbigeoModelo.id.codDistr= 0;
				}
						
			//PURIBE 16012024 - FIN--
		}else if (stipos==0)
		{
			$scope.nombreDPTO = 'Ubigeo';
		$scope.stipo=1;	
		$scope.nuevo = false;
	
		$scope.deshabilitarCombos= true;
		$scope.loadListaMsUbigeoCodDpto();//SELECT
		$scope.loadListaMsUbigeoCodProv(codDpto);//SELECT
		$scope.loadListaMsUbigeoDistr(codDpto,codProv);
		$scope.cargarmsUbigeo(codDpto+"-"+codProv+"-"+codDistr);
		}
	    //PURIBE 20012024 - FIN--
	  //  if(id){
	    //	$scope.cargarmsUbigeo(id);
	    //}
	   ///CARGAR COMPLEMENTOS 
	
			
	  };
		   //PURIBE 15012024 - FIN
		    // PURIBE 10012024 - FIN

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

	//PURIBE 20012024 - INICIO--
	  $scope.msUbigeoModelo = {
		id: $scope.msUbigeoId,
			descripcion: null,
			codDpto: null,
			codProv: null,
			idubigeo: null,
			coddistTxt:null,
			coddptoTxt:null,
			codprovTxt:null,
			estado:null,
                      // ADICIONALES
	                
		    editopcion: 1
		};
	  
		//PURIBE 10012024 - INICIO--
	  $scope.clearmsUbigeo = function(){
		    $scope.msUbigeoModelo.id.codDpto = null;
			$scope.msUbigeoModelo.id.codProv = null;
			$scope.msUbigeoModelo.id.codDistr = null;
			$scope.msUbigeoModelo.coddistTxt = null;
		    $scope.msUbigeoModelo.coddptoTxt= null;
		    $scope.msUbigeoModelo.codprovTxt = null;
		    $scope.msUbigeoModelo.descripcion = null;
		    $scope.msUbigeoModelo.codDpto = null;
		    $scope.msUbigeoModelo.codProv = null;
		    $scope.msUbigeoModelo.idubigeo = null;
			$scope.msUbigeoModelo.estado=null;
		    
                  // ADICIONALES
	            
		    $scope.msUbigeoModelo.editopcion = 1;
		
	 } 
	 	/* PURIBE 20012024 - INICIO*/
	 
	  /* PURIBE 20012024 - INICIO*/
	  $scope.setMsUbigeoModelo = function(msUbigeoBk) {
		$scope.msUbigeoModelo.coddistTxt=msUbigeoBk.coddistTxt;
		$scope.msUbigeoModelo.coddptoTxt=msUbigeoBk.coddptoTxt;
		$scope.msUbigeoModelo.codprovTxt=msUbigeoBk.codprovTxt;
		  $scope.msUbigeoModelo.id = msUbigeoBk.id;
		  $scope.msUbigeoModelo.id.codDpto = msUbigeoBk.id.codDpto;
		  $scope.msUbigeoModelo.id.codProv = msUbigeoBk.id.codProv;
		  $scope.msUbigeoModelo.id.codDistr = msUbigeoBk.id.codDistr;
		  $scope.msUbigeoModelo.codDpto = msUbigeoBk.id.codDpto;
		  $scope.msUbigeoModelo.codProv = msUbigeoBk.id.codProv;
			$scope.msUbigeoModelo.descripcion = msUbigeoBk.descripcion;
			$scope.msUbigeoModelo.idubigeo = msUbigeoBk.idubigeo;
		
			if (msUbigeoBk.estado==0){
				$scope.msUbigeoModelo.estado = false;
				}
				else{
					$scope.msUbigeoModelo.estado = true;
				}
		/* PURIBE 20012024 - FIN*/
		
                        // ADICIONALES
	                
			$scope.msUbigeoModelo.editopcion = msUbigeoBk.msUbigeoACL.editopcion;
		}
		//PURIBE 10012024 - INICIO--
		//PURIBE 20012024 - FIN--
	  // ////////////////////////////////////////////////
	  $scope.editarMsUbigeo = function(ev, msUbigeoBk) {		  
		    $scope.setMsUbigeoModelo(msUbigeoBk);		  
			$location.url('/editar/' + $scope.msUbigeoModelo.codDpto  + '/' + $scope.msUbigeoModelo.codProv + '/' + msUbigeoBk.id.codDistr);
			
			// $location.url('/editar/' +msUbigeoBk.id);
			// $scope.nuevo = false;
		
	  }
	    // PURIBE 10012024 - FIN

	// PURIBE 10012024 - INICIO
	  $scope.nuevoMsUbigeo = function(tipo) {
		
			$location.url('/nuevo/'+tipo);
		
			$scope.nuevo = true;
			$scope.clearmsUbigeo();
				
				

	  }
	  // PURIBE 10012024 - FIN

	$scope.cancelarMsUbigeo = function() {
		$scope.clearmsUbigeo();
		$location.url('/');
	}
	
	/* PURIBE 20012024 - INICIO*/
	$scope.updateModel = function() {
		// Aplicar tu lógica aquí
		$scope.estado = $scope.msUbigeoModelo.estado ? 1 : 0;
	};
		/* PURIBE 20012024 - FIN*/

	$scope.salvarMsUbigeo = function(ev){		
	    ev.target.disabled = true;
			/* PURIBE 20012024 - INICIO*/
	    /* PURIBE 25012024 - INICIO*/
		$scope.estado = $scope.msUbigeoModelo.estado ? 3 : 0;
		$scope.msUbigeoModelo.estado = $scope.estado
		/* PURIBE 25012024 - FIN*/
	/* PURIBE 20012024 - FIN*/
		if ($scope.msUbigeoModelo.descripcion !== null && $scope.msUbigeoModelo.descripcion !== ''
		&& $scope.msUbigeoModelo.id.codDpto ==0 )
		{
			$scope.msUbigeoModelo.codDpto =0;
			$scope.msUbigeoModelo.id.codDpto =0;
			$scope.msUbigeoModelo.id.codProv =0;
			$scope.msUbigeoModelo.id.codDistr =0;
		}
		else if ($scope.msUbigeoModelo.descripcion !== null && $scope.msUbigeoModelo.descripcion !== ''
		&& $scope.msUbigeoModelo.id.codProv ==0)
		{
			$scope.msUbigeoModelo.codDpto =0;
			$scope.msUbigeoModelo.id.codProv =0;
			$scope.msUbigeoModelo.id.codDistr =0;
		}
		else if ($scope.msUbigeoModelo.descripcion !== null && $scope.msUbigeoModelo.descripcion !== ''
		&& $scope.msUbigeoModelo.id.codDistr ==0)
		{
			$scope.msUbigeoModelo.codDpto =0;
			$scope.msUbigeoModelo.id.codDistr =0;
		}

		if (!$scope.nuevo)
		{
			$scope.msUbigeoModelo.codDpto =$scope.msUbigeoModelo.id.codDpto;

		}

	    var datainsert = angular.toJson($scope.msUbigeoModelo);
			console.log("datainsert = "+datainsert);	
    		$http.post(insertmsUbigeoUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
				var dato = res.data;

//				$scope.datos.push(dato); 
				$scope.total = $scope.datos.length;
				
				$scope.setMsUbigeoModelo(dato);
				   //PURIBE 20012024 - INICIO
				 if ($scope.nuevo)
				{
					$scope.deshabilitarBoton = true;
				$mdDialog.show(
				         $mdDialog.alert()
				        .parent(angular.element(document.body))
				        .clickOutsideToClose(true)
				        .title('Guardar ' + $scope.nombreDPTO)
				        .textContent($scope.nombreDPTO+" resgistrado en el sistema  se guardó correctamente.")
				        .ariaLabel('ERROR')
				        .ok('OK')
				        .targetEvent(ev)
				    );
				}
				   //PURIBE 20012024 - FIN
				else if (!$scope.nuevo)
				{
					$mdDialog.show(
						$mdDialog.alert()
					   .parent(angular.element(document.body))
					   .clickOutsideToClose(true)
					   .title('Editar Ubigeo')
					   .textContent("Ubigeo resgistrado en el sistema  se guardó correctamente.")
					   .ariaLabel('ERROR')
					   .ok('OK')
					   .targetEvent(ev)
				   );

				}
				$scope.nuevo = false;
			},
			function error(errResponse) {
	            console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
	            var dato = errResponse.data;
	            if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
	            	$mdDialog.show(
					         $mdDialog.alert()
					        .parent(angular.element(document.body))
					        .clickOutsideToClose(true)
					        .title('Guardar Provincia')
					        .textContent(dato.message)
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
// /ADICIONALES
// SELECT INI
// $scope.listaMsUbigeoCodDpto=[];
// $scope.loadListaMsUbigeoCodDpto=function(){
// $http.get(listaMsUbigeocodDptoCodDptoUrl).then(function(res){
// $scope.listaMsUbigeoCodDpto = res.data;
// },
// function error(errResponse) {
// var dato;
// if(errResponse && errResponse.data){
// console.log("data " + errResponse.data + " status " + errResponse.status + "
// headers " + errResponse.headers + "config " + errResponse.config + "
// statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
// dato = errResponse.data;
// }
// if(errResponse.message){
// console.log("Message " + errResponse.message);
// dato = errResponse.message;
// }
// });
// };
// $scope.changeCodDpto=function(){
// ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
// }
// $scope.$watch('msUbigeoModelo.codDpto', function (newValue, oldValue) {
// console.log('msUbigeoModelo.codDpto ' + newValue+' -- '+oldValue);
// //CARGAR DATOS DEL SIGUIENTE SELECT
// // if($scope.isArray($scope.listaMsUbigeoCodDpto)){
// // var obj = $scope.listaMsUbigeoCodDpto.find(o => o.id === newValue);
// // if($scope.isObject(obj)){
// // $scope.msUbigeoModelo.codDptoTxt = obj.valor;
// // }
// // }
// });
// // SELECT FIN
// // SELECT INI
// $scope.listaMsUbigeoCodProv=[];
// $scope.loadListaMsUbigeoCodProv=function(){
// $http.get(listaMsUbigeocodProvCodProvUrl).then(function(res){
// $scope.listaMsUbigeoCodProv = res.data;
// },
// function error(errResponse) {
// var dato;
// if(errResponse && errResponse.data){
// console.log("data " + errResponse.data + " status " + errResponse.status + "
// headers " + errResponse.headers + "config " + errResponse.config + "
// statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
// dato = errResponse.data;
// }
// if(errResponse.message){
// console.log("Message " + errResponse.message);
// dato = errResponse.message;
// }
// });
// };
// $scope.changeCodProv=function(){
// ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
// }
// $scope.$watch('msUbigeoModelo.codProv', function (newValue, oldValue) {
// console.log('msUbigeoModelo.codProv ' + newValue+' -- '+oldValue);
// //CARGAR DATOS DEL SIGUIENTE SELECT
// // if($scope.isArray($scope.listaMsUbigeoCodProv)){
// // var obj = $scope.listaMsUbigeoCodProv.find(o => o.id === newValue);
// // if($scope.isObject(obj)){
// // $scope.msUbigeoModelo.codProvTxt = obj.valor;
// // }
// // }
// });
// SELECT FIN

	$scope.listaMsUbigeoCoddpto=[];
	$scope.loadlistaCoddptos=function(){
		$http.get(listaCoddptosUrl).then(function(res){
			$scope.listaMsUbigeoCoddpto = res.data; 
		},
		function error(errResponse) {
			console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		});
	};
	
	// PURIBE 10012024 - INICIO--
    $scope.listaMsUbigeoCodProv=[];
$scope.loadListaMsUbigeoCodProv=function(CodDpto){
	var surl = listaMsUbigeocodProvCodProvUrl+ '/'+ CodDpto;
	$http.get(surl).then(function(res){
		$scope.listaMsUbigeoCodProv = res.data; 
	},
	function error(errResponse) {
		console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
	});
};

$scope.listaMsUbigeoCodDistr=[];
$scope.loadListaMsUbigeoDistr=function(CodDpto,CodProv){
	var surl = listaCoddistUrl+ '/'+ CodDpto+ '/'+ CodProv;
	$http.get(surl).then(function(res){
		$scope.listaMsUbigeoCodDistr = res.data; 
	},
	function error(errResponse) {
		console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
	});
};


    $scope.changeCodProv=function(){
		$scope.msUbigeoModelo.id.codDistr = null;
      // /BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
    }
	// PURIBE 10012024 - FIN--
    $scope.$watch('msUbigeoModelo.codProv', function (newValue, oldValue) {
	console.log('msUbigeoModelo.codProv ' + newValue+' -- '+oldValue);
	// CARGAR DATOS DEL SIGUIENTE SELECT
});
	
	$scope.$watch('msUbigeoModelo.codDpto', function (newValue, oldValue) {
		console.log('msUbigeoModelo.codDpto ' + newValue+' -- '+oldValue);
		$scope.loadlistaCodprov();
	});
	
	$scope.$watch('msUbigeoModelo.codProv', function (newValue, oldValue) {
		console.log('msUbigeoModelo.codProv ' + newValue+' -- '+oldValue);
		$scope.loadlistaCoddist();
	});
	
	//PURIBE 20012024 - INICIO--
    $scope.changeCodDpto=function(){
		$scope.msUbigeoModelo.id.codProv = 0;
		$scope.msUbigeoModelo.id.codDistr = 0;

		$scope.loadListaMsUbigeoCodProv($scope.msUbigeoModelo.id.codDpto);
      ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
    }


	$scope.changeCodDistr=function(){
	//	$scope.msUbigeoModelo.id.codDistr = 0;
		  ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
		}
//PURIBE 20012024 - FIN--

    $scope.$watch('msUbigeoModelo.codDpto', function (newValue, oldValue) {
	console.log('msUbigeoModelo.codDpto ' + newValue+' -- '+oldValue);
	// CARGAR DATOS DEL SIGUIENTE SELECT
	// PURIBE 10012024 - FIN --
});
	
// DESCARGAR
	$scope.descargar = function(){
		return descargarUrl+$scope.getURLParametros();
	}
// /FIN ADICIONALES
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

	//PURIBE 10012024 - INICIO
	  //  $scope.nuevo = ($scope.isNumber($scope.msUbigeoModelo.id) && $scope.msUbigeoModelo.id > 0);
		  debugger;
		$scope.edit  = true;
		  //PURIBE 10012024 - FIN--


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
