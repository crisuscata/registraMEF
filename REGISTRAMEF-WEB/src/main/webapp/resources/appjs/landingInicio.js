var contexto = window.location.pathname.substring(0,window.location.pathname.indexOf('/',2));
var pglogoff = window.location.origin+contexto+'/logoff.htm';
var principalUrl = window.location.origin+contexto+'/	';
var listalandingIniUrl = contexto+"/rs/ctrllandingIni/loadConsolidado";
var listaTdSedesSedeidsedeUrl = contexto+"/rs/ctrllandingIni/listaTdSedesSedeIdsede";
//PURIBE 22012024 - INICIO
var principalUrl = window.location.origin+contexto+'/index.htm';
var asistenciaUrl= window.location.origin+contexto+'/asistencia'+'/listadtAsistencia.html';
var capacitacionUrl= window.location.origin+contexto+'/capacitacion'+'/listadtCapacitacion.html';
var visitaUrl= window.location.origin+contexto+'/visitas'+'/listadtVisitas.html';
var visitanoprogUrl= window.location.origin+contexto+'/visitas'+'/listadtVisitasNoProg.html';/* PURIBE 21032024 - INICIO*/
var valorverUrl = contexto+"/rs/ctrldtLanding/loadvalorcrearleer";// PURIBE 15042024 - INICIO -->

//PURIBE 21032024 - INICIO
var asistenciaformprogUrl= window.location.origin+contexto+'/asistencia'+'/listadtAsistencia.html'+'#!/nuevo';
var capacitacionformprogUrl= window.location.origin+contexto+'/capacitacion'+'/listadtCapacitacion.html'+'#!/nuevo';
var visitaformprogUrl= window.location.origin+contexto+'/visitas'+'/listadtVisitas.html'+'#!/nuevo';
//PURIBE 21032024 - FIN

//PURIBE 22012024 - FIN
/**
 * //MPINARES 29092023 - INICIO - NUEVO JS
 */
myapp = angular.module('MyApp');

myapp.config(function($routeProvider) {
	  $routeProvider
	  .when("/editar/:iddoc", {
		  templateUrl : "paginas/editarConstruccion.html",
		  controller : "ctrllandingIni"
	  })
	  .when("/nuevo", {
		  templateUrl : "paginas/editartdEvento.html",
		  controller : "ctrllandingIni"
	  })
	  .otherwise({
		  templateUrl : "paginas/verConstruccion.html",
		  controller : "ctrllandingIni"  
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

myapp.controller('ctrllandingIni', ['$mdEditDialog', '$scope', '$timeout', '$http', '$mdDialog','$location','$routeParams', '$mdPanel',  function ($mdEditDialog, $scope, $timeout, $http, $mdDialog, $location, $routeParams, $mdPanel) {
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
	  };
	 
	 $scope.logItem = function (item) {
	  console.log(item.name, 'was selected');
	 };
	 
	 $scope.logPagination = function (page, limit) {
	  console.log('page: ', page);
	  console.log('limit: ', limit);
	     };
     // ///////////////////////////////////////////
	$scope.datos = [];
	$scope.total = 0;
	
	$scope.contratos = {
			tipoExpt : null,
			enproceso : null,
			monto : null
		};
	
	$scope.convenios = {
			tipoExpt : null,
			enproceso : null,
			monto : null	
		};
	
	$scope.vacaciones = {
			tipoExpt : null,
			enproceso : null,
			monto : null	
		};
	
	$scope.plazas = {
			tipoExpt : null,
			enproceso : null,
			monto : null	
		};
	
	$scope.autorizmuni = {
			tipoExpt : null,
			enproceso : null,
			monto : null
		};
	
	$scope.viatico = {
			tipoExpt : null,
			enproceso : null,
			monto : null	
		};
	
	$scope.cajachica = {
			tipoExpt : null,
			enproceso : null,
			monto : null	
		};
	
	$scope.clearData = function(){
		
		$scope.contratos.tipoExpt = null;
		$scope.contratos.enproceso = null;
		$scope.contratos.monto = null;
		
		$scope.convenios.tipoExpt = null;
		$scope.convenios.enproceso = null;
		$scope.convenios.monto = null;
		
		$scope.vacaciones.tipoExpt = null;
		$scope.vacaciones.enproceso = null;
		$scope.vacaciones.monto = null;
		
		$scope.plazas.tipoExpt = null;
		$scope.plazas.enproceso = null;
		$scope.plazas.monto = null;
		
		$scope.autorizmuni.tipoExpt = null;
		$scope.autorizmuni.enproceso = null;
		$scope.autorizmuni.monto = null;
		
		$scope.viatico.tipoExpt = null;
		$scope.viatico.enproceso = null;
		$scope.viatico.monto = null;
		
		$scope.cajachica.tipoExpt = null;
		$scope.cajachica.enproceso = null;
		$scope.cajachica.monto = null;
			
		$scope.fechaHoraActualizacion = null;
		$scope.dequien = null;
		$scope.tiempoenBD = 0;
		$scope.tiempoenproceso = 0;
	};
	
$scope.setData = function(data){
		
		if($scope.isObject(data.contratos)){
		$scope.contratos.tipoExpt = data.contratos.tipoExpt;
		$scope.contratos.enproceso = data.contratos.enproceso;
		}
		
		if($scope.isObject(data.convenios)){
			$scope.convenios.tipoExpt = data.convenios.tipoExpt;
			$scope.convenios.enproceso = data.convenios.enproceso;
			}
		
		if($scope.isObject(data.vacaciones)){
			$scope.vacaciones.tipoExpt = data.vacaciones.tipoExpt;
			$scope.vacaciones.enproceso = data.vacaciones.enproceso;
			}
		
		if($scope.isObject(data.plazas)){
			$scope.plazas.tipoExpt = data.plazas.tipoExpt;
			$scope.plazas.enproceso = data.plazas.enproceso;
			}
		
		if($scope.isObject(data.autorizmuni)){
			$scope.autorizmuni.tipoExpt = data.autorizmuni.tipoExpt;
			$scope.autorizmuni.enproceso = data.autorizmuni.enproceso;
			}
		
		if($scope.isObject(data.viatico)){
			$scope.viatico.tipoExpt = data.viatico.tipoExpt;
			$scope.viatico.enproceso = data.viatico.enproceso;
			$scope.viatico.monto = data.viatico.monto;
			}
		
		if($scope.isObject(data.cajachica)){
			$scope.cajachica.tipoExpt = data.cajachica.tipoExpt;
			$scope.cajachica.enproceso = data.cajachica.enproceso;
			$scope.cajachica.monto = data.cajachica.monto;
			}
		
		if($scope.isNull($scope.contratos.enproceso)){
			$scope.contratos.enproceso = 0;
		}
		if($scope.isNull($scope.convenios.enproceso)){
			$scope.convenios.enproceso = 0;
		}
		if($scope.isNull($scope.vacaciones.enproceso)){
			$scope.vacaciones.enproceso = 0;
		}
		if($scope.isNull($scope.plazas.enproceso)){
			$scope.plazas.enproceso = 0;
		}
		if($scope.isNull($scope.autorizmuni.enproceso)){
			$scope.autorizmuni.enproceso = 0;
		}
		if($scope.isNull($scope.viatico.enproceso)){
			$scope.viatico.enproceso = 0;
		}
		if($scope.isNull($scope.cajachica.enproceso)){
			$scope.cajachica.enproceso = 0;
		}
		
		if($scope.isNull($scope.viatico.monto)){
			$scope.viatico.monto = 0;
		}
		if($scope.isNull($scope.cajachica.monto)){
			$scope.cajachica.monto = 0;
		}
		

		$scope.fechaHoraActualizacion = data.fechaHoraActualizacion;
		$scope.dequien = data.dequien;
		$scope.tiempoenBD = data.tiempoenBD;
		$scope.tiempoenproceso = data.tiempoenproceso;
	};
	
	$scope.loadtdlistaLandingIni = function () {
	    //$scope.promise = $timeout(function () {
	    	var surl = $scope.getURL();	    
	    	$scope.promise = $http.get(surl).then(function(res){
	    		
	    		$scope.clearData();
				$scope.setData(res.data);
				
				console.log(" DE "+ $scope.dequien);
				console.log(" Fech y hora "+ $scope.fechaHoraActualizacion);
				console.log("Tiempo respuesta BD " +$scope.tiempoenBD+" Tiempo en Paginar "+$scope.tiempoenproceso);
				
				},
				function error(errResponse) {
		            console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		            var dato = errResponse.data;
		            if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
		            	$mdDialog.show(
						         $mdDialog.alert()
						        .parent(angular.element(document.body))
						        .clickOutsideToClose(true)
						        .title('Lista de Registro')
						        .textContent(dato.message)
						        .ariaLabel('ERROR')
						        .ok('OK')
						    );
		            }
		        });			 
	     //}, 500);
//	    	$scope.loadListaTdSedesSedeIdsede();
	    	$scope.loadListaTdSedesSedeIdsede();
	  };
	  
	//PURIBE 15042024  INICIO-->
	   $scope.landing = {
		listareunion : null,
		registroreunion : null,
		listaasistencia :null,
		registroasistencia :null,
		listacapacitacion :null,
		registrocapacitacion :null
		}

		$scope.valorverUrl;
		$scope.cargarlanding = function(){
			/**
			 * PRINT DE CONTROL
			 */
			console.log("window.location.pathname: " + window.location.pathname + " contexto: " + contexto + "\nvalorverUrl: " + valorverUrl + " principalUrl: " + principalUrl);
			
			var surl = valorverUrl;
			$http.get(surl).then(function(res){
				var dato = res.data;					
				$scope.landing.listareunion        = dato.listareunion;					
				$scope.landing.registroreunion     = dato.registroreunion;
				$scope.landing.listaasistencia     = dato.listaasistencia;
				$scope.landing.registroasistencia  = dato.registroasistencia;
				$scope.landing.listacapacitacion    =dato.listacapacitacion;
				$scope.landing.registrocapacitacion =dato.registrocapacitacion;
								
			},
			function error(errResponse) {
				console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
				var dato = errResponse.data;
				if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
					$mdDialog.show(
							$mdDialog.alert()
							.parent(angular.element(document.body))
							.clickOutsideToClose(true)
							.title('Cargar landing por roles')
							.textContent(dato.message)
							.ariaLabel('ERROR')
							.ok('Aceptar')
							.targetEvent(ev)
					);
				}			           
			});			        			        	
		};		    

	$scope.cargarlanding();
	  //PURIBE 15042024  FIN-->
	  
	//PURIBE 15042024 - INICIO
	$scope.redirectasistenciaformprogUrl=function(){
		if($scope.landing.registroasistencia)
			{
		window.location.href=asistenciaformprogUrl; 
			}
		};	 
	$scope.redirectcapacitacionformprogUrl=function(){
		if($scope.landing.registrocapacitacion)
			{
		window.location.href=capacitacionformprogUrl; 
			}
		};	 
	$scope.redirectvisitaformprogUrl=function(){
		if($scope.landing.registroreunion)
			{
		window.location.href=visitaformprogUrl; 
			}
		};	 
		//PURIBE 15042024 - INICIO

		/* PURIBE 21032024 - INICIO*/
		$scope.redirectvisitanoprogUrl=function(){
			window.location.href=visitanoprogUrl; 
			};	
		/* PURIBE 21032024 - FIN*/

			//PURIBE 15042024 - INICIO
			$scope.redirectasistenciaUrl=function(){
				if ($scope.landing.listaasistencia)
				{
				window.location.href=asistenciaUrl; 
				}
				};	 

			$scope.redirectcapacitacionUrl=function(){
				if ($scope.landing.listacapacitacion)
				{
			window.location.href=capacitacionUrl; 
				}
				};	 

			$scope.redirectvisitaUrl=function(){
				if ($scope.landing.listareunion)
				{
			window.location.href=visitaUrl; 
				}
				};	 
			//PURIBE 15042024 - FIN	 

			///PURIBE 22012024 - FIN
	  
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
				//MPINARES 13072023 - INICIO
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
						filtroparametro += "?"+key+"="+$scope.formatDMY(valor);
					}else{
						filtroparametro += "&"+key+"="+$scope.formatDMY(valor);
					}
				}
				//MPINARES 13072023 - FIN
			});
                console.log('Parametros del URL: '+order+limit+page+filtroparametro);	 
		  return order+limit+page+filtroparametro;
	  }

        $scope.getURL=function(){		    	 
		  return listalandingIniUrl+$scope.getURLParametros();
	  }
        
  	  $scope.filtro ={
  			  mesFiltro: new Date(),
  			  mesFiltroJUD: new Date(),
  			  idsede: null
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
  
	$scope.load = function () {
		console.log("ACCEDIENDO A LA VISTA ");
	  };
	
	
///FIN ADICIONALES			 			 
	// ////////////////////////////////////////////////////////////////
	  
      $scope.listaTdSedesSedeIdsede=[];
  	$scope.loadListaTdSedesSedeIdsede=function(){
  		$http.get(listaTdSedesSedeidsedeUrl).then(function(res){
  			$scope.listaTdSedesSedeIdsede = res.data; 
  		},
  		function error(errResponse) {
  			console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
  		});
  	};
          $scope.changeIdsede=function(){
            ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
          }
          $scope.$watch('tdLogisticaConformidadModelo.idsede', function (newValue, oldValue) {
  		console.log('tdLogisticaConformidadModelo.idsede ' + newValue+' -- '+oldValue);
  		//CARGAR DATOS DEL SIGUIENTE SELECT
  	});
	
		    $scope.cancel = function() {
				$mdDialog.cancel();
		    };
		    
		 // Returns if a value is really a number
			$scope.isNumber  = function(value) {
			  return typeof value === 'number' && isFinite(value);
			  };	
				  
		      
		    	    
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
			 
			$scope.filtroTdEvento = function(toma){				
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
