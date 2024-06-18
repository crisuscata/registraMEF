var contexto = window.location.pathname.substring(0,window.location.pathname.indexOf('/',2));
// PURIBE 21032024 - INICIO -->
var pglogoff = window.location.origin+contexto+'/logoff.htm';
var principalUrl = window.location.origin+contexto+'/index.htm';
var listadtVisitasUrl = contexto+"/rs/ctrldtVisitas/listadtVisitas";
var insertdtVisitasUrl = contexto+"/rs/ctrldtVisitas/salvardtVisitas";
var eliminardtVisitasUrl = contexto+"/rs/ctrldtVisitas/eliminardtVisitas";
var reactivardtVisitasUrl = contexto+"/rs/ctrldtVisitas/reactivardtVisitas";//PURIBE
var buscarCodEjecUrl = contexto+"/rs/ctrldtVisitas/buscarcodejec/";//PURIBE
var listaMsUsuarios = contexto+"/rs/ctrldtVisitas/listausuarios";//PURIBE
var listaMsparametrosUrl = contexto+"/rs/ctrldtVisitas/prtParametros/";//PURIBE
var listaMStema  = contexto+"/rs/ctrldtVisitas/listamstemas/";//PURIBE
var modalparticipanteUrl= 'modal'+'/modalparticipante.html';//PURIBE

var editardtVisitasUrl = contexto+"/rs/ctrldtVisitas/editardtVisitas/";
var listaPrtParametrosidparametroIdOrigenUrl = contexto+"/rs/ctrldtVisitas/listaPrtParametrosIdparametroIdOrigen";
var listaPrtParametrosidparametroIdModalidadUrl = contexto+"/rs/ctrldtVisitas/listaPrtParametrosIdparametroIdModalidad";

var listaMsSedesidSedeIdSedeUrl = contexto+"/rs/ctrldtVisitas/listaMsSedesIdSedeIdSede";
var listaPrtParametrosidparametroIdFinanciaUrl = contexto+"/rs/ctrldtVisitas/listaPrtParametrosIdparametroIdFinancia";
var descargarUrl = contexto+"/rs/ctrldtVisitas/descargar/";
/*PURIBE 01022024 - INICIO-->*/
var listaMsUbigeocodDptoCodDptoUrl = contexto+"/rs/ctrldtVisitas/listaCoddptos";
var listadtEntidadesUrl = contexto+"/rs/ctrldtEntidades/listaViewdtEntidades";
/*PURIBE 01022024 - FIN-->*/

var listaMsInstitucionesidproveeUrl = contexto+"/rs/ctrldtVisitas/listaMsInstitucionesIdprovee/";//puribe
///URLs CARGA DE ARCHIVOS
var insertDocUrl = contexto+"/rs/ctrldtVisitas/insertarchivo";
var descargarUrl = contexto+"/rs/ctrldtVisitas/descargar/";
///FIN URLs CARGA DE ARCHIVOS

var descargarvistaUrl = contexto+"/rs/ctrldtVisitas/descargarvista";

/**
 * 
 */
myapp = angular.module('MyApp');
/*PURIBE 01022024 - INICIO-->*/
//puribe


myapp.config(function($routeProvider) {
	  $routeProvider
	  .when("/editar/:idVisita/:fechaInicio/:fechaFin", {
		  templateUrl : "visitas/editardtVisitas.html",
		  controller : "ctrlListadtVisitas"
	  })
	  .when("/nuevo/:fechaInicio/:fechaFin", {
		  templateUrl : "visitas/editardtVisitas.html",
		  controller : "ctrlListadtVisitas"
	  })
	  .when("/nuevo", {
		templateUrl : "visitas/editardtVisitas.html",
		controller : "ctrlListadtVisitas"
	})
	  .otherwise({
		  templateUrl : "visitas/verdtVisitas.html",
		  controller : "ctrlListadtVisitas"  
	  });
	});
	//puribe
	/*PURIBE 01022024 - FIN-->*/
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

myapp.controller('ctrlListadtVisitas', ['$mdEditDialog', '$scope', '$timeout', '$http', '$mdDialog','$location','$routeParams', '$mdPanel',  function ($mdEditDialog, $scope, $timeout, $http, $mdDialog, $location, $routeParams, $mdPanel) {
	'use strict';
	 
	 $scope.limitOptions = [100, 500, 1000, 5000];
	 $scope.query = {
			    order: 'idVisita',
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
			$scope.loaddtVisitass();
			};
			$scope.vertema= 0;//puribe
			$scope.selectedOrigen= 0;//puribe
			$scope.refrescar= 0;//puribe
			$scope.programada= 1;//puribe

			$scope.visitausuarios = []; //puribe
		

				 /* PURIBE 01022024 - INICIO */
		 $scope.logItem = function (ev, dtVisitasBk) {
		ev.target.disabled = true;
		var checkboxId = 'checkbox_' + dtVisitasBk.idVisita;
		var checkbox = angular.element(document.getElementById(checkboxId));
		var estaMarcado = checkbox.attr('aria-checked') === 'true';

		 if (!estaMarcado)  {
			$scope.setDtVisitasModelo(dtVisitasBk);	
			var nuevaDtVisitas = angular.copy($scope.dtVisitasModelo);
	
			// Puedes modificar las propiedades según sea necesario
			//nuevaDtVisitas.seleccionado = true;
		
			// Agregar la nueva instancia a la lista
			$scope.listaDtVisitas.push(nuevaDtVisitas);
			ev.target.disabled = false;
		 // console.log(item.name, 'was selected');

		} else {
			// Si el elemento fue deseleccionado, elimínalo de la lista

			var idToDelete = dtVisitasBk.idVisita;
			var index = -1;
			
			// Buscar el índice del elemento con el ID correspondiente
			for (var i = 0; i < $scope.listaDtVisitas.length; i++) {
				if ($scope.listaDtVisitas[i].idVisita === idToDelete) {
					index = i;
					break;
				}
			}
			
			// Verificar si se encontró el elemento y eliminarlo de la lista
			if (index !== -1) {
				$scope.listaDtVisitas.splice(index, 1);
			}

		}
		ev.target.disabled = false;

	 };
	 
	 $scope.logPagination = function (page, limit) {
	  console.log('page: ', page);
	  console.log('limit: ', limit);
	  $scope.loaddtVisitass();
         };
     $scope.creadtVisitas = false;
    // ///////////////////////////////////////////

	$scope.datos = [];
	$scope.total = 0;
	$scope.filtroEntidad="";
	$scope.filtroDepartamento="";

	$scope.loaddtVisitass = function () {
	    //$scope.promise = $timeout(function () {
				//puribe
	    	var surl = $scope.getURL();	   
			
			//puribe
	    	$scope.promise = $http.get(surl).then(function(res){
	    		 $scope.datos = res.data.data;
		
				 $scope.formatDate = function(dateString) {
					var date = new Date(dateString);
					var year = date.toLocaleString("default", { year: "numeric" });
					var month = date.toLocaleString("default", { month: "2-digit" });
					var day = date.toLocaleString("default", { day: "2-digit" });
					return day + "/" + month + "/" + year;
				}

				$scope.datos.map(function(obj) {
					//obj.fechaProgramada = $scope.formatDate(obj.fechaProgramada);
					obj.fechaProgramadaMostrar = $scope.formatDate(obj.fechaVisita);

				});	
	    /* PURIBE 01022024 - FIN */
				//PURIBE 29032024  INICIO-->
	    		 if(res.data.contador>0)
				 {
	    		 $scope.total = res.data.contador;
	    		 var tiempoenBD = res.data.tiempoenBD;
	    		 var tiempoenproceso = res.data.tiempoenproceso;
	    		 $scope.creadtVisitas = res.data.creamodifica;
	    		 console.log("data " +$scope.datos.length+" DE "+ $scope.total);
	    		 console.log("Tiempo respuesta BD dtVisitas " +tiempoenBD+" Tiempo en Paginar "+tiempoenproceso);
				 $scope.refrescar=0; //puribe
				 }
				 else
				 {
					$mdDialog.show(
						$mdDialog.alert()
					   .parent(angular.element(document.body))
					   .clickOutsideToClose(true)
					   .title('Lista de Visitas')
					   .textContent("No se encontro resultados")
					   .ariaLabel('WARNING')
					   .ok('ACEPTAR') 
				   );
				 }
				 //PURIBE 29032024  FIN->
				},
				function error(errResponse) {
		            console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		            var dato = errResponse.data;
					$scope.refrescar=0; //puribe
		            if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
		            	$mdDialog.show(
						         $mdDialog.alert()
						        .parent(angular.element(document.body))
						        .clickOutsideToClose(true)
						        .title('Lista de Visitas')
						        .textContent(dato.message)
						        .ariaLabel('ERROR')
						        .ok('ACEPTAR') //PURIBE 29032024  INICIO-->
						    );
		            }
		        });			 
	     //}, 500);
	  };
	 	  


	  $scope.getURLEjecutora=function(){
          var origen="?oferta=127";
		  var programada="&programada=121";
		  return origen+programada;
	  }

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
		 /* PURIBE 01022024 - INICIO */
				if(!$scope.isNull(valor) && ($scope.isDate(valor))){
					if(elprimero){
						elprimero=false;
						filtroparametro += "?"+key+"="+$scope.formatDateOnly(valor);
					}else{
						filtroparametro += "&"+key+"="+$scope.formatDateOnly(valor);
					}	
				}
				//puribe
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

				/////////////////
				if($scope.programada == 1){
					if(elprimero){
						elprimero=false;
						filtroparametro += "?programada=1";
					}else{
						filtroparametro += "&programada=1";
					}	
				}
				else if($scope.programada == 0)
				{
					if(elprimero){
					elprimero=false;
					filtroparametro += "?programada=0";
				}else{
					filtroparametro += "&programada=0";
				}	
				}
			/////////////////
				
	        //puribe

			});
                  console.log('Parametros del URL: '+order+limit+page+filtroparametro);	 
		  return order+limit+page+filtroparametro;
	  }

          $scope.getURL=function(){		    	 
		  return listadtVisitasUrl+$scope.getURLParametros();
	  }
		//puribe
		$scope.getURLreactiva=function(){		    	 
			return reactivardtVisitasUrl  +$scope.getURLParametros();
			
		}
		$scope.getURLeliminar=function(){		    	 
			return eliminardtVisitasUrl  +$scope.getURLParametros();
			
		}
		$scope.getURLsalvar=function(){		    	 
			return insertdtVisitasUrl  +$scope.getURLParametros();
		
		}
		//puribe
		
	  
		//puribe
	  $scope.editdtVisitas = function () {
		    $scope.nuevo = true;
		    var idVisita = $routeParams.idVisita;

			$scope.filtro.fechaInicio = $routeParams.fechaInicio;
			$scope.filtro.fechaFin= $routeParams.fechaFin;
			
			/* PURIBE 22032024 - INICIO*/
			if (!$routeParams.fechaInicio || !$routeParams.fechaFin)
			{

				var fechaActual = new Date();
				var limitesDelMesActual = obtenerLimitesDelMes(fechaActual);
				
				$scope.filtro.fechaInicio = limitesDelMesActual.primerDia;
				$scope.filtro.fechaFin = limitesDelMesActual.ultimoDia;
			}
				/* PURIBE 22032024 - FIN*/
			
			var fechaInicioString = $scope.filtro.fechaInicio;
			$scope.filtro.fechaInicio = fechaInicioString ? new Date(fechaInicioString) : null;

			var fechaFinString = $scope.filtro.fechaFin;
			$scope.filtro.fechaFin = fechaFinString ? new Date(fechaFinString) : null;


		    if(idVisita){
		    	$scope.cargardtVisitas(idVisita);
		    }
			else
			{
				
				var fechaActual = new Date();

				fechaActual.setDate(1);
				$scope.dtVisitasModelo.fechaVisita=fechaActual;
				$scope.dtVisitasModelo.fechaVisita.setMonth($scope.dtVisitasModelo.fechaVisita.getMonth() + 1);

			}
		
		   ///CARGAR COMPLEMENTOS 
             //   $scope.loadListaPrtParametrosIdOrigen();//SELECT
               // $scope.loadListaPrtParametrosIdModalidad();//SELECT
                //$scope.loadListaPrtParametrosIdTipo();//SELECT
                //$scope.loadListaPrtParametrosIdLugar();//SELECT
                //$scope.loadListaMsSedesIdSede();//SELECT
                //$scope.loadListaPrtParametrosIdFinancia();//SELECT
	
		  };
		  //puribe
	  
	  $scope.filtro ={
  fechaVisita: null,
  idOrigen: null,
  idProgramacion: null,
  idModalidad: null,
  idTipo: null,
  idLugar: null,
  idEntidad: null,
  idSede: null,
  idSistAdm: null,
  idFinancia: null,
  fechaProgramada: null,
  fechaInicio:null,
  fechaFin:null,
  Entidad:null,
  Departamento:null,
  participante:null,
         estado: null
		}; 


		$scope.$watch('filtro.Departamento', function(newVal, oldVal) {
			// Si el nuevo valor es 0, establecer el modelo en null
			if (newVal === 0) {
				$scope.filtro.Departamento = null;
			}
		});

		$scope.$watch('dtAsistenciaModelo.idEntidad', function (newValue, oldValue) {
			console.log('dtAsistenciaModelo.idEntidad ' + newValue+' -- '+oldValue);
			//CARGAR DATOS DEL SIGUIENTE SELECT
			});



	  		 /* PURIBE 01022024 - FIN */
	  $scope.seteestado = function(eestado) {
			if($scope.filtro.estado === eestado){
				$scope.filtro.estado = null;
			}else{
				$scope.filtro.estado = eestado;
			}
			$scope.loaddtVisitass();
		};
	  //puribe
         $scope.refrescarvista = function(ev){
		  if(typeof(ev)=='undefined' || ev==null){
	          
          }else{
			 var keyCode = ev.which || ev.keyCode;
			    if (keyCode === 13) {
					$scope.refrescar=1;
			    	$scope.loaddtVisitass();
			    }else if (keyCode === 1) {
					$scope.refrescar=1;
			    	$scope.loaddtVisitass();
			    }
          }
		};
		//puribe
	/* PURIBE 01022024 - INICIO */
		$scope.filtrar = function(ev){
			if(typeof(ev)=='undefined' || ev==null){
				
			}else{
			   var keyCode = ev.which || ev.keyCode;
				  if (keyCode === 13) {
					  $scope.filtrarDatos();
				  }else if (keyCode === 1) {
					  $scope.filtrarDatos();
				  }
			}
		  };

		  $scope.filtrarDatos = function () {
			$scope.loaddtVisitass()
			var datosFiltrados = angular.copy($scope.datos);
	
			// Filtrar por rango de fechas
			
			if ($scope.dtVisitasFechas.fechaprogramainicio && 	$scope.dtVisitasFechas.fechaprogramafin) {
			
			  datosFiltrados = datosFiltrados.filter(function (item) {
				var fechaItem = new Date(item.fechaProgramada); 
				return fechaItem >= new Date($scope.dtVisitasFechas.fechaprogramainicio) && fechaItem <= new Date($scope.dtVisitasFechas.fechaprogramafin);
			  });
			}

	
			// Filtrar por Entidad
			if ($scope.filtroEntidad) {
			  var filtroEntidadLower = $scope.filtroEntidad.toLowerCase();
	
			  datosFiltrados = datosFiltrados.filter(function (item) {
				return item.idEntidadTxt.toLowerCase().includes(filtroEntidadLower);
			  });
			}

			// Filtrar por Departamento
			if ($scope.filtroDepartamento) {
				var filtroDepartamentoLower = $scope.filtroDepartamento.toLowerCase();
	  
				datosFiltrados = datosFiltrados.filter(function (item) {
				  return item.idDepartamentoTxt.toLowerCase().includes(filtroDepartamentoLower);
				});
			  }
	
			  $scope.datos = datosFiltrados;
		  };
		

          $scope.descargarvista = function(){
			return descargarvistaUrl + $scope.getURLParametros();

	  };
	
	  //PURIBE
	  $scope.getURLEntidad=function(dato){		    	 
		var surl =buscarCodEjecUrl+ dato +$scope.getURLEjecutora();

		//return listadtVisitasUrl+getURLEjecutora;
		return surl;
		}


  		//PURIBE

		$scope.listaMsUbigeoCodDpto=[];
		$scope.loadListaMsUbigeoCodDpto=function(){
			$http.get(listaMsUbigeocodDptoCodDptoUrl).then(function(res){
				$scope.listaMsUbigeoCodDpto = res.data; 
			},
			function error(errResponse) {
				console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
			});
		};

		

		function obtenerLimitesDelMes(fecha) {
			// Clonamos la fecha para no modificar la original
			var primeraFechaDelMes = new Date(fecha.getFullYear(), fecha.getMonth(), 1);
			
			// Obtenemos el último día del mes siguiente y restamos un día
			var ultimoDiaDelMes = new Date(fecha.getFullYear(), fecha.getMonth() + 1, 0);
		  
			return {
			  primerDia: primeraFechaDelMes,
			  ultimoDia: ultimoDiaDelMes
			};
		  }


			$scope.dtVisitasFechas ={
				fechaprogramainicio: new Date(),
				fechaprogramafin: new Date()
			}

			var fechaActual = new Date();
			var limitesDelMesActual = obtenerLimitesDelMes(fechaActual);
			
			
			$scope.filtro.fechaInicio = limitesDelMesActual.primerDia;
			$scope.filtro.fechaFin = limitesDelMesActual.ultimoDia;
	
 /*Manuel*/


    //PURIBE
			$scope.buscarxcodEjec = function(dato){
				console.log('codigoEjecutora: '+ dato.codEjecutora);
				$scope.dlgInstmsInstitucionesDtoss=[];
				$scope.selectedItem = null;
				$scope.searchText = null;

				var surl = $scope.getURLEntidad(dato.codEjecutora);	    

				console.log('surl: '+ surl);
				$scope.dlgInstpromise = $http.get(surl).then(function(res){
					var resData = res.data;
					if(resData.length==0){
						$mdDialog.show(
							$mdDialog.alert()
							.parent(angular.element(document.body))
							.clickOutsideToClose(true)
							.title('BUSCAR POR CODIGO EJECUTORA')
							.textContent("NO SE ENCONTRARON DATOS CON "+dato.codEjecutora)
							.ariaLabel('BUSQUEDA')
							.ok('ACEPTAR') //PURIBE 29032024  INICIO-->
							.targetEvent(resData)
						);
					} else if(resData.length==1){
						var institucion = resData[0];
						console.log(JSON.stringify(institucion));
						$scope.dtVisitasModelo.codEjecutora = institucion.codEjec; 
			//				                dato.ruc = institucion.ruc;
			$scope.dtVisitasModelo.idEntidadTxt = institucion.razSocial;
			$scope.dtVisitasModelo.idEntidad = institucion.idEntidad;
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
					// PURIBE 29032024  INICIO
					console.log("Buscar por código ejecutora data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse.statusText + " xhrStat " + errResponse.xhrStatus);
					// PURIBE 29032024  FIN
					var errData = errResponse.data;
					if(errData && typeof(errData.message) != 'undefined'){
						$mdDialog.show(
							$mdDialog.alert()
							.parent(angular.element(document.body))
							.clickOutsideToClose(true)
							.title('Buscar por código ejecutora - Registramef')     // PURIBE 29032024  INICIO
							.textContent(errData.message)
							.ariaLabel('ERROR')
							.ok('ACEPTAR') //PURIBE 29032024  INICIO-->
							.targetEvent(errData)
						);
					}
				});
			};
    //PURIBE

	   //PURIBE
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
						var programada="?programada=121";
						var sUrl = listaMsInstitucionesidproveeUrl+query+programada;
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
							$scope.dtVisitasModelo.idEntidad = item.idEntidad;
							$scope.dtVisitasModelo.idEntidadTxt = item.razSocial;
							$scope.dtVisitasModelo.codEjecutora  = item.codEjec;
						}
					}
		//				    	AUTOCOMPLETE FIN
					   //PURIBE
					$scope.showdlgInstitucionDialog = function(ev) {		
		//				    		$scope.loadubigeodefecto();
		//				    		$scope.loadlistaPaises();
		//				    		$scope.loadlistaCoddptos();		
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
				
						//MPINARES 24012023 - FIN
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

			//puribe
					$scope.listalugarMsparametros=[];
					var idpadrelugar="123";
					
					$scope.loadlugarMsparametros=function(){
						var sUrl = listaMsparametrosUrl+idpadrelugar;
						$http.get(sUrl).then(function(res){
							$scope.listalugarMsparametros = res.data; 
						},
						function error(errResponse) {
							console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
						});
					};


					$scope.listafinanciamientoMsparametros=[];
					var idpadrefinanciamiento="323";
					$scope.loadfinanciaMsparametros=function(){
						var sUrl = listaMsparametrosUrl+idpadrefinanciamiento;
						$http.get(sUrl).then(function(res){
							$scope.listafinanciamientoMsparametros = res.data; 
						},
						function error(errResponse) {
							console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
						});
					};

					$scope.listaorigen=[];
					var idpadreorigen="126";
					$scope.loadorigenMsparametros=function(){
						var sUrl = listaMsparametrosUrl+idpadreorigen;
						$http.get(sUrl).then(function(res){
							$scope.listaorigen = res.data; 
							$scope.dtVisitasModelo.idOrigen = 127;// se agrega por default oferta
						},
						function error(errResponse) {
							console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
						});
					};

					
					$scope.loadorigenMsparametros();//puribe
					$scope.loadListaMsUbigeoCodDpto();//SELECT
					$scope.loadlugarMsparametros();//puribe
					$scope.loadfinanciaMsparametros();//puribe

					

					

		//puribe
 /*Manuel*/


 $scope.quitarClasePlaceholder = function() {
	// Utiliza $timeout para esperar a que termine el ciclo de digestión
		$timeout(function() {
			// Encuentra el label dentro de md-input-container y quita la clase md-placeholder
			var miLabel = angular.element(document.getElementById('miLabel'));
            miLabel.removeClass('md-placeholder');
			console.log('Elemento seleccionado:', miLabel);
		});
	};
	

	

	$scope.listaDtVisitas = [];

//puribe
	$scope.Parametro = {
		idparametrolugar: null,
		descripcionlugar: null,
		idfinanciamiento: null,
		descripcionfinancia: null
	}

		//	$scope.agregartema=function(valor)
		//	{
		//		$scope.vertema=valor;
				//id="formularioparticipante";
		//	}


			$scope.agregarparticipante = function (ev) {
				$mdDialog.show({
					controller: ParticipanteDialogController,
					templateUrl: modalparticipanteUrl,
					parent: angular.element(document.body),
					targetEvent: ev,
					clickOutsideToClose: true,
					fullscreen: false,
				})
					.then(function (visitausuario) {
						console.log(visitausuario);
						//PURIBE 29032024  INICIO-->
						
						  for (var i = 0; i < $scope.visitausuarios.length;i++)
						  {
						
							if  ($scope.visitausuarios[i].idTema ==visitausuario.idTema
								  &&  $scope.visitausuarios[i].idUsuinterno==visitausuario.idUsuinterno
								  &&  $scope.visitausuarios[i].estado==3)
								  {

									$mdDialog.show(
										$mdDialog.alert()
										.parent(angular.element(document.body))
										.clickOutsideToClose(true)
										.title('AGREGAR PARTICIPANTE')
										.textContent("ERROR,YA EXISTE EL TEMA SELECCIONADO CON EL PARTICIPANTE")
										.ariaLabel('WARNING')
										.ok('ACEPTAR') 
									);
										return;
								  }
						
						  }  
						 //PURIBE 29032024  FIN-->
						$scope.visitausuarios.push(visitausuario);
						console.log($scope.visitausuarios);
					}, function () {
		
					});
			}


	// PURIBE 29032024 - INICIO-->
	$scope.editarparticipant = function (ev,dato) {
		$mdDialog.show({
			controller: ParticipanteDialogController,
			templateUrl: modalparticipanteUrl,
			parent: angular.element(document.body),
			targetEvent: ev,
			clickOutsideToClose: true,
			fullscreen: false,
			locals: {
				visitausuario: dato // Pasar el objeto visitausuario al modal
			}
		})
			.then(function (visitausuario) {
				console.log(visitausuario);
				//$scope.instancias.forEach((element) => element.instanciaActual =  0);
				$scope.visitausuarios.push(visitausuario);
				console.log($scope.visitausuarios);
			}, function () {

			});
	}
	// PURIBE 29032024 - FIN-->

		
	// PURIBE 29032024 - INICIO-->
	$scope.eliminarParticipante = function (index) {
		$scope.visitausuarios[index].estado = 2;
	//	$scope.visitausuarios.splice(index, 1);
	}
	// PURIBE 29032024 - FIN -->



//puribe
	  $scope.dtVisitasModelo = {
			idVisita : null,
			fechaVisita: new Date(),
			conclusion: null,
			idOrigen: null,
			idProgramacion: null,
			idModalidad: null,
			idTipo: null,
			idLugar: null,
			idEntidad: null,
			idSede: null,
			idSistAdm: null,
			idFinancia: null,
			fechaFinalizacion: new Date(),
		fechaProgramada: new Date(),
		estado:null,

                        // ADICIONALES
	                estadoTxt: null,
		idOrigenTxt: null,
		idProgramacionTxt: null,
		idModalidadTxt: null,
		idTipoTxt: null,
		idLugarTxt: null,
		idEntidadTxt: null,
		idSedeTxt: null,
		idSistAdmTxt: null,
		idFinanciaTxt: null,
		idusuario:null,//PURIBE
		codEjecutora: null,//PURIBE
		visitaUsuarios: [], //PURIBE

		    editopcion: 1
		};
	  
	  $scope.cleardtVisitas = function(){
		    $scope.dtVisitasModelo.idVisita = null;
		    $scope.dtVisitasModelo.fechaVisita = null;
		    $scope.dtVisitasModelo.conclusion = null;
		    $scope.dtVisitasModelo.idOrigen = null;
		    $scope.dtVisitasModelo.idProgramacion = null;
		    $scope.dtVisitasModelo.idModalidad = null;
		    $scope.dtVisitasModelo.idTipo = null;
		    $scope.dtVisitasModelo.idLugar = null;
		    $scope.dtVisitasModelo.idEntidad = null;
		    $scope.dtVisitasModelo.idSede = null;
		    $scope.dtVisitasModelo.idSistAdm = null;
		    $scope.dtVisitasModelo.idFinancia = null;
			$scope.dtVisitasModelo.estado = null;
		    $scope.dtVisitasModelo.fechaFinalizacion = new Date();$scope.dtVisitasModelo.fechaProgramada = new Date();
                    // ADICIONALES
	            $scope.dtVisitasModelo.estadoTxt = null;
			$scope.dtVisitasModelo.idOrigenTxt = null;
			$scope.dtVisitasModelo.idProgramacionTxt = null;
			$scope.dtVisitasModelo.idModalidadTxt = null;
			$scope.dtVisitasModelo.idTipoTxt = null;
			$scope.dtVisitasModelo.idLugarTxt = null;
			$scope.dtVisitasModelo.idEntidadTxt = null;
			$scope.dtVisitasModelo.idSedeTxt = null;
			$scope.dtVisitasModelo.idSistAdmTxt = null;
			$scope.dtVisitasModelo.idFinanciaTxt = null;
			$scope.dtVisitasModelo.idusuario= null;
			$scope.dtVisitasModelo.codEjecutora = null;
			$scope.dtVisitasModelo.visitaUsuarios=null; //puribe

		    $scope.dtVisitasModelo.editopcion = 1;
	 } 
	 
	  $scope.setDtVisitasModelo = function(dtVisitasBk) {

		  $scope.dtVisitasModelo.idVisita = dtVisitasBk.idVisita;
			$scope.dtVisitasModelo.fechaVisita = dtVisitasBk.fechaVisita;
			$scope.dtVisitasModelo.conclusion = dtVisitasBk.conclusion;
			$scope.dtVisitasModelo.idOrigen = dtVisitasBk.idOrigen;
			$scope.dtVisitasModelo.idProgramacion = dtVisitasBk.idProgramacion;
			$scope.dtVisitasModelo.idModalidad = dtVisitasBk.idModalidad;
			$scope.dtVisitasModelo.idTipo = dtVisitasBk.idTipo;
			$scope.dtVisitasModelo.idLugar = dtVisitasBk.idLugar;
			$scope.dtVisitasModelo.idEntidad = dtVisitasBk.idEntidad;
			$scope.dtVisitasModelo.idSede = dtVisitasBk.idSede;
			$scope.dtVisitasModelo.idSistAdm = dtVisitasBk.idSistAdm;
			$scope.dtVisitasModelo.estado = dtVisitasBk.estado;
			$scope.dtVisitasModelo.idFinancia = dtVisitasBk.idFinancia;
			$scope.dtVisitasModelo.fechaFinalizacion = dtVisitasBk.fechaFinalizacion;
                        if(!$scope.isNull($scope.dtVisitasModelo.fechaFinalizacion) && !isNaN($scope.dtVisitasModelo.fechaFinalizacion)){
			    $scope.dtVisitasModelo.fechaFinalizacion = new Date($scope.dtVisitasModelo.fechaFinalizacion);
		        }
			$scope.dtVisitasModelo.fechaProgramada = dtVisitasBk.fechaProgramada;
									if(!$scope.isNull($scope.dtVisitasModelo.fechaProgramada) && !isNaN($scope.dtVisitasModelo.fechaProgramada)){
							$scope.dtVisitasModelo.fechaProgramada = new Date($scope.dtVisitasModelo.fechaProgramada);
							}

		


                        // ADICIONALES
	                $scope.dtVisitasModelo.estadoTxt = dtVisitasBk.estadoTxt;
				$scope.dtVisitasModelo.idOrigenTxt = dtVisitasBk.idOrigenTxt;
				$scope.dtVisitasModelo.idProgramacionTxt = dtVisitasBk.idProgramacionTxt;
				$scope.dtVisitasModelo.idModalidadTxt = dtVisitasBk.idModalidadTxt;
				$scope.dtVisitasModelo.idTipoTxt = dtVisitasBk.idTipoTxt;
				$scope.dtVisitasModelo.idLugarTxt = dtVisitasBk.idLugarTxt;
				$scope.dtVisitasModelo.idEntidadTxt = dtVisitasBk.idEntidadTxt;
				$scope.dtVisitasModelo.idSedeTxt = dtVisitasBk.idSedeTxt;
				$scope.dtVisitasModelo.idSistAdmTxt = dtVisitasBk.idSistAdmTxt;
				$scope.dtVisitasModelo.idFinanciaTxt = dtVisitasBk.idFinanciaTxt;
				$scope.dtVisitasModelo.codEjecutora=  dtVisitasBk.codEjecutora; /* PURIBE 29032024 - INICIO*/

			$scope.dtVisitasModelo.editopcion = dtVisitasBk.dtVisitasACL.editopcion;
		}
	  // ////////////////////////////////////////////////
	
	/* PURIBE 01022024 - FIN */
 		//puribe

		//puribe
		 $scope.setDtVisitasusuario = function(visitausuario) {
		//	$scope.dtVisitasModelo.visitaUsuarios.push({ idtema: visitausuario.idVisita });
				$scope.visitausuarios =[]
			for (var i = 0; i < visitausuario.length; i++) {
			
				$scope.visitausuarios.push(visitausuario[i]);
			}
	
		 }
	  //puribe

	  $scope.editarDtVisitas = function(ev, dtVisitasBk) {		  
		    $scope.setDtVisitasModelo(dtVisitasBk);		

			//$scope.filtro.fechaInicio = limitesDelMesActual.primerDia;
			//$scope.filtro.fechaFin = limitesDelMesActual.ultimoDia;  

			$location.url('/editar/' + $scope.dtVisitasModelo.idVisita+ '/' +$scope.filtro.fechaInicio+ '/' +$scope.filtro.fechaFin);
		//	+ '/' + $scope.msUbigeoModelo.codProv + '/' + msUbigeoBk.id.codDistr);
			$scope.nuevo = false;
	  }
	   //puribe
	    //puribe
	  $scope.nuevoDtVisitas = function() {
		    $scope.cleardtVisitas();
			$location.url('/nuevo/'+$scope.filtro.fechaInicio+ '/' +$scope.filtro.fechaFin);
			$scope.nuevo = true;
	  }
	  	    //puribe
	  $scope.cancelarDtVisitas = function() {
		    $scope.cleardtVisitas();
		    $location.url('/');
	  }
	  			  


		///////////////////////////////////////////////////////////////
		function mapUsuarioVisita(visitausuario) {
			return {
				
				idUsuinterno: visitausuario.idusuario,
				idTema: visitausuario.idtema
			};
		}

		// Mapear cada elemento de $scope.visitausuarios a un objeto UsuarioVisita
		
		///////////////////////////////////////////////////////////////////////////////

	    //puribe
	  $scope.salvarDtVisitas = function(ev){		
				    ev.target.disabled = true;
					$scope.dtVisitasModelo.visitaUsuarios=[];
				for (var i = 0; i < $scope.visitausuarios.length; i++) {
					var usuario = $scope.visitausuarios[i];

					if(usuario.idusuario != null){
				
						$scope.dtVisitasModelo.visitaUsuarios.push({
						
							idVisitUsuint:usuario.idVisitUsuint,
							idUsuinterno: usuario.idusuario,
							idTema: usuario.idTema,
							estado:usuario.estado /* PURIBE 29032024 - INICIO */
							
						});
					}
					else{

						$scope.dtVisitasModelo.visitaUsuarios.push({
						
							idVisitUsuint:usuario.idVisitUsuint,
							idUsuinterno: usuario.idUsuinterno,
							idTema: usuario.idTema,
							estado:usuario.estado /* PURIBE 29032024 - INICIO */
							
						});

					}

				}

				/* PURIBE 29032024 - INICIO*/
				// Verifica si todos los elementos tienen el estado 2
			var todosEstado2 = $scope.dtVisitasModelo.visitaUsuarios.every(function(usuario) {
				return usuario.estado === 2;
			});

				if ($scope.dtVisitasModelo.visitaUsuarios.length === 0 || todosEstado2 ) 
				{
					/* PURIBE 29032024 - FIN */
					 var confirm = $mdDialog.confirm()
					.title('Participante')
					.textContent('Seleccione participante para poder grabar')
					.ariaLabel('Validación')
					.targetEvent(ev)
					.ok('ACEPTAR') //PURIBE 29032024  INICIO-->
					.theme('warn'); 

				$mdDialog.show(confirm).then(function () {
					// Lógica a realizar si se hace clic en OK
					$scope.status = 'OK';
					return;
				}, function () {
					// Lógica a realizar si se hace clic en Cancelar
					$scope.status = 'Cancelado';
					return;
				});

			}
	    //puribe

				 /* PURIBE 29032024 - INICIO*/
				else{
					var datainsert = angular.toJson($scope.dtVisitasModelo);
					 
						console.log("datainsert = " + angular.toJson(datainsert));	

						var surl = $scope.getURLsalvar();	

			        		$http.post(surl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
								var dato = res.data;

//			    				$scope.datos.push(dato); 
							$scope.visitausuarios = dato.visitaUsuarios;
			    				$scope.total = $scope.datos.length;
			    				
			    				$scope.setDtVisitasModelo(dato);
							//	setDtVisitasusuario
			    				
			    				$mdDialog.show(
								         $mdDialog.alert()
								        .parent(angular.element(document.body))
								        .clickOutsideToClose(true)
								        .title('Guardar reunión de trabajo')  //PURIBE 29032024  INICIO-->
								        .textContent("Reunión de trabajo se guardó correctamente.")//PURIBE 29032024  INICIO-->
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
									         $mdDialog.alert()
									        .parent(angular.element(document.body))
									        .clickOutsideToClose(true)
									        .title('Guardar reunión de trabajo') //PURIBE 29032024  INICIO-->
									        .textContent(dato.message)
									        .ariaLabel('ERROR')
									        .ok('ACEPTAR')
									        .targetEvent(ev)
									    );
					            }
					        });		
			        			        	
			        	ev.target.disabled = false;
		 		 }
				 /* PURIBE 29032024 - FIN*/
			 };
			 
	   $scope.eliminardtVisitas = function(ev){		
				    ev.target.disabled = true;
					//puribe
  				//PURIBE 01022024 - INICIO-->
		
				    var datainsert = angular.toJson($scope.listaDtVisitas);
					var surl = $scope.getURLeliminar();	 

		 			console.log("datainsert = "+datainsert);	
	        		$http.post(surl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
						var dato = res.data;
						var instrumentos = $scope.datos;
				        var index = $scope.datos.findIndex(obj => obj.idVisita === dato.idVisita);
						console.log("INDEX " + index);
				        if(instrumentos.length>index){
				        	instrumentos.splice(index, 1);
					        $scope.datos = instrumentos;
					        $scope.total = $scope.datos.length;
				        }	
						//puribe
						$scope.loaddtVisitass();
					},
					function error(errResponse) {
			            console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
			            var dato = errResponse.data;
			            if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
			            	$mdDialog.show(
					         $mdDialog.alert()
					        .parent(angular.element(document.body))
					        .clickOutsideToClose(true)
					        .title('Eliminar reuniones de trabajo') //PURIBE 29032024  INICIO-->
					        .textContent(dato.message)
					        .ariaLabel('ERROR')
					        .ok('ACEPTAR') //PURIBE 29032024  INICIO-->
					        .targetEvent(ev)
						   );
			            }
			        });			        			        	
		        	ev.target.disabled = false;
			 };	

 		 //PURIBE 12022024 - INICIO-->
		 //puribe
			 $scope.reactivardtVisitas = function(ev,dtVisitasBk){		
				ev.target.disabled = true;
				$scope.setDtVisitasModelo(dtVisitasBk);	
				var datainsert = angular.toJson($scope.dtVisitasModelo);

				var surl = $scope.getURLreactiva();	 
				//reactivardtVisitasUrl   
				
				 console.log("datainsert = "+datainsert);	
				$http.post( surl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
					var dato = res.data;
					var instrumentos = $scope.datos;
					var index = $scope.datos.findIndex(obj => obj.idVisita === dato.idVisita);
					console.log("INDEX " + index);
					if(instrumentos.length>index){
						instrumentos.splice(index, 1);
						$scope.datos = instrumentos;
						$scope.total = $scope.datos.length;
					}	
					$scope.loaddtVisitass();
				},
				function error(errResponse) {
					console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
					var dato = errResponse.data;
					if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
						$mdDialog.show(
						 $mdDialog.alert()
						.parent(angular.element(document.body))
						.clickOutsideToClose(true)
						.title('Eliminar Visitas')
						.textContent(dato.message)
						.ariaLabel('ERROR')
						.ok('ACEPTAR') //PURIBE 29032024  INICIO-->
						.targetEvent(ev)
					   );
					}
				});			        			        	
				ev.target.disabled = false;
		 };	
		 //puribe
			//PURIBE 12022024 - FIN-->
			//puribe
			$scope.formatD = function(dateString) {
				var date = new Date(dateString);
				return date;
			};

			//puribe
		$scope.cargardtVisitas = function(idVisita){		
			var surl = editardtVisitasUrl+idVisita;
			$http.get(surl).then(function(res){
				var dato = res.data;
				dato.fechaVisita = $scope.formatD(dato.fechaVisita);
				$scope.visitausuarios = dato.visitaUsuarios
				$scope.setDtVisitasModelo(dato);
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
					        .title('Cargar Visitas')
					        .textContent(dato.message)
					        .ariaLabel('ERROR')
					        .ok('ACEPTAR') //PURIBE 29032024  INICIO-->
						   );
			            }			           
			        });			        			        	
			 };
			 //PURIBE 12022024 - INICIO-->
			//PURIBE 12022024 - INICIO-->
				$scope.showConfirmEliminar= function(ev, dtVisitasBk) {
					//PURIBE 29032024  INICIO-->
					if ($scope.listaDtVisitas.length>0) 
					{
						    var confirm = $mdDialog.confirm()
						      .title('Eliminar reuniones de trabajo')
						      .textContent('¿Está usted seguro de eliminar el registro?')
						      .ariaLabel('Lucky day')
						      .targetEvent(ev)
						      .ok('Si')
						      .cancel('No');

						    $mdDialog.show(confirm).then(function () {
						      $scope.status = 'SI';
						      $scope.eliminardtVisitas(ev, dtVisitasBk);
						    }, function () {
						      $scope.status = 'NO';
						    });
						}
						 //PURIBE 29032024  FIN-->
				  };		  
				 
			$scope.showConfirmReactivar= function(ev, dtVisitasBk) {
				 //PURIBE 29032024  INICIO-->
				var confirm = $mdDialog.confirm()
					.title('Reactivar Reunión de trabajo')
					.textContent('Está usted seguro de reactivar el registro?')
					.ariaLabel('Lucky day')
					.targetEvent(ev)
					.ok('Si')
					.cancel('No');

				$mdDialog.show(confirm).then(function () {
					$scope.status = 'SI';
					$scope.reactivardtVisitas(ev, dtVisitasBk);
					//$scope.eliminardtVisitas(ev, dtVisitasBk);
				}, function () {
					$scope.status = 'NO';
				});
					 //PURIBE 29032024  FIN-->
			};	
				   //PURIBE 12022024 - FIN-->
///ADICIONALES
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
        $scope.$watch('dtVisitasModelo.idOrigen', function (newValue, oldValue) {
		console.log('dtVisitasModelo.idOrigen ' + newValue+' -- '+oldValue);
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
        $scope.$watch('dtVisitasModelo.idModalidad', function (newValue, oldValue) {
		console.log('dtVisitasModelo.idModalidad ' + newValue+' -- '+oldValue);
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
        $scope.$watch('dtVisitasModelo.idTipo', function (newValue, oldValue) {
		console.log('dtVisitasModelo.idTipo ' + newValue+' -- '+oldValue);
		//CARGAR DATOS DEL SIGUIENTE SELECT
	});
//SELECT FIN                
//SELECT INI
        $scope.listaPrtParametrosIdLugar=[];
	$scope.loadListaPrtParametrosIdLugar=function(){
		$http.get(listaPrtParametrosidparametroIdLugarUrl).then(function(res){
			$scope.listaPrtParametrosIdLugar = res.data; 
		},
		function error(errResponse) {
			console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		});
	};
        $scope.changeIdLugar=function(){
          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
        }
        $scope.$watch('dtVisitasModelo.idLugar', function (newValue, oldValue) {
		console.log('dtVisitasModelo.idLugar ' + newValue+' -- '+oldValue);
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
        $scope.$watch('dtVisitasModelo.idSede', function (newValue, oldValue) {
		console.log('dtVisitasModelo.idSede ' + newValue+' -- '+oldValue);
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
        $scope.$watch('dtVisitasModelo.idFinancia', function (newValue, oldValue) {
		console.log('dtVisitasModelo.idFinancia ' + newValue+' -- '+oldValue);
		//CARGAR DATOS DEL SIGUIENTE SELECT
	});
//SELECT FIN    
        
      //PURIBE 29032024  INICIO-->
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
        //PURIBE 29032024  FIN-->


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
				  
		    $scope.nuevo = ($scope.isNumber($scope.dtVisitasModelo.idVisita) && $scope.dtVisitasModelo.idVisita > 0);
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
			 
			$scope.filtroDtVisitas = function(toma){				
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
					  	/*PURIBE 01022024 - INICIO-->*/
						  $timeout(function() {
							$scope.quitarClasePlaceholder();
						});  
				   /*PURIBE 01022024 - FIN-->*/



				   function ParticipanteDialogController($scope, $mdDialog) {

					$scope.formCol1WidthPercentage = 20;
					$scope.formCol2WidthPercentage = 45;
					$scope.formCol3WidthPercentage = 15;
					$scope.formCol4WidthPercentage = 20;
			
					$scope.visitausuarios = [];
					$scope.etapas = [];
					

					$scope.usuario = {};
					$scope.tema = {};
					

					$scope.visitausuario = {
						idusuario:null,
						idUsuinterno:null,
						idUsuinternoTxt:null,
						idSistAdm : null,
						idSistAdmTxt: null,
						idTema:null,
						idTemaTxt:null,
						estado:3, //  PURIBE 29032024 - INICIO -->
						instanciaActual:1
					}

					$scope.visitausuario.idusuario = null;
				
					$scope.determinateValue = 0;
					$scope.activar = 0;
			
					
			
					$scope.hide = function () {
					//	$scope.instancia.instancia = $scope.selectedItem;
						$mdDialog.hide($scope.visitausuario);
					};
			
					$scope.cancel = function () {
						$mdDialog.cancel();
					};
			

					$scope.changetema=function(dato){
						$scope.visitausuario.idTema = dato.idTema;
						$scope.visitausuario.idTemaTxt= dato.idTemaTxt;
					}

					$scope.changeSistemAd=function(dato){
						var miPromesa = new Promise(function(resolve, reject) {
						$scope.activar=0;
						$scope.listamstemas=null;
						$scope.visitausuario.idUsuinterno= dato.idusuario;
						$scope.visitausuario.idUsuinternoTxt = dato.idUsuinternoTxt;
						$scope.visitausuario.idSistAdm = dato.idSistAdmi;     
						$scope.visitausuario.idSistAdmTxt = dato.idSistAdmiTxt;
						$scope.loadlistamstema($scope.visitausuario.idSistAdm).then(function(response) { 
							resolve("La operación fue exitosa");
						 })
						.catch(function(error) {
						   // La solicitud falló, puedes manejar el error aquí
						   console.error("Error:", error);
						   reject("Hubo un error en la operación");
						});

						
					});

							miPromesa
							.then(function(resultado) {
							console.log("Éxito:", resultado);
							$scope.activar=1;
							
							})
							.catch(function(error) {
							console.error("Error:", error);
							
							});
							
					};
					

					$scope.listainternoMsusuarios=[];
					$scope.loadlistamsusuarios=function(){
						var sUrl = listaMsUsuarios;
						$http.get(sUrl).then(function(res){
							$scope.listainternoMsusuarios = res.data; 
							$scope.determinateValue = 100;
						},
						function error(errResponse) {
							console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
						});
					};

					$scope.listainternoMsusuariosVisitas=[];

					$scope.loadlistamsusuariosVisitas=function(){
					
						var sUrl = listaMsUsuarios;
						$http.get(sUrl).then(function(res){
							$scope.listainternoMsusuarios = res.data; 
							$scope.determinateValue = 100;
						
						},
						function error(errResponse) {
							console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
							
						});
					};
				




					$scope.listamstemas=[];
					$scope.loadlistamstema=function(idSistAdm){
						var sUrl = listaMStema  + idSistAdm;

						 return $http.get(sUrl).then(function(res){
							$scope.listamstemas = res.data; 
							$scope.determinateValue = 100;
							return res;
						})
						.catch(function(errResponse) {
						
							console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
							throw errResponse; 
						 });
					};

				
			

					$scope.loadlistamsusuarios();
						





					//$scope.loadEtapas();
				}
			


// PURIBE 21032024 - FIN -->

}]);
