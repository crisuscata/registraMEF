var contexto = window.location.pathname.substring(0,window.location.pathname.indexOf('/',2));
var pglogoff = window.location.origin+contexto+'/logoff.htm';
var principalUrl = window.location.origin+contexto+'/index.htm';
var listadtAsistenciaUrl = contexto+"/rs/ctrldtAsistencia/listadtAsistencia";
var insertdtAsistenciaUrl = contexto+"/rs/ctrldtAsistencia/salvardtAsistencia";
var eliminardtAsistenciaUrl = contexto+"/rs/ctrldtAsistencia/eliminardtAsistencia";
var editardtAsistenciaUrl = contexto+"/rs/ctrldtAsistencia/editardtAsistencia/";
var listaDtEntidadesidEntidadIdEntidadUrl = contexto+"/rs/ctrldtAsistencia/listaDtEntidadesIdEntidadIdEntidad";
var listaPrtParametrosidparametroIdOrigenUrl = contexto+"/rs/ctrldtAsistencia/listaPrtParametrosIdparametroIdOrigen";
var listaPrtParametrosidparametroIdModalidadUrl = contexto+"/rs/ctrldtAsistencia/listaPrtParametrosIdparametroIdModalidad";
var listaPrtParametrosidparametroIdFinanciaUrl = contexto+"/rs/ctrldtAsistencia/listaPrtParametrosIdparametroIdFinancia";
var descargarUrl = contexto+"/rs/ctrldtAsistencia/descargar/";

///URLs CARGA DE ARCHIVOS
var insertDocUrl = contexto+"/rs/ctrldtAsistencia/insertarchivo";
var descargarUrl = contexto+"/rs/ctrldtAsistencia/descargar/";
///FIN URLs CARGA DE ARCHIVOS

var descargarvistaUrl = contexto+"/rs/ctrldtAsistencia/descargarvista";

/**
 * 
 */
myapp = angular.module('MyApp');

myapp.config(function($routeProvider) {
	  $routeProvider
	  .when("/editar/:idAsistencia", {
		  templateUrl : "adminis/editardtAsistencia.html",
		  controller : "ctrlListadtAsistencia"
	  })
	  .when("/nuevo", {
		  templateUrl : "adminis/editardtAsistencia.html",
		  controller : "ctrlListadtAsistencia"
	  })
	  .otherwise({
		  templateUrl : "adminis/verdtAsistencia.html",
		  controller : "ctrlListadtAsistencia"  
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

myapp.controller('ctrlListadtAsistencia', ['$mdEditDialog', '$scope', '$timeout', '$http', '$mdDialog','$location','$routeParams', '$mdPanel',  function ($mdEditDialog, $scope, $timeout, $http, $mdDialog, $location, $routeParams, $mdPanel) {
	'use strict';
	 
	 $scope.limitOptions = [100, 500, 1000, 5000];
	 $scope.query = {
			    order: 'idAsistencia',
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
	  $scope.loaddtAsistencias();
	 };
	 
	 $scope.logItem = function (item) {
	  console.log(item.name, 'was selected');
	 };
	 
	 $scope.logPagination = function (page, limit) {
	  console.log('page: ', page);
	  console.log('limit: ', limit);
	  $scope.loaddtAsistencias();
         };
     $scope.creadtAsistencia = false;
    // ///////////////////////////////////////////
	$scope.datos = [];
	$scope.total = 0;

	$scope.loaddtAsistencias = function () {
	    //$scope.promise = $timeout(function () {
	    	var surl = $scope.getURL();	    
	    	$scope.promise = $http.get(surl).then(function(res){
	    		 $scope.datos = res.data.data;
	    		 if(res.data.contador>0)
	    		 $scope.total = res.data.contador;
	    		 var tiempoenBD = res.data.tiempoenBD;
	    		 var tiempoenproceso = res.data.tiempoenproceso;
	    		 $scope.creadtAsistencia = res.data.creamodifica;
	    		 console.log("data " +$scope.datos.length+" DE "+ $scope.total);
	    		 console.log("Tiempo respuesta BD dtAsistencia " +tiempoenBD+" Tiempo en Paginar "+tiempoenproceso);
				},
				function error(errResponse) {
		            console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		            var dato = errResponse.data;
		            if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
		            	$mdDialog.show(
						         $mdDialog.alert()
						        .parent(angular.element(document.body))
						        .clickOutsideToClose(true)
						        .title('Lista de Asistencia Técnica')
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
		  return listadtAsistenciaUrl+$scope.getURLParametros();
	  }
	  
	  $scope.editdtAsistencia = function () {
		    $scope.nuevo = true;
		    var idAsistencia = $routeParams.idAsistencia;
		    if(idAsistencia){
		    	$scope.cargardtAsistencia(idAsistencia);
		    }
		   ///CARGAR COMPLEMENTOS 
                $scope.loadListaDtEntidadesIdEntidad();//SELECT
                $scope.loadListaPrtParametrosIdOrigen();//SELECT
                $scope.loadListaPrtParametrosIdModalidad();//SELECT
                $scope.loadListaPrtParametrosIdFinancia();//SELECT
		  };
	  
	  $scope.filtro ={
  fechaAsistencia: null,
  detalle: null,
  idUsuinterno: null,
  idEntidad: null,
  idOrigen: null,
  idProgramacion: null,
  idModalidad: null,
  idSede: null,
  idSistAdm: null,
  idFinancia: null,
  fechaFinalizacion: null,
  fechaSoli: null,
  
         estado: null
		}; 
	  
	  $scope.seteestado = function(eestado) {
			if($scope.filtro.estado === eestado){
				$scope.filtro.estado = null;
			}else{
				$scope.filtro.estado = eestado;
			}
			$scope.loaddtAsistencias();
		};
	  
         $scope.refrescarvista = function(ev){
		  if(typeof(ev)=='undefined' || ev==null){
	          
          }else{
			 var keyCode = ev.which || ev.keyCode;
			    if (keyCode === 13) {
			    	$scope.loaddtAsistencias();
			    }else if (keyCode === 1) {
			    	$scope.loaddtAsistencias();
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

	  $scope.dtAsistenciaModelo = {
			idAsistencia : null,
			fechaAsistencia: new Date(),
detalle: null,
			idUsuinterno: null,
			idEntidad: null,
			idOrigen: null,
			idProgramacion: null,
			idModalidad: null,
			idSede: null,
			idSistAdm: null,
			idFinancia: null,
			fechaFinalizacion: new Date(),
fechaProgramada: new Date(),
fechaSoli: new Date(),

                        // ADICIONALES
	                estadoTxt: null,
idUsuinternoTxt: null,
idEntidadTxt: null,
idOrigenTxt: null,
idProgramacionTxt: null,
idModalidadTxt: null,
idSedeTxt: null,
idSistAdmTxt: null,
idFinanciaTxt: null,

		    editopcion: 1
		};
	  
	  $scope.cleardtAsistencia = function(){
		    $scope.dtAsistenciaModelo.idAsistencia = null;
		    $scope.dtAsistenciaModelo.fechaAsistencia = new Date();$scope.dtAsistenciaModelo.detalle = null;
		    $scope.dtAsistenciaModelo.idUsuinterno = null;
		    $scope.dtAsistenciaModelo.idEntidad = null;
		    $scope.dtAsistenciaModelo.idOrigen = null;
		    $scope.dtAsistenciaModelo.idProgramacion = null;
		    $scope.dtAsistenciaModelo.idModalidad = null;
		    $scope.dtAsistenciaModelo.idSede = null;
		    $scope.dtAsistenciaModelo.idSistAdm = null;
		    $scope.dtAsistenciaModelo.idFinancia = null;
		    $scope.dtAsistenciaModelo.fechaFinalizacion = new Date();$scope.dtAsistenciaModelo.fechaProgramada = new Date();$scope.dtAsistenciaModelo.fechaSoli = new Date();
                    // ADICIONALES
	            $scope.dtAsistenciaModelo.estadoTxt = null;
$scope.dtAsistenciaModelo.idUsuinternoTxt = null;
$scope.dtAsistenciaModelo.idEntidadTxt = null;
$scope.dtAsistenciaModelo.idOrigenTxt = null;
$scope.dtAsistenciaModelo.idProgramacionTxt = null;
$scope.dtAsistenciaModelo.idModalidadTxt = null;
$scope.dtAsistenciaModelo.idSedeTxt = null;
$scope.dtAsistenciaModelo.idSistAdmTxt = null;
$scope.dtAsistenciaModelo.idFinanciaTxt = null;

		    $scope.dtAsistenciaModelo.editopcion = 1;
	 } 
	 
	  $scope.setDtAsistenciaModelo = function(dtAsistenciaBk) {
		  $scope.dtAsistenciaModelo.idAsistencia = dtAsistenciaBk.idAsistencia;
			$scope.dtAsistenciaModelo.fechaAsistencia = dtAsistenciaBk.fechaAsistencia;
                        if(!$scope.isNull($scope.dtAsistenciaModelo.fechaAsistencia) && !isNaN($scope.dtAsistenciaModelo.fechaAsistencia)){
			    $scope.dtAsistenciaModelo.fechaAsistencia = new Date($scope.dtAsistenciaModelo.fechaAsistencia);
		        }
$scope.dtAsistenciaModelo.detalle = dtAsistenciaBk.detalle;
			$scope.dtAsistenciaModelo.idUsuinterno = dtAsistenciaBk.idUsuinterno;
			$scope.dtAsistenciaModelo.idEntidad = dtAsistenciaBk.idEntidad;
			$scope.dtAsistenciaModelo.idOrigen = dtAsistenciaBk.idOrigen;
			$scope.dtAsistenciaModelo.idProgramacion = dtAsistenciaBk.idProgramacion;
			$scope.dtAsistenciaModelo.idModalidad = dtAsistenciaBk.idModalidad;
			$scope.dtAsistenciaModelo.idSede = dtAsistenciaBk.idSede;
			$scope.dtAsistenciaModelo.idSistAdm = dtAsistenciaBk.idSistAdm;
			$scope.dtAsistenciaModelo.idFinancia = dtAsistenciaBk.idFinancia;
			$scope.dtAsistenciaModelo.fechaFinalizacion = dtAsistenciaBk.fechaFinalizacion;
                        if(!$scope.isNull($scope.dtAsistenciaModelo.fechaFinalizacion) && !isNaN($scope.dtAsistenciaModelo.fechaFinalizacion)){
			    $scope.dtAsistenciaModelo.fechaFinalizacion = new Date($scope.dtAsistenciaModelo.fechaFinalizacion);
		        }
$scope.dtAsistenciaModelo.fechaProgramada = dtAsistenciaBk.fechaProgramada;
                        if(!$scope.isNull($scope.dtAsistenciaModelo.fechaProgramada) && !isNaN($scope.dtAsistenciaModelo.fechaProgramada)){
			    $scope.dtAsistenciaModelo.fechaProgramada = new Date($scope.dtAsistenciaModelo.fechaProgramada);
		        }
$scope.dtAsistenciaModelo.fechaSoli = dtAsistenciaBk.fechaSoli;
                        if(!$scope.isNull($scope.dtAsistenciaModelo.fechaSoli) && !isNaN($scope.dtAsistenciaModelo.fechaSoli)){
			    $scope.dtAsistenciaModelo.fechaSoli = new Date($scope.dtAsistenciaModelo.fechaSoli);
		        }

                        // ADICIONALES
	                $scope.dtAsistenciaModelo.estadoTxt = dtAsistenciaBk.estadoTxt;
$scope.dtAsistenciaModelo.idUsuinternoTxt = dtAsistenciaBk.idUsuinternoTxt;
$scope.dtAsistenciaModelo.idEntidadTxt = dtAsistenciaBk.idEntidadTxt;
$scope.dtAsistenciaModelo.idOrigenTxt = dtAsistenciaBk.idOrigenTxt;
$scope.dtAsistenciaModelo.idProgramacionTxt = dtAsistenciaBk.idProgramacionTxt;
$scope.dtAsistenciaModelo.idModalidadTxt = dtAsistenciaBk.idModalidadTxt;
$scope.dtAsistenciaModelo.idSedeTxt = dtAsistenciaBk.idSedeTxt;
$scope.dtAsistenciaModelo.idSistAdmTxt = dtAsistenciaBk.idSistAdmTxt;
$scope.dtAsistenciaModelo.idFinanciaTxt = dtAsistenciaBk.idFinanciaTxt;

			$scope.dtAsistenciaModelo.editopcion = dtAsistenciaBk.dtAsistenciaACL.editopcion;
		}
	  // ////////////////////////////////////////////////
	  $scope.editarDtAsistencia = function(ev, dtAsistenciaBk) {		  
		    $scope.setDtAsistenciaModelo(dtAsistenciaBk);		  
			$location.url('/editar/' + $scope.dtAsistenciaModelo.idAsistencia);
			$scope.nuevo = false;
	  }
	  
	  $scope.nuevoDtAsistencia = function() {
		    $scope.cleardtAsistencia();
			$location.url('/nuevo');
			$scope.nuevo = true;
	  }
	  	  
	  $scope.cancelarDtAsistencia = function() {
		    $scope.cleardtAsistencia();
		    $location.url('/');
	  }
	  			  
	  $scope.salvarDtAsistencia = function(ev){		
				    ev.target.disabled = true;
				    var datainsert = angular.toJson($scope.dtAsistenciaModelo);
		 			console.log("datainsert = "+datainsert);	
		        		$http.post(insertdtAsistenciaUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
							var dato = res.data;

//		    				$scope.datos.push(dato); 
		    				$scope.total = $scope.datos.length;
		    				
		    				$scope.setDtAsistenciaModelo(dato);
		    				
		    				$mdDialog.show(
							         $mdDialog.alert()
							        .parent(angular.element(document.body))
							        .clickOutsideToClose(true)
							        .title('Guardar Asistencia Técnica')
							        .textContent("del Asistencia Técnica se guardó correctamente.")
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
								        .title('Guardar Asistencia Técnica')
								        .textContent(dato.message)
								        .ariaLabel('ERROR')
								        .ok('OK')
								        .targetEvent(ev)
								    );
				            }
				        });		
		        			        	
		        	ev.target.disabled = false;
			 };
			 
	   $scope.eliminardtAsistencia = function(ev,dtAsistenciaBk){		
				    ev.target.disabled = true;
				    $scope.setDtAsistenciaModelo(dtAsistenciaBk);
				    var datainsert = angular.toJson($scope.dtAsistenciaModelo);
		 			console.log("datainsert = "+datainsert);	
	        		$http.post(eliminardtAsistenciaUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
						var dato = res.data;
						var instrumentos = $scope.datos;
				        var index = $scope.datos.findIndex(obj => obj.idAsistencia === dato.idAsistencia);
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
					        .title('Eliminar Asistencia Técnica')
					        .textContent(dato.message)
					        .ariaLabel('ERROR')
					        .ok('OK')
					        .targetEvent(ev)
						   );
			            }
			        });			        			        	
		        	ev.target.disabled = false;
			 };	
			
		$scope.cargardtAsistencia = function(idAsistencia){		
			var surl = editardtAsistenciaUrl+idAsistencia;
			$http.get(surl).then(function(res){
				var dato = res.data;
				$scope.setDtAsistenciaModelo(dato);
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
					        .title('Cargar Asistencia Técnica')
					        .textContent(dato.message)
					        .ariaLabel('ERROR')
					        .ok('OK')
						   );
			            }			           
			        });			        			        	
			 };
			 
		$scope.showConfirm = function(ev, dtAsistenciaBk) {
				    var confirm = $mdDialog.confirm()
				      .title('Eliminar Asistencia Técnica')
				      .textContent('Esta usted seguro de eliminar el registro?')
				      .ariaLabel('Lucky day')
				      .targetEvent(ev)
				      .ok('Si')
				      .cancel('No');

				    $mdDialog.show(confirm).then(function () {
				      $scope.status = 'SI';
				      $scope.eliminardtAsistencia(ev, dtAsistenciaBk);
				    }, function () {
				      $scope.status = 'NO';
				    });
				  };		  
///ADICIONALES
//SELECT INI
        $scope.listaDtEntidadesIdEntidad=[];
	$scope.loadListaDtEntidadesIdEntidad=function(){
		$http.get(listaDtEntidadesidEntidadIdEntidadUrl).then(function(res){
			$scope.listaDtEntidadesIdEntidad = res.data; 
		},
		function error(errResponse) {
			console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		});
	};
        $scope.changeIdEntidad=function(){
          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
        }
        $scope.$watch('dtAsistenciaModelo.idEntidad', function (newValue, oldValue) {
		console.log('dtAsistenciaModelo.idEntidad ' + newValue+' -- '+oldValue);
		//CARGAR DATOS DEL SIGUIENTE SELECT
	});
//SELECT FIN                
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
        $scope.$watch('dtAsistenciaModelo.idOrigen', function (newValue, oldValue) {
		console.log('dtAsistenciaModelo.idOrigen ' + newValue+' -- '+oldValue);
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
        $scope.$watch('dtAsistenciaModelo.idModalidad', function (newValue, oldValue) {
		console.log('dtAsistenciaModelo.idModalidad ' + newValue+' -- '+oldValue);
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
        $scope.$watch('dtAsistenciaModelo.idFinancia', function (newValue, oldValue) {
		console.log('dtAsistenciaModelo.idFinancia ' + newValue+' -- '+oldValue);
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
				  
		    $scope.nuevo = ($scope.isNumber($scope.dtAsistenciaModelo.idAsistencia) && $scope.dtAsistenciaModelo.idAsistencia > 0);
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
			 
			$scope.filtroDtAsistencia = function(toma){				
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
