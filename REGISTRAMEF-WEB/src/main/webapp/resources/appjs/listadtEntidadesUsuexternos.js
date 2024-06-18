var contexto = window.location.pathname.substring(0,window.location.pathname.indexOf('/',2));
var pglogoff = window.location.origin+contexto+'/logoff.htm';
var principalUrl = window.location.origin+contexto+'/index.htm';
var listadtEntidadesUsuexternosUrl = contexto+"/rs/ctrldtEntidadesUsuexternos/listadtEntidadesUsuexternos";
var insertdtEntidadesUsuexternosUrl = contexto+"/rs/ctrldtEntidadesUsuexternos/salvardtEntidadesUsuexternos";
var eliminardtEntidadesUsuexternosUrl = contexto+"/rs/ctrldtEntidadesUsuexternos/eliminardtEntidadesUsuexternos";
var activardtEntidadesUsuexternosUrl = contexto+"/rs/ctrldtEntidadesUsuexternos/activardtEntidadesUsuexternos";
var eliminarListadtEntidadesUsuexternosUrl = contexto+"/rs/ctrldtEntidadesUsuexternos/eliminarListadtEntidadesUsuexternos";
var editardtEntidadesUsuexternosUrl = contexto+"/rs/ctrldtEntidadesUsuexternos/editardtEntidadesUsuexternos/";
var listaDtUsuarioExternoidUsuexternoUrl = contexto+"/rs/ctrldtEntidadesUsuexternos/listaDtUsuarioExternoIdUsuexterno/";
var listaDtUsuarioExternoXNombreUrl = contexto+"/rs/ctrldtEntidadesUsuexternos/listaDtUsuarioExternoXNombre/";

var descargarUrl = contexto+"/rs/ctrldtEntidadesUsuexternos/descargar/";

///URLs CARGA DE ARCHIVOS
var insertDocUrl = contexto+"/rs/ctrldtEntidadesUsuexternos/insertarchivo";
///FIN URLs CARGA DE ARCHIVOS

var descargarvistaUrl = contexto+"/rs/ctrldtEntidadesUsuexternos/descargarvista";

/**
 * 
 */
myapp = angular.module('MyApp');

myapp.config(function($routeProvider) {
	  $routeProvider
	  .when("/editar/:idUsuextEnti", {
		  templateUrl : "adminis/editardtEntidadesUsuexternos.html",
		  controller : "ctrlListadtEntidadesUsuexternos"
	  })
	  .when("/nuevo", {
		  templateUrl : "adminis/editardtEntidadesUsuexternos.html",
		  controller : "ctrlListadtEntidadesUsuexternos"
	  })
	  .otherwise({
		  templateUrl : "adminis/verdtEntidadesUsuexternos.html",
		  controller : "ctrlListadtEntidadesUsuexternos"  
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

myapp.controller('ctrlListadtEntidadesUsuexternos', ['$mdEditDialog', '$scope', '$timeout', '$http', '$mdDialog','$location','$routeParams', '$mdPanel',  function ($mdEditDialog, $scope, $timeout, $http, $mdDialog, $location, $routeParams, $mdPanel) {
	'use strict';
	 
	 $scope.limitOptions = [100, 500, 1000, 5000];
	 $scope.query = {
			    order: 'idUsuextEnti',
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
	  $scope.loaddtEntidadesUsuexternoss();
	 };
	 
	 $scope.logItem = function (item) {
	  console.log(item.name, 'was selected');
	 };
	 
	 $scope.logPagination = function (page, limit) {
	  console.log('page: ', page);
	  console.log('limit: ', limit);
	  $scope.loaddtEntidadesUsuexternoss();
         };
     $scope.creadtEntidadesUsuexternos = false;
    // ///////////////////////////////////////////
	$scope.datos = [];
	$scope.total = 0;

	$scope.loaddtEntidadesUsuexternoss = function () {
	    //$scope.promise = $timeout(function () {
	    	var surl = $scope.getURL();	    
	    	$scope.promise = $http.get(surl).then(function(res){
	    		 $scope.datos = res.data.data;
	    		 if(res.data.contador>0)
	    		 $scope.total = res.data.contador;
	    		 var tiempoenBD = res.data.tiempoenBD;
	    		 var tiempoenproceso = res.data.tiempoenproceso;
	    		 $scope.creadtEntidadesUsuexternos = res.data.creamodifica;
	    		 console.log("data " +$scope.datos.length+" DE "+ $scope.total);
	    		 console.log("Tiempo respuesta BD dtEntidadesUsuexternos " +tiempoenBD+" Tiempo en Paginar "+tiempoenproceso);
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
						        .title('Lista de Entidad Del Usuario Externo')
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
		  return listadtEntidadesUsuexternosUrl+$scope.getURLParametros();
	  }
	  
	  $scope.editdtEntidadesUsuexternos = function () {
		    $scope.nuevo = true;
		    var idUsuextEnti = $routeParams.idUsuextEnti;
		    if(idUsuextEnti){
		    	$scope.cargardtEntidadesUsuexternos(idUsuextEnti);
		    }
		   ///CARGAR COMPLEMENTOS 
		  };
	  
	  $scope.filtro ={
  idEntidad: null,
  idUsuexterno: null,
  
         estado: null
		}; 
	  
	  $scope.seteestado = function(eestado) {
			if($scope.filtro.estado === eestado){
				$scope.filtro.estado = null;
			}else{
				$scope.filtro.estado = eestado;
			}
			$scope.loaddtEntidadesUsuexternoss();
		};
	  
         $scope.refrescarvista = function(ev){
		  if(typeof(ev)=='undefined' || ev==null){
	          
          }else{
			 var keyCode = ev.which || ev.keyCode;
			    if (keyCode === 13) {
			    	$scope.loaddtEntidadesUsuexternoss();
			    }else if (keyCode === 1) {
			    	$scope.loaddtEntidadesUsuexternoss();
			    }
          }
		};

	  $scope.dtEntidadesUsuexternosModelo = {
			idUsuextEnti : null,
			idEntidad: null,
			nombre: null,
                      idUsuexterno: null,
                        // ADICIONALES
	                idEntidadTxt: null,
idUsuexternoTxt: null,
estadoTxt: null,

		    editopcion: 1
		};
	  
	  $scope.cleardtEntidadesUsuexternos = function(){
		    $scope.dtEntidadesUsuexternosModelo.idUsuextEnti = null;
		    $scope.dtEntidadesUsuexternosModelo.idEntidad = null;
		    $scope.dtEntidadesUsuexternosModelo.idUsuexterno = null;$scope.dtEntidadesUsuexternosModelo.nombre = null;
                    // ADICIONALES
	            $scope.dtEntidadesUsuexternosModelo.idEntidadTxt = null;
$scope.dtEntidadesUsuexternosModelo.idUsuexternoTxt = null;
$scope.dtEntidadesUsuexternosModelo.estadoTxt = null;

		    $scope.dtEntidadesUsuexternosModelo.editopcion = 1;
	 } 
	 
	  $scope.setDtEntidadesUsuexternosModelo = function(dtEntidadesUsuexternosBk) {
		  $scope.dtEntidadesUsuexternosModelo.idUsuextEnti = dtEntidadesUsuexternosBk.idUsuextEnti;
			$scope.dtEntidadesUsuexternosModelo.idEntidad = dtEntidadesUsuexternosBk.idEntidad;
			$scope.dtEntidadesUsuexternosModelo.idUsuexterno = dtEntidadesUsuexternosBk.idUsuexterno; $scope.dtEntidadesUsuexternosModelo.nombre = dtEntidadesUsuexternosBk.nombre;
                        // ADICIONALES
	                $scope.dtEntidadesUsuexternosModelo.idEntidadTxt = dtEntidadesUsuexternosBk.idEntidadTxt;
$scope.dtEntidadesUsuexternosModelo.idUsuexternoTxt = dtEntidadesUsuexternosBk.idUsuexternoTxt;
$scope.dtEntidadesUsuexternosModelo.estadoTxt = dtEntidadesUsuexternosBk.estadoTxt;

			$scope.dtEntidadesUsuexternosModelo.editopcion = dtEntidadesUsuexternosBk.dtEntidadesUsuexternosACL.editopcion;
		}
	  // ////////////////////////////////////////////////
	  $scope.editarDtEntidadesUsuexternos = function(ev, dtEntidadesUsuexternosBk) {		  
		    $scope.setDtEntidadesUsuexternosModelo(dtEntidadesUsuexternosBk);		  
			$location.url('/editar/' + $scope.dtEntidadesUsuexternosModelo.idUsuextEnti);
			$scope.nuevo = false;
	  }
	  
	  $scope.nuevoDtEntidadesUsuexternos = function() {
		    $scope.cleardtEntidadesUsuexternos();
			$location.url('/nuevo');
			$scope.nuevo = true;
	  }
	  	  
	  $scope.cancelarDtEntidadesUsuexternos = function() {
		    $scope.cleardtEntidadesUsuexternos();
		    $location.url('/');
	  }
	  			  
	  $scope.salvarDtEntidadesUsuexternos = function(ev){		
				    ev.target.disabled = true;
				    var datainsert = angular.toJson($scope.dtEntidadesUsuexternosModelo);
		 			console.log("datainsert = "+datainsert);	
		        		$http.post(insertdtEntidadesUsuexternosUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
							var dato = res.data;

//		    				$scope.datos.push(dato); 
		    				$scope.total = $scope.datos.length;
		    				
		    				$scope.setDtEntidadesUsuexternosModelo(dato);
		    				
		    				$mdDialog.show(
							         $mdDialog.alert()
							        .parent(angular.element(document.body))
							        .clickOutsideToClose(true)
							        .title('Guardar Entidad Del Usuario Externo')
							        .textContent("del Entidad Del Usuario Externo se guardó correctamente.")
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
								        .title('Guardar Entidad Del Usuario Externo')
								        .textContent(dato)
								        .ariaLabel('ERROR')
								        .ok('OK')
								        .targetEvent(ev)
								    );
				            }
				        });		
		        			        	
		        	ev.target.disabled = false;
			 };
			 
	   $scope.eliminardtEntidadesUsuexternos = function(ev,dtEntidadesUsuexternosBk){		
				    ev.target.disabled = true;
				    $scope.setDtEntidadesUsuexternosModelo(dtEntidadesUsuexternosBk);
				    var datainsert = angular.toJson($scope.dtEntidadesUsuexternosModelo);
		 			console.log("Eliminar = "+datainsert);	
	        		$http.post(eliminardtEntidadesUsuexternosUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
						var dato = res.data;
						var instrumentos = $scope.datos;
				        var index = $scope.datos.findIndex(obj => obj.idUsuextEnti === dato.idUsuextEnti);
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
					        .title('Eliminar Entidad Del Usuario Externo')
					        .textContent(dato)
					        .ariaLabel('ERROR')
					        .ok('OK')
					        .targetEvent(ev)
						   );
			            }
			        });			        			        	
		        	ev.target.disabled = false;
			 };

            $scope.activardtEntidadesUsuexternos = function(ev,dtEntidadesUsuexternosBk){		
				    ev.target.disabled = true;
				    $scope.setDtEntidadesUsuexternosModelo(dtEntidadesUsuexternosBk);
				    var datainsert = angular.toJson($scope.dtEntidadesUsuexternosModelo);
		 			console.log("Activar = "+datainsert);	
	        		$http.post(activardtEntidadesUsuexternosUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
						var dato = res.data;
						var instrumentos = $scope.datos;
				        var index = $scope.datos.findIndex(obj => obj.idUsuextEnti === dato.idUsuextEnti);
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
					        .title('Activar Entidad Del Usuario Externo')
					        .textContent(dato)
					        .ariaLabel('ERROR')
					        .ok('OK')
					        .targetEvent(ev)
						   );
			            }
			        });			        			        	
		        	ev.target.disabled = false;
			 };

            $scope.eliminarListadtEntidadesUsuexternos = function(ev){		
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
				             listaids.push($scope.selected[i].idUsuextEnti);
			                 }
                                    } 
				    
				    var datainsert = angular.toJson(listaids);
		 			console.log("Elimiar = "+datainsert);	
	        		$http.post(eliminarListadtEntidadesUsuexternosUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
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
					        .title('Eliminar Entidad Del Usuario Externo')
					        .textContent(dato)
					        .ariaLabel('ERROR')
					        .ok('OK')
					        .targetEvent(ev)
						   );
			            }
			        });			        			        	
		        	ev.target.disabled = false;
			 };	
			
		$scope.cargardtEntidadesUsuexternos = function(idUsuextEnti){		
			var surl = editardtEntidadesUsuexternosUrl+idUsuextEnti;
			$http.get(surl).then(function(res){
				var dato = res.data;
				$scope.setDtEntidadesUsuexternosModelo(dato);
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
					        .title('Cargar Entidad Del Usuario Externo')
					        .textContent(dato)
					        .ariaLabel('ERROR')
					        .ok('OK')
						   );
			            }			           
			        });			        			        	
			 };
			 
		$scope.showConfirm = function(ev, dtEntidadesUsuexternosBk) {
				    var confirm = $mdDialog.confirm()
				      .title('Activar Entidad Del Usuario Externo')
				      .textContent('Esta usted seguro de activar el registro?')
				      .ariaLabel('Lucky day')
				      .targetEvent(ev)
				      .ok('Si')
				      .cancel('No');

				    $mdDialog.show(confirm).then(function () {
				      $scope.status = 'SI';
				      $scope.eliminardtEntidadesUsuexternos(ev, dtEntidadesUsuexternosBk);
				    }, function () {
				      $scope.status = 'NO';
				    });
				  };

                $scope.showConfirmActivar = function(ev, dtEntidadesUsuexternosBk) {
				    var confirm = $mdDialog.confirm()
				      .title('Activar Entidad Del Usuario Externo')
				      .textContent('Esta usted seguro de activar el registro?')
				      .ariaLabel('Lucky day')
				      .targetEvent(ev)
				      .ok('Si')
				      .cancel('No');

				    $mdDialog.show(confirm).then(function () {
				      $scope.status = 'SI';
				      $scope.activardtEntidadesUsuexternos(ev, dtEntidadesUsuexternosBk);
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
				      .title('Eliminar Entidad Del Usuario Externo')
				      .textContent('Esta usted seguro de eliminar los '+tamanio+' registros seleccionados?')
				      .ariaLabel('Lucky day')
				      .targetEvent(ev)
				      .ok('Si')
				      .cancel('No');

				    $mdDialog.show(confirm).then(function () {
				      $scope.status = 'SI';
				      $scope.eliminarListadtEntidadesUsuexternos(ev);
				    }, function () {
				      $scope.status = 'NO';
				    });
				  };		  
///ADICIONALES
//SEARCH X Nombre
       $scope.ctrlDtUsuarioExternoIdUsuexterno={
         simulateQuery: false,
         isDisabled: false,
         selectedItem: null
        };
       
        $scope.newStateDtUsuarioExternoIdUsuexterno=function(state) {
             console.log("¡Lo siento! ¡Primero tendrás que crear una Constitución para " + state+"! ");
        }

        $scope.listaDtUsuarioExternoIdUsuexterno=[];
        $scope.querySearchDtUsuarioExternoIdUsuexterno = function(query) {
//          var results = query ? $scope.listaDtUsuarioExternoIdUsuexterno.filter($scope.createFilterForDtUsuarioExternoIdUsuexterno(query)) : $scope.listaDtUsuarioExternoIdUsuexterno,
//          return results;
            var sUrl = listaDtUsuarioExternoidUsuexternoUrl+query;
            return $http.get(sUrl).then(function(res){
                        $scope.listaDtUsuarioExternoIdUsuexterno = res.data;
                        return $scope.listaDtUsuarioExternoIdUsuexterno;
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

         $scope.createFilterForDtUsuarioExternoIdUsuexterno = function(query) {
                var upperCaseQuery = query.toUpperCase();
                return function filterFn(item) {
                  return (item.nombre.indexOf(upperCaseQuery) === 0);
                };
        };

        $scope.searchTextChangeDtUsuarioExternoIdUsuexterno = function(text) {
            console.log('Text changed to ' + text);
        }

        $scope.selectedItemChangeDtUsuarioExternoIdUsuexterno = function(item) {
           if($scope.isObject(item)){
               console.log('Item changed to ' + JSON.stringify(item));
               $scope.dtEntidadesUsuexternosModelo.idUsuexterno = item.idUsuexterno;
               $scope.dtEntidadesUsuexternosModelo.idUsuexternoTxt = item.nombre;
            }
        } 
////////////////////////////////////////////////////////////////////////////////
        
        $scope.listaDtUsuarioExternoXNombre=[];
        $scope.dlgDtUsuarioExternolimitOptions = [50,100, 500, 1000];
	$scope.dlgDtUsuarioExternoquery = {
			order: 'idUsuexterno',
			limit: 50,
			page: 1
	};
	$scope.dlgDtUsuarioExternoselected = [];
        $scope.dlgDtUsuarioExternooptions = {
			rowSelection: true,
			multiSelect: false,
			autoSelect: true,
			decapitate: false,
			largeEditDialog: false,
			boundaryLinks: true,
			limitSelect: true,
			pageSelect: true
	};
        $scope.dlgDtUsuarioExternofiltro ={
			idUsuexterno: null,
			nombre: null,
	};
        $scope.dlgDtUsuarioExternoDtoss = [];
	$scope.dlgDtUsuarioExternototal = 0;

        $scope.dlgDtUsuarioExternopromise=$timeout(function (){
               console.log("Listo");
        }, 500);        

        $scope.showDtUsuarioExternoDialog = function(ev) {		
		$mdDialog.show({
			contentElement: '#dtUsuarioExternoDialog',
			parent: angular.element(document.body),
			targetEvent: ev,
			clickOutsideToClose: true
		});
	};

        $scope.searchDtUsuarioExternoByNombre = function(ev){
            if(!$scope.isString($scope.dtEntidadesUsuexternosModelo.nombre)){
                    $mdDialog.show(
                        $mdDialog.alert()
                        .parent(angular.element(document.body))
                        .clickOutsideToClose(true)
                        .title('Dato incorrecto!')
                        .textContent('Ingrese el valor del Nombre en el cuadro de busqueda.')
                        .ariaLabel('ERROR')
                        .ok('OK')
                        .targetEvent(ev)
                    );
                    return;
            }            
            $scope.dtEntidadesUsuexternosModelo.idUsuexterno = null;
            $scope.dtEntidadesUsuexternosModelo.idUsuexternoTxt = null;
            $scope.dlgDtUsuarioExternoDtoss = [];
	    $scope.dlgDtUsuarioExternototal = 0;
            var surl = listaDtUsuarioExternoXNombreUrl+$scope.dtEntidadesUsuexternosModelo.nombre;
            $scope.dlgDtUsuarioExternopromise== $http.get(surl).then(function(res){
		var dato = res.data;
		if(dato.length==0){
			$mdDialog.show(
                            $mdDialog.alert()
                            .parent(angular.element(document.body))
                            .clickOutsideToClose(true)
                            .title('BUSCAR POR NOMBRE')
                            .textContent("NO SE ENCONTRARON DATOS CON "+$scope.dtEntidadesUsuexternosModelo.nombre)
                            .ariaLabel('BUSQUEDA')
                            .ok('OK')
                            .targetEvent(ev)
			);
		} else if(dato.length==1){
			var item = dato[0];				               
			if($scope.isObject(item)){
				console.log('Item changed to ' + JSON.stringify(item));
				$scope.dtEntidadesUsuexternosModelo.idUsuexterno = item.idUsuexterno;
                                $scope.dtEntidadesUsuexternosModelo.idUsuexternoTxt = item.nombre;
                                $scope.dtEntidadesUsuexternosModelo.nombre = item.nombre; 
			}
		} else if(dato.length>1){
			$scope.dlgDtUsuarioExternoDtoss = dato;
			$scope.dlgDtUsuarioExternototal = dato.length;
			$scope.showDtUsuarioExternoDialog(ev);
		}
	},
	function error(errResponse) {
		console.log("Buscar x Nombre data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		var dato = errResponse.data;
		if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
			$mdDialog.show(
                            $mdDialog.alert()
                            .parent(angular.element(document.body))
                            .clickOutsideToClose(true)
                            .title('Buscar x NOMBRE - Kamachiq')
                            .textContent(dato.message)
                            .ariaLabel('ERROR')
                            .ok('OK')
                            .targetEvent(ev)
			);
		}              
	});
        };
        $scope.dlgDtUsuarioExternorefrescarvista = function(ev){
		var keyCode = ev.which || ev.keyCode;
		if (keyCode === 13) {
		}
	};

        $scope.seleccionadodlgDtUsuarioExterno = function(ev) {
            if($scope.isObject(ev)){
                var item = ev;
                $scope.dtEntidadesUsuexternosModelo.idUsuexterno = item.idUsuexterno;
                $scope.dtEntidadesUsuexternosModelo.idUsuexternoTxt = item.nombre;
                $scope.dtEntidadesUsuexternosModelo.nombre = item.nombre; 
                $scope.cancel();
            }
	};        
//FIN DE SEARCH X Nombre


//DESCARGAR
    	$scope.descargar = function(){
    		return descargarUrl+$scope.getURLParametros();
    	}
///FIN ADICIONALES			 			 
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
				  
		    $scope.nuevo = ($scope.isNumber($scope.dtEntidadesUsuexternosModelo.idUsuextEnti) && $scope.dtEntidadesUsuexternosModelo.idUsuextEnti > 0);
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
			 
			$scope.filtroDtEntidadesUsuexternos = function(toma){				
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
