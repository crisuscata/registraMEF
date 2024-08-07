var contexto = window.location.pathname.substring(0,window.location.pathname.indexOf('/',2));
var pglogoff = window.location.origin+contexto+'/logoff.htm';
var principalUrl = window.location.origin+contexto+'/index.htm';
var listadtAsistenciaUrl = contexto+"/rs/ctrldtAsistencia/listadtAsistencia";
var insertdtAsistenciaUrl = contexto+"/rs/ctrldtAsistencia/salvardtAsistencia";
var eliminardtAsistenciaUrl = contexto+"/rs/ctrldtAsistencia/eliminardtAsistencia";
var activardtAsistenciaUrl = contexto+"/rs/ctrldtAsistencia/activardtAsistencia";
var eliminarListadtAsistenciaUrl = contexto+"/rs/ctrldtAsistencia/eliminarListadtAsistencia";
var editardtAsistenciaUrl = contexto+"/rs/ctrldtAsistencia/editardtAsistencia/";
var listaDtEntidadesidEntidadIdEntidadUrl = contexto+"/rs/ctrldtAsistencia/listaDtEntidadesIdEntidadIdEntidad";
var listaPrtParametrosidparametroIdOrigenUrl = contexto+"/rs/ctrldtAsistencia/listaPrtParametrosIdparametroIdOrigen";
var listaPrtParametrosidparametroIdModalidadUrl = contexto+"/rs/ctrldtAsistencia/listaPrtParametrosIdparametroIdModalidad";
var listaPrtParametrosidparametroIdFinanciaUrl = contexto+"/rs/ctrldtAsistencia/listaPrtParametrosIdparametroIdFinancia";
var descargarUrl = contexto+"/rs/ctrldtAsistencia/descargar/";
var valorcrearlUrl = contexto+"/rs/ctrldtAsistencia/loadvalorcrear";// PURIBE 15042024 - INICIO -->

// /URLs CARGA DE ARCHIVOS
var insertDocUrl = contexto+"/rs/ctrldtAsistencia/insertarchivo";
// /FIN URLs CARGA DE ARCHIVOS

var descargarvistaUrl = contexto+"/rs/ctrldtAsistencia/descargarvista";

// MPINARES 24012023 - INICIO
var buscarCodEjecUrl = contexto+"/rs/ctrldtAsistencia/buscarcodejec/";
var listaMsTemaidTemaIdTemaUrl = contexto+"/rs/ctrldtAsistencia/listaMsTemaIdTemaIdTema";
var listaMsSubtemaidSubtemaIdSubtemaUrl = contexto+"/rs/ctrldtAsistencia/listaMsSubtemaIdSubtemaIdSubtema/";
var listaMsSedesUrl = contexto+"/rs/ctrldtAsistencia/listamsSedes";
var eliminardtAsistenciaTemasUrl = contexto+"/rs/ctrldtAsistencia/eliminardtAsistenciaTema";
var listaMsInstitucionesidproveeUrl = contexto+"/rs/ctrldtAsistencia/listaMsInstitucionesIdprovee/";
var listaPrtParametrosidparametroIdTipoEntidadUrl = contexto+"/rs/ctrldtAsistencia/listaPrtParametrosIdparametroIdTipoEntidad";
var listaPrtParametrosidparametroIdCaracteristicaUrl = contexto+"/rs/ctrldtAsistencia/listaPrtParametrosIdparametroIdCaracteristica";
var listaPaisesUrl = contexto+"/rs/ctrldtAsistencia/listaPaises";
var listaCoddptosUrl = contexto+"/rs/ctrldtAsistencia/listaCoddptos";
var ubigeodefectoUrl = contexto+"/rs/ctrldtAsistencia/ubigeodefecto";
var listaCodprovUrl = contexto+"/rs/ctrldtAsistencia/listaCodprov/";
var listaCoddistUrl = contexto+"/rs/ctrldtAsistencia/listaCoddist/";
var insertdtEntidadesUrl = contexto+"/rs/ctrldtAsistencia/salvardtEntidades";
var listamsSisAdminUrl = contexto+"/rs/ctrldtAsistencia/listamsSisAdmin";
var anulardtAsistenciaUrl = contexto+"/rs/ctrldtAsistencia/anulardtAsistenciaList";
var reactivardtAsistenciaUrl = contexto+"/rs/ctrldtAsistencia/reactivardtAsistencia";
var currentserverdateUrl = contexto+"/rs/ctrltitulo/currentserverdate";
// MPINARES 24012023 - FIN

/**
 * 
 */
myapp = angular.module('MyApp');

myapp.config(function($routeProvider) {
	  $routeProvider
	  .when("/editar/:idAsistencia", {
		  templateUrl : "asistencia/editardtAsistencia.html",
		  controller : "ctrlListadtAsistencia"
	  })
	  .when("/nuevo", {
		  templateUrl : "asistencia/editardtAsistencia.html",
		  controller : "ctrlListadtAsistencia"
	  })
	  .otherwise({
		  templateUrl : "asistencia/verdtAsistencia.html",
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

myapp.controller('ctrlListadtAsistencia', ['$mdEditDialog', '$scope', '$timeout', '$http', '$mdDialog','$location','$routeParams', '$mdPanel',  function ($mdEditDialog, $scope, $timeout, $http, $mdDialog, $location, $routeParams, $mdPanel) {
	'use strict';
	 
	 $scope.limitOptions = [100, 500, 1000, 5000];
	 $scope.query = {
			    order: '',
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
	 $scope.refrescar= 0;//puribe
	 
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
	$scope.currentserverdate = null;
	
	$scope.getCurrentserverdate = function(){           
        var surl = currentserverdateUrl;
        $http.get(surl).then(function(res){
              var dato = res.data;
              $scope.currentserverdate = new Date(dato);
              $scope.filtro.fechaInicio=$scope.firstDate(new Date(dato));
              $scope.filtro.fechaFin= $scope.getLastDayOfMonth(new Date(dato));
              $scope.loaddtAsistencias();
//            $scope.firstDate($scope.getCurrentserverdate())
//            return $scope.currentserverdate;
        },
        function error(errResponse) {
              console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
              var dato = errResponse.data;
              if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
                    $mdDialog.show(
                                $mdDialog.alert()
                                .parent(angular.element(document.body))
                                .clickOutsideToClose(true)
                                .title('Obtener fecha servidor')
                                .textContent(dato.message)
                                .ariaLabel('ERROR')
                                .ok('OK')
                                .targetEvent(ev)
                    );
              }                            
        });                                                   
  };
  
//  $scope.getCurrentserverdate();

	$scope.loaddtAsistencias = function () {
		if($scope.isDate($scope.filtro.fechaInicio) && $scope.isDate($scope.filtro.fechaFin)){
			if($scope.filtro.fechaInicio.getTime()>$scope.filtro.fechaFin.getTime()){
				$mdDialog.show(
						$mdDialog.alert()
						.parent(angular.element(document.body))
						.clickOutsideToClose(true)
						.title('Buscar asistencias')
						.textContent("La fecha de Inicio no puede ser mayor a la fecha de fin")
						.ariaLabel('Lucky day')
						.ok('ACEPTAR')
				);
				return;
			}
		}
		
	    // $scope.promise = $timeout(function () {
	    	var surl = $scope.getURL();	    
	    	$scope.promise = $http.get(surl).then(function(res){
	    		 $scope.datos = res.data.data;
	    		 if($scope.datos.length>0){
	    			 if(res.data.contador>0)
	    	    		 $scope.total = res.data.contador;
	    	    		 var tiempoenBD = res.data.tiempoenBD;
	    	    		 var tiempoenproceso = res.data.tiempoenproceso;
	    	    		// $scope.creadtAsistencia = res.data.creamodifica; // PURIBE 15042024 - INICIO -->
//	    	    		 $scope.creadtAsistencia = res.data.creamodifica;
	    	    		 console.log("data " +$scope.datos.length+" DE "+ $scope.total);
	    	    		 console.log("Tiempo respuesta BD dtAsistencia " +tiempoenBD+" Tiempo en Paginar "+tiempoenproceso);
	    	    		 $scope.refrescar=0; //puribe
	    		 }else{
//	 				$mdDialog.show(
//							$mdDialog.alert()
//							.parent(angular.element(document.body))
//							.clickOutsideToClose(true)
//							.title('Buscar asistencias')
//							.textContent("No se encontraron resultados para la búsqueda")
//							.ariaLabel('Lucky day')
//							.ok('ACEPTAR')
//					);
//					return;
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
				$scope.refrescar=0; //puribe
			}			
			$scope.refrescar=0; //puribe
			if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
		            	$mdDialog.show(
						         $mdDialog.alert()
						        .parent(angular.element(document.body))
						        .clickOutsideToClose(true)
						        .title('Lista de asistencia técnica')
						        .textContent(dato.message)
						        .ariaLabel('ERROR')
						        .ok('ACEPTAR')
						    );
		            }
		        });			 
	     // }, 500);
	    	// MPINARES 24012023 - INICIO
	    	// /CARGAR COMPLEMENTOS
            $scope.loadlistaMsSedes();// SELECT
          // MPINARES 24012023 - FIN
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
				//MPINARES 14022024 - INICIO
				if(!$scope.isNull(valor) && ($scope.isDate(valor))){
					if(elprimero){
						elprimero=false;
						filtroparametro += "?"+key+"="+$scope.formatDateOnly(valor);
					}else{
						filtroparametro += "&"+key+"="+$scope.formatDateOnly(valor);
					}
				}
				//MPINARES 14022024 - FIN
				
				if($scope.refrescar == 1){
					if(elprimero){
						elprimero=false;
						filtroparametro += "?reload=1";
					}else{
						filtroparametro += "&reload=1";
					}	
				}else if($scope.refrescar == 0){
					if(elprimero){
					elprimero=false;
					filtroparametro += "?reload=0";
				}else{
					filtroparametro += "&reload=0";
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
		   // /CARGAR COMPLEMENTOS
                $scope.loadListaDtEntidadesIdEntidad();// SELECT
                $scope.loadListaPrtParametrosIdOrigen();// SELECT
                $scope.loadListaPrtParametrosIdModalidad();// SELECT
                $scope.loadListaPrtParametrosIdFinancia();// SELECT
              // MPINARES 24012023 - INICIO
                $scope.loadListaMsTemaIdTema();// SELECT
// $scope.loadListaMsSubtemaIdSubtema();//SELECT
              // MPINARES 24012023 - FIN
		  };
	  
// $scope.filtro ={
// idEntidad: null,
// idSede: null,
// fechaAsistencia: null,
// idUsuinterno: null,
// idSistAdm: null,
// idOrigen: null,
// idProgramacion: null,
// estado: null,
//  
// estado: null
// };
		  
		// MPINARES 24012023 - INICIO
		  
		//PURIBE 15042024  INICIO-->


			$scope.valorcrear;
			$scope.loadvalorcrear=function(){
				$http.get(valorcrearlUrl).then(function(res){
					$scope.valorcrear = res.data; 

					if ($scope.valorcrear.id==2)
					{
					$scope.creadtAsistencia = true;
					}
					else
					{
						$scope.creadtAsistencia=false; 
					}
				},
				function error(errResponse) {
					console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
				});
			};
			$scope.loadvalorcrear();
			//PURIBE 15042024  FIN-->
		  
			$scope.validateFormat = function(ev){
				let key;
				if (event.type === 'paste') {
					key = event.clipboardData.getData('text/plain');
				} else {
					key = event.keyCode;
					key = String.fromCharCode(key);
				}
				const regex = /[0-9]|\./;
				if (!regex.test(key)) {
					event.returnValue = false;
					if (event.preventDefault) {
						event.preventDefault();
					}
				}
			};
			
		  $scope.firstDate = function(dia){
			  dia.setDate(1);
			  dia.setMonth(dia.getMonth() + 1);
			  dia.setHours(0, 0, 0);
			  dia.setMilliseconds(0);
//			  dia.getTime();
//			  dia.getMilliseconds();
//			  var d = new Date(dia.getTime());
			  return dia; 
		  }
		  
		  $scope.firstDateNextMonth = function(dia){
			  const year = dia.getFullYear();
			  const month = dia.getMonth() + 2; 
			  dia = new Date(year, month, 0);
			  dia.setDate(1);
			  return dia; 
		  }
		  
		  $scope.getLastDayOfMonth = function(dia){
			  const year = dia.getFullYear();
			  const month = dia.getMonth() + 2; 
			  dia = new Date(year, month, 0);
			  dia.setHours(0, 0, 0);
			  dia.setMilliseconds(0);
//			  dia.getTime();
//			  dia.getMilliseconds();
//			  var d = new Date(dia.getTime());
			  return dia; 
		  }
		  
		//MPINARES 13022024 - INICIO
		  $scope.filtro ={
				  fechaInicio:$scope.firstDate(new Date()),
				  fechaFin: $scope.getLastDayOfMonth(new Date()),
				  idSedeTxt: null,
				  idEntidadTxt: null,
				  idAsistencia: null,
				  dniUserTxt: null,
				  usuExtTxt: null,
				  codEjecutora: null,
				  idUsuinternoTxt: null,
				  idSistAdmTxt: null,
				  idOrigenTxt: null,
				  estadoTxt: null,
				  idProgramacion: 121
			}; 
		//MPINARES 13022024 - FIN
	  
	  $scope.dato ={
			  ejecutora: null,
			  idproveeTxt: null,
			  idprovee: null
					}; 
	  
		$scope.formatDMY = function(dia){     
		    if(typeof(dia)=='undefined' || dia==null)
		    	return "";
		    var d = new Date(dia);
		    var dformat = [("00" + d.getDate()).slice(-2),
		    	("00" + (d.getMonth() + 1)).slice(-2),
		    		 d.getFullYear()			        	
		                ].join('/');
		    var dHour = [ ("00" + d.getHours()).slice(-2),
		    	("00" + d.getMinutes()).slice(-2),
		    	("00" + d.getSeconds()).slice(-2)				        	
		                ].join(':');				        
		 return dformat;
		};

	// MPINARES 24012023 - FIN
	  
	  $scope.seteestado = function(eestado) {
			if($scope.filtro.estado === eestado){
				$scope.filtro.estado = null;
			}else{
				$scope.filtro.estado = eestado;
			}
			$scope.loaddtAsistencias();
		};
	  
		//MPINARES 13022024 - INICIO
        $scope.refrescarvista = function(ev){
		  if(typeof(ev)=='undefined' || ev==null){
	          
         }else{
			 var keyCode = ev.which || ev.keyCode;
			    if (keyCode === 13) {
			    	$scope.refrescar=1;
			    	$scope.loaddtAsistencias();
			    }else if (keyCode === 1) {
			    	$scope.refrescar=1;
			    	$scope.loaddtAsistencias();
			    }
         }
//       	 var keyCode = ev.which || ev.keyCode;
//    		if (keyCode === 13) {
//    			$scope.loaddtAsistencias();
//    		}
		};
		//MPINARES 13022024 - FIN
		
		// MPINARES 24012023 - INICIO
        $scope.descargarvista = function(){
      	  return descargarvistaUrl + $scope.getURLParametros();
// if(typeof(ev)=='undefined' || ev==null){
// return "#";
// }else{
// return descargarvistaUrl;
// }
	    };
	    
	    $scope.dtAsistenciaAnular = {
				idAsistencia : null,
				detalle: null
			};
	    
	    $scope.setDtAsistenciaAnular = function(dtAsistenciaBk) {
//			  $scope.dtAsistenciaAnular.idAsistencia = dtAsistenciaBk.idAsistencia;
//			  $scope.dtAsistenciaAnular.detalle = dtAsistenciaBk.detalle;
	    	
	    	$scope.dtAsistenciaAnular.idAsistencia = dtAsistenciaBk.idAsistencia;
			$scope.dtAsistenciaAnular.idEntidad = dtAsistenciaBk.idEntidad;
			$scope.dtAsistenciaAnular.idSede = dtAsistenciaBk.idSede;
			$scope.dtAsistenciaAnular.fechaAsistencia = dtAsistenciaBk.fechaAsistencia;
            if(!$scope.isNull($scope.dtAsistenciaAnular.fechaAsistencia) && !isNaN($scope.dtAsistenciaAnular.fechaAsistencia)){
			    $scope.dtAsistenciaAnular.fechaAsistencia = new Date($scope.dtAsistenciaAnular.fechaAsistencia);
		     }
			$scope.dtAsistenciaAnular.idUsuinterno = dtAsistenciaBk.idUsuinterno;
			$scope.dtAsistenciaAnular.idSistAdm = dtAsistenciaBk.idSistAdm;
			$scope.dtAsistenciaAnular.idOrigen = dtAsistenciaBk.idOrigen;
			$scope.dtAsistenciaAnular.idProgramacion = dtAsistenciaBk.idProgramacion;
			$scope.dtAsistenciaAnular.estado = dtAsistenciaBk.estado;
			$scope.dtAsistenciaAnular.detalle = dtAsistenciaBk.detalle;
			$scope.dtAsistenciaAnular.idModalidad = dtAsistenciaBk.idModalidad;
			$scope.dtAsistenciaAnular.idFinancia = dtAsistenciaBk.idFinancia;
			$scope.dtAsistenciaAnular.fechaFinalizacion = dtAsistenciaBk.fechaFinalizacion;
            if(!$scope.isNull($scope.dtAsistenciaAnular.fechaFinalizacion) && !isNaN($scope.dtAsistenciaAnular.fechaFinalizacion)){
			    $scope.dtAsistenciaAnular.fechaFinalizacion = new Date($scope.dtAsistenciaAnular.fechaFinalizacion);
		     }
			$scope.dtAsistenciaAnular.fechaProgramada = dtAsistenciaBk.fechaProgramada;
            if(!$scope.isNull($scope.dtAsistenciaAnular.fechaProgramada) && !isNaN($scope.dtAsistenciaAnular.fechaProgramada)){
			    $scope.dtAsistenciaAnular.fechaProgramada = new Date($scope.dtAsistenciaAnular.fechaProgramada);
		    }
			$scope.dtAsistenciaAnular.fechaSoli = dtAsistenciaBk.fechaSoli;
            if(!$scope.isNull($scope.dtAsistenciaAnular.fechaSoli) && !isNaN($scope.dtAsistenciaAnular.fechaSoli)){
			$scope.dtAsistenciaAnular.fechaSoli = new Date($scope.dtAsistenciaAnular.fechaSoli);
		        }
                        
            $scope.dtAsistenciaAnular.fechaSoliJUD = dtAsistenciaBk.fechaSoliJUD;
            if(!$scope.isNull($scope.dtAsistenciaAnular.fechaSoliJUD) && !isNaN($scope.dtAsistenciaAnular.fechaSoliJUD)){
			    $scope.dtAsistenciaAnular.fechaSoliJUD = new Date($scope.dtAsistenciaAnular.fechaSoliJUD);
		    }
            $scope.dtAsistenciaAnular.fechaProgramadaJUD = dtAsistenciaBk.fechaProgramadaJUD;
            if(!$scope.isNull($scope.dtAsistenciaAnular.fechaProgramadaJUD) && !isNaN($scope.dtAsistenciaAnular.fechaProgramadaJUD)){
			    $scope.dtAsistenciaAnular.fechaProgramadaJUD = new Date($scope.dtAsistenciaAnular.fechaProgramadaJUD);
		        }
            $scope.dtAsistenciaAnular.codEjecutora = dtAsistenciaBk.codEjecutora;
            $scope.dtAsistenciaAnular.dtAsistenciaTemasBkJSss = dtAsistenciaBk.dtAsistenciaTemasBkJSss;
            if(dtAsistenciaBk.dtAsistenciaTemasBkJSss!=null && dtAsistenciaBk.dtAsistenciaTemasBkJSss.length>0){
            				$scope.datoAsistenciaTema = $scope.dtAsistenciaAnular.dtAsistenciaTemasBkJSss;			
            }
                        // ADICIONALES
	        $scope.dtAsistenciaAnular.idEntidadTxt = dtAsistenciaBk.idEntidadTxt;
			$scope.dtAsistenciaAnular.idSedeTxt = dtAsistenciaBk.idSedeTxt;
			$scope.dtAsistenciaAnular.idUsuinternoTxt = dtAsistenciaBk.idUsuinternoTxt;
			$scope.dtAsistenciaAnular.idSistAdmTxt = dtAsistenciaBk.idSistAdmTxt;
			$scope.dtAsistenciaAnular.idOrigenTxt = dtAsistenciaBk.idOrigenTxt;
			$scope.dtAsistenciaAnular.idProgramacionTxt = dtAsistenciaBk.idProgramacionTxt;
			$scope.dtAsistenciaAnular.estadoTxt = dtAsistenciaBk.estadoTxt;
			$scope.dtAsistenciaAnular.idModalidadTxt = dtAsistenciaBk.idModalidadTxt;
			$scope.dtAsistenciaAnular.idFinanciaTxt = dtAsistenciaBk.idFinanciaTxt;
//			$scope.dtAsistenciaAnular.editopcion = dtAsistenciaBk.dtAsistenciaACL.editopcion;
	    	
				
			};
	    $scope.cleardtAsistenciaAnular = function(){
//		    $scope.dtAsistenciaAnular.idAsistencia = null;
//		    $scope.dtAsistenciaAnular.detalle = null;
	    	
	    	$scope.dtAsistenciaAnular.idAsistencia = null;
		    $scope.dtAsistenciaAnular.idEntidad = null;
		    $scope.dtAsistenciaAnular.idSede = null;
		    $scope.dtAsistenciaAnular.fechaAsistencia = new Date();
		    $scope.dtAsistenciaAnular.idUsuinterno = null;
		    $scope.dtAsistenciaAnular.idSistAdm = null;
		    $scope.dtAsistenciaAnular.idOrigen = null;
		    $scope.dtAsistenciaAnular.idProgramacion = null;
		    $scope.dtAsistenciaAnular.estado = null;
		    $scope.dtAsistenciaAnular.detalle = null;
		    $scope.dtAsistenciaAnular.idModalidad = null;
		    $scope.dtAsistenciaAnular.idFinancia = null;
		    $scope.dtAsistenciaAnular.fechaFinalizacion = new Date();
		    $scope.dtAsistenciaAnular.fechaProgramada = new Date();
		    $scope.dtAsistenciaAnular.fechaSoli = new Date();
                    // ADICIONALES
	        $scope.dtAsistenciaAnular.idEntidadTxt = null;
			$scope.dtAsistenciaAnular.idSedeTxt = null;
			$scope.dtAsistenciaAnular.idUsuinternoTxt = null;
			$scope.dtAsistenciaAnular.idSistAdmTxt = null;
			$scope.dtAsistenciaAnular.idOrigenTxt = null;
			$scope.dtAsistenciaAnular.idProgramacionTxt = null;
			$scope.dtAsistenciaAnular.estadoTxt = null;
			$scope.dtAsistenciaAnular.idModalidadTxt = null;
			$scope.dtAsistenciaAnular.idFinanciaTxt = null;

//		    $scope.dtAsistenciaAnular.editopcion = 1;
		    
	    };
	    
	    $scope.selectedAsist = [];
		  $scope.selection = function(item){
//			  	$scope.cleardtAsistenciaAnular();
//		    	$scope.setDtAsistenciaAnular(item);
			    if(item.checked){
//			    	$scope.selectedAsist.push($scope.dtAsistenciaAnular);
			    	$scope.selectedAsist.push({
			    		idAsistencia : item.idAsistencia,
			    		idEntidad : item.idEntidad,
			    		idSede : item.idSede,
			    		fechaAsistencia : item.fechaAsistencia,
			    		idUsuinterno : item.idUsuinterno,
			    		idSistAdm : item.idSistAdm,
			    		idOrigen : item.idOrigen,
			    		idProgramacion : item.idProgramacion,
			    		estado : item.estado,
			    		detalle : item.detalle,
			    		idModalidad : item.idModalidad,
			    		idFinancia : item.idFinancia,
			    		fechaFinalizacion : item.fechaFinalizacion,
			    		fechaProgramada : item.fechaProgramada,
			    		fechaSoli : item.fechaSoli,
			    		fechaSoliJUD : item.fechaSoliJUD,
			    		fechaProgramadaJUD : item.fechaProgramadaJUD,
			    		codEjecutora : item.codEjecutora,
			    		dtAsistenciaTemasBkJSss : item.dtAsistenciaTemasBkJSss,
			    		idEntidadTxt : item.idEntidadTxt,
			    		idSedeTxt : item.idSedeTxt,
			    		idUsuinternoTxt : item.idUsuinternoTxt,
			    		idSistAdmTxt : item.idSistAdmTxt,
			    		idOrigenTxt : item.idOrigenTxt,
			    		idProgramacionTxt : item.idProgramacionTxt,
			    		estadoTxt : item.estadoTxt,
			    		idModalidadTxt : item.idModalidadTxt,
			    		idFinanciaTxt : item.idFinanciaTxt
		                })
			    }else{
			    	$scope.selectedAsist = $scope.selectedAsist.filter(val => val.idAsistencia !== item.idAsistencia);
			    }
			    console.log('lista: '+ $scope.selectedAsist); 
			  };
		  
		  $scope.showConfirmAnularAsistencia = function(ev) {
			  if($scope.selectedAsist.length<1){
					$mdDialog.show(
							$mdDialog.alert()
							.parent(angular.element(document.body))
							.clickOutsideToClose(true)
							.title('Anular registros')
							.textContent("No se han seleccionado registros.")
							.ariaLabel('Lucky day')
							.ok('ACEPTAR')
							.targetEvent(ev)
					);
				}else{
					var confirm = $mdDialog.confirm()
	                .title('Anular registros')
	                .textContent('¿Está seguro que desea anular los registros seleccionados?')
	                .ariaLabel('Lucky day')
	                .targetEvent(ev)
	                .ok('Si')
	                .cancel('No');

	              $mdDialog.show(confirm).then(function () {
	                $scope.status = 'SI';
	                $scope.anulardtAsistenciaList(ev, $scope.selectedAsist);
	              }, function () {
	                $scope.status = 'NO';
	              });
				}
          };
          
          $scope.anulardtAsistenciaList = function(ev, selectedAsist){		
			    ev.target.disabled = true;
			    var datainsert = angular.toJson(selectedAsist);
				console.log("datainsert = "+datainsert);	
			$http.post(anulardtAsistenciaUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
					var dato1 = res.data;
// var instrumentos = $scope.datos;
// var index = $scope.datos.findIndex(obj => obj.idAsistTema ===
// dato.idAsistTema);
// console.log("INDEX " + index);
// if(instrumentos.length>index){
// instrumentos.splice(index, 1);
// $scope.datos = instrumentos;
// $scope.total = $scope.datos.length;
// }
			        $scope.loaddtAsistencias();
				},
				function error(errResponse) {
		            console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		            var dato = errResponse.data;
		            if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
		            	$mdDialog.show(
				         $mdDialog.alert()
				        .parent(angular.element(document.body))
				        .clickOutsideToClose(true)
				        .title('Anular asistencias')
				        .textContent(dato.message)
				        .ariaLabel('ERROR')
				        .ok('ACEPTAR')
				        .targetEvent(ev)
					   );
		            }
		        });			        			        	
	      	ev.target.disabled = false;
		 };
		 
		 
		 $scope.showConfirmReactivarAsistencia = function(ev, dtAsistenciaBk) {
			    var confirm = $mdDialog.confirm()
			      .title('Reactivar servicio')
			      .textContent('¿Estás seguro que desea reactivar el servicio?')
			      .ariaLabel('Lucky day')
			      .targetEvent(ev)
			      .ok('Si')
			      .cancel('No');

			    $mdDialog.show(confirm).then(function () {
			      $scope.status = 'SI';
			      $scope.reactivardtAsistencia(ev, dtAsistenciaBk);
			    }, function () {
			      $scope.status = 'NO';
			    });
			  };
			  
			  
			  $scope.reactivardtAsistencia = function(ev,dtAsistenciaBk){		
				    ev.target.disabled = true;
				    $scope.setDtAsistenciaModelo(dtAsistenciaBk);
				    var datainsert = angular.toJson($scope.dtAsistenciaModelo);
		 			console.log("datainsert = "+datainsert);	
	        		$http.post(reactivardtAsistenciaUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
	        			//MPINARES 13022024 - INICIO
						var dato1 = res.data;
//						var instrumentos = $scope.datos;
//				        var index = $scope.datos.findIndex(obj => obj.idAsistencia === dato.idAsistencia);
//						console.log("INDEX " + index);
//				        if(instrumentos.length>index){
//				        	instrumentos.splice(index, 1);
//					        $scope.datos = instrumentos;
//					        $scope.total = $scope.datos.length;
//				        }	
						$scope.loaddtAsistencias();
						//MPINARES 13022024 - FIN	
					},
					function error(errResponse) {
			            console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
			            var dato = errResponse.data;
			            if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
			            	$mdDialog.show(
					         $mdDialog.alert()
					        .parent(angular.element(document.body))
					        .clickOutsideToClose(true)
					        .title('Reactivar servicio')
					        .textContent(dato.message)
					        .ariaLabel('ERROR')
					        .ok('ACEPTAR')
					        .targetEvent(ev)
						   );
			            }
			        });			        			        	
		        	ev.target.disabled = false;
			 };
		// MPINARES 24012023 - FIN

			 $scope.dtAsistenciaModelo = {
						idAsistencia : null,
						fechaAsistencia: null,
						detalle: null,
						idUsuinterno: null,
						idEntidad: null,
						idOrigen: 127,
						idProgramacion: 121,
						idModalidad: null,
						idSede: null,
						idSistAdm: null,
						idFinancia: null,
						fechaFinalizacion: null,
						fechaProgramada: null,
						fechaSoli: null,
						// MPINARES 24012023 - INICIO
						fechaSoliJUD : $scope.firstDateNextMonth(new Date()),
						fechaProgramadaJUD : $scope.firstDateNextMonth(new Date()),
						vistaProgramado : true,
						codEjecutora  : null,
						checked : false,
						// MPINARES 24012023 - FIN
			                        // ADICIONALES
				        estadoTxt: null,
						idUsuinternoTxt: null,
						idEntidadTxt: null,
						idOrigenTxt: "OFERTA",
						idProgramacionTxt: null,
						idModalidadTxt: null,
						idSedeTxt: null,
						idSistAdmTxt: null,
						idFinanciaTxt: null,

					    editopcion: 1
					};
	  
	  $scope.cleardtAsistencia = function(){
		    $scope.dtAsistenciaModelo.idAsistencia = null;
		    $scope.dtAsistenciaModelo.idEntidad = null;
		    $scope.dtAsistenciaModelo.idSede = null;
		    $scope.dtAsistenciaModelo.fechaAsistencia = new Date();$scope.dtAsistenciaModelo.idUsuinterno = null;
		    $scope.dtAsistenciaModelo.idSistAdm = null;
		    $scope.dtAsistenciaModelo.idOrigen = null;
		    $scope.dtAsistenciaModelo.idProgramacion = null;
		    $scope.dtAsistenciaModelo.estado = null;
		    $scope.dtAsistenciaModelo.detalle = null;
		    $scope.dtAsistenciaModelo.idModalidad = null;
		    $scope.dtAsistenciaModelo.idFinancia = null;
		    $scope.dtAsistenciaModelo.fechaFinalizacion = new Date();$scope.dtAsistenciaModelo.fechaProgramada = new Date();$scope.dtAsistenciaModelo.fechaSoli = new Date();
                    // ADICIONALES
	            $scope.dtAsistenciaModelo.idEntidadTxt = null;
$scope.dtAsistenciaModelo.idSedeTxt = null;
$scope.dtAsistenciaModelo.idUsuinternoTxt = null;
$scope.dtAsistenciaModelo.idSistAdmTxt = null;
$scope.dtAsistenciaModelo.idOrigenTxt = null;
$scope.dtAsistenciaModelo.idProgramacionTxt = null;
$scope.dtAsistenciaModelo.estadoTxt = null;
$scope.dtAsistenciaModelo.idModalidadTxt = null;
$scope.dtAsistenciaModelo.idFinanciaTxt = null;

		    $scope.dtAsistenciaModelo.editopcion = 1;
	 } 
	 
	  $scope.setDtAsistenciaModelo = function(dtAsistenciaBk) {
		  $scope.dtAsistenciaModelo.idAsistencia = dtAsistenciaBk.idAsistencia;
			$scope.dtAsistenciaModelo.idEntidad = dtAsistenciaBk.idEntidad;
			$scope.dtAsistenciaModelo.idSede = dtAsistenciaBk.idSede;
			$scope.dtAsistenciaModelo.fechaAsistencia = dtAsistenciaBk.fechaAsistencia;
                        if(!$scope.isNull($scope.dtAsistenciaModelo.fechaAsistencia) && !isNaN($scope.dtAsistenciaModelo.fechaAsistencia)){
			    $scope.dtAsistenciaModelo.fechaAsistencia = new Date($scope.dtAsistenciaModelo.fechaAsistencia);
		        }
$scope.dtAsistenciaModelo.idUsuinterno = dtAsistenciaBk.idUsuinterno;
			$scope.dtAsistenciaModelo.idSistAdm = dtAsistenciaBk.idSistAdm;
			$scope.dtAsistenciaModelo.idOrigen = dtAsistenciaBk.idOrigen;
			$scope.dtAsistenciaModelo.idProgramacion = dtAsistenciaBk.idProgramacion;
			$scope.dtAsistenciaModelo.estado = dtAsistenciaBk.estado;
			$scope.dtAsistenciaModelo.detalle = dtAsistenciaBk.detalle;
			$scope.dtAsistenciaModelo.idModalidad = dtAsistenciaBk.idModalidad;
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
                        
                        // MPINARES 24012023 - INICIO
                        $scope.dtAsistenciaModelo.fechaSoliJUD = dtAsistenciaBk.fechaSoliJUD;
                        if(!$scope.isNull($scope.dtAsistenciaModelo.fechaSoliJUD) && !isNaN($scope.dtAsistenciaModelo.fechaSoliJUD)){
			    $scope.dtAsistenciaModelo.fechaSoliJUD = new Date($scope.dtAsistenciaModelo.fechaSoliJUD);
		        }
                        $scope.dtAsistenciaModelo.fechaProgramadaJUD = dtAsistenciaBk.fechaProgramadaJUD;
                        if(!$scope.isNull($scope.dtAsistenciaModelo.fechaProgramadaJUD) && !isNaN($scope.dtAsistenciaModelo.fechaProgramadaJUD)){
			    $scope.dtAsistenciaModelo.fechaProgramadaJUD = new Date($scope.dtAsistenciaModelo.fechaProgramadaJUD);
		        }
                        $scope.dtAsistenciaModelo.codEjecutora = dtAsistenciaBk.codEjecutora;
                        
            			$scope.dtAsistenciaModelo.dtAsistenciaTemasBkJSss = dtAsistenciaBk.dtAsistenciaTemasBkJSss;
            			if(dtAsistenciaBk.dtAsistenciaTemasBkJSss!=null && dtAsistenciaBk.dtAsistenciaTemasBkJSss.length>0){
            				$scope.datoAsistenciaTema = $scope.dtAsistenciaModelo.dtAsistenciaTemasBkJSss;			
//            				$scope.datoAsistenciaTema = [];
//            				for(var i = 0; i < dtAsistenciaBk.dtAsistenciaTemasBkJSss.length; i++)
//            				{
//            					var asistenciaTema = dtAsistenciaBk.dtAsistenciaTemasBkJSss[i];
//            					$scope.addAsistTema(asistenciaTema, i, dtAsistenciaBk.dtAsistenciaTemasBkJSss.length);
//            				}
            			}
                      // MPINARES 24012023 - FIN

                        // ADICIONALES
	                $scope.dtAsistenciaModelo.idEntidadTxt = dtAsistenciaBk.idEntidadTxt;
$scope.dtAsistenciaModelo.idSedeTxt = dtAsistenciaBk.idSedeTxt;
$scope.dtAsistenciaModelo.idUsuinternoTxt = dtAsistenciaBk.idUsuinternoTxt;
$scope.dtAsistenciaModelo.idSistAdmTxt = dtAsistenciaBk.idSistAdmTxt;
$scope.dtAsistenciaModelo.idOrigenTxt = dtAsistenciaBk.idOrigenTxt;
$scope.dtAsistenciaModelo.idProgramacionTxt = dtAsistenciaBk.idProgramacionTxt;
$scope.dtAsistenciaModelo.estadoTxt = dtAsistenciaBk.estadoTxt;
$scope.dtAsistenciaModelo.idModalidadTxt = dtAsistenciaBk.idModalidadTxt;
$scope.dtAsistenciaModelo.idFinanciaTxt = dtAsistenciaBk.idFinanciaTxt;

			$scope.dtAsistenciaModelo.editopcion = dtAsistenciaBk.dtAsistenciaACL.editopcion;
			$scope.dtAsistenciaModelo.addEntidad = dtAsistenciaBk.dtAsistenciaACL.addEntidad;
		}
	  
	// MPINARES 24012023 - INICIO
	  $scope.addAsistTema = function (asistenciaTema, i, size) {
	    	var addx=false;
	    	if(i+1==size){
	    		addx= true;
      }else{
      	addx= false;
      }
	        $scope.datoAsistenciaTema.push({
	        	contador: i+ 1, 
	        	idAsistTema: asistenciaTema.idAsistTema,
	        	idTema: asistenciaTema.idTema, 
	        	idSubtema: asistenciaTema.idSubtema, 
	        	detalle: asistenciaTema.detalle,            
	            add: addx
	            
	        })

	    }
	// MPINARES 24012023 - FIN
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
		// MPINARES 24012023 - INICIO
		  if($scope.isArray($scope.datoAsistenciaTema)){
				if($scope.datoAsistenciaTema.length>0){
					$scope.dtAsistenciaModelo.dtAsistenciaTemasBkJSss = $scope.datoAsistenciaTema;
				}}
		// MPINARES 24012023 - FIN
				    ev.target.disabled = true;
				    var datainsert = angular.toJson($scope.dtAsistenciaModelo);
		 			console.log("datainsert = "+datainsert);	
		        		$http.post(insertdtAsistenciaUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
							var dato = res.data;

// $scope.datos.push(dato);
		    				$scope.total = $scope.datos.length;
		    				
		    				$scope.setDtAsistenciaModelo(dato);
		    				
		    				$mdDialog.show(
							         $mdDialog.alert()
							        .parent(angular.element(document.body))
							        .clickOutsideToClose(true)
							        .title('Guardar asistencia técnica')
							        .textContent("Los datos se guardaron correctamente")
							        .ariaLabel('ERROR')
							        .ok('ACEPTAR')
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
			if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
				            	$mdDialog.show(
								         $mdDialog.alert()
								        .parent(angular.element(document.body))
								        .clickOutsideToClose(true)
								        .title('Guardar asistencia técnica')
								        .textContent(dato.message)
								        .ariaLabel('ERROR')
								        .ok('ACEPTAR')
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
		 			console.log("Eliminar = "+datainsert);	
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
			            var dato;
			if(errResponse && errResponse.data){
			   console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
			   dato = errResponse.data;
			}
			if(errResponse.message){ 
				console.log("Message " + errResponse.message);
				dato = errResponse.message;
			}			
			if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
			            	$mdDialog.show(
					         $mdDialog.alert()
					        .parent(angular.element(document.body))
					        .clickOutsideToClose(true)
					        .title('Eliminar asistencia técnica')
					        .textContent(dato.message)
					        .ariaLabel('ERROR')
					        .ok('ACEPTAR')
					        .targetEvent(ev)
						   );
			            }
			        });			        			        	
		        	ev.target.disabled = false;
			 };

            $scope.activardtAsistencia = function(ev,dtAsistenciaBk){		
				    ev.target.disabled = true;
				    $scope.setDtAsistenciaModelo(dtAsistenciaBk);
				    var datainsert = angular.toJson($scope.dtAsistenciaModelo);
		 			console.log("Activar = "+datainsert);	
	        		$http.post(activardtAsistenciaUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
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
			            var dato;
			if(errResponse && errResponse.data){
			   console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
			   dato = errResponse.data;
			}
			if(errResponse.message){ 
				console.log("Message " + errResponse.message);
				dato = errResponse.message;
			}			
			if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
			            	$mdDialog.show(
					         $mdDialog.alert()
					        .parent(angular.element(document.body))
					        .clickOutsideToClose(true)
					        .title('Activar asistencia técnica')
					        .textContent(dato.message)
					        .ariaLabel('ERROR')
					        .ok('ACEPTAR')
					        .targetEvent(ev)
						   );
			            }
			        });			        			        	
		        	ev.target.disabled = false;
			 };

            $scope.eliminarListadtAsistencia = function(ev){		
				    ev.target.disabled = true;
                                   
                                    if(!$scope.isArray($scope.selected) || $scope.selected.length<=0){
				    	$mdDialog.show(
								$mdDialog.alert()
								.parent(angular.element(document.body))
								.clickOutsideToClose(true)
								.title('Eliminar')
								.textContent("No se han seleccionado registros para eliminar... ")
								.ariaLabel('ERROR')
								.ok('ACEPTAR')
								.targetEvent(ev)
						);
				    	ev.target.disabled = false;
					return;
				    }else{
                                        for (var i = 0; i < $scope.selected.length; i++) {
				             listaids.push($scope.selected[i].idAsistencia);
			                 }
                                    } 
				    
				    var datainsert = angular.toJson(listaids);
		 			console.log("Elimiar = "+datainsert);	
	        		$http.post(eliminarListadtAsistenciaUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
						var dato = res.data;
						$mdDialog.show(
					$mdDialog.alert()
					.parent(angular.element(document.body))
					.clickOutsideToClose(true)
					.title('Eliminar registros')
					.textContent(dato)
					.ariaLabel('Eliminar')
					.ok('ACEPTAR')
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
			if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
			            	$mdDialog.show(
					         $mdDialog.alert()
					        .parent(angular.element(document.body))
					        .clickOutsideToClose(true)
					        .title('Eliminar asistencia técnica')
					        .textContent(dato.message)
					        .ariaLabel('ERROR')
					        .ok('ACEPTAR')
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
			            var dato;
			if(errResponse && errResponse.data){
			   console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
			   dato = errResponse.data;
			}
			if(errResponse.message){ 
				console.log("Message " + errResponse.message);
				dato = errResponse.message;
			}			
			if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
			            	$mdDialog.show(
					         $mdDialog.alert()
					        .parent(angular.element(document.body))
					        .clickOutsideToClose(true)
					        .title('Cargar asistencia técnica')
					        .textContent(dato.message)
					        .ariaLabel('ERROR')
					        .ok('ACEPTAR')
						   );
			            }			           
			        });			        			        	
			 };
			 
		$scope.showConfirm = function(ev, dtAsistenciaBk) {
				    var confirm = $mdDialog.confirm()
				      .title('Activar asistencia técnica')
				      .textContent('¿Está usted seguro de activar el registro?')
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

                $scope.showConfirmActivar = function(ev, dtAsistenciaBk) {
				    var confirm = $mdDialog.confirm()
				      .title('Activar asistencia técnica')
				      .textContent('¿Está usted seguro de activar el registro?')
				      .ariaLabel('Lucky day')
				      .targetEvent(ev)
				      .ok('Si')
				      .cancel('No');

				    $mdDialog.show(confirm).then(function () {
				      $scope.status = 'SI';
				      $scope.activardtAsistencia(ev, dtAsistenciaBk);
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
								.textContent("No se han seleccionado registros para eliminar... ")
								.ariaLabel('ERROR')
								.ok('ACEPTAR')
								.targetEvent(ev)
						);
				    	return;
				    }else{
                                       tamanio = $scope.selected.length;
                                    }

				    var confirm = $mdDialog.confirm()
				      .title('Eliminar Asistencia Técnica')
				      .textContent('¿Está usted seguro de eliminar los '+tamanio+' registros seleccionados?')
				      .ariaLabel('Lucky day')
				      .targetEvent(ev)
				      .ok('Si')
				      .cancel('No');

				    $mdDialog.show(confirm).then(function () {
				      $scope.status = 'SI';
				      $scope.eliminarListadtAsistencia(ev);
				    }, function () {
				      $scope.status = 'NO';
				    });
				  };	
				  
				// MPINARES 24012023 - INICIO
				  $scope.buscarxcodEjec = function(dato){
					  	
					  if($scope.isNull(dato.codEjecutora)){
			                $mdDialog.show(
				                    $mdDialog.alert()
				                    .parent(angular.element(document.body))
				                    .clickOutsideToClose(true)
				                    .title('Entidad')
				                    .textContent('No se ha encontrado la entidad con código ejecutora 0')
				                    .ariaLabel('Lucky day')
				                    .ok('ACEPTAR')
				                );
			                return;
					  }
					  
					  
				        console.log('codigoEjecutora: '+ dato.codEjecutora);
				        $scope.dlgInstmsInstitucionesDtoss=[];
				        $scope.selectedItem = null;
				        $scope.searchText = null;
				        var surl = buscarCodEjecUrl + dato.codEjecutora; 
				        console.log('surl: '+ surl);
				        $scope.dlgInstpromise = $http.get(surl).then(function(res){
				            var resData = res.data;
				            if(resData.length==1){
				                var institucion = resData[0];
				                console.log(JSON.stringify(institucion));
				                dato.codEjecutora = institucion.codEjec; 
// dato.ruc = institucion.ruc;
				                dato.idEntidadTxt = institucion.razSocialUbigeo;
				                dato.idEntidad = institucion.idEntidad;
				                console.log('modelo', dato);

				                $scope.selectedItem = institucion;
// $scope.ctrlViaticosId.selectedItem = institucion;
				            } else if(resData.length>1){
				                $scope.dlgInstmsInstitucionesDtoss = resData;
				                $scope.dlgInsttotal = resData.length;
// $scope.showdlgPersonasDialog(resData);
				                $scope.showdlgInstDialog(resData);  
				            }
				        }, function error(errResponse) {
				            console.log("Buscar x CodEjec data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse.statusText + " xhrStat " + errResponse.xhrStatus);
				            var errData = errResponse.data;
				            if(errData && typeof(errData.message) != 'undefined'){
				                $mdDialog.show(
				                    $mdDialog.alert()
				                    .parent(angular.element(document.body))
				                    .clickOutsideToClose(true)
				                    .title('Entidad')
				                    .textContent(errData.message)
				                    .ariaLabel('ERROR')
				                    .ok('ACEPTAR')
				                    .targetEvent(errData)
				                );
				                dato.idEntidadTxt = null;
				                dato.idEntidad = null;
				            }
				        });
				    };
				    
				    $scope.datoAsistenciaTema = [];
//						{contador: 1, idAsistTema: "", idTema: "", idSubtema: "", detalle:"", add: true}
//				    ];
				    
					  $scope.dtAsistenciaTemasModelo = {
								idAsistTema : null,
								detalle: null,
								idAsistencia: null,
								idTema: null,
								idSubtema: null,
								idUsuinterno: null,
								idSistAdmi: null,
								
					                        // ADICIONALES
						        idAsistenciaTxt: null,
								idTemaTxt: null,
								idSubtemaTxt: null,
								estadoTxt: null
							};
					  
					  $scope.cleardtAsistenciaTemas = function(){
						    $scope.dtAsistenciaTemasModelo.idAsistTema = null;
						    $scope.dtAsistenciaTemasModelo.detalle = null;
						    $scope.dtAsistenciaTemasModelo.idAsistencia = null;
						    $scope.dtAsistenciaTemasModelo.idTema = null;
						    $scope.dtAsistenciaTemasModelo.idSubtema = null;
						    $scope.dtAsistenciaTemasModelo.idUsuinterno = null;
						    $scope.dtAsistenciaTemasModelo.idSistAdmi = null;
						    
				                    // ADICIONALES
					        $scope.dtAsistenciaTemasModelo.idAsistenciaTxt = null;
							$scope.dtAsistenciaTemasModelo.idTemaTxt = null;
							$scope.dtAsistenciaTemasModelo.idSubtemaTxt = null;
							$scope.dtAsistenciaTemasModelo.estadoTxt = null;
					 } 
					  
					  $scope.setDtAsistenciaTemasModelo = function(dtAsistenciaTemasBk) {
						  $scope.dtAsistenciaTemasModelo.idAsistTema = dtAsistenciaTemasBk.idAsistTema;
							$scope.dtAsistenciaTemasModelo.detalle = dtAsistenciaTemasBk.detalle;
							$scope.dtAsistenciaTemasModelo.idAsistencia = dtAsistenciaTemasBk.idAsistencia;
							$scope.dtAsistenciaTemasModelo.idTema = dtAsistenciaTemasBk.idTema;
							$scope.dtAsistenciaTemasModelo.idSubtema = dtAsistenciaTemasBk.idSubtema;
							$scope.dtAsistenciaTemasModelo.idUsuinterno = dtAsistenciaTemasBk.idUsuinterno;
							$scope.dtAsistenciaTemasModelo.idSistAdmi = dtAsistenciaTemasBk.idSistAdmi;
							// ADICIONALES
					        $scope.dtAsistenciaTemasModelo.idAsistenciaTxt = dtAsistenciaTemasBk.idAsistenciaTxt;
							$scope.dtAsistenciaTemasModelo.idTemaTxt = dtAsistenciaTemasBk.idTemaTxt;
							$scope.dtAsistenciaTemasModelo.idSubtemaTxt = dtAsistenciaTemasBk.idSubtemaTxt;
							$scope.dtAsistenciaTemasModelo.estadoTxt = dtAsistenciaTemasBk.estadoTxt;
						}
				    
					$scope.settingFlagAddAndRemoveDetAsistenciaTema = function () {
				        let sizeTemas = $scope.datoAsistenciaTema.length;
				        $scope.datoAsistenciaTema.map(function (obj) {

				        	if (obj.contador == sizeTemas) {
				                obj.add = true;
				            } else {
				                obj.add = false;
				            }

				        });
				    }
					
					$scope.removeAsistenciaTema = function (ev,dato) {
						$scope.showConfirmDeleteAsistenciaTema(ev, dato);		
//				    	if(dato.idAsistTema!=null && dato.idAsistTema>0){
//				    		$scope.showConfirmDeleteAsistenciaTema(ev, dato);
//				    	}else{
//				    		$scope.datoAsistenciaTema = $scope.datoAsistenciaTema.filter(val => val.idAsistTema !== dato.idAsistTema);
//				    	} 
				    }
					
					$scope.showConfirmDeleteAsistenciaTema = function(ev, dtAsistenciaTemasBk) {
					    var confirm = $mdDialog.confirm()
					      .title('Temas agendados')
					      .textContent('¿Estás seguro que deseas eliminar el registro?')
					      .ariaLabel('Lucky day')
					      .targetEvent(ev)
					      .ok('Si')
					      .cancel('No');

					    $mdDialog.show(confirm).then(function () {
					    	if(dtAsistenciaTemasBk.idAsistTema!=null && dtAsistenciaTemasBk.idAsistTema>0){
					    		$scope.status = 'SI';
							      $scope.cleardtAsistenciaTemas();
							      $scope.setDtAsistenciaTemasModelo(dtAsistenciaTemasBk);
							      $scope.eliminardtAsistenciaTemas(ev, $scope.dtAsistenciaTemasModelo);
//							      $scope.datoAsistenciaTema = [];
					    	}else{
					    		$scope.datoAsistenciaTema = $scope.datoAsistenciaTema.filter(val => val.idAsistTema !== dtAsistenciaTemasBk.idAsistTema);
					    	}
					      
					    }, function () {
					      $scope.status = 'NO';
					    });
					  };
					  
					  $scope.eliminardtAsistenciaTemas = function(ev,dtAsistenciaTemasBk){		
						    ev.target.disabled = true;
						    var datainsert = angular.toJson(dtAsistenciaTemasBk);
							console.log("datainsert = "+datainsert);	
						$http.post(eliminardtAsistenciaTemasUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
								var dato = res.data;
								var instrumentos = $scope.datos;
						        var index = $scope.datos.findIndex(obj => obj.idAsistTema === dato.idAsistTema);
								console.log("INDEX " + index);
						        if(instrumentos.length>index){
						        	instrumentos.splice(index, 1);
							        $scope.datos = instrumentos;
							        $scope.total = $scope.datos.length;
						        }	
						        $scope.editdtAsistencia();
							},
							function error(errResponse) {
					            console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
					            var dato = errResponse.data;
					            if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
					            	$mdDialog.show(
							         $mdDialog.alert()
							        .parent(angular.element(document.body))
							        .clickOutsideToClose(true)
							        .title('Eliminar registro')
							        .textContent(dato.message)
							        .ariaLabel('ERROR')
							        .ok('ACEPTAR')
							        .targetEvent(ev)
								   );
					            }
					        });			        			        	
				      	ev.target.disabled = false;
					 };
					
					 $scope.nuevoAsistenciaTemas= function () {
					        $scope.datoAsistenciaTema.push({
					        	contador: $scope.datoAsistenciaTema.length + 1,
					        	idAsistTema: "",
					        	idTema: "", 
					        	idSubtema: "", 
					        	detalle: "", 	           
					            add: false
					        })

					        $scope.settingFlagAddAndRemoveDetAsistenciaTema();
					    }
					 
					// SELECT INI
				        $scope.listaMsTemaIdTema=[];
					$scope.loadListaMsTemaIdTema=function(){
						$http.get(listaMsTemaidTemaIdTemaUrl).then(function(res){
							$scope.listaMsTemaIdTema = res.data; 
						},
						function error(errResponse) {
							console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
						});
					};
				        $scope.changeIdTema=function(idTema){
				          // /BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
				        	$scope.loadListaMsSubtemaIdSubtema(idTema);
				        	var temaText = $scope.listaMsTemaIdTema.find(temaText => temaText.id === idTema );
//				        	var objEncontrado = $scope.listaMsTemaIdTema.find(o => o.id === idTema);
				        	$scope.asistenciaTemasmodelo.idTemaTxt=temaText.valor;
				        }
				        $scope.$watch('dtConsultasModelo.idTema', function (newValue, oldValue) {
						console.log('dtConsultasModelo.idTema ' + newValue+' -- '+oldValue);
						// CARGAR DATOS DEL SIGUIENTE SELECT
					});
				// SELECT FIN
				        
				// SELECT INI
				        $scope.listaMsSubtemaIdSubtema=[];
					$scope.loadListaMsSubtemaIdSubtema=function(idTema){
						$scope.listaMsSubtemaIdSubtema=[];
						if(!$scope.isNumber(idTema))
							return;
						
						var surl = listaMsSubtemaidSubtemaIdSubtemaUrl+idTema;
						$http.get(surl).then(function(res){
							$scope.listaMsSubtemaIdSubtema = res.data; 
						},
						function error(errResponse) {
							console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
						});
					};
				        $scope.changeIdSubtema=function(idSubtema){
				          // /BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
				        	var subtemaText = $scope.listaMsSubtemaIdSubtema.find(subtemaText => subtemaText.id === idSubtema );
				        	$scope.asistenciaTemasmodelo.idSubtemaTxt=subtemaText.valor;
				        }
				        $scope.$watch('dtConsultasModelo.idSubtema', function (newValue, oldValue) {
						console.log('dtConsultasModelo.idSubtema ' + newValue+' -- '+oldValue);
						// CARGAR DATOS DEL SIGUIENTE SELECT
					});
				// SELECT FIN
				        
				      // SELECT INI
				        $scope.listaMsSedes=[];
					$scope.loadlistaMsSedes=function(){
						$http.get(listaMsSedesUrl).then(function(res){
							$scope.listaMsSedes = res.data; 
						},
						function error(errResponse) {
							console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
						});
					};
				        $scope.changeIdSede=function(){
				          // /BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
				        }
				        $scope.$watch('dtAsistenciaModelo.idSede', function (newValue, oldValue) {
						console.log('dtAsistenciaModelo.idSede ' + newValue+' -- '+oldValue);
						// CARGAR DATOS DEL SIGUIENTE SELECT
					});
				// SELECT FIN
				        
				      // SELECT INI
				        $scope.listaMsSisAdmin=[];
				        $scope.loadlistaMsSisAdmin=function(){
				        $http.get(listamsSisAdminUrl).then(function(res){
				        	$scope.listaMsSisAdmin = res.data; 
				        },
				        function error(errResponse) {
				        	console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
				        });
				        };
				        $scope.changeIdMsSisAdmin=function(){
				          // /BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
				        }
				        $scope.$watch('dtAsistenciaModelo.idSede', function (newValue, oldValue) {
				        console.log('dtAsistenciaModelo.idSede ' + newValue+' -- '+oldValue);
				        // CARGAR DATOS DEL SIGUIENTE SELECT
				        });
				        // SELECT FIN
				        
				        // AUTOCOMPLETE INI
				    	$scope.ctrlMsInstitucionesIdprovee={
				    			simulateQuery: false,
				    			isDisabled: false,
				    			selectedItem: null
				    	};

				    	$scope.newStateMsInstitucionesIdprovee=function(state) {
				    		console.log("¡Lo siento! ¡Primero tendrás que crear una Constitución para " + state+"! ");
				    	}

				    	$scope.listaMsInstitucionesIdprovee=[];
				    	$scope.querySearchMsInstitucionesIdprovee = function(query) {
// var results = query ?
// $scope.listaMsInstitucionesIdprovee.filter($scope.createFilterForMsInstitucionesIdprovee(query))
// : $scope.listaMsInstitucionesIdprovee,
// return results;
				    		var sUrl = listaMsInstitucionesidproveeUrl+query;
				    		return $http.get(sUrl).then(function(res){
				    			$scope.listaMsInstitucionesIdprovee = res.data;
				    			return $scope.listaMsInstitucionesIdprovee;
				    		},
				    		function error(errResponse) {
				    			console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
				    		});
				    	};

				    	$scope.createFilterForMsInstitucionesIdprovee = function(query) {
				    		var upperCaseQuery = query.toUpperCase();
				    		return function filterFn(item) {
				    			return (item.razSocial.indexOf(upperCaseQuery) === 0);
				    		};
				    	};

				    	$scope.searchTextChangeMsInstitucionesIdprovee = function(text) {
				    		console.log('Text changed to ' + text);
				    	}

				    	$scope.selectedItemChangeMsInstitucionesIdprovee = function(item) {
				    		if($scope.isObject(item)){
				    			console.log('Item changed to ' + JSON.stringify(item));
				    			$scope.dtAsistenciaModelo.idEntidad = item.idEntidad;
				    			$scope.dtAsistenciaModelo.idEntidadTxt = item.razSocialUbigeo;
				    			$scope.dtAsistenciaModelo.codEjecutora  = item.codEjec;
				    		}
				    	}
// AUTOCOMPLETE FIN
				    	
				    	$scope.showdlgInstitucionDialog = function(ev) {		
				    		$scope.loadubigeodefecto();
				    		$scope.loadlistaPaises();
				    		$scope.loadlistaCoddptos();	
				    		$scope.loadlistaMsSedes();
				    		$scope.loadlistaMsSisAdmin();
				    		$scope.loadListaPrtParametrosIdTipoEntidad();
				    		$scope.loadListaPrtParametrosIdCaracteristica();
				    		$mdDialog.show({
				    			templateUrl: contexto+"/dialogos/entidades.html",
				    			clickOutsideToClose: true,
				    			scope: $scope,
				    			preserveScope: true,
				    			controller: mdDialogInstitucionCtrl,                	
				    			parent: angular.element(document.body),
				    			targetEvent: ev,
				    			clickOutsideToClose: true
				    		}).then($scope.closeDialog, $scope.cancelDialod);
				    	};
				    	
				    	  // SELECT INI
				        $scope.listaPrtParametrosIdTipoEntidad=[];
				    $scope.loadListaPrtParametrosIdTipoEntidad=function(){
				    	$http.get(listaPrtParametrosidparametroIdTipoEntidadUrl).then(function(res){
				    		$scope.listaPrtParametrosIdTipoEntidad = res.data; 
				    	},
				    	function error(errResponse) {
				    		console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
				    	});
				    };
				        $scope.changeIdTipoEntidad=function(){
				          // /BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
				        }
				        $scope.$watch('dtEntidadesModelo.idTipo', function (newValue, oldValue) {
				    	console.log('dtEntidadesModelo.idTipo ' + newValue+' -- '+oldValue);
				    	// CARGAR DATOS DEL SIGUIENTE SELECT
				    });
				    // SELECT FIN
				        
				      // SELECT INI
				        $scope.listaPrtParametrosIdCaracteristica=[];
				    $scope.loadListaPrtParametrosIdCaracteristica=function(){
				    	$http.get(listaPrtParametrosidparametroIdCaracteristicaUrl).then(function(res){
				    		$scope.listaPrtParametrosIdCaracteristica = res.data; 
				    	},
				    	function error(errResponse) {
				    		console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
				    	});
				    };
				        $scope.changeIdCaracteristica=function(){
				          // /BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
				        }
				        $scope.$watch('dtEntidadesModelo.idCaract', function (newValue, oldValue) {
				    	console.log('dtEntidadesModelo.idCaract ' + newValue+' -- '+oldValue);
				    	// CARGAR DATOS DEL SIGUIENTE SELECT
				    });
				    // SELECT FIN
				        
				        $scope.listaPaisess=[];
				    	$scope.loadlistaPaises=function(){			
				    		if(!$scope.isArray($scope.listaPaisess) || $scope.listaPaisess.length<=0){
				    			$http.get(listaPaisesUrl).then(function(res){
				    				$scope.listaPaisess = res.data; 
				    			},
				    			function error(errResponse) {
				    				console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
				    			});
				    		}
				    	};

				    	$scope.listaCoddptoss=[];
				    	$scope.loadlistaCoddptos=function(){
				    		if(!$scope.isArray($scope.listaCoddptoss) || $scope.listaCoddptoss.length<=0){
				    			$http.get(listaCoddptosUrl).then(function(res){
				    				$scope.listaCoddptoss = res.data; 
				    			},
				    			function error(errResponse) {
				    				console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
				    			});
				    		}
				    	};
				    	
				    	
				    	$scope.ubigeodefectos=null;
				    	$scope.loadubigeodefecto=function(){
				    		if($scope.ubigeodefectos==null){
				    			$http.get(ubigeodefectoUrl).then(function(res){
				    				$scope.ubigeodefectos = res.data;			
				    			},
				    			function error(errResponse) {
				    				console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
				    			});
				    		}
				    	};
				    
				  // MPINARES 24012023 - FIN
				    	
						//*************************************************************************************
				    	
				    	$scope.generateRandomInteger = function(max) {
						    return Math.floor(Math.random() * max) + 1;
						}
				    	
						$scope.addAsistenciaTemas = function(ev) {
							ev.target.disabled = true;
							$scope.clearAsistenciaTemasmodelo();		
							$mdDialog.show({
								templateUrl: contexto+"/dialogos/editarAsistTemas.html",
								scope: $scope,
								preserveScope: true,
								//controller: mdDialogInstitucionCtrl,                	
								parent: angular.element(document.body),
								targetEvent: ev,
								clickOutsideToClose: true
							}).then($scope.closeDialog, $scope.cancelDialod);	
							ev.target.disabled = false;
						};
						
						$scope.asistenciaTemasmodelo = {
								idAsistTema: null,
								idAsistencia: null,
								idTema: null,
								idTemaTxt: null,
								idSubtema: null,
								idSubtemaTxt: null,
								detalle: null
							};
						
						$scope.setAsistenciaTemasmodelo = function(asistTemasm){
							$scope.asistenciaTemasmodelo.idAsistTema= asistTemasm.idAsistTema;
							$scope.asistenciaTemasmodelo.idAsistencia= asistTemasm.idAsistencia;
							$scope.asistenciaTemasmodelo.idTema= asistTemasm.idTema;
							$scope.asistenciaTemasmodelo.idTemaTxt= asistTemasm.idTemaTxt;
							$scope.asistenciaTemasmodelo.idSubtema= asistTemasm.idSubtema;
							$scope.asistenciaTemasmodelo.idSubtemaTxt= asistTemasm.idSubtemaTxt;
							$scope.asistenciaTemasmodelo.detalle= asistTemasm.detalle;
						};
						
						$scope.clearAsistenciaTemasmodelo= function(){
							$scope.asistenciaTemasmodelo.idAsistTema= null;
							$scope.asistenciaTemasmodelo.idAsistencia= null;
							$scope.asistenciaTemasmodelo.idTema= null;
							$scope.asistenciaTemasmodelo.idTemaTxt= null;
							$scope.asistenciaTemasmodelo.idSubtema= null;
							$scope.asistenciaTemasmodelo.idSubtemaTxt= null;
							$scope.asistenciaTemasmodelo.detalle= null;
						};
						
						$scope.nuevoAsistenciaTemasmodelo = function (ev) {
							ev.target.disabled = true;
							
							if ($scope.isNull($scope.asistenciaTemasmodelo.idTema)) {
								// PURIBE 15042024 - INICIO -->
								$mdDialog.show(
									$mdDialog.alert().multiple(true)
									.parent(angular.element(document.body))
									.clickOutsideToClose(true)
									.title('Temas agendados')
									.textContent("No se ha seleccionado el tema")
									.ariaLabel('Lucky day')
									.ok('ACEPTAR')
							);
								ev.target.disabled = false;
								return;
							}
							
							if ($scope.isNull($scope.asistenciaTemasmodelo.idSubtema)) {
								// PURIBE 15042024 - INICIO -->
								$mdDialog.show(
									$mdDialog.alert().multiple(true)
									.parent(angular.element(document.body))
									.clickOutsideToClose(true)
									.title('Temas agendados')
									.textContent("No se ha seleccionado el subtema")
									.ariaLabel('Lucky day')
									.ok('ACEPTAR')
							);
								ev.target.disabled = false;
								return;
							}
							
							if ($scope.isNull($scope.asistenciaTemasmodelo.detalle)) {
								// PURIBE 15042024 - INICIO -->
								$mdDialog.show(
									$mdDialog.alert().multiple(true)
									.parent(angular.element(document.body))
									.clickOutsideToClose(true)
									.title('Temas agendados')
									.textContent("No se ha ingresado el detalle del tema")
									.ariaLabel('Lucky day')
									.ok('ACEPTAR')
							);
								ev.target.disabled = false;
								return;
							}
							
							
							if ($scope.datoAsistenciaTema.filter(e => e.idSubtema === $scope.asistenciaTemasmodelo.idSubtema).length > 0) {
								  /* vendors contains the element we're looking for */
								$mdDialog.show(
										$mdDialog.alert().multiple(true)
										.parent(angular.element(document.body))
										.clickOutsideToClose(true)
										.title('Temas agendados')
										.textContent("El subtema asignado ya existe")
										.ariaLabel('Lucky day')
										.ok('ACEPTAR')
								);
								ev.target.disabled = false;
								return;
								}
							
					        var datoactual = Object.assign({}, $scope.asistenciaTemasmodelo);		
							if($scope.isNull(datoactual.idAsistTema) || $scope.isUndefined(datoactual.idAsistTema)){
								datoactual.idAsistTema = $scope.generateRandomInteger(1000)*-1;
							}
							if($scope.isArray($scope.datoAsistenciaTema)){
								var objEncontrado = $scope.datoAsistenciaTema.find(o => o.idAsistTema === datoactual.idAsistTema);
								if($scope.isObject(objEncontrado)){
									Object.assign(objEncontrado, datoactual);
									$scope.cancel();
									ev.target.disabled = false;
									return;
								}
							}	
							$scope.datoAsistenciaTema.push(datoactual);	
							$scope.cancel();
							ev.target.disabled = false;
						};
						
						//*************************************************************************************
				    	
// /ADICIONALES
// SELECT INI
        $scope.listaDtEntidadesIdEntidad=[];
	$scope.loadListaDtEntidadesIdEntidad=function(){
		$http.get(listaDtEntidadesidEntidadIdEntidadUrl).then(function(res){
			$scope.listaDtEntidadesIdEntidad = res.data; 
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
        $scope.changeIdEntidad=function(){
          // /BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
        }
        $scope.$watch('dtAsistenciaModelo.idEntidad', function (newValue, oldValue) {
		console.log('dtAsistenciaModelo.idEntidad ' + newValue+' -- '+oldValue);
		// CARGAR DATOS DEL SIGUIENTE SELECT
// if($scope.isArray($scope.listaDtEntidadesIdEntidad)){
// var obj = $scope.listaDtEntidadesIdEntidad.find(o => o.id === newValue);
// if($scope.isObject(obj)){
// $scope.dtEntidadesModelo.idEntidadTxt = obj.valor;
// }
// }
	});
// SELECT FIN
// SELECT INI
        $scope.listaPrtParametrosIdOrigen=[];
	$scope.loadListaPrtParametrosIdOrigen=function(){
		$http.get(listaPrtParametrosidparametroIdOrigenUrl).then(function(res){
			$scope.listaPrtParametrosIdOrigen = res.data; 
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
        $scope.changeIdOrigen=function(){
          // /BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
        }
        $scope.$watch('dtAsistenciaModelo.idOrigen', function (newValue, oldValue) {
		console.log('dtAsistenciaModelo.idOrigen ' + newValue+' -- '+oldValue);
		// CARGAR DATOS DEL SIGUIENTE SELECT
// if($scope.isArray($scope.listaPrtParametrosIdOrigen)){
// var obj = $scope.listaPrtParametrosIdOrigen.find(o => o.id === newValue);
// if($scope.isObject(obj)){
// $scope.prtParametrosModelo.idparametroTxt = obj.valor;
// }
// }
	});
// SELECT FIN
// SELECT INI
        $scope.listaPrtParametrosIdModalidad=[];
	$scope.loadListaPrtParametrosIdModalidad=function(){
		$http.get(listaPrtParametrosidparametroIdModalidadUrl).then(function(res){
			$scope.listaPrtParametrosIdModalidad = res.data; 
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
        $scope.changeIdModalidad=function(){
          // /BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
        }
        $scope.$watch('dtAsistenciaModelo.idModalidad', function (newValue, oldValue) {
		console.log('dtAsistenciaModelo.idModalidad ' + newValue+' -- '+oldValue);
		// CARGAR DATOS DEL SIGUIENTE SELECT
// if($scope.isArray($scope.listaPrtParametrosIdModalidad)){
// var obj = $scope.listaPrtParametrosIdModalidad.find(o => o.id === newValue);
// if($scope.isObject(obj)){
// $scope.prtParametrosModelo.idparametroTxt = obj.valor;
// }
// }
	});
// SELECT FIN
// SELECT INI
        $scope.listaPrtParametrosIdFinancia=[];
	$scope.loadListaPrtParametrosIdFinancia=function(){
		$http.get(listaPrtParametrosidparametroIdFinanciaUrl).then(function(res){
			$scope.listaPrtParametrosIdFinancia = res.data; 
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
        $scope.changeIdFinancia=function(){
          // /BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
        }
        $scope.$watch('dtAsistenciaModelo.idFinancia', function (newValue, oldValue) {
		console.log('dtAsistenciaModelo.idFinancia ' + newValue+' -- '+oldValue);
		// CARGAR DATOS DEL SIGUIENTE SELECT
// if($scope.isArray($scope.listaPrtParametrosIdFinancia)){
// var obj = $scope.listaPrtParametrosIdFinancia.find(o => o.id === newValue);
// if($scope.isObject(obj)){
// $scope.prtParametrosModelo.idparametroTxt = obj.valor;
// }
// }
	});
// SELECT FIN


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

// MPINARES 24012023 - INICIO
var mdDialogInstitucionCtrl = function ($scope, $http, $mdDialog) { 

	$scope.dtEntidadesModelo = {
			idEntidad : null,
			codEjec: null,
			razSocial: null,
			direccion: null,
			ruc: null,
			idTipo: null,
			idCaract: null,
			codDpto: null,
			codProv: null,
			codDistr: null,
			idpais: null,
			idSistAdmi: null,
			idSede: null,
			geozona: null,
			
                        // ADICIONALES
	        estadoTxt: null,
			idTipoTxt: null,
			idCaractTxt: null,
			codDptoTxt: null,
			codProvTxt: null,
			codDistrTxt: null,
			idpaisTxt: null,
			idSistAdmiTxt: null,

		    editopcion: 1
		};

// if($scope.msInstitucionesModelo.codpais==null){
// $scope.msInstitucionesModelo.codpais=$scope.ubigeodefectos.xDefectoCodpais;
// }
// if($scope.msInstitucionesModelo.coddpto==null){
// $scope.msInstitucionesModelo.coddpto=$scope.ubigeodefectos.xDefectoCoddpto;
// }
// if($scope.msInstitucionesModelo.codprov==null){
// $scope.msInstitucionesModelo.codprov=$scope.ubigeodefectos.xDefectoCodprov;
// }
// if($scope.msInstitucionesModelo.coddist==null){
// $scope.msInstitucionesModelo.coddist=$scope.ubigeodefectos.xDefectoCoddist;
// }

	$scope.setDtEntidadesModelo = function(dtEntidadesBk) {
		  $scope.dtEntidadesModelo.idEntidad = dtEntidadesBk.idEntidad;
			$scope.dtEntidadesModelo.codEjec = dtEntidadesBk.codEjec;
			$scope.dtEntidadesModelo.razSocial = dtEntidadesBk.razSocial;
			$scope.dtEntidadesModelo.direccion = dtEntidadesBk.direccion;
			$scope.dtEntidadesModelo.ruc = dtEntidadesBk.ruc;
			$scope.dtEntidadesModelo.idTipo = dtEntidadesBk.idTipo;
			$scope.dtEntidadesModelo.idCaract = dtEntidadesBk.idCaract;
			$scope.dtEntidadesModelo.codDpto = dtEntidadesBk.codDpto;
			$scope.dtEntidadesModelo.codProv = dtEntidadesBk.codProv;
			$scope.dtEntidadesModelo.codDistr = dtEntidadesBk.codDistr;
			$scope.dtEntidadesModelo.idpais = dtEntidadesBk.idpais;
			$scope.dtEntidadesModelo.idSistAdmi = dtEntidadesBk.idSistAdmi;
			$scope.dtEntidadesModelo.idSede = dtEntidadesBk.idSede;
			$scope.dtEntidadesModelo.geozona = dtEntidadesBk.geozona;
			
                      // ADICIONALES
	        $scope.dtEntidadesModelo.estadoTxt = dtEntidadesBk.estadoTxt;
			$scope.dtEntidadesModelo.idTipoTxt = dtEntidadesBk.idTipoTxt;
			$scope.dtEntidadesModelo.idCaractTxt = dtEntidadesBk.idCaractTxt;
			$scope.dtEntidadesModelo.codDptoTxt = dtEntidadesBk.codDptoTxt;
			$scope.dtEntidadesModelo.codProvTxt = dtEntidadesBk.codProvTxt;
			$scope.dtEntidadesModelo.codDistrTxt = dtEntidadesBk.codDistrTxt;
			$scope.dtEntidadesModelo.idpaisTxt = dtEntidadesBk.idpaisTxt;
			$scope.dtEntidadesModelo.idSistAdmiTxt = dtEntidadesBk.idSistAdmiTxt;

			$scope.dtEntidadesModelo.editopcion = dtEntidadesBk.dtEntidadesACL.editopcion;
		}
	
    // SELECT INI
    $scope.listaMsSedes=[];
$scope.loadlistaMsSedes=function(){
	$http.get(listaMsSedesUrl).then(function(res){
		$scope.listaMsSedes = res.data; 
	},
	function error(errResponse) {
		console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
	});
};
    $scope.changeIdSede=function(){
      // /BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
    }
    $scope.$watch('dtEntidadesModelo.idSede', function (newValue, oldValue) {
	console.log('dtEntidadesModelo.idSede ' + newValue+' -- '+oldValue);
	// CARGAR DATOS DEL SIGUIENTE SELECT
});
// SELECT FIN
    
  // SELECT INI
    $scope.listaPrtParametrosIdTipoEntidad=[];
$scope.loadListaPrtParametrosIdTipoEntidad=function(){
	$http.get(listaPrtParametrosidparametroIdTipoEntidadUrl).then(function(res){
		$scope.listaPrtParametrosIdTipoEntidad = res.data; 
	},
	function error(errResponse) {
		console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
	});
};
    $scope.changeIdTipoEntidad=function(){
      // /BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
    }
    $scope.$watch('dtEntidadesModelo.idTipo', function (newValue, oldValue) {
	console.log('dtEntidadesModelo.idTipo ' + newValue+' -- '+oldValue);
	// CARGAR DATOS DEL SIGUIENTE SELECT
});
// SELECT FIN
    
    // SELECT INI
    $scope.listaPrtParametrosIdCaracteristica=[];
$scope.loadListaPrtParametrosIdCaracteristica=function(){
	$http.get(listaPrtParametrosidparametroIdCaracteristicaUrl).then(function(res){
		$scope.listaPrtParametrosIdCaracteristica = res.data; 
	},
	function error(errResponse) {
		console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
	});
};
    $scope.changeIdCaracteristica=function(){
      // /BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
    }
    $scope.$watch('dtEntidadesModelo.idCaract', function (newValue, oldValue) {
	console.log('dtEntidadesModelo.idCaract ' + newValue+' -- '+oldValue);
	// CARGAR DATOS DEL SIGUIENTE SELECT
});
// SELECT FIN
    
    $scope.listaPaisess=[];
	$scope.loadlistaPaises=function(){			
		if(!$scope.isArray($scope.listaPaisess) || $scope.listaPaisess.length<=0){
			$http.get(listaPaisesUrl).then(function(res){
				$scope.listaPaisess = res.data; 
			},
			function error(errResponse) {
				console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
			});
		}
	};

	$scope.listaCoddptoss=[];
	$scope.loadlistaCoddptos=function(){
		if(!$scope.isArray($scope.listaCoddptoss) || $scope.listaCoddptoss.length<=0){
			$http.get(listaCoddptosUrl).then(function(res){
				$scope.listaCoddptoss = res.data; 
			},
			function error(errResponse) {
				console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
			});
		}
	};
	
	$scope.changeCoddpto=function(){
		$scope.dtEntidadesModelo.codProv = null;
		$scope.dtEntidadesModelo.codDistr = null;
	}

	$scope.changeCodprov=function(){
		$scope.dtEntidadesModelo.codDistr = null;
	}
	
	$scope.listaCodprovs=[];
	$scope.loadlistaCodprov=function(){
		if($scope.dtEntidadesModelo.codDpto){
			var surl = listaCodprovUrl+$scope.dtEntidadesModelo.codDpto;
			$http.get(surl).then(function(res){
				$scope.listaCodprovs = res.data; 
			},
			function error(errResponse) {
				console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
			});
		}else{
			$scope.listaCodprovs=[];
		}
	};

	$scope.listaCoddists=[];
	$scope.loadlistaCoddist=function(){
		if($scope.dtEntidadesModelo.codDpto &&
				$scope.dtEntidadesModelo.codProv){
			var surl = listaCoddistUrl+$scope.dtEntidadesModelo.codDpto+'/'+$scope.dtEntidadesModelo.codProv;
			$http.get(surl).then(function(res){
				$scope.listaCoddists = res.data; 
			},
			function error(errResponse) {
				console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
			});
		}else{
			$scope.listaCoddists=[];
		}
	};


	$scope.visualizarUbigeo = true;	
	$scope.$watch('dtEntidadesModelo.codpais', function (newValue, oldValue) {
		console.log('dtEntidadesModelo.codpais ' + newValue+' -- '+oldValue);
		if($scope.ubigeodefectos!=null){
			if($scope.ubigeodefectos.xDefectoCodpais == newValue){
				$scope.visualizarUbigeo = true;
			}else{
				$scope.visualizarUbigeo = false;
			}
		}else{
			$scope.loadubigeodefecto();
		}
	});
//
	$scope.$watch('dtEntidadesModelo.codDpto', function (newValue, oldValue) {
		console.log('dtEntidadesModelo.codDpto ' + newValue+' -- '+oldValue);
		$scope.loadlistaCodprov();
// $scope.msInstitucionesModelo.codprov = null;
// $scope.msInstitucionesModelo.coddist = null;
	});

	$scope.$watch('dtEntidadesModelo.codProv', function (newValue, oldValue) {
		console.log('dtEntidadesModelo.codProv ' + newValue+' -- '+oldValue);
		$scope.loadlistaCoddist();
// $scope.msInstitucionesModelo.coddist = null;
	});
	
	$scope.salvarDtEntidades = function(ev){	
		
		if($scope.isArray($scope.datoEntidadSisAdmin)){
			if($scope.datoEntidadSisAdmin.length>0){
				$scope.dtEntidadesModelo.dtEntidadSisAdminBkJSss = $scope.datoEntidadSisAdmin;
			}}
		
		ev.target.disabled = true;
		var datainsert = angular.toJson($scope.dtEntidadesModelo);
		console.log("datainsert = "+datainsert);	
		$http.post(insertdtEntidadesUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
			var dato = res.data;

			$scope.setDtEntidadesModelo(dato);

			$mdDialog.show(
					$mdDialog.alert()
					.parent(angular.element(document.body))
					.clickOutsideToClose(true)
					.title('Guardar entidad')
					.textContent('La entidad se guardó correctamente')
					.ariaLabel('Información')
					.ok('ACEPTAR')
					.targetEvent(ev)
			);

// $scope.tdAtencionesModelo.ruc = dato.ruc;
// $scope.tdAtencionesModelo.razonSocial = dato.razSocial;
// $scope.tdAtencionesModelo.idprovee = dato.idEntidad;
// $scope.tdAtencionesModelo.tipoentidad = dato.idTipo;
			$scope.selectedItem = dato;
		},
		function error(errResponse) {
			console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
			var dato = errResponse.data;
			if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
				$mdDialog.show(
						$mdDialog.alert()
						.parent(angular.element(document.body))
						.clickOutsideToClose(true)
						.title('Guardar entidad')
						.textContent(dato.message)
						.ariaLabel('ERROR')
						.ok('ACEPTAR')
						.targetEvent(ev)
				);
			}
		});		

		ev.target.disabled = false;
	};
	
	$scope.datoEntidadSisAdmin = [
		{contador: 1, identidadSisadm: "", idSistAdmi: "", idSede: "", add: true}
    ];
	
	$scope.settingFlagAddAndRemoveEntidadSisAdmin = function () {
        let sizeTemas = $scope.datoEntidadSisAdmin.length;
        $scope.datoEntidadSisAdmin.map(function (obj) {

        	if (obj.contador == sizeTemas) {
                obj.add = true;
            } else {
                obj.add = false;
            }

        });
    }
	
	$scope.removeEntidadSisAdmin = function (ev,dato) {
    	if(dato.identidadSisadm!=null && dato.identidadSisadm>0){
    		$scope.showConfirmDeleteEntidadSisAdmin(ev, dato);
    	}else{
    		$scope.datoEntidadSisAdmin = $scope.datoEntidadSisAdmin.filter(val => val.contador !== dato.contador);
    	} 
    }
	
	$scope.showConfirmDeleteEntidadSisAdmin = function(ev, dtEntidadSisAdminBk) {
	    var confirm = $mdDialog.confirm()
	      .title('Eliminar registro')
	      .textContent('¿Está usted seguro de eliminar el registro?')
	      .ariaLabel('Lucky day')
	      .targetEvent(ev)
	      .ok('Si')
	      .cancel('No');

	    $mdDialog.show(confirm).then(function () {
	      $scope.status = 'SI';
	      $scope.eliminarEntidadSisAdmin(ev, dtEntidadSisAdminBk);
	    }, function () {
	      $scope.status = 'NO';
	    });
	  };
	  
	  
	  $scope.eliminarEntidadSisAdmin = function(ev,dtEntidadSisAdminBk){		
		    ev.target.disabled = true;
		    var datainsert = angular.toJson(dtEntidadSisAdminBk);
			console.log("datainsert = "+datainsert);	
		$http.post(eliminardtEntidadSisAdminUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
				var dato = res.data;
				var instrumentos = $scope.datos;
		        var index = $scope.datos.findIndex(obj => obj.identidadSisadm === dato.identidadSisadm);
				console.log("INDEX " + index);
		        if(instrumentos.length>index){
		        	instrumentos.splice(index, 1);
			        $scope.datos = instrumentos;
			        $scope.total = $scope.datos.length;
		        }	
// $scope.editdtAsistencia();
			},
			function error(errResponse) {
	            console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
	            var dato = errResponse.data;
	            if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
	            	$mdDialog.show(
			         $mdDialog.alert()
			        .parent(angular.element(document.body))
			        .clickOutsideToClose(true)
			        .title('Eliminar registro')
			        .textContent(dato.message)
			        .ariaLabel('ERROR')
			        .ok('ACEPTAR')
			        .targetEvent(ev)
				   );
	            }
	        });			        			        	
    	ev.target.disabled = false;
	 };
	 
	 $scope.nuevoEntidadSisAdmin= function (ev,dato) {
		 if(dato.idSede!=null && dato.idSede>0 && dato.idSistAdmi!=null && dato.idSistAdmi>0){
		        $scope.datoEntidadSisAdmin.push({
		        	contador: $scope.datoEntidadSisAdmin.length + 1,
		        	identidadSisadm: "",
		        	idSistAdmi: "", 
		        	idSede: "", 	           
		            add: false
		        })

		        $scope.settingFlagAddAndRemoveEntidadSisAdmin();
		 }else{
			 $mdDialog.show(
						$mdDialog.alert()
						.parent(angular.element(document.body))
						.clickOutsideToClose(true)
						.title('Guardar entidad')
						.textContent("Debe seleccionar el sistema administrativo y la sede... ")
						.ariaLabel('ERROR')
						.ok('ACEPTAR')
						.targetEvent(ev)
				);
		    	ev.target.disabled = false;
			return;
		 }
		 

	    };
	    
	    $scope.changeIdSedeEnti=function(ev,dato){
        	///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
        	if($scope.datoEntidadSisAdmin.length > 1){
        		if ($scope.datoEntidadSisAdmin.filter(e => e.idSistAdmi === dato.idSistAdmi && e.idSede === dato.idSede).length > 1 ) {
					  /* vendors contains the element we're looking for */
        			dato.idSistAdmi="";
        			dato.idSede="";
					$mdDialog.show(
							$mdDialog.alert()
							.parent(angular.element(document.body))
							.clickOutsideToClose(true)
							.title('Guardar entidad')
							.textContent("El sistema administrativo y la sede ya existen")
							.ariaLabel('Lucky day')
							.ok('ACEPTAR')
					);
					ev.target.disabled = false;
					return;
					}
        	
	        }
        };
};

// SELECT INI
$scope.listaMsSisAdmin=[];
$scope.loadlistaMsSisAdmin=function(){
$http.get(listamsSisAdminUrl).then(function(res){
	$scope.listaMsSisAdmin = res.data; 
},
function error(errResponse) {
	console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
});
};
$scope.changeIdMsSisAdmin=function(){
  // /BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
}
$scope.$watch('dtAsistenciaModelo.idSede', function (newValue, oldValue) {
console.log('dtAsistenciaModelo.idSede ' + newValue+' -- '+oldValue);
// CARGAR DATOS DEL SIGUIENTE SELECT
});
// SELECT FIN

// MPINARES 24012023 - FIN
