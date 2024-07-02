//MPINARES 14022024 - INICIO - NUEVA JS
var contexto = window.location.pathname.substring(0,window.location.pathname.indexOf('/',2));
var pglogoff = window.location.origin+contexto+'/logoff.htm';
var principalUrl = window.location.origin+contexto+'/index.htm';
var listadtAsistenciaUrl = contexto+"/rs/ctrldtAsistencia/listadtAsistenciaNoProg";
var insertdtAsistenciaUrl = contexto+"/rs/ctrldtAsistencia/salvardtAsistenciaNoProg";
var validarCambiosAsistenciaUrl = contexto+"/rs/ctrldtAsistencia/validarCambiosAsistencia";
var finalizardtAsistenciaUrl = contexto+"/rs/ctrldtAsistencia/finalizardtAsistencia";
var eliminardtAsistenciaUrl = contexto+"/rs/ctrldtAsistencia/eliminardtAsistencia";
var editardtAsistenciaUrl = contexto+"/rs/ctrldtAsistencia/editardtAsistencia/";
var enviarConstanciaAtencionUrl = contexto+"/rs/ctrldtAsistencia/enviarConstanciaAtencion";
var listaDtEntidadesidEntidadIdEntidadUrl = contexto+"/rs/ctrldtAsistencia/listaDtEntidadesIdEntidadIdEntidad";
var listaPrtParametrosidparametroIdOrigenUrl = contexto+"/rs/ctrldtAsistencia/listaPrtParametrosIdparametroIdOrigen";
var listaPrtParametrosidparametroIdModalidadUrl = contexto+"/rs/ctrldtAsistencia/listaPrtParametrosIdparametroIdModalidad";
var listaPrtParametrosidparametroIdFinanciaUrl = contexto+"/rs/ctrldtAsistencia/listaPrtParametrosIdparametroIdFinancia";
var listaDtUsuarioXNombreapellidoUrl = contexto+"/rs/ctrldtAsistencia/buscarDtUsuarioXnombre/";
var listaCargoPorIdUsuarioExtUrl = contexto+"/rs/ctrldtAsistencia/listaCargoPorIdUsuarioExt/";
var descargarUrl = contexto+"/rs/ctrldtAsistencia/descargar/";

///URLs CARGA DE ARCHIVOS
var insertDocUrl = contexto+"/rs/ctrldtAsistencia/insertarchivo";
var descargarUrl = contexto+"/rs/ctrldtAsistencia/descargar/";
///FIN URLs CARGA DE ARCHIVOS

var descargarvistaUrl = contexto+"/rs/ctrldtAsistencia/descargarvista";


var buscarCodEjecUrl = contexto+"/rs/ctrldtAsistencia/buscarcodejec/";
var listaMsTemaidTemaIdTemaUrl = contexto+"/rs/ctrldtAsistencia/listaMsTemaIdTemaIdTema";
var listaMsSubtemaidSubtemaIdSubtemaUrl = contexto+"/rs/ctrldtAsistencia/listaMsSubtemaIdSubtemaIdSubtema/";
var listaMsSedesUrl = contexto+"/rs/ctrldtAsistencia/listamsSedes";
var eliminardtAsistenciaTemasUrl = contexto+"/rs/ctrldtAsistencia/eliminardtAsistenciaTema";
var eliminardtAsistenciaUsuariosUrl = contexto+"/rs/ctrldtAsistencia/eliminardtAsistenciaUsuario";
var listaMsInstitucionesidproveeUrl = contexto+"/rs/ctrldtAsistencia/listaMsInstitucionesIdprovee/";
var listaPrtParametrosidparametroIdTipoEntidadUrl = contexto+"/rs/ctrldtAsistencia/listaPrtParametrosIdparametroIdTipoEntidad";
var listaPrtParametrosidparametroIdCaracteristicaUrl = contexto+"/rs/ctrldtAsistencia/listaPrtParametrosIdparametroIdCaracteristica";
var listaPaisesUrl = contexto+"/rs/ctrldtAsistencia/listaPaises";
var listaCoddptosUrl = contexto+"/rs/ctrldtAsistencia/listaCoddptos";
var ubigeodefectoUrl = contexto+"/rs/ctrldtAsistencia/ubigeodefecto";
var listaCodprovUrl = contexto+"/rs/ctrldtAsistencia/listaCodprov/";
var listaCoddistUrl = contexto+"/rs/ctrldtAsistencia/listaCoddist/";
var insertdtEntidadesUrl = contexto+"/rs/ctrldtAsistencia/salvardtEntidades";
//var listamsSisAdminUrl = contexto+"/rs/ctrldtAsistencia/listamsSisAdmin";
var anulardtAsistenciaUrl = contexto+"/rs/ctrldtAsistencia/anulardtAsistenciaList";
var reactivardtAsistenciaUrl = contexto+"/rs/ctrldtAsistencia/reactivardtAsistencia";
var buscarPorNumDocUrl = contexto+"/rs/ctrldtAsistencia/buscarPorNumDoc/";
var descargarFormatoUrl = contexto+"/rs/ctrldtAsistencia/descargarFormato/";

/**
 * 
 */
myapp = angular.module('MyApp');

myapp.config(function($routeProvider) {
	  $routeProvider
	  .when("/editar/:idAsistencia", {
		  templateUrl : "asistencia/editardtAsistenciaNoProg.html",
		  controller : "ctrlListadtAsistencia"
	  })
	  .when("/nuevo", {
		  templateUrl : "asistencia/editardtAsistenciaNoProg.html",
		  controller : "ctrlListadtAsistencia"
	  })
	  .otherwise({
		  templateUrl : "asistencia/verdtAsistenciaNoProg.html",
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

myapp.directive('ngFileModel', function () {
	return {
		scope:true,
		link: function (scope, element, attrs) {
			console.log("ngFileModel link2");
			var letraatrib = attrs.letter==null?'':attrs.letter;
			element.bind('change', function (changeEvent) {                  		
				var files = changeEvent.target.files;
				for (var i = 0;i<files.length;i++) {
					var name = files[i].name.toLowerCase();
					if ( /\.(jpe?g|png|gif|html|pdf|msg|doc?x|xls?x)$/i.test(name) ) {
						cargar(files[i],letraatrib);               	
					}
				}                                       
			});

			function cargarBase64(archivo){
				var reader = new FileReader();
				reader.onload = function (loadEvent) {
					var ngFileModel = {
							lastModified: archivo.lastModified,
							lastModifiedDate: archivo.lastModifiedDate,
							name: archivo.name,
							tamanio: archivo.size,
							tipo: archivo.type,
							data: loadEvent.target.result
					};
					scope.$emit("fileSelected", ngFileModel);

				}
				reader.readAsDataURL(archivo);
			}

			function cargar(archivo,letraatrib){
				console.log("ngFileModel cargar");
				// emit event upward
				var ngFileModel = {
						iddocumento: null,
						lastmodified: archivo.lastModified,						
						filenameoriginal: archivo.name,
						filename: null,
						tamanio: archivo.size,
						tipo: archivo.type,
						tipodocumento: null,
						data: archivo,
						letter:letraatrib
				};
				scope.$emit("fileSelected", ngFileModel);
			}
		},//FIN FUNCION LINK
	};
});

myapp.service('fileUploadServ', ['$http','$mdDialog',
						function ($http,$mdDialog) {
	
	this.uploadFileToUrl = function(posicion, archivo, uploadUrl){
		var reader = {};
		var slice_size = 1000 * 1024;
		var file = archivo.data;

		function start_upload() {
			reader = new FileReader();
			upload_file( 0 );
		}

		function upload_file( start ) {

			var next_slice = start + slice_size + 1;
			var blob = file.slice( start, next_slice );

			reader.onloadend = function(event) {
				if ( event.target.readyState !== FileReader.DONE ) {
					return;
				}
				$http( {
					url: uploadUrl,
					method: 'POST', 
					headers: { 'Content-Type': 'application/json' },
					transformRequest: angular.identity,
					data: angular.toJson({
						iddocumento: archivo.iddocumento,
						lastmodified: archivo.lastmodified,						
						filenameoriginal: archivo.filenameoriginal,
						filename: archivo.filename,
						tamanio: archivo.tamanio,
						tipo: archivo.tipo,
						tipodocumento: archivo.tipodocumento,
						data: event.target.result 	
					})    				
				}).then(function (response){
					var data = response.data; 
					console.log( "SUCCESS: "+response);
					if(archivo.filename=== null)
						archivo.filename = data.filename;    					
					var size_done = start + slice_size;
					var percent_done = Math.floor( ( size_done / archivo.tamanio ) * 100 );    					
					if ( next_slice < archivo.tamanio ) {
						// Update upload progress
						document.getElementById('dbi-upload-progress'+archivo.letter+'_'+posicion).innerHTML = 'Uploading File - ' + percent_done + '%' ;
						// More to upload, call function recursively
						document.getElementById('progress-bar'+archivo.letter+'_'+posicion).style.width = percent_done+ '%';
						document.getElementById('progress-bar'+archivo.letter+'_'+posicion).innerHTML = percent_done+ '%';

						upload_file( next_slice );
					} else {
						document.getElementById('dbi-upload-progress'+archivo.letter+'_'+posicion).innerHTML = 'Upload Complete!' ;
						document.getElementById('progress-bar'+archivo.letter+'_'+posicion).style.width = '100%';
						document.getElementById('progress-bar'+archivo.letter+'_'+posicion).innerHTML = '100%';
						archivo.data = null;
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
								.title('Cargar archivos')
								.textContent(dato.message)
								.ariaLabel('ERROR')
								.ok('OK')
								.targetEvent(event)
						);
					}
				})    			
			};
			reader.readAsDataURL(blob);
		}

		start_upload();

		function uuidv4() {
			return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
				var r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
				return v.toString(16);
			});
		}

		function to2digit(n) {
			return ('00' + n).slice(-2);
		}
	}
}]);

myapp.controller('ctrlListadtAsistencia', ['$mdEditDialog', '$scope', '$timeout', '$http', '$mdDialog','$location','$routeParams', '$mdPanel',  'fileUploadServ',
								  function ($mdEditDialog,   $scope,   $timeout,   $http,   $mdDialog,  $location,  $routeParams,   $mdPanel, fileUploadSrv) {
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
	$scope.archivos = [];
	
	$scope.uploadFile = function () {
		console.log("UPLOAD FILE");
		
		console.log("JSON.stringify( $scope.archivos ) : " + JSON.stringify( $scope.archivos ));
	}

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
						        .title('Lista de asistencia Técnica')
						        .textContent(dato.message)
						        .ariaLabel('ERROR')
						        .ok('OK')
						    );
		            }
		        });			 
	     //}, 500);
	    	
	    	///CARGAR COMPLEMENTOS 
            $scope.loadlistaMsSedes();//SELECT
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
				
				if(!$scope.isNull(valor) && ($scope.isDate(valor))){
					if(elprimero){
						elprimero=false;
						filtroparametro += "?"+key+"="+$scope.formatDateOnly(valor);
					}else{
						filtroparametro += "&"+key+"="+$scope.formatDateOnly(valor);
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
                $scope.loadListaMsTemaIdTema();//SELECT
//                $scope.loadListaMsSubtemaIdSubtema();//SELECT
                
		  };
	  
		
		  $scope.firstDate = function(dia){
			  dia.setDate(1);
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
			  const month = dia.getMonth() + 1; 
			  dia = new Date(year, month, 0);
			  return dia; 
		  }
		  
		
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
			  idProgramacion: null
		}; 
	
	  
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
//        	 var keyCode = ev.which || ev.keyCode;
//     		if (keyCode === 13) {
//     			$scope.loaddtAsistencias();
//     		}
		};

          $scope.descargarvista = function(){
        	  return descargarvistaUrl + $scope.getURLParametros();
//			  if(typeof(ev)=='undefined' || ev==null){
//				  return "#";
//	          }else{
//	        	  return descargarvistaUrl;
//	        	  }
	    };
	    
	    $scope.dtAsistenciaAnular = {
				idAsistencia : null,
				detalle: null
			};
	    
	    $scope.setDtAsistenciaAnular = function(dtAsistenciaBk) {
			  $scope.dtAsistenciaAnular.idAsistencia = dtAsistenciaBk.idAsistencia;
			  $scope.dtAsistenciaAnular.detalle = dtAsistenciaBk.detalle;
				
			};
	    $scope.cleardtAsistenciaAnular = function(){
		    $scope.dtAsistenciaAnular.idAsistencia = null;
		    $scope.dtAsistenciaAnular.detalle = null;
		    
	    };
	    
	    $scope.selectedAsist = [];
		  $scope.selection = function(item){
			  	$scope.cleardtAsistenciaAnular();
		    	$scope.setDtAsistenciaAnular(item);
			    if(item.checked){
			    	$scope.selectedAsist.push($scope.dtAsistenciaAnular);
			    }else{
			    	$scope.selectedAsist = $scope.selectedAsist.filter(val => val.idAsistencia !== $scope.dtAsistenciaAnular.idAsistencia);
			    }
			    console.log('lista: '+ $scope.selectedAsist); 
			  };
		  
		  $scope.showConfirmAnularAsistencia = function(ev) {
			  if($scope.selectedAsist.length<1){
					$mdDialog.show(
							$mdDialog.alert()
							.parent(angular.element(document.body))
							.clickOutsideToClose(true)
							.title('Anular asistencia')
							.textContent("Debe seleccionar al menos un registro")
							.ariaLabel('Lucky day')
							.ok('OK')
							.targetEvent(ev)
					);
				}else{
					var confirm = $mdDialog.confirm()
	                .title('Anular asistencia')
	                .textContent('¿Está usted seguro de anular los registros?')
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
//					var instrumentos = $scope.datos;
//			        var index = $scope.datos.findIndex(obj => obj.idAsistTema === dato.idAsistTema);
//					console.log("INDEX " + index);
//			        if(instrumentos.length>index){
//			        	instrumentos.splice(index, 1);
//				        $scope.datos = instrumentos;
//				        $scope.total = $scope.datos.length;
//			        }	
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
				        .ok('OK')
				        .targetEvent(ev)
					   );
		            }
		        });			        			        	
	      	ev.target.disabled = false;
		 };
		 
		 
		 $scope.showConfirmReactivarAsistencia = function(ev, dtAsistenciaBk) {
			    var confirm = $mdDialog.confirm()
			      .title('Reactivar asistencia técnica')
			      .textContent('¿Está usted seguro de reactivar el registro?')
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
					},
					function error(errResponse) {
			            console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
			            var dato = errResponse.data;
			            if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
			            	$mdDialog.show(
					         $mdDialog.alert()
					        .parent(angular.element(document.body))
					        .clickOutsideToClose(true)
					        .title('Reactivar asistencia técnica')
					        .textContent(dato.message)
					        .ariaLabel('ERROR')
					        .ok('OK')
					        .targetEvent(ev)
						   );
			            }
			        });			        			        	
		        	ev.target.disabled = false;
			 };
		

	  $scope.dtAsistenciaModelo = {
			idAsistencia : null,
			fechaAsistencia: null,
			detalle: null,
			idUsuinterno: null,
			idEntidad: null,
			idOrigen: 140,
			idProgramacion: null,
			idModalidad: null,
			idSede: null,
			idSistAdm: null,
			idFinancia: null,
			fechaFinalizacion: null,
			fechaProgramada: null,
			fechaSoli: null,
			fechaSoliJUD : $scope.firstDateNextMonth(new Date()),
			fechaProgramadaJUD : $scope.firstDateNextMonth(new Date()),
			fechaServicioJUD : $scope.firstDateNextMonth(new Date()),
			vistaProgramado : true,
			codEjecutora  : null,
			checked : false,
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
			tdAnexosJSss: [],

		    editopcion: 1
		};
	  
	  $scope.cleardtAsistencia = function(){
		    $scope.dtAsistenciaModelo.idAsistencia = null;
		    $scope.dtAsistenciaModelo.fechaAsistencia = new Date();
		    $scope.dtAsistenciaModelo.detalle = null;
		    $scope.dtAsistenciaModelo.idUsuinterno = null;
		    $scope.dtAsistenciaModelo.idEntidad = null;
		    $scope.dtAsistenciaModelo.idOrigen = null;
		    $scope.dtAsistenciaModelo.idProgramacion = null;
		    $scope.dtAsistenciaModelo.idModalidad = null;
		    $scope.dtAsistenciaModelo.idSede = null;
		    $scope.dtAsistenciaModelo.idSistAdm = null;
		    $scope.dtAsistenciaModelo.idFinancia = null;
		    $scope.dtAsistenciaModelo.fechaFinalizacion = new Date();
		    $scope.dtAsistenciaModelo.fechaProgramada = new Date();
		    $scope.dtAsistenciaModelo.fechaSoli = new Date();
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
            $scope.datoAsistenciaTema = [];
            
    		 		for(var i = 0; i < dtAsistenciaBk.dtAsistenciaTemasBkJSss.length; i++) {
    					var asistenciaTema = dtAsistenciaBk.dtAsistenciaTemasBkJSss[i];
    					$scope.addAsistTema(asistenciaTema, i, dtAsistenciaBk.dtAsistenciaTemasBkJSss.length);
    				}

            }
            
            $scope.dtAsistenciaModelo.dtAsistenciaUsuariosBkJSss = dtAsistenciaBk.dtAsistenciaUsuariosBkJSss;
            
            if(dtAsistenciaBk.dtAsistenciaUsuariosBkJSss!=null && dtAsistenciaBk.dtAsistenciaUsuariosBkJSss.length>0){
            	$scope.datoUsuario = [];
            	
            	for(var i = 0; i < dtAsistenciaBk.dtAsistenciaUsuariosBkJSss.length; i++) {
					var usuario = dtAsistenciaBk.dtAsistenciaUsuariosBkJSss[i];
					$scope.addUsuario(usuario, i, dtAsistenciaBk.dtAsistenciaUsuariosBkJSss.length);
				}
            	
            	
            }
            //tdLogisticaConveniosBk.tdAnexosDtoss;
            $scope.dtAsistenciaModelo.tdAnexosJSss = dtAsistenciaBk.dtAnexosBKJSss;

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
			
			if(dtAsistenciaBk.idAsistencia!=null && dtAsistenciaBk.idAsistencia!=0){
				
				var idPadreAsisProgramado = 121;
				var idPadreAsisNoProgramado = 122;
				
				if(dtAsistenciaBk.idProgramacion == idPadreAsisNoProgramado){
					$scope.dtAsistenciaModelo.editopcion = 2;
				} else if(dtAsistenciaBk.idProgramacion == idPadreAsisProgramado){
					$scope.dtAsistenciaModelo.editopcion = 3;
				}
				
			} else{
				$scope.dtAsistenciaModelo.editopcion = dtAsistenciaBk.dtAsistenciaACL.editopcion;
			}
			
			
		}
	
	  $scope.addAsistTema = function (asistenciaTema, i, size) {
		  
	    	var addx=false;
	    	
	    	if(i+1==size){
	    		addx= true;
	    	}
	    	
	    	else{
	    		addx= false;
	    	}
	        
	    	$scope.datoAsistenciaTema.push({
	        	contador: i+ 1, 
	        	idTema: asistenciaTema.idTema,
	        	idAsistTema: asistenciaTema.idAsistTema,
	        	idTemaTxt: asistenciaTema.idTemaTxt,
	        	idSubtema: asistenciaTema.idSubtema,
	        	idSubtemaTxt: asistenciaTema.idSubtemaTxt,
	        	detalle: asistenciaTema.detalle,
	            add: addx
	            
	        })
			
	  }
	  
	  $scope.addUsuario = function (usuario, i, size) {
		  
	    	var addx=false;
	    	
	    	if(i+1==size){
	    		addx= true;
	    	}
	    	
	    	else{
	    		addx= false;
	    	}
	        
	    	$scope.datoUsuario.push({
	        	contador: i+ 1,
	        	idAsistUsuext: usuario.idAsistUsuext,
	        	numDocu: usuario.numDocu,
	        	nombresApellidos: usuario.aPaterno + ' '+ usuario.aMaterno + ' ' + usuario.nombre,
	        	idCargoUsuextTxt: usuario.idCargoUsuextTxt,
	        	correoUsuext: usuario.correoUsuext,
	        	fijoUsuext: usuario.fijoUsuext,
	        	celularUsuext: usuario.celularUsuext,
	        	idUsuexterno: usuario.idUsuexterno,
	        	
	            add: addx
	            
	        })
			
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
	  
	  $scope.handleremover = function(pos){
			$scope.archivos.splice(pos,1);			  
	  }
	  
	  $scope.$on("fileSelected", function (event, args) {
			$scope.$apply(function () {
				console.log("PROBANDO ENVIAR EL ARCHIVO");           
				$scope.archivos.push(args);	            
				var pos = $scope.archivos.length-1;
				fileUploadSrv.uploadFileToUrl(pos,$scope.archivos[pos],insertDocUrl);
			});
	  });
	  
	  $scope.addTemaAndUsers= function(){	
		  var propertiesToRemove = ['contador', 'add'];
		  
		    if($scope.isArray($scope.datoAsistenciaTema)) {
				if($scope.datoAsistenciaTema.length>0) {
						$scope.dtAsistenciaModelo.dtAsistenciaTemasBkJSss =  $scope.removePropertiesFromList(angular.copy($scope.datoAsistenciaTema), propertiesToRemove);
				}
			}
		    
		    if($scope.isArray($scope.datoUsuario)) {
				if($scope.datoUsuario.length>0) {
						$scope.dtAsistenciaModelo.dtAsistenciaUsuariosBkJSss = $scope.removePropertiesFromList(angular.copy($scope.datoUsuario), propertiesToRemove);
				}
			}
	  }
	  
	  $scope.uploadFileTotdAnexoJsModel = function(){
		  	//FILES
		    if($scope.isArray($scope.archivos)){
				if($scope.archivos.length>0){
					for(var i = 0; i < $scope.archivos.length; i++)
					{
						var archivo = $scope.archivos[i];
						if(archivo.filename!=null &&  archivo.data!=null){
							$mdDialog.show(
									$mdDialog.alert()
									.parent(angular.element(document.body))
									.clickOutsideToClose(true)
									.title('Cargar archivos')
									.textContent("TODAVÍA SE ESTA CARGANDO EL ARCHIVO "+archivo.filenameoriginal+" ESPERE QUE CULMINE LA OPERACIÓN...")
									.ariaLabel('ERROR')
									.ok('OK')
									.targetEvent(ev)
							);
							return;
						}else if(archivo.filename===null && archivo.data!=null){					
							$mdDialog.show(
									$mdDialog.alert()
									.parent(angular.element(document.body))
									.clickOutsideToClose(true)
									.title('Cargar archivos')
									.textContent("TODAVÍA SE ESTA CARGANDO EL ARCHIVO "+archivo.filenameoriginal+" ESPERE QUE CULMINE LA OPERACIÓN...")
									.ariaLabel('ERROR')
									.ok('OK')
									.targetEvent(ev)
							);
							return;
						}
					}
					
					$scope.dtAsistenciaModelo.tdAnexosJSss = $scope.archivos;
				}}
	  }	
	  			  
	  $scope.salvarDtAsistencia = function(ev){	
		  
		  			$scope.addTemaAndUsers();
		  			$scope.uploadFileTotdAnexoJsModel();
				    
				    
				    ev.target.disabled = true;
				    var datainsert = angular.toJson($scope.dtAsistenciaModelo);
		 			console.log("datainsert = "+datainsert);	
		        		$http.post(insertdtAsistenciaUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
							var dato = res.data;

		    				$scope.total = $scope.datos.length;
		    				
		    				$scope.setDtAsistenciaModelo(dato);
		    				
		    				var idPadreModVirtual = 137;
		    				var idPadreModPresencial = 138;
		    				
		    				if($scope.dtAsistenciaModelo.idModalidad == idPadreModVirtual || 
		    						$scope.dtAsistenciaModelo.idModalidad == idPadreModPresencial){
		    					$scope.showPanelDocumentos = 1;
		    				}
		    				
		    				if($scope.dtAsistenciaModelo.idModalidad == idPadreModPresencial){
		    					$scope.showButtonsFormato = 1;
		    				}
		    				
		    				$scope.showButtonsFinalizar = 1;
		    				
		    				$mdDialog.show(
							         $mdDialog.alert()
							        .parent(angular.element(document.body))
							        .clickOutsideToClose(true)
							        .title('Guardar asistencia técnica')
							        .textContent("Asistencia técnica se guardó correctamente.")
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
								        .title('Guardar asistencia técnica')
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
					        .title('Eliminar asistencia técnica')
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
					        .title('Cargar asistencia técnica')
					        .textContent(dato.message)
					        .ariaLabel('ERROR')
					        .ok('OK')
						   );
			            }			           
			        });			        			        	
			 };
			 
		$scope.showConfirm = function(ev, dtAsistenciaBk) {
				    var confirm = $mdDialog.confirm()
				      .title('Eliminar asistencia técnica')
				      .textContent('¿Está usted seguro de eliminar el registro?')
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
				  
				
				  $scope.buscarxcodEjec = function(dato){
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
//				                dato.ruc = institucion.ruc;
				                dato.idEntidadTxt = institucion.razSocial;
				                dato.idEntidad = institucion.idEntidad;
				                console.log('modelo', dato);

				                $scope.selectedItem = institucion;
//				                $scope.ctrlViaticosId.selectedItem = institucion;
				            } else if(resData.length>1){
				                $scope.dlgInstmsInstitucionesDtoss = resData;
				                $scope.dlgInsttotal = resData.length;
//				                $scope.showdlgPersonasDialog(resData);
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
				                    .title('Buscar por ejecutora - Registramef')
				                    .textContent(errData.message)
				                    .ariaLabel('ERROR')
				                    .ok('OK')
				                    .targetEvent(errData)
				                );
				                dato.idEntidadTxt = null;
				                dato.idEntidad = null;
				            }
				        });
				    };
				    
				    $scope.datoAsistenciaTema = [];
				    
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
				    	if(dato.idAsistTema!=null && dato.idAsistTema>0){
				    		$scope.showConfirmDeleteAsistenciaTema(ev, dato);
				    	}else{
				    		$scope.datoAsistenciaTema = $scope.datoAsistenciaTema.filter(val => val.idAsistTema !== dato.idAsistTema);
				    	} 
				    }
					
					
					$scope.removeUsuario = function (ev,dato) {
				    	if(dato.idAsistUsuext!=null && dato.idAsistUsuext>0){
				    		$scope.showConfirmDeleteUsuario(ev, dato);
				    	}else{
				    		$scope.datoUsuario = $scope.datoUsuario.filter(val => val.idUsuexterno !== dato.idUsuexterno);
				    	} 
				    }
					
					 $scope.removeProperties = function(obj, properties) {
			                properties.forEach(function(property) {
			                    delete obj[property];
			                });
			                return obj;
			            };
			            
			       $scope.removePropertiesFromList = function(list, properties) {
			                return list.map(function(item) {
			                    properties.forEach(function(property) {
			                        delete item[property];
			                    });
			                    return item;
			                });
			      };
			      
			      
			      $scope.showSendMailUsuario = function(ev, usuario) {
					    var confirm = $mdDialog.confirm()
					      .title('Enviar Constancia de atención')
					      .textContent('¿SEGURO QUE DESEA ENVIAR LA CONSTANCIA DE ATENCIÓN?')
					      .targetEvent(ev)
					      .ok('Si')
					      .cancel('No');

					    $mdDialog.show(confirm).then(function () {
					      $scope.status = 'SI';
					      $scope.sendMailUsuario(ev, usuario);
					    }, function () {
					      $scope.status = 'NO';
					    });
					  };
			      
			      
					$scope.sendMailUsuario = function (ev,usuario) {
				        var propertiesToRemove = ['contador', 'add'];
						var newUsuario = $scope.removeProperties(angular.copy(usuario), propertiesToRemove);
						console.log("newUsuario:" + JSON.stringify( newUsuario));
						
						if(newUsuario.idAsistUsuext==null){
							$mdDialog.show(
									$mdDialog.alert()
									.parent(angular.element(document.body))
									.clickOutsideToClose(true)
									.title('ASISTENCIA TECNICA')
									.textContent("PARA QUE PUEDA ENVIAR EL CORREO SE NECESITA QUE GUARDE LA ASISTENCIA PARA QUE SE ACTUALICE LOS DATOS DE LOS NUEVOS USUARIOS AGREGADOS")
									.ok('OK')
							);
							return;
						}
						
						if(newUsuario!=null){
							$scope.dtAsistenciaModelo.dtAsistenciaUsuexternosBk = newUsuario;
						}
						
						var propertiestdAnexosJSssToRemove = ['tdAnexosJSss'];
						var dtAsistenciaModelo = $scope.removeProperties(angular.copy($scope.dtAsistenciaModelo ), propertiestdAnexosJSssToRemove);
						
						console.log("$scope.dtAsistenciaModelo:" + JSON.stringify( dtAsistenciaModelo ));
						 var datainsert = angular.toJson(dtAsistenciaModelo);
						
						$http.post(enviarConstanciaAtencionUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
							var dato = res.data;
							
		    				$scope.total = $scope.datos.length;
		    				
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
								        .title('Enviar Constancia de Correo')
								        .textContent(dato.message)
								        .ariaLabel('ERROR')
								        .ok('OK')
								        .targetEvent(ev)
								    );
				            }
				        });		
				    }
					
					
					$scope.showConfirmDeleteAsistenciaTema = function(ev, dtAsistenciaTemasBk) {
					    var confirm = $mdDialog.confirm()
					      .title('Eliminar registro')
					      .textContent('¿Está usted seguro de eliminar el registro?')
					      .ariaLabel('Lucky day')
					      .targetEvent(ev)
					      .ok('Si')
					      .cancel('No');

					    $mdDialog.show(confirm).then(function () {
					      $scope.status = 'SI';
					      $scope.eliminardtAsistenciaTemas(ev, dtAsistenciaTemasBk);
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
							        .ok('OK')
							        .targetEvent(ev)
								   );
					            }
					        });			        			        	
				      	ev.target.disabled = false;
					 };
					  
					  $scope.showConfirmDeleteUsuario = function(ev, usuarioBK) {
						    var confirm = $mdDialog.confirm()
						      .title('Eliminar registro')
						      .textContent('¿Está usted seguro de eliminar el registro?')
						      .ariaLabel('Lucky day')
						      .targetEvent(ev)
						      .ok('Si')
						      .cancel('No');

						    $mdDialog.show(confirm).then(function () {
						      $scope.status = 'SI';
						      $scope.eliminardUsuario(ev, usuarioBK);
						    }, function () {
						      $scope.status = 'NO';
						    });
						  };
						  
						  $scope.eliminardUsuario = function(ev,usuarioBK){		
							    ev.target.disabled = true;
							    var datainsert = angular.toJson(usuarioBK);
								console.log("datainsert usuarioBK = "+datainsert);	
							$http.post(eliminardtAsistenciaUsuariosUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
									var dato = res.data;
									var instrumentos = $scope.datos;
							        var index = $scope.datos.findIndex(obj => obj.idAsistUsuext === dato.idAsistUsuext);
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
								        .ok('OK')
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
					 
					//SELECT INI
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
			          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
			        	$scope.loadListaMsSubtemaIdSubtema(idTema);
			        	var temaText = $scope.listaMsTemaIdTema.find(temaText => temaText.id === idTema );
			        	$scope.asistenciaTemasmodelo.idTemaTxt=temaText.valor;
			        }
				        $scope.$watch('dtConsultasModelo.idTema', function (newValue, oldValue) {
						console.log('dtConsultasModelo.idTema ' + newValue+' -- '+oldValue);
						//CARGAR DATOS DEL SIGUIENTE SELECT
					});
				//SELECT FIN   
				        
				//SELECT INI 
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
				        	var subtemaText = $scope.listaMsSubtemaIdSubtema.find(subtemaText => subtemaText.id === idSubtema );
				        	$scope.asistenciaTemasmodelo.idSubtemaTxt=subtemaText.valor;
				        }
				        $scope.$watch('dtConsultasModelo.idSubtema', function (newValue, oldValue) {
						console.log('dtConsultasModelo.idSubtema ' + newValue+' -- '+oldValue);
						//CARGAR DATOS DEL SIGUIENTE SELECT
					});
				//SELECT FIN 
				        
				      //SELECT INI
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
				          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
				        }
				        $scope.$watch('dtAsistenciaModelo.idSede', function (newValue, oldValue) {
						console.log('dtAsistenciaModelo.idSede ' + newValue+' -- '+oldValue);
						//CARGAR DATOS DEL SIGUIENTE SELECT
					});
				//SELECT FIN 
				        
				      //SELECT INI
				        //$scope.listaMsSisAdmin=[];
				       /* $scope.loadlistaMsSisAdmin=function(){
				        $http.get(listamsSisAdminUrl).then(function(res){
				        	$scope.listaMsSisAdmin = res.data; 
				        },
				        function error(errResponse) {
				        	console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
				        });
				        };*/
				        
				       /* $scope.changeIdMsSisAdmin=function(){
				          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
				        }*/
				        $scope.$watch('dtAsistenciaModelo.idSede', function (newValue, oldValue) {
				        console.log('dtAsistenciaModelo.idSede ' + newValue+' -- '+oldValue);
				        //CARGAR DATOS DEL SIGUIENTE SELECT
				        });
				        //SELECT FIN 
				        
				        //AUTOCOMPLETE INI
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
//				    		var results = query ?
//				    		$scope.listaMsInstitucionesIdprovee.filter($scope.createFilterForMsInstitucionesIdprovee(query))
//				    		: $scope.listaMsInstitucionesIdprovee,
//				    		return results;
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
				    			$scope.dtAsistenciaModelo.idEntidadTxt = item.razSocial;
				    			$scope.dtAsistenciaModelo.codEjecutora  = item.codEjec;
				    		}
				    	}
//				    	AUTOCOMPLETE FIN
				    	
				    	$scope.showdlgInstitucionDialog = function(ev) {		
				    		$scope.loadubigeodefecto();
				    		$scope.loadlistaPaises();
				    		$scope.loadlistaCoddptos();	
				    		$scope.loadlistaMsSedes();
				    		//$scope.loadlistaMsSisAdmin();
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
				    	
				    	  //SELECT INI
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
				          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
				        }
				        $scope.$watch('dtEntidadesModelo.idTipo', function (newValue, oldValue) {
				    	console.log('dtEntidadesModelo.idTipo ' + newValue+' -- '+oldValue);
				    	//CARGAR DATOS DEL SIGUIENTE SELECT
				    });
				    //SELECT FIN 
				        
				      //SELECT INI
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
				          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
				        }
				        $scope.$watch('dtEntidadesModelo.idCaract', function (newValue, oldValue) {
				    	console.log('dtEntidadesModelo.idCaract ' + newValue+' -- '+oldValue);
				    	//CARGAR DATOS DEL SIGUIENTE SELECT
				    });
				    //SELECT FIN  
				        
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
          
        		
        }
        
        $scope.$watch('dtAsistenciaModelo.idModalidad', function (newValue, oldValue) {
        	
        		console.log('dtAsistenciaModelo.idModalidad ' + newValue+' -- '+oldValue);

        		var idPadreModVirtual = 137;
				var idPadreModPresencial = 138;
				
				if(newValue == idPadreModVirtual || 
						newValue == idPadreModPresencial){
					$scope.showPanelDocumentos = 1;
				} else{
					$scope.showPanelDocumentos = 0;
				}
        		
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
        
        $scope.changeIdOrigen=function(){
            ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
          }
        
        $scope.$watch('dtAsistenciaModelo.idFinancia', function (newValue, oldValue) {
		console.log('dtAsistenciaModelo.idFinancia ' + newValue+' -- '+oldValue);
		//CARGAR DATOS DEL SIGUIENTE SELECT
	});
//SELECT FIN                

//SHOW DIALOG TEMA
        
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
        
        $scope.generateRandomInteger = function(max) {
		    return Math.floor(Math.random() * max) + 1;
		}
        
        $scope.changeIdCargo=function(idCargo){
	        	var cargoObjectJson = $scope.listaCargos.find(cargoText => cargoText.idCargo === idCargo );
	        	$scope.usuarioModelo.idCargoUsuext = cargoObjectJson.idCargo;
	        	$scope.usuarioModelo.idCargoUsuextTxt = cargoObjectJson.idCargoTxt;
	   }
        
        $scope.asistenciaTemasmodelo = {
				idAsistTema: null,
				idAsistencia: null,
				idTema: null,
				idTemaTxt: null,
				idSubtema: null,
				idSubtemaTxt: null,
				detalle: null
			};
        
        $scope.usuarioModelo = {
        		idAsistUsuext:null,
        		idUsuexterno: null,
        		numDocu: null,
				aPaterno: null,
				aMaterno: null,
				nombre: null,
				nombresApellidos: null,
				idCargoUsuext: null,
				idCargoUsuextTxt: null,
				correoUsuext: null,
				fijoUsuext: null,
				celularUsuext: null
		};
        
        $scope.clearUsuarioModelDialog= function(){
        	$scope.usuarioModelo.idAsistUsuext= null;
        	$scope.usuarioModelo.idUsuexterno= null;
        	$scope.usuarioModelo.numDocu= null;
        	$scope.usuarioModelo.aPaterno= null;
        	$scope.usuarioModelo.aMaterno= null;
        	$scope.usuarioModelo.nombre= null;
        	$scope.usuarioModelo.idCargoUsuext= null;
        	$scope.usuarioModelo.idCargoUsuextTxt= null;
        	$scope.usuarioModelo.correoUsuext= null;
        	$scope.usuarioModelo.fijoUsuext= null;
        	$scope.usuarioModelo.celularUsuext= null;
        	$scope.usuarioModelo.nombresApellidos= null;
        	$scope.listaCargos=[];
        }
        
        $scope.clearAsistenciaTecTemasmodelo= function(){
			$scope.asistenciaTemasmodelo.idAsistTema= null;
			$scope.asistenciaTemasmodelo.idAsistencia= null;
			$scope.asistenciaTemasmodelo.idTema= null;
			$scope.asistenciaTemasmodelo.idTemaTxt= null;
			$scope.asistenciaTemasmodelo.idSubtema= null;
			$scope.asistenciaTemasmodelo.idSubtemaTxt= null;
			$scope.asistenciaTemasmodelo.detalle= null;
		};
        
        $scope.showDialogTema = function(ev) {
			ev.target.disabled = true;
			$scope.clearAsistenciaTecTemasmodelo();	
			$mdDialog.show({
				templateUrl: contexto+"/dialogos/editarRegAsistTecTemas.html",
				scope: $scope,
				preserveScope: true,
				parent: angular.element(document.body),
				targetEvent: ev,
				clickOutsideToClose: true
			}).then($scope.closeDialog, $scope.cancelDialod);	
			ev.target.disabled = false;
		};
		
		$scope.agregarTema = function (ev) {
			ev.target.disabled = true;
			
			if (!$scope.dtAsistenciaForm2.$valid) {
				alert('El diálogo no cumple con los campos obligatorios...');
				ev.target.disabled = false;
				return;
			}
			
			if ($scope.datoAsistenciaTema.filter(e => e.idSubtema === $scope.asistenciaTemasmodelo.idSubtema).length > 0) {
				 
				$mdDialog.show(
						$mdDialog.alert()
						.parent(angular.element(document.body))
						.clickOutsideToClose(true)
						.title('Guardar asistencia técnica')
						.textContent("El subtema seleccionado ya existe")
						.ariaLabel('Lucky day')
						.ok('OK')
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
   //FIN DIALOG TEMA     

		//DIALOG USUARIO
		
		$scope.showDialogUsuario = function(ev) {
			ev.target.disabled = true;
			$scope.clearUsuarioModelDialog();		
			$mdDialog.show({
				templateUrl: contexto+"/dialogos/editarRegUsuario.html",
				scope: $scope,
				preserveScope: true,
				parent: angular.element(document.body),
				targetEvent: ev,
				clickOutsideToClose: true
			}).then($scope.closeDialog, $scope.cancelDialod);	
			ev.target.disabled = false;
		};
		$scope.listaCargos=[];
		$scope.activar = 0;
		$scope.showPanelDocumentos = 0;
		$scope.showButtonsFinalizar = 0;
		$scope.showButtonsFormato = 0;
		$scope.archivos = [];
		$scope.guardadoExitoso = 0;
		$scope.buscarxdni = function(dato){
	        console.log('dni: '+ dato.numDocu);
	        var surl = buscarPorNumDocUrl + dato.numDocu; 
	        console.log('surl: '+ surl);
	        $scope.dlgInstpromise = $http.get(surl).then(function(res){
	            var resData = res.data;
	            
	            if(resData.idUsuexterno!=null && resData.idUsuexterno!=0){
	            	$scope.usuarioModelo.idUsuexterno = resData.idUsuexterno;
		            $scope.usuarioModelo.nombresApellidos = resData.apaterno + ' '+ resData.amaterno + ' ' + resData.nombre;
		            $scope.usuarioModelo.aPaterno = resData.apaterno;
		            $scope.usuarioModelo.aMaterno = resData.amaterno;
		            $scope.usuarioModelo.nombre = resData.nombre;
		            $scope.usuarioModelo.correoUsuext = resData.correo;
		            $scope.usuarioModelo.celularUsuext = (resData.telefCell!=null && resData.telefCell!=0)?resData.telefCell:resData.otroCelular;
		            $scope.usuarioModelo.fijoUsuext =  (resData.telefFijo!=null && resData.telefFijo!=0)?resData.telefFijo:resData.otroCelular;
		            $scope.listaCargos = resData.usucargos;
		            
		            $scope.activar=1;
		            console.log("resData:" + JSON.stringify(resData));
		            console.log("$scope.listaCargos:" + JSON.stringify($scope.listaCargos));
	            } else {
	            	alert('Nos se encontró información del DNI...');
					return;
	            }
	            
	           
	        }, function error(errResponse) {
	            console.log("Buscar x dni data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse.statusText + " xhrStat " + errResponse.xhrStatus);
	            var errData = errResponse.data;
	            if(errData && typeof(errData.message) != 'undefined'){
	                $mdDialog.show(
	                    $mdDialog.alert()
	                    .parent(angular.element(document.body))
	                    .clickOutsideToClose(true)
	                    .title('Buscar por dni - Registramef')
	                    .textContent(errData.message)
	                    .ariaLabel('ERROR')
	                    .ok('OK')
	                    .targetEvent(errData)
	                );
	                dato.idEntidadTxt = null;
	                dato.idEntidad = null;
	            }
	        });
	        
	    };
	    
	    $scope.ctrlMsUSuariosExterxNombApe={
				simulateQuery: false,
				isDisabled: false,
				selectedItem: null
		};
	    
	    $scope.datoUsuario = [];
	    
	    $scope.agregarUsuario = function () {
			
			if ($scope.datoUsuario.filter(e => e.idUsuexterno === $scope.usuarioModelo.idUsuexterno).length > 0) {
				$mdDialog.show(
						$mdDialog.alert()
						.parent(angular.element(document.body))
						.clickOutsideToClose(true)
						.title('Guardar usuario')
						.textContent("El usuario seleccionado ya existe")
						.ok('OK')
				);
				ev.target.disabled = false;
				return;
			}
			
			
			var datoactual = Object.assign({}, $scope.usuarioModelo);
			$scope.datoUsuario.push(datoactual);	
			$scope.cancel();
		};
		
		//FIN DIALOG USUARIO
		
		$scope.selectedPerson = function(resData) {
    		if($scope.isObject(resData)){
    			console.log("persona seleccionada:" + JSON.stringify(resData));
    			
    			$scope.usuarioModelo.idUsuexterno = resData.idUsuexterno;
	            $scope.usuarioModelo.nombresApellidos = resData.apaterno + ' '+ resData.amaterno + ' ' + resData.nombre;
	            $scope.usuarioModelo.aPaterno = resData.apaterno;
	            $scope.usuarioModelo.aMaterno = resData.amaterno;
	            $scope.usuarioModelo.nombre = resData.nombre;
	            $scope.usuarioModelo.correoUsuext = resData.correo;
	            $scope.usuarioModelo.celularUsuext = (resData.telefCell!=null && resData.telefCell!=0)?resData.telefCell:resData.otroCelular;
	            $scope.usuarioModelo.fijoUsuext =  (resData.telefFijo!=null && resData.telefFijo!=0)?resData.telefFijo:'';
	            $scope.usuarioModelo.numDocu =    resData.numDocum;
	            
	            $scope.promise = $http.get(listaCargoPorIdUsuarioExtUrl+ resData.idUsuexterno)
	            .then(function(response) {
	            	console.log("persona seleccionada cargos:" + JSON.stringify(response.data));
	            	$scope.listaCargos = response.data;
	            	return response.data;
	            })
	            .catch(function (errResponse) {
	            	console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
	                return [];
	            });
	            
    			
    		}
    	}
		
		//BUSCAR POR APELLIDO Y NOMBRE
		$scope.searchTextChange = function(text) {
	        console.log('Texto de búsqueda cambiado a: ' + text);
	    };
	    
	    $scope.querySearch = function(valor) {
	    	console.log('nombreapellido to find: '+valor);
	    	
	        return $http.get(listaDtUsuarioXNombreapellidoUrl+ valor)
	            .then(function(response) {
	            	//console.log(response.data);
	            	
	            	console.log("response.data:" + JSON.stringify(response.data));
	            	
	            	$scope.activar=1;
	            	
	            	return response.data;
	            	
	            })
	            .catch(function (errResponse) {
	            	console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
	              
	                return [];
	            });
	        
	    };
		
	    $scope.generarFormato = function(){
			return descargarFormatoUrl+$scope.dtAsistenciaModelo.idAsistencia;
	    };
	    
	    $scope.validateGenerarFormato = function(ev){
	    	
	    	$scope.addTemaAndUsers();
	    	
	    	var propertiesToRemove = ['dtAnexoACL', 'cestado', 'esEliminado', 'cclase'];
	    	
	    	if ( typeof($scope.dtAsistenciaModelo.tdAnexosJSss) !== "undefined" && $scope.dtAsistenciaModelo.tdAnexosJSss !== null ) {
	    		$scope.dtAsistenciaModelo.tdAnexosJSss =  $scope.removePropertiesFromList(angular.copy($scope.dtAsistenciaModelo.tdAnexosJSss), propertiesToRemove);
	    	}
	    	
	    	
	    	
	    	ev.target.disabled = true;
		    var datainsert = angular.toJson($scope.dtAsistenciaModelo);
 			console.log("datainsert to validate = "+datainsert);	
        		$http.post(validarCambiosAsistenciaUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
        			var dato = res.data;
					if(dato!=null){
						location.href = $scope.generarFormato();
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
						        .title('Guardar asistencia técnica')
						        .textContent(dato.message)
						        .ariaLabel('ERROR')
						        .ok('OK')
						        .targetEvent(ev)
						    );
		            }
		        });		
        			        	
        	ev.target.disabled = false;
		    
		    
	    }
		
//DESCARGAR
    	$scope.descargar = function(){
    		return descargarUrl+$scope.getURLParametros();
    	}
    	
    	$scope.hide = function () {
			$mdDialog.hide($scope.usuarioModelo);
			$scope.agregarUsuario();
		};
    	
    	
    	$scope.showConfirmFinalizar = function(ev) {
    		
    		if($scope.datoUsuario.length==0) {
    			$mdDialog.show(
						$mdDialog.alert()
						.parent(angular.element(document.body))
						.clickOutsideToClose(true)
						.title('ASISTENCIA TECNICA')
						.textContent("PARA FINALIZAR EL SERVICIO DEBE REGISTRAR EL USUARIO ATENDIDO")
						.ok('OK')
				);
    			return;
    		}
    		
    		var idPadreModVirtual = 137;
			var idPadreModPresencial = 138;
			
			if($scope.dtAsistenciaModelo.idModalidad == idPadreModVirtual || 
					$scope.dtAsistenciaModelo.idModalidad == idPadreModPresencial){
				if($scope.archivos.length==0){
					$mdDialog.show(
							$mdDialog.alert()
							.parent(angular.element(document.body))
							.clickOutsideToClose(true)
							.title('ASISTENCIA TECNICA')
							.textContent("PARA FINALIZAR EL SERVICIO DEBE ADJUNTAR EL ARCHIVO DIGITAL")
							.ok('OK')
					);
	    			return;
				} else{
					$scope.uploadFileTotdAnexoJsModel();
				}
			}
    		
		    var confirm = $mdDialog.confirm()
		      .title('Finalizar asistencia técnica')
		      .textContent('¿Está usted seguro de finalizar el registro?')
		      .ariaLabel('Lucky day')
		      .targetEvent(ev)
		      .ok('Si')
		      .cancel('No');

		    $mdDialog.show(confirm).then(function () {
		      $scope.status = 'SI';
		     // var datainsertFinalizar = angular.toJson($scope.dtAsistenciaModelo);
		      
		      $scope.finalizardtAsistencia(ev, $scope.dtAsistenciaModelo);
		    }, function () {
		      $scope.status = 'NO';
		    });
		  };
		  
		  $scope.finalizardtAsistencia = function(ev,dtAsistenciaBk){		
			    ev.target.disabled = true;
			    
			    var datainsert = angular.toJson(dtAsistenciaBk);
			    
				console.log("datainsertFinalizar = "+datainsert);	
				
			$http.post(finalizardtAsistenciaUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
				var dato = res.data;

				$scope.total = $scope.datos.length;
				
				$scope.setDtAsistenciaModelo(dato);
				
				$mdDialog.show(
				         $mdDialog.alert()
				        .parent(angular.element(document.body))
				        .clickOutsideToClose(true)
				        .title('Finalizar asistencia técnica')
				        .textContent("Asistencia técnica se finalizó correctamente.")
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
						        .title('Finalizar asistencia técnica')
						        .textContent(dato.message)
						        .ariaLabel('ERROR')
						        .ok('OK')
						        .targetEvent(ev)
						    );
		            }
		        });			        			        	
	    	ev.target.disabled = false;
		 };
    	
//ADJUNTAR DOCUMENTOS
		 
		 
    	
///FIN ADICIONALES			 			 
	// ////////////////////////////////////////////////////////////////
	
		    $scope.cancel = function() {
		    	$scope.activar = 0;
		    	$scope.clearUsuarioModelDialog();
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

//	if($scope.msInstitucionesModelo.codpais==null){
//		$scope.msInstitucionesModelo.codpais=$scope.ubigeodefectos.xDefectoCodpais;
//	}
//	if($scope.msInstitucionesModelo.coddpto==null){
//		$scope.msInstitucionesModelo.coddpto=$scope.ubigeodefectos.xDefectoCoddpto;
//	}
//	if($scope.msInstitucionesModelo.codprov==null){
//		$scope.msInstitucionesModelo.codprov=$scope.ubigeodefectos.xDefectoCodprov;
//	}
//	if($scope.msInstitucionesModelo.coddist==null){
//		$scope.msInstitucionesModelo.coddist=$scope.ubigeodefectos.xDefectoCoddist;
//	}

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
	
    //SELECT INI
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
      ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
    }
    $scope.$watch('dtEntidadesModelo.idSede', function (newValue, oldValue) {
	console.log('dtEntidadesModelo.idSede ' + newValue+' -- '+oldValue);
	//CARGAR DATOS DEL SIGUIENTE SELECT
});
//SELECT FIN 
    
  //SELECT INI
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
      ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
    }
    $scope.$watch('dtEntidadesModelo.idTipo', function (newValue, oldValue) {
	console.log('dtEntidadesModelo.idTipo ' + newValue+' -- '+oldValue);
	//CARGAR DATOS DEL SIGUIENTE SELECT
});
//SELECT FIN  
    
    //SELECT INI
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
      ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
    }
    $scope.$watch('dtEntidadesModelo.idCaract', function (newValue, oldValue) {
	console.log('dtEntidadesModelo.idCaract ' + newValue+' -- '+oldValue);
	//CARGAR DATOS DEL SIGUIENTE SELECT
});
//SELECT FIN  
    
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
//		$scope.msInstitucionesModelo.codprov = null;
//		$scope.msInstitucionesModelo.coddist = null;
	});

	$scope.$watch('dtEntidadesModelo.codProv', function (newValue, oldValue) {
		console.log('dtEntidadesModelo.codProv ' + newValue+' -- '+oldValue);
		$scope.loadlistaCoddist();
//		$scope.msInstitucionesModelo.coddist = null;
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
					.ok('OK')
					.targetEvent(ev)
			);

//			$scope.tdAtencionesModelo.ruc = dato.ruc; 
//			$scope.tdAtencionesModelo.razonSocial = dato.razSocial;
//			$scope.tdAtencionesModelo.idprovee = dato.idEntidad;
//			$scope.tdAtencionesModelo.tipoentidad = dato.idTipo;
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
						.ok('OK')
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
//		        $scope.editdtAsistencia();
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
			        .ok('OK')
			        .targetEvent(ev)
				   );
	            }
	        });			        			        	
    	ev.target.disabled = false;
	 };
	 
	 $scope.nuevoEntidadSisAdmin= function () {
	        $scope.datoEntidadSisAdmin.push({
	        	contador: $scope.datoEntidadSisAdmin.length + 1,
	        	identidadSisadm: "",
	        	idSistAdmi: "", 
	        	idSede: "", 	           
	            add: false
	        })

	        $scope.settingFlagAddAndRemoveEntidadSisAdmin();
	    }
};

