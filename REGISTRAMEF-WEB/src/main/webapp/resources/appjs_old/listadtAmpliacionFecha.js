var contexto = window.location.pathname.substring(0,window.location.pathname.indexOf('/',2));
var pglogoff = window.location.origin+contexto+'/logoff.htm';
var principalUrl = window.location.origin+contexto+'/index.htm';
var listadtAmpliacionFechaUrl = contexto+"/rs/ctrldtAmpliacionFecha/listadtAmpliacionFecha";
var insertdtAmpliacionFechaUrl = contexto+"/rs/ctrldtAmpliacionFecha/salvardtAmpliacionFecha";
var eliminardtAmpliacionFechaUrl = contexto+"/rs/ctrldtAmpliacionFecha/eliminardtAmpliacionFecha";
var editardtAmpliacionFechaUrl = contexto+"/rs/ctrldtAmpliacionFecha/editardtAmpliacionFecha/";
var listaPrtParametrosidparametroTipoFechaCorteUrl = contexto+"/rs/ctrldtAmpliacionFecha/listaPrtParametrosIdparametroTipoFechaCorte";
var listaMsSedesidSedeIdSedeUrl = contexto+"/rs/ctrldtAmpliacionFecha/listaMsSedesIdSedeIdSede";
var listaMsSisAdmistrativoidSistAdmiIdSistAdmiUrl = contexto+"/rs/ctrldtAmpliacionFecha/listaMsSisAdmistrativoIdSistAdmiIdSistAdmi";
var descargarUrl = contexto+"/rs/ctrldtAmpliacionFecha/descargar/";

///URLs CARGA DE ARCHIVOS
var insertDocUrl = contexto+"/rs/ctrldtAmpliacionFecha/insertarchivo";
var descargarUrl = contexto+"/rs/ctrldtAmpliacionFecha/descargar/";
///FIN URLs CARGA DE ARCHIVOS

var descargarvistaUrl = contexto+"/rs/ctrldtAmpliacionFecha/descargarvista";

/**
 * 
 */
myapp = angular.module('MyApp');

myapp.config(function($routeProvider) {
	  $routeProvider
	  .when("/editar/:idAutorizacion", {
		  templateUrl : "adminis/editardtAmpliacionFecha.html",
		  controller : "ctrlListadtAmpliacionFecha"
	  })
	  .when("/nuevo", {
		  templateUrl : "adminis/editardtAmpliacionFecha.html",
		  controller : "ctrlListadtAmpliacionFecha"
	  })
	  .otherwise({
		  templateUrl : "adminis/verdtAmpliacionFecha.html",
		  controller : "ctrlListadtAmpliacionFecha"  
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

myapp.controller('ctrlListadtAmpliacionFecha', ['$mdEditDialog', '$scope', '$timeout', '$http', '$mdDialog','$location','$routeParams', '$mdPanel',  function ($mdEditDialog, $scope, $timeout, $http, $mdDialog, $location, $routeParams, $mdPanel) {
	'use strict';
	 
	 $scope.limitOptions = [100, 500, 1000, 5000];
	 $scope.query = {
			    order: 'idAutorizacion',
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
	  $scope.loaddtAmpliacionFechas();
	 };
	 
	 $scope.logItem = function (item) {
	  console.log(item.name, 'was selected');
	 };
	 
	 $scope.logPagination = function (page, limit) {
	  console.log('page: ', page);
	  console.log('limit: ', limit);
	  $scope.loaddtAmpliacionFechas();
         };
     $scope.creadtAmpliacionFecha = false;
    // ///////////////////////////////////////////
	$scope.datos = [];
	$scope.total = 0;

	$scope.loaddtAmpliacionFechas = function () {
	    //$scope.promise = $timeout(function () {
	    	var surl = $scope.getURL();	    
	    	$scope.promise = $http.get(surl).then(function(res){
	    		 $scope.datos = res.data.data;
	    		 if(res.data.contador>0)
	    		 $scope.total = res.data.contador;
	    		 var tiempoenBD = res.data.tiempoenBD;
	    		 var tiempoenproceso = res.data.tiempoenproceso;
	    		 $scope.creadtAmpliacionFecha = res.data.creamodifica;
	    		 console.log("data " +$scope.datos.length+" DE "+ $scope.total);
	    		 console.log("Tiempo respuesta BD dtAmpliacionFecha " +tiempoenBD+" Tiempo en Paginar "+tiempoenproceso);
				},
				function error(errResponse) {
		            console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		            var dato = errResponse.data;
		            if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
		            	$mdDialog.show(
						         $mdDialog.alert()
						        .parent(angular.element(document.body))
						        .clickOutsideToClose(true)
						        .title('Lista de Ampliaciones')
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
		  return listadtAmpliacionFechaUrl+$scope.getURLParametros();
	  }
	  
	  $scope.editdtAmpliacionFecha = function () {
		    $scope.nuevo = true;
		    var idAutorizacion = $routeParams.idAutorizacion;
		    if(idAutorizacion){
		    	$scope.cargardtAmpliacionFecha(idAutorizacion);
		    }
		   ///CARGAR COMPLEMENTOS 
                $scope.loadListaPrtParametrosTipoFechaCorte();//SELECT
                $scope.loadListaMsSedesIdSede();//SELECT
                $scope.loadListaMsSisAdmistrativoIdSistAdmi();//SELECT
		  };
	  
	  $scope.filtro ={
  tipoFechaCorte: null,
  idSede: null,
  idSistAdmi: null,
  
         estado: null
		}; 
	  
	  $scope.seteestado = function(eestado) {
			if($scope.filtro.estado === eestado){
				$scope.filtro.estado = null;
			}else{
				$scope.filtro.estado = eestado;
			}
			$scope.loaddtAmpliacionFechas();
		};
	  
         $scope.refrescarvista = function(ev){
		  if(typeof(ev)=='undefined' || ev==null){
	          
          }else{
			 var keyCode = ev.which || ev.keyCode;
			    if (keyCode === 13) {
			    	$scope.loaddtAmpliacionFechas();
			    }else if (keyCode === 1) {
			    	$scope.loaddtAmpliacionFechas();
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

	  $scope.dtAmpliacionFechaModelo = {
			idAutorizacion : null,
			tipoFechaCorte: null,
			idSede: null,
			idSistAdmi: null,
			fechaInicio: new Date(),
fechaFin: new Date(),

                        // ADICIONALES
	                tipoFechaCorteTxt: null,
idSedeTxt: null,
idSistAdmiTxt: null,
estadoTxt: null,

		    editopcion: 1
		};
	  
	  $scope.cleardtAmpliacionFecha = function(){
		    $scope.dtAmpliacionFechaModelo.idAutorizacion = null;
		    $scope.dtAmpliacionFechaModelo.tipoFechaCorte = null;
		    $scope.dtAmpliacionFechaModelo.idSede = null;
		    $scope.dtAmpliacionFechaModelo.idSistAdmi = null;
		    $scope.dtAmpliacionFechaModelo.fechaInicio = new Date();$scope.dtAmpliacionFechaModelo.fechaFin = new Date();
                    // ADICIONALES
	            $scope.dtAmpliacionFechaModelo.tipoFechaCorteTxt = null;
$scope.dtAmpliacionFechaModelo.idSedeTxt = null;
$scope.dtAmpliacionFechaModelo.idSistAdmiTxt = null;
$scope.dtAmpliacionFechaModelo.estadoTxt = null;

		    $scope.dtAmpliacionFechaModelo.editopcion = 1;
	 } 
	 
	  $scope.setDtAmpliacionFechaModelo = function(dtAmpliacionFechaBk) {
		  $scope.dtAmpliacionFechaModelo.idAutorizacion = dtAmpliacionFechaBk.idAutorizacion;
			$scope.dtAmpliacionFechaModelo.tipoFechaCorte = dtAmpliacionFechaBk.tipoFechaCorte;
			$scope.dtAmpliacionFechaModelo.idSede = dtAmpliacionFechaBk.idSede;
			$scope.dtAmpliacionFechaModelo.idSistAdmi = dtAmpliacionFechaBk.idSistAdmi;
			$scope.dtAmpliacionFechaModelo.fechaInicio = dtAmpliacionFechaBk.fechaInicio;
                        if(!$scope.isNull($scope.dtAmpliacionFechaModelo.fechaInicio) && !isNaN($scope.dtAmpliacionFechaModelo.fechaInicio)){
			    $scope.dtAmpliacionFechaModelo.fechaInicio = new Date($scope.dtAmpliacionFechaModelo.fechaInicio);
		        }
$scope.dtAmpliacionFechaModelo.fechaFin = dtAmpliacionFechaBk.fechaFin;
                        if(!$scope.isNull($scope.dtAmpliacionFechaModelo.fechaFin) && !isNaN($scope.dtAmpliacionFechaModelo.fechaFin)){
			    $scope.dtAmpliacionFechaModelo.fechaFin = new Date($scope.dtAmpliacionFechaModelo.fechaFin);
		        }

                        // ADICIONALES
	                $scope.dtAmpliacionFechaModelo.tipoFechaCorteTxt = dtAmpliacionFechaBk.tipoFechaCorteTxt;
$scope.dtAmpliacionFechaModelo.idSedeTxt = dtAmpliacionFechaBk.idSedeTxt;
$scope.dtAmpliacionFechaModelo.idSistAdmiTxt = dtAmpliacionFechaBk.idSistAdmiTxt;
$scope.dtAmpliacionFechaModelo.estadoTxt = dtAmpliacionFechaBk.estadoTxt;

			$scope.dtAmpliacionFechaModelo.editopcion = dtAmpliacionFechaBk.dtAmpliacionFechaACL.editopcion;
		}
	  // ////////////////////////////////////////////////
	  $scope.editarDtAmpliacionFecha = function(ev, dtAmpliacionFechaBk) {		  
		    $scope.setDtAmpliacionFechaModelo(dtAmpliacionFechaBk);		  
			$location.url('/editar/' + $scope.dtAmpliacionFechaModelo.idAutorizacion);
			$scope.nuevo = false;
	  }
	  
	  $scope.nuevoDtAmpliacionFecha = function() {
		    $scope.cleardtAmpliacionFecha();
			$location.url('/nuevo');
			$scope.nuevo = true;
	  }
	  	  
	  $scope.cancelarDtAmpliacionFecha = function() {
		    $scope.cleardtAmpliacionFecha();
		    $location.url('/');
	  }
	  			  
	  $scope.salvarDtAmpliacionFecha = function(ev){		
				    ev.target.disabled = true;
				    var datainsert = angular.toJson($scope.dtAmpliacionFechaModelo);
		 			console.log("datainsert = "+datainsert);	
		        		$http.post(insertdtAmpliacionFechaUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
							var dato = res.data;

//		    				$scope.datos.push(dato); 
		    				$scope.total = $scope.datos.length;
		    				
		    				$scope.setDtAmpliacionFechaModelo(dato);
		    				
		    				$mdDialog.show(
							         $mdDialog.alert()
							        .parent(angular.element(document.body))
							        .clickOutsideToClose(true)
							        .title('Guardar Ampliaciones')
							        .textContent("del Ampliaciones se guardó correctamente.")
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
								        .title('Guardar Ampliaciones')
								        .textContent(dato.message)
								        .ariaLabel('ERROR')
								        .ok('OK')
								        .targetEvent(ev)
								    );
				            }
				        });		
		        			        	
		        	ev.target.disabled = false;
			 };
			 
	   $scope.eliminardtAmpliacionFecha = function(ev,dtAmpliacionFechaBk){		
				    ev.target.disabled = true;
				    $scope.setDtAmpliacionFechaModelo(dtAmpliacionFechaBk);
				    var datainsert = angular.toJson($scope.dtAmpliacionFechaModelo);
		 			console.log("datainsert = "+datainsert);	
	        		$http.post(eliminardtAmpliacionFechaUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
						var dato = res.data;
						var instrumentos = $scope.datos;
				        var index = $scope.datos.findIndex(obj => obj.idAutorizacion === dato.idAutorizacion);
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
					        .title('Eliminar Ampliaciones')
					        .textContent(dato.message)
					        .ariaLabel('ERROR')
					        .ok('OK')
					        .targetEvent(ev)
						   );
			            }
			        });			        			        	
		        	ev.target.disabled = false;
			 };	
			
		$scope.cargardtAmpliacionFecha = function(idAutorizacion){		
			var surl = editardtAmpliacionFechaUrl+idAutorizacion;
			$http.get(surl).then(function(res){
				var dato = res.data;
				$scope.setDtAmpliacionFechaModelo(dato);
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
					        .title('Cargar Ampliaciones')
					        .textContent(dato.message)
					        .ariaLabel('ERROR')
					        .ok('OK')
						   );
			            }			           
			        });			        			        	
			 };
			 
		$scope.showConfirm = function(ev, dtAmpliacionFechaBk) {
				    var confirm = $mdDialog.confirm()
				      .title('Eliminar Ampliaciones')
				      .textContent('Esta usted seguro de eliminar el registro?')
				      .ariaLabel('Lucky day')
				      .targetEvent(ev)
				      .ok('Si')
				      .cancel('No');

				    $mdDialog.show(confirm).then(function () {
				      $scope.status = 'SI';
				      $scope.eliminardtAmpliacionFecha(ev, dtAmpliacionFechaBk);
				    }, function () {
				      $scope.status = 'NO';
				    });
				  };		  
///ADICIONALES
//SELECT INI
        $scope.listaPrtParametrosTipoFechaCorte=[];
	$scope.loadListaPrtParametrosTipoFechaCorte=function(){
		$http.get(listaPrtParametrosidparametroTipoFechaCorteUrl).then(function(res){
			$scope.listaPrtParametrosTipoFechaCorte = res.data; 
		},
		function error(errResponse) {
			console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		});
	};
        $scope.changeTipoFechaCorte=function(){
          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
        }
        $scope.$watch('dtAmpliacionFechaModelo.tipoFechaCorte', function (newValue, oldValue) {
		console.log('dtAmpliacionFechaModelo.tipoFechaCorte ' + newValue+' -- '+oldValue);
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
        $scope.$watch('dtAmpliacionFechaModelo.idSede', function (newValue, oldValue) {
		console.log('dtAmpliacionFechaModelo.idSede ' + newValue+' -- '+oldValue);
		//CARGAR DATOS DEL SIGUIENTE SELECT
	});
//SELECT FIN                
//SELECT INI
        $scope.listaMsSisAdmistrativoIdSistAdmi=[];
	$scope.loadListaMsSisAdmistrativoIdSistAdmi=function(){
		$http.get(listaMsSisAdmistrativoidSistAdmiIdSistAdmiUrl).then(function(res){
			$scope.listaMsSisAdmistrativoIdSistAdmi = res.data; 
		},
		function error(errResponse) {
			console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		});
	};
        $scope.changeIdSistAdmi=function(){
          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
        }
        $scope.$watch('dtAmpliacionFechaModelo.idSistAdmi', function (newValue, oldValue) {
		console.log('dtAmpliacionFechaModelo.idSistAdmi ' + newValue+' -- '+oldValue);
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
				  
		    $scope.nuevo = ($scope.isNumber($scope.dtAmpliacionFechaModelo.idAutorizacion) && $scope.dtAmpliacionFechaModelo.idAutorizacion > 0);
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
			 
			$scope.filtroDtAmpliacionFecha = function(toma){				
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
