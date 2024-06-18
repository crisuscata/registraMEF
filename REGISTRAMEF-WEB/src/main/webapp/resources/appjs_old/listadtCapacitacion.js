var contexto = window.location.pathname.substring(0,window.location.pathname.indexOf('/',2));
var pglogoff = window.location.origin+contexto+'/logoff.htm';
var principalUrl = window.location.origin+contexto+'/index.htm';
var listadtCapacitacionUrl = contexto+"/rs/ctrldtCapacitacion/listadtCapacitacion";
var insertdtCapacitacionUrl = contexto+"/rs/ctrldtCapacitacion/salvardtCapacitacion";
var eliminardtCapacitacionUrl = contexto+"/rs/ctrldtCapacitacion/eliminardtCapacitacion";
var editardtCapacitacionUrl = contexto+"/rs/ctrldtCapacitacion/editardtCapacitacion/";
var listaMsLocalidLocalIdLocalUrl = contexto+"/rs/ctrldtCapacitacion/listaMsLocalIdLocalIdLocal";
var listaPrtParametrosidparametroIdModoUrl = contexto+"/rs/ctrldtCapacitacion/listaPrtParametrosIdparametroIdModo";
var listaPrtParametrosidparametroIdNivelUrl = contexto+"/rs/ctrldtCapacitacion/listaPrtParametrosIdparametroIdNivel";
var listaPrtParametrosidparametroIdOrigenUrl = contexto+"/rs/ctrldtCapacitacion/listaPrtParametrosIdparametroIdOrigen";
var listaPrtParametrosidparametroIdPrestacionUrl = contexto+"/rs/ctrldtCapacitacion/listaPrtParametrosIdparametroIdPrestacion";
var listaPrtParametrosidparametroIdTipoUrl = contexto+"/rs/ctrldtCapacitacion/listaPrtParametrosIdparametroIdTipo";
var listaPrtParametrosidparametroIdFinanciaUrl = contexto+"/rs/ctrldtCapacitacion/listaPrtParametrosIdparametroIdFinancia";
var listaPrtParametrosidparametroIdModalidadUrl = contexto+"/rs/ctrldtCapacitacion/listaPrtParametrosIdparametroIdModalidad";
var descargarUrl = contexto+"/rs/ctrldtCapacitacion/descargar/";

///URLs CARGA DE ARCHIVOS
var insertDocUrl = contexto+"/rs/ctrldtCapacitacion/insertarchivo";
var descargarUrl = contexto+"/rs/ctrldtCapacitacion/descargar/";
///FIN URLs CARGA DE ARCHIVOS

var descargarvistaUrl = contexto+"/rs/ctrldtCapacitacion/descargarvista";

/**
 * 
 */
myapp = angular.module('MyApp');

myapp.config(function($routeProvider) {
	  $routeProvider
	  .when("/editar/:idCapacitacion", {
		  templateUrl : "adminis/editardtCapacitacion.html",
		  controller : "ctrlListadtCapacitacion"
	  })
	  .when("/nuevo", {
		  templateUrl : "adminis/editardtCapacitacion.html",
		  controller : "ctrlListadtCapacitacion"
	  })
	  .otherwise({
		  templateUrl : "adminis/verdtCapacitacion.html",
		  controller : "ctrlListadtCapacitacion"  
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

myapp.controller('ctrlListadtCapacitacion', ['$mdEditDialog', '$scope', '$timeout', '$http', '$mdDialog','$location','$routeParams', '$mdPanel',  function ($mdEditDialog, $scope, $timeout, $http, $mdDialog, $location, $routeParams, $mdPanel) {
	'use strict';
	 
	 $scope.limitOptions = [100, 500, 1000, 5000];
	 $scope.query = {
			    order: 'idCapacitacion',
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
	  $scope.loaddtCapacitacions();
	 };
	 
	 $scope.logItem = function (item) {
	  console.log(item.name, 'was selected');
	 };
	 
	 $scope.logPagination = function (page, limit) {
	  console.log('page: ', page);
	  console.log('limit: ', limit);
	  $scope.loaddtCapacitacions();
         };
     $scope.creadtCapacitacion = false;
    // ///////////////////////////////////////////
	$scope.datos = [];
	$scope.total = 0;

	$scope.loaddtCapacitacions = function () {
	    //$scope.promise = $timeout(function () {
	    	var surl = $scope.getURL();	    
	    	$scope.promise = $http.get(surl).then(function(res){
	    		 $scope.datos = res.data.data;
	    		 if(res.data.contador>0)
	    		 $scope.total = res.data.contador;
	    		 var tiempoenBD = res.data.tiempoenBD;
	    		 var tiempoenproceso = res.data.tiempoenproceso;
	    		 $scope.creadtCapacitacion = res.data.creamodifica;
	    		 console.log("data " +$scope.datos.length+" DE "+ $scope.total);
	    		 console.log("Tiempo respuesta BD dtCapacitacion " +tiempoenBD+" Tiempo en Paginar "+tiempoenproceso);
				},
				function error(errResponse) {
		            console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		            var dato = errResponse.data;
		            if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
		            	$mdDialog.show(
						         $mdDialog.alert()
						        .parent(angular.element(document.body))
						        .clickOutsideToClose(true)
						        .title('Lista de Capacitaciones')
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
		  return listadtCapacitacionUrl+$scope.getURLParametros();
	  }
	  
	  $scope.editdtCapacitacion = function () {
		    $scope.nuevo = true;
		    var idCapacitacion = $routeParams.idCapacitacion;
		    if(idCapacitacion){
		    	$scope.cargardtCapacitacion(idCapacitacion);
		    }
		   ///CARGAR COMPLEMENTOS 
                $scope.loadListaMsLocalIdLocal();//SELECT
                $scope.loadListaPrtParametrosIdModo();//SELECT
                $scope.loadListaPrtParametrosIdNivel();//SELECT
                $scope.loadListaPrtParametrosIdOrigen();//SELECT
                $scope.loadListaPrtParametrosIdPrestacion();//SELECT
                $scope.loadListaPrtParametrosIdTipo();//SELECT
                $scope.loadListaPrtParametrosIdFinancia();//SELECT
                $scope.loadListaPrtParametrosIdModalidad();//SELECT
		  };
	  
	  $scope.filtro ={
  fechaInic: null,
  fechaFin: null,
  cantPartic: null,
  nomEvento: null,
  idLocal: null,
  idUsuinterno: null,
  idModo: null,
  idNivel: null,
  idOrigen: null,
  idPrestacion: null,
  idProgramacion: null,
  idTipo: null,
  idSede: null,
  idSistAdm: null,
  idFinancia: null,
  fechaFinalizacion: null,
  idModalidad: null,
  fechaIniProgramada: null,
  fechaFinProgramada: null,
  fechaSoli: null,
  stdNumeroSid: null,
  stdNumeroDoc: null,
  motivoEjec: null,
  
         estado: null
		}; 
	  
	  $scope.seteestado = function(eestado) {
			if($scope.filtro.estado === eestado){
				$scope.filtro.estado = null;
			}else{
				$scope.filtro.estado = eestado;
			}
			$scope.loaddtCapacitacions();
		};
	  
         $scope.refrescarvista = function(ev){
		  if(typeof(ev)=='undefined' || ev==null){
	          
          }else{
			 var keyCode = ev.which || ev.keyCode;
			    if (keyCode === 13) {
			    	$scope.loaddtCapacitacions();
			    }else if (keyCode === 1) {
			    	$scope.loaddtCapacitacions();
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

	  $scope.dtCapacitacionModelo = {
			idCapacitacion : null,
			fechaInic: new Date(),
fechaFin: new Date(),
cantPartic: null,
			publicObj: null,
			nomEvento: null,
			detalleCapa: null,
			idLocal: null,
			idUsuinterno: null,
			idModo: null,
			idNivel: null,
			idOrigen: null,
			idPrestacion: null,
			idProgramacion: null,
			cantParticAsist: null,
			idTipo: null,
			idcapaPadre: null,
			idSede: null,
			idSistAdm: null,
			idFinancia: null,
			fechaFinalizacion: new Date(),
flagPubli: null,
			idModalidad: null,
			detalleCapaVirtual: null,
			fechaIniProgramada: new Date(),
fechaFinProgramada: new Date(),
fechaSoli: new Date(),
stdIddoc: null,
			stdNumeroSid: null,
			stdNumeroAnio: null,
			stdNumeroDoc: null,
			stdAsunto: null,
			stdTipoDoc: null,
			stdFechaRecepcion: new Date(),
stdModalidadIng: null,
			flagEjec: null,
			motivoEjec: null,
			
                        // ADICIONALES
	                idLocalTxt: null,
idUsuinternoTxt: null,
estadoTxt: null,
idModoTxt: null,
idNivelTxt: null,
idOrigenTxt: null,
idPrestacionTxt: null,
idProgramacionTxt: null,
idTipoTxt: null,
idSedeTxt: null,
idSistAdmTxt: null,
idFinanciaTxt: null,
idModalidadTxt: null,

		    editopcion: 1
		};
	  
	  $scope.cleardtCapacitacion = function(){
		    $scope.dtCapacitacionModelo.idCapacitacion = null;
		    $scope.dtCapacitacionModelo.fechaInic = new Date();$scope.dtCapacitacionModelo.fechaFin = new Date();$scope.dtCapacitacionModelo.cantPartic = null;
		    $scope.dtCapacitacionModelo.publicObj = null;
		    $scope.dtCapacitacionModelo.nomEvento = null;
		    $scope.dtCapacitacionModelo.detalleCapa = null;
		    $scope.dtCapacitacionModelo.idLocal = null;
		    $scope.dtCapacitacionModelo.idUsuinterno = null;
		    $scope.dtCapacitacionModelo.idModo = null;
		    $scope.dtCapacitacionModelo.idNivel = null;
		    $scope.dtCapacitacionModelo.idOrigen = null;
		    $scope.dtCapacitacionModelo.idPrestacion = null;
		    $scope.dtCapacitacionModelo.idProgramacion = null;
		    $scope.dtCapacitacionModelo.cantParticAsist = null;
		    $scope.dtCapacitacionModelo.idTipo = null;
		    $scope.dtCapacitacionModelo.idcapaPadre = null;
		    $scope.dtCapacitacionModelo.idSede = null;
		    $scope.dtCapacitacionModelo.idSistAdm = null;
		    $scope.dtCapacitacionModelo.idFinancia = null;
		    $scope.dtCapacitacionModelo.fechaFinalizacion = new Date();$scope.dtCapacitacionModelo.flagPubli = null;
		    $scope.dtCapacitacionModelo.idModalidad = null;
		    $scope.dtCapacitacionModelo.detalleCapaVirtual = null;
		    $scope.dtCapacitacionModelo.fechaIniProgramada = new Date();$scope.dtCapacitacionModelo.fechaFinProgramada = new Date();$scope.dtCapacitacionModelo.fechaSoli = new Date();$scope.dtCapacitacionModelo.stdIddoc = null;
		    $scope.dtCapacitacionModelo.stdNumeroSid = null;
		    $scope.dtCapacitacionModelo.stdNumeroAnio = null;
		    $scope.dtCapacitacionModelo.stdNumeroDoc = null;
		    $scope.dtCapacitacionModelo.stdAsunto = null;
		    $scope.dtCapacitacionModelo.stdTipoDoc = null;
		    $scope.dtCapacitacionModelo.stdFechaRecepcion = new Date();$scope.dtCapacitacionModelo.stdModalidadIng = null;
		    $scope.dtCapacitacionModelo.flagEjec = null;
		    $scope.dtCapacitacionModelo.motivoEjec = null;
		    
                    // ADICIONALES
	            $scope.dtCapacitacionModelo.idLocalTxt = null;
$scope.dtCapacitacionModelo.idUsuinternoTxt = null;
$scope.dtCapacitacionModelo.estadoTxt = null;
$scope.dtCapacitacionModelo.idModoTxt = null;
$scope.dtCapacitacionModelo.idNivelTxt = null;
$scope.dtCapacitacionModelo.idOrigenTxt = null;
$scope.dtCapacitacionModelo.idPrestacionTxt = null;
$scope.dtCapacitacionModelo.idProgramacionTxt = null;
$scope.dtCapacitacionModelo.idTipoTxt = null;
$scope.dtCapacitacionModelo.idSedeTxt = null;
$scope.dtCapacitacionModelo.idSistAdmTxt = null;
$scope.dtCapacitacionModelo.idFinanciaTxt = null;
$scope.dtCapacitacionModelo.idModalidadTxt = null;

		    $scope.dtCapacitacionModelo.editopcion = 1;
	 } 
	 
	  $scope.setDtCapacitacionModelo = function(dtCapacitacionBk) {
		  $scope.dtCapacitacionModelo.idCapacitacion = dtCapacitacionBk.idCapacitacion;
			$scope.dtCapacitacionModelo.fechaInic = dtCapacitacionBk.fechaInic;
                        if(!$scope.isNull($scope.dtCapacitacionModelo.fechaInic) && !isNaN($scope.dtCapacitacionModelo.fechaInic)){
			    $scope.dtCapacitacionModelo.fechaInic = new Date($scope.dtCapacitacionModelo.fechaInic);
		        }
$scope.dtCapacitacionModelo.fechaFin = dtCapacitacionBk.fechaFin;
                        if(!$scope.isNull($scope.dtCapacitacionModelo.fechaFin) && !isNaN($scope.dtCapacitacionModelo.fechaFin)){
			    $scope.dtCapacitacionModelo.fechaFin = new Date($scope.dtCapacitacionModelo.fechaFin);
		        }
$scope.dtCapacitacionModelo.cantPartic = dtCapacitacionBk.cantPartic;
			$scope.dtCapacitacionModelo.publicObj = dtCapacitacionBk.publicObj;
			$scope.dtCapacitacionModelo.nomEvento = dtCapacitacionBk.nomEvento;
			$scope.dtCapacitacionModelo.detalleCapa = dtCapacitacionBk.detalleCapa;
			$scope.dtCapacitacionModelo.idLocal = dtCapacitacionBk.idLocal;
			$scope.dtCapacitacionModelo.idUsuinterno = dtCapacitacionBk.idUsuinterno;
			$scope.dtCapacitacionModelo.idModo = dtCapacitacionBk.idModo;
			$scope.dtCapacitacionModelo.idNivel = dtCapacitacionBk.idNivel;
			$scope.dtCapacitacionModelo.idOrigen = dtCapacitacionBk.idOrigen;
			$scope.dtCapacitacionModelo.idPrestacion = dtCapacitacionBk.idPrestacion;
			$scope.dtCapacitacionModelo.idProgramacion = dtCapacitacionBk.idProgramacion;
			$scope.dtCapacitacionModelo.cantParticAsist = dtCapacitacionBk.cantParticAsist;
			$scope.dtCapacitacionModelo.idTipo = dtCapacitacionBk.idTipo;
			$scope.dtCapacitacionModelo.idcapaPadre = dtCapacitacionBk.idcapaPadre;
			$scope.dtCapacitacionModelo.idSede = dtCapacitacionBk.idSede;
			$scope.dtCapacitacionModelo.idSistAdm = dtCapacitacionBk.idSistAdm;
			$scope.dtCapacitacionModelo.idFinancia = dtCapacitacionBk.idFinancia;
			$scope.dtCapacitacionModelo.fechaFinalizacion = dtCapacitacionBk.fechaFinalizacion;
                        if(!$scope.isNull($scope.dtCapacitacionModelo.fechaFinalizacion) && !isNaN($scope.dtCapacitacionModelo.fechaFinalizacion)){
			    $scope.dtCapacitacionModelo.fechaFinalizacion = new Date($scope.dtCapacitacionModelo.fechaFinalizacion);
		        }
$scope.dtCapacitacionModelo.flagPubli = dtCapacitacionBk.flagPubli;
			$scope.dtCapacitacionModelo.idModalidad = dtCapacitacionBk.idModalidad;
			$scope.dtCapacitacionModelo.detalleCapaVirtual = dtCapacitacionBk.detalleCapaVirtual;
			$scope.dtCapacitacionModelo.fechaIniProgramada = dtCapacitacionBk.fechaIniProgramada;
                        if(!$scope.isNull($scope.dtCapacitacionModelo.fechaIniProgramada) && !isNaN($scope.dtCapacitacionModelo.fechaIniProgramada)){
			    $scope.dtCapacitacionModelo.fechaIniProgramada = new Date($scope.dtCapacitacionModelo.fechaIniProgramada);
		        }
$scope.dtCapacitacionModelo.fechaFinProgramada = dtCapacitacionBk.fechaFinProgramada;
                        if(!$scope.isNull($scope.dtCapacitacionModelo.fechaFinProgramada) && !isNaN($scope.dtCapacitacionModelo.fechaFinProgramada)){
			    $scope.dtCapacitacionModelo.fechaFinProgramada = new Date($scope.dtCapacitacionModelo.fechaFinProgramada);
		        }
$scope.dtCapacitacionModelo.fechaSoli = dtCapacitacionBk.fechaSoli;
                        if(!$scope.isNull($scope.dtCapacitacionModelo.fechaSoli) && !isNaN($scope.dtCapacitacionModelo.fechaSoli)){
			    $scope.dtCapacitacionModelo.fechaSoli = new Date($scope.dtCapacitacionModelo.fechaSoli);
		        }
$scope.dtCapacitacionModelo.stdIddoc = dtCapacitacionBk.stdIddoc;
			$scope.dtCapacitacionModelo.stdNumeroSid = dtCapacitacionBk.stdNumeroSid;
			$scope.dtCapacitacionModelo.stdNumeroAnio = dtCapacitacionBk.stdNumeroAnio;
			$scope.dtCapacitacionModelo.stdNumeroDoc = dtCapacitacionBk.stdNumeroDoc;
			$scope.dtCapacitacionModelo.stdAsunto = dtCapacitacionBk.stdAsunto;
			$scope.dtCapacitacionModelo.stdTipoDoc = dtCapacitacionBk.stdTipoDoc;
			$scope.dtCapacitacionModelo.stdFechaRecepcion = dtCapacitacionBk.stdFechaRecepcion;
                        if(!$scope.isNull($scope.dtCapacitacionModelo.stdFechaRecepcion) && !isNaN($scope.dtCapacitacionModelo.stdFechaRecepcion)){
			    $scope.dtCapacitacionModelo.stdFechaRecepcion = new Date($scope.dtCapacitacionModelo.stdFechaRecepcion);
		        }
$scope.dtCapacitacionModelo.stdModalidadIng = dtCapacitacionBk.stdModalidadIng;
			$scope.dtCapacitacionModelo.flagEjec = dtCapacitacionBk.flagEjec;
			$scope.dtCapacitacionModelo.motivoEjec = dtCapacitacionBk.motivoEjec;
			
                        // ADICIONALES
	                $scope.dtCapacitacionModelo.idLocalTxt = dtCapacitacionBk.idLocalTxt;
$scope.dtCapacitacionModelo.idUsuinternoTxt = dtCapacitacionBk.idUsuinternoTxt;
$scope.dtCapacitacionModelo.estadoTxt = dtCapacitacionBk.estadoTxt;
$scope.dtCapacitacionModelo.idModoTxt = dtCapacitacionBk.idModoTxt;
$scope.dtCapacitacionModelo.idNivelTxt = dtCapacitacionBk.idNivelTxt;
$scope.dtCapacitacionModelo.idOrigenTxt = dtCapacitacionBk.idOrigenTxt;
$scope.dtCapacitacionModelo.idPrestacionTxt = dtCapacitacionBk.idPrestacionTxt;
$scope.dtCapacitacionModelo.idProgramacionTxt = dtCapacitacionBk.idProgramacionTxt;
$scope.dtCapacitacionModelo.idTipoTxt = dtCapacitacionBk.idTipoTxt;
$scope.dtCapacitacionModelo.idSedeTxt = dtCapacitacionBk.idSedeTxt;
$scope.dtCapacitacionModelo.idSistAdmTxt = dtCapacitacionBk.idSistAdmTxt;
$scope.dtCapacitacionModelo.idFinanciaTxt = dtCapacitacionBk.idFinanciaTxt;
$scope.dtCapacitacionModelo.idModalidadTxt = dtCapacitacionBk.idModalidadTxt;

			$scope.dtCapacitacionModelo.editopcion = dtCapacitacionBk.dtCapacitacionACL.editopcion;
		}
	  // ////////////////////////////////////////////////
	  $scope.editarDtCapacitacion = function(ev, dtCapacitacionBk) {		  
		    $scope.setDtCapacitacionModelo(dtCapacitacionBk);		  
			$location.url('/editar/' + $scope.dtCapacitacionModelo.idCapacitacion);
			$scope.nuevo = false;
	  }
	  
	  $scope.nuevoDtCapacitacion = function() {
		    $scope.cleardtCapacitacion();
			$location.url('/nuevo');
			$scope.nuevo = true;
	  }
	  	  
	  $scope.cancelarDtCapacitacion = function() {
		    $scope.cleardtCapacitacion();
		    $location.url('/');
	  }
	  			  
	  $scope.salvarDtCapacitacion = function(ev){		
				    ev.target.disabled = true;
				    var datainsert = angular.toJson($scope.dtCapacitacionModelo);
		 			console.log("datainsert = "+datainsert);	
		        		$http.post(insertdtCapacitacionUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
							var dato = res.data;

//		    				$scope.datos.push(dato); 
		    				$scope.total = $scope.datos.length;
		    				
		    				$scope.setDtCapacitacionModelo(dato);
		    				
		    				$mdDialog.show(
							         $mdDialog.alert()
							        .parent(angular.element(document.body))
							        .clickOutsideToClose(true)
							        .title('Guardar Capacitaciones')
							        .textContent("del Capacitaciones se guardó correctamente.")
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
								        .title('Guardar Capacitaciones')
								        .textContent(dato.message)
								        .ariaLabel('ERROR')
								        .ok('OK')
								        .targetEvent(ev)
								    );
				            }
				        });		
		        			        	
		        	ev.target.disabled = false;
			 };
			 
	   $scope.eliminardtCapacitacion = function(ev,dtCapacitacionBk){		
				    ev.target.disabled = true;
				    $scope.setDtCapacitacionModelo(dtCapacitacionBk);
				    var datainsert = angular.toJson($scope.dtCapacitacionModelo);
		 			console.log("datainsert = "+datainsert);	
	        		$http.post(eliminardtCapacitacionUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
						var dato = res.data;
						var instrumentos = $scope.datos;
				        var index = $scope.datos.findIndex(obj => obj.idCapacitacion === dato.idCapacitacion);
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
					        .title('Eliminar Capacitaciones')
					        .textContent(dato.message)
					        .ariaLabel('ERROR')
					        .ok('OK')
					        .targetEvent(ev)
						   );
			            }
			        });			        			        	
		        	ev.target.disabled = false;
			 };	
			
		$scope.cargardtCapacitacion = function(idCapacitacion){		
			var surl = editardtCapacitacionUrl+idCapacitacion;
			$http.get(surl).then(function(res){
				var dato = res.data;
				$scope.setDtCapacitacionModelo(dato);
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
					        .title('Cargar Capacitaciones')
					        .textContent(dato.message)
					        .ariaLabel('ERROR')
					        .ok('OK')
						   );
			            }			           
			        });			        			        	
			 };
			 
		$scope.showConfirm = function(ev, dtCapacitacionBk) {
				    var confirm = $mdDialog.confirm()
				      .title('Eliminar Capacitaciones')
				      .textContent('Esta usted seguro de eliminar el registro?')
				      .ariaLabel('Lucky day')
				      .targetEvent(ev)
				      .ok('Si')
				      .cancel('No');

				    $mdDialog.show(confirm).then(function () {
				      $scope.status = 'SI';
				      $scope.eliminardtCapacitacion(ev, dtCapacitacionBk);
				    }, function () {
				      $scope.status = 'NO';
				    });
				  };		  
///ADICIONALES
//SELECT INI
        $scope.listaMsLocalIdLocal=[];
	$scope.loadListaMsLocalIdLocal=function(){
		$http.get(listaMsLocalidLocalIdLocalUrl).then(function(res){
			$scope.listaMsLocalIdLocal = res.data; 
		},
		function error(errResponse) {
			console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		});
	};
        $scope.changeIdLocal=function(){
          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
        }
        $scope.$watch('dtCapacitacionModelo.idLocal', function (newValue, oldValue) {
		console.log('dtCapacitacionModelo.idLocal ' + newValue+' -- '+oldValue);
		//CARGAR DATOS DEL SIGUIENTE SELECT
	});
//SELECT FIN                
//SELECT INI
        $scope.listaPrtParametrosIdModo=[];
	$scope.loadListaPrtParametrosIdModo=function(){
		$http.get(listaPrtParametrosidparametroIdModoUrl).then(function(res){
			$scope.listaPrtParametrosIdModo = res.data; 
		},
		function error(errResponse) {
			console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		});
	};
        $scope.changeIdModo=function(){
          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
        }
        $scope.$watch('dtCapacitacionModelo.idModo', function (newValue, oldValue) {
		console.log('dtCapacitacionModelo.idModo ' + newValue+' -- '+oldValue);
		//CARGAR DATOS DEL SIGUIENTE SELECT
	});
//SELECT FIN                
//SELECT INI
        $scope.listaPrtParametrosIdNivel=[];
	$scope.loadListaPrtParametrosIdNivel=function(){
		$http.get(listaPrtParametrosidparametroIdNivelUrl).then(function(res){
			$scope.listaPrtParametrosIdNivel = res.data; 
		},
		function error(errResponse) {
			console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		});
	};
        $scope.changeIdNivel=function(){
          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
        }
        $scope.$watch('dtCapacitacionModelo.idNivel', function (newValue, oldValue) {
		console.log('dtCapacitacionModelo.idNivel ' + newValue+' -- '+oldValue);
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
        $scope.$watch('dtCapacitacionModelo.idOrigen', function (newValue, oldValue) {
		console.log('dtCapacitacionModelo.idOrigen ' + newValue+' -- '+oldValue);
		//CARGAR DATOS DEL SIGUIENTE SELECT
	});
//SELECT FIN                
//SELECT INI
        $scope.listaPrtParametrosIdPrestacion=[];
	$scope.loadListaPrtParametrosIdPrestacion=function(){
		$http.get(listaPrtParametrosidparametroIdPrestacionUrl).then(function(res){
			$scope.listaPrtParametrosIdPrestacion = res.data; 
		},
		function error(errResponse) {
			console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		});
	};
        $scope.changeIdPrestacion=function(){
          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
        }
        $scope.$watch('dtCapacitacionModelo.idPrestacion', function (newValue, oldValue) {
		console.log('dtCapacitacionModelo.idPrestacion ' + newValue+' -- '+oldValue);
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
        $scope.$watch('dtCapacitacionModelo.idTipo', function (newValue, oldValue) {
		console.log('dtCapacitacionModelo.idTipo ' + newValue+' -- '+oldValue);
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
        $scope.$watch('dtCapacitacionModelo.idFinancia', function (newValue, oldValue) {
		console.log('dtCapacitacionModelo.idFinancia ' + newValue+' -- '+oldValue);
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
        $scope.$watch('dtCapacitacionModelo.idModalidad', function (newValue, oldValue) {
		console.log('dtCapacitacionModelo.idModalidad ' + newValue+' -- '+oldValue);
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
				  
		    $scope.nuevo = ($scope.isNumber($scope.dtCapacitacionModelo.idCapacitacion) && $scope.dtCapacitacionModelo.idCapacitacion > 0);
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
			 
			$scope.filtroDtCapacitacion = function(toma){				
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
