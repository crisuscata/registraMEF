//MPINARES 14022024 - INICIO - NUEVA JS
//CUSCATA - 10072024
var contexto = window.location.pathname.substring(0,window.location.pathname.indexOf('/',2));
var pglogoff = window.location.origin+contexto+'/logoff.htm';
var principalUrl = window.location.origin+contexto+'/index.htm';
var listadtAsistenciaNoProgUrl = contexto+"/rs/ctrldtAsistencia/listadtAsistenciaNoProg";
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
var descargarXLSUrl = contexto+"/rs/ctrlDtReportResumen/descargarXLS";

/*
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
*/

var listaMsSedesUrl = contexto+"/rs/ctrldtAsistencia/listamsSedes";
var listaParametrosXIdPadreToIdParamTipoServicioUrl = contexto+"/rs/ctrlDtReportResumen/listaParametrosXIdPadreToIdParamTipoServicio";
var listaIDValorMsSisAdmiTemaCapaUrl = contexto+"/rs/ctrlDtReportResumen/listaIDValorMsSisAdmiTemaCapa";
var listaIDValorMsSisAdmiBksssUrl = contexto+"/rs/ctrlDtReportResumen/listaIDValorMsSisAdmiBksss";
var listaIDValorMsUserTemaCapaBySedeBySisAdmUrl = contexto+"/rs/ctrlDtReportResumen/listaIDValorMsUserTemaCapaBySedeBySisAdm/";
var listaIDValorMsUserBySedeBySisAdmUrl = contexto+"/rs/ctrlDtReportResumen/listaIDValorMsUserBySedeBySisAdm/";
var listaMsEstadoUrl = contexto+"/rs/ctrlDtReportResumen/listaMsEstado";

var cargarReporteUrl = contexto+"/rs/ctrlDtReportResumen/cargarReporte";



myapp = angular.module('MyApp', ['chart.js','ngMaterial', 'md.data.table', 'ngRoute']);
//myapp = angular.module('MyApp');

myapp.config(function($routeProvider) {
	  $routeProvider
	  .when("/editar/:idAsistencia", {
		  templateUrl : "asistencia/editardtAsistenciaNoProg.html",
		  controller : "ctrlRptResumen"
	  })
	  .when("/nuevo", {
		  templateUrl : "asistencia/editardtAsistenciaNoProg.html",
		  controller : "ctrlRptResumen"
	  })
	  .otherwise({
		  templateUrl : "reportes/servicios/verRptResumen.html",
		  controller : "ctrlRptResumen"  
	  });
	});

myapp.config(['$mdDateLocaleProvider', function ($mdDateLocaleProvider) {
    $mdDateLocaleProvider.formatDate = function (date) {
    	if(date==null)
            return "";
    	var day = date.getDate();
        var monthIndex = date.getMonth();
        var year = date.getFullYear();

        return (day<10?'0'+day:day) + '/' + (monthIndex<9?'0'+(monthIndex + 1):(monthIndex + 1)) + '/' + year;

//        return date ? moment(date).format('DD/MM/YYYY') : '';
    };
    $mdDateLocaleProvider.parseDate = function (dateString) {
//        var m = moment(dateString, 'DD/MM/YYYY', true);
    	var parts = dateString.split("/");
    	var dt = new Date(parseInt(parts[2], 10),
    	                  parseInt(parts[1], 10) - 1,
    	                  parseInt(parts[0], 10));
    	return dt ? dt:new Date(NaN);
//        return m.isValid() ? m.toDate() : new Date(NaN);
    };
}]);

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

myapp.controller('ctrlRptResumen', ['$mdEditDialog', '$scope', '$timeout', '$http', '$mdDialog','$location','$routeParams', '$mdPanel',  'fileUploadServ',
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
	  $scope.loaddtAsistenciasNoProg();
	 };
	 
	 $scope.logItem = function (item) {
	  console.log(item.name, 'was selected');
	 };
	 
	 $scope.logPagination = function (page, limit) {
	  console.log('page: ', page);
	  console.log('limit: ', limit);
	  $scope.loaddtAsistenciasNoProg();
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
	
	
	
	$scope.loadRptResumen = function () {
		if($scope.isDate($scope.filtro.fechaInicio) && $scope.isDate($scope.filtro.fechaFin)){
			if($scope.filtro.fechaInicio.getTime()>$scope.filtro.fechaFin.getTime()){
				$mdDialog.show(
						$mdDialog.alert()
						.parent(angular.element(document.body))
						.clickOutsideToClose(true)
						.title('Buscar capacitaciones')
						.textContent("La fecha de Inicio no puede ser mayor a la fecha de fin")
						.ariaLabel('Lucky day')
						.ok('ACEPTAR')
				);
				return;
			}
		}
		
	    /*	var surl = $scope.getURL();	    
	    	$scope.promise = $http.get(surl).then(function(res){
	    		 $scope.datos = res.data.data;
	    		 if($scope.datos.length>0){
		    		 if(res.data.contador>0)
			    		 $scope.total = res.data.contador;
			    		 var tiempoenBD = res.data.tiempoenBD;
			    		 var tiempoenproceso = res.data.tiempoenproceso;
			    		 $scope.prepublicarCapa = res.data.prepublicar;
			    		 $scope.acumularCapa = res.data.acumular;
			    		 console.log("data " +$scope.datos.length+" DE "+ $scope.total);
			    		 console.log("Tiempo respuesta BD dtCapacitacion " +tiempoenBD+" Tiempo en Paginar "+tiempoenproceso);
			    		 $scope.refrescar=0; 
	    		 }
				});		*/	 
	    	
		$scope.loadlistaMsSedes();
    	$scope.loadListarParametrosXIdPadreToIdParamTipoServicio();
    	$scope.loadllistaMsEstado();
    	$scope.loadlistaIDValorMsSisAdmiTemaCapa();
    	//$scope.loadlistaIDValorMsUserTemaCapaBySedeBySisAdm();
    	$scope.loadUsuario();
	  };
	
	
	  $scope.isFiltroCapa = false;
	  
	  $scope.onTipoServicioChange = function() {
	        console.log('Selected Tipo Servicio:', $scope.filtro.idTipoServicio);
	        
	        var tipoServicioCapacitacion = 133;
	        
	        if( $scope.filtro.idTipoServicio == tipoServicioCapacitacion){
	        	$scope.isFiltroCapa = true;
	        	$scope.promise = $http.get(listaIDValorMsSisAdmiTemaCapaUrl).then(function(res){
	        		$scope.listaIDValorMsSisAdmiTemaCapa = res.data;
	        	});	
	        	
	        	
	        } else{
	        	$scope.isFiltroCapa = false;
	        	$scope.promise = $http.get(listaIDValorMsSisAdmiBksssUrl).then(function(res){
	        		$scope.listaIDValorMsSisAdmiTemaCapa = res.data;
	        	});	
	        }
	        
	 };
	 
	 $scope.loadUsuario = function() {
		 var url = $scope.isFiltroCapa 
	        ? listaIDValorMsUserTemaCapaBySedeBySisAdmUrl  + $scope.filtro.idSede + "/" + $scope.filtro.idSisAdmin
	        : listaIDValorMsUserBySedeBySisAdmUrl + $scope.filtro.idSede + "/" + $scope.filtro.idSisAdmin;

	        $scope.promise = $http.get(url).then(function(res) {
	            $scope.listaIDValorMsUserTemaCapaBySedeBySisAdm = res.data;
	        });
	 }
	 
	 $scope.onUserChange = function() {
	        console.log(' idSede:', $scope.filtro.idSede);
	        console.log(' idSisAdmin:', $scope.filtro.idSisAdmin);
	        
	        
	        $scope.loadUsuario();
	 };
	

	$scope.loaddtAsistenciasNoProg = function () {
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
		  return listadtAsistenciaNoProgUrl+$scope.getURLParametros();
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
			  idTipoServicio: null,
			  idSede: 0,
			  idSisAdmin: 0,
			  idUserInt: 0,
			  idEstado: 0,
			  flagAsis: false
		}; 
	
	  
	  $scope.filtrocapa ={
			  monthYear:null,
			  monthYearMod:null
		}; 
	  
	  $scope.filtroreutrabajo ={
			  monthYear:null,
			  monthYearMod:null
		};
		
		$scope.filtroasistecnica ={
			  monthYear:null,
			  monthYearMod:null
		};
		
		$scope.filtroasistecnicaplazo ={
			  monthYear:null,
			  monthYearMod:null
		};
		
		$scope.filtroconsulta ={
			  monthYear:null,
			  monthYearMod:null
		};
		
	  $scope.filtroesttema ={
			  sisAdmin:null,
			  tema:null,
			  subtema:null
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
			$scope.loaddtAsistenciasNoProg();
		};
		
		
         $scope.refrescarvista = function(ev){
		  if(typeof(ev)=='undefined' || ev==null){
	          
          }else{
			 var keyCode = ev.which || ev.keyCode;
			    if (keyCode === 13) {
			    	$scope.loaddtAsistenciasNoProg();
			    }else if (keyCode === 1) {
			    	$scope.loaddtAsistenciasNoProg();
			    }
          }
//        	 var keyCode = ev.which || ev.keyCode;
//     		if (keyCode === 13) {
//     			$scope.loaddtAsistenciasNoProg();
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
	    
	    
	    
	    
	    /*$scope.descargarXSL = function() {
	        console.log("JSON.stringify($scope.filtro):" + JSON.stringify($scope.filtro));
	        
	        // Ensure fechaInicio and fechaFin are Date objects
	        if (!($scope.filtro.fechaInicio instanceof Date)) {
	            $scope.filtro.fechaInicio = new Date($scope.filtro.fechaInicio);
	        }
	        if (!($scope.filtro.fechaFin instanceof Date)) {
	            $scope.filtro.fechaFin = new Date($scope.filtro.fechaFin);
	        }

	        // Format the dates to 'yyyy-MM-dd'
	        var formattedFechaInicio = $scope.filtro.fechaInicio.toISOString().split('T')[0];  
	        var formattedFechaFin = $scope.filtro.fechaFin.toISOString().split('T')[0];

	        // Construct the URL
	        var url = descargarXLSUrl 
	            + "?fechaInicio=" + encodeURIComponent(formattedFechaInicio)
	            + "&fechaFin=" + encodeURIComponent(formattedFechaFin)
	            + "&idTipoServicio=" + encodeURIComponent($scope.filtro.idTipoServicio || '')
	            + "&idSede=" + encodeURIComponent($scope.filtro.idSede || '')
	            + "&idSisAdmin=" + encodeURIComponent($scope.filtro.idSisAdmin || '')
	            + "&idUserInt=" + encodeURIComponent($scope.filtro.idUserInt || '')
	            + "&idEstado=" + encodeURIComponent($scope.filtro.idEstado || '');

	        console.log("Url:" + url);
	        
	        return url;
	    };
	    
	    
	    $scope.validateDescargarXSL = function(ev) {
	        location.href = $scope.descargarXSL();
	    };*/
	    
	    $scope.descargarXSL = function(){
	        return  descargarXLSUrl+$scope.getURLParametros();
	    };
	    
	    $scope.validateDescargaXSL = function(ev){
	    	
	    	if ($scope.filtro.idTipoServicio === null || $scope.filtro.idTipoServicio === undefined || $scope.filtro.idTipoServicio === 0) {

    			$mdDialog.show(
						$mdDialog.alert()
						.parent(angular.element(document.body))
						.clickOutsideToClose(true)
						.title('REPORTE RESUMEN')
						.textContent("DEBE SELECCIONAR EL TIPO DE SERVICIO PARA LA CONSULTA")
						.ok('OK')
				);
    			return;
    		}
	    	
	    	location.href = $scope.descargarXSL();
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    $scope.dtAsistenciaAnular = {
				idAsistencia : null,
				estado: null,
				detalle: null
			};
	    
	    $scope.selectedAsist = [];
		  $scope.selection = function(asistencia){
			  
			    if(asistencia.checked){
			    	$scope.selectedAsist.push({
			    		idAsistencia: asistencia.idAsistencia,
			    		estado: asistencia.estado
			    	 })
			    	
			    	console.log('$scope.selectedAsist checked: '+ JSON.stringify($scope.selectedAsist) );
			    	
			    }else{
			    	$scope.selectedAsist = $scope.selectedAsist.filter(val => val.idAsistencia !== asistencia.idAsistencia);
			    	
			    	console.log('$scope.selectedAsist no checked: '+ JSON.stringify($scope.selectedAsist) );
			    }
		};
		  
		  $scope.showConfirmAnularAsistencia = function(ev) {
			  
			  console.log("$scope.selectedAsist:" + JSON.stringify($scope.selectedAsist));
			  
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
				console.log("datainsert to anular = "+datainsert);	
			$http.post(anulardtAsistenciaUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
					var dato1 = res.data;
			        $scope.loaddtAsistenciasNoProg();
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
						$scope.loaddtAsistenciasNoProg();
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
				    
				
        $scope.listaDtEntidadesIdEntidad=[];
		$scope.loadListaDtEntidadesIdEntidad=function(){
			$http.get(listaDtEntidadesidEntidadIdEntidadUrl).then(function(res){
				$scope.listaDtEntidadesIdEntidad = res.data; 
			},
			function error(errResponse) {
				console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
			});
		};
		
		$scope.listarParametrosXIdPadreToIdParamTipoServicio=[];
		$scope.loadListarParametrosXIdPadreToIdParamTipoServicio=function(){
			$http.get(listaParametrosXIdPadreToIdParamTipoServicioUrl).then(function(res){
				$scope.listarParametrosXIdPadreToIdParamTipoServicio = res.data; 
			},
			function error(errResponse) {
				console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
			});
		};
		
		$scope.listaIDValorMsSisAdmiTemaCapa=[];
		$scope.loadlistaIDValorMsSisAdmiTemaCapa=function(){
			$http.get(listaIDValorMsSisAdmiTemaCapaUrl).then(function(res){
				$scope.listaIDValorMsSisAdmiTemaCapa = res.data; 
			},
			function error(errResponse) {
				console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
			});
		};
		
		$scope.listaIDValorMsSisAdmiBksss=[];
		$scope.loadlistaIDValorMsSisAdmiBksss=function(){
			$http.get(listaIDValorMsSisAdmiBksssUrl).then(function(res){
				$scope.listaIDValorMsSisAdmiBksss = res.data; 
			},
			function error(errResponse) {
				console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
			});
		};
		
		/*$scope.listaIDValorMsUserTemaCapaBySedeBySisAdm=[];
		$scope.loadlistaIDValorMsUserTemaCapaBySedeBySisAdm=function(){
			$http.get(listaIDValorMsUserTemaCapaBySedeBySisAdmUrl).then(function(res){
				$scope.listaIDValorMsUserTemaCapaBySedeBySisAdm = res.data; 
			},
			function error(errResponse) {
				console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
			});
		};*/
		
		
		$scope.listaIDValorMsUserBySedeBySisAdm=[];
		$scope.loadllistaIDValorMsUserBySedeBySisAdm=function(){
			$http.get(listaIDValorMsUserBySedeBySisAdmUrl).then(function(res){
				$scope.listaIDValorMsUserBySedeBySisAdm = res.data; 
			},
			function error(errResponse) {
				console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
			});
		};
		
		$scope.listaMsEstado=[];
		$scope.loadllistaMsEstado=function(){
			$http.get(listaMsEstadoUrl).then(function(res){
				$scope.listaMsEstado = res.data; 
			},
			function error(errResponse) {
				console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
			});
		};
		
		
		$scope.reportecapacitacionResumen=[];
		$scope.listCapacitacion=[];
		$scope.loadReporteResumen=function(){
			$http.get(cargarReporteUrl+$scope.getURLParametros()).then(function(res){
				
				//$scope.listCapacitacionEvolMensual = res.data.listCapacitacionEvolMensual; 
				
				//console.log("$scope.listCapacitacionEvolMensual: " + JSON.stringify( $scope.listCapacitacionEvolMensual ));
				
				$scope.reportecapacitacionResumen = res.data;
				$scope.buildDashboardCapacitacion(res.data);
				$scope.buildUsuarioCapacitadoPorTematica(res.data);
				$scope.buildDashboardCapacitacionByModalidad(res.data);
				$scope.buildDashboardReunionTrabajoEvolMensual(res.data);
				$scope.buildDashboardReunionTrabajoPorTematica(res.data);
				$scope.buildDashboardAsistenciaTecEvolMensual(res.data);
				$scope.buildDashboardAsistenciaTecPorTematica(res.data);
				$scope.buildDashboardAsistenciaTecByModalidad(res.data);
				$scope.buildDashboardConsultaEvolMensual(res.data);
				$scope.buildDashboardConsultaPorTematica(res.data);
				$scope.buildDashboardConsultaByModalidad(res.data);
				
				$scope.buildDashboardEstadisticaPorTema(res.data);
				$scope.buildTableAsistenciaDentroFueraPlazo(res.data);
				
				
				
				
				/*if (res.data!=null && res.data.listCapacitacion.length > 0) {
					$scope.listCapacitacion = res.data.listCapacitacion.filter(c => c.asitio === 'SI' && c.estado === 'FINALIZADO');
					$scope.buildDashboardCapacitacion($scope.listCapacitacion);
				}*/
				
				
				
			},
			function error(errResponse) {
				console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
			});
		};
		
		$scope.getMonth = function(fecha){
			var date = new Date(fecha);

			var month = date.getMonth();
			
			return month; 
		}
		
		$scope.getAnio = function(fecha){
			
			var date = new Date(fecha);
			var year = date.getFullYear()
			
			return year; 
		}
		
		
		/*
		$scope.showReportResumen2 = function() {
			  $scope.meses = [" ", "Enero 2024", "Febrero 2024", "Total"];
			  $scope.dataRows = [
			    ["Capacitados", "7000", "8000", "15000"],
			    ["Some Other Data", "Data1", "Data2", "Data3"]
			  ];
			}
*/
        
		$scope.showReportResumen =function(){
			
			const fechaInicio = new Date($scope.filtro.fechaInicio);
			const fechaFin = new Date($scope.filtro.fechaFin);
			
			console.log("fechaInicio: " + fechaInicio);
			console.log("fechaFin: " + fechaFin);
			
			const differenceInMilliseconds = fechaFin - fechaInicio;
			
			const differenceInDays = differenceInMilliseconds / (1000 * 60 * 60 * 24);
			
			//if (differenceInDays <= 31) {
				$scope.loadReporteResumen();
			/*} else{
				$mdDialog.show(
				         $mdDialog.alert()
				        .parent(angular.element(document.body))
				        .clickOutsideToClose(true)
				        .title('Cargar Reporte')
				        .textContent("El rango de fecha debe ser menor o igual a 31 dias")
				        .ariaLabel('ERROR')
				        .ok('OK')
				    );
			}*/
			
		}
		
		$scope.getNameOfMonth = function(index) {
			var monthNames = ['ENERO', 'FEBRERO', 'MARZO','ABRIL','MAYO','JUNIO','JULIO','AGOSTO','SEPTIEMBRE','OCTUBRE','NOVIEMBRE','DICIEMBRE'];
			return monthNames[index-1];
		}
		
		$scope.buildCapacitacionSummary = function(listCapacitacion) {
		    const monthYearData = {};

		    listCapacitacion.forEach(function(event) {
		        const date = new Date(event.fechaInic);  // Convert timestamp to date
		        const month = date.getUTCMonth();  // Extract the month (0-11)
		        const year = date.getUTCFullYear(); // Extract the year
		        const monthYearKey = `${month + 1}-${year}`;  // Create "month-year" key

		        if (!monthYearData[monthYearKey]) {
		            monthYearData[monthYearKey] = event.cantParticAsist;
		        } else {
		            monthYearData[monthYearKey] += event.cantParticAsist;
		        }
		    });

		    const monthYearArray = Object.keys(monthYearData)
		        .map(key => {
		            const [month, year] = key.split('-');
		            return { month: parseInt(month), year: parseInt(year), sum: monthYearData[key] };
		        })
		        .sort((a, b) => (a.year - b.year) || (a.month - b.month));

		    const monthYearLabels = monthYearArray.map(item => 
		        `${new Date(Date.UTC(item.year, item.month - 1)).toLocaleString('default', { month: 'long' })} ${item.year}`
		    );
		    
		    const sumsOfParticipants = monthYearArray.map(item => item.sum);

		    return {
		        labels: monthYearLabels,
		        data: sumsOfParticipants
		    };
		};

		/*$scope.showReportResumen2 = function() {
		    var listCapacitacion = [
		        {
		            "fechaInic": 1721223000000, // July 2024 (timestamp for a date in July)
		            "cantParticAsist": 100
		        },
		        {
		            "fechaInic": 1721223000000, // July 2024
		            "cantParticAsist": 300
		        },
		        {
		            "fechaInic": 1721854800000, // August 2024 (timestamp for a date in August)
		            "cantParticAsist": 300
		        },
		        {
		            "fechaInic": 1721854800000, // August 2024
		            "cantParticAsist": 700
		        }
		    ];

		    listCapacitacion.forEach(function(event) {
		        const date = new Date(event.fechaInic);
		        console.log('Converted Date:', date.toUTCString()); // Print the UTC date
		    });

		    var result = $scope.buildCapacitacionSummary(listCapacitacion);

		    console.log(JSON.stringify(result));
		};*/


		
		$scope.buildDashboardCapacitacion =function(data) {
			
			var listCapacitacionEvolMensual = data.listCapacitacionEvolMensual; 
			
			
			console.log("listCapacitacionEvolMensual :" + JSON.stringify(listCapacitacionEvolMensual));
			
			var labels = listCapacitacionEvolMensual.map(item => item.monthYear.trim());
			var participantsData = listCapacitacionEvolMensual.map(item => item.totalParticipants);
			var eventsData = listCapacitacionEvolMensual.map(item => item.totalEvents);
			
			//BUILD DASHBOARD Evolución Mensual
			$scope.buildDashboardEvolMensual(eventsData, labels, 'mixedChartCapaEvolMensual', 'Capacitación');
			/*var chartOptions = {
			        responsive: true,
			        scales: {
			            y: {
			                beginAtZero: true
			            }
			        }
			    };

			    var chartData = {
			        labels: labels,
			        datasets: [
			            {
			                type: 'bar',
			                label: 'Participantes',
			                data: participantsData,
			                backgroundColor: 'rgba(75, 192, 192, 0.2)',
			                borderColor: 'rgba(75, 192, 192, 1)',
			                borderWidth: 1
			            },
			            {
		                    type: 'line',
		                    label: 'Total',
		                    data: participantsData,
		                    borderColor: 'rgba(255, 99, 132, 1)',
		                    backgroundColor: 'rgba(255, 99, 132, 0.2)',
		                    borderWidth: 2,
		                    fill: false
		                }
			        ]
			    };

			    angular.element(document).ready(function () {
			        var ctx = document.getElementById('mixedChartCapaEvolMensual').getContext('2d');
			        new Chart(ctx, {
			            type: 'bar',
			            data: chartData,
			            options: chartOptions
			        });
			    });*/
			
			//Build Table
			$scope.mesesCapacitacion = [" ", ...labels , "Total"];
			
			$scope.dataCapacitacionEventoRows = [
			    { id: 1, cells: ["Capacitados", ...participantsData, participantsData.reduce((sum, value) => sum + value, 0)] },
			    { id: 2, cells: ["Eventos", ...eventsData, eventsData.reduce((sum, value) => sum + value, 0)] }
			  ];
			
		}
		
		function getUniqueCapacitacion(list) {
            const map = new Map();
            list.forEach(item => {
                if (!map.has(item.idCapacitacion)) {
                    map.set(item.idCapacitacion, item);
                }
            });

            return Array.from(map.values());
        }
		
		$scope.findMonthFechaFinal = function(){
		    var monthFechaFinal = $scope.getMonth($scope.filtro.fechaFin);
		    
		    var monthNames = ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'];
		    
		    var monthName = monthNames[monthFechaFinal];
		    
		    console.log("monthName:"+monthName);
		    
		    return monthName;
		}
		
	    $scope.onDashCapaByTematica = function(month) {
	        if (month === 0) {
	            var listCapacitacionUsSegunTematicaByLastMonth = $scope.listCapacitacionUsSegunTematica;
	        } else {
	            var listCapacitacionUsSegunTematicaByLastMonth = $scope.listCapacitacionUsSegunTematica.filter(item => item.monthYear.includes(month));
	        }
	        
	        var labels = listCapacitacionUsSegunTematicaByLastMonth.map(item => item.abreviaturaAdmin.trim());
	        var participantsData = listCapacitacionUsSegunTematicaByLastMonth.map(item => item.totalParticipants);
	        
	        $scope.showDashboardBar(labels, participantsData, 'barChartCapaByTematica', 'Eventos');
	    };

		
		$scope.listaCapaByTematica=[];
		$scope.listCapacitacionUsSegunTematica=[];
		$scope.buildUsuarioCapacitadoPorTematica = function(data){
			$scope.listCapacitacionUsSegunTematica = data.listCapacitacionUsSegunTematica; 
			
			$scope.listaCapaByTematica = $scope.listCapacitacionUsSegunTematica.filter((value, index, self) => 
		    		index === self.findIndex((t) => t.monthYear === value.monthYear)
			);

			var lastMonth = $scope.findMonthFechaFinal();
			var lastAnio = $scope.getAnio($scope.filtro.fechaFin);
			
			$scope.filtrocapa.monthYear = lastMonth + ' '+ lastAnio;
			
			$scope.onDashCapaByTematica(lastMonth);
			
		}
		
		$scope.showDashboardBar = function(labels, data, idElementHTML, nameSerie){
			
			var series = [nameSerie];
	        
		    var options = {
		        scales: {
		            y: {
		                beginAtZero: true
		            }
		        }
		    };

		    angular.element(document).ready(function () {
		        var ctx = document.getElementById(idElementHTML).getContext('2d');
		        new Chart(ctx, {
		            type: 'bar',
		            data: {
		                labels: labels,
		                datasets: series.map(function(series, index) {
		                    return {
		                        label: series,
		                        data: data,
		                        backgroundColor: 'rgba(75, 192, 192, 0.2)',
		                        borderColor: 'rgba(75, 192, 192, 1)',
		                        borderWidth: 1
		                    };
		                })
		            },
		            options: options
		        });
		    });
			
		}
		
		
		
		//CAPACITACION POR MODALIDAD
		
		$scope.onDashCapaByModalidad = function(month) {
			var listCapacitacionModalidadByLastMonth = null;
			if (month === 0) {
				listCapacitacionModalidadByLastMonth = $scope.listaMonthCapaByModalidad;
	        } else {
	        	listCapacitacionModalidadByLastMonth = $scope.listaMonthCapaByModalidad.filter(item => item.monthYear.includes(month));
	        }
	        
			var virtualData = listCapacitacionModalidadByLastMonth.map(item => item.totalVirtual);
			var totalVirtual = virtualData.reduce((sum, value) => sum + value, 0)
			
			var presencialData = listCapacitacionModalidadByLastMonth.map(item => item.totalPresencial);
			var totalPresencial = presencialData.reduce((sum, value) => sum + value, 0)
			
			
			var chartData = {
		        labels: ['Virtual', 'Presencial'],
		        datasets: [{
		            data: [totalVirtual, totalPresencial],
		            backgroundColor: ['#FF6384', '#36A2EB'], 
		            hoverBackgroundColor: ['#FF6384', '#36A2EB']
		        }]
		    };
			
			$scope.showDashByModalidad(chartData,'doughnutByModalidad');
			
	    };
		
		$scope.listaMonthCapaByModalidad=[];
		$scope.listaCapaByModalidadGeneral=[];
		$scope.buildDashboardCapacitacionByModalidad =function(data) {
			
			$scope.listaMonthCapaByModalidad = data.listCapacitacionModalidad; 
			
			$scope.listaMonthCapaByModalidad = $scope.listaMonthCapaByModalidad.filter((value, index, self) => 
    		index === self.findIndex((t) => t.monthYear === value.monthYear)
			);
			
			var labels = $scope.listaMonthCapaByModalidad.map(item => item.monthYear.trim());
			
			var virtualData = $scope.listaMonthCapaByModalidad.map(item => item.totalVirtual);
			var totalVirtual = virtualData.reduce((sum, value) => sum + value, 0)
			
			console.log("virtualData:"+virtualData);
			console.log("totalVirtual:"+totalVirtual);
			
			var presencialData = $scope.listaMonthCapaByModalidad.map(item => item.totalPresencial);
			var totalPresencial = presencialData.reduce((sum, value) => sum + value, 0)
			
			console.log("presencialData:"+presencialData);
			console.log("totalPresencial:"+totalPresencial);
			
			
			var lastMonth = $scope.findMonthFechaFinal();
			var lastAnio = $scope.getAnio($scope.filtro.fechaFin);
			
			$scope.filtrocapa.monthYearMod = lastMonth + ' '+ lastAnio;
			
			$scope.onDashCapaByModalidad(lastMonth);
		    
		    //Build Table
			$scope.mesesCapaModa = ["Por capacitación", ...labels , "Total"];
			
			$scope.dataCapacitacionModalidadRows = [
			    { id: 1, cells: ["Presencial", ...presencialData, totalPresencial] },
			    { id: 2, cells: ["Virtual", ...virtualData, totalVirtual] }
			  ];
			
		}
		
		//ASISTENCIA TECNICA POR MODALIDAD
		$scope.onDashAsistTecnicaByModalidad = function(month) {
			var listAsisTecModalidadByLastMonth = null;
			if (month === 0) {
				listAsisTecModalidadByLastMonth = $scope.listaMonthAsisTecByModalidad;
	        } else {
	        	listAsisTecModalidadByLastMonth = $scope.listaMonthAsisTecByModalidad.filter(item => item.monthYear.includes(month));
	        }
	        
			var virtualData = listAsisTecModalidadByLastMonth.map(item => item.totalVirtual);
			var totalVirtual = virtualData.reduce((sum, value) => sum + value, 0)
			
			var presencialData = listAsisTecModalidadByLastMonth.map(item => item.totalPresencial);
			var totalPresencial = presencialData.reduce((sum, value) => sum + value, 0)
			
			var telefonicaData = listAsisTecModalidadByLastMonth.map(item => item.totalTelefonico);
			var totalTelefonica = telefonicaData.reduce((sum, value) => sum + value, 0)
			
			
			var chartData = {
		        labels: ['Virtual', 'Presencial', 'Telefónica'],
		        datasets: [{
		            data: [totalVirtual, totalPresencial, totalTelefonica],
		            backgroundColor: ['#FF6384', '#36A2EB', '#63ffb1'], 
		            hoverBackgroundColor: ['#FF6384', '#36A2EB', '#63ffb1']
		        }]
		    };
			
			$scope.showDashByModalidad(chartData,'doughnutAsisTecByModalidad');
			
	    };
		
		$scope.listaMonthAsisTecByModalidad=[];
		$scope.listaAsisTecByModalidadGeneral=[];
		$scope.buildDashboardAsistenciaTecByModalidad =function(data) {
			
			$scope.listaAsisTecByModalidadGeneral = data.listReporteAsistenciaTecnicaModalidad; 
			
			$scope.listaMonthAsisTecByModalidad = $scope.listaAsisTecByModalidadGeneral.filter((value, index, self) => 
    		index === self.findIndex((t) => t.monthYear === value.monthYear)
			);
			
			var titleOfTable = $scope.listaMonthAsisTecByModalidad.map(item => item.monthYear.trim());
			
			var virtualData = $scope.listaMonthAsisTecByModalidad.map(item => item.totalVirtual);
			var totalVirtual = virtualData.reduce((sum, value) => sum + value, 0)
			
			var presencialData = $scope.listaMonthAsisTecByModalidad.map(item => item.totalPresencial);
			var totalPresencial = presencialData.reduce((sum, value) => sum + value, 0)
			
			var telefonicaData = $scope.listaMonthAsisTecByModalidad.map(item => item.totalTelefonico);
			var totalTelefonica = telefonicaData.reduce((sum, value) => sum + value, 0)
			
			
			var lastMonth = $scope.findMonthFechaFinal();
			var lastAnio = $scope.getAnio($scope.filtro.fechaFin);
			
			$scope.filtroasistecnica.monthYearMod = lastMonth + ' '+ lastAnio;
			
			$scope.onDashAsistTecnicaByModalidad(lastMonth);
		    
		    //Build Table
			$scope.mesesAsisTecModa = [" ", ...titleOfTable , "Total"];
			
			$scope.dataAsisTecModalidadRows = [
			    { id: 1, cells: ["Presencial", ...presencialData, totalPresencial] },
			    { id: 2, cells: ["Virtual", ...virtualData, totalVirtual] },
			    { id: 3, cells: ["Telefónica", ...telefonicaData, totalTelefonica] }
			  ];
			
		}
		
		//CONSULTA POR MODALIDAD
		
		$scope.onDashConsultaByModalidad = function(month) {
			var listConsultaModalidadByLastMonth = null;
			if (month === 0) {
				listConsultaModalidadByLastMonth = $scope.listaMonthConsultaByModalidad;
	        } else {
	        	listConsultaModalidadByLastMonth = $scope.listaMonthConsultaByModalidad.filter(item => item.monthYear.includes(month));
	        }
	        
			var virtualData = listConsultaModalidadByLastMonth.map(item => item.totalVirtual);
			var totalVirtual = virtualData.reduce((sum, value) => sum + value, 0)
			
			var presencialData = listConsultaModalidadByLastMonth.map(item => item.totalPresencial);
			var totalPresencial = presencialData.reduce((sum, value) => sum + value, 0)
			
			var telefonicaData = listConsultaModalidadByLastMonth.map(item => item.totalTelefonico);
			var totalTelefonica = telefonicaData.reduce((sum, value) => sum + value, 0)
			
			
			var chartData = {
		        labels: ['Virtual', 'Presencial', 'Telefónica'],
		        datasets: [{
		            data: [totalVirtual, totalPresencial, totalTelefonica],
		            backgroundColor: ['#FF6384', '#36A2EB', '#63ffb1'], 
		            hoverBackgroundColor: ['#FF6384', '#36A2EB', '#63ffb1']
		        }]
		    };
			
			$scope.showDashByModalidad(chartData,'doughnutConsultaByModalidad');
			
	    };
		
		$scope.listaMonthConsultaByModalidad=[];
		$scope.listaConsultaByModalidadGeneral=[];
		$scope.buildDashboardConsultaByModalidad =function(data) {
			
			$scope.listaConsultaByModalidadGeneral = data.listConsultaModalidad; 
			
			$scope.listaMonthConsultaByModalidad = $scope.listaConsultaByModalidadGeneral.filter((value, index, self) => 
    		index === self.findIndex((t) => t.monthYear === value.monthYear)
			);
			
			var titleOfTable = $scope.listaMonthConsultaByModalidad.map(item => item.monthYear.trim());
			
			var virtualData = $scope.listaMonthConsultaByModalidad.map(item => item.totalVirtual);
			var totalVirtual = virtualData.reduce((sum, value) => sum + value, 0)
			
			var presencialData = $scope.listaMonthConsultaByModalidad.map(item => item.totalPresencial);
			var totalPresencial = presencialData.reduce((sum, value) => sum + value, 0)
			
			var telefonicaData = $scope.listaMonthConsultaByModalidad.map(item => item.totalTelefonico);
			var totalTelefonica = telefonicaData.reduce((sum, value) => sum + value, 0)
			
			
			var lastMonth = $scope.findMonthFechaFinal();
			var lastAnio = $scope.getAnio($scope.filtro.fechaFin);
			
			$scope.filtroconsulta.monthYearMod = lastMonth + ' '+ lastAnio;
			
			$scope.onDashAsistTecnicaByModalidad(lastMonth);
		    
		    //Build Table
			$scope.mesesConsultaModa = [" ", ...titleOfTable , "Total"];
			
			$scope.dataConsultaModalidadRows = [
			    { id: 1, cells: ["Presencial", ...presencialData, totalPresencial] },
			    { id: 2, cells: ["Virtual", ...virtualData, totalVirtual] },
			    { id: 3, cells: ["Telefónica", ...telefonicaData, totalTelefonica] }
			  ];
			
		}
		
		
		
		
		
		
		$scope.showDashByModalidad =function(chartData, nameIdHTMLElement) {

		    var chartOptions = {
		            responsive: true,
		            maintainAspectRatio: false, 
		            plugins: {
		                legend: {
		                    position: 'top',
		                    labels: {
		                        font: {
		                            size: 14 
		                        }
		                    }
		                },
		                tooltip: {
		                    callbacks: {
		                        label: function(tooltipItem) {
		                            return tooltipItem.label + ': ' + tooltipItem.raw;
		                        }
		                    }
		                }
		            },
		            layout: {
		                padding: {
		                    top: 10,
		                    bottom: 10,
		                    left: 10,
		                    right: 10
		                }
		            }
		        };

		    angular.element(document).ready(function () {
		        var ctx = document.getElementById(nameIdHTMLElement).getContext('2d');
		        new Chart(ctx, {
		            type: 'doughnut',
		            data: chartData,
		            options: chartOptions
		        });
		    });
			
		}
		
		$scope.buildDashboardReunionTrabajoEvolMensual =function(data) {
			
			var listReunionTrabajoEvolMensual = data.listReunionTrabajoEvolMensual; 
			
			console.log("listReunionTrabajoEvolMensual :" + JSON.stringify(listReunionTrabajoEvolMensual));
			
			var labels = listReunionTrabajoEvolMensual.map(item => item.monthYear.trim());
			var totalData = listReunionTrabajoEvolMensual.map(item => item.total);
			
			
			//BUILD DASHBOARD Evolución Mensual
			$scope.buildDashboardEvolMensual(totalData, labels, 'mixedChartReunionTraEvolMensual', 'Reu Trabajo');
			/*var chartOptions = {
			        responsive: true,
			        scales: {
			            y: {
			                beginAtZero: true
			            }
			        }
			    };

			    var chartData = {
			        labels: labels,
			        datasets: [
			            {
			                type: 'bar',
			                label: 'Total',
			                data: totalData,
			                backgroundColor: 'rgba(75, 192, 192, 0.2)',
			                borderColor: 'rgba(75, 192, 192, 1)',
			                borderWidth: 1
			            },
			            {
		                    type: 'line',
		                    label: 'Total',
		                    data: totalData,
		                    borderColor: 'rgba(255, 99, 132, 1)',
		                    backgroundColor: 'rgba(255, 99, 132, 0.2)',
		                    borderWidth: 2,
		                    fill: false
		                }
			        ]
			    };

			    angular.element(document).ready(function () {
			        var ctx = document.getElementById('mixedChartReunionTraEvolMensual').getContext('2d');
			        new Chart(ctx, {
			            type: 'bar',
			            data: chartData,
			            options: chartOptions
			        });
			    });*/
			
			//Build Table
			$scope.mesesReunionTra = [" ", ...labels , "Total"];
			
			$scope.dataReunTrabajRows = [
			    { id: 1, cells: ["Reuniones de Trabajo", ...totalData, totalData.reduce((sum, value) => sum + value, 0)] }
			  ];
			
		}
		
		$scope.buildDashboardAsistenciaTecEvolMensual = function(data) {
			
			var listReporteAsistenciaTecnicaEvolMensual = data.listReporteAsistenciaTecnicaEvolMensual; 
			
			console.log("listReporteAsistenciaTecnicaEvolMensual :" + JSON.stringify(listReporteAsistenciaTecnicaEvolMensual));
			
			var labels = listReporteAsistenciaTecnicaEvolMensual.map(item => item.monthYear.trim());
			var totalData = listReporteAsistenciaTecnicaEvolMensual.map(item => item.total);
			
			//BUILD DASHBOARD Evolución Mensual
			$scope.buildDashboardEvolMensual(totalData, labels, 'mixedChartAsisTecnicaEvolMensual', 'Asistencias');
			
			//Build Table
			$scope.mesesAsistenciaTec = [" ", ...labels , "Total"];
			
			$scope.dataAsistenciaTecRows = [
			    { id: 1, cells: ["Asistencias", ...totalData, totalData.reduce((sum, value) => sum + value, 0)] }
			  ];
			
		}
		
		$scope.buildDashboardEvolMensual = function(totalData, labels, idElementHTML, nameSerie) {
			
			var chartOptions = {
			        responsive: true,
			        scales: {
			            y: {
			                beginAtZero: true
			            }
			        }
			    };

			    var chartData = {
			        labels: labels,
			        datasets: [
			            {
			                type: 'bar',
			                label: 'Total',
			                data: totalData,
			                backgroundColor: 'rgba(75, 192, 192, 0.2)',
			                borderColor: 'rgba(75, 192, 192, 1)',
			                borderWidth: 1
			            },
			            {
		                    type: 'line',
		                    label: 'Total',
		                    data: totalData,
		                    borderColor: 'rgba(255, 99, 132, 1)',
		                    backgroundColor: 'rgba(255, 99, 132, 0.2)',
		                    borderWidth: 2,
		                    fill: false
		                }
			        ]
			    };

			    angular.element(document).ready(function () {
			        var ctx = document.getElementById(idElementHTML).getContext('2d');
			        new Chart(ctx, {
			            type: 'bar',
			            data: chartData,
			            options: chartOptions
			        });
			    });
			
		}
		
		//CONSULTA EVOL MENSUAL
		
		$scope.buildDashboardConsultaEvolMensual = function(data) {
			
			var lisConsultaEvolMensual = data.lisConsultaEvolMensual; 
			
			var labels = lisConsultaEvolMensual.map(item => item.monthYear.trim());
			var totalData = lisConsultaEvolMensual.map(item => item.total);
			
			//BUILD DASHBOARD Evolución Mensual
			$scope.buildDashboardEvolMensual(totalData, labels, 'mixedChartConsultaEvolMensual', 'Consulta');
			
			//Build Table
			$scope.mesesConsultas = [" ", ...labels , "Total"];
			
			$scope.dataConsultasRows = [
			    { id: 1, cells: ["Consultas", ...totalData, totalData.reduce((sum, value) => sum + value, 0)] }
			  ];
			
		}
		
		/*$scope.onDashReuTrabajByTematica = function(month) {
	        if (month === 0) {
	            var listReunionTrabajoUsSegunTematicaByLastMonth = $scope.listReunionTrabajoUsSegunTematica;
	        } else {
	            var listReunionTrabajoUsSegunTematicaByLastMonth = $scope.listReunionTrabajoUsSegunTematica.filter(item => item.monthYear.includes(month));
	        }
	        
	        var labels = listReunionTrabajoUsSegunTematica.map(item => item.abreviatura.trim());
	        var data = listReunionTrabajoUsSegunTematicaByLastMonth.map(item => item.total);
	        
	        $scope.showDashboardBar(labels, data, 'barChartReuTrabajoByTematica', 'Usuarios');
	    };*/
	    
	    $scope.onDashReuTrabajByTematica = function(month) {
	        let listReunionTrabajoUsSegunTematicaByLastMonth;
	        
	        if (month === 0) {
	            listReunionTrabajoUsSegunTematicaByLastMonth = $scope.listReunionTrabajoUsSegunTematica;
	        } else {
	            listReunionTrabajoUsSegunTematicaByLastMonth = $scope.listReunionTrabajoUsSegunTematica.filter(item => item.monthYear.includes(month));
	        }
	        
	        var labels = listReunionTrabajoUsSegunTematicaByLastMonth.map(item => item.abreviatura.trim());
	        var data = listReunionTrabajoUsSegunTematicaByLastMonth.map(item => item.total);
	        
	        $scope.showDashboardBar(labels, data, 'barChartReuTrabajoByTematica', 'Usuarios');
	    };

	    
		
		$scope.listReunionTrabajoUsSegunTematica=[];
		$scope.listaReuTrabByTematica=[];
		$scope.buildDashboardReunionTrabajoPorTematica = function(data){
			$scope.listReunionTrabajoUsSegunTematica = data.listReunionTrabajoUsSegunTematica; 
			
			$scope.listaReuTrabByTematica = $scope.listReunionTrabajoUsSegunTematica.filter((value, index, self) => 
		    		index === self.findIndex((t) => t.monthYear === value.monthYear)
			);

			var lastMonth = $scope.findMonthFechaFinal();
			var lastAnio = $scope.getAnio($scope.filtro.fechaFin);
			
			$scope.filtroreutrabajo.monthYear = lastMonth + ' '+ lastAnio;
			
			$scope.onDashReuTrabajByTematica(lastMonth);
			
		}
		
		$scope.listEstadisticaPorTema=[];
		$scope.listSistAdmin=[];
		$scope.buildDashboardEstadisticaPorTema = function(data){
			$scope.listEstadisticaPorTema = data.listEstadisticaPorTema; 
			
			//console.log("listEstadisticaPorTema: "+JSON.stringify( $scope.listEstadisticaPorTema ));
			
			let uniqueSistAdmin = new Set();
			
			$scope.listEstadisticaPorTema.forEach(item => {
			    if (!uniqueSistAdmin.has(item.sistAdmin)) {
			        uniqueSistAdmin.add(item.sistAdmin);
			        $scope.listSistAdmin.push({ "sistAdmin": item.sistAdmin });
			    }
			});
			//
			
			//console.log("listSistAdmin: "+JSON.stringify( $scope.listSistAdmin ));
			
		}
		
		//ASIS TECNICA POR TEMA
		
		$scope.onDashAsistenciaTecnicaByTematica = function(month) {
	        let listAsisteTecnicaSegunTematicaByLastMonth;
	        
	        if (month === 0) {
	            listAsisteTecnicaSegunTematicaByLastMonth = $scope.listAsistenciaTecnicaSegunTematica;
	        } else {
	            listAsisteTecnicaSegunTematicaByLastMonth = $scope.listAsistenciaTecnicaSegunTematica.filter(item => item.monthYear.includes(month));
	        }
	        
	        var labels = listAsisteTecnicaSegunTematicaByLastMonth.map(item => item.abreviatura.trim());
	        var data = listAsisteTecnicaSegunTematicaByLastMonth.map(item => item.total);
	        
	        $scope.showDashboardBar(labels, data, 'barChartAsistenciaTecnicaByTematica', 'Usuarios');
	    };
		
		
		$scope.listAsistenciaTecnicaSegunTematica=[];
		$scope.listaAsisTecnicaByTematica=[];
		$scope.buildDashboardAsistenciaTecPorTematica = function(data){
			$scope.listAsistenciaTecnicaSegunTematica = data.listReporteAsistenciaTecnicaSegunTematica; 
			
			$scope.listaAsisTecnicaByTematica = $scope.listAsistenciaTecnicaSegunTematica.filter((value, index, self) => 
		    		index === self.findIndex((t) => t.monthYear === value.monthYear)
			);

			var lastMonth = $scope.findMonthFechaFinal();
			var lastAnio = $scope.getAnio($scope.filtro.fechaFin);
			
			$scope.filtroasistecnica.monthYear = lastMonth + ' '+ lastAnio;
			
			$scope.onDashAsistenciaTecnicaByTematica(lastMonth);
			
		}
		
		
		//CONSULTA POR TEMA
		
		$scope.onDashConsultaByTematica = function(month) {
	        let listConsultaByLastMonth;
	        
	        if (month === 0) {
	            listConsultaByLastMonth = $scope.listConsultaSegunTematica;
	        } else {
	            listConsultaByLastMonth = $scope.listConsultaSegunTematica.filter(item => item.monthYear.includes(month));
	        }
	        
	        var labels = listConsultaByLastMonth.map(item => item.abreviatura.trim());
	        var data = listConsultaByLastMonth.map(item => item.total);
	        
	        $scope.showDashboardBar(labels, data, 'barChartConsultaByTematica', 'Consulta');
	    };
		
		
		
		$scope.listConsultaSegunTematica=[];
		$scope.listaConsultaByTematica=[];
		$scope.buildDashboardConsultaPorTematica = function(data){
			$scope.listConsultaSegunTematica = data.listConsultaSegunTematica; 
			
			$scope.listaConsultaByTematica = $scope.listConsultaSegunTematica.filter((value, index, self) => 
		    		index === self.findIndex((t) => t.monthYear === value.monthYear)
			);

			var lastMonth = $scope.findMonthFechaFinal();
			var lastAnio = $scope.getAnio($scope.filtro.fechaFin);
			
			$scope.filtroconsulta.monthYear = lastMonth + ' '+ lastAnio;
			
			$scope.onDashConsultaByTematica(lastMonth);
			
		}
		
		
		
		
		
		
		
		$scope.listTema=[];
		$scope.onDashEstTemaDashAndTemas = function(sisAdmin) {
			
			console.log("sisAdmin: "+sisAdmin);
			
			let uniqueTemas = new Set();

		    $scope.listTema = $scope.listEstadisticaPorTema.filter(function(item) {
		        if (item.sistAdmin === sisAdmin && !uniqueTemas.has(item.tema)) {
		            uniqueTemas.add(item.tema);
		            return true;
		        }
		        return false;
		    });
    		
    		//console.log("$scope.listTema: "+JSON.stringify( $scope.listTema ));
			
		}
		
		var doughnutChartInstance = null;
		$scope.onDashEstTemaSubTema = function(sisAdmin, tema) {
			
			  var filteredList = $scope.listEstadisticaPorTema.filter(function(item) {
			    return item.sistAdmin === sisAdmin && item.tema === tema;
			  });
			
			  $scope.subTemas = filteredList.map(function(item) {
			    return {
			      subtema: item.subtema,
			      cantidadTotal: item.cantidadTotal
			    };
			  });
			
			console.log("result:" + JSON.stringify($scope.subTemas));
			
			$scope.totalCantidadTotal = $scope.subTemas.reduce(function(sum, item) {
		        return sum + item.cantidadTotal;
		    }, 0);
			
			var labels = $scope.subTemas.map(function(item) {
		        return item.subtema;
		    });
		
		    var data = $scope.subTemas.map(function(item) {
		        return item.cantidadTotal;
		    });
		    
		    function generateRandomColor() {
		        var letters = '0123456789ABCDEF';
		        var color = '#';
		        for (var i = 0; i < 6; i++) {
		            color += letters[Math.floor(Math.random() * 16)];
		        }
		        return color;
		    }
		    
		    var backgroundColors = $scope.subTemas.map(function() {
		        return generateRandomColor();
		    });
		
			var chartData = {
		        labels: labels,
		        datasets: [{
		            data: data,
		            backgroundColor: backgroundColors
		        }]
		    };

		    var chartOptions = {
			        responsive: true,
			        maintainAspectRatio: false, 
			        plugins: {
			            legend: {
			                position: 'top',
			                labels: {
			                    font: {
			                        size: 14 
			                    }
			                }
			            },
			            tooltip: {
			                callbacks: {
			                    label: function(tooltipItem) {
			                        var label = tooltipItem.label || '';
			                        var value = tooltipItem.raw || 0;  // Get the corresponding value
			                        return label + ': ' + value;  // Display the label and value
			                    }
			                }
			            }
			        },
			        layout: {
			            padding: {
			                top: 10,
			                bottom: 10,
			                left: 10,
			                right: 10
			            }
			        }
			    };
			    
			    if (doughnutChartInstance) {
			        doughnutChartInstance.destroy();
			    }

			    angular.element(document).ready(function () {
			        var ctx = document.getElementById('doughnutEstaPorTema').getContext('2d');
			        doughnutChartInstance = new Chart(ctx, {
			            type: 'doughnut',
			            data: chartData,
			            options: chartOptions
			        });
			    });
			    
			
			
		}
		
		/**
		 $scope.listAsistenciaTecnicaSegunTematica=[];
		$scope.listaAsisTecnicaByTematica=[];
		$scope.buildDashboardAsistenciaTecPorTematica = function(data){
			$scope.listAsistenciaTecnicaSegunTematica = data.listReporteAsistenciaTecnicaSegunTematica; 
		 * 
		 */
		
		//ASISTENCIA TECNICA FUERA DE PLAZO
		
		$scope.onDashAsistTecnicaPlazo = function(month) {
			if (month === 0) {
				$scope.listAsistenciaDentroFueraPlazo = $scope.listAsistenciaDentroFueraPlazoGeneral;
	        } else {
	        	$scope.listAsistenciaDentroFueraPlazo = $scope.listAsistenciaDentroFueraPlazoGeneral.filter(item => item.monthYear.includes(month));
	        }
	    };
		
		$scope.listAsistenciaDentroFueraPlazo=[];
		$scope.listAsistenciaDentroFueraPlazoGeneral=[];
		$scope.listaMonthAsistenciaDentroFueraPlazo=[];
		$scope.buildTableAsistenciaDentroFueraPlazo = function(data){
			$scope.listAsistenciaDentroFueraPlazoGeneral = data.listAsistenciaDentroFueraPlazo; 
			
			$scope.listaMonthAsistenciaDentroFueraPlazo = $scope.listAsistenciaDentroFueraPlazoGeneral.filter((value, index, self) => 
    		index === self.findIndex((t) => t.monthYear === value.monthYear)
			);
			
			var lastMonth = $scope.findMonthFechaFinal();
			var lastAnio = $scope.getAnio($scope.filtro.fechaFin);
			
			$scope.filtroasistecnicaplazo.monthYearMod = lastMonth + ' '+ lastAnio;
			
			$scope.onDashAsistTecnicaPlazo(lastMonth);
			
		}
		
		
		
		
		 //DASHBOARD
		 // Define your chart data REDONDO EXAMPLE
		/* 
		    $scope.canalesV = [10, 	  20, 		30];
		    $scope.canalesL = ['Red', 'Blue', 'Yellow'];
		    $scope.coloursCanales = [
		        {
		            backgroundColor: ['#FF6384', '#36A2EB', '#FFCE56']
		        }
		    ];

		    // Define chart options
		    $scope.optionsCanalesChart = {
		        responsive: true,
		        maintainAspectRatio: false
		    };
		  */  
		    
		    
		 /////  
		    
		    
		    
		    
		    /*
		    $scope.chartData = [
		        [65, 59, 80, 81, 56, 55, 40], // Dataset 1
		        [28, 48, 40, 19, 86, 27, 90]  // Dataset 2 (if needed)
		    ];
		    
		 // Define chart labels
		    $scope.chartLabels = ['January', 'February', 'March', 'April', 'May', 'June', 'July'];

		    // Define chart options
		    $scope.chartOptions = {
		        scales: {
		            x: {
		                beginAtZero: true
		            }
		        }
		    };

		    // Define chart colors
		    $scope.chartColors = ['#FF6384', '#36A2EB'];

		    // Set up chart type
		    $scope.chartType = 'horizontalBar'; // Use 'bar' for vertical bars
		    */
		    
		    
		    /*
		 // Bar Chart
		    $scope.barChartData = [65, 59, 80, 81, 56, 55, 40];
		    $scope.barChartLabels = ['January', 'February', 'March', 'April', 'May', 'June', 'July'];
		    $scope.barChartOptions = { scales: { x: { beginAtZero: true } } };
		    $scope.barChartColors = ['#FF6384', '#36A2EB', '#FFCE56'];

		    // Line Chart
		    $scope.lineChartData = [
		        { data: [65, 59, 80, 81, 56, 55, 40], label: 'Series A' },
		        { data: [28, 48, 40, 19, 86, 27, 90], label: 'Series B' }
		    ];
		    $scope.lineChartLabels = ['January', 'February', 'March', 'April', 'May', 'June', 'July'];
		    $scope.lineChartOptions = { responsive: true };
		    
		    // Pie Chart
		    $scope.pieChartData = [300, 50, 100];
		    $scope.pieChartLabels = ['Red', 'Blue', 'Yellow'];
		    $scope.pieChartOptions = { responsive: true };

		    // Doughnut Chart
		    $scope.doughnutChartData = [300, 50, 100];
		    $scope.doughnutChartLabels = ['Red', 'Blue', 'Yellow'];
		    $scope.doughnutChartOptions = { responsive: true };
		    
		    // Radar Chart
		    $scope.radarChartData = [
		        { data: [65, 59, 90, 81, 56, 55], label: 'Series A' }
		    ];
		    $scope.radarChartLabels = ['January', 'February', 'March', 'April', 'May', 'June'];
		    $scope.radarChartOptions = { responsive: true };
		    
		    // Polar Area Chart
		    $scope.polarAreaChartData = [11, 16, 7, 25];
		    $scope.polarAreaChartLabels = ['Red', 'Green', 'Yellow', 'Blue'];
		    $scope.polarAreaChartOptions = { responsive: true };
		    
		    // Bubble Chart
		    $scope.bubbleChartData = [
		        {
		            data: [
		                { x: 10, y: 20, r: 15 },
		                { x: 15, y: 25, r: 10 }
		            ],
		            label: 'Series A'
		        }
		    ];
		    $scope.bubbleChartOptions = { responsive: true };

		    // Scatter Chart
		    $scope.scatterChartData = [
		        {
		            data: [
		                { x: 10, y: 20 },
		                { x: 15, y: 25 }
		            ],
		            label: 'Series A'
		        }
		    ];
		    $scope.scatterChartOptions = { responsive: true };
		    
		    */
		 //FIN DASHBOARD  
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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
   /* $scope.listaMsSedes=[];
$scope.loadlistaMsSedes=function(){
	$http.get(listaMsSedesUrl).then(function(res){
		$scope.listaMsSedes = res.data; 
	},
	function error(errResponse) {
		console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
	});
};*/
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

//FIN CUSCATA - 10072024