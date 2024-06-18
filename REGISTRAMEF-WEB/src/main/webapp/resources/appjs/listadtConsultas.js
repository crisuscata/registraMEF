var contexto = window.location.pathname.substring(0,window.location.pathname.indexOf('/',2));
var pglogoff = window.location.origin+contexto+'/logoff.htm';
var principalUrl = window.location.origin+contexto+'/index.htm';
var listadtConsultasUrl = contexto+"/rs/ctrldtConsultas/listadtConsultas";
var insertdtConsultasUrl = contexto+"/rs/ctrldtConsultas/salvardtConsultas";
var eliminardtConsultasUrl = contexto+"/rs/ctrldtConsultas/eliminardtConsultas";
var activardtConsultasUrl = contexto+"/rs/ctrldtConsultas/activardtConsultas";
var eliminarListadtConsultasUrl = contexto+"/rs/ctrldtConsultas/eliminarListadtConsultas";
var editardtConsultasUrl = contexto+"/rs/ctrldtConsultas/editardtConsultas/";
var listaDtUsuarioExternoidUsuexternoUrl = contexto+"/rs/ctrldtConsultas/listaDtUsuarioExternoIdUsuexterno/";
var listaDtUsuarioExternoXNombreUrl = contexto+"/rs/ctrldtConsultas/listaDtUsuarioExternoXNombre/";

var listaMsTemaidTemaIdTemaUrl = contexto+"/rs/ctrldtConsultas/listaMsTemaIdTemaIdTema";
var listaMsSubtemaidSubtemaIdSubtemaUrl = contexto+"/rs/ctrldtConsultas/listaMsSubtemaIdSubtemaIdSubtema";
var listaPrtParametrosidparametroIdPrestservicUrl = contexto+"/rs/ctrldtConsultas/listaPrtParametrosIdparametroIdPrestservic";
var listaPrtParametrosidparametroIdModalidadUrl = contexto+"/rs/ctrldtConsultas/listaPrtParametrosIdparametroIdModalidad";
var listaDtEntidadesidEntidadUrl = contexto+"/rs/ctrldtConsultas/listaDtEntidadesIdEntidad/";
var listaDtEntidadesXRazSocialUrl = contexto+"/rs/ctrldtConsultas/listaDtEntidadesXRazSocial/";

var listaPrtParametrosidparametroIdOrigenUrl = contexto+"/rs/ctrldtConsultas/listaPrtParametrosIdparametroIdOrigen";
var listaPrtParametrosidparametroIdCargoUrl = contexto+"/rs/ctrldtConsultas/listaPrtParametrosIdparametroIdCargo";
var listaMsSedesidSedeIdSedeUrl = contexto+"/rs/ctrldtConsultas/listaMsSedesIdSedeIdSede";
var descargarUrl = contexto+"/rs/ctrldtConsultas/descargar/";

///URLs CARGA DE ARCHIVOS
var insertDocUrl = contexto+"/rs/ctrldtConsultas/insertarchivo";
///FIN URLs CARGA DE ARCHIVOS

var descargarvistaUrl = contexto+"/rs/ctrldtConsultas/descargarvista";

/**
 * 
 */
myapp = angular.module('MyApp');

myapp.config(function($routeProvider) {
	  $routeProvider
	  .when("/editar/:idConsulta", {
		  templateUrl : "consultas/editardtConsultas.html",
		  controller : "ctrlListadtConsultas"
	  })
	  .when("/nuevo", {
		  templateUrl : "consultas/editardtConsultas.html",
		  controller : "ctrlListadtConsultas"
	  })
	  .otherwise({
		  templateUrl : "consultas/verdtConsultas.html",
		  controller : "ctrlListadtConsultas"  
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

myapp.controller('ctrlListadtConsultas', ['$mdEditDialog', '$scope', '$timeout', '$http', '$mdDialog','$location','$routeParams', '$mdPanel',  function ($mdEditDialog, $scope, $timeout, $http, $mdDialog, $location, $routeParams, $mdPanel) {
	'use strict';
	 
	 $scope.limitOptions = [100, 500, 1000, 5000];
	 $scope.query = {
			    order: 'idConsulta',
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
	  $scope.loaddtConsultass();
	 };
	 
	 $scope.logItem = function (item) {
	  console.log(item.name, 'was selected');
	 };
	 
	 $scope.logPagination = function (page, limit) {
	  console.log('page: ', page);
	  console.log('limit: ', limit);
	  $scope.loaddtConsultass();
         };
     $scope.creadtConsultas = false;
    // ///////////////////////////////////////////
	$scope.datos = [];
	$scope.total = 0;

	$scope.loaddtConsultass = function () {
	    //$scope.promise = $timeout(function () {
	    	var surl = $scope.getURL();	    
	    	$scope.promise = $http.get(surl).then(function(res){
	    		 $scope.datos = res.data.data;
	    		 if(res.data.contador>0)
	    		 $scope.total = res.data.contador;
	    		 var tiempoenBD = res.data.tiempoenBD;
	    		 var tiempoenproceso = res.data.tiempoenproceso;
	    		 $scope.creadtConsultas = res.data.creamodifica;
	    		 console.log("data " +$scope.datos.length+" DE "+ $scope.total);
	    		 console.log("Tiempo respuesta BD dtConsultas " +tiempoenBD+" Tiempo en Paginar "+tiempoenproceso);
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
						        .title('Lista de Consultas')
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
		  return listadtConsultasUrl+$scope.getURLParametros();
	  }
	  
	  $scope.editdtConsultas = function () {
		    $scope.nuevo = true;
		    var idConsulta = $routeParams.idConsulta;
		    if(idConsulta){
		    	$scope.cargardtConsultas(idConsulta);
		    }
		   ///CARGAR COMPLEMENTOS 
                $scope.loadListaMsTemaIdTema();//SELECT
                $scope.loadListaMsSubtemaIdSubtema();//SELECT
                $scope.loadListaPrtParametrosIdPrestservic();//SELECT
                $scope.loadListaPrtParametrosIdModalidad();//SELECT
                $scope.loadListaPrtParametrosIdOrigen();//SELECT
                $scope.loadListaPrtParametrosIdCargo();//SELECT
                $scope.loadListaMsSedesIdSede();//SELECT
		  };
	  
	  $scope.filtro ={
  fechaConsu: null,
  idUsuexterno: null,
  idSistAdm: null,
  idTema: null,
  idSubtema: null,
  estado: null,
  
         estado: null
		}; 
	  
	  $scope.seteestado = function(eestado) {
			if($scope.filtro.estado === eestado){
				$scope.filtro.estado = null;
			}else{
				$scope.filtro.estado = eestado;
			}
			$scope.loaddtConsultass();
		};
	  
         $scope.refrescarvista = function(ev){
		  if(typeof(ev)=='undefined' || ev==null){
	          
          }else{
			 var keyCode = ev.which || ev.keyCode;
			    if (keyCode === 13) {
			    	$scope.loaddtConsultass();
			    }else if (keyCode === 1) {
			    	$scope.loaddtConsultass();
			    }
          }
		};

	  $scope.dtConsultasModelo = {
			idConsulta : null,
			fechaConsu: new Date(),
nombre: null,
                      idUsuexterno: null,idSistAdm: null,
			idTema: null,
			idSubtema: null,
			estado: null,
			detalle: null,
			respuesta: null,
			idPrestservic: null,
			idModalidad: null,
			idUsuinterno: null,
			razSocial: null,
                      idEntidad: null,idOrigen: null,
			idCargo: null,
			idSede: null,
			correoUsuext: null,
			fijoUsuext: null,
			celularUsuext: null,
			fechaFinalizacion: new Date(),
fechaSoli: new Date(),

                        // ADICIONALES
	                idUsuexternoTxt: null,
idSistAdmTxt: null,
idTemaTxt: null,
idSubtemaTxt: null,
estadoTxt: null,
idPrestservicTxt: null,
idModalidadTxt: null,
idUsuinternoTxt: null,
idEntidadTxt: null,
idOrigenTxt: null,
idCargoTxt: null,
idSedeTxt: null,

		    editopcion: 1
		};
	  
	  $scope.cleardtConsultas = function(){
		    $scope.dtConsultasModelo.idConsulta = null;
		    $scope.dtConsultasModelo.fechaConsu = new Date();$scope.dtConsultasModelo.idUsuexterno = null;$scope.dtConsultasModelo.nombre = null;$scope.dtConsultasModelo.idSistAdm = null;
		    $scope.dtConsultasModelo.idTema = null;
		    $scope.dtConsultasModelo.idSubtema = null;
		    $scope.dtConsultasModelo.estado = null;
		    $scope.dtConsultasModelo.detalle = null;
		    $scope.dtConsultasModelo.respuesta = null;
		    $scope.dtConsultasModelo.idPrestservic = null;
		    $scope.dtConsultasModelo.idModalidad = null;
		    $scope.dtConsultasModelo.idUsuinterno = null;
		    $scope.dtConsultasModelo.idEntidad = null;$scope.dtConsultasModelo.razSocial = null;$scope.dtConsultasModelo.idOrigen = null;
		    $scope.dtConsultasModelo.idCargo = null;
		    $scope.dtConsultasModelo.idSede = null;
		    $scope.dtConsultasModelo.correoUsuext = null;
		    $scope.dtConsultasModelo.fijoUsuext = null;
		    $scope.dtConsultasModelo.celularUsuext = null;
		    $scope.dtConsultasModelo.fechaFinalizacion = new Date();$scope.dtConsultasModelo.fechaSoli = new Date();
                    // ADICIONALES
	            $scope.dtConsultasModelo.idUsuexternoTxt = null;
$scope.dtConsultasModelo.idSistAdmTxt = null;
$scope.dtConsultasModelo.idTemaTxt = null;
$scope.dtConsultasModelo.idSubtemaTxt = null;
$scope.dtConsultasModelo.estadoTxt = null;
$scope.dtConsultasModelo.idPrestservicTxt = null;
$scope.dtConsultasModelo.idModalidadTxt = null;
$scope.dtConsultasModelo.idUsuinternoTxt = null;
$scope.dtConsultasModelo.idEntidadTxt = null;
$scope.dtConsultasModelo.idOrigenTxt = null;
$scope.dtConsultasModelo.idCargoTxt = null;
$scope.dtConsultasModelo.idSedeTxt = null;

		    $scope.dtConsultasModelo.editopcion = 1;
	 } 
	 
	  $scope.setDtConsultasModelo = function(dtConsultasBk) {
		  $scope.dtConsultasModelo.idConsulta = dtConsultasBk.idConsulta;
			$scope.dtConsultasModelo.fechaConsu = dtConsultasBk.fechaConsu;
                        if(!$scope.isNull($scope.dtConsultasModelo.fechaConsu) && !isNaN($scope.dtConsultasModelo.fechaConsu)){
			    $scope.dtConsultasModelo.fechaConsu = new Date($scope.dtConsultasModelo.fechaConsu);
		        }
$scope.dtConsultasModelo.idUsuexterno = dtConsultasBk.idUsuexterno; $scope.dtConsultasModelo.nombre = dtConsultasBk.nombre;$scope.dtConsultasModelo.idSistAdm = dtConsultasBk.idSistAdm;
			$scope.dtConsultasModelo.idTema = dtConsultasBk.idTema;
			$scope.dtConsultasModelo.idSubtema = dtConsultasBk.idSubtema;
			$scope.dtConsultasModelo.estado = dtConsultasBk.estado;
			$scope.dtConsultasModelo.detalle = dtConsultasBk.detalle;
			$scope.dtConsultasModelo.respuesta = dtConsultasBk.respuesta;
			$scope.dtConsultasModelo.idPrestservic = dtConsultasBk.idPrestservic;
			$scope.dtConsultasModelo.idModalidad = dtConsultasBk.idModalidad;
			$scope.dtConsultasModelo.idUsuinterno = dtConsultasBk.idUsuinterno;
			$scope.dtConsultasModelo.idEntidad = dtConsultasBk.idEntidad; $scope.dtConsultasModelo.razSocial = dtConsultasBk.razSocial;$scope.dtConsultasModelo.idOrigen = dtConsultasBk.idOrigen;
			$scope.dtConsultasModelo.idCargo = dtConsultasBk.idCargo;
			$scope.dtConsultasModelo.idSede = dtConsultasBk.idSede;
			$scope.dtConsultasModelo.correoUsuext = dtConsultasBk.correoUsuext;
			$scope.dtConsultasModelo.fijoUsuext = dtConsultasBk.fijoUsuext;
			$scope.dtConsultasModelo.celularUsuext = dtConsultasBk.celularUsuext;
			$scope.dtConsultasModelo.fechaFinalizacion = dtConsultasBk.fechaFinalizacion;
                        if(!$scope.isNull($scope.dtConsultasModelo.fechaFinalizacion) && !isNaN($scope.dtConsultasModelo.fechaFinalizacion)){
			    $scope.dtConsultasModelo.fechaFinalizacion = new Date($scope.dtConsultasModelo.fechaFinalizacion);
		        }
$scope.dtConsultasModelo.fechaSoli = dtConsultasBk.fechaSoli;
                        if(!$scope.isNull($scope.dtConsultasModelo.fechaSoli) && !isNaN($scope.dtConsultasModelo.fechaSoli)){
			    $scope.dtConsultasModelo.fechaSoli = new Date($scope.dtConsultasModelo.fechaSoli);
		        }

                        // ADICIONALES
	                $scope.dtConsultasModelo.idUsuexternoTxt = dtConsultasBk.idUsuexternoTxt;
$scope.dtConsultasModelo.idSistAdmTxt = dtConsultasBk.idSistAdmTxt;
$scope.dtConsultasModelo.idTemaTxt = dtConsultasBk.idTemaTxt;
$scope.dtConsultasModelo.idSubtemaTxt = dtConsultasBk.idSubtemaTxt;
$scope.dtConsultasModelo.estadoTxt = dtConsultasBk.estadoTxt;
$scope.dtConsultasModelo.idPrestservicTxt = dtConsultasBk.idPrestservicTxt;
$scope.dtConsultasModelo.idModalidadTxt = dtConsultasBk.idModalidadTxt;
$scope.dtConsultasModelo.idUsuinternoTxt = dtConsultasBk.idUsuinternoTxt;
$scope.dtConsultasModelo.idEntidadTxt = dtConsultasBk.idEntidadTxt;
$scope.dtConsultasModelo.idOrigenTxt = dtConsultasBk.idOrigenTxt;
$scope.dtConsultasModelo.idCargoTxt = dtConsultasBk.idCargoTxt;
$scope.dtConsultasModelo.idSedeTxt = dtConsultasBk.idSedeTxt;

			$scope.dtConsultasModelo.editopcion = dtConsultasBk.dtConsultasACL.editopcion;
		}
	  // ////////////////////////////////////////////////
	  $scope.editarDtConsultas = function(ev, dtConsultasBk) {		  
		    $scope.setDtConsultasModelo(dtConsultasBk);		  
			$location.url('/editar/' + $scope.dtConsultasModelo.idConsulta);
			$scope.nuevo = false;
	  }
	  
	  $scope.nuevoDtConsultas = function() {
		    $scope.cleardtConsultas();
			$location.url('/nuevo');
			$scope.nuevo = true;
	  }
	  	  
	  $scope.cancelarDtConsultas = function() {
		    $scope.cleardtConsultas();
		    $location.url('/');
	  }
	  			  
	  $scope.salvarDtConsultas = function(ev){		
				    ev.target.disabled = true;
				    var datainsert = angular.toJson($scope.dtConsultasModelo);
		 			console.log("datainsert = "+datainsert);	
		        		$http.post(insertdtConsultasUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
							var dato = res.data;

//		    				$scope.datos.push(dato); 
		    				$scope.total = $scope.datos.length;
		    				
		    				$scope.setDtConsultasModelo(dato);
		    				
		    				$mdDialog.show(
							         $mdDialog.alert()
							        .parent(angular.element(document.body))
							        .clickOutsideToClose(true)
							        .title('Guardar Consultas')
							        .textContent("del Consultas se guardó correctamente.")
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
								        .title('Guardar Consultas')
								        .textContent(dato)
								        .ariaLabel('ERROR')
								        .ok('OK')
								        .targetEvent(ev)
								    );
				            }
				        });		
		        			        	
		        	ev.target.disabled = false;
			 };
			 
	   $scope.eliminardtConsultas = function(ev,dtConsultasBk){		
				    ev.target.disabled = true;
				    $scope.setDtConsultasModelo(dtConsultasBk);
				    var datainsert = angular.toJson($scope.dtConsultasModelo);
		 			console.log("Eliminar = "+datainsert);	
	        		$http.post(eliminardtConsultasUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
						var dato = res.data;
						var instrumentos = $scope.datos;
				        var index = $scope.datos.findIndex(obj => obj.idConsulta === dato.idConsulta);
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
					        .title('Eliminar Consultas')
					        .textContent(dato)
					        .ariaLabel('ERROR')
					        .ok('OK')
					        .targetEvent(ev)
						   );
			            }
			        });			        			        	
		        	ev.target.disabled = false;
			 };

            $scope.activardtConsultas = function(ev,dtConsultasBk){		
				    ev.target.disabled = true;
				    $scope.setDtConsultasModelo(dtConsultasBk);
				    var datainsert = angular.toJson($scope.dtConsultasModelo);
		 			console.log("Activar = "+datainsert);	
	        		$http.post(activardtConsultasUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
						var dato = res.data;
						var instrumentos = $scope.datos;
				        var index = $scope.datos.findIndex(obj => obj.idConsulta === dato.idConsulta);
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
					        .title('Activar Consultas')
					        .textContent(dato)
					        .ariaLabel('ERROR')
					        .ok('OK')
					        .targetEvent(ev)
						   );
			            }
			        });			        			        	
		        	ev.target.disabled = false;
			 };

            $scope.eliminarListadtConsultas = function(ev){		
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
				             listaids.push($scope.selected[i].idConsulta);
			                 }
                                    } 
				    
				    var datainsert = angular.toJson(listaids);
		 			console.log("Elimiar = "+datainsert);	
	        		$http.post(eliminarListadtConsultasUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
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
					        .title('Eliminar Consultas')
					        .textContent(dato)
					        .ariaLabel('ERROR')
					        .ok('OK')
					        .targetEvent(ev)
						   );
			            }
			        });			        			        	
		        	ev.target.disabled = false;
			 };	
			
		$scope.cargardtConsultas = function(idConsulta){		
			var surl = editardtConsultasUrl+idConsulta;
			$http.get(surl).then(function(res){
				var dato = res.data;
				$scope.setDtConsultasModelo(dato);
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
					        .title('Cargar Consultas')
					        .textContent(dato)
					        .ariaLabel('ERROR')
					        .ok('OK')
						   );
			            }			           
			        });			        			        	
			 };
			 
		$scope.showConfirm = function(ev, dtConsultasBk) {
				    var confirm = $mdDialog.confirm()
				      .title('Activar Consultas')
				      .textContent('Esta usted seguro de activar el registro?')
				      .ariaLabel('Lucky day')
				      .targetEvent(ev)
				      .ok('Si')
				      .cancel('No');

				    $mdDialog.show(confirm).then(function () {
				      $scope.status = 'SI';
				      $scope.eliminardtConsultas(ev, dtConsultasBk);
				    }, function () {
				      $scope.status = 'NO';
				    });
				  };

                $scope.showConfirmActivar = function(ev, dtConsultasBk) {
				    var confirm = $mdDialog.confirm()
				      .title('Activar Consultas')
				      .textContent('Esta usted seguro de activar el registro?')
				      .ariaLabel('Lucky day')
				      .targetEvent(ev)
				      .ok('Si')
				      .cancel('No');

				    $mdDialog.show(confirm).then(function () {
				      $scope.status = 'SI';
				      $scope.activardtConsultas(ev, dtConsultasBk);
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
				      .title('Eliminar Consultas')
				      .textContent('Esta usted seguro de eliminar los '+tamanio+' registros seleccionados?')
				      .ariaLabel('Lucky day')
				      .targetEvent(ev)
				      .ok('Si')
				      .cancel('No');

				    $mdDialog.show(confirm).then(function () {
				      $scope.status = 'SI';
				      $scope.eliminarListadtConsultas(ev);
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
               $scope.dtConsultasModelo.idUsuexterno = item.idUsuexterno;
               $scope.dtConsultasModelo.idUsuexternoTxt = item.nombre;
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
            if(!$scope.isString($scope.dtConsultasModelo.nombre)){
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
            $scope.dtConsultasModelo.idUsuexterno = null;
            $scope.dtConsultasModelo.idUsuexternoTxt = null;
            $scope.dlgDtUsuarioExternoDtoss = [];
	    $scope.dlgDtUsuarioExternototal = 0;
            var surl = listaDtUsuarioExternoXNombreUrl+$scope.dtConsultasModelo.nombre;
            $scope.dlgDtUsuarioExternopromise== $http.get(surl).then(function(res){
		var dato = res.data;
		if(dato.length==0){
			$mdDialog.show(
                            $mdDialog.alert()
                            .parent(angular.element(document.body))
                            .clickOutsideToClose(true)
                            .title('BUSCAR POR NOMBRE')
                            .textContent("NO SE ENCONTRARON DATOS CON "+$scope.dtConsultasModelo.nombre)
                            .ariaLabel('BUSQUEDA')
                            .ok('OK')
                            .targetEvent(ev)
			);
		} else if(dato.length==1){
			var item = dato[0];				               
			if($scope.isObject(item)){
				console.log('Item changed to ' + JSON.stringify(item));
				$scope.dtConsultasModelo.idUsuexterno = item.idUsuexterno;
                                $scope.dtConsultasModelo.idUsuexternoTxt = item.nombre;
                                $scope.dtConsultasModelo.nombre = item.nombre; 
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
                $scope.dtConsultasModelo.idUsuexterno = item.idUsuexterno;
                $scope.dtConsultasModelo.idUsuexternoTxt = item.nombre;
                $scope.dtConsultasModelo.nombre = item.nombre; 
                $scope.cancel();
            }
	};        
//FIN DE SEARCH X Nombre
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
        $scope.$watch('dtConsultasModelo.idTema', function (newValue, oldValue) {
		console.log('dtConsultasModelo.idTema ' + newValue+' -- '+oldValue);
		//CARGAR DATOS DEL SIGUIENTE SELECT
//	if($scope.isArray($scope.listaMsTemaIdTema)){
//		var obj = $scope.listaMsTemaIdTema.find(o => o.id === newValue);
//		if($scope.isObject(obj)){
//			$scope.msTemaModelo.idTemaTxt = obj.valor;
//		}
//	}
	});
//SELECT FIN                
//SELECT INI
        $scope.listaMsSubtemaIdSubtema=[];
	$scope.loadListaMsSubtemaIdSubtema=function(){
		$http.get(listaMsSubtemaidSubtemaIdSubtemaUrl).then(function(res){
			$scope.listaMsSubtemaIdSubtema = res.data; 
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
        $scope.changeIdSubtema=function(){
          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
        }
        $scope.$watch('dtConsultasModelo.idSubtema', function (newValue, oldValue) {
		console.log('dtConsultasModelo.idSubtema ' + newValue+' -- '+oldValue);
		//CARGAR DATOS DEL SIGUIENTE SELECT
//	if($scope.isArray($scope.listaMsSubtemaIdSubtema)){
//		var obj = $scope.listaMsSubtemaIdSubtema.find(o => o.id === newValue);
//		if($scope.isObject(obj)){
//			$scope.msSubtemaModelo.idSubtemaTxt = obj.valor;
//		}
//	}
	});
//SELECT FIN                
//SELECT INI
        $scope.listaPrtParametrosIdPrestservic=[];
	$scope.loadListaPrtParametrosIdPrestservic=function(){
		$http.get(listaPrtParametrosidparametroIdPrestservicUrl).then(function(res){
			$scope.listaPrtParametrosIdPrestservic = res.data; 
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
        $scope.changeIdPrestservic=function(){
          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
        }
        $scope.$watch('dtConsultasModelo.idPrestservic', function (newValue, oldValue) {
		console.log('dtConsultasModelo.idPrestservic ' + newValue+' -- '+oldValue);
		//CARGAR DATOS DEL SIGUIENTE SELECT
//	if($scope.isArray($scope.listaPrtParametrosIdPrestservic)){
//		var obj = $scope.listaPrtParametrosIdPrestservic.find(o => o.id === newValue);
//		if($scope.isObject(obj)){
//			$scope.prtParametrosModelo.idparametroTxt = obj.valor;
//		}
//	}
	});
//SELECT FIN                
//SELECT INI
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
          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
        }
        $scope.$watch('dtConsultasModelo.idModalidad', function (newValue, oldValue) {
		console.log('dtConsultasModelo.idModalidad ' + newValue+' -- '+oldValue);
		//CARGAR DATOS DEL SIGUIENTE SELECT
//	if($scope.isArray($scope.listaPrtParametrosIdModalidad)){
//		var obj = $scope.listaPrtParametrosIdModalidad.find(o => o.id === newValue);
//		if($scope.isObject(obj)){
//			$scope.prtParametrosModelo.idparametroTxt = obj.valor;
//		}
//	}
	});
//SELECT FIN                
//SEARCH X RazSocial
       $scope.ctrlDtEntidadesIdEntidad={
         simulateQuery: false,
         isDisabled: false,
         selectedItem: null
        };
       
        $scope.newStateDtEntidadesIdEntidad=function(state) {
             console.log("¡Lo siento! ¡Primero tendrás que crear una Constitución para " + state+"! ");
        }

        $scope.listaDtEntidadesIdEntidad=[];
        $scope.querySearchDtEntidadesIdEntidad = function(query) {
//          var results = query ? $scope.listaDtEntidadesIdEntidad.filter($scope.createFilterForDtEntidadesIdEntidad(query)) : $scope.listaDtEntidadesIdEntidad,
//          return results;
            var sUrl = listaDtEntidadesidEntidadUrl+query;
            return $http.get(sUrl).then(function(res){
                        $scope.listaDtEntidadesIdEntidad = res.data;
                        return $scope.listaDtEntidadesIdEntidad;
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

         $scope.createFilterForDtEntidadesIdEntidad = function(query) {
                var upperCaseQuery = query.toUpperCase();
                return function filterFn(item) {
                  return (item.razSocial.indexOf(upperCaseQuery) === 0);
                };
        };

        $scope.searchTextChangeDtEntidadesIdEntidad = function(text) {
            console.log('Text changed to ' + text);
        }

        $scope.selectedItemChangeDtEntidadesIdEntidad = function(item) {
           if($scope.isObject(item)){
               console.log('Item changed to ' + JSON.stringify(item));
               $scope.dtConsultasModelo.idEntidad = item.idEntidad;
               $scope.dtConsultasModelo.idEntidadTxt = item.razSocial;
            }
        } 
////////////////////////////////////////////////////////////////////////////////
        
        $scope.listaDtEntidadesXRazSocial=[];
        $scope.dlgDtEntidadeslimitOptions = [50,100, 500, 1000];
	$scope.dlgDtEntidadesquery = {
			order: 'idEntidad',
			limit: 50,
			page: 1
	};
	$scope.dlgDtEntidadesselected = [];
        $scope.dlgDtEntidadesoptions = {
			rowSelection: true,
			multiSelect: false,
			autoSelect: true,
			decapitate: false,
			largeEditDialog: false,
			boundaryLinks: true,
			limitSelect: true,
			pageSelect: true
	};
        $scope.dlgDtEntidadesfiltro ={
			idEntidad: null,
			razSocial: null,
	};
        $scope.dlgDtEntidadesDtoss = [];
	$scope.dlgDtEntidadestotal = 0;

        $scope.dlgDtEntidadespromise=$timeout(function (){
               console.log("Listo");
        }, 500);        

        $scope.showDtEntidadesDialog = function(ev) {		
		$mdDialog.show({
			contentElement: '#dtEntidadesDialog',
			parent: angular.element(document.body),
			targetEvent: ev,
			clickOutsideToClose: true
		});
	};

        $scope.searchDtEntidadesByRazSocial = function(ev){
            if(!$scope.isString($scope.dtConsultasModelo.razSocial)){
                    $mdDialog.show(
                        $mdDialog.alert()
                        .parent(angular.element(document.body))
                        .clickOutsideToClose(true)
                        .title('Dato incorrecto!')
                        .textContent('Ingrese el valor del RazSocial en el cuadro de busqueda.')
                        .ariaLabel('ERROR')
                        .ok('OK')
                        .targetEvent(ev)
                    );
                    return;
            }            
            $scope.dtConsultasModelo.idEntidad = null;
            $scope.dtConsultasModelo.idEntidadTxt = null;
            $scope.dlgDtEntidadesDtoss = [];
	    $scope.dlgDtEntidadestotal = 0;
            var surl = listaDtEntidadesXRazSocialUrl+$scope.dtConsultasModelo.razSocial;
            $scope.dlgDtEntidadespromise== $http.get(surl).then(function(res){
		var dato = res.data;
		if(dato.length==0){
			$mdDialog.show(
                            $mdDialog.alert()
                            .parent(angular.element(document.body))
                            .clickOutsideToClose(true)
                            .title('BUSCAR POR RAZSOCIAL')
                            .textContent("NO SE ENCONTRARON DATOS CON "+$scope.dtConsultasModelo.razSocial)
                            .ariaLabel('BUSQUEDA')
                            .ok('OK')
                            .targetEvent(ev)
			);
		} else if(dato.length==1){
			var item = dato[0];				               
			if($scope.isObject(item)){
				console.log('Item changed to ' + JSON.stringify(item));
				$scope.dtConsultasModelo.idEntidad = item.idEntidad;
                                $scope.dtConsultasModelo.idEntidadTxt = item.razSocial;
                                $scope.dtConsultasModelo.razSocial = item.razSocial; 
			}
		} else if(dato.length>1){
			$scope.dlgDtEntidadesDtoss = dato;
			$scope.dlgDtEntidadestotal = dato.length;
			$scope.showDtEntidadesDialog(ev);
		}
	},
	function error(errResponse) {
		console.log("Buscar x RazSocial data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		var dato = errResponse.data;
		if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
			$mdDialog.show(
                            $mdDialog.alert()
                            .parent(angular.element(document.body))
                            .clickOutsideToClose(true)
                            .title('Buscar x RAZSOCIAL - Kamachiq')
                            .textContent(dato.message)
                            .ariaLabel('ERROR')
                            .ok('OK')
                            .targetEvent(ev)
			);
		}              
	});
        };
        $scope.dlgDtEntidadesrefrescarvista = function(ev){
		var keyCode = ev.which || ev.keyCode;
		if (keyCode === 13) {
		}
	};

        $scope.seleccionadodlgDtEntidades = function(ev) {
            if($scope.isObject(ev)){
                var item = ev;
                $scope.dtConsultasModelo.idEntidad = item.idEntidad;
                $scope.dtConsultasModelo.idEntidadTxt = item.razSocial;
                $scope.dtConsultasModelo.razSocial = item.razSocial; 
                $scope.cancel();
            }
	};        
//FIN DE SEARCH X RazSocial
//SELECT INI
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
          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
        }
        $scope.$watch('dtConsultasModelo.idOrigen', function (newValue, oldValue) {
		console.log('dtConsultasModelo.idOrigen ' + newValue+' -- '+oldValue);
		//CARGAR DATOS DEL SIGUIENTE SELECT
//	if($scope.isArray($scope.listaPrtParametrosIdOrigen)){
//		var obj = $scope.listaPrtParametrosIdOrigen.find(o => o.id === newValue);
//		if($scope.isObject(obj)){
//			$scope.prtParametrosModelo.idparametroTxt = obj.valor;
//		}
//	}
	});
//SELECT FIN                
//SELECT INI
        $scope.listaPrtParametrosIdCargo=[];
	$scope.loadListaPrtParametrosIdCargo=function(){
		$http.get(listaPrtParametrosidparametroIdCargoUrl).then(function(res){
			$scope.listaPrtParametrosIdCargo = res.data; 
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
        $scope.changeIdCargo=function(){
          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
        }
        $scope.$watch('dtConsultasModelo.idCargo', function (newValue, oldValue) {
		console.log('dtConsultasModelo.idCargo ' + newValue+' -- '+oldValue);
		//CARGAR DATOS DEL SIGUIENTE SELECT
//	if($scope.isArray($scope.listaPrtParametrosIdCargo)){
//		var obj = $scope.listaPrtParametrosIdCargo.find(o => o.id === newValue);
//		if($scope.isObject(obj)){
//			$scope.prtParametrosModelo.idparametroTxt = obj.valor;
//		}
//	}
	});
//SELECT FIN                
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
          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
        }
        $scope.$watch('dtConsultasModelo.idSede', function (newValue, oldValue) {
		console.log('dtConsultasModelo.idSede ' + newValue+' -- '+oldValue);
		//CARGAR DATOS DEL SIGUIENTE SELECT
//	if($scope.isArray($scope.listaMsSedesIdSede)){
//		var obj = $scope.listaMsSedesIdSede.find(o => o.id === newValue);
//		if($scope.isObject(obj)){
//			$scope.msSedesModelo.idSedeTxt = obj.valor;
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
				  
		    $scope.nuevo = ($scope.isNumber($scope.dtConsultasModelo.idConsulta) && $scope.dtConsultasModelo.idConsulta > 0);
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
			 
			$scope.filtroDtConsultas = function(toma){				
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
