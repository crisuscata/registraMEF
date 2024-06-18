var contexto = window.location.pathname.substring(0,window.location.pathname.indexOf('/',2));
var pglogoff = window.location.origin+contexto+'/logoff.htm';
var principalUrl = window.location.origin+contexto+'/index.htm';
var perfilUrl = contexto+"/rs/ctrltitulo/perfilusuario";

var editarprtParametrosUrl = contexto+"/rs/ctrltitulo/editarprtParametros/"; //PURIBE 21032024 - INI
var actualizanotificacionUrl = contexto+"/rs/ctrltitulo/actualizanotificacion";//PURIBE 21032024 - INI

//MPINARES 14022024 - INICIO
var listaPrtParametrosidparametroIdTipoServicioUrl = contexto+"/rs/ctrltitulo/listaPrtParametrosIdparametroIdTipoServicio";
var editardtCapacitacionUrl = contexto+"/rs/ctrldtCapacitacion/editardtCapacitacion/";
var editardtAsistenciaUrl = contexto+"/rs/ctrldtAsistencia/editardtAsistencia/";
var editardtVisitasUrl = contexto+"/rs/ctrldtVisitas/editardtVisitas/";
var editardtConsultasUrl = contexto+"/rs/ctrldtConsultas/editardtConsultas/";
var capaeditUrl = window.location.origin+contexto+'/capacitacion/listadtCapacitacion.html';
var asisteditUrl = window.location.origin+contexto+'/asistencia/listadtAsistencia.html';
var visiteditUrl = window.location.origin+contexto+'/visitas/listadtVisitas.html';
var consueditUrl = window.location.origin+contexto+'/consultas/listadtConsultas.html';
//MPINARES 14022024 - FIN

myapp = angular.module('MyApp');

myapp.config(['$mdPanelProvider', function ($mdPanelProvider) {
	$mdPanelProvider.definePreset('infoPanel', {
		attachTo: angular.element(document.body),
		controller: ['mdPanelRef', function(mdPanelRef) {

			var mdPanelRef = mdPanelRef;

			this.closeMenu = function() {
				mdPanelRef && mdPanelRef.close();
			};   

			this.showdlgCambioContrasenia = function(){
				this.$scope.$parent.$broadcast('showdlgCambioContraseniaX', 'X');
//				this.$scope.$root.$broadcast('showdlgCambioContraseniaX', 'X');
			};  
		}],
		controllerAs: 'ctrl',
		template: '' +
		'<div style="margin-left: 15px;margin-top: 25px;" ng-mouseleave="ctrl.closeMenu()">' +	          
		'  <div>' +
		'  <table>' +
		'  <tr>' +
		'  <td>' +
		'        <span style="font-size: 14px !important;color:#555753;"><b>{{ctrl.nombrecompleto}}</b></span>' +
		'  </td>' +
		'  <td>' +
		'        <span style="font-size: 22px !important;color:#555753;background-color: #EEEEEC;margin-left: 15px;" ><md-icon md-font-set="material-icons">person</md-icon></span>' +
		'  <td>' +
		'  </tr>' +
		'  </table>' +
		'    </div>' +
		'    <md-divider class="menu-divider"></md-divider>' +
		'        <div>&nbsp;</div>' +
		'        <div style="font-size: 14px !important;color:#555753;">{{ctrl.sede}}</div>' +
		'        <div style="font-size: 14px !important;color:#555753;">{{ctrl.idunidadTxt}}</div>' +
		'    <md-divider class="menu-divider"></md-divider>' +
		'        <div layout="row" layout-align="end center" flex>' +
		'        <md-button class="menu-button" ng-click="ctrl.showdlgCambioContrasenia()">' + 
		'        <md-icon md-svg-icon="resources/icons/power_settings_new-24px.svg" aria-label="Salir">' +
		'        </md-icon>' + 
		'        </md-button>' +
		'        </div>' +
		'        <div>&nbsp;</div>' +
		'</div>',
		panelClass: 'idea',
		focusOnOpen: false,
		zIndex: 100,
		propagateContainerEvents: true,
		groupName: 'infos',
	});
}]);

myapp.config(['$mdPanelProvider', function ($mdPanelProvider) {
	$mdPanelProvider.definePreset('notiPanel', {
		attachTo: angular.element(document.body),
		controller: ['mdPanelRef', function(mdPanelRef) {
			this.closeMenu = function() {
				mdPanelRef && mdPanelRef.close();
			};
			this.formatDate = function(dia){     
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
		}],
		controllerAs: 'ctrl',
		template: '' +
		//PURIBE 22032024 - INI
		'<div>' +	          
		'  <div>' +
		'        <span style="font-size: 16px !important;color:rgba(0, 150, 136, 1);"><b>NOTIFICACIONES</b></span>' +
		'  </div>' +
		'    <md-divider class="menu-divider"></md-divider>' +
		'<div>' +		//PURIBE 29032024 - INI
		'<div ng-repeat="pendiente in ctrl.pendientes">'+
		'        <div style="font-size: 14px !important;color:#555753;width:290px;height:80px;overflow-y: auto; white-space: pre-wrap;">{{pendiente.descripcion}}</div>' +
		'<div>' +
		//PURIBE 29032024 - FIN
//		'<div ng-mouseleave="ctrl.closeMenu()">' +	          
//		'  <div>' +
//		'        <span style="font-size: 14px !important;color:#CC0000;"><b>Notificaciones</b></span>' +
//		'  </div>' +
//		'    <md-divider class="menu-divider"></md-divider>' +
//		'<div ng-repeat="x in ctrl.pendientes">' +
//		'        <div style="font-size: 14px !important;color:#555753;">Se acaba de asignar nueva consultaTener en cuenta que según el numeral 5.5.4. de la Directiva N° 005-2021-EF/45.01, el registro de información sobre los servicios prestados se realiza a través del REGISTRAMEF en el plazo máximo de dos (2) días hábiles con posterioridad a su ejecución.</div>' +
//		'        <div>&nbsp;</div>' +
//		'		<div style="font-size: 14px !important;color:#555753;">Asimismo, el numeral 5.5.4.3. de la citada directiva, establece que el registro de la capacitación es efectuado por el/la asistente de gestión de servicios o el/la gestor/a de centro.</div>' +
//		'        <div style="font-size: 14px !important;color:#555753;">{{ctrl.formatDate(x.miflujo.fechaDerivacion)}}</div>' +
		'    <md-divider class="menu-divider"></md-divider>' +
//		'</div>' +
		'        <div>&nbsp;</div>' +
		'        <div>&nbsp;</div>' +
		'</div>',
		panelClass: 'noti',
		focusOnOpen: false,
		zIndex: 100,
		propagateContainerEvents: true,
		groupName: 'infos',
		size: '200px',
	});
}]);

myapp.controller('tituloCtrl', ['$mdEditDialog', '$scope', '$timeout', '$http', '$mdDialog','$location','$routeParams','$mdPanel','$interval', function ($mdEditDialog, $scope, $timeout, $http, $mdDialog, $location, $routeParams, $mdPanel, $interval) {

	$scope.msUsuariosPerfilJS = {
			idusuario: null,
			username: null,
			nombrecompleto: null,
			contrasenia: null,
			sede: null,
			idunidad: null,
			idunidadTxt: null,
			contraseniaConfir: null
	};

	$scope.inicializacion = function(){
		$scope.cargarperfil();
//		$scope.loadtdPendientes();
	}	
	$scope.listaPrtParametros=[];    //PURIBE 29032024 - INICIO->
	$scope.ctrl.contadorNotificaciones = $scope.listaPrtParametros.length; // <!--PURIBE 29032024  INICIO> Inicializa el contador
	
	//MPINARES 14022024 - INICIO
	$scope.datosBusqueda = {
			idregistro: null,
			idtiposervicio: null
	};
	
	$scope.cleardatosBusqueda= function(){
		$scope.datosBusqueda.idregistro= null;
		$scope.datosBusqueda.idtiposervicio= null;
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
	
	 $scope.buscarServicio = function(ev) {
			ev.target.disabled = true;
			$scope.cleardatosBusqueda();	
			$scope.loadListaPrtParametrosIdTipoServicio();//SELECT
			$mdDialog.show({
				templateUrl: contexto+"/dialogos/busquedaServicio.html",
				scope: $scope,
				preserveScope: true,
				//controller: mdDialogInstitucionCtrl,                	
				parent: angular.element(document.body),
				targetEvent: ev,
				clickOutsideToClose: true
			}).then($scope.closeDialog, $scope.cancelDialod);	
			ev.target.disabled = false;
		};
		
	      //SELECT INI
        $scope.listaPrtParametrosIdTipoServicio=[];
	$scope.loadListaPrtParametrosIdTipoServicio=function(){
		$http.get(listaPrtParametrosidparametroIdTipoServicioUrl).then(function(res){
			$scope.listaPrtParametrosIdTipoServicio = res.data; 
		},
		function error(errResponse) {
			console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		});
	};
        $scope.changeIdTipoServicio=function(){
          ///BLANQUEAR LOS CAMPOS QUE DEPENDEN DE ESTE SELECT
        }
        $scope.$watch('datosBusqueda.idtiposervicio', function (newValue, oldValue) {
		console.log('datosBusqueda.idtiposervicio ' + newValue+' -- '+oldValue);
		//CARGAR DATOS DEL SIGUIENTE SELECT
	});
//SELECT FIN
        
        $scope.buscarXTipoServicio = function (ev){
    		if(!$scope.isNumber($scope.datosBusqueda.idregistro) || $scope.isNull($scope.datosBusqueda.idregistro) || $scope.datosBusqueda.idregistro<1){
    			$mdDialog.show(
    					$mdDialog.alert()
    					.parent(angular.element(document.body))
    					.clickOutsideToClose(true)
    					.title('Buscar Servicio')
    					.textContent("Debe ingresar un ID de registro válido...")
    					.ariaLabel('ERROR')
    					.ok('OK')
    			);
    			return;
    		}
    		
    		if(!$scope.isNumber($scope.datosBusqueda.idtiposervicio) || $scope.isNull($scope.datosBusqueda.idtiposervicio) || $scope.datosBusqueda.idtiposervicio<1){
    			$mdDialog.show(
    					$mdDialog.alert()
    					.parent(angular.element(document.body))
    					.clickOutsideToClose(true)
    					.title('Buscar Servicio')
    					.textContent("Debe seleccionar el tipo de servicio...")
    					.ariaLabel('ERROR')
    					.ok('OK')
    			);
    			return;
    		}
    		
    		ev.target.disabled = true;	
    		//CAPACITACIONES
    		if($scope.datosBusqueda.idtiposervicio==133){
    			var surl = editardtCapacitacionUrl+$scope.datosBusqueda.idregistro;	    
        		$scope.promise = $http.get(surl).then(function(res){
        			var dato = res.data;
        			window.location.href=capaeditUrl+'#!/editar/' + $scope.datosBusqueda.idregistro; 
        			ev.target.disabled = false;			
        		},
        		function error(errResponse) {
		            console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		            var dato = errResponse.data;
		            if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
		            	$mdDialog.show(
				         $mdDialog.alert()
				        .parent(angular.element(document.body))
				        .clickOutsideToClose(true)
				        .title('Buscar Servicio')
				        .textContent("NO SE ENCONTRARON RESULTADOS EN LA BUSQUEDA...")
				        .ariaLabel('ERROR')
				        .ok('OK')
					   );
		            }			           
		        });		
    		}
    		
    		//ASISTENCIAS
    		if($scope.datosBusqueda.idtiposervicio==132){
    			var surl = editardtAsistenciaUrl+$scope.datosBusqueda.idregistro;	    
        		$scope.promise = $http.get(surl).then(function(res){
        			var dato = res.data;
        			window.location.href=asisteditUrl+'#!/editar/' + $scope.datosBusqueda.idregistro; 
        			ev.target.disabled = false;			
        		},
        		function error(errResponse) {
		            console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		            var dato = errResponse.data;
		            if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
		            	$mdDialog.show(
				         $mdDialog.alert()
				        .parent(angular.element(document.body))
				        .clickOutsideToClose(true)
				        .title('Buscar Servicio')
				        .textContent("NO SE ENCONTRARON DATOS EN LA BUSQUEDA..."+dato.message)
				        .ariaLabel('ERROR')
				        .ok('OK')
					   );
		            }			           
		        });		
    		}
    		
    		//VISITAS
    		if($scope.datosBusqueda.idtiposervicio==134){
    			var surl = editardtVisitasUrl+$scope.datosBusqueda.idregistro;	    
        		$scope.promise = $http.get(surl).then(function(res){
        			var dato = res.data;
        			window.location.href=visiteditUrl+'#!/editar/' + $scope.datosBusqueda.idregistro; 
        			ev.target.disabled = false;			
        		},
        		function error(errResponse) {
		            console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		            var dato = errResponse.data;
		            if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
		            	$mdDialog.show(
				         $mdDialog.alert()
				        .parent(angular.element(document.body))
				        .clickOutsideToClose(true)
				        .title('Buscar Servicio')
				        .textContent("NO SE ENCONTRARON DATOS EN LA BUSQUEDA..."+dato.message)
				        .ariaLabel('ERROR')
				        .ok('OK')
					   );
		            }			           
		        });	
    		}
    		
    		//CONSULTAS
    		if($scope.datosBusqueda.idtiposervicio==135){
    			var surl = editardtConsultasUrl+$scope.datosBusqueda.idregistro;	    
        		$scope.promise = $http.get(surl).then(function(res){
        			var dato = res.data;
        			window.location.href=consueditUrl+'#!/editar/' + $scope.datosBusqueda.idregistro; 
        			ev.target.disabled = false;			
        		},
        		function error(errResponse) {
		            console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
		            var dato = errResponse.data;
		            if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
		            	$mdDialog.show(
				         $mdDialog.alert()
				        .parent(angular.element(document.body))
				        .clickOutsideToClose(true)
				        .title('Buscar Servicio')
				        .textContent("NO SE ENCONTRARON DATOS EN LA BUSQUEDA..."+dato.message)
				        .ariaLabel('ERROR')
				        .ok('OK')
					   );
		            }			           
		        });	
    		}
    		
    	};
    	
    	// Returns if a value is a string
		  $scope.isString  = function(value) {
		  return typeof value === 'string' || value instanceof String;
		  };
		  
			// Returns if a value is really a number
			$scope.isNumber  = function(value) {
				return typeof value === 'number' && isFinite(value);
			};	
				
			// Returns if a value is null
			  $scope.isNull = function(value) {
			  return value === null;
			  };
			  
	//MPINARES 14022024 - FIN

	//PURIBE 25012024 - INI
	$scope.notificacionMostrada = false;

	$scope.prtParametrosModelo = {
			idparametro : null,
			descripcion: null,
			notificacion:null,
			editopcion:null,
			idpadreTxt:null, 
			estado:null, 
			estadoTxt:null, 
			idpadre:null 

	};

	$scope.setPrtParametrosModelo = function(prtParametrosBk) {
		$scope.prtParametrosModelo.idparametro = prtParametrosBk.idparametro;
		$scope.prtParametrosModelo.descripcion = prtParametrosBk.descripcion;
		$scope.prtParametrosModelo.notificacion = prtParametrosBk.notificacion;
//		$scope.pendientes = $scope.prtParametrosModelo.notificacion; //PURIBE 29032024
	}
	//PURIBE 25012024 - FIN

	$scope.setPerfil = function(dato){
		$scope.msUsuariosPerfilJS.idusuario = dato.idusuario;
		$scope.msUsuariosPerfilJS.username = dato.username;
		$scope.msUsuariosPerfilJS.nombrecompleto = dato.nombrecompleto;
		$scope.msUsuariosPerfilJS.contrasenia = dato.contrasenia;
		$scope.msUsuariosPerfilJS.sede = dato.sede;
		$scope.msUsuariosPerfilJS.idunidad = dato.idunidad;
		$scope.msUsuariosPerfilJS.idunidadTxt = dato.idunidadTxt;
		$scope.msUsuariosPerfilJS.contraseniaConfir = dato.contraseniaConfir;
	};

	$scope.cargarperfil = function(){		
		var surl = perfilUrl;
		$http.get(surl).then(function(res){
			var dato = res.data;
			$scope.setPerfil(dato);
		},
		function error(errResponse) {
			console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
			var dato = errResponse.data;
			if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
				$mdDialog.show(
						$mdDialog.alert()
						.parent(angular.element(document.body))
						.clickOutsideToClose(true)
						.title('Cargar perfil')
						.textContent(dato.message)
						.ariaLabel('ERROR')
						.ok('OK')
						.targetEvent(ev)
				);
			}			           
		});			        			        	
	};

	$scope.getClassNotifica = function(){
		if($scope.pendientes.length>0){
			return 'red';
		}
		return '';	
	}

	$scope.getClassUsuario = function(){		
		return '';	
	}

	$scope.getTotalNotifica = function(){
		if($scope.pendientes.length>0){
			return ('00' + $scope.pendientes.length).slice(-2);
		}
		return '';	
	}

	$scope.cancel = function() {
		$mdDialog.cancel();
	};

	$mdPanel.newPanelGroup('infos', {
		maxOpen: 1
	});

	$scope.panelRef=null;

	this.showdlgPerfil = function(ev) {
		var offsetwidth = (ev.srcElement.nodeName=="MD-ICON"?"-255px":"-260px");
		var offsetheight = (ev.srcElement.nodeName=="MD-ICON"?"40px":"45px");
		$mdPanel.open('infoPanel', {
			id: 'iddlgUsuario',
			position: $mdPanel.newPanelPosition()
			.relativeTo(ev.target)
			.addPanelPosition(
					$mdPanel.xPosition.OFFSET_END,
					$mdPanel.yPosition.ALIGN_TOPS
			).withOffsetX(offsetwidth).withOffsetY(offsetheight),
			locals: {
				nombrecompleto: $scope.msUsuariosPerfilJS.nombrecompleto,
				sede: $scope.msUsuariosPerfilJS.sede,
				idunidadTxt: $scope.msUsuariosPerfilJS.idunidadTxt
			},
			bindToController: true,
			openFrom: ev,
			clickOutsideToClose: true,
			escapeToClose: true,
			focusOnOpen: true
		}).then(function(result) {
			$scope.panelRef = result;
//			panelRef.panelContainer.addClass('menu-panel-container-w');
//			panelRef.panelContainer.css('width', '300px');
			//panelRef.panelEl.css('width', '300px');
//			panelRef.panelContainer[0].setAttribute('style', 'width:200px;');
//			panelRef.panelEl.addClass('menu-panel-container-w');
			var element = $scope.panelRef.panelEl;
			setTimeout(function(){
				element[0].style.transition= "width 0.4s linear";
				element[0].style.width = "300px";
			},200,"JavaScript");	          
			console.log('Print '+element[0].style.cssText+' CLASS '+ element[0].className);	          
		});;
	};

	//PURIBE 25012024 - INICIO
	var self = this;
	var abierto=false;

	var handleClick = function() {
		// Verificar si el panel está abierto
		if ($scope.panelRef && $scope.panelRef.isAttached) {
			// Cerrar el panel si está abierto
			$scope.panelRef.close();
			abierto=false;
			return;
		} 
	};
	this.showdlgNoti  = (ev,noticampana) => {
		//   var offsetwidth = (ev.srcElement.nodeName=="MD-ICON"?"-370px":"-375px");
		// var offsetheight = (ev.srcElement.nodeName=="MD-ICON"?"40px":"45px");
		ev = ev || {};
		var offsetwidth = (noticampana === "noticampana") ? '-370px' : '-375px';
		var offsetheight = (noticampana === "noticampana") ? '40px' : '45px';

		if (abierto){
			var boton = document.getElementById('noticampana');
			if (boton) {
				boton.addEventListener('click', handleClick);
			}
		}

		if (noticampana === "noticampana") {
			// Coordenadas específicas para el botón con icono
			position = $mdPanel.newPanelPosition()
			.absolute()
			.top('50px')  // Ajusta estas coordenadas según tu diseño
			.right('20px');
		} else {
			// Coordenadas predeterminadas si no es el botón con icono
			position = $mdPanel.newPanelPosition()
			.relativeTo(ev.target || document.body)
			.addPanelPosition(
					$mdPanel.xPosition.OFFSET_END,
					$mdPanel.yPosition.ALIGN_TOPS
			).withOffsetX(offsetwidth).withOffsetY(offsetheight);
		}

		$mdPanel.open('notiPanel', {
			id: 'iddlgNoti',
			position: position,
			locals: {
				pendientes: $scope.listaPrtParametros  //PURIBE 29032024 - INICIO->
			},
			openFrom: ev.target,
			escapeToClose: true,
			focusOnOpen: true
		}).then(function(result) {
			$scope.panelRef = result;

//			panelRef.panelContainer.addClass('menu-panel-container-w');
//			panelRef.panelContainer.css('width', '300px');
			//panelRef.panelEl.css('width', '300px');
//			panelRef.panelContainer[0].setAttribute('style', 'width:200px;');
//			panelRef.panelEl.addClass('menu-panel-container-w');
			var element = $scope.panelRef.panelEl;
			element[0].style.backgroundColor = 'white';
			element[0].style.zIndex = '1000';
			element[0].style.border = '1px solid black';

			abierto=true;
			if (!$scope.notificacionMostrada) {
				$scope.notificacionMostrada = true;
				abierto=false;
				setTimeout(function() {
					// Cierra el panel
					$scope.actualizanotificacion();

					$scope.panelRef.close();
				}, 5000);
			}

			setTimeout(function(){
				//  element[0].style.transition= "width 0.4s linear";
				// element[0].style.width = "372px";
			},200,"JavaScript");	          
			console.log('Print '+element[0].style.cssText+' CLASS '+ element[0].className);	          
		});;
	};

	$scope.cargarprtParametros = function(idparametro){		
		return new Promise(function(resolve, reject) {
			var surl = editarprtParametrosUrl+idparametro;
			$http.get(surl).then(
					function(res){
						var dato = res.data;
						//PURIBE 29032024 - INICIO->
						for (var i = 0; i < dato.length; i++) {
							$scope.setPrtParametrosModelo(dato[i]);
							var nuevoParametro = angular.copy($scope.prtParametrosModelo);
							$scope.listaPrtParametros.push(nuevoParametro);
							
						}
						$scope.ctrl.contadorNotificaciones=$scope.listaPrtParametros.length;
						//PURIBE 29032024 - FIN->
						resolve(dato);
					})
					.catch(function(errResponse) {
						console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
						var dato = errResponse.data;
						if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
							$mdDialog.show(
									$mdDialog.alert()
									.parent(angular.element(document.body))
									.clickOutsideToClose(true)
									.title('Cargar Parámetros')
									.textContent(dato.message)
									.ariaLabel('ERROR')
									.ok('OK')
							);
							reject(dato.message);
						}			           
					});		
		});		        			        	
	};


	$scope.cargarprtParametros(0).then(function(datos)
			{


		// Abre el panel después de asignar los datos.
		//abrirPanel();
		//PURIBE 29032024 - INICIO->
		//elijo el primer item, aca deberia de cambiar la logica a visto pero mientras lo trabajo asi
		if	($scope.listaPrtParametros[0].notificacion==1) 
		//PURIBE 29032024 - FIN->
		{
			self.showdlgNoti(null, "noticampana");
		}
			}) 
			.catch(function(mensajeError) {
				console.error("Error al cargar parámetros:", mensajeError);
			});


	$scope.actualizanotificacion = function(){	

		var datainsert = angular.toJson($scope.listaPrtParametros); //PURIBE 29032024 - INICIO->
		console.log("datainsert = "+datainsert);	
		$http.post(actualizanotificacionUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
			var dato = res.data;
			//PURIBE 29032024 - INICIO->
			$scope.listaPrtParametros = [];
				for (var i = 0; i < dato.length; i++) {
					$scope.setPrtParametrosModelo(dato[i]);
					var nuevoParametro = angular.copy($scope.prtParametrosModelo);
					$scope.listaPrtParametros.push(nuevoParametro);
				}
				$scope.ctrl.contadorNotificaciones=$scope.listaPrtParametros.length;
			//PURIBE 29032024 - FIN>

		},
		function error(errResponse) {
			console.log("data " + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
			var dato = errResponse.data;
			if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
				$mdDialog.show(
						$mdDialog.alert()
						.parent(angular.element(document.body))
						.clickOutsideToClose(true)
						.title('Actualizar Notificacion')
						.textContent(dato.message)
						.ariaLabel('ERROR')
						.ok('OK')
						.targetEvent(ev)
				);
			}
		});			        			        	

	};
	//PURIBE 25012024 - FIN

//	this.showdlgNoti = function(ev) {
//	var offsetwidth = (ev.srcElement.nodeName=="MD-ICON"?"-370px":"-375px");
//	var offsetheight = (ev.srcElement.nodeName=="MD-ICON"?"40px":"45px");
//	$mdPanel.open('notiPanel', {
//	id: 'iddlgNoti',
//	position: $mdPanel.newPanelPosition()
//	.relativeTo(ev.target)
//	.addPanelPosition(
//	$mdPanel.xPosition.OFFSET_END,
//	$mdPanel.yPosition.ALIGN_TOPS
//	).withOffsetX(offsetwidth).withOffsetY(offsetheight),
//	locals: {
//	pendientes: $scope.pendientes
//	},
//	openFrom: ev,
//	clickOutsideToClose: true,
//	escapeToClose: true,
//	focusOnOpen: true
//	}).then(function(result) {
//	$scope.panelRef = result;
////	panelRef.panelContainer.addClass('menu-panel-container-w');
////	panelRef.panelContainer.css('width', '300px');
//	//panelRef.panelEl.css('width', '300px');
////	panelRef.panelContainer[0].setAttribute('style', 'width:200px;');
////	panelRef.panelEl.addClass('menu-panel-container-w');
//	var element = $scope.panelRef.panelEl;
//	setTimeout(function(){
//	element[0].style.transition= "width 0.4s linear";
//	element[0].style.width = "372px";
//	},200,"JavaScript");	          
//	console.log('Print '+element[0].style.cssText+' CLASS '+ element[0].className);	          
//	});;
//	};

///////////////////////////////////////
	$scope.pendientes =[];
	$scope.promise = null;
	$scope.creatdAtenciones = false;

	$scope.loadtdPendientes = function () {
		var surl = pendientesUrl;	    
		$scope.promise = $http.get(surl).then(function(res){
			$scope.pendientes = res.data.data;
			if(res.data.contador>0)
				$scope.total = res.data.contador;
			var tiempoenBD = res.data.tiempoenBD;
			var tiempoenproceso = res.data.tiempoenproceso;
			$scope.creatdAtenciones = res.data.creamodifica;
			console.log("data " +$scope.pendientes.length+" DE "+ $scope.total);
			console.log("Tiempo respuesta pendientes BD " +tiempoenBD+" Tiempo en Paginar "+tiempoenproceso);
		},
		function error(errResponse) {
			console.log("data pendientes" + errResponse.data + " status " + errResponse.status + " headers " + errResponse.headers + "config " + errResponse.config + " statusText " + errResponse + " xhrStat " + errResponse.xhrStatus);
			var dato = errResponse.data;
			if(typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined'){
				$mdDialog.show(
						$mdDialog.alert()
						.parent(angular.element(document.body))
						.clickOutsideToClose(true)
						.title('Lista de  Pendientes de Atención Y/o Consulta')
						.textContent(dato.message)
						.ariaLabel('ERROR')
						.ok('OK')
				);
			}
		});			 
	};

//	$interval( function(){ $scope.loadtdPendientes(); }, 300000);

	$scope.$on("showdlgCambioContraseniaX", function(evt,data){ 
		if($scope.panelRef)
			$scope.panelRef.close();
		$scope.showdlgCambioContrasenia();
	});

	$scope.showdlgCambioContrasenia = function() {		
		$mdDialog.show({
			contentElement: '#cambioClaveDialog',
			parent: angular.element(document.body),
			clickOutsideToClose: true,
			scope: $scope,
			preserveScope: true
		});
	};		 

	$scope.actulizarMsUsuarios = function(ev){		
		ev.target.disabled = true;
		var datainsert = angular.toJson($scope.msUsuariosPerfilJS);// $httpParamSerializerJQLike($scope.nuevapersonamodel);
		console.log("datainsert = "+datainsert);	
		$http.post(actualizarperfilUrl,datainsert,{headers: {'Content-Type': 'application/json'}}).then(function(res){
			var dato = res.data;
			$scope.setPerfil(dato); 
			$mdDialog.show(
					$mdDialog.alert()
					.parent(angular.element(document.body))
					.clickOutsideToClose(true)
					.title('GUARDAR CONTRASEÑA')
					.textContent('LA CONTRASEÑA SE GUARDO CORRECTAMENTE')
					.ariaLabel('INFORMACIÓN')
					.ok('OK')
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
						.title('GUARDAR CONTRASEÑA')
						.textContent(dato.message)
						.ariaLabel('ERROR')
						.ok('OK')
						.targetEvent(ev)
				);
			}
		});
		ev.target.disabled = false;
	};
}]);

