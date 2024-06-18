var contexto = window.location.pathname.substring(0,window.location.pathname.indexOf('/',2));
var pglogoff = window.location.origin+contexto+'/logoff.htm';
var principalUrl = window.location.origin+contexto+'/index.htm';
var listadtAsistenciaProyectoUrl = contexto+"/rs/ctrldtAsistenciaProyecto/listadtAsistenciaProyecto";
var insertdtAsistenciaProyectoUrl = contexto+"/rs/ctrldtAsistenciaProyecto/salvardtAsistenciaProyecto";
var eliminardtAsistenciaProyectoUrl = contexto+"/rs/ctrldtAsistenciaProyecto/eliminardtAsistenciaProyecto";
var activardtAsistenciaProyectoUrl = contexto+"/rs/ctrldtAsistenciaProyecto/activardtAsistenciaProyecto";
var eliminarListadtAsistenciaProyectoUrl = contexto+"/rs/ctrldtAsistenciaProyecto/eliminarListadtAsistenciaProyecto";
var editardtAsistenciaProyectoUrl = contexto+"/rs/ctrldtAsistenciaProyecto/editardtAsistenciaProyecto/";
var listaMsProyectoInversionidProyectoUrl = contexto+"/rs/ctrldtAsistenciaProyecto/listaMsProyectoInversionIdProyecto/";
var listaMsProyectoInversionXNombreUrl = contexto+"/rs/ctrldtAsistenciaProyecto/listaMsProyectoInversionXNombre/";

var descargarUrl = contexto+"/rs/ctrldtAsistenciaProyecto/descargar/";

///URLs CARGA DE ARCHIVOS
var insertDocUrl = contexto+"/rs/ctrldtAsistenciaProyecto/insertarchivo";
///FIN URLs CARGA DE ARCHIVOS

var descargarvistaUrl = contexto+"/rs/ctrldtAsistenciaProyecto/descargarvista";

/**
 * 
 */
myapp = angular.module('MyApp');

myapp.config(function($routeProvider) {
	  $routeProvider
	  .when("/editar/:idAsistProyecto", {
		  templateUrl : "adminis/editardtAsistenciaProyecto.html",
		  controller : "ctrlListadtAsistenciaProyecto"
	  })
	  .when("/nuevo", {
		  templateUrl : "adminis/editardtAsistenciaProyecto.html",
		  controller : "ctrlListadtAsistenciaProyecto"
	  })
	  .otherwise({
		  templateUrl : "adminis/verdtAsistenciaProyecto.html",
		  controller : "ctrlListadtAsistenciaProyecto"  
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

myapp.controller('ctrlListadtAsistenciaProyecto', ['$mdEditDialog', '$scope', '$timeout', '$http', '$mdDialog','$location','$routeParams', '$mdPanel',  function ($mdEditDialog, $scope, $timeout, $http, $mdDialog, $location, $routeParams, $mdPanel) {
	'use strict';
	 
	 $scope.limitOptions = [100, 500, 1000, 5000];
	 $scope.query = {
			    order: 'idAsistProyecto',
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
	  $scope.loaddtAsistenciaProyectos();
	 };
	 
	 $scope.logItem = function (item) {
	  console.log(item.name, 'was selected');
	 };
	 
	 $scope.logPagination = function (page, limit) {
	  console.log('page: ', page);
	  console.log('limit: ', limit);
	  $scope.loaddtAsistenciaProyectos();
         };
     $scope.creadtAsistenciaProyecto = false;
    // ///////////////////////////////////////////
	$scope.datos = [];
	$scope.total = 0;

	$scope.loaddtAsistenciaProyectos = function () {
	    //$scope.promise = $timeout(function () {
	    	var surl = $scope.getURL();	    
	    	$scope.promise = $http.get(surl).then(function(res){
	    		 $scope.datos = res.data.data;
	    		 if(res.data.contador>0)
	    		 $scope.total = res.data.contador;
	    		 var tiempoenBD = res.data.tiempoenBD;
	    		 var tiempoenproceso = res.data.tiempoenproceso;
	    		 $scope.creadtAsistenciaProyecto = res.data.creamodifica;
	    		 console.log("data " +$scope.datos.length+" DE "+ $scope.total);
	    		 console.log("Tiempo respuesta BD dtAsistenciaProyecto " +tiempoenBD+" Tiempo en Paginar "+tiempoenproceso);
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
						        .title('Lista de Lista De Los Distintos Proyectos De Inversión Relacionados A La Asistencia Técnica')
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
		  return listadtAsistenciaProyectoUrl+$scope.getURLParametros();
	  }
	  
	  $scope.editdtAsistenciaProyecto = function () {
		    $scope.nuevo = true;
		    var idAsistProyecto = $routeParams.idAsistProyecto;
		    if(idAsistProyecto){
		    	$scope.cargardtAsistenciaProyecto(idAsistProyecto);
		    }
		   ///CARGAR COMPLEMENTOS 
		  };
	  
	  $scope.filtro ={
  idAsistencia: null,
  idProyecto: null,
  detalle: null,
  
         estado: null
		}; 
	  
	  $scope.seteestado = function(eestado) {
			if($scope.filtro.estado === eestado){
				$scope.filtro.estado = null;
			}else{
				$scope.filtro.estado = eestado;
			}
			$scope.loaddtAsistenciaProyectos();
		};
	  
         $scope.refrescarvista = function(ev){
		  if(typeof(ev)=='undefined' || ev==null){
	          
          }else{
			 var keyCode = ev.which || ev.keyCode;
			    if (keyCode === 13) {
			    	$scope.loaddtAsistenciaProyectos();
			    }else if (keyCode === 1) {
			    	$scope.loaddtAsistenciaProyectos();
			    }
          }
		};

	  $scope.dtAsistenciaProyectoModelo = {
			idAsistProyecto : null,
			idAsistencia: null,
			nombre: null,
                      idProyecto: null,detalle: null,
			
                        // ADICIONALES
	                idAsistenciaTxt: null,
idProyectoTxt: null,
estadoTxt: null,

		    editopcion: 1
		};
	  
	  $scope.cleardtAsistenciaProyecto = function(){
		    $scope.dtAsistenciaProyectoModelo.idAsistProyecto = null;
		    $scope.dtAsistenciaProyectoModelo.idAsistencia = null;
		    $scope.dtAsistenciaProyectoModelo.idProyecto = null;$scope.dtAsistenciaProyectoModelo.nombre = null;$scope.dtAsistenciaProyectoModelo.detalle = null;
		    
                    // ADICIONALES
	            $scope.dtAsistenciaProyectoModelo.idAsistenciaTxt = null;
$scope.dtAsistenciaProyectoModelo.idProyectoTxt = null;
$scope.dtAsistenciaProyectoModelo.estadoTxt = null;

		    $scope.dtAsistenciaProyectoModelo.editopcion = 1;
	 } 
	 
	  $scope.setDtAsistenciaProyectoModelo = function(dtAsistenciaProyectoBk) {
		  $scope.dtAsistenciaProyectoModelo.idAsistProyecto = dtAsistenciaProyectoBk.idAsistProyecto;
			$scope.dtAsistenciaProyectoModelo.idAsistencia = dtAsistenciaProyectoBk.idAsistencia;
			$scope.dtAsistenciaProyectoModelo.idProyecto = dtAsistenciaProyectoBk.idProyecto; $scope.dtAsistenciaProyectoModelo.nombre = dtAsistenciaProyectoBk.nombre;$scope.dtAsistenciaProyectoModelo.detalle = dtAsistenciaProyectoBk.detalle;
			
                        // ADICIONALES
	                $scope.dtAsistenciaProyectoModelo.idAsistenciaTxt = dtAsistenciaProyectoBk.idAsistenciaTxt;
$scope.dtAsistenciaProyectoModelo.idProyectoTxt = dtAsistenciaProyectoBk.idProyectoTxt;
$scope.dtAsistenciaProyectoModelo.estadoTxt = dtAsistenciaProyectoBk.estadoTxt;

			$scope.dtAsistenciaProyectoModelo.editopcion = dtAsistenciaProyectoBk.dtAsistenciaProyectoACL.editopcion;
		}
	  // ////////////////////////////////////////////////
	  $scope.editarDtAsistenciaProyecto = function(ev, dtAsistenciaProyectoBk) {		  
		    $scope.setDtAsistenciaProyectoModelo(dtAsistenciaProyectoBk);		  
			$location.url('/editar/' + $scope.dtAsistenciaProyectoModelo.idAsistProyecto);
			$scope.nuevo = false;
	  }
	  
	  $scope.nuevoDtAsistenciaProyecto = function() {
		    $scope.cleardtAsistenciaProyecto();
			$location.url('/nuevo');
			$scope.nuevo = true;
	  }
	  	  
	  $scope.cancelarDtAsistenciaProyecto = function() {
		    $scope.cleardtAsistenciaProyecto();
		    $location.url('/');
	  }
	  			  
	  $scope.salvarDtAsistenciaProyecto = function(ev){		
				    ev.target.disabled = true;
				    var datainsert = angular.toJson($scope.dtAsistenciaProyectoModelo);
		 			console.log("datainsert = "+datainsert);	
		        		$http.post(insertdtAsistenciaProyectoUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
							var dato = res.data;

//		    				$scope.datos.push(dato); 
		    				$scope.total = $scope.datos.length;
		    				
		    				$scope.setDtAsistenciaProyectoModelo(dato);
		    				
		    				$mdDialog.show(
							         $mdDialog.alert()
							        .parent(angular.element(document.body))
							        .clickOutsideToClose(true)
							        .title('Guardar Lista De Los Distintos Proyectos De Inversión Relacionados A La Asistencia Técnica')
							        .textContent("del Lista De Los Distintos Proyectos De Inversión Relacionados A La Asistencia Técnica se guardó correctamente.")
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
								        .title('Guardar Lista De Los Distintos Proyectos De Inversión Relacionados A La Asistencia Técnica')
								        .textContent(dato)
								        .ariaLabel('ERROR')
								        .ok('OK')
								        .targetEvent(ev)
								    );
				            }
				        });		
		        			        	
		        	ev.target.disabled = false;
			 };
			 
	   $scope.eliminardtAsistenciaProyecto = function(ev,dtAsistenciaProyectoBk){		
				    ev.target.disabled = true;
				    $scope.setDtAsistenciaProyectoModelo(dtAsistenciaProyectoBk);
				    var datainsert = angular.toJson($scope.dtAsistenciaProyectoModelo);
		 			console.log("Eliminar = "+datainsert);	
	        		$http.post(eliminardtAsistenciaProyectoUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
						var dato = res.data;
						var instrumentos = $scope.datos;
				        var index = $scope.datos.findIndex(obj => obj.idAsistProyecto === dato.idAsistProyecto);
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
					        .title('Eliminar Lista De Los Distintos Proyectos De Inversión Relacionados A La Asistencia Técnica')
					        .textContent(dato)
					        .ariaLabel('ERROR')
					        .ok('OK')
					        .targetEvent(ev)
						   );
			            }
			        });			        			        	
		        	ev.target.disabled = false;
			 };

            $scope.activardtAsistenciaProyecto = function(ev,dtAsistenciaProyectoBk){		
				    ev.target.disabled = true;
				    $scope.setDtAsistenciaProyectoModelo(dtAsistenciaProyectoBk);
				    var datainsert = angular.toJson($scope.dtAsistenciaProyectoModelo);
		 			console.log("Activar = "+datainsert);	
	        		$http.post(activardtAsistenciaProyectoUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
						var dato = res.data;
						var instrumentos = $scope.datos;
				        var index = $scope.datos.findIndex(obj => obj.idAsistProyecto === dato.idAsistProyecto);
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
					        .title('Activar Lista De Los Distintos Proyectos De Inversión Relacionados A La Asistencia Técnica')
					        .textContent(dato)
					        .ariaLabel('ERROR')
					        .ok('OK')
					        .targetEvent(ev)
						   );
			            }
			        });			        			        	
		        	ev.target.disabled = false;
			 };

            $scope.eliminarListadtAsistenciaProyecto = function(ev){		
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
				             listaids.push($scope.selected[i].idAsistProyecto);
			                 }
                                    } 
				    
				    var datainsert = angular.toJson(listaids);
		 			console.log("Elimiar = "+datainsert);	
	        		$http.post(eliminarListadtAsistenciaProyectoUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
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
					        .title('Eliminar Lista De Los Distintos Proyectos De Inversión Relacionados A La Asistencia Técnica')
					        .textContent(dato)
					        .ariaLabel('ERROR')
					        .ok('OK')
					        .targetEvent(ev)
						   );
			            }
			        });			        			        	
		        	ev.target.disabled = false;
			 };	
			
		$scope.cargardtAsistenciaProyecto = function(idAsistProyecto){		
			var surl = editardtAsistenciaProyectoUrl+idAsistProyecto;
			$http.get(surl).then(function(res){
				var dato = res.data;
				$scope.setDtAsistenciaProyectoModelo(dato);
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
					        .title('Cargar Lista De Los Distintos Proyectos De Inversión Relacionados A La Asistencia Técnica')
					        .textContent(dato)
					        .ariaLabel('ERROR')
					        .ok('OK')
						   );
			            }			           
			        });			        			        	
			 };
			 
		$scope.showConfirm = function(ev, dtAsistenciaProyectoBk) {
				    var confirm = $mdDialog.confirm()
				      .title('Activar Lista De Los Distintos Proyectos De Inversión Relacionados A La Asistencia Técnica')
				      .textContent('Esta usted seguro de activar el registro?')
				      .ariaLabel('Lucky day')
				      .targetEvent(ev)
				      .ok('Si')
				      .cancel('No');

				    $mdDialog.show(confirm).then(function () {
				      $scope.status = 'SI';
				      $scope.eliminardtAsistenciaProyecto(ev, dtAsistenciaProyectoBk);
				    }, function () {
				      $scope.status = 'NO';
				    });
				  };

                $scope.showConfirmActivar = function(ev, dtAsistenciaProyectoBk) {
				    var confirm = $mdDialog.confirm()
				      .title('Activar Lista De Los Distintos Proyectos De Inversión Relacionados A La Asistencia Técnica')
				      .textContent('Esta usted seguro de activar el registro?')
				      .ariaLabel('Lucky day')
				      .targetEvent(ev)
				      .ok('Si')
				      .cancel('No');

				    $mdDialog.show(confirm).then(function () {
				      $scope.status = 'SI';
				      $scope.activardtAsistenciaProyecto(ev, dtAsistenciaProyectoBk);
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
				      .title('Eliminar Lista De Los Distintos Proyectos De Inversión Relacionados A La Asistencia Técnica')
				      .textContent('Esta usted seguro de eliminar los '+tamanio+' registros seleccionados?')
				      .ariaLabel('Lucky day')
				      .targetEvent(ev)
				      .ok('Si')
				      .cancel('No');

				    $mdDialog.show(confirm).then(function () {
				      $scope.status = 'SI';
				      $scope.eliminarListadtAsistenciaProyecto(ev);
				    }, function () {
				      $scope.status = 'NO';
				    });
				  };		  
///ADICIONALES
//SEARCH X Nombre
       $scope.ctrlMsProyectoInversionIdProyecto={
         simulateQuery: false,
         isDisabled: false,
         selectedItem: null
        };
       
        $scope.newStateMsProyectoInversionIdProyecto=function(state) {
             console.log("¡Lo siento! ¡Primero tendrás que crear una Constitución para " + state+"! ");
        }

        $scope.listaMsProyectoInversionIdProyecto=[];
        $scope.querySearchMsProyectoInversionIdProyecto = function(query) {
//          var results = query ? $scope.listaMsProyectoInversionIdProyecto.filter($scope.createFilterForMsProyectoInversionIdProyecto(query)) : $scope.listaMsProyectoInversionIdProyecto,
//          return results;
            var sUrl = listaMsProyectoInversionidProyectoUrl+query;
            return $http.get(sUrl).then(function(res){
                        $scope.listaMsProyectoInversionIdProyecto = res.data;
                        return $scope.listaMsProyectoInversionIdProyecto;
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

         $scope.createFilterForMsProyectoInversionIdProyecto = function(query) {
                var upperCaseQuery = query.toUpperCase();
                return function filterFn(item) {
                  return (item.nombre.indexOf(upperCaseQuery) === 0);
                };
        };

        $scope.searchTextChangeMsProyectoInversionIdProyecto = function(text) {
            console.log('Text changed to ' + text);
        }

        $scope.selectedItemChangeMsProyectoInversionIdProyecto = function(item) {
           if($scope.isObject(item)){
               console.log('Item changed to ' + JSON.stringify(item));
               $scope.dtAsistenciaProyectoModelo.idProyecto = item.idProyecto;
               $scope.dtAsistenciaProyectoModelo.idProyectoTxt = item.nombre;
            }
        } 
////////////////////////////////////////////////////////////////////////////////
        
        $scope.listaMsProyectoInversionXNombre=[];
        $scope.dlgMsProyectoInversionlimitOptions = [50,100, 500, 1000];
	$scope.dlgMsProyectoInversionquery = {
			order: 'idProyecto',
			limit: 50,
			page: 1
	};
	$scope.dlgMsProyectoInversionselected = [];
        $scope.dlgMsProyectoInversionoptions = {
			rowSelection: true,
			multiSelect: false,
			autoSelect: true,
			decapitate: false,
			largeEditDialog: false,
			boundaryLinks: true,
			limitSelect: true,
			pageSelect: true
	};
        $scope.dlgMsProyectoInversionfiltro ={
			idProyecto: null,
			nombre: null,
	};
        $scope.dlgMsProyectoInversionDtoss = [];
	$scope.dlgMsProyectoInversiontotal = 0;

        $scope.dlgMsProyectoInversionpromise=$timeout(function (){
               console.log("Listo");
        }, 500);        

        $scope.showMsProyectoInversionDialog = function(ev) {		
		$mdDialog.show({
			contentElement: '#msProyectoInversionDialog',
			parent: angular.element(document.body),
			targetEvent: ev,
			clickOutsideToClose: true
		});
	};

        $scope.searchMsProyectoInversionByNombre = function(ev){
            if(!$scope.isString($scope.dtAsistenciaProyectoModelo.nombre)){
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
            $scope.dtAsistenciaProyectoModelo.idProyecto = null;
            $scope.dtAsistenciaProyectoModelo.idProyectoTxt = null;
            $scope.dlgMsProyectoInversionDtoss = [];
	    $scope.dlgMsProyectoInversiontotal = 0;
            var surl = listaMsProyectoInversionXNombreUrl+$scope.dtAsistenciaProyectoModelo.nombre;
            $scope.dlgMsProyectoInversionpromise== $http.get(surl).then(function(res){
		var dato = res.data;
		if(dato.length==0){
			$mdDialog.show(
                            $mdDialog.alert()
                            .parent(angular.element(document.body))
                            .clickOutsideToClose(true)
                            .title('BUSCAR POR NOMBRE')
                            .textContent("NO SE ENCONTRARON DATOS CON "+$scope.dtAsistenciaProyectoModelo.nombre)
                            .ariaLabel('BUSQUEDA')
                            .ok('OK')
                            .targetEvent(ev)
			);
		} else if(dato.length==1){
			var item = dato[0];				               
			if($scope.isObject(item)){
				console.log('Item changed to ' + JSON.stringify(item));
				$scope.dtAsistenciaProyectoModelo.idProyecto = item.idProyecto;
                                $scope.dtAsistenciaProyectoModelo.idProyectoTxt = item.nombre;
                                $scope.dtAsistenciaProyectoModelo.nombre = item.nombre; 
			}
		} else if(dato.length>1){
			$scope.dlgMsProyectoInversionDtoss = dato;
			$scope.dlgMsProyectoInversiontotal = dato.length;
			$scope.showMsProyectoInversionDialog(ev);
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
        $scope.dlgMsProyectoInversionrefrescarvista = function(ev){
		var keyCode = ev.which || ev.keyCode;
		if (keyCode === 13) {
		}
	};

        $scope.seleccionadodlgMsProyectoInversion = function(ev) {
            if($scope.isObject(ev)){
                var item = ev;
                $scope.dtAsistenciaProyectoModelo.idProyecto = item.idProyecto;
                $scope.dtAsistenciaProyectoModelo.idProyectoTxt = item.nombre;
                $scope.dtAsistenciaProyectoModelo.nombre = item.nombre; 
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
				  
		    $scope.nuevo = ($scope.isNumber($scope.dtAsistenciaProyectoModelo.idAsistProyecto) && $scope.dtAsistenciaProyectoModelo.idAsistProyecto > 0);
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
			 
			$scope.filtroDtAsistenciaProyecto = function(toma){				
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
