//INICIO CUSCATA - 25072024
var contexto = window.location.pathname.substring(0,window.location.pathname.indexOf('/',2));
var pglogoff = window.location.origin+contexto+'/logoff.htm';
var principalUrl = window.location.origin+contexto+'/index.htm';
var listadtCapacitacionUrl = contexto+"/rs/ctrldtCapacitacion/listadtCapacitacion";
var insertdtCapacitacionNoProgUrl = contexto+"/rs/ctrldtCapacitacion/salvardtCapacitacionNoProg";
var eliminardtCapacitacionUrl = contexto+"/rs/ctrldtCapacitacion/eliminardtCapacitacion";
var activardtCapacitacionUrl = contexto+"/rs/ctrldtCapacitacion/activardtCapacitacion";
var eliminarListadtCapacitacionUrl = contexto+"/rs/ctrldtCapacitacion/eliminarListadtCapacitacion";
var editardtCapacitacionUrl = contexto+"/rs/ctrldtCapacitacion/editardtCapacitacion/";
var listaPrtParametrosidparametroIdModalidadUrl = contexto+"/rs/ctrldtCapacitacion/listaPrtParametrosIdparametroIdModalidad";
var listaMsLocalidLocalIdLocalUrl = contexto+"/rs/ctrldtCapacitacion/listaMsLocalIdLocalIdLocal";
var listaPrtParametrosidparametroIdModoUrl = contexto+"/rs/ctrldtCapacitacion/listaPrtParametrosIdparametroIdModo";
var listaPrtParametrosidparametroIdNivelUrl = contexto+"/rs/ctrldtCapacitacion/listaPrtParametrosIdparametroIdNivel";
var listaPrtParametrosidparametroIdOrigenUrl = contexto+"/rs/ctrldtCapacitacion/listaPrtParametrosIdparametroIdOrigen";
var listaPrtParametrosidparametroIdPrestacionUrl = contexto+"/rs/ctrldtCapacitacion/listaPrtParametrosIdparametroIdPrestacion";
var listaPrtParametrosidparametroIdTipoUrl = contexto+"/rs/ctrldtCapacitacion/listaPrtParametrosIdparametroIdTipo";
var listaPrtParametrosidparametroIdFinanciaUrl = contexto+"/rs/ctrldtCapacitacion/listaPrtParametrosIdparametroIdFinancia";
var listaDtUsuarioXNombreapellidoUrl = contexto+"/rs/ctrldtAsistencia/buscarDtUsuarioXnombre/";
var listaMsUsuarios = contexto+"/rs/ctrldtVisitas/listausuarios";
var descargarUrl = contexto+"/rs/ctrldtCapacitacion/descargar/";
var valorcrearlUrl = contexto+"/rs/ctrldtCapacitacion/loadvalorcrear";// PURIBE 15042024 - INICIO -->
var buscarPorNumDocUrl = contexto+"/rs/ctrldtCapacitacion/buscarPorNumDoc/";


///URLs CARGA DE ARCHIVOS
var insertDocUrl = contexto+"/rs/ctrldtCapacitacion/insertarchivo";
///FIN URLs CARGA DE ARCHIVOS

var descargarvistaUrl = contexto+"/rs/ctrldtCapacitacion/descargarvista";

//MPINARES 14022024 - INICIO
var listaMsSedesUrl = contexto+"/rs/ctrldtCapacitacion/listamsSedes";
var listaMsTemaidTemaIdTemaUrl = contexto+"/rs/ctrldtCapacitacion/listaMsTemaIdTemaIdTema";
var listaMsSubtemaidSubtemaIdSubtemaUrl = contexto+"/rs/ctrldtCapacitacion/listaMsSubtemaIdSubtemaIdSubtema/";
var buscarCodEjecUrl = contexto+"/rs/ctrldtAsistencia/buscarcodejec/";
var listaMsInstitucionesidproveeUrl = contexto+"/rs/ctrldtAsistencia/listaMsInstitucionesIdprovee/";
var listaPrtParametrosidparametroIdPublicoUrl = contexto+"/rs/ctrldtCapacitacion/listaPrtParametrosIdparametroIdPublico";
var situacionSTDUrl = contexto+"/rs/ctrldtCapacitacion/situaciontramite/";
var listaProcedeEjecucionUrl = contexto+"/rs/ctrldtCapacitacion/listaProcedeEjecucion";
var listaPrtParametrosidparametroIdTipoEntidadUrl = contexto+"/rs/ctrldtCapacitacion/listaPrtParametrosIdparametroIdTipoEntidad";
var listaPrtParametrosidparametroIdCaracteristicaUrl = contexto+"/rs/ctrldtCapacitacion/listaPrtParametrosIdparametroIdCaracteristica";
var listaPaisesUrl = contexto+"/rs/ctrldtCapacitacion/listaPaises";
var listaCoddptosUrl = contexto+"/rs/ctrldtCapacitacion/listaCoddptos";
var listaCodprovUrl = contexto+"/rs/ctrldtCapacitacion/listaCodprov/";
var listaCoddistUrl = contexto+"/rs/ctrldtCapacitacion/listaCoddist/";
var insertdtEntidadesUrl = contexto+"/rs/ctrldtCapacitacion/salvardtEntidades";
var ubigeodefectoUrl = contexto+"/rs/ctrldtCapacitacion/ubigeodefecto";
var listamsSisAdminUrl = contexto+"/rs/ctrldtCapacitacion/listamsSisAdmin";
var prepublicardtCapaUrl = contexto+"/rs/ctrldtCapacitacion/prepublicardtCapacitacionList";
var anulardtCapacitacionListUrl = contexto+"/rs/ctrldtCapacitacion/anulardtCapacitacionList";
var validacmularCapacitacionListUrl = contexto+"/rs/ctrldtCapacitacion/validacmularCapacitacionList";
var insertdtCapacitacionAcumulaUrl = contexto+"/rs/ctrldtCapacitacion/salvardtCapacitacionAcumula";
var reactivardtCapacitacionUrl = contexto+"/rs/ctrldtCapacitacion/reactivardtCapacitacion";
var listaMStema  = contexto+"/rs/ctrldtVisitas/listamstemas/";//PURIBE
//MPINARES 14022024 - FIN

/**
 * 
 */
myapp = angular.module('MyApp');

myapp.config(function($routeProvider) {
	  $routeProvider
	  .when("/editar/:idCapacitacion", {
		  templateUrl : "capacitacion/editardtCapacitacionNoProg.html",
		  controller : "ctrlListadtCapacitacionNoProg"
	  })
	  .when("/nuevo", {
		  templateUrl : "capacitacion/editardtCapacitacionNoProg.html",
		  controller : "ctrlListadtCapacitacionNoProg"
	  })
	  .otherwise({
		  templateUrl : "capacitacion/verdtCapacitacionNoProg.html",
		  controller : "ctrlListadtCapacitacionNoProg"  
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


myapp.controller('ctrlListadtCapacitacionNoProg', ['$mdEditDialog', '$scope', '$timeout', '$http', '$mdDialog','$location','$routeParams', '$mdPanel',  'fileUploadServ',
											function ($mdEditDialog, $scope, $timeout, $http, $mdDialog, $location, $routeParams, $mdPanel, fileUploadSrv) {
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
	  $scope.loaddtCapacitacions();
	 };
	 $scope.refrescar= 0;//puribe
	 $scope.logItem = function (item) {
	  console.log(item.name, 'was selected');
	 };
	 
	 $scope.logPagination = function (page, limit) {
	  console.log('page: ', page);
	  console.log('limit: ', limit);
	  $scope.loaddtCapacitacions();
         };
     $scope.creadtCapacitacion = false;
     $scope.prepublicarCapa = false;
     $scope.acumularCapa = false;
    // ///////////////////////////////////////////
	$scope.datos = [];
	$scope.total = 0;
	$scope.currentserverdate = null;
	
	$scope.archivos = [];
	
	$scope.getCurrentserverdate = function(){           
        var surl = currentserverdateUrl;
        $http.get(surl).then(function(res){
              var dato = res.data;
              $scope.currentserverdate = new Date(dato);
              $scope.filtro.fechaInicio=$scope.firstDate(new Date(dato));
              $scope.filtro.fechaFin= $scope.getLastDayOfMonth(new Date(dato));
              $scope.loaddtCapacitacions();
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
	
	$scope.example = {
	        value: new Date(2010, 11, 28, 14, 57)
	      };
	
	//PURIBE 15042024  INICIO-->

	$scope.valorcrear;
	$scope.loadvalorcrear=function(){
		$http.get(valorcrearlUrl).then(function(res){
			$scope.valorcrear = res.data; 

			if ($scope.valorcrear.id==2)
			{
			$scope.creadtCapacitacion = true;
			}
			else
			{
				$scope.creadtCapacitacion =false; 
			}
		},
		function error(errResponse) {
			console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		});
	};
	$scope.loadvalorcrear();
	//PURIBE 15042024  FIN-->

	$scope.loaddtCapacitacions = function () {
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
		
		
		
		
		/*
		$scope.listamstemas=[];
		$scope.loadlistamstema=function(idSistAdm){
			var sUrl = listaMStema  + idSistAdm;

			 return $http.get(sUrl).then(function(res){
				$scope.listamstemas = res.data; 
				
				console.log("$scope.listamstemas:" + JSON.stringify($scope.listamstemas));
				
				$scope.determinateValue = 100;
				return res;
			})
			.catch(function(errResponse) {
			
				console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
				throw errResponse; 
			 });
		};*/
		
	    //$scope.promise = $timeout(function () {
	    	var surl = $scope.getURL();	    
	    	$scope.promise = $http.get(surl).then(function(res){
	    		 $scope.datos = res.data.data;
	    		 if($scope.datos.length>0){
		    		 if(res.data.contador>0)
			    		 $scope.total = res.data.contador;
			    		 var tiempoenBD = res.data.tiempoenBD;
			    		 var tiempoenproceso = res.data.tiempoenproceso;
//			    		 $scope.creadtCapacitacion = res.data.creamodifica; // PURIBE 15042024 - INICIO -->
			    		 $scope.prepublicarCapa = res.data.prepublicar;
			    		 $scope.acumularCapa = res.data.acumular;
			    		 console.log("data " +$scope.datos.length+" DE "+ $scope.total);
			    		 console.log("Tiempo respuesta BD dtCapacitacion " +tiempoenBD+" Tiempo en Paginar "+tiempoenproceso);
			    		 $scope.refrescar=0; //puribe
	    		 }else{
//	    			 $mdDialog.show(
//								$mdDialog.alert()
//								.parent(angular.element(document.body))
//								.clickOutsideToClose(true)
//								.title('Buscar capacitaciones')
//								.textContent("No se encontraron resultados para la búsqueda")
//								.ariaLabel('Lucky day')
//								.ok('ACEPTAR')
//						);
//						return;
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
			if(typeof(dato) != 'undefined'){
		            	$mdDialog.show(
						         $mdDialog.alert()
						        .parent(angular.element(document.body))
						        .clickOutsideToClose(true)
						        .title('Lista de capacitaciones')
						        .textContent(dato)
						        .ariaLabel('ERROR')
						        .ok('ACEPTAR')
						    );
		            }
		        });			 
	     //}, 500);
	    	$scope.loadlistaMsSedes();// SELECT
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
				}
				else if($scope.refrescar == 0)
				{
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
		  return listadtCapacitacionUrl+$scope.getURLParametros();
	  }
	  
	  $scope.editdtCapacitacion = function () {
		    $scope.nuevo = true;
		    var idCapacitacion = $routeParams.idCapacitacion;
		    if(idCapacitacion){
		    	$scope.cargardtCapacitacion(idCapacitacion);
		    }
		  //MPINARES 14022024 - INICIO
			   ///CARGAR COMPLEMENTOS 
	                $scope.loadListaMsLocalIdLocal();//SELECT
	                $scope.loadListaPrtParametrosIdModo();//SELECT
	                $scope.loadListaPrtParametrosIdNivel();//SELECT
//	                $scope.loadListaPrtParametrosIdOrigen();//SELECT
	                $scope.loadListaPrtParametrosIdPrestacion();//SELECT
	                $scope.loadListaPrtParametrosIdTipo();//SELECT
	                $scope.loadListaPrtParametrosIdFinancia();//SELECT
	                $scope.loadListaPrtParametrosIdModalidad();//SELECT
	                $scope.loadListaPrtParametrosIdPublico();//SELECT
	                $scope.loadListaProcedeEjecucion();//SELECT
	                $scope.loadListaPrtParametrosIdOrigen();//SELECT
			   // $scope.loadListaMsTemaIdTema();
			    $scope.loadlistamstema();
			    $scope.loadlistamsusuarios();
			    $scope.rangeYearIni();
			  //MPINARES 14022024 - FIN
		  };
	  
		//MPINARES 14022024 - INICIO 
		  
		  $scope.rangeYear=[];
			$scope.rangeYearIni=function(){
				if($scope.isArray($scope.rangeYear) && $scope.rangeYear.length<=0){
					var max = new Date().getFullYear();
				    var min = 2011;
				    for (var i = max; i >= min; i--) {
				      $scope.rangeYear.push(i)
				  }}
				};	
				
		  $scope.firstDate = function(dia){
			  dia.setDate(1);
			  dia.setMonth(dia.getMonth() + 1);
			  dia.setHours(0, 0, 0);
			  dia.setMilliseconds(0);
			  return dia; 
		  }
		  
		  $scope.getLastDayOfMonth = function(dia){
			  const year = dia.getFullYear();
			  const month = dia.getMonth() + 2; 
			  dia = new Date(year, month, 0);
			  dia.setHours(0, 0, 0);
			  dia.setMilliseconds(0);
			  return dia; 
		  }
		  
		  $scope.filtro ={
				  fechaInicio:$scope.firstDate(new Date()),
				  fechaFin: $scope.getLastDayOfMonth(new Date()),
				  idSedeTxt: null,
				  entidadesTxt: null,
				  idProgramacion: 121
			}; 
		  

		  $scope.formatDMYHM = function(dia){     
			    if(typeof(dia)=='undefined' || dia==null)
			    	return "";
		        var d = new Date(dia);
		        var dformat = [ d.getFullYear(),
		        	("00" + (d.getMonth() + 1)).slice(-2),
		        	("00" + d.getDate()).slice(-2)				        	
		                    ].join('/');
		        var dHour = [ ("00" + d.getHours()).slice(-2),
		        	("00" + d.getMinutes()).slice(-2)				        	
		                    ].join(':');				        
		     return dformat+" "+dHour;
		  };
		  
		//*************************************ACUMULAR************************************************
		  $scope.dtCapacitacionAcumulaModelo = {
					idCapacitacion : null,
					fechaInic: null,
					fechaFin: null,
					cantPartic: null,
					publicObj: null,
					nomEvento: null,
					detalleCapa: null,
					idLocal: null,
					idUsuinterno: null,
					idModo: null,
					idNivel: null,
					idOrigen: 127,
					idPrestacion: null,
					idProgramacion: 121,
					cantParticAsist: null,
					idTipo: null,
					idcapaPadre: null,
					idSede: null,
					idSistAdm: null,
					idFinancia: null,
					fechaFinalizacion: null,
					flagPubli: null,
					idModalidad: null,
					detalleCapaVirtual: null,
					fechaIniProgramada: null,
					fechaFinProgramada: null,
					fechaSoli: null,
					stdIddoc: null,
					stdNumeroSid: null,
					stdNumeroAnio: null,
					stdNumeroDoc: null,
					stdAsunto: null,
					stdTipoDoc: null,
					stdFechaRecepcion: null,
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
					dtCapaTemasBkJSss: [],
					dtCapaEntidadesBkJSss: [],
					dtCapaPublicoBkJSss: [],
				    editopcion: 1
				};
		  
		  $scope.setDtCapacitacionAcumulaModelo = function(dtCapacitacionBk) {
			    
			    $scope.dtCapacitacionAcumulaModelo.fechaInic = dtCapacitacionBk.fechaInic;
	          if(!$scope.isNull($scope.dtCapacitacionAcumulaModelo.fechaInic) && !isNaN($scope.dtCapacitacionAcumulaModelo.fechaInic)){
				    $scope.dtCapacitacionAcumulaModelo.fechaInic = new Date($scope.dtCapacitacionAcumulaModelo.fechaInic);
			        }
			    $scope.dtCapacitacionAcumulaModelo.fechaFin = dtCapacitacionBk.fechaFin;
	          if(!$scope.isNull($scope.dtCapacitacionAcumulaModelo.fechaFin) && !isNaN($scope.dtCapacitacionAcumulaModelo.fechaFin)){
				    $scope.dtCapacitacionAcumulaModelo.fechaFin = new Date($scope.dtCapacitacionAcumulaModelo.fechaFin);
			        }
				$scope.dtCapacitacionAcumulaModelo.cantPartic = dtCapacitacionBk.cantPartic;
//				$scope.dtCapacitacionAcumulaModelo.publicObj = dtCapacitacionBk.publicObj;
				$scope.dtCapacitacionAcumulaModelo.nomEvento = dtCapacitacionBk.nomEvento;
//				$scope.dtCapacitacionAcumulaModelo.detalleCapa = dtCapacitacionBk.detalleCapa;
				$scope.dtCapacitacionAcumulaModelo.idLocal = dtCapacitacionBk.idLocal;
//				$scope.dtCapacitacionAcumulaModelo.idUsuinterno = dtCapacitacionBk.idUsuinterno;
				$scope.dtCapacitacionAcumulaModelo.idModo = dtCapacitacionBk.idModo;
				$scope.dtCapacitacionAcumulaModelo.idNivel = dtCapacitacionBk.idNivel;
				$scope.dtCapacitacionAcumulaModelo.idOrigen = dtCapacitacionBk.idOrigen;
				$scope.dtCapacitacionAcumulaModelo.idPrestacion = dtCapacitacionBk.idPrestacion;
				$scope.dtCapacitacionAcumulaModelo.idProgramacion = dtCapacitacionBk.idProgramacion;
				$scope.dtCapacitacionAcumulaModelo.cantParticAsist = dtCapacitacionBk.cantParticAsist;
				$scope.dtCapacitacionAcumulaModelo.idTipo = dtCapacitacionBk.idTipo;
				$scope.dtCapacitacionAcumulaModelo.idcapaPadre = dtCapacitacionBk.idcapaPadre;
//				$scope.dtCapacitacionAcumulaModelo.idSede = dtCapacitacionBk.idSede;
//				$scope.dtCapacitacionAcumulaModelo.idSistAdm = dtCapacitacionBk.idSistAdm;
				$scope.dtCapacitacionAcumulaModelo.idFinancia = dtCapacitacionBk.idFinancia;
				$scope.dtCapacitacionAcumulaModelo.fechaFinalizacion = dtCapacitacionBk.fechaFinalizacion;
	          if(!$scope.isNull($scope.dtCapacitacionAcumulaModelo.fechaFinalizacion) && !isNaN($scope.dtCapacitacionAcumulaModelo.fechaFinalizacion)){
				    $scope.dtCapacitacionAcumulaModelo.fechaFinalizacion = new Date($scope.dtCapacitacionAcumulaModelo.fechaFinalizacion);
			        }
//				$scope.dtCapacitacionAcumulaModelo.flagPubli = dtCapacitacionBk.flagPubli;
				$scope.dtCapacitacionAcumulaModelo.idModalidad = dtCapacitacionBk.idModalidad;
//				$scope.dtCapacitacionAcumulaModelo.detalleCapaVirtual = dtCapacitacionBk.detalleCapaVirtual;
//				$scope.dtCapacitacionAcumulaModelo.fechaIniProgramada = dtCapacitacionBk.fechaIniProgramada;
//	          if(!$scope.isNull($scope.dtCapacitacionAcumulaModelo.fechaIniProgramada) && !isNaN($scope.dtCapacitacionAcumulaModelo.fechaIniProgramada)){
//				    $scope.dtCapacitacionAcumulaModelo.fechaIniProgramada = new Date($scope.dtCapacitacionAcumulaModelo.fechaIniProgramada);
//			        }
//				$scope.dtCapacitacionAcumulaModelo.fechaFinProgramada = dtCapacitacionBk.fechaFinProgramada;
//	          if(!$scope.isNull($scope.dtCapacitacionAcumulaModelo.fechaFinProgramada) && !isNaN($scope.dtCapacitacionAcumulaModelo.fechaFinProgramada)){
//					$scope.dtCapacitacionAcumulaModelo.fechaFinProgramada = new Date($scope.dtCapacitacionAcumulaModelo.fechaFinProgramada);
//			        }
				$scope.dtCapacitacionAcumulaModelo.fechaSoli = dtCapacitacionBk.fechaSoli;
	                  if(!$scope.isNull($scope.dtCapacitacionAcumulaModelo.fechaSoli) && !isNaN($scope.dtCapacitacionAcumulaModelo.fechaSoli)){
			    $scope.dtCapacitacionAcumulaModelo.fechaSoli = new Date($scope.dtCapacitacionAcumulaModelo.fechaSoli);
		        }     
	           $scope.dtCapacitacionAcumulaModelo.fechaSoliJUD = dtCapacitacionBk.fechaSoliJUD;
	                  if(!$scope.isNull($scope.dtCapacitacionAcumulaModelo.fechaSoliJUD) && !isNaN($scope.dtCapacitacionAcumulaModelo.fechaSoliJUD)){
			    $scope.dtCapacitacionAcumulaModelo.fechaSoliJUD = new Date($scope.dtCapacitacionAcumulaModelo.fechaSoliJUD);
		        }
	                  $scope.dtCapacitacionAcumulaModelo.fechaInicJUD = dtCapacitacionBk.fechaInicJUD;
	                  if(!$scope.isNull($scope.dtCapacitacionAcumulaModelo.fechaInicJUD) && !isNaN($scope.dtCapacitacionAcumulaModelo.fechaInicJUD)){
			    $scope.dtCapacitacionAcumulaModelo.fechaInicJUD = new Date($scope.dtCapacitacionAcumulaModelo.fechaInicJUD);
		        }
	                  $scope.dtCapacitacionAcumulaModelo.fechaFinJUD = dtCapacitacionBk.fechaFinJUD;
	                  if(!$scope.isNull($scope.dtCapacitacionAcumulaModelo.fechaFinJUD) && !isNaN($scope.dtCapacitacionAcumulaModelo.fechaFinJUD)){
			    $scope.dtCapacitacionAcumulaModelo.fechaFinJUD = new Date($scope.dtCapacitacionAcumulaModelo.fechaFinJUD);
		        }     
	                      
//				$scope.dtCapacitacionAcumulaModelo.stdIddoc = dtCapacitacionBk.stdIddoc;
//				$scope.dtCapacitacionAcumulaModelo.stdNumeroSid = dtCapacitacionBk.stdNumeroSid;
//				$scope.dtCapacitacionAcumulaModelo.stdNumeroAnio = dtCapacitacionBk.stdNumeroAnio;
//				$scope.dtCapacitacionAcumulaModelo.stdNumeroDoc = dtCapacitacionBk.stdNumeroDoc;
//				$scope.dtCapacitacionAcumulaModelo.stdAsunto = dtCapacitacionBk.stdAsunto;
//				$scope.dtCapacitacionAcumulaModelo.stdTipoDoc = dtCapacitacionBk.stdTipoDoc;
//				$scope.dtCapacitacionAcumulaModelo.stdFechaRecepcion = dtCapacitacionBk.stdFechaRecepcion;
//	          if(!$scope.isNull($scope.dtCapacitacionAcumulaModelo.stdFechaRecepcion) && !isNaN($scope.dtCapacitacionAcumulaModelo.stdFechaRecepcion)){
//				    $scope.dtCapacitacionAcumulaModelo.stdFechaRecepcion = new Date($scope.dtCapacitacionAcumulaModelo.stdFechaRecepcion);
//			        }
//				$scope.dtCapacitacionAcumulaModelo.stdModalidadIng = dtCapacitacionBk.stdModalidadIng;
//				$scope.dtCapacitacionAcumulaModelo.flagEjec = dtCapacitacionBk.flagEjec;
//				$scope.dtCapacitacionAcumulaModelo.motivoEjec = dtCapacitacionBk.motivoEjec;
				
	                      // ADICIONALES
//		        $scope.dtCapacitacionAcumulaModelo.idLocalTxt = dtCapacitacionBk.idLocalTxt;
//				$scope.dtCapacitacionAcumulaModelo.idUsuinternoTxt = dtCapacitacionBk.idUsuinternoTxt;
//				$scope.dtCapacitacionAcumulaModelo.estadoTxt = dtCapacitacionBk.estadoTxt;
//				$scope.dtCapacitacionAcumulaModelo.idModoTxt = dtCapacitacionBk.idModoTxt;
//				$scope.dtCapacitacionAcumulaModelo.idNivelTxt = dtCapacitacionBk.idNivelTxt;
//				$scope.dtCapacitacionAcumulaModelo.idOrigenTxt = dtCapacitacionBk.idOrigenTxt;
//				$scope.dtCapacitacionAcumulaModelo.idPrestacionTxt = dtCapacitacionBk.idPrestacionTxt;
//				$scope.dtCapacitacionAcumulaModelo.idProgramacionTxt = dtCapacitacionBk.idProgramacionTxt;
//				$scope.dtCapacitacionAcumulaModelo.idTipoTxt = dtCapacitacionBk.idTipoTxt;
//				$scope.dtCapacitacionAcumulaModelo.idSedeTxt = dtCapacitacionBk.idSedeTxt;
//				$scope.dtCapacitacionAcumulaModelo.idSistAdmTxt = dtCapacitacionBk.idSistAdmTxt;
//				$scope.dtCapacitacionAcumulaModelo.idFinanciaTxt = dtCapacitacionBk.idFinanciaTxt;
//				$scope.dtCapacitacionAcumulaModelo.idModalidadTxt = dtCapacitacionBk.idModalidadTxt;

				$scope.dtCapacitacionAcumulaModelo.dtCapaTemasBkJSss = dtCapacitacionBk.dtCapaTemasBkJSss;
				if(dtCapacitacionBk.dtCapaTemasBkJSss!=null && dtCapacitacionBk.dtCapaTemasBkJSss.length>0){
					$scope.datoCapasTema = $scope.dtCapacitacionAcumulaModelo.dtCapaTemasBkJSss;
				}
				$scope.dtCapacitacionAcumulaModelo.dtCapaEntidadesBkJSss = dtCapacitacionBk.dtCapaEntidadesBkJSss;
				if(dtCapacitacionBk.dtCapaEntidadesBkJSss!=null && dtCapacitacionBk.dtCapaEntidadesBkJSss.length>0){
					$scope.datoCapaEntidades = $scope.dtCapacitacionAcumulaModelo.dtCapaEntidadesBkJSss;
				}
				$scope.dtCapacitacionAcumulaModelo.dtCapaPublicoBkJSss = dtCapacitacionBk.dtCapaPublicoBkJSss;
				if(dtCapacitacionBk.dtCapaPublicoBkJSss!=null && dtCapacitacionBk.dtCapaPublicoBkJSss.length>0){
					$scope.datoCapaPublico = [];
					for(var i = 0; i < dtCapacitacionBk.dtCapaPublicoBkJSss.length; i++)
					{
						var capaPublico = dtCapacitacionBk.dtCapaPublicoBkJSss[i];
						$scope.addCapaPublico(capaPublico, i, dtCapacitacionBk.dtCapaPublicoBkJSss.length);
					}
				}
//				$scope.dtCapacitacionAcumulaModelo.editopcion = dtCapacitacionBk.dtCapacitacionACL.editopcion;
			}
		  
		  $scope.cleardtCapacitacionAcumula = function(){
			    $scope.dtCapacitacionAcumulaModelo.idCapacitacion = null;
			    $scope.dtCapacitacionAcumulaModelo.fechaInic = null;
			    $scope.dtCapacitacionAcumulaModelo.fechaFin = null;
			    $scope.dtCapacitacionAcumulaModelo.cantPartic = null;
			    $scope.dtCapacitacionAcumulaModelo.publicObj = null;
			    $scope.dtCapacitacionAcumulaModelo.nomEvento = null;
			    $scope.dtCapacitacionAcumulaModelo.detalleCapa = null;
			    $scope.dtCapacitacionAcumulaModelo.idLocal = null;
			    $scope.dtCapacitacionAcumulaModelo.idUsuinterno = null;
			    $scope.dtCapacitacionAcumulaModelo.idModo = null;
			    $scope.dtCapacitacionAcumulaModelo.idNivel = null;
			    $scope.dtCapacitacionAcumulaModelo.idOrigen = 127;
			    $scope.dtCapacitacionAcumulaModelo.idPrestacion = null;
			    $scope.dtCapacitacionAcumulaModelo.idProgramacion = 121;
			    $scope.dtCapacitacionAcumulaModelo.cantParticAsist = null;
			    $scope.dtCapacitacionAcumulaModelo.idTipo = null;
			    $scope.dtCapacitacionAcumulaModelo.idcapaPadre = null;
			    $scope.dtCapacitacionAcumulaModelo.idSede = null;
			    $scope.dtCapacitacionAcumulaModelo.idSistAdm = null;
			    $scope.dtCapacitacionAcumulaModelo.idFinancia = null;
			    $scope.dtCapacitacionAcumulaModelo.fechaFinalizacion = null;
			    $scope.dtCapacitacionAcumulaModelo.flagPubli = null;
			    $scope.dtCapacitacionAcumulaModelo.idModalidad = null;
			    $scope.dtCapacitacionAcumulaModelo.detalleCapaVirtual = null;
			    $scope.dtCapacitacionAcumulaModelo.fechaIniProgramada = null;
			    $scope.dtCapacitacionAcumulaModelo.fechaFinProgramada = null;
			    $scope.dtCapacitacionAcumulaModelo.fechaSoli = null;
			    $scope.dtCapacitacionAcumulaModelo.stdIddoc = null;
			    $scope.dtCapacitacionAcumulaModelo.stdNumeroSid = null;
			    $scope.dtCapacitacionAcumulaModelo.stdNumeroAnio = null;
			    $scope.dtCapacitacionAcumulaModelo.stdNumeroDoc = null;
			    $scope.dtCapacitacionAcumulaModelo.stdAsunto = null;
			    $scope.dtCapacitacionAcumulaModelo.stdTipoDoc = null;
			    $scope.dtCapacitacionAcumulaModelo.stdFechaRecepcion = null;
			    $scope.dtCapacitacionAcumulaModelo.stdModalidadIng = null;
			    $scope.dtCapacitacionAcumulaModelo.flagEjec = null;
			    $scope.dtCapacitacionAcumulaModelo.motivoEjec = null;
			    
	                // ADICIONALES
		        $scope.dtCapacitacionAcumulaModelo.idLocalTxt = null;
				$scope.dtCapacitacionAcumulaModelo.idUsuinternoTxt = null;
				$scope.dtCapacitacionAcumulaModelo.estadoTxt = null;
				$scope.dtCapacitacionAcumulaModelo.idModoTxt = null;
				$scope.dtCapacitacionAcumulaModelo.idNivelTxt = null;
				$scope.dtCapacitacionAcumulaModelo.idOrigenTxt = null;
				$scope.dtCapacitacionAcumulaModelo.idPrestacionTxt = null;
				$scope.dtCapacitacionAcumulaModelo.idProgramacionTxt = null;
				$scope.dtCapacitacionAcumulaModelo.idTipoTxt = null;
				$scope.dtCapacitacionAcumulaModelo.idSedeTxt = null;
				$scope.dtCapacitacionAcumulaModelo.idSistAdmTxt = null;
				$scope.dtCapacitacionAcumulaModelo.idFinanciaTxt = null;
				$scope.dtCapacitacionAcumulaModelo.idModalidadTxt = null;
				$scope.dtCapacitacionAcumulaModelo.dtCapaTemasBkJSss= [];
				$scope.dtCapacitacionAcumulaModelo.dtCapaEntidadesBkJSss= [];
				$scope.dtCapacitacionAcumulaModelo.dtCapaPublicoBkJSss= [];
			    $scope.dtCapacitacionAcumulaModelo.editopcion = 1;
		 }
		  
		  $scope.showConfirmAcumularCapacitacion = function(ev) {
			  if($scope.selectedCapaci.length<2){
					$mdDialog.show(
							$mdDialog.alert()
							.parent(angular.element(document.body))
							.clickOutsideToClose(true)
							.title('Acumular capacitación')
							.textContent("Debe seleccionar al menos dos registros para acumular")
							.ariaLabel('Lucky day')
							.ok('ACEPTAR')
							.targetEvent(ev)
					);
				}else{
					var confirm = $mdDialog.confirm()
	                .title('Acumular capacitación')
	                .textContent('¿Está usted seguro de acumular los registros?')
	                .ariaLabel('Lucky day')
	                .targetEvent(ev)
	                .ok('Si')
	                .cancel('No');

	              $mdDialog.show(confirm).then(function () {
	                $scope.status = 'SI';
	                //VALIDAR LAS CAPAS A ACUMULARSE
	                $scope.validacumularCapacitacionList(ev, $scope.selectedCapaci);
	              }, function () {
	                $scope.status = 'NO';
	              });
				}
	        };
	        
	        $scope.validacumularCapacitacionList = function(ev, selectedCapaci){		
			    ev.target.disabled = true;
			    var datainsert = angular.toJson(selectedCapaci);
				console.log("datainsert = "+datainsert);
			$http.post(validacmularCapacitacionListUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
					var dato1 = res.data;
					$scope.cleardtCapacitacionAcumula();
					$scope.setDtCapacitacionAcumulaModelo(dato1);
					 $scope.acumularCapas(ev, selectedCapaci);
//					var instrumentos = $scope.datos;
//			        var index = $scope.datos.findIndex(obj => obj.idAsistTema === dato.idAsistTema);
//					console.log("INDEX " + index);
//			        if(instrumentos.length>index){
//			        	instrumentos.splice(index, 1);
//				        $scope.datos = instrumentos;
//				        $scope.total = $scope.datos.length;
//			        }	
				},
				function error(errResponse) {
		            console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		            var dato = errResponse.data;
		            if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
		            	$mdDialog.show(
				         $mdDialog.alert()
				        .parent(angular.element(document.body))
				        .clickOutsideToClose(true)
				        .title('Acumular capacitación')
				        .textContent(dato.message)
				        .ariaLabel('ERROR')
				        .ok('ACEPTAR')
				        .targetEvent(ev)
					   );
		            }
		        });			        			        	
	      	ev.target.disabled = false;
		 };
		  
		  $scope.acumularCapas = function(ev, selectedCapaci) {
//	        $scope.acumularCapas = function(ev) {
				ev.target.disabled = true;
				$scope.loadListaMsLocalIdLocal();
				$scope.loadListaPrtParametrosIdModalidad();
				$scope.loadListaPrtParametrosIdNivel();
				$scope.loadListaPrtParametrosIdPrestacion();
				$scope.loadListaPrtParametrosIdTipo();
				$scope.loadListaPrtParametrosIdFinancia();
//				$scope.cleardtCapacitacionAcumula();		
				$mdDialog.show({
					templateUrl: contexto+"/dialogos/acumularCapas.html",
					scope: $scope,
					preserveScope: true,
					//controller: mdDialogInstitucionCtrl,                	
					parent: angular.element(document.body),
					targetEvent: ev,
					clickOutsideToClose: true
				}).then($scope.closeDialog, $scope.cancelDialod);	
				ev.target.disabled = false;
			};
		  
		  //*************************************************************************************
		  $scope.addCapaEntidad = function(ev) {
				ev.target.disabled = true;
				$scope.clearCapaEntidadmodelo();		
				$mdDialog.show({
					templateUrl: contexto+"/dialogos/editarCapaEntidades.html",
					scope: $scope,
					preserveScope: true,
					//controller: mdDialogInstitucionCtrl,                	
					parent: angular.element(document.body),
					targetEvent: ev,
					clickOutsideToClose: true
				}).then($scope.closeDialog, $scope.cancelDialod);	
				ev.target.disabled = false;
			};
			
			$scope.generateRandomInteger = function(max) {
			    return Math.floor(Math.random() * max) + 1;
			}
			
			
			$scope.capaEntidadmodelo = {
					idCapaEnti: null,
					idCapacitacion: null,
					idEntidad: null, 
					idEntidadTxt: null,
					codEjecutora: null
				};
				
				$scope.setCapaEntidadmodelo = function(capaEntidadm){
					$scope.capaEntidadmodelo.idCapaEnti= capaEntidadm.idCapaEnti;
					$scope.capaEntidadmodelo.idCapacitacion= capaEntidadm.idCapacitacion;
					$scope.capaEntidadmodelo.idEntidad= capaEntidadm.idEntidad;
					$scope.capaEntidadmodelo.idEntidadTxt= capaEntidadm.idEntidadTxt;
					$scope.capaEntidadmodelo.codEjecutora= capaEntidadm.codEjecutora;
				};
				
				$scope.clearCapaEntidadmodelo= function(){
					$scope.capaEntidadmodelo.idCapaEnti= null;
					$scope.capaEntidadmodelo.idCapacitacion= null;
					$scope.capaEntidadmodelo.idEntidad= null;
					$scope.capaEntidadmodelo.idEntidadTxt= null;
					$scope.capaEntidadmodelo.codEjecutora= null;
				};
				
				$scope.nuevoCapaEntidadmodelo = function (ev) {
					ev.target.disabled = true;
					
					if (!$scope.dtCapacitacionForm2.$valid) {
						// PURIBE 15042024 - INICIO -->
						$mdDialog.show(
							$mdDialog.alert()
							.parent(angular.element(document.body))
							.clickOutsideToClose(true)
							.title('Guardar capacitación')
							.textContent("El diálogo no cumple con los campos obligatorios...")
							.ariaLabel('Lucky day')
							.ok('ACEPTAR')
					);
						ev.target.disabled = false;
						return;
					
				// PURIBE 15042024 - FIN-->	
				}
					
			        var datoactual = Object.assign({}, $scope.capaEntidadmodelo);		
					if($scope.isNull(datoactual.idCapaEnti) || $scope.isUndefined(datoactual.idCapaEnti)){
						datoactual.idCapaEnti = $scope.generateRandomInteger(1000)*-1;
					}
					if($scope.isArray($scope.datoCapaEntidades)){
						var objEncontrado = $scope.datoCapaEntidades.find(o => o.idCapaEnti === datoactual.idCapaEnti);
						if($scope.isObject(objEncontrado)){
							Object.assign(objEncontrado, datoactual);
							$scope.cancel();
							ev.target.disabled = false;
							return;
						}
					}	
					$scope.datoCapaEntidades.push(datoactual);	
					$scope.cancel();
					ev.target.disabled = false;
				};
				
			// DIALOG PARTICIPANTE
				
				$scope.hideParticipante = function () {
					
					
					if ($scope.datoCapasTema.some(e => e.idSubtema === $scope.capacitacionTemasmodelo.idSubtema)) {
						 
						$mdDialog.show(
								$mdDialog.alert()
								.parent(angular.element(document.body))
								.clickOutsideToClose(true)
								.title('Agregar Tema')
								.textContent("El subtema seleccionado ya existe")
								.ariaLabel('Lucky day')
								.ok('OK')
						);
						ev.target.disabled = false;
						return;
						}
					
					
					$mdDialog.hide($scope.capacitacionTemasmodelo);

					var datoactual = Object.assign({}, $scope.capacitacionTemasmodelo);
					
					//datoactual.idUsuinterno = 
					
					
					if($scope.isNull(datoactual.idCapaTemAgen) || $scope.isUndefined(datoactual.idCapaTemAgen)){
						datoactual.idCapaTemAgen = $scope.generateRandomInteger(1000)*-1;
					}
					
					$scope.datoCapasTema.push(datoactual);	
					$scope.cancel();
				};
				
			    
			    $scope.listainternoMsusuarios=[];
				
				$scope.loadlistamsusuarios=function(){
					$http.get(listaMsUsuarios).then(function(res){
						$scope.listainternoMsusuarios = res.data; 
						
						console.log($scope.listainternoMsusuarios);
						console.log("loadlistamsusuarios:" + JSON.stringify($scope.listainternoMsusuarios));
						
					},
					function error(errResponse) {
						console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
					});
				};
				
				$scope.listamstemas=[];
				$scope.loadlistamstema=function(idusuario){
					
					if(idusuario!=null && idusuario!=0){
						console.log("idusuario:" + idusuario);
						
						var usuario = $scope.listainternoMsusuarios.find(c=>c.idusuario === idusuario);
						
						var idSistAdm=  usuario.idSistAdmi;
						
						$scope.capacitacionTemasmodelo.idSistAdmiTxt = usuario.idSistAdmiTxt;
						$scope.capacitacionTemasmodelo.idUsuinternoTxt = usuario.idUsuinternoTxt;
						$scope.capacitacionTemasmodelo.idUsuinterno = usuario.idusuario;
						
						var sUrl = listaMStema  + idSistAdm;

						 return $http.get(sUrl).then(function(res){
							$scope.listamstemas = res.data; 
							
							console.log("$scope.listamstemas: " + JSON.stringify($scope.listamstemas) );
							
							$scope.determinateValue = 100;
							return res;
						})
						.catch(function(errResponse) {
						
							console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
							throw errResponse; 
						 });
					}
					
				};
				
				$scope.changeIdTema=function(idTema){
					console.log("idTema:" + idTema);
					
		        	$scope.loadListaMsSubtemaIdSubtema(idTema);
		        	
		        	var temaFound = $scope.listamstemas.find(c => c.idTema === idTema );
		        	
		        	$scope.capacitacionTemasmodelo.idTema = idTema;
		        	$scope.capacitacionTemasmodelo.idTemaTxt=temaFound.descripcion;
			    }
				
				$scope.listaMsSubtemaIdSubtema=[];
				 
				$scope.loadListaMsSubtemaIdSubtema=function(idTema){
					
					console.log("sub tema idTema to find: " + idTema);
					
					$scope.listaMsSubtemaIdSubtema=[];
					
					if(!$scope.isNumber(idTema))
						return;
					
					var surl = listaMsSubtemaidSubtemaIdSubtemaUrl+idTema;
					$http.get(surl).then(function(res){
						$scope.listaMsSubtemaIdSubtema = res.data; 
						
						console.log("$scope.listaMsSubtemaIdSubtema: " + JSON.stringify($scope.listaMsSubtemaIdSubtema) );
						
					},
					function error(errResponse) {
						console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
					});
				};
				
				$scope.changeIdSubtema=function(idSubtema){
					console.log("idSubtema:"+idSubtema);
					
					var subTemaFound = $scope.listaMsSubtemaIdSubtema.find(c => c.id === idSubtema );
					$scope.capacitacionTemasmodelo.idSubtemaTxt=subTemaFound.valor;
					
					$scope.activar = 1;
				}
				
				$scope.activar = 0;
				
				$scope.capacitacionTemasmodelo = {
						idCapaTemAgen: null,
			    		idUsuinterno: null,
			    		idUsuinternoTxt: null,
						idTema: null,
						idTemaTxt: null,
						idSistAdmiTxt:null,
						idSubtema: null,
						idSubtemaTxt: null,
					};
				
				 $scope.clearcapacitacionTemasmodelo= function(){
						$scope.capacitacionTemasmodelo.idUsuinterno= null;
						$scope.capacitacionTemasmodelo.idTema= null;
						$scope.capacitacionTemasmodelo.idTemaTxt= null;
						$scope.capacitacionTemasmodelo.idSistAdmiTxt= null;
						$scope.capacitacionTemasmodelo.idSubtema= null;
						$scope.capacitacionTemasmodelo.idSubtemaTxt= null;
						$scope.listamstemas=[];
						$scope.listaMsSubtemaIdSubtema=[];
					};
				
				//*************************************************************************************
				$scope.showCapaTemas = function(ev) {
					ev.target.disabled = true;
					
					$scope.loadlistamsusuarios();
					$scope.clearcapacitacionTemasmodelo();
					
					$mdDialog.show({
						templateUrl: contexto+"/dialogos/editarCapaTemasNoProg.html",
						scope: $scope,
						preserveScope: true,
						//controller: mdDialogInstitucionCtrl,                	
						parent: angular.element(document.body),
						targetEvent: ev,
						clickOutsideToClose: true
					}).then($scope.closeDialog, $scope.cancelDialod);	
					ev.target.disabled = false;
				};
				
				$scope.capaTemasmodelo = {
						idCapaTemAgen: null,
						idCapacitacion: null,
						idTema: null,
						idTemaTxt: null,
						idSubtema: null,
						idSubtemaTxt: null,
						idUsuinternoTxt: null
					};
				
				$scope.setCapaTemasmodelo = function(capaTemasm){
					$scope.capaTemasmodelo.idCapaTemAgen= capaTemasm.idCapaTemAgen;
					$scope.capaTemasmodelo.idCapacitacion= capaTemasm.idCapacitacion;
					$scope.capaTemasmodelo.idTema= capaTemasm.idTema;
					$scope.capaTemasmodelo.idTemaTxt= capaTemasm.idTemaTxt;
					$scope.capaTemasmodelo.idSubtema= capaTemasm.idSubtema;
					$scope.capaTemasmodelo.idSubtemaTxt= capaTemasm.idSubtemaTxt;
					$scope.capaTemasmodelo.idUsuinternoTxt= capaTemasm.idUsuinternoTxt;
				};
				
				/*$scope.clearCapaTemasmodelo= function(){
					$scope.capaTemasmodelo.idCapaTemAgen= null;
					$scope.capaTemasmodelo.idCapacitacion= null;
					$scope.capaTemasmodelo.idTema= null;
					$scope.capaTemasmodelo.idTemaTxt= null;
					$scope.capaTemasmodelo.idSubtema= null;
					$scope.capaTemasmodelo.idSubtemaTxt= null;
					$scope.capaTemasmodelo.idUsuinternoTxt= null;
				};*/
				
				$scope.nuevoCapaTemasmodelo = function (ev) {
					ev.target.disabled = true;
					
					if ($scope.isNull($scope.capaTemasmodelo.idTema)) {
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
					
					if ($scope.isNull($scope.capaTemasmodelo.idSubtema)) {
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
					
					if ($scope.datoCapasTema.filter(e => e.idSubtema === $scope.capaTemasmodelo.idSubtema).length > 0) {
						  /* vendors contains the element we're looking for */
						$mdDialog.show(
								$mdDialog.alert().multiple(true)
								.parent(angular.element(document.body))
								.clickOutsideToClose(true)
								.title('Guardar capacitación')
								.textContent("El subtema seleccionado ya existe")
								.ariaLabel('Lucky day')
								.ok('ACEPTAR')
						);
						ev.target.disabled = false;
						return;
						}
					
			        var datoactual = Object.assign({}, $scope.capaTemasmodelo);		
					if($scope.isNull(datoactual.idCapaTemAgen) || $scope.isUndefined(datoactual.idCapaTemAgen)){
						datoactual.idCapaTemAgen = $scope.generateRandomInteger(1000)*-1;
					}
					if($scope.isArray($scope.datoCapasTema)){
						var objEncontrado = $scope.datoCapasTema.find(o => o.idCapaTemAgen === datoactual.idCapaTemAgen);
						if($scope.isObject(objEncontrado)){
							Object.assign(objEncontrado, datoactual);
							$scope.cancel();
							ev.target.disabled = false;
							return;
						}
					}	
					$scope.datoCapasTema.push(datoactual);	
					$scope.cancel();
					ev.target.disabled = false;
				};
				
				//DIALOG PARTICIPANTES
				
				$scope.usuarioModelo = {
		        		idCapaUsuext:null,
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
						celularUsuext: null,
						codEjecutora: null,
						idEntidadTxt: null,
						idEntidad: null,
						idCargo:null,
						idCargoTxt:null
				};
				
				$scope.hideDialogParticipantes = function () {
					$mdDialog.hide($scope.usuarioModelo);
					$scope.agregarUsuario();
				};
				
				$scope.clearUsuarioModelDialog= function(){
		        	$scope.usuarioModelo.idCapaUsuext= null;
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
		        	$scope.usuarioModelo.codEjecutora= null;
		        	$scope.usuarioModelo.idEntidadTxt= null;
		        	$scope.usuarioModelo.idEntidad = null;
		        	$scope.usuarioModelo.idCargo= null;
		        	$scope.usuarioModelo.idCargoTxt = null;
		        	
		        	$scope.selectedItem = null;
		        	
		        	$scope.listaCargos=[];
		        }
				
				$scope.showDialogParticipante = function(ev) {
					ev.target.disabled = true;
					$scope.clearUsuarioModelDialog();		
					$mdDialog.show({
						templateUrl: contexto+"/dialogos/editarCapaParticipantes.html",
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
				            
				            $scope.usuarioModelo.codEjecutora = resData.codEjecutora; 
			                $scope.usuarioModelo.idEntidadTxt = resData.idEntidadTxt;
			                $scope.usuarioModelo.idEntidad = resData.idEntidad;
			                
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
				                console.log("JSON.stringify(institucion): "+JSON.stringify(institucion));
				                
				                $scope.usuarioModelo.codEjecutora = institucion.codEjec; 
				                $scope.usuarioModelo.idEntidadTxt = institucion.razSocialUbigeo;
				                $scope.usuarioModelo.idEntidad = institucion.idEntidad;
				                
				              /*  dato.codEjecutora = institucion.codEjec; 
				                dato.idEntidadTxt = institucion.razSocialUbigeo;
				                dato.idEntidad = institucion.idEntidad;
				                console.log('modelo', dato);

				                $scope.selectedItem = institucion; */
				                $scope.selectedItem = institucion;
				                
				            } else if(resData.length>1){
				                $scope.dlgInstmsInstitucionesDtoss = resData;
				                $scope.dlgInsttotal = resData.length;
				                $scope.showdlgInstDialog(resData);  
				            }
				        }, function error(errResponse) {
				            console.log("Buscar x CodEjec data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse.statusText + " xhrStat " + errResponse.xhrStatus);
				            var errData = errResponse.data;
				            if(errData && typeof(errData.message) != 'undefined'){
				                $mdDialog.show(
				                    $mdDialog.alert().multiple(true)
				                    .parent(angular.element(document.body))
				                    .clickOutsideToClose(true)
				                    .title('Buscar por ejecutora - Registramef')
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
			    
			    
			    
			    
			    
				//FIN DIALOG PARTICIPANTES
				
				
				//**********************************************************************************************************
				$scope.situaciondemitramite = function(ev){		
					var parametro1 = null;
					var parametro2 = null;
//					$scope.cleartdEvento();
					if(!$scope.isString($scope.dtCapacitacionModelo.stdNumeroSid) || 
							!$scope.isString($scope.dtCapacitacionModelo.stdNumeroAnio)
					){
						$mdDialog.show(
								$mdDialog.alert()
								.parent(angular.element(document.body))
								.clickOutsideToClose(true)
								.title('Buscar situación de mi trámite')
								.textContent("No se ha ingresado texto en el año y/o número de expediente...")
								.ariaLabel('ERROR')
								.ok('ACEPTAR')
								.targetEvent(ev)
						);
						return;
					}else{
						var formattedNumber = ("000000" + $scope.dtCapacitacionModelo.stdNumeroSid).slice(-6);
						$scope.dtCapacitacionModelo.stdNumeroSid=formattedNumber;
						if(!$scope.isString($scope.dtCapacitacionModelo.stdNumeroSid) ||  
								$scope.dtCapacitacionModelo.stdNumeroSid.length!=6 || 
								isNaN($scope.dtCapacitacionModelo.stdNumeroSid)){
							$mdDialog.show(
									$mdDialog.alert()
									.parent(angular.element(document.body))
									.clickOutsideToClose(true)
									.title('Buscar situación de mi trámite')
									.textContent("El número ingresado no corresponde a un expediente...")
									.ariaLabel('ERROR')
									.ok('ACEPTAR')
									.targetEvent(ev));
							return;
						}else if((!$scope.isString($scope.dtCapacitacionModelo.stdNumeroAnio) ||  
								$scope.dtCapacitacionModelo.stdNumeroAnio.length!=4 || 
								isNaN($scope.dtCapacitacionModelo.stdNumeroAnio)) && 
								!($scope.isNumber($scope.dtCapacitacionModelo.stdNumeroAnio) && 
										($scope.dtCapacitacionModelo.stdNumeroAnio>2010 && $scope.dtCapacitacionModelo.stdNumeroAnio<9999))){
							$mdDialog.show(
									$mdDialog.alert()
									.parent(angular.element(document.body))
									.clickOutsideToClose(true)
									.title('Buscar situación de mi trámite')
									.textContent("El año ingresado no corresponde a un expediente...")
									.ariaLabel('ERROR')
									.ok('ACEPTAR')
									.targetEvent(ev));
							return;
						}else{
							parametro1 = encodeURIComponent($scope.dtCapacitacionModelo.stdNumeroAnio);
							parametro2 = encodeURIComponent($scope.dtCapacitacionModelo.stdNumeroSid);
						}
					}		
					ev.target.disabled = true;
					var surl = situacionSTDUrl+parametro1+'/'+parametro2;
					$scope.dlgPersopromise = $http.get(surl).then(function(res){
						var dato = res.data;
						$scope.dtCapacitacionModelo.stdAsunto = dato.asunto;
						$scope.dtCapacitacionModelo.stdTipoDoc = dato.tipodedocumento;
						$scope.dtCapacitacionModelo.stdNumeroDoc = dato.numerodedocumento;
						$scope.dtCapacitacionModelo.stdIddoc = dato.expedienteiddoc; 
						$scope.dtCapacitacionModelo.stdModalidadIng = dato.modalidadIngreso;
						$scope.dtCapacitacionModelo.stdFechaRecepcion = dato.fechahorarecepcion;
						ev.target.disabled = false;
					},
					function error(errResponse) {
						console.log("Buscar situación de mi trámite data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
						var dato = errResponse.data;
						if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
							$mdDialog.show(
									$mdDialog.alert()
									.parent(angular.element(document.body))
									.clickOutsideToClose(true)
									.title('Buscar situación de mi trámite')
									.textContent(dato.message)
									.ariaLabel('ERROR')
									.ok('ACEPTAR')
									.targetEvent(ev)
							);
						}		
						$scope.dtCapacitacionModelo.stdAsunto = null;
						$scope.dtCapacitacionModelo.stdTipoDoc = null;
						$scope.dtCapacitacionModelo.stdNumeroDoc = null;
						$scope.dtCapacitacionModelo.stdIddoc = null; 
						$scope.dtCapacitacionModelo.stdModalidadIng = null;
						$scope.dtCapacitacionModelo.stdFechaRecepcion = null;
						ev.target.disabled = false;
					});		
				};
				
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
				//*********************************************************************************
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
		    	
		    	//SELECT INI
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
		          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
		        }
		        $scope.$watch('dtAsistenciaModelo.idSede', function (newValue, oldValue) {
		        console.log('dtAsistenciaModelo.idSede ' + newValue+' -- '+oldValue);
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
				
		//MPINARES 14022024 - FIN
	  
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
			    	$scope.refrescar=1;
			    	$scope.loaddtCapacitacions();
			    }else if (keyCode === 1) {
			    	$scope.refrescar=1;
			    	$scope.loaddtCapacitacions();
			    }
          }
		};
		
		//MPINARES 14022024 - INICIO
        $scope.descargarvista = function(){
      	  return descargarvistaUrl + $scope.getURLParametros();
//			  if(typeof(ev)=='undefined' || ev==null){
//				  return "#";
//	          }else{
//	        	  return descargarvistaUrl;
//	        	  }
	    };
	  //MPINARES 14022024 - FIN

//MPINARES 14022024 - INICIO
	    
	    $scope.salvarDtCapacitacionAcumula = function(ev){	
			
			  if($scope.isArray($scope.selectedCapaci)){
					if($scope.selectedCapaci.length>0){
						$scope.dtCapacitacionAcumulaModelo.dtCapaAcumulaListBkJSss = $scope.selectedCapaci;
					}};
					
					    ev.target.disabled = true;
					    var datainsert = angular.toJson($scope.dtCapacitacionAcumulaModelo);
			 			console.log("datainsert = "+datainsert);	
			        		$http.post(insertdtCapacitacionAcumulaUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
								var dato = res.data;

//			    				$scope.datos.push(dato); 
//			    				$scope.total = $scope.datos.length;
			    				
//			    				$scope.setDtCapacitacionModelo(dato);
			    				
			    				$mdDialog.show(
								         $mdDialog.alert()
								        .parent(angular.element(document.body))
								        .clickOutsideToClose(true)
								        .title('Guardar capacitaciones')
								        .textContent("la Capacitación acumulada se guardó correctamente en ID: " + dato.idCapacitacion)
								        .ariaLabel('ERROR')
								        .ok('ACEPTAR')
								        .targetEvent(ev)
								    );
			    				
			    				$scope.nuevo = false;
							},
							function error(errResponse) {
					            console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
					            var dato = errResponse.data;
					            if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
					            	$mdDialog.show(
									         $mdDialog.alert().multiple(true)
									        .parent(angular.element(document.body))
									        .clickOutsideToClose(true)
									        .title('Guardar capacitaciones')
									        .textContent(dato.message)
									        .ariaLabel('ERROR')
									        .ok('ACEPTAR')
									        .targetEvent(ev)
									    );
					            }
					        });		
			        			        	
			        	ev.target.disabled = false;
				 };
				 
	    $scope.dtCapacitacionAnular = {
	    		idCapacitacion : null,
	    		detalleCapa: null
	          };
	    
	    $scope.setDtCapacitacionAnular = function(dtCapacitacionBk) {
//	        $scope.dtCapacitacionAnular.idCapacitacion = dtCapacitacionBk.idCapacitacion;
//	        $scope.dtCapacitacionAnular.detalleCapa = dtCapacitacionBk.detalleCapa;
	    	$scope.dtCapacitacionAnular.idCapacitacion = dtCapacitacionBk.idCapacitacion;
			$scope.dtCapacitacionAnular.fechaInic = dtCapacitacionBk.fechaInic;
            if(!$scope.isNull($scope.dtCapacitacionAnular.fechaInic) && !isNaN($scope.dtCapacitacionAnular.fechaInic)){
			    $scope.dtCapacitacionAnular.fechaInic = new Date($scope.dtCapacitacionAnular.fechaInic);
		    }
			$scope.dtCapacitacionAnular.fechaFin = dtCapacitacionBk.fechaFin;
            if(!$scope.isNull($scope.dtCapacitacionAnular.fechaFin) && !isNaN($scope.dtCapacitacionAnular.fechaFin)){
			    $scope.dtCapacitacionAnular.fechaFin = new Date($scope.dtCapacitacionAnular.fechaFin);
		    }
			$scope.dtCapacitacionAnular.nomEvento = dtCapacitacionBk.nomEvento;
			$scope.dtCapacitacionAnular.idSistAdm = dtCapacitacionBk.idSistAdm;
			$scope.dtCapacitacionAnular.idUsuinterno = dtCapacitacionBk.idUsuinterno;
			$scope.dtCapacitacionAnular.flagPubli = dtCapacitacionBk.flagPubli;
			$scope.dtCapacitacionAnular.idModalidad = dtCapacitacionBk.idModalidad;
			$scope.dtCapacitacionAnular.idProgramacion = dtCapacitacionBk.idProgramacion;
			$scope.dtCapacitacionAnular.estado = dtCapacitacionBk.estado;
			$scope.dtCapacitacionAnular.cantPartic = dtCapacitacionBk.cantPartic;
			$scope.dtCapacitacionAnular.publicObj = dtCapacitacionBk.publicObj;
			$scope.dtCapacitacionAnular.detalleCapa = dtCapacitacionBk.detalleCapa;
			$scope.dtCapacitacionAnular.idLocal = dtCapacitacionBk.idLocal;
			$scope.dtCapacitacionAnular.idModo = dtCapacitacionBk.idModo;
			$scope.dtCapacitacionAnular.idNivel = dtCapacitacionBk.idNivel;
			$scope.dtCapacitacionAnular.idOrigen = dtCapacitacionBk.idOrigen;
			$scope.dtCapacitacionAnular.idPrestacion = dtCapacitacionBk.idPrestacion;
			$scope.dtCapacitacionAnular.cantParticAsist = dtCapacitacionBk.cantParticAsist;
			$scope.dtCapacitacionAnular.idTipo = dtCapacitacionBk.idTipo;
			$scope.dtCapacitacionAnular.idcapaPadre = dtCapacitacionBk.idcapaPadre;
			$scope.dtCapacitacionAnular.idSede = dtCapacitacionBk.idSede;
			$scope.dtCapacitacionAnular.idFinancia = dtCapacitacionBk.idFinancia;
			$scope.dtCapacitacionAnular.fechaFinalizacion = dtCapacitacionBk.fechaFinalizacion;
            if(!$scope.isNull($scope.dtCapacitacionAnular.fechaFinalizacion) && !isNaN($scope.dtCapacitacionAnular.fechaFinalizacion)){
			    $scope.dtCapacitacionAnular.fechaFinalizacion = new Date($scope.dtCapacitacionAnular.fechaFinalizacion);
		    }
			$scope.dtCapacitacionAnular.detalleCapaVirtual = dtCapacitacionBk.detalleCapaVirtual;
			$scope.dtCapacitacionAnular.fechaIniProgramada = dtCapacitacionBk.fechaIniProgramada;
            if(!$scope.isNull($scope.dtCapacitacionAnular.fechaIniProgramada) && !isNaN($scope.dtCapacitacionAnular.fechaIniProgramada)){
			    $scope.dtCapacitacionAnular.fechaIniProgramada = new Date($scope.dtCapacitacionAnular.fechaIniProgramada);
		    }
			$scope.dtCapacitacionAnular.fechaFinProgramada = dtCapacitacionBk.fechaFinProgramada;
            if(!$scope.isNull($scope.dtCapacitacionAnular.fechaFinProgramada) && !isNaN($scope.dtCapacitacionAnular.fechaFinProgramada)){
			    $scope.dtCapacitacionAnular.fechaFinProgramada = new Date($scope.dtCapacitacionAnular.fechaFinProgramada);
		    }
			$scope.dtCapacitacionAnular.fechaSoli = dtCapacitacionBk.fechaSoli;
            if(!$scope.isNull($scope.dtCapacitacionAnular.fechaSoli) && !isNaN($scope.dtCapacitacionAnular.fechaSoli)){
			    $scope.dtCapacitacionAnular.fechaSoli = new Date($scope.dtCapacitacionAnular.fechaSoli);
		    }
                              
            $scope.dtCapacitacionAnular.fechaSoliJUD = dtCapacitacionBk.fechaSoliJUD;
            if(!$scope.isNull($scope.dtCapacitacionAnular.fechaSoliJUD) && !isNaN($scope.dtCapacitacionAnular.fechaSoliJUD)){
       			    $scope.dtCapacitacionAnular.fechaSoliJUD = new Date($scope.dtCapacitacionAnular.fechaSoliJUD);
       		}
            $scope.dtCapacitacionAnular.fechaInicJUD = dtCapacitacionBk.fechaInicJUD;
            if(!$scope.isNull($scope.dtCapacitacionAnular.fechaInicJUD) && !isNaN($scope.dtCapacitacionAnular.fechaInicJUD)){
       			    $scope.dtCapacitacionAnular.fechaInicJUD = new Date($scope.dtCapacitacionAnular.fechaInicJUD);
       		}
            $scope.dtCapacitacionAnular.fechaFinJUD = dtCapacitacionBk.fechaFinJUD;
            if(!$scope.isNull($scope.dtCapacitacionAnular.fechaFinJUD) && !isNaN($scope.dtCapacitacionAnular.fechaFinJUD)){
       			    $scope.dtCapacitacionAnular.fechaFinJUD = new Date($scope.dtCapacitacionAnular.fechaFinJUD);
       		}
             
			$scope.dtCapacitacionAnular.stdIddoc = dtCapacitacionBk.stdIddoc;
			$scope.dtCapacitacionAnular.stdNumeroSid = dtCapacitacionBk.stdNumeroSid;
			$scope.dtCapacitacionAnular.stdNumeroAnio = dtCapacitacionBk.stdNumeroAnio;
			$scope.dtCapacitacionAnular.stdNumeroDoc = dtCapacitacionBk.stdNumeroDoc;
			$scope.dtCapacitacionAnular.stdAsunto = dtCapacitacionBk.stdAsunto;
			$scope.dtCapacitacionAnular.stdTipoDoc = dtCapacitacionBk.stdTipoDoc;
			$scope.dtCapacitacionAnular.stdFechaRecepcion = dtCapacitacionBk.stdFechaRecepcion;
            if(!$scope.isNull($scope.dtCapacitacionAnular.stdFechaRecepcion) && !isNaN($scope.dtCapacitacionAnular.stdFechaRecepcion)){
			    $scope.dtCapacitacionAnular.stdFechaRecepcion = new Date($scope.dtCapacitacionAnular.stdFechaRecepcion);
		    }
			$scope.dtCapacitacionAnular.stdModalidadIng = dtCapacitacionBk.stdModalidadIng;
			$scope.dtCapacitacionAnular.flagEjec = dtCapacitacionBk.flagEjec;
			$scope.dtCapacitacionAnular.motivoEjec = dtCapacitacionBk.motivoEjec;
			
                        // ADICIONALES
	        $scope.dtCapacitacionAnular.idSistAdmTxt = dtCapacitacionBk.idSistAdmTxt;
			$scope.dtCapacitacionAnular.idUsuinternoTxt = dtCapacitacionBk.idUsuinternoTxt;
			$scope.dtCapacitacionAnular.idModalidadTxt = dtCapacitacionBk.idModalidadTxt;
			$scope.dtCapacitacionAnular.idProgramacionTxt = dtCapacitacionBk.idProgramacionTxt;
			$scope.dtCapacitacionAnular.estadoTxt = dtCapacitacionBk.estadoTxt;
			$scope.dtCapacitacionAnular.idLocalTxt = dtCapacitacionBk.idLocalTxt;
			$scope.dtCapacitacionAnular.idModoTxt = dtCapacitacionBk.idModoTxt;
			$scope.dtCapacitacionAnular.idNivelTxt = dtCapacitacionBk.idNivelTxt;
			$scope.dtCapacitacionAnular.idOrigenTxt = dtCapacitacionBk.idOrigenTxt;
			$scope.dtCapacitacionAnular.idPrestacionTxt = dtCapacitacionBk.idPrestacionTxt;
			$scope.dtCapacitacionAnular.idTipoTxt = dtCapacitacionBk.idTipoTxt;
			$scope.dtCapacitacionAnular.idSedeTxt = dtCapacitacionBk.idSedeTxt;
			$scope.dtCapacitacionAnular.idFinanciaTxt = dtCapacitacionBk.idFinanciaTxt;
			$scope.dtCapacitacionAnular.dtCapaTemasBkJSss = dtCapacitacionBk.dtCapaTemasBkJSss;
			if(dtCapacitacionBk.dtCapaTemasBkJSss!=null && dtCapacitacionBk.dtCapaTemasBkJSss.length>0){
				$scope.datoCapasTema = $scope.dtCapacitacionAnular.dtCapaTemasBkJSss;
			}
			$scope.dtCapacitacionAnular.dtCapaEntidadesBkJSss = dtCapacitacionBk.dtCapaEntidadesBkJSss;
			if(dtCapacitacionBk.dtCapaEntidadesBkJSss!=null && dtCapacitacionBk.dtCapaEntidadesBkJSss.length>0){
				$scope.datoCapaEntidades = $scope.dtCapacitacionAnular.dtCapaEntidadesBkJSss;
			}
			$scope.dtCapacitacionAnular.dtCapaPublicoBkJSss = dtCapacitacionBk.dtCapaPublicoBkJSss;
			if(dtCapacitacionBk.dtCapaPublicoBkJSss!=null && dtCapacitacionBk.dtCapaPublicoBkJSss.length>0){
				$scope.datoCapaPublico = [];
				for(var i = 0; i < dtCapacitacionBk.dtCapaPublicoBkJSss.length; i++)
				{
					var capaPublico = dtCapacitacionBk.dtCapaPublicoBkJSss[i];
					$scope.addCapaPublico(capaPublico, i, dtCapacitacionBk.dtCapaPublicoBkJSss.length);
				}
			}
	        
	      };
	      $scope.cleardtCapacitacionAnular = function(){
//	        $scope.dtCapacitacionAnular.idCapacitacion = null;
//	        $scope.dtCapacitacionAnular.detalleCapa = null;
	    	  $scope.dtCapacitacionAnular.idCapacitacion = null;
			    $scope.dtCapacitacionAnular.fechaInic = new Date();$scope.dtCapacitacionAnular.fechaFin = new Date();$scope.dtCapacitacionAnular.nomEvento = null;
			    $scope.dtCapacitacionAnular.idSistAdm = null;
			    $scope.dtCapacitacionAnular.idUsuinterno = null;
			    $scope.dtCapacitacionAnular.flagPubli = null;
			    $scope.dtCapacitacionAnular.idModalidad = null;
			    $scope.dtCapacitacionAnular.idProgramacion = null;
			    $scope.dtCapacitacionAnular.estado = null;
			    $scope.dtCapacitacionAnular.cantPartic = null;
			    $scope.dtCapacitacionAnular.publicObj = null;
			    $scope.dtCapacitacionAnular.detalleCapa = null;
			    $scope.dtCapacitacionAnular.idLocal = null;
			    $scope.dtCapacitacionAnular.idModo = null;
			    $scope.dtCapacitacionAnular.idNivel = null;
			    $scope.dtCapacitacionAnular.idOrigen = null;
			    $scope.dtCapacitacionAnular.idPrestacion = null;
			    $scope.dtCapacitacionAnular.cantParticAsist = null;
			    $scope.dtCapacitacionAnular.idTipo = null;
			    $scope.dtCapacitacionAnular.idcapaPadre = null;
			    $scope.dtCapacitacionAnular.idSede = null;
			    $scope.dtCapacitacionAnular.idFinancia = null;
			    $scope.dtCapacitacionAnular.fechaFinalizacion = new Date();$scope.dtCapacitacionAnular.detalleCapaVirtual = null;
			    $scope.dtCapacitacionAnular.fechaIniProgramada = new Date();$scope.dtCapacitacionAnular.fechaFinProgramada = new Date();$scope.dtCapacitacionAnular.fechaSoli = new Date();$scope.dtCapacitacionAnular.stdIddoc = null;
			    $scope.dtCapacitacionAnular.stdNumeroSid = null;
			    $scope.dtCapacitacionAnular.stdNumeroAnio = null;
			    $scope.dtCapacitacionAnular.stdNumeroDoc = null;
			    $scope.dtCapacitacionAnular.stdAsunto = null;
			    $scope.dtCapacitacionAnular.stdTipoDoc = null;
			    $scope.dtCapacitacionAnular.stdFechaRecepcion = new Date();$scope.dtCapacitacionAnular.stdModalidadIng = null;
			    $scope.dtCapacitacionAnular.flagEjec = null;
			    $scope.dtCapacitacionAnular.motivoEjec = null;
	                    // ADICIONALES
		        $scope.dtCapacitacionAnular.idSistAdmTxt = null;
				$scope.dtCapacitacionAnular.idUsuinternoTxt = null;
				$scope.dtCapacitacionAnular.idModalidadTxt = null;
				$scope.dtCapacitacionAnular.idProgramacionTxt = null;
				$scope.dtCapacitacionAnular.estadoTxt = null;
				$scope.dtCapacitacionAnular.idLocalTxt = null;
				$scope.dtCapacitacionAnular.idModoTxt = null;
				$scope.dtCapacitacionAnular.idNivelTxt = null;
				$scope.dtCapacitacionAnular.idOrigenTxt = null;
				$scope.dtCapacitacionAnular.idPrestacionTxt = null;
				$scope.dtCapacitacionAnular.idTipoTxt = null;
				$scope.dtCapacitacionAnular.idSedeTxt = null;
				$scope.dtCapacitacionAnular.idFinanciaTxt = null;
				$scope.dtCapacitacionAnular.dtCapaTemasBkJSss= [];
				$scope.dtCapacitacionAnular.dtCapaEntidadesBkJSss= [];
				$scope.dtCapacitacionAnular.dtCapaPublicoBkJSss= [];
	        
	      };
	      
	      $scope.selectedCapaci = [];
	      $scope.selection = function(item){
//	          $scope.cleardtCapacitacionAnular();
//	          $scope.setDtCapacitacionAnular(item);
	          if(item.checked){
//	            $scope.selectedCapaci.push(item);
	        	  $scope.selectedCapaci.push({
	        		  idCapacitacion : item.idCapacitacion,
	        		  fechaInic : item.fechaInic,
	        		  fechaFin : item.fechaFin,
	        		  nomEvento : item.nomEvento,
	        		  idSistAdm : item.idSistAdm,
	        		  idUsuinterno : item.idUsuinterno,
	        		  flagPubli : item.flagPubli,
	        		  idModalidad : item.idModalidad,
	        		  idProgramacion : item.idProgramacion,
	        		  estado : item.estado,
	        		  cantPartic : item.cantPartic,
	        		  publicObj : item.publicObj,
	        		  detalleCapa : item.detalleCapa,
	        		  idLocal : item.idLocal,
	        		  idModo : item.idModo,
	        		  idNivel : item.idNivel,
	        		  idOrigen : item.idOrigen,
	        		  idPrestacion : item.idPrestacion,
	        		  cantParticAsist : item.cantParticAsist,
	        		  idTipo : item.idTipo,
	        		  idcapaPadre : item.idcapaPadre,
	        		  idSede : item.idSede,
	        		  idFinancia : item.idFinancia,
	        		  fechaFinalizacion : item.fechaFinalizacion,
	        		  detalleCapaVirtual : item.detalleCapaVirtual,
	        		  fechaIniProgramada : item.fechaIniProgramada,
	        		  fechaFinProgramada : item.fechaFinProgramada,
	        		  fechaSoli : item.fechaSoli,
	        		  fechaSoliJUD : item.fechaSoliJUD,
	        		  fechaInicJUD : item.fechaInicJUD,
	        		  fechaFinJUD : item.fechaFinJUD,
	        		  stdIddoc : item.stdIddoc,
	        		  stdNumeroSid : item.stdNumeroSid,
	        		  stdNumeroAnio : item.stdNumeroAnio,
	        		  stdNumeroDoc : item.stdNumeroDoc,
	        		  stdAsunto : item.stdAsunto,
	        		  stdTipoDoc : item.stdTipoDoc,
	        		  stdFechaRecepcion : item.stdFechaRecepcion,
	        		  stdModalidadIng : item.stdModalidadIng,
	        		  flagEjec : item.flagEjec,
	        		  motivoEjec : item.motivoEjec,
	        		  idSistAdmTxt : item.idSistAdmTxt,
	        		  idUsuinternoTxt : item.idUsuinternoTxt,
	        		  idModalidadTxt : item.idModalidadTxt,
	        		  idProgramacionTxt : item.idProgramacionTxt,
	        		  estadoTxt : item.estadoTxt,
	        		  idLocalTxt : item.idLocalTxt,
	        		  idModoTxt : item.idModoTxt,
	        		  idNivelTxt : item.idNivelTxt,
	        		  idOrigenTxt : item.idOrigenTxt,
	        		  idPrestacionTxt : item.idPrestacionTxt,
	        		  idTipoTxt : item.idTipoTxt,
	        		  idSedeTxt : item.idSedeTxt,
	        		  idFinanciaTxt : item.idFinanciaTxt,
	        		  dtCapaTemasBkJSss : item.dtCapaTemasBkJSss,
	        		  dtCapaEntidadesBkJSss : item.dtCapaEntidadesBkJSss,
	        		  dtCapaPublicoBkJSss : item.dtCapaPublicoBkJSss
	                })
	          }else{
//	            $scope.selectedCapaci = $scope.selectedCapaci.filter(val => val.idCapacitacion !== $scope.dtCapacitacionAnular.idCapacitacion);
	        	  $scope.selectedCapaci = $scope.selectedCapaci.filter(val => val.idCapacitacion !== item.idCapacitacion);
	          }
	          console.log('lista: '+ $scope.selectedCapaci); 
	        };
	        
	        $scope.showConfirmAnularCapacitacion = function(ev) {
				  if($scope.selectedCapaci.length<1){
						$mdDialog.show(
								$mdDialog.alert()
								.parent(angular.element(document.body))
								.clickOutsideToClose(true)
								.title('Anular capacitación')
								.textContent("Debe seleccionar al menos un registro")
								.ariaLabel('Lucky day')
								.ok('ACEPTAR')
								.targetEvent(ev)
						);
					}else{
						var confirm = $mdDialog.confirm()
		                .title('Anular capacitación')
		                .textContent('¿Está usted seguro de anular los registros?')
		                .ariaLabel('Lucky day')
		                .targetEvent(ev)
		                .ok('Si')
		                .cancel('No');

		              $mdDialog.show(confirm).then(function () {
		                $scope.status = 'SI';
		                $scope.anulardtCapacitacionList(ev, $scope.selectedCapaci);
		              }, function () {
		                $scope.status = 'NO';
		              });
					}
	            };
	            
	            $scope.anulardtCapacitacionList = function(ev, selectedCapaci){		
				    ev.target.disabled = true;
				    var datainsert = angular.toJson(selectedCapaci);
					console.log("datainsert = "+datainsert);	
//				$http.post(anulardtCapacitacionListUrl+$scope.getURLParametros(),datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
				$http.post(anulardtCapacitacionListUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
						var dato1 = res.data;
//						var instrumentos = $scope.datos;
//				        var index = $scope.datos.findIndex(obj => obj.idAsistTema === dato.idAsistTema);
//						console.log("INDEX " + index);
//				        if(instrumentos.length>index){
//				        	instrumentos.splice(index, 1);
//					        $scope.datos = instrumentos;
//					        $scope.total = $scope.datos.length;
//				        }	
				        $scope.loaddtCapacitacions();
					},
					function error(errResponse) {
			            console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
			            var dato = errResponse.data;
			            if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
			            	$mdDialog.show(
					         $mdDialog.alert()
					        .parent(angular.element(document.body))
					        .clickOutsideToClose(true)
					        .title('Anular capacitación')
					        .textContent(dato.message)
					        .ariaLabel('ERROR')
					        .ok('ACEPTAR')
					        .targetEvent(ev)
						   );
			            }
			        });			        			        	
		      	ev.target.disabled = false;
			 };
	            
	            
	            $scope.showConfirmPrepublicarCapacitacion = function(ev) {
					  if($scope.selectedCapaci.length<1){
							$mdDialog.show(
									$mdDialog.alert()
									.parent(angular.element(document.body))
									.clickOutsideToClose(true)
									.title('Pre-publicar capacitación')
									.textContent("Debe seleccionar al menos un registro")
									.ariaLabel('Lucky day')
									.ok('ACEPTAR')
									.targetEvent(ev)
							);
						}else{
							var confirm = $mdDialog.confirm()
			                .title('Pre-publicar capacitación')
			                .textContent('¿Está usted seguro de pre-publicar los registros?')
			                .ariaLabel('Lucky day')
			                .targetEvent(ev)
			                .ok('Si')
			                .cancel('No');

			              $mdDialog.show(confirm).then(function () {
			                $scope.status = 'SI';
			                $scope.prepublicarCapaList(ev, $scope.selectedCapaci);
			              }, function () {
			                $scope.status = 'NO';
			              });
						}
		            };
		            
		            $scope.prepublicarCapaList = function(ev, selectedCapaci){		
					    ev.target.disabled = true;
					    var datainsert = angular.toJson(selectedCapaci);
						console.log("datainsert = "+datainsert);	
					$http.post(prepublicardtCapaUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
							var dato1 = res.data;
//							var instrumentos = $scope.datos;
//					        var index = $scope.datos.findIndex(obj => obj.idAsistTema === dato.idAsistTema);
//							console.log("INDEX " + index);
//					        if(instrumentos.length>index){
//					        	instrumentos.splice(index, 1);
//						        $scope.datos = instrumentos;
//						        $scope.total = $scope.datos.length;
//					        }	
					        $scope.loaddtCapacitacions();
					        
					        $mdDialog.show(
							         $mdDialog.alert()
							        .parent(angular.element(document.body))
							        .clickOutsideToClose(true)
							        .title('Pre-publicar capacitación')
							        .textContent("Se han pre-publicado las capacitaciones seleccionadas")
							        .ariaLabel('ERROR')
							        .ok('ACEPTAR')
							        .targetEvent(ev)
							    );
					        
						},
						function error(errResponse) {
				            console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
				            var dato = errResponse.data;
				            if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
				            	$mdDialog.show(
						         $mdDialog.alert()
						        .parent(angular.element(document.body))
						        .clickOutsideToClose(true)
						        .title('Pre-publicar capacitación')
						        .textContent(dato.message)
						        .ariaLabel('ERROR')
						        .ok('ACEPTAR')
						        .targetEvent(ev)
							   );
				            }
				        });			        			        	
			      	ev.target.disabled = false;
				 };
	        
	        
	        $scope.showConfirmReactivarCapacitacion = function(ev, dtCapacitacionBk) {
	            var confirm = $mdDialog.confirm()
	              .title('Reactivar capacitación técnica')
	              .textContent('¿Está usted seguro de reactivar el registro?')
	              .ariaLabel('Lucky day')
	              .targetEvent(ev)
	              .ok('Si')
	              .cancel('No');

	            $mdDialog.show(confirm).then(function () {
	              $scope.status = 'SI';
	              $scope.reactivardtCapacitacion(ev, dtCapacitacionBk);
	            }, function () {
	              $scope.status = 'NO';
	            });
	          };
	          
	          $scope.reactivardtCapacitacion = function(ev,dtCapacitacionBk){		
				    ev.target.disabled = true;
				    $scope.setDtCapacitacionModelo(dtCapacitacionBk);
				    var datainsert = angular.toJson($scope.dtCapacitacionModelo);
		 			console.log("datainsert = "+datainsert);	
	        		$http.post(reactivardtCapacitacionUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
						var dato1 = res.data;
//						var instrumentos = $scope.datos;
//				        var index = $scope.datos.findIndex(obj => obj.idAsistencia === dato.idAsistencia);
//						console.log("INDEX " + index);
//				        if(instrumentos.length>index){
//				        	instrumentos.splice(index, 1);
//					        $scope.datos = instrumentos;
//					        $scope.total = $scope.datos.length;
//				        }	
						$scope.loaddtCapacitacions();
					},
					function error(errResponse) {
			            console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
			            var dato = errResponse.data;
			            if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
			            	$mdDialog.show(
					         $mdDialog.alert()
					        .parent(angular.element(document.body))
					        .clickOutsideToClose(true)
					        .title('Reactivar capacitaciones')
					        .textContent(dato.message)
					        .ariaLabel('ERROR')
					        .ok('ACEPTAR')
					        .targetEvent(ev)
						   );
			            }
			        });			        			        	
		        	ev.target.disabled = false;
			 };
	        
			  $scope.firstDateNextMonth = function(dia){
				  const year = dia.getFullYear();
				  const month = dia.getMonth() + 2; 
				  dia = new Date(year, month, 0);
				  dia.setDate(1);
				  return dia; 
			  }
	       
	  $scope.dtCapacitacionModelo = {
			idCapacitacion : null,
			fechaInic: null,
			fechaFin: null,
			cantPartic: null,
			publicObj: null,
			nomEvento: null,
			detalleCapa: null,
			idLocal: null,
			idUsuinterno: null,
			idModo: null,
			idNivel: null,
			idOrigen: 127,
			idPrestacion: null,
			idProgramacion: 121,
			cantParticAsist: null,
			idTipo: null,
			idcapaPadre: null,
			idSede: null,
			idSistAdm: null,
			idFinancia: null,
			fechaFinalizacion: null,
			flagPubli: null,
			idModalidad: null,
			detalleCapaVirtual: null,
			fechaIniProgramada: null,
			fechaFinProgramada: null,
			fechaSoli: null,
			fechaSoliJUD: $scope.firstDateNextMonth(new Date()),
			fechaInicJUD: $scope.firstDateNextMonth(new Date()),
			fechaFinJUD: $scope.firstDateNextMonth(new Date()),
			stdIddoc: null,
			stdNumeroSid: null,
			stdNumeroAnio: null,
			stdNumeroDoc: null,
			stdAsunto: null,
			stdTipoDoc: null,
			stdFechaRecepcion: null,
			stdModalidadIng: null,
			flagEjec: null,
			motivoEjec: null,
			idOrigen: 140,
			
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
			dtCapaTemasBkJSss: [],
			dtCapaEntidadesBkJSss: [],
			dtCapaPublicoBkJSss: [],
		    editopcion: 1
		};
	//MPINARES 14022024 - FIN
	  
	  $scope.cleardtCapacitacion = function(){
		    $scope.dtCapacitacionModelo.idCapacitacion = null;
		    $scope.dtCapacitacionModelo.fechaInic = new Date();$scope.dtCapacitacionModelo.fechaFin = new Date();$scope.dtCapacitacionModelo.nomEvento = null;
		    $scope.dtCapacitacionModelo.idSistAdm = null;
		    $scope.dtCapacitacionModelo.idUsuinterno = null;
		    $scope.dtCapacitacionModelo.flagPubli = null;
		    $scope.dtCapacitacionModelo.idModalidad = null;
		    $scope.dtCapacitacionModelo.idProgramacion = null;
		    $scope.dtCapacitacionModelo.estado = null;
		    $scope.dtCapacitacionModelo.cantPartic = null;
		    $scope.dtCapacitacionModelo.publicObj = null;
		    $scope.dtCapacitacionModelo.detalleCapa = null;
		    $scope.dtCapacitacionModelo.idLocal = null;
		    $scope.dtCapacitacionModelo.idModo = null;
		    $scope.dtCapacitacionModelo.idNivel = null;
		    $scope.dtCapacitacionModelo.idOrigen = null;
		    $scope.dtCapacitacionModelo.idPrestacion = null;
		    $scope.dtCapacitacionModelo.cantParticAsist = null;
		    $scope.dtCapacitacionModelo.idTipo = null;
		    $scope.dtCapacitacionModelo.idcapaPadre = null;
		    $scope.dtCapacitacionModelo.idSede = null;
		    $scope.dtCapacitacionModelo.idFinancia = null;
		    $scope.dtCapacitacionModelo.fechaFinalizacion = new Date();$scope.dtCapacitacionModelo.detalleCapaVirtual = null;
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
	            $scope.dtCapacitacionModelo.idSistAdmTxt = null;
$scope.dtCapacitacionModelo.idUsuinternoTxt = null;
$scope.dtCapacitacionModelo.idModalidadTxt = null;
$scope.dtCapacitacionModelo.idProgramacionTxt = null;
$scope.dtCapacitacionModelo.estadoTxt = null;
$scope.dtCapacitacionModelo.idLocalTxt = null;
$scope.dtCapacitacionModelo.idModoTxt = null;
$scope.dtCapacitacionModelo.idNivelTxt = null;
$scope.dtCapacitacionModelo.idOrigenTxt = null;
$scope.dtCapacitacionModelo.idPrestacionTxt = null;
$scope.dtCapacitacionModelo.idTipoTxt = null;
$scope.dtCapacitacionModelo.idSedeTxt = null;
$scope.dtCapacitacionModelo.idFinanciaTxt = null;
//MPINARES 14022024 - INICIO
$scope.dtCapacitacionModelo.dtCapaTemasBkJSss= [];
$scope.dtCapacitacionModelo.dtCapaEntidadesBkJSss= [];
$scope.dtCapacitacionModelo.dtCapaPublicoBkJSss= [];
//MPINARES 14022024 - FIN

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
$scope.dtCapacitacionModelo.nomEvento = dtCapacitacionBk.nomEvento;
			$scope.dtCapacitacionModelo.idSistAdm = dtCapacitacionBk.idSistAdm;
			$scope.dtCapacitacionModelo.idUsuinterno = dtCapacitacionBk.idUsuinterno;
			$scope.dtCapacitacionModelo.flagPubli = dtCapacitacionBk.flagPubli;
			$scope.dtCapacitacionModelo.idModalidad = dtCapacitacionBk.idModalidad;
			$scope.dtCapacitacionModelo.idProgramacion = dtCapacitacionBk.idProgramacion;
			$scope.dtCapacitacionModelo.estado = dtCapacitacionBk.estado;
			$scope.dtCapacitacionModelo.cantPartic = dtCapacitacionBk.cantPartic;
			$scope.dtCapacitacionModelo.publicObj = dtCapacitacionBk.publicObj;
			$scope.dtCapacitacionModelo.detalleCapa = dtCapacitacionBk.detalleCapa;
			$scope.dtCapacitacionModelo.idLocal = dtCapacitacionBk.idLocal;
			$scope.dtCapacitacionModelo.idModo = dtCapacitacionBk.idModo;
			$scope.dtCapacitacionModelo.idNivel = dtCapacitacionBk.idNivel;
			$scope.dtCapacitacionModelo.idOrigen = dtCapacitacionBk.idOrigen;
			$scope.dtCapacitacionModelo.idPrestacion = dtCapacitacionBk.idPrestacion;
			$scope.dtCapacitacionModelo.cantParticAsist = dtCapacitacionBk.cantParticAsist;
			$scope.dtCapacitacionModelo.idTipo = dtCapacitacionBk.idTipo;
			$scope.dtCapacitacionModelo.idcapaPadre = dtCapacitacionBk.idcapaPadre;
			$scope.dtCapacitacionModelo.idSede = dtCapacitacionBk.idSede;
			$scope.dtCapacitacionModelo.idFinancia = dtCapacitacionBk.idFinancia;
			$scope.dtCapacitacionModelo.fechaFinalizacion = dtCapacitacionBk.fechaFinalizacion;
                        if(!$scope.isNull($scope.dtCapacitacionModelo.fechaFinalizacion) && !isNaN($scope.dtCapacitacionModelo.fechaFinalizacion)){
			    $scope.dtCapacitacionModelo.fechaFinalizacion = new Date($scope.dtCapacitacionModelo.fechaFinalizacion);
		        }
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
                        
                      //MPINARES 14022024 - INICIO       
                        $scope.dtCapacitacionModelo.fechaSoliJUD = dtCapacitacionBk.fechaSoliJUD;
                               if(!$scope.isNull($scope.dtCapacitacionModelo.fechaSoliJUD) && !isNaN($scope.dtCapacitacionModelo.fechaSoliJUD)){
       			    $scope.dtCapacitacionModelo.fechaSoliJUD = new Date($scope.dtCapacitacionModelo.fechaSoliJUD);
       		        }
                               $scope.dtCapacitacionModelo.fechaInicJUD = dtCapacitacionBk.fechaInicJUD;
                               if(!$scope.isNull($scope.dtCapacitacionModelo.fechaInicJUD) && !isNaN($scope.dtCapacitacionModelo.fechaInicJUD)){
       			    $scope.dtCapacitacionModelo.fechaInicJUD = new Date($scope.dtCapacitacionModelo.fechaInicJUD);
       		        }
                               $scope.dtCapacitacionModelo.fechaFinJUD = dtCapacitacionBk.fechaFinJUD;
                               if(!$scope.isNull($scope.dtCapacitacionModelo.fechaFinJUD) && !isNaN($scope.dtCapacitacionModelo.fechaFinJUD)){
       			    $scope.dtCapacitacionModelo.fechaFinJUD = new Date($scope.dtCapacitacionModelo.fechaFinJUD);
       		        }
                             //MPINARES 14022024 - FIN  
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
	                $scope.dtCapacitacionModelo.idSistAdmTxt = dtCapacitacionBk.idSistAdmTxt;
$scope.dtCapacitacionModelo.idUsuinternoTxt = dtCapacitacionBk.idUsuinternoTxt;
$scope.dtCapacitacionModelo.idModalidadTxt = dtCapacitacionBk.idModalidadTxt;
$scope.dtCapacitacionModelo.idProgramacionTxt = dtCapacitacionBk.idProgramacionTxt;
$scope.dtCapacitacionModelo.estadoTxt = dtCapacitacionBk.estadoTxt;
$scope.dtCapacitacionModelo.idLocalTxt = dtCapacitacionBk.idLocalTxt;
$scope.dtCapacitacionModelo.idModoTxt = dtCapacitacionBk.idModoTxt;
$scope.dtCapacitacionModelo.idNivelTxt = dtCapacitacionBk.idNivelTxt;
$scope.dtCapacitacionModelo.idOrigenTxt = dtCapacitacionBk.idOrigenTxt;
$scope.dtCapacitacionModelo.idPrestacionTxt = dtCapacitacionBk.idPrestacionTxt;
$scope.dtCapacitacionModelo.idTipoTxt = dtCapacitacionBk.idTipoTxt;
$scope.dtCapacitacionModelo.idSedeTxt = dtCapacitacionBk.idSedeTxt;
$scope.dtCapacitacionModelo.idFinanciaTxt = dtCapacitacionBk.idFinanciaTxt;

//MPINARES 14022024 - INICIO
$scope.dtCapacitacionModelo.dtCapaTemasBkJSss = dtCapacitacionBk.dtCapaTemasBkJSss;
if(dtCapacitacionBk.dtCapaTemasBkJSss!=null && dtCapacitacionBk.dtCapaTemasBkJSss.length>0){
	$scope.datoCapasTema = $scope.dtCapacitacionModelo.dtCapaTemasBkJSss;
}else{
	$scope.datoCapasTema = [];
}
$scope.dtCapacitacionModelo.dtCapaEntidadesBkJSss = dtCapacitacionBk.dtCapaEntidadesBkJSss;
if(dtCapacitacionBk.dtCapaEntidadesBkJSss!=null && dtCapacitacionBk.dtCapaEntidadesBkJSss.length>0){
	$scope.datoCapaEntidades = $scope.dtCapacitacionModelo.dtCapaEntidadesBkJSss;
}else{
	$scope.datoCapaEntidades = [];
}
$scope.dtCapacitacionModelo.dtCapaPublicoBkJSss = dtCapacitacionBk.dtCapaPublicoBkJSss;
if(dtCapacitacionBk.dtCapaPublicoBkJSss!=null && dtCapacitacionBk.dtCapaPublicoBkJSss.length>0){
	$scope.datoCapaPublico = [];
	for(var i = 0; i < dtCapacitacionBk.dtCapaPublicoBkJSss.length; i++)
	{
		var capaPublico = dtCapacitacionBk.dtCapaPublicoBkJSss[i];
		$scope.addCapaPublico(capaPublico, i, dtCapacitacionBk.dtCapaPublicoBkJSss.length);
	}
}
//MPINARES 14022024 - FIN

			$scope.dtCapacitacionModelo.editopcion = dtCapacitacionBk.dtCapacitacionACL.editopcion;
			$scope.dtCapacitacionModelo.addEntidad = dtCapacitacionBk.dtCapacitacionACL.addEntidad;
		}
	  
	//MPINARES 14022024 - INICIO
		$scope.addCapaPublico = function (capaPublico, i, size) {
			var addx=false;
			if(i+1==size){
				addx= true;
			}else{
				addx= false;
			}
			$scope.datoCapaPublico.push({
				contador: i+ 1, 
				idCapaPublico: capaPublico.idCapaPublico,
				idCargo: capaPublico.idCargo, 
				add: addx

			})

		};
	//MPINARES 14022024 - FIN
	  // ////////////////////////////////////////////////
	  $scope.editarDtCapacitacion = function(ev, dtCapacitacionBk) {		  
		    $scope.setDtCapacitacionModelo(dtCapacitacionBk);		  
			$location.url('/editar/' + $scope.dtCapacitacionModelo.idCapacitacion);
			$scope.nuevo = false;
	  }
	  
	  $scope.nuevoDtCapacitacion = function() {
		    $scope.cleardtCapacitacion();

		   // $scope.loadlistamstema();
		  //  $scope.loadlistamsusuarios();
		    $scope.rangeYearIni();
		    
		    
			$location.url('/nuevo');
			$scope.nuevo = true;
	  }
	  	  
	  $scope.cancelarDtCapacitacion = function() {
		    $scope.cleardtCapacitacion();
		    $location.url('/');
	  }
	  
	  $scope.handleremover = function(pos){
			$scope.archivos.splice(pos,1);			  
	  }
	  
	  $scope.$on("fileSelected", function (event, args) {
			$scope.$apply(function () {
				console.log("PROBANDO ENVIAR EL ARCHIVO:" +JSON.stringify( args ) );           
				$scope.archivos.push(args);	            
				var pos = $scope.archivos.length-1;
				fileUploadSrv.uploadFileToUrl(pos,$scope.archivos[pos],insertDocUrl);
			});
	  });
	  		
	 /* $scope.salvarDtCapacitacionTest = function(ev){	
		  
		  console.log( "$scope.archivos:"+ JSON.stringify( $scope.archivos ));
		  
	  }*/
	  
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
					
					$scope.dtCapacitacionModelo.tdAnexosJSss = $scope.archivos;
				}}
	  }	
	  
	  $scope.removePropertiesFromList = function(list, properties) {
          return list.map(function(item) {
              properties.forEach(function(property) {
                  delete item[property];
              });
              return item;
          });
};
	  
	  $scope.addTema= function(){	
		  var propertiesToRemove = ['contador', 'add'];
		  
		  if($scope.isArray($scope.datoCapasTema)){
				if($scope.datoCapasTema.length>0) {
					
					$scope.dtCapacitacionModelo.dtCapaTemasBkJSss =  $scope.removePropertiesFromList(angular.copy($scope.datoCapasTema), propertiesToRemove);
					
					console.log("$scope.dtCapacitacionModelo.dtCapaTemasBkJSss:" + JSON.stringify($scope.dtCapacitacionModelo.dtCapaTemasBkJSss));
					
				}
			}
		  
		  
	  }
	  
	  $scope.salvarDtCapacitacion = function(ev){	
		  
		  $scope.uploadFileTotdAnexoJsModel();
		  
		
		  if($scope.isArray($scope.datoCapaPublico)){
				if($scope.datoCapaPublico.length>0){
					$scope.dtCapacitacionModelo.dtCapaPublicoBkJSss = $scope.datoCapaPublico;
				}};
		  if($scope.isArray($scope.datoCapaEntidades)){
				if($scope.datoCapaEntidades.length>0){
					$scope.dtCapacitacionModelo.dtCapaEntidadesBkJSss = $scope.datoCapaEntidades;
				}};
				
				$scope.addTema();
				
				    ev.target.disabled = true;
				    var datainsert = angular.toJson($scope.dtCapacitacionModelo);
		 			console.log("datainsert = "+datainsert);	
		        		$http.post(insertdtCapacitacionNoProgUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
							var dato = res.data;

//		    				$scope.datos.push(dato); 
		    				$scope.total = $scope.datos.length;
		    				
		    				$scope.setDtCapacitacionModelo(dato);
		    				
		    				$mdDialog.show(
							         $mdDialog.alert()
							        .parent(angular.element(document.body))
							        .clickOutsideToClose(true)
							        .title('Guardar capacitaciones')
							        .textContent("Capacitaciones se guardó correctamente.")
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
			if(typeof(dato) != 'undefined'){
				            	$mdDialog.show(
								         $mdDialog.alert()
								        .parent(angular.element(document.body))
								        .clickOutsideToClose(true)
								        .title('Guardar capacitaciones')
								        .textContent(dato.message)
								        .ariaLabel('ERROR')
								        .ok('ACEPTAR')
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
		 			console.log("Eliminar = "+datainsert);	
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
					        .title('Eliminar capacitaciones')
					        .textContent(dato)
					        .ariaLabel('ERROR')
					        .ok('ACEPTAR')
					        .targetEvent(ev)
						   );
			            }
			        });			        			        	
		        	ev.target.disabled = false;
			 };

            $scope.activardtCapacitacion = function(ev,dtCapacitacionBk){		
				    ev.target.disabled = true;
				    $scope.setDtCapacitacionModelo(dtCapacitacionBk);
				    var datainsert = angular.toJson($scope.dtCapacitacionModelo);
		 			console.log("Activar = "+datainsert);	
	        		$http.post(activardtCapacitacionUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
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
					        .title('Activar capacitaciones')
					        .textContent(dato)
					        .ariaLabel('ERROR')
					        .ok('ACEPTAR')
					        .targetEvent(ev)
						   );
			            }
			        });			        			        	
		        	ev.target.disabled = false;
			 };

            $scope.eliminarListadtCapacitacion = function(ev){		
				    ev.target.disabled = true;
                                   
                                    if(!$scope.isArray($scope.selected) || $scope.selected.length<=0){
				    	$mdDialog.show(
								$mdDialog.alert()
								.parent(angular.element(document.body))
								.clickOutsideToClose(true)
								.title('Eliminar')
								.textContent("No se ha seleccionado registros para eliminar... ")
								.ariaLabel('ERROR')
								.ok('ACEPTAR')
								.targetEvent(ev)
						);
				    	ev.target.disabled = false;
					return;
				    }else{
                                        for (var i = 0; i < $scope.selected.length; i++) {
				             listaids.push($scope.selected[i].idCapacitacion);
			                 }
                                    } 
				    
				    var datainsert = angular.toJson(listaids);
		 			console.log("Elimiar = "+datainsert);	
	        		$http.post(eliminarListadtCapacitacionUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
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
			if(typeof(dato) != 'undefined'){
			            	$mdDialog.show(
					         $mdDialog.alert()
					        .parent(angular.element(document.body))
					        .clickOutsideToClose(true)
					        .title('Eliminar capacitaciones')
					        .textContent(dato)
					        .ariaLabel('ERROR')
					        .ok('ACEPTAR')
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
					        .title('Cargar capacitaciones')
					        .textContent(dato)
					        .ariaLabel('ERROR')
					        .ok('ACEPTAR')
						   );
			            }			           
			        });			        			        	
			 };
			 
		$scope.showConfirm = function(ev, dtCapacitacionBk) {
				    var confirm = $mdDialog.confirm()
				      .title('Activar capacitaciones')
				      .textContent('¿Está usted seguro de activar el registro?')
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
				  
//MPINARES 14022024 - INICIO
				  

				    
				    //***********************************************************************************************
				    $scope.datoCapaPublico = [];
//				    $scope.datoCapaPublico = [
//					{contador: 1, idCapaPublico: $scope.generateRandomInteger(1000)*-1, idCargo: "",  searchText: null, add: true}
//			    ];
				    
				    $scope.nuevoCapaPublico= function (ev,dato) {
				    	if(dato.idCargo!=null && dato.idCargo>0){
//				    		var datoactual = Object.assign({}, dato);
//							datoactual.idCapaPublico = $scope.generateRandomInteger(1000)*-1;
//				    		datoactual.contador = $scope.datoCapaPublico.length + 1;
//				    		datoactual.idCargo = "";
//				    		datoactual.searchText = null;
//				    		datoactual.add = false;
//				    		$scope.datoCapaPublico.push(datoactual);	
//				    		$scope.datoCapaPublico.push({
//					        	contador: $scope.datoCapaPublico.length + 1,
//					        	idCapaPublico: $scope.generateRandomInteger(1000)*-1,
//					        	idCargo: "", 
//					        	searchText: null,
//					            add: false
//					        })
				    		ev.target.disabled = true;
				    		var datoactual = Object.assign({}, $scope.capaPublicomodelo);
				    		datoactual.idCapaPublico = $scope.generateRandomInteger(1000)*-1;
				    		datoactual.contador = $scope.datoCapaPublico.length + 1;
				    		datoactual.idCargo = $scope.capaPublicomodelo.idCargo;
				    		datoactual.idCargoTxt = $scope.capaPublicomodelo.idCargoTxt;
				    		$scope.datoCapaPublico.push(datoactual);
				    		$scope.clearCapaPublicomodelo();
//					        $scope.settingFlagAddAndRemoveDetCapaPublico();
				    	}else{
					    	$mdDialog.show(
									$mdDialog.alert()
									.parent(angular.element(document.body))
									.clickOutsideToClose(true)
									.title('Público objetivo')
									.textContent("Debe seleccionar el público objetivo... ")
									.ariaLabel('ERROR')
									.ok('ACEPTAR')
									.targetEvent(ev)
							);
					    	ev.target.disabled = false;
						return;
				    	} 
				    }
				    
				    $scope.settingFlagAddAndRemoveDetCapaPublico = function () {
				        let sizeTemas = $scope.datoCapaPublico.length;
				        $scope.datoCapaPublico.map(function (obj) {

				        	if (obj.contador == sizeTemas) {
				                obj.add = true;
				            } else {
				                obj.add = false;
				            }

				        });
				    }
				    
				    $scope.removeCapaPublico = function (ev,dato) {
				    	if(dato.idCapaPublico!=null && dato.idCapaPublico>0){
//				    		$scope.showConfirmDeleteAsistenciaTema(ev, dato);
				    	}else{
				    		$scope.datoCapaPublico = $scope.datoCapaPublico.filter(val => val.contador !== dato.contador);
				    	} 
				    }
				  //***********************************************************************************************
				    $scope.datoCapasTema = [];
//						{contador: 1, idCapaTemAgen: "", idTema: "", idSubtema: "",  add: true}
//				    ];
				    
					 $scope.nuevoCapasTemas= function () {
					        $scope.datoCapasTema.push({
					        	contador: $scope.datoCapasTema.length + 1,
					        	idCapaTemAgen: "",
					        	idTema: "", 
					        	idSubtema: "",	           
					            add: false
					        })

					        $scope.settingFlagAddAndRemoveDetCapasTema();
					    }
				    
					$scope.settingFlagAddAndRemoveDetCapasTema = function () {
				        let sizeTemas = $scope.datoCapasTema.length;
				        $scope.datoCapasTema.map(function (obj) {

				        	if (obj.contador == sizeTemas) {
				                obj.add = true;
				            } else {
				                obj.add = false;
				            }

				        });
				    }
					
					$scope.removeCapasTema = function (ev,dato) {
						$scope.showConfirmDeleteCapaTemas(ev, dato);
				    }
					
					$scope.showConfirmDeleteCapaTemas = function(ev, dtCapaTemasBk) {
					    var confirm = $mdDialog.confirm()
					      .title('Temas agendados')
					      .textContent('¿Estás seguro que deseas eliminar el registro?')
					      .ariaLabel('Lucky day')
					      .targetEvent(ev)
					      .ok('Si')
					      .cancel('No');

					    $mdDialog.show(confirm).then(function () {
					    	
					    	if(dtCapaTemasBk.idCapaTemAgen!=null && dtCapaTemasBk.idCapaTemAgen>0) {
					    		
					    		  $scope.status = 'SI';
							      $scope.clearCapaTemasmodelo();
							      $scope.setCapaTemasmodelo(dtCapaTemasBk);
							      $scope.eliminardtCapaTemas(ev, $scope.capaTemasmodelo);
							      
					    	} else { 
					    		$scope.datoCapasTema = $scope.datoCapasTema.filter(val => val.idCapaTemAgen !== dtCapaTemasBk.idCapaTemAgen);
					    		//$scope.datoAsistenciaTema = $scope.datoAsistenciaTema.filter(val => val.idAsistTema !== dato.idAsistTema);
					    	} 
					    	
					    }, function () {
					      $scope.status = 'NO';
					    });
					  };
					  
					  $scope.eliminardtCapaTemas = function(ev,dtCapaTemasBk){		
						    ev.target.disabled = true;
						    var datainsert = angular.toJson(dtCapaTemasBk);
							console.log("datainsert = "+datainsert);	
						$http.post(eliminardtCapaTemasUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
								var dato = res.data;
								var instrumentos = $scope.datos;
						        var index = $scope.datos.findIndex(obj => obj.idCapaTemAgen === dato.idCapaTemAgen);
								console.log("INDEX " + index);
						        if(instrumentos.length>index){
						        	instrumentos.splice(index, 1);
							        $scope.datos = instrumentos;
							        $scope.total = $scope.datos.length;
						        }	
						        $scope.editdtCapacitacion();
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
					
					//***********************************************************************************************
					$scope.datoCapaEntidades= [];
//						{contador: 1, idCapaEnti: "", idEntidad: "", codEjecutora: "",idEntidadTxt: "",  add: true}
//				    ];
				    
					 $scope.nuevoCapaEntidades= function () {
					        $scope.datoCapaEntidades.push({
					        	contador: $scope.datoCapaEntidades.length + 1,
					        	idCapaEnti: "",
					        	idEntidad: "", 
					        	codEjecutora: "",	
					        	idEntidadTxt: "",          
					            add: false
					        })

					        $scope.settingFlagAddAndRemoveDetCapaEntidades();
					    }
				    
					$scope.settingFlagAddAndRemoveDetCapaEntidades = function () {
				        let sizeTemas = $scope.datoCapaEntidades.length;
				        $scope.datoCapaEntidades.map(function (obj) {

				        	if (obj.contador == sizeTemas) {
				                obj.add = true;
				            } else {
				                obj.add = false;
				            }

				        });
				    }
					
					$scope.removeCapaEntidades = function (ev,dato) {
						$scope.showConfirmDeleteCapaEntidades(ev, dato);			
//				    	if(dato.idCapaEnti!=null && dato.idCapaEnti>0){
//				    		$scope.showConfirmDeleteCapaEntidades(ev, dato);
//				    	}else{
//				    		$scope.datoCapaEntidades = $scope.datoCapaEntidades.filter(val => val.idCapaEnti !== dato.idCapaEnti);
//				    	} 
				    }
					
					$scope.showConfirmDeleteCapaEntidades = function(ev, dtCapaEntidadesBk) {
					    var confirm = $mdDialog.confirm()
					      .title('Entidades agregadas')
					      .textContent('¿Estás seguro que deseas eliminar el registro?')
					      .ariaLabel('Lucky day')
					      .targetEvent(ev)
					      .ok('Si')
					      .cancel('No');

					    $mdDialog.show(confirm).then(function () {
					    	if(dtCapaEntidadesBk.idCapaEnti!=null && dtCapaEntidadesBk.idCapaEnti>0){
//					    		$scope.showConfirmDeleteCapaEntidades(ev, dato);
					    		 $scope.status = 'SI';
							      $scope.clearCapaEntidadmodelo();
							      $scope.setCapaEntidadmodelo(dtCapaEntidadesBk);
							      $scope.eliminardtCapaEntidades(ev, $scope.capaEntidadmodelo);
					    	}else{
					    		$scope.datoCapaEntidades = $scope.datoCapaEntidades.filter(val => val.idCapaEnti !== dtCapaEntidadesBk.idCapaEnti);
					    	} 
					    }, function () {
					      $scope.status = 'NO';
					    });
					  };
					  
					  $scope.eliminardtCapaEntidades = function(ev,dtCapaEntidadesBk){		
						    ev.target.disabled = true;
						    var datainsert = angular.toJson(dtCapaEntidadesBk);
							console.log("datainsert = "+datainsert);	
						$http.post(eliminardtCapaEntidadesUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
								var dato = res.data;
								var instrumentos = $scope.datos;
						        var index = $scope.datos.findIndex(obj => obj.idCapaEnti === dato.idCapaEnti);
								console.log("INDEX " + index);
						        if(instrumentos.length>index){
						        	instrumentos.splice(index, 1);
							        $scope.datos = instrumentos;
							        $scope.total = $scope.datos.length;
						        }	
						        $scope.editdtCapacitacion();
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
					
					//***********************************************************************************************
					
					//AUTOCOMPLETE INI
			    	$scope.ctrlMsInstitucionesIdprovee={
			    			simulateQuery: false,
			    			isDisabled: false,
			    			selectedItem: null
			    	};

			    	$scope.newStateMsInstitucionesIdprovee=function(state) {
			    		console.log("¡Lo siento! ¡Primero tendrás que crear una Entidada para " + state+"! ");
			    	}

			    	$scope.listaMsInstitucionesIdprovee=[];
			    	$scope.querySearchMsInstitucionesIdprovee = function(query) {
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
			    		if($scope.isObject(item)) {
			    			console.log('Item changed to ' + JSON.stringify(item));
			    			
			    			$scope.usuarioModelo.codEjecutora = item.codEjec; 
			                $scope.usuarioModelo.idEntidadTxt = item.razSocialUbigeo;
			                $scope.usuarioModelo.idEntidad = item.idEntidad;
			    			
			    		}
			    	}
//			    	AUTOCOMPLETE FIN
			    	
			    	//***********************************************************************************************
			    	//***********************************************************************************************
			    	
			    	$scope.capaPublicomodelo = {
			    			contador: null,
			    			idCapaPublico: null,
			    			idCargo: null,
			    			idCargoTxt: null,
			    			add: null
					};
			    	
			    	$scope.clearCapaPublicomodelo= function(){
						$scope.capaPublicomodelo.contador= null;
						$scope.capaPublicomodelo.idCapaPublico= null;
						$scope.capaPublicomodelo.idCargo= null;
						$scope.capaPublicomodelo.idCargoTxt= null;
						$scope.capaPublicomodelo.add= null;
					};
					
					//AUTOCOMPLETE PUBLICO INI
			    	$scope.ctrlDtcapaPublico={
			    			simulateQuery: false,
			    			isDisabled: false,
			    			selectedItem: null
			    	};

			    	$scope.searchTextChangeDtcapaPublico = function(text) {
			    		console.log('Text changed to ' + text);
			    	}
			    	
			    	$scope.querySearchDtcapaPublico = function (query) {
//			    		var upperCaseQuery = query.toUpperCase();
			    		var results = null;
			    	    results = query ? $scope.listaPrtParametrosIdPublico.filter($scope.createFilterFor(query)) : $scope.listaPrtParametrosIdPublico;
			    	      return results;
			    	    }

			    	$scope.selectedItemChangeDtcapaPublico = function(item) {
			    		if($scope.isObject(item)){
			    			console.log('Item changed to ' + JSON.stringify(item));
			    			$scope.capaPublicomodelo.idCargo = item.id;
			    			$scope.capaPublicomodelo.idCargoTxt = item.valor;
			    		}
			    	}
			    	
			    	$scope.createFilterFor = function (query) {
			    	      var upperCaseQuery = query.toUpperCase();
			    	      return function filterFn(item) {
			    	        return (item.valor.indexOf(upperCaseQuery) === 0);
			    	      };

			    	    }
			    	
			    	
//			    	AUTOCOMPLETE PUBLICO FIN
			    	
			    	//***********************************************************************************************
				    
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
				       
				        $scope.$watch('dtCapacitacionModelo.idTema', function (newValue, oldValue) {
						console.log('dtCapacitacionModelo.idTema ' + newValue+' -- '+oldValue);
					});
				        
				        $scope.changeIdCargo=function(idCargo){
				        	
				        	var cargo = $scope.listaCargos.find(c=>c.idCargo === idCargo);
				        	
				        	$scope.usuarioModelo.idCargoTxt = cargo.idCargoTxt;
				        	
				        	
				        	/*if($scope.datoCapaPublico.length > 1){
				        		if ($scope.datoCapaPublico.filter(e => e.idCargo === dato.idCargo).length > 1) {
				        			dato.idCargo="";
									$mdDialog.show(
											$mdDialog.alert()
											.parent(angular.element(document.body))
											.clickOutsideToClose(true)
											.title('Público objetivo')
											.textContent("El Público objetivo seleccionado ya existe")
											.ariaLabel('Lucky day')
											.ok('ACEPTAR')
									);
									ev.target.disabled = false;
									return;
									}
				        	
					        }*/
				        }
				        	
     
				      //SELECT INI
				        $scope.listaPrtParametrosIdPublico=[];
					$scope.loadListaPrtParametrosIdPublico=function(){
						$http.get(listaPrtParametrosidparametroIdPublicoUrl).then(function(res){
							$scope.listaPrtParametrosIdPublico = res.data; 
						},
						function error(errResponse) {
							console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
						});
					};
				        $scope.changeIdPublico=function(){
				          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
				        }
				        $scope.$watch('dtCapacitacionModelo.idModalidad', function (newValue, oldValue) {
						console.log('dtCapacitacionModelo.idModalidad ' + newValue+' -- '+oldValue);
						//CARGAR DATOS DEL SIGUIENTE SELECT
					});
				//SELECT FIN
				      //SELECT INI
				        $scope.listaProcedeEjecucion=[];
					$scope.loadListaProcedeEjecucion=function(){
						$http.get(listaProcedeEjecucionUrl).then(function(res){
							$scope.listaProcedeEjecucion = res.data; 
						},
						function error(errResponse) {
							console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
						});
					};
				        $scope.changelistaProcedeEjecucion=function(){
				          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
				        }
				        $scope.$watch('dtCapacitacionModelo.idModalidad', function (newValue, oldValue) {
						console.log('dtCapacitacionModelo.idModalidad ' + newValue+' -- '+oldValue);
						//CARGAR DATOS DEL SIGUIENTE SELECT
					});
				//SELECT FIN 
//MPINARES 14022024 - FIN

                $scope.showConfirmActivar = function(ev, dtCapacitacionBk) {
				    var confirm = $mdDialog.confirm()
				      .title('Activar capacitaciones')
				      .textContent('¿Está usted seguro de activar el registro?')
				      .ariaLabel('Lucky day')
				      .targetEvent(ev)
				      .ok('Si')
				      .cancel('No');

				    $mdDialog.show(confirm).then(function () {
				      $scope.status = 'SI';
				      $scope.activardtCapacitacion(ev, dtCapacitacionBk);
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
								.textContent("No se ha seleccionado registros para eliminar... ")
								.ariaLabel('ERROR')
								.ok('ACEPTAR')
								.targetEvent(ev)
						);
				    	return;
				    }else{
                                       tamanio = $scope.selected.length;
                                    }

				    var confirm = $mdDialog.confirm()
				      .title('Eliminar capacitaciones')
				      .textContent('¿Está usted seguro de eliminar los '+tamanio+' registros seleccionados?')
				      .ariaLabel('Lucky day')
				      .targetEvent(ev)
				      .ok('Si')
				      .cancel('No');

				    $mdDialog.show(confirm).then(function () {
				      $scope.status = 'SI';
				      $scope.eliminarListadtCapacitacion(ev);
				    }, function () {
				      $scope.status = 'NO';
				    });
				  };		  
///ADICIONALES
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
        $scope.changeRadioIdModalidad=function(idModalidad){
          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
        	if(idModalidad!=null && idModalidad==137){
        		$scope.dtCapacitacionModelo.idLocal = null;
        	}
        	if(idModalidad!=null && idModalidad==138){
        		$scope.dtCapacitacionModelo.detalleCapaVirtual = null;
        	}
        }
        $scope.$watch('dtCapacitacionModelo.idModalidad', function (newValue, oldValue) {
		console.log('dtCapacitacionModelo.idModalidad ' + newValue+' -- '+oldValue);
		//CARGAR DATOS DEL SIGUIENTE SELECT
//	if($scope.isArray($scope.listaPrtParametrosIdModalidad)){
//		var obj = $scope.listaPrtParametrosIdModalidad.find(o => o.id === newValue);
//		if($scope.isObject(obj)){
//			$scope.prtParametrosModelo.idparametroTxt = obj.valor;
//		}
//	}
	});
//SELECT FIN                
//SELECT INI
        $scope.listaMsLocalIdLocal=[];
	$scope.loadListaMsLocalIdLocal=function(){
		$http.get(listaMsLocalidLocalIdLocalUrl).then(function(res){
			$scope.listaMsLocalIdLocal = res.data; 
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
        $scope.changeIdLocal=function(){
          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
        }
        $scope.$watch('dtCapacitacionModelo.idLocal', function (newValue, oldValue) {
		console.log('dtCapacitacionModelo.idLocal ' + newValue+' -- '+oldValue);
	});

        $scope.listaPrtParametrosIdModo=[];
	$scope.loadListaPrtParametrosIdModo=function(){
		$http.get(listaPrtParametrosidparametroIdModoUrl).then(function(res){
			$scope.listaPrtParametrosIdModo = res.data; 
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
        $scope.changeIdModo=function(idModo){
          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
        	if(idModo!=null && idModo==93){
        		$scope.dtCapacitacionModelo.idModalidad = null;
        		$scope.dtCapacitacionModelo.idLocal = null;
        		$scope.dtCapacitacionModelo.nomEvento = null;
        		$scope.dtCapacitacionModelo.cantPartic = null;
        		$scope.dtCapacitacionModelo.idNivel = null;
        		$scope.dtCapacitacionModelo.idPrestacion = null;
        		$scope.dtCapacitacionModelo.idTipo = null;
        	}
        }
        
        $scope.$watch('dtCapacitacionModelo.idModo', function (newValue, oldValue) {
		console.log('dtCapacitacionModelo.idModo ' + newValue+' -- '+oldValue);
	});
//SELECT FIN                
//SELECT INI
        $scope.listaPrtParametrosIdNivel=[];
	$scope.loadListaPrtParametrosIdNivel=function(){
		$http.get(listaPrtParametrosidparametroIdNivelUrl).then(function(res){
			$scope.listaPrtParametrosIdNivel = res.data; 
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
        $scope.changeIdNivel=function(){
          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
        }
        $scope.$watch('dtCapacitacionModelo.idNivel', function (newValue, oldValue) {
		console.log('dtCapacitacionModelo.idNivel ' + newValue+' -- '+oldValue);
	});
//SELECT FIN                
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
        $scope.$watch('dtCapacitacionModelo.idOrigen', function (newValue, oldValue) {
		console.log('dtCapacitacionModelo.idOrigen ' + newValue+' -- '+oldValue);
	});
//SELECT FIN                
//SELECT INI
        $scope.listaPrtParametrosIdPrestacion=[];
	$scope.loadListaPrtParametrosIdPrestacion=function(){
		$http.get(listaPrtParametrosidparametroIdPrestacionUrl).then(function(res){
			$scope.listaPrtParametrosIdPrestacion = res.data; 
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
        $scope.changeIdPrestacion=function(){
          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
        }
        $scope.$watch('dtCapacitacionModelo.idPrestacion', function (newValue, oldValue) {
		console.log('dtCapacitacionModelo.idPrestacion ' + newValue+' -- '+oldValue);
	});
//SELECT FIN                
//SELECT INI
        $scope.listaPrtParametrosIdTipo=[];
	$scope.loadListaPrtParametrosIdTipo=function(){
		$http.get(listaPrtParametrosidparametroIdTipoUrl).then(function(res){
			$scope.listaPrtParametrosIdTipo = res.data; 
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
        $scope.changeIdTipo=function(){
          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
        }
        $scope.$watch('dtCapacitacionModelo.idTipo', function (newValue, oldValue) {
		console.log('dtCapacitacionModelo.idTipo ' + newValue+' -- '+oldValue);
	});
//SELECT FIN                
//SELECT INI
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
          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
        }
        $scope.$watch('dtCapacitacionModelo.idFinancia', function (newValue, oldValue) {
		console.log('dtCapacitacionModelo.idFinancia ' + newValue+' -- '+oldValue);
	});
//SELECT FIN                


//DESCARGAR
    	$scope.descargar = function(){
    		return descargarUrl+$scope.getURLParametros();
    	}
    	
    	// CHECKBOX - PARTICIPANTES
    	
    	$scope.selectAll = false;

    	$scope.toggleAll = function(selectAll) {
    	    angular.forEach($scope.datoUsuario, function(dato) {
    	        dato.checked = selectAll;
    	        $scope.selection(dato);
    	    });
    	};
    	
    	 $scope.selectedParticipantes = [];
    	 
		  $scope.selection = function(participante){
			  
			    if(participante.checked){
			    	$scope.selectedParticipantes.push({
			    		/*idAsistencia: asistencia.idAsistencia,
			    		estado: asistencia.estado*/
			    	 })
			    	
			    	console.log('$scope.selectedParticipantes checked: '+ JSON.stringify($scope.selectedParticipantes) );
			    	
			    }else{
			    	//$scope.selectedAsist = $scope.selectedAsist.filter(val => val.idAsistencia !== asistencia.idAsistencia);
			    	
			    	//console.log('$scope.selectedAsist no checked: '+ JSON.stringify($scope.selectedAsist) );
			    }
		};
		
		
		/**
$scope.selection = function(dato) {
    if (dato.checked) {
        // Add the item to the selected array
        if ($scope.selected.indexOf(dato) === -1) {
            $scope.selected.push(dato);
        }
    } else {
        // Remove the item from the selected array
        var index = $scope.selected.indexOf(dato);
        if (index !== -1) {
            $scope.selected.splice(index, 1);
        }
    }
};
		 * */
		
    	
    	
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

//MPINARES 14022024 - INICIO
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
	});

	$scope.$watch('dtEntidadesModelo.codProv', function (newValue, oldValue) {
		console.log('dtEntidadesModelo.codProv ' + newValue+' -- '+oldValue);
		$scope.loadlistaCoddist();
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

//FIN CUSCATA - 25072024