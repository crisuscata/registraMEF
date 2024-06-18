var contexto = window.location.pathname.substring(0,window.location.pathname.indexOf('/',2));
var pglogoff = window.location.origin+contexto+'/logoff.htm';
var principalUrl = window.location.origin+contexto+'/index.htm';
var listamsUsuariosUrl = contexto+"/rs/ctrlmsUsuarios/listamsUsuarios";
var insertmsUsuariosUrl = contexto+"/rs/ctrlmsUsuarios/salvarmsUsuarios";
var eliminarmsUsuariosUrl = contexto+"/rs/ctrlmsUsuarios/eliminarmsUsuarios";
var editarmsUsuariosUrl = contexto+"/rs/ctrlmsUsuarios/editarmsUsuarios/";
var listaPrtParametrosidparametroIdCargoUrl = contexto+"/rs/ctrlmsUsuarios/listaPrtParametrosIdparametroIdCargo";
var listaMsSisAdmistrativoidSistAdmiIdSistAdmiUrl = contexto+"/rs/ctrlmsUsuarios/listaMsSisAdmistrativoIdSistAdmiIdSistAdmi";
var listaMsSedesidSedeIdSedeUrl = contexto+"/rs/ctrlmsUsuarios/listaMsSedesIdSedeIdSede";
var listaPrtParametrosidparametroIdCondlabrUrl = contexto+"/rs/ctrlmsUsuarios/listaPrtParametrosIdparametroIdCondlabr";
var descargarUrl = contexto+"/rs/ctrlmsUsuarios/descargar/";

///URLs CARGA DE ARCHIVOS
var insertDocUrl = contexto+"/rs/ctrlmsUsuarios/insertarchivo";
var descargarUrl = contexto+"/rs/ctrlmsUsuarios/descargar/";
///FIN URLs CARGA DE ARCHIVOS

var descargarvistaUrl = contexto+"/rs/ctrlmsUsuarios/descargarvista";

/**
 * 
 */
myapp = angular.module('MyApp');

myapp.config(function($routeProvider) {
	  $routeProvider
	  .when("/editar/:idusuario", {
		  templateUrl : "adminis/editarmsUsuarios.html",
		  controller : "ctrlListamsUsuarios"
	  })
	  .when("/nuevo", {
		  templateUrl : "adminis/editarmsUsuarios.html",
		  controller : "ctrlListamsUsuarios"
	  })
	  .otherwise({
		  templateUrl : "adminis/vermsUsuarios.html",
		  controller : "ctrlListamsUsuarios"  
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

myapp.controller('ctrlListamsUsuarios', ['$mdEditDialog', '$scope', '$timeout', '$http', '$mdDialog','$location','$routeParams', '$mdPanel',  function ($mdEditDialog, $scope, $timeout, $http, $mdDialog, $location, $routeParams, $mdPanel) {
	'use strict';
	 
	 $scope.limitOptions = [100, 500, 1000, 5000];
	 $scope.query = {
			    order: 'idusuario',
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
	  $scope.loadmsUsuarioss();
	 };
	 
	 $scope.logItem = function (item) {
	  console.log(item.name, 'was selected');
	 };
	 
	 $scope.logPagination = function (page, limit) {
	  console.log('page: ', page);
	  console.log('limit: ', limit);
	  $scope.loadmsUsuarioss();
         };
     $scope.creamsUsuarios = false;
    // ///////////////////////////////////////////
	$scope.datos = [];
	$scope.total = 0;

	$scope.loadmsUsuarioss = function () {
	    //$scope.promise = $timeout(function () {
	    	var surl = $scope.getURL();	    
	    	$scope.promise = $http.get(surl).then(function(res){
	    		 $scope.datos = res.data.data;
	    		 if(res.data.contador>0)
	    		 $scope.total = res.data.contador;
	    		 var tiempoenBD = res.data.tiempoenBD;
	    		 var tiempoenproceso = res.data.tiempoenproceso;
	    		 $scope.creamsUsuarios = res.data.creamodifica;
	    		 console.log("data " +$scope.datos.length+" DE "+ $scope.total);
	    		 console.log("Tiempo respuesta BD msUsuarios " +tiempoenBD+" Tiempo en Paginar "+tiempoenproceso);
				},
				function error(errResponse) {
		            console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		            var dato = errResponse.data;
		            if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
		            	$mdDialog.show(
						         $mdDialog.alert()
						        .parent(angular.element(document.body))
						        .clickOutsideToClose(true)
						        .title('Lista de Usuarios Internos')
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
		  return listamsUsuariosUrl+$scope.getURLParametros();
	  }
	  
	  $scope.editmsUsuarios = function () {
		    $scope.nuevo = true;
		    var idusuario = $routeParams.idusuario;
		    if(idusuario){
		    	$scope.cargarmsUsuarios(idusuario);
		    }
		   ///CARGAR COMPLEMENTOS 
                $scope.loadListaPrtParametrosIdCargo();//SELECT
                $scope.loadListaMsSisAdmistrativoIdSistAdmi();//SELECT
                $scope.loadListaMsSedesIdSede();//SELECT
                $scope.loadListaPrtParametrosIdCondlabr();//SELECT
		  };
	  
	  $scope.filtro ={
  dni: null,
  nombres: null,
  apellidoPaterno: null,
  apellidoMaterno: null,
  fechaInic: null,
  fechaCese: null,
  direccion: null,
  username: null,
  codDpto: null,
  codProv: null,
  codDistr: null,
  
         estado: null
		}; 
	  
	  $scope.seteestado = function(eestado) {
			if($scope.filtro.estado === eestado){
				$scope.filtro.estado = null;
			}else{
				$scope.filtro.estado = eestado;
			}
			$scope.loadmsUsuarioss();
		};
	  
         $scope.refrescarvista = function(ev){
		  if(typeof(ev)=='undefined' || ev==null){
	          
          }else{
			 var keyCode = ev.which || ev.keyCode;
			    if (keyCode === 13) {
			    	$scope.loadmsUsuarioss();
			    }else if (keyCode === 1) {
			    	$scope.loadmsUsuarioss();
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

	  $scope.msUsuariosModelo = {
			idusuario : null,
			dni: null,
			nombres: null,
			apellidoPaterno: null,
			apellidoMaterno: null,
			contrasenia: null,
			profesion: null,
			correo: null,
			telefono: null,
			fechaInic: new Date(),
fechaCese: new Date(),
direccion: null,
			username: null,
			idCargo: null,
			codDpto: null,
			codProv: null,
			codDistr: null,
			idpais: null,
			idSistAdmi: null,
			idSede: null,
			idCondlabr: null,
			
                        // ADICIONALES
	                estadoTxt: null,
idCargoTxt: null,
codDptoTxt: null,
codProvTxt: null,
codDistrTxt: null,
idpaisTxt: null,
idSistAdmiTxt: null,
idSedeTxt: null,
idCondlabrTxt: null,

		    editopcion: 1
		};
	  
	  $scope.clearmsUsuarios = function(){
		    $scope.msUsuariosModelo.idusuario = null;
		    $scope.msUsuariosModelo.dni = null;
		    $scope.msUsuariosModelo.nombres = null;
		    $scope.msUsuariosModelo.apellidoPaterno = null;
		    $scope.msUsuariosModelo.apellidoMaterno = null;
		    $scope.msUsuariosModelo.contrasenia = null;
		    $scope.msUsuariosModelo.profesion = null;
		    $scope.msUsuariosModelo.correo = null;
		    $scope.msUsuariosModelo.telefono = null;
		    $scope.msUsuariosModelo.fechaInic = new Date();$scope.msUsuariosModelo.fechaCese = new Date();$scope.msUsuariosModelo.direccion = null;
		    $scope.msUsuariosModelo.username = null;
		    $scope.msUsuariosModelo.idCargo = null;
		    $scope.msUsuariosModelo.codDpto = null;
		    $scope.msUsuariosModelo.codProv = null;
		    $scope.msUsuariosModelo.codDistr = null;
		    $scope.msUsuariosModelo.idpais = null;
		    $scope.msUsuariosModelo.idSistAdmi = null;
		    $scope.msUsuariosModelo.idSede = null;
		    $scope.msUsuariosModelo.idCondlabr = null;
		    
                    // ADICIONALES
	            $scope.msUsuariosModelo.estadoTxt = null;
$scope.msUsuariosModelo.idCargoTxt = null;
$scope.msUsuariosModelo.codDptoTxt = null;
$scope.msUsuariosModelo.codProvTxt = null;
$scope.msUsuariosModelo.codDistrTxt = null;
$scope.msUsuariosModelo.idpaisTxt = null;
$scope.msUsuariosModelo.idSistAdmiTxt = null;
$scope.msUsuariosModelo.idSedeTxt = null;
$scope.msUsuariosModelo.idCondlabrTxt = null;

		    $scope.msUsuariosModelo.editopcion = 1;
	 } 
	 
	  $scope.setMsUsuariosModelo = function(msUsuariosBk) {
		  $scope.msUsuariosModelo.idusuario = msUsuariosBk.idusuario;
			$scope.msUsuariosModelo.dni = msUsuariosBk.dni;
			$scope.msUsuariosModelo.nombres = msUsuariosBk.nombres;
			$scope.msUsuariosModelo.apellidoPaterno = msUsuariosBk.apellidoPaterno;
			$scope.msUsuariosModelo.apellidoMaterno = msUsuariosBk.apellidoMaterno;
			$scope.msUsuariosModelo.contrasenia = msUsuariosBk.contrasenia;
			$scope.msUsuariosModelo.profesion = msUsuariosBk.profesion;
			$scope.msUsuariosModelo.correo = msUsuariosBk.correo;
			$scope.msUsuariosModelo.telefono = msUsuariosBk.telefono;
			$scope.msUsuariosModelo.fechaInic = msUsuariosBk.fechaInic;
                        if(!$scope.isNull($scope.msUsuariosModelo.fechaInic) && !isNaN($scope.msUsuariosModelo.fechaInic)){
			    $scope.msUsuariosModelo.fechaInic = new Date($scope.msUsuariosModelo.fechaInic);
		        }
$scope.msUsuariosModelo.fechaCese = msUsuariosBk.fechaCese;
                        if(!$scope.isNull($scope.msUsuariosModelo.fechaCese) && !isNaN($scope.msUsuariosModelo.fechaCese)){
			    $scope.msUsuariosModelo.fechaCese = new Date($scope.msUsuariosModelo.fechaCese);
		        }
$scope.msUsuariosModelo.direccion = msUsuariosBk.direccion;
			$scope.msUsuariosModelo.username = msUsuariosBk.username;
			$scope.msUsuariosModelo.idCargo = msUsuariosBk.idCargo;
			$scope.msUsuariosModelo.codDpto = msUsuariosBk.codDpto;
			$scope.msUsuariosModelo.codProv = msUsuariosBk.codProv;
			$scope.msUsuariosModelo.codDistr = msUsuariosBk.codDistr;
			$scope.msUsuariosModelo.idpais = msUsuariosBk.idpais;
			$scope.msUsuariosModelo.idSistAdmi = msUsuariosBk.idSistAdmi;
			$scope.msUsuariosModelo.idSede = msUsuariosBk.idSede;
			$scope.msUsuariosModelo.idCondlabr = msUsuariosBk.idCondlabr;
			
                        // ADICIONALES
	                $scope.msUsuariosModelo.estadoTxt = msUsuariosBk.estadoTxt;
$scope.msUsuariosModelo.idCargoTxt = msUsuariosBk.idCargoTxt;
$scope.msUsuariosModelo.codDptoTxt = msUsuariosBk.codDptoTxt;
$scope.msUsuariosModelo.codProvTxt = msUsuariosBk.codProvTxt;
$scope.msUsuariosModelo.codDistrTxt = msUsuariosBk.codDistrTxt;
$scope.msUsuariosModelo.idpaisTxt = msUsuariosBk.idpaisTxt;
$scope.msUsuariosModelo.idSistAdmiTxt = msUsuariosBk.idSistAdmiTxt;
$scope.msUsuariosModelo.idSedeTxt = msUsuariosBk.idSedeTxt;
$scope.msUsuariosModelo.idCondlabrTxt = msUsuariosBk.idCondlabrTxt;

			$scope.msUsuariosModelo.editopcion = msUsuariosBk.msUsuariosACL.editopcion;
		}
	  // ////////////////////////////////////////////////
	  $scope.editarMsUsuarios = function(ev, msUsuariosBk) {		  
		    $scope.setMsUsuariosModelo(msUsuariosBk);		  
			$location.url('/editar/' + $scope.msUsuariosModelo.idusuario);
			$scope.nuevo = false;
	  }
	  
	  $scope.nuevoMsUsuarios = function() {
		    $scope.clearmsUsuarios();
			$location.url('/nuevo');
			$scope.nuevo = true;
	  }
	  	  
	  $scope.cancelarMsUsuarios = function() {
		    $scope.clearmsUsuarios();
		    $location.url('/');
	  }
	  			  
	  $scope.salvarMsUsuarios = function(ev){		
				    ev.target.disabled = true;
				    var datainsert = angular.toJson($scope.msUsuariosModelo);
		 			console.log("datainsert = "+datainsert);	
		        		$http.post(insertmsUsuariosUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
							var dato = res.data;

//		    				$scope.datos.push(dato); 
		    				$scope.total = $scope.datos.length;
		    				
		    				$scope.setMsUsuariosModelo(dato);
		    				
		    				$mdDialog.show(
							         $mdDialog.alert()
							        .parent(angular.element(document.body))
							        .clickOutsideToClose(true)
							        .title('Guardar Usuarios Internos')
							        .textContent("del Usuarios Internos se guardó correctamente.")
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
								        .title('Guardar Usuarios Internos')
								        .textContent(dato.message)
								        .ariaLabel('ERROR')
								        .ok('OK')
								        .targetEvent(ev)
								    );
				            }
				        });		
		        			        	
		        	ev.target.disabled = false;
			 };
			 
	   $scope.eliminarmsUsuarios = function(ev,msUsuariosBk){		
				    ev.target.disabled = true;
				    $scope.setMsUsuariosModelo(msUsuariosBk);
				    var datainsert = angular.toJson($scope.msUsuariosModelo);
		 			console.log("datainsert = "+datainsert);	
	        		$http.post(eliminarmsUsuariosUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
						var dato = res.data;
						var instrumentos = $scope.datos;
				        var index = $scope.datos.findIndex(obj => obj.idusuario === dato.idusuario);
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
					        .title('Eliminar Usuarios Internos')
					        .textContent(dato.message)
					        .ariaLabel('ERROR')
					        .ok('OK')
					        .targetEvent(ev)
						   );
			            }
			        });			        			        	
		        	ev.target.disabled = false;
			 };	
			
		$scope.cargarmsUsuarios = function(idusuario){		
			var surl = editarmsUsuariosUrl+idusuario;
			$http.get(surl).then(function(res){
				var dato = res.data;
				$scope.setMsUsuariosModelo(dato);
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
					        .title('Cargar Usuarios Internos')
					        .textContent(dato.message)
					        .ariaLabel('ERROR')
					        .ok('OK')
						   );
			            }			           
			        });			        			        	
			 };
			 
		$scope.showConfirm = function(ev, msUsuariosBk) {
				    var confirm = $mdDialog.confirm()
				      .title('Eliminar Usuarios Internos')
				      .textContent('Esta usted seguro de eliminar el registro?')
				      .ariaLabel('Lucky day')
				      .targetEvent(ev)
				      .ok('Si')
				      .cancel('No');

				    $mdDialog.show(confirm).then(function () {
				      $scope.status = 'SI';
				      $scope.eliminarmsUsuarios(ev, msUsuariosBk);
				    }, function () {
				      $scope.status = 'NO';
				    });
				  };		  
///ADICIONALES
//SELECT INI
        $scope.listaPrtParametrosIdCargo=[];
	$scope.loadListaPrtParametrosIdCargo=function(){
		$http.get(listaPrtParametrosidparametroIdCargoUrl).then(function(res){
			$scope.listaPrtParametrosIdCargo = res.data; 
		},
		function error(errResponse) {
			console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		});
	};
        $scope.changeIdCargo=function(){
          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
        }
        $scope.$watch('msUsuariosModelo.idCargo', function (newValue, oldValue) {
		console.log('msUsuariosModelo.idCargo ' + newValue+' -- '+oldValue);
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
        $scope.$watch('msUsuariosModelo.idSistAdmi', function (newValue, oldValue) {
		console.log('msUsuariosModelo.idSistAdmi ' + newValue+' -- '+oldValue);
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
        $scope.$watch('msUsuariosModelo.idSede', function (newValue, oldValue) {
		console.log('msUsuariosModelo.idSede ' + newValue+' -- '+oldValue);
		//CARGAR DATOS DEL SIGUIENTE SELECT
	});
//SELECT FIN                
//SELECT INI
        $scope.listaPrtParametrosIdCondlabr=[];
	$scope.loadListaPrtParametrosIdCondlabr=function(){
		$http.get(listaPrtParametrosidparametroIdCondlabrUrl).then(function(res){
			$scope.listaPrtParametrosIdCondlabr = res.data; 
		},
		function error(errResponse) {
			console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		});
	};
        $scope.changeIdCondlabr=function(){
          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
        }
        $scope.$watch('msUsuariosModelo.idCondlabr', function (newValue, oldValue) {
		console.log('msUsuariosModelo.idCondlabr ' + newValue+' -- '+oldValue);
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
				  
		    $scope.nuevo = ($scope.isNumber($scope.msUsuariosModelo.idusuario) && $scope.msUsuariosModelo.idusuario > 0);
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
			 
			$scope.filtroMsUsuarios = function(toma){				
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
