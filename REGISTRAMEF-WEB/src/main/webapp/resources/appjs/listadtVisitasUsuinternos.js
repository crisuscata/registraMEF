var contexto = window.location.pathname.substring(0,window.location.pathname.indexOf('/',2));
var pglogoff = window.location.origin+contexto+'/logoff.htm';
var principalUrl = window.location.origin+contexto+'/index.htm';
var listadtVisitasUsuinternosUrl = contexto+"/rs/ctrldtVisitasUsuinternos/listadtVisitasUsuinternos";
var insertdtVisitasUsuinternosUrl = contexto+"/rs/ctrldtVisitasUsuinternos/salvardtVisitasUsuinternos";
var eliminardtVisitasUsuinternosUrl = contexto+"/rs/ctrldtVisitasUsuinternos/eliminardtVisitasUsuinternos";
var activardtVisitasUsuinternosUrl = contexto+"/rs/ctrldtVisitasUsuinternos/activardtVisitasUsuinternos";
var eliminarListadtVisitasUsuinternosUrl = contexto+"/rs/ctrldtVisitasUsuinternos/eliminarListadtVisitasUsuinternos";
var editardtVisitasUsuinternosUrl = contexto+"/rs/ctrldtVisitasUsuinternos/editardtVisitasUsuinternos/";
var listaMsUsuariosUrl = contexto+"/rs/ctrldtVisitasUsuinternos/listaMsUsuarios";
var listaMsTemaidTemaIdTemaUrl = contexto+"/rs/ctrldtVisitasUsuinternos/listaMsTemaIdTemaIdTema";
var descargarUrl = contexto+"/rs/ctrldtVisitasUsuinternos/descargar/";

///URLs CARGA DE ARCHIVOS
var insertDocUrl = contexto+"/rs/ctrldtVisitasUsuinternos/insertarchivo";
///FIN URLs CARGA DE ARCHIVOS

var descargarvistaUrl = contexto+"/rs/ctrldtVisitasUsuinternos/descargarvista";

/**
 * 
 */
myapp = angular.module('MyApp');

myapp.config(function($routeProvider) {
	  $routeProvider
	  .when("/editar/:idVisitUsuint", {
		  templateUrl : "adminis/editardtVisitasUsuinternos.html",
		  controller : "ctrlListadtVisitasUsuinternos"
	  })
	  .when("/nuevo", {
		  templateUrl : "adminis/editardtVisitasUsuinternos.html",
		  controller : "ctrlListadtVisitasUsuinternos"
	  })
	  .otherwise({
		  templateUrl : "adminis/verdtVisitasUsuinternos.html",
		  controller : "ctrlListadtVisitasUsuinternos"  
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

myapp.controller('ctrlListadtVisitasUsuinternos', ['$mdEditDialog', '$scope', '$timeout', '$http', '$mdDialog','$location','$routeParams', '$mdPanel',  function ($mdEditDialog, $scope, $timeout, $http, $mdDialog, $location, $routeParams, $mdPanel) {
	'use strict';
	 
	 $scope.limitOptions = [100, 500, 1000, 5000];
	 $scope.query = {
			    order: 'idVisitUsuint',
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
	  $scope.loaddtVisitasUsuinternoss();
	 };
	 
	 $scope.logItem = function (item) {
	  console.log(item.name, 'was selected');
	 };
	 
	 $scope.logPagination = function (page, limit) {
	  console.log('page: ', page);
	  console.log('limit: ', limit);
	  $scope.loaddtVisitasUsuinternoss();
         };
     $scope.creadtVisitasUsuinternos = false;
    // ///////////////////////////////////////////
	$scope.datos = [];
	$scope.total = 0;

	$scope.loaddtVisitasUsuinternoss = function () {
	    //$scope.promise = $timeout(function () {
	    	var surl = $scope.getURL();	    
	    	$scope.promise = $http.get(surl).then(function(res){
	    		 $scope.datos = res.data.data;
	    		 if(res.data.contador>0)
	    		 $scope.total = res.data.contador;
	    		 var tiempoenBD = res.data.tiempoenBD;
	    		 var tiempoenproceso = res.data.tiempoenproceso;
	    		 $scope.creadtVisitasUsuinternos = res.data.creamodifica;
	    		 console.log("data " +$scope.datos.length+" DE "+ $scope.total);
	    		 console.log("Tiempo respuesta BD dtVisitasUsuinternos " +tiempoenBD+" Tiempo en Paginar "+tiempoenproceso);
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
						        .title('Lista de Participantes De La Visita')
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
		  return listadtVisitasUsuinternosUrl+$scope.getURLParametros();
	  }
	  
	  $scope.editdtVisitasUsuinternos = function () {
		    $scope.nuevo = true;
		    var idVisitUsuint = $routeParams.idVisitUsuint;
		    if(idVisitUsuint){
		    	$scope.cargardtVisitasUsuinternos(idVisitUsuint);
		    }
		   ///CARGAR COMPLEMENTOS 
                $scope.loadListaMsUsuarios();//SELECT-BUSQUEDA
                $scope.loadListaMsTemaIdTema();//SELECT
		  };
	  
	  $scope.filtro ={
  idVisita: null,
  idUsuinterno: null,
  
         estado: null
		}; 
	  
	  $scope.seteestado = function(eestado) {
			if($scope.filtro.estado === eestado){
				$scope.filtro.estado = null;
			}else{
				$scope.filtro.estado = eestado;
			}
			$scope.loaddtVisitasUsuinternoss();
		};
	  
         $scope.refrescarvista = function(ev){
		  if(typeof(ev)=='undefined' || ev==null){
	          
          }else{
			 var keyCode = ev.which || ev.keyCode;
			    if (keyCode === 13) {
			    	$scope.loaddtVisitasUsuinternoss();
			    }else if (keyCode === 1) {
			    	$scope.loaddtVisitasUsuinternoss();
			    }
          }
		};

	  $scope.dtVisitasUsuinternosModelo = {
			idVisitUsuint : null,
			idVisita: null,
			idUsuinterno: null,
			idTema: null,
			
                        // ADICIONALES
	                idVisitaTxt: null,
idUsuinternoTxt: null,
estadoTxt: null,
idTemaTxt: null,

		    editopcion: 1
		};
	  
	  $scope.cleardtVisitasUsuinternos = function(){
		    $scope.dtVisitasUsuinternosModelo.idVisitUsuint = null;
		    $scope.dtVisitasUsuinternosModelo.idVisita = null;
		    $scope.dtVisitasUsuinternosModelo.idUsuinterno = null;
		    $scope.dtVisitasUsuinternosModelo.idTema = null;
		    
                    // ADICIONALES
	            $scope.dtVisitasUsuinternosModelo.idVisitaTxt = null;
$scope.dtVisitasUsuinternosModelo.idUsuinternoTxt = null;
$scope.dtVisitasUsuinternosModelo.estadoTxt = null;
$scope.dtVisitasUsuinternosModelo.idTemaTxt = null;

		    $scope.dtVisitasUsuinternosModelo.editopcion = 1;
	 } 
	 
	  $scope.setDtVisitasUsuinternosModelo = function(dtVisitasUsuinternosBk) {
		  $scope.dtVisitasUsuinternosModelo.idVisitUsuint = dtVisitasUsuinternosBk.idVisitUsuint;
			$scope.dtVisitasUsuinternosModelo.idVisita = dtVisitasUsuinternosBk.idVisita;
			$scope.dtVisitasUsuinternosModelo.idUsuinterno = dtVisitasUsuinternosBk.idUsuinterno;
			$scope.dtVisitasUsuinternosModelo.idTema = dtVisitasUsuinternosBk.idTema;
			
                        // ADICIONALES
	                $scope.dtVisitasUsuinternosModelo.idVisitaTxt = dtVisitasUsuinternosBk.idVisitaTxt;
$scope.dtVisitasUsuinternosModelo.idUsuinternoTxt = dtVisitasUsuinternosBk.idUsuinternoTxt;
$scope.dtVisitasUsuinternosModelo.estadoTxt = dtVisitasUsuinternosBk.estadoTxt;
$scope.dtVisitasUsuinternosModelo.idTemaTxt = dtVisitasUsuinternosBk.idTemaTxt;

			$scope.dtVisitasUsuinternosModelo.editopcion = dtVisitasUsuinternosBk.dtVisitasUsuinternosACL.editopcion;
		}
	  // ////////////////////////////////////////////////
	  $scope.editarDtVisitasUsuinternos = function(ev, dtVisitasUsuinternosBk) {		  
		    $scope.setDtVisitasUsuinternosModelo(dtVisitasUsuinternosBk);		  
			$location.url('/editar/' + $scope.dtVisitasUsuinternosModelo.idVisitUsuint);
			$scope.nuevo = false;
	  }
	  
	  $scope.nuevoDtVisitasUsuinternos = function() {
		    $scope.cleardtVisitasUsuinternos();
			$location.url('/nuevo');
			$scope.nuevo = true;
	  }
	  	  
	  $scope.cancelarDtVisitasUsuinternos = function() {
		    $scope.cleardtVisitasUsuinternos();
		    $location.url('/');
	  }
	  			  
	  $scope.salvarDtVisitasUsuinternos = function(ev){		
				    ev.target.disabled = true;
				    var datainsert = angular.toJson($scope.dtVisitasUsuinternosModelo);
		 			console.log("datainsert = "+datainsert);	
		        		$http.post(insertdtVisitasUsuinternosUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
							var dato = res.data;

//		    				$scope.datos.push(dato); 
		    				$scope.total = $scope.datos.length;
		    				
		    				$scope.setDtVisitasUsuinternosModelo(dato);
		    				
		    				$mdDialog.show(
							         $mdDialog.alert()
							        .parent(angular.element(document.body))
							        .clickOutsideToClose(true)
							        .title('Guardar Participantes De La Visita')
							        .textContent("del Participantes De La Visita se guardó correctamente.")
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
								        .title('Guardar Participantes De La Visita')
								        .textContent(dato)
								        .ariaLabel('ERROR')
								        .ok('OK')
								        .targetEvent(ev)
								    );
				            }
				        });		
		        			        	
		        	ev.target.disabled = false;
			 };
			 
	   $scope.eliminardtVisitasUsuinternos = function(ev,dtVisitasUsuinternosBk){		
				    ev.target.disabled = true;
				    $scope.setDtVisitasUsuinternosModelo(dtVisitasUsuinternosBk);
				    var datainsert = angular.toJson($scope.dtVisitasUsuinternosModelo);
		 			console.log("Eliminar = "+datainsert);	
	        		$http.post(eliminardtVisitasUsuinternosUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
						var dato = res.data;
						var instrumentos = $scope.datos;
				        var index = $scope.datos.findIndex(obj => obj.idVisitUsuint === dato.idVisitUsuint);
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
					        .title('Eliminar Participantes De La Visita')
					        .textContent(dato)
					        .ariaLabel('ERROR')
					        .ok('OK')
					        .targetEvent(ev)
						   );
			            }
			        });			        			        	
		        	ev.target.disabled = false;
			 };

            $scope.activardtVisitasUsuinternos = function(ev,dtVisitasUsuinternosBk){		
				    ev.target.disabled = true;
				    $scope.setDtVisitasUsuinternosModelo(dtVisitasUsuinternosBk);
				    var datainsert = angular.toJson($scope.dtVisitasUsuinternosModelo);
		 			console.log("Activar = "+datainsert);	
	        		$http.post(activardtVisitasUsuinternosUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
						var dato = res.data;
						var instrumentos = $scope.datos;
				        var index = $scope.datos.findIndex(obj => obj.idVisitUsuint === dato.idVisitUsuint);
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
					        .title('Activar Participantes De La Visita')
					        .textContent(dato)
					        .ariaLabel('ERROR')
					        .ok('OK')
					        .targetEvent(ev)
						   );
			            }
			        });			        			        	
		        	ev.target.disabled = false;
			 };

            $scope.eliminarListadtVisitasUsuinternos = function(ev){		
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
				             listaids.push($scope.selected[i].idVisitUsuint);
			                 }
                                    } 
				    
				    var datainsert = angular.toJson(listaids);
		 			console.log("Elimiar = "+datainsert);	
	        		$http.post(eliminarListadtVisitasUsuinternosUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
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
					        .title('Eliminar Participantes De La Visita')
					        .textContent(dato)
					        .ariaLabel('ERROR')
					        .ok('OK')
					        .targetEvent(ev)
						   );
			            }
			        });			        			        	
		        	ev.target.disabled = false;
			 };	
			
		$scope.cargardtVisitasUsuinternos = function(idVisitUsuint){		
			var surl = editardtVisitasUsuinternosUrl+idVisitUsuint;
			$http.get(surl).then(function(res){
				var dato = res.data;
				$scope.setDtVisitasUsuinternosModelo(dato);
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
					        .title('Cargar Participantes De La Visita')
					        .textContent(dato)
					        .ariaLabel('ERROR')
					        .ok('OK')
						   );
			            }			           
			        });			        			        	
			 };
			 
		$scope.showConfirm = function(ev, dtVisitasUsuinternosBk) {
				    var confirm = $mdDialog.confirm()
				      .title('Activar Participantes De La Visita')
				      .textContent('Esta usted seguro de activar el registro?')
				      .ariaLabel('Lucky day')
				      .targetEvent(ev)
				      .ok('Si')
				      .cancel('No');

				    $mdDialog.show(confirm).then(function () {
				      $scope.status = 'SI';
				      $scope.eliminardtVisitasUsuinternos(ev, dtVisitasUsuinternosBk);
				    }, function () {
				      $scope.status = 'NO';
				    });
				  };

                $scope.showConfirmActivar = function(ev, dtVisitasUsuinternosBk) {
				    var confirm = $mdDialog.confirm()
				      .title('Activar Participantes De La Visita')
				      .textContent('Esta usted seguro de activar el registro?')
				      .ariaLabel('Lucky day')
				      .targetEvent(ev)
				      .ok('Si')
				      .cancel('No');

				    $mdDialog.show(confirm).then(function () {
				      $scope.status = 'SI';
				      $scope.activardtVisitasUsuinternos(ev, dtVisitasUsuinternosBk);
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
				      .title('Eliminar Participantes De La Visita')
				      .textContent('Esta usted seguro de eliminar los '+tamanio+' registros seleccionados?')
				      .ariaLabel('Lucky day')
				      .targetEvent(ev)
				      .ok('Si')
				      .cancel('No');

				    $mdDialog.show(confirm).then(function () {
				      $scope.status = 'SI';
				      $scope.eliminarListadtVisitasUsuinternos(ev);
				    }, function () {
				      $scope.status = 'NO';
				    });
				  };		  
///ADICIONALES
//SELECT-BUSQUEDA INI
        $scope.listaMsUsuarios=[];
	$scope.loadListaMsUsuarios=function(){
		$http.get(listaMsUsuariosUrl).then(function(res){
			$scope.listaMsUsuarios = res.data; 
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
        $scope.filterItemsMsUsuarios= function(items) {
            if($scope.searchTermMsUsuarios.search.length<=0)
                return $scope.listaMsUsuarios;
            var result = [];
            angular.forEach(items, function(item) {
                // if item is something.. add to result
                if(item.nombres.toLowerCase().indexOf($scope.searchTermMsUsuarios.search.toLowerCase())>=0){
                    result.push(item); 
                }
            });
            return result;
        };
        $scope.searchTermMsUsuarios = { search: '', nombres: null };
        $scope.clearSearchTermMsUsuarios = function () {
            $scope.searchTermMsUsuarios.search = '';
        };
        
        $scope.showMsUsuariosDialog = function(ev) {		
		$mdDialog.show({
			contentElement: '#msUsuariosDialog',
			parent: angular.element(document.body),
			targetEvent: ev,
			clickOutsideToClose: true
		});
	};
        
        $scope.dlgMsUsuarioslimitOptions = [50,100, 500, 1000];
	$scope.dlgMsUsuariosquery = {
			order: 'idusuario',
			limit: 50,
			page: 1
	};
	$scope.dlgMsUsuariosselected = [];
        $scope.dlgMsUsuariosoptions = {
			rowSelection: true,
			multiSelect: false,
			autoSelect: true,
			decapitate: false,
			largeEditDialog: false,
			boundaryLinks: true,
			limitSelect: true,
			pageSelect: true
	};
        $scope.dlgMsUsuariosfiltro ={
			idusuario: null,
			nombres: null,
	};
        $scope.dlgMsUsuariosDtoss = [];
	$scope.dlgMsUsuariostotal = 0;
        
        $scope.dlgMsUsuariospromise=$timeout(function (){
            if($scope.listaMsUsuarios.length==0){
                $scope.loadListaMsUsuarios();
            }else{
                $scope.dlgMsUsuariosDtoss = $scope.listaMsUsuarios;
                $scope.dlgMsUsuariostotal = $scope.listaMsUsuarios.length;
            }
        }, 500);
        
        $scope.dlgMsUsuariosrefrescarvista = function(ev){
		var keyCode = ev.which || ev.keyCode;
		if (keyCode === 13) {
		}
	};
        $scope.filtrodlgMsUsuarios = function(msUsuariosAct){
		var keys = Object.keys($scope.dlgMsUsuariosfiltro);
		for (var key of keys) {
			var valor = $scope.dlgMsUsuariosfiltro[key];
			try{
				if(valor == null ) continue;
                                if(valor == '' ) continue;
				if($scope.isString(valor) && $scope.isString(msUsuariosAct[key])){
					if(msUsuariosAct[key].toUpperCase().indexOf(valor.toUpperCase())<=-1){
						return false;
					}									  
				}else if($scope.isString(valor)){
					return false;
				}
			}catch(e){
				console.log("Error = "+e);	
			}
		}
		return true;
	};
        
        $scope.seleccionadodlgMsUsuarios = function(ev) {
		$scope.dlgMsUsuariosselected = [];
		if($scope.isObject(ev)){
			var dato = ev;
			$scope.dtVisitasUsuinternosModelo.idUsuinterno = dato.idusuario;
			$scope.cancel();
		}
	};
        
        $scope.searchMsUsuariosByNombres = function(ev){
		if(!$scope.isString($scope.searchTermMsUsuarios.nombres)){
			$mdDialog.show(
					$mdDialog.alert()
					.parent(angular.element(document.body))
					.clickOutsideToClose(true)
					.title('Dato incorrecto!')
					.textContent('Ingrese el valor del Nombres en el cuadro de busqueda.')
					.ariaLabel('ERROR')
					.ok('OK')
					.targetEvent(ev)
			);
			return;
		}

		var msUsuariosDto = $scope.findMsUsuariosByNombres($scope.searchTermMsUsuarios.nombres, $scope.listaMsUsuarios);
		if(!$scope.isObject(msUsuariosDto)){
			$mdDialog.show(
					$mdDialog.alert()
					.parent(angular.element(document.body))
					.clickOutsideToClose(true)
					.title('Dato no encontrado!')
					.textContent('No se encontró ninguna MsUsuarios para el Nombres ingresado.')
					.ariaLabel('ERROR')
					.ok('OK')
					.targetEvent(ev)
			);
			return;
		}

		$scope.dtVisitasUsuinternosModelo.idUsuinterno = msUsuariosDto.idusuario;
	};

        $scope.findMsUsuariosByNombres = function(key, inputArray){
		for (var i=0; i < inputArray.length; i++) {
			if (inputArray[i].nombres === key) {
				return inputArray[i];
			}}
	};
//SELECT-BUSQUEDA FIN
//SELECT INI
        $scope.listaMsTemaIdTema=[];
	$scope.loadListaMsTemaIdTema=function(){
		$http.get(listaMsTemaidTemaIdTemaUrl).then(function(res){
			$scope.listaMsTemaIdTema = res.data; 
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
        $scope.changeIdTema=function(){
          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
        }
        $scope.$watch('dtVisitasUsuinternosModelo.idTema', function (newValue, oldValue) {
		console.log('dtVisitasUsuinternosModelo.idTema ' + newValue+' -- '+oldValue);
		//CARGAR DATOS DEL SIGUIENTE SELECT
//	if($scope.isArray($scope.listaMsTemaIdTema)){
//		var obj = $scope.listaMsTemaIdTema.find(o => o.id === newValue);
//		if($scope.isObject(obj)){
//			$scope.msTemaModelo.idTemaTxt = obj.valor;
//		}
//	}
	});
//SELECT FIN                


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
				  
		    $scope.nuevo = ($scope.isNumber($scope.dtVisitasUsuinternosModelo.idVisitUsuint) && $scope.dtVisitasUsuinternosModelo.idVisitUsuint > 0);
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
			 
			$scope.filtroDtVisitasUsuinternos = function(toma){				
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
