var contexto = window.location.pathname.substring(0,window.location.pathname.indexOf('/',2));
var pglogoff = window.location.origin+contexto+'/logoff.htm';
var principalUrl = window.location.origin+contexto+'/index.htm';
var listadtVisitasUrl = contexto+"/rs/ctrldtVisitas/listadtVisitas";
var insertdtVisitasUrl = contexto+"/rs/ctrldtVisitas/salvardtVisitas";
var eliminardtVisitasUrl = contexto+"/rs/ctrldtVisitas/eliminardtVisitas";
var editardtVisitasUrl = contexto+"/rs/ctrldtVisitas/editardtVisitas/";
var listaPrtParametrosidparametroIdOrigenUrl = contexto+"/rs/ctrldtVisitas/listaPrtParametrosIdparametroIdOrigen";
var listaPrtParametrosidparametroIdModalidadUrl = contexto+"/rs/ctrldtVisitas/listaPrtParametrosIdparametroIdModalidad";
var listaPrtParametrosidparametroIdTipoUrl = contexto+"/rs/ctrldtVisitas/listaPrtParametrosIdparametroIdTipo";
var listaPrtParametrosidparametroIdLugarUrl = contexto+"/rs/ctrldtVisitas/listaPrtParametrosIdparametroIdLugar";
var listaMsSedesidSedeIdSedeUrl = contexto+"/rs/ctrldtVisitas/listaMsSedesIdSedeIdSede";
var listaPrtParametrosidparametroIdFinanciaUrl = contexto+"/rs/ctrldtVisitas/listaPrtParametrosIdparametroIdFinancia";
var descargarUrl = contexto+"/rs/ctrldtVisitas/descargar/";

///URLs CARGA DE ARCHIVOS
var insertDocUrl = contexto+"/rs/ctrldtVisitas/insertarchivo";
var descargarUrl = contexto+"/rs/ctrldtVisitas/descargar/";
///FIN URLs CARGA DE ARCHIVOS

var descargarvistaUrl = contexto+"/rs/ctrldtVisitas/descargarvista";

/**
 * 
 */
myapp = angular.module('MyApp');

myapp.config(function($routeProvider) {
	  $routeProvider
	  .when("/editar/:idVisita", {
		  templateUrl : "adminis/editardtVisitas.html",
		  controller : "ctrlListadtVisitas"
	  })
	  .when("/nuevo", {
		  templateUrl : "adminis/editardtVisitas.html",
		  controller : "ctrlListadtVisitas"
	  })
	  .otherwise({
		  templateUrl : "adminis/verdtVisitas.html",
		  controller : "ctrlListadtVisitas"  
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

myapp.controller('ctrlListadtVisitas', ['$mdEditDialog', '$scope', '$timeout', '$http', '$mdDialog','$location','$routeParams', '$mdPanel',  function ($mdEditDialog, $scope, $timeout, $http, $mdDialog, $location, $routeParams, $mdPanel) {
	'use strict';
	 
	 $scope.limitOptions = [100, 500, 1000, 5000];
	 $scope.query = {
			    order: 'idVisita',
			    limit: 100,
			    page: 1
			  };
	 
	 $scope.selected = [];
	 $scope.options = {
			    rowSelection: false,
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
	  $scope.loaddtVisitass();
	 };
	 
	 $scope.logItem = function (item) {
	  console.log(item.name, 'was selected');
	 };
	 
	 $scope.logPagination = function (page, limit) {
	  console.log('page: ', page);
	  console.log('limit: ', limit);
	  $scope.loaddtVisitass();
         };
     $scope.creadtVisitas = false;
    // ///////////////////////////////////////////
	$scope.datos = [];
	$scope.total = 0;

	$scope.loaddtVisitass = function () {
	    //$scope.promise = $timeout(function () {
	    	var surl = $scope.getURL();	    
	    	$scope.promise = $http.get(surl).then(function(res){
	    		 $scope.datos = res.data.data;
	    		 if(res.data.contador>0)
	    		 $scope.total = res.data.contador;
	    		 var tiempoenBD = res.data.tiempoenBD;
	    		 var tiempoenproceso = res.data.tiempoenproceso;
	    		 $scope.creadtVisitas = res.data.creamodifica;
	    		 console.log("data " +$scope.datos.length+" DE "+ $scope.total);
	    		 console.log("Tiempo respuesta BD dtVisitas " +tiempoenBD+" Tiempo en Paginar "+tiempoenproceso);
				},
				function error(errResponse) {
		            console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		            var dato = errResponse.data;
		            if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
		            	$mdDialog.show(
						         $mdDialog.alert()
						        .parent(angular.element(document.body))
						        .clickOutsideToClose(true)
						        .title('Lista de Visitas')
						        .textContent(dato.message)
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
		  return listadtVisitasUrl+$scope.getURLParametros();
	  }
	  
	  $scope.editdtVisitas = function () {
		    $scope.nuevo = true;
		    var idVisita = $routeParams.idVisita;
		    if(idVisita){
		    	$scope.cargardtVisitas(idVisita);
		    }
		   ///CARGAR COMPLEMENTOS 
                $scope.loadListaPrtParametrosIdOrigen();//SELECT
                $scope.loadListaPrtParametrosIdModalidad();//SELECT
                $scope.loadListaPrtParametrosIdTipo();//SELECT
                $scope.loadListaPrtParametrosIdLugar();//SELECT
                $scope.loadListaMsSedesIdSede();//SELECT
                $scope.loadListaPrtParametrosIdFinancia();//SELECT
		  };
	  
	  $scope.filtro ={
  fechaVisita: null,
  idOrigen: null,
  idProgramacion: null,
  idModalidad: null,
  idTipo: null,
  idLugar: null,
  idEntidad: null,
  idSede: null,
  idSistAdm: null,
  idFinancia: null,
  fechaProgramada: null,
  
         estado: null
		}; 
	  
	  $scope.seteestado = function(eestado) {
			if($scope.filtro.estado === eestado){
				$scope.filtro.estado = null;
			}else{
				$scope.filtro.estado = eestado;
			}
			$scope.loaddtVisitass();
		};
	  
         $scope.refrescarvista = function(ev){
		  if(typeof(ev)=='undefined' || ev==null){
	          
          }else{
			 var keyCode = ev.which || ev.keyCode;
			    if (keyCode === 13) {
			    	$scope.loaddtVisitass();
			    }else if (keyCode === 1) {
			    	$scope.loaddtVisitass();
			    }
          }
		};

          $scope.descargarvista = function(ev){
			  if(typeof(ev)=='undefined' || ev==null){
				  return "#";
	          }else{
	        	  return descargarvistaUrl;
	        	  }
	    };

	  $scope.dtVisitasModelo = {
			idVisita : null,
			fechaVisita: null,
			conclusion: null,
			idOrigen: null,
			idProgramacion: null,
			idModalidad: null,
			idTipo: null,
			idLugar: null,
			idEntidad: null,
			idSede: null,
			idSistAdm: null,
			idFinancia: null,
			fechaFinalizacion: new Date(),
fechaProgramada: new Date(),

                        // ADICIONALES
	                estadoTxt: null,
idOrigenTxt: null,
idProgramacionTxt: null,
idModalidadTxt: null,
idTipoTxt: null,
idLugarTxt: null,
idEntidadTxt: null,
idSedeTxt: null,
idSistAdmTxt: null,
idFinanciaTxt: null,

		    editopcion: 1
		};
	  
	  $scope.cleardtVisitas = function(){
		    $scope.dtVisitasModelo.idVisita = null;
		    $scope.dtVisitasModelo.fechaVisita = null;
		    $scope.dtVisitasModelo.conclusion = null;
		    $scope.dtVisitasModelo.idOrigen = null;
		    $scope.dtVisitasModelo.idProgramacion = null;
		    $scope.dtVisitasModelo.idModalidad = null;
		    $scope.dtVisitasModelo.idTipo = null;
		    $scope.dtVisitasModelo.idLugar = null;
		    $scope.dtVisitasModelo.idEntidad = null;
		    $scope.dtVisitasModelo.idSede = null;
		    $scope.dtVisitasModelo.idSistAdm = null;
		    $scope.dtVisitasModelo.idFinancia = null;
		    $scope.dtVisitasModelo.fechaFinalizacion = new Date();$scope.dtVisitasModelo.fechaProgramada = new Date();
                    // ADICIONALES
	            $scope.dtVisitasModelo.estadoTxt = null;
$scope.dtVisitasModelo.idOrigenTxt = null;
$scope.dtVisitasModelo.idProgramacionTxt = null;
$scope.dtVisitasModelo.idModalidadTxt = null;
$scope.dtVisitasModelo.idTipoTxt = null;
$scope.dtVisitasModelo.idLugarTxt = null;
$scope.dtVisitasModelo.idEntidadTxt = null;
$scope.dtVisitasModelo.idSedeTxt = null;
$scope.dtVisitasModelo.idSistAdmTxt = null;
$scope.dtVisitasModelo.idFinanciaTxt = null;

		    $scope.dtVisitasModelo.editopcion = 1;
	 } 
	 
	  $scope.setDtVisitasModelo = function(dtVisitasBk) {
		  $scope.dtVisitasModelo.idVisita = dtVisitasBk.idVisita;
			$scope.dtVisitasModelo.fechaVisita = dtVisitasBk.fechaVisita;
			$scope.dtVisitasModelo.conclusion = dtVisitasBk.conclusion;
			$scope.dtVisitasModelo.idOrigen = dtVisitasBk.idOrigen;
			$scope.dtVisitasModelo.idProgramacion = dtVisitasBk.idProgramacion;
			$scope.dtVisitasModelo.idModalidad = dtVisitasBk.idModalidad;
			$scope.dtVisitasModelo.idTipo = dtVisitasBk.idTipo;
			$scope.dtVisitasModelo.idLugar = dtVisitasBk.idLugar;
			$scope.dtVisitasModelo.idEntidad = dtVisitasBk.idEntidad;
			$scope.dtVisitasModelo.idSede = dtVisitasBk.idSede;
			$scope.dtVisitasModelo.idSistAdm = dtVisitasBk.idSistAdm;
			$scope.dtVisitasModelo.idFinancia = dtVisitasBk.idFinancia;
			$scope.dtVisitasModelo.fechaFinalizacion = dtVisitasBk.fechaFinalizacion;
                        if(!$scope.isNull($scope.dtVisitasModelo.fechaFinalizacion) && !isNaN($scope.dtVisitasModelo.fechaFinalizacion)){
			    $scope.dtVisitasModelo.fechaFinalizacion = new Date($scope.dtVisitasModelo.fechaFinalizacion);
		        }
$scope.dtVisitasModelo.fechaProgramada = dtVisitasBk.fechaProgramada;
                        if(!$scope.isNull($scope.dtVisitasModelo.fechaProgramada) && !isNaN($scope.dtVisitasModelo.fechaProgramada)){
			    $scope.dtVisitasModelo.fechaProgramada = new Date($scope.dtVisitasModelo.fechaProgramada);
		        }

                        // ADICIONALES
	                $scope.dtVisitasModelo.estadoTxt = dtVisitasBk.estadoTxt;
$scope.dtVisitasModelo.idOrigenTxt = dtVisitasBk.idOrigenTxt;
$scope.dtVisitasModelo.idProgramacionTxt = dtVisitasBk.idProgramacionTxt;
$scope.dtVisitasModelo.idModalidadTxt = dtVisitasBk.idModalidadTxt;
$scope.dtVisitasModelo.idTipoTxt = dtVisitasBk.idTipoTxt;
$scope.dtVisitasModelo.idLugarTxt = dtVisitasBk.idLugarTxt;
$scope.dtVisitasModelo.idEntidadTxt = dtVisitasBk.idEntidadTxt;
$scope.dtVisitasModelo.idSedeTxt = dtVisitasBk.idSedeTxt;
$scope.dtVisitasModelo.idSistAdmTxt = dtVisitasBk.idSistAdmTxt;
$scope.dtVisitasModelo.idFinanciaTxt = dtVisitasBk.idFinanciaTxt;

			$scope.dtVisitasModelo.editopcion = dtVisitasBk.dtVisitasACL.editopcion;
		}
	  // ////////////////////////////////////////////////
	  $scope.editarDtVisitas = function(ev, dtVisitasBk) {		  
		    $scope.setDtVisitasModelo(dtVisitasBk);		  
			$location.url('/editar/' + $scope.dtVisitasModelo.idVisita);
			$scope.nuevo = false;
	  }
	  
	  $scope.nuevoDtVisitas = function() {
		    $scope.cleardtVisitas();
			$location.url('/nuevo');
			$scope.nuevo = true;
	  }
	  	  
	  $scope.cancelarDtVisitas = function() {
		    $scope.cleardtVisitas();
		    $location.url('/');
	  }
	  			  
	  $scope.salvarDtVisitas = function(ev){		
				    ev.target.disabled = true;
				    var datainsert = angular.toJson($scope.dtVisitasModelo);
		 			console.log("datainsert = "+datainsert);	
		        		$http.post(insertdtVisitasUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
							var dato = res.data;

//		    				$scope.datos.push(dato); 
		    				$scope.total = $scope.datos.length;
		    				
		    				$scope.setDtVisitasModelo(dato);
		    				
		    				$mdDialog.show(
							         $mdDialog.alert()
							        .parent(angular.element(document.body))
							        .clickOutsideToClose(true)
							        .title('Guardar Visitas')
							        .textContent("del Visitas se guardó correctamente.")
							        .ariaLabel('ERROR')
							        .ok('OK')
							        .targetEvent(ev)
							    );
		    				
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
								        .title('Guardar Visitas')
								        .textContent(dato.message)
								        .ariaLabel('ERROR')
								        .ok('OK')
								        .targetEvent(ev)
								    );
				            }
				        });		
		        			        	
		        	ev.target.disabled = false;
			 };
			 
	   $scope.eliminardtVisitas = function(ev,dtVisitasBk){		
				    ev.target.disabled = true;
				    $scope.setDtVisitasModelo(dtVisitasBk);
				    var datainsert = angular.toJson($scope.dtVisitasModelo);
		 			console.log("datainsert = "+datainsert);	
	        		$http.post(eliminardtVisitasUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
						var dato = res.data;
						var instrumentos = $scope.datos;
				        var index = $scope.datos.findIndex(obj => obj.idVisita === dato.idVisita);
						console.log("INDEX " + index);
				        if(instrumentos.length>index){
				        	instrumentos.splice(index, 1);
					        $scope.datos = instrumentos;
					        $scope.total = $scope.datos.length;
				        }	
					},
					function error(errResponse) {
			            console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
			            var dato = errResponse.data;
			            if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
			            	$mdDialog.show(
					         $mdDialog.alert()
					        .parent(angular.element(document.body))
					        .clickOutsideToClose(true)
					        .title('Eliminar Visitas')
					        .textContent(dato.message)
					        .ariaLabel('ERROR')
					        .ok('OK')
					        .targetEvent(ev)
						   );
			            }
			        });			        			        	
		        	ev.target.disabled = false;
			 };	
			
		$scope.cargardtVisitas = function(idVisita){		
			var surl = editardtVisitasUrl+idVisita;
			$http.get(surl).then(function(res){
				var dato = res.data;
				$scope.setDtVisitasModelo(dato);
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
					        .title('Cargar Visitas')
					        .textContent(dato.message)
					        .ariaLabel('ERROR')
					        .ok('OK')
						   );
			            }			           
			        });			        			        	
			 };
			 
		$scope.showConfirm = function(ev, dtVisitasBk) {
				    var confirm = $mdDialog.confirm()
				      .title('Eliminar Visitas')
				      .textContent('Esta usted seguro de eliminar el registro?')
				      .ariaLabel('Lucky day')
				      .targetEvent(ev)
				      .ok('Si')
				      .cancel('No');

				    $mdDialog.show(confirm).then(function () {
				      $scope.status = 'SI';
				      $scope.eliminardtVisitas(ev, dtVisitasBk);
				    }, function () {
				      $scope.status = 'NO';
				    });
				  };		  
///ADICIONALES
//SELECT INI
        $scope.listaPrtParametrosIdOrigen=[];
	$scope.loadListaPrtParametrosIdOrigen=function(){
		$http.get(listaPrtParametrosidparametroIdOrigenUrl).then(function(res){
			$scope.listaPrtParametrosIdOrigen = res.data; 
		},
		function error(errResponse) {
			console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		});
	};
        $scope.changeIdOrigen=function(){
          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
        }
        $scope.$watch('dtVisitasModelo.idOrigen', function (newValue, oldValue) {
		console.log('dtVisitasModelo.idOrigen ' + newValue+' -- '+oldValue);
		//CARGAR DATOS DEL SIGUIENTE SELECT
	});
//SELECT FIN                
//SELECT INI
        $scope.listaPrtParametrosIdModalidad=[];
	$scope.loadListaPrtParametrosIdModalidad=function(){
		$http.get(listaPrtParametrosidparametroIdModalidadUrl).then(function(res){
			$scope.listaPrtParametrosIdModalidad = res.data; 
		},
		function error(errResponse) {
			console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		});
	};
        $scope.changeIdModalidad=function(){
          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
        }
        $scope.$watch('dtVisitasModelo.idModalidad', function (newValue, oldValue) {
		console.log('dtVisitasModelo.idModalidad ' + newValue+' -- '+oldValue);
		//CARGAR DATOS DEL SIGUIENTE SELECT
	});
//SELECT FIN                
//SELECT INI
        $scope.listaPrtParametrosIdTipo=[];
	$scope.loadListaPrtParametrosIdTipo=function(){
		$http.get(listaPrtParametrosidparametroIdTipoUrl).then(function(res){
			$scope.listaPrtParametrosIdTipo = res.data; 
		},
		function error(errResponse) {
			console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		});
	};
        $scope.changeIdTipo=function(){
          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
        }
        $scope.$watch('dtVisitasModelo.idTipo', function (newValue, oldValue) {
		console.log('dtVisitasModelo.idTipo ' + newValue+' -- '+oldValue);
		//CARGAR DATOS DEL SIGUIENTE SELECT
	});
//SELECT FIN                
//SELECT INI
        $scope.listaPrtParametrosIdLugar=[];
	$scope.loadListaPrtParametrosIdLugar=function(){
		$http.get(listaPrtParametrosidparametroIdLugarUrl).then(function(res){
			$scope.listaPrtParametrosIdLugar = res.data; 
		},
		function error(errResponse) {
			console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		});
	};
        $scope.changeIdLugar=function(){
          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
        }
        $scope.$watch('dtVisitasModelo.idLugar', function (newValue, oldValue) {
		console.log('dtVisitasModelo.idLugar ' + newValue+' -- '+oldValue);
		//CARGAR DATOS DEL SIGUIENTE SELECT
	});
//SELECT FIN                
//SELECT INI
        $scope.listaMsSedesIdSede=[];
	$scope.loadListaMsSedesIdSede=function(){
		$http.get(listaMsSedesidSedeIdSedeUrl).then(function(res){
			$scope.listaMsSedesIdSede = res.data; 
		},
		function error(errResponse) {
			console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		});
	};
        $scope.changeIdSede=function(){
          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
        }
        $scope.$watch('dtVisitasModelo.idSede', function (newValue, oldValue) {
		console.log('dtVisitasModelo.idSede ' + newValue+' -- '+oldValue);
		//CARGAR DATOS DEL SIGUIENTE SELECT
	});
//SELECT FIN                
//SELECT INI
        $scope.listaPrtParametrosIdFinancia=[];
	$scope.loadListaPrtParametrosIdFinancia=function(){
		$http.get(listaPrtParametrosidparametroIdFinanciaUrl).then(function(res){
			$scope.listaPrtParametrosIdFinancia = res.data; 
		},
		function error(errResponse) {
			console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		});
	};
        $scope.changeIdFinancia=function(){
          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
        }
        $scope.$watch('dtVisitasModelo.idFinancia', function (newValue, oldValue) {
		console.log('dtVisitasModelo.idFinancia ' + newValue+' -- '+oldValue);
		//CARGAR DATOS DEL SIGUIENTE SELECT
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
		    
		 // Returns if a value is really a number
			$scope.isNumber  = function(value) {
			  return typeof value === 'number' && isFinite(value);
			  };	
				  
		    $scope.nuevo = ($scope.isNumber($scope.dtVisitasModelo.idVisita) && $scope.dtVisitasModelo.idVisita > 0);
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
			 
			$scope.filtroDtVisitas = function(toma){				
				const keys = Object.keys($scope.filtro);
				console.log('Filtro Keys '+keys);
				Object.keys($scope.filtro).forEach(key => {
					   console.log(key);
					   const valor = $scope.filtro[key];
		                  console.log('Filtro Key '+key+' Valor '+valor);
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
