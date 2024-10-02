var contexto = window.location.pathname.substring(0,window.location.pathname.indexOf('/',2));
var pglogoff = window.location.origin+contexto+'/logoff.htm';
var principalUrl = window.location.origin+contexto+'/index.htm';
var perfilMenuUrl = contexto+"/rs/ctrlmenu/perfilusuario";
var actualizarperfilUrl = contexto+"/rs/ctrlmenu/actualizarperfil";

myapp = angular.module('MyApp');

myapp.config(['$mdPanelProvider', function ($mdPanelProvider) {
	$mdPanelProvider.definePreset('menuPanel', {
		  attachTo: angular.element(document.body),
	      controller: ['mdPanelRef', function(mdPanelRef) {
	    	  this.closeMenu = function() {
	    	      mdPanelRef && mdPanelRef.close();
	    	    };
	    	  this.redireccionar = function(direccion){
	    		  var urldestino = direccion;
	    		  console.log("Menu " +urldestino);
	    		  window.location.href = urldestino;
	    	  };   
	    	  this.showMenu = function($event, menu) {
	    		  console.log("SHOW MENU "+menu);
	    		  this.$scope.$parent.$broadcast('showMenuRM', this.evento, menu);  
	    	  };
	    	  
	    	  this.cambiarIconoBoton = function($event, menu) {
	    		  console.log("Cambiar Icono "+menu);
	    		  this.$scope.$parent.$broadcast('cambiarIcon', this.evento, menu);  
	    	  };
	      }],
	      controllerAs: 'ctrl',
	      template: '' +
	          '<div class="menu-panel" md-whiteframe="4" ng-mouseleave="ctrl.closeMenu()">' +	          
	          '  <div class="menu-content">' +
	          '    <div class="menu-titulo" md-colors="{background: \'primary-700\'}">' +
	          '      <md-button ng-click="ctrl.closeMenu()">' +
	          '        <span><b>{{ctrl.menuname}}</b></span>' +
	          '      </md-button>' +
	          '    </div>' +
	          '    <md-divider class="menu-divider"></md-divider>' +
	        //PURIBE 04042024 - INICIO
	          '    <div class="menu-item" ng-repeat="item in ctrl.items | filter: {activo: true}">' +	 
			  //PURIBE 04042024 - FIN  	          
	          '      <md-button href="{{item.refe}}" ng-disabled="{{!item.activo}}" ng-if="!item.submenu" ng-mousedown="ctrl.cambiarIconoBoton($event, item.name);">' +
	          '        <span>{{item.name}}</span>' +
	          '      </md-button>' +
	          '      <md-button ng-click="ctrl.showMenu($event, item.submenu);" ng-disabled="{{!item.activo}}" ng-if="item.submenu">' +
	          '        <div layout="row" layout-align="space-between center"><span>{{item.name}}</span><span>&raquo;</span></div>' +
	          '      </md-button>' +
	          '    </div>' +
	          '  </div>' +
	          '</div>',
	      panelClass: 'menu-panel-container',
	      focusOnOpen: false,
	      zIndex: 100,
	      propagateContainerEvents: true,
	      groupName: 'menus',
	    });
}]);

myapp.directive('strength', function () {
	return {
		restrict: 'A',
		scope:true,
		link: function (scope, element, attrs) {
			
			var defaults = {
		            strengthClass: 'strength',
		            strengthMeterClass: 'strength_meter',
		            strengthButtonClass: 'button_strength',
		            strengthButtonText: 'Show Password',
		            strengthButtonTextToggle: 'Hide Password'
		        };
			
			var characters = 0;
            var capitalletters = 0;
            var loweletters = 0;
            var number = 0;
            var special = 0;

            var upperCase= new RegExp('[A-Z]');
            var lowerCase= new RegExp('[a-z]');
            var numbers = new RegExp('[0-9]');
            var specialchars = new RegExp('([!,%,&,@,#,$,^,*,?,_,~])');
			
            function getPercentage(a, b) {
                return ((b / a) * 100);
            };
            
            function check_strength(thisval,thisid){
               if (thisval.length > 8) { characters = 1; } else { characters = 0; };
               if (thisval.match(upperCase)) { capitalletters = 1} else { capitalletters = 0; };
               if (thisval.match(lowerCase)) { loweletters = 1}  else { loweletters = 0; };
               if (thisval.match(numbers)) { number = 1}  else { number = 0; };
               var total = characters + capitalletters + loweletters + number + special;
               var totalpercent = getPercentage(7, total).toFixed(0);
               get_total(total,thisid);
            };
            
            function get_total(total,thisid){
              var thismeter = angular.element(document.getElementById(thisid+'meter'));
              if(total == 0){
                    thismeter.removeClass('veryweak weak medium strong').html('');
              }else if (total <= 1) {
                 thismeter.removeClass('veryweak weak medium strong');
                 thismeter.addClass('veryweak').html('<p>MuyDébil</p>');
              } else if (total == 2){
                  thismeter.removeClass('veryweak weak medium strong');
                 thismeter.addClass('weak').html('<p>Débiles</p>');
              } else if(total == 3){
                  thismeter.removeClass('veryweak weak medium strong');
                 thismeter.addClass('medium').html('<p>Medio</p>');

              } else {
                   thismeter.removeClass('veryweak weak medium strong');
                 thismeter.addClass('strong').html('<p>Fuerte</p>');
              } 
              console.log(total);
          };
            
          var $elem = angular.element(element);
          var options = defaults;
          var _defaults = defaults;
          
          var isShown = false;
          var strengthButtonText = options.strengthButtonText;
          var strengthButtonTextToggle = options.strengthButtonTextToggle;

          var thisid = $elem.attr('id');

          $elem.addClass(options.strengthClass);
          $elem.attr('data-password',thisid);
          $elem.after('<input style="display:none" id="'+thisid+'vis" class="'+options.strengthClass+'" data-password="'+thisid+'" type="text" name="" value="" autocomplete="off"><a data-password-button="'+thisid+'" href="javascript:void(0);" id="'+thisid+'link" class="'+options.strengthButtonClass+'">'+options.strengthButtonText+'</a><div class="'+options.strengthMeterClass+'"><div id="'+thisid+'meter" data-meter="'+thisid+'"><p></p></div></div>');
           
          $elem.bind('keyup', function(event) {
//        	  event.stopPropagation();
              thisval = angular.element(document.getElementById(thisid)).val();
              angular.element(document.getElementById(thisid+'vis')).val(thisval);
              check_strength(thisval,thisid);              
          });
                   
          angular.element(document.getElementById(thisid+'vis')).bind('keyup', function(event) {
//        	  event.stopPropagation();
        	  thisval = angular.element(document.getElementById(thisid+'vis')).val();
              console.log(thisval);
              angular.element(document.getElementById(thisid)).val(thisval);
              check_strength(thisval,thisid);              
          });
          
          angular.element(document.getElementById(thisid+'link')).on('click',function(e) {
//              e.preventDefault();
              e.stopPropagation();
             thisclass = 'hide_'+angular.element(this).attr('class');
              if (isShown) {
            	  document.getElementById(thisid+'vis').style.display = "none";
            	  document.getElementById(thisid).style.display = "block";
            	  angular.element(document.getElementById(thisid)).focus();
            	  angular.element(document.getElementById(thisid+'link')).removeClass(thisclass).html(strengthButtonText);
                  isShown = false;
              } else {
            	  document.getElementById(thisid+'vis').style.display = "block";
            	  document.getElementById(thisid).style.display = "none";
            	  angular.element(document.getElementById(thisid+'vis')).focus();
            	  angular.element(document.getElementById(thisid+'link')).addClass(thisclass).html(strengthButtonTextToggle);
                  isShown = true; 
              }         
          });
          
		},//FIN FUNCION LINK
	};
});

myapp.controller('menuCtrl', ['$scope','$mdPanel','$mdDialog','$http', function ($scope,$mdPanel,$mdDialog,$http) { //11082023 LLEYVAH
	  
	//-----------------------------
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
	
	$scope.cancel = function() {
		$mdDialog.cancel();
	};
	
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
	//-----------------------------
	
	      $scope.programacion = {
		      name: 'Programación',
		      items: [
		    	  {'name':'Asistencias técnicas','refe':'asistencia/listadtAsistencia.html','activo':true},
		    	  {'name':'Capacitaciones','refe':'capacitacion/listadtCapacitacion.html','activo':true},
		    	  {'name':'Reuniones de trabajo','refe':'visitas/listadtVisitas.html','activo':true}		    	  
		      ]
		    };
	      
	      $scope.registro = {
			      name: 'Registro',
			      items: [
			    	  {'name':'Asistencias técnicas','refe':'asistencia/listadtAsistenciaNoProg.html','activo':true},//MPINARES 14022024 - INICIO
			    	  {'name':'Capacitaciones','refe':'capacitacion/listadtCapacitacionNoProg.html','activo':true},//CUSCATA - 18072024
			    	  {'name':'Capacitaciones Publicadas','refe':'capacitacion/listadtCapacitacionNoProgPublicadas.html','activo':true},//JPUYEN 30072024
			    	  {'name':'Reuniones de trabajo','refe':'visitas/listadtVisitasNoProg.html','activo':true},//PURIBE 04042024 - INICIO
			    	  {'name':'Consultas','refe':'consultas/listadtConsultas.html','activo':true}	//MPINARES 24012023 - INICIO
			      ]
			    };
	        
	        $scope.reporteServicios = {
		  		      name: 'Reporte de servicios',
		  		      items: [
		  		    	  {'name':'Resumen','refe':'reportes/servicios/listarRptResumen.html','activo':true},
		  		    	  {'name':'Por sede','refe':'paginas/listatConstruccion.html','activo':true},
		  		    	  {'name':'Por representantes técnicos','refe':'reportes/servicios/listarRptRepreTecnicos.html','activo':true}
		  		      ]
		  		    };
	      
	        $scope.reporteEntidades = {
		  		      name: 'Reporte de entidades',
		  		      items: [
		  		    	  {'name':'Por geozona','refe':'paginas/listatConstruccion.html','activo':true},
		  		    	  {'name':'Por cobertura','refe':'paginas/listatConstruccion.html','activo':true}
		  		      ]
		  		    };	         
	      
	        $scope.reporteUsuarios = {
		  		      name: 'Reporte de usuarios',
		  		      items: [
		  		    	  {'name':'Directorio','refe':'paginas/listatConstruccion.html','activo':true},
		  		    	  {'name':'Internos','refe':'paginas/listatConstruccion.html','activo':true},
		  		    	  {'name':'Externos','refe':'paginas/listatConstruccion.html','activo':true}
		  		      ]
		  		    };
	        
	        $scope.reportes = {
	  		      name: 'Reportes',
	  		      items: [
	  		    	  {'name':'Reporte de servicios','refe':'javascript:void(0);','activo':true,'submenu':$scope.reporteServicios},
	  		    	  {'name':'Reporte genérico','refe':'paginas/listatConstruccion.html','activo':true},
	  		    	  {'name':'Reporte avance de metas','refe':'paginas/listatConstruccion.html','activo':true},
	  		    	  {'name':'Reporte de encuestas','refe':'paginas/listatConstruccion.html','activo':true},
	  		    	  {'name':'Reporte de entidades','refe':'javascript:void(0);','activo':true,'submenu':$scope.reporteEntidades},
	  		    	  {'name':'Reporte de usuarios','refe':'javascript:void(0);','activo':true,'submenu':$scope.reporteUsuarios}
	  		      ]
	  		    };
	        
	        $scope.usuarios = {
		  		      name: 'Usuarios',
		  		      items: [
		  		    	  {'name':'Internos','refe':'adminis/listamsUsuarios.html','activo':true},
		  		    	  {'name':'Externos','refe':'adminis/listadtUsuarioExterno.html','activo':true}
		  		      ]
		  		    };
	        
	        $scope.usuarios = {
		  		      name: 'Usuarios',
		  		      items: [
		  		    	  {'name':'Internos','refe':'adminis/listamsUsuarios.html','activo':true},
		  		    	  {'name':'Externos','refe':'adminis/listadtUsuarioExterno.html','activo':true}
		  		      ]
		  		    };
	        
	        $scope.datosServicios = {
		  		      name: 'Datos de Servicios',
		  		      items: [
		  		    	  {'name':'Sistema administrativo','refe':'adminis/listamsSisAdmistrativo.html','activo':true},
		  		    	  {'name':'Temas','refe':'adminis/listamsTema.html','activo':true},
		  		    	  {'name':'Subtema','refe':'adminis/listamsSubtema.html','activo':true}
		  		      ]
		  		    };
	        
	        $scope.entidadesLocales = {
		  		      name: 'Entidades y locales',
		  		      items: [
		  		    	  {'name':'Entidades','refe':'adminis/listadtEntidades.html','activo':true},
		  		    	  {'name':'Locales','refe':'adminis/listamsLocal.html','activo':true},
		  		    	  {'name':'Geozona','refe':'paginas/listatConstruccion.html','activo':true}
		  		      ]
		  		    };
	         
	        $scope.metasIndicadores = {
		  		      name: 'Metas e indicadores',
		  		      items: [
		  		    	  {'name':'Metas','refe':'adminis/listamsMeta.html','activo':true},
		  		    	  {'name':'Indicadores','refe':'adminis/listamsIndicador.html','activo':true}
		  		      ]
		  		    };
	         
	        
	        $scope.administracion = {
		      name: 'Datos de Servicios',
		      items: [
		    	  {'name':'Usuarios','refe':'javascript:void(0);','activo':true,'submenu':$scope.usuarios},
		    	  {'name':'Datos de Servicios','refe':'javascript:void(0);','activo':true, 'submenu':$scope.datosServicios},
		    	  {'name':'Entidades y locales','refe':'javascript:void(0);','activo':true, 'submenu':$scope.entidadesLocales},
		    	  {'name':'Sedes','refe':'adminis/listamsSedes.html','activo':true},
		    	  {'name':'Metas e indicadores','refe':'javascript:void(0);','activo':true, 'submenu':$scope.metasIndicadores},
		    	  {'name':'Encuestas','refe':'encuestas/listadtEncuesta.html','activo':true},
		    	  {'name':'Proyectos de inversión','refe':'adminis/listamsProyectoInversion.html','activo':true},
		    	  {'name':'Ampliación de plazo','refe':'adminis/listadtAmpliacionFecha.html','activo':true}		    	  
		      ]
		    };
	       		    
		    $scope.configuracion = { 
		      name: 'Configuración',
		      items: [
		    	  {'name':'Parámetros','refe':'adminis/listaprtParametros.html','activo':true},
		    	  {'name':'Países','refe':'adminis/listamsPaises.html','activo':true},
		    	  {'name':'Ubigeo','refe':'adminis/listamsUbigeo.html','activo':true},
		    	  {'name':'Feriados','refe':'adminis/listataFeriados.html','activo':true},
		    	  {'name':'Programación de alertas','refe':'adminis/listamsUsuarios.html','activo':true},
		    	  {'name':'Mantenimiento','refe':'adminis/mantenimiento.html','activo':true}		    	  
		      ]
		    };
		    
		    $scope.ayuda = {
				      name: 'Ayuda',
				      items: [
				    	  {'name':'Manual de usuario','refe':'paginas/listatConstruccion.html','activo':true},
				    	  {'name':'Videos','refe':'paginas/listatConstruccion.html','activo':true}
				      ]
				    };

		    $mdPanel.newPanelGroup('menus', {
		      maxOpen: 1
		    });
		    		    
		    $scope.cargarperfil = function(){
		    	/**
		    	 * PRINT DE CONTROL
		    	 */
		    	console.log("window.location.pathname: " + window.location.pathname + " contexto: " + contexto + "\nperfilMenuUrl: " + perfilMenuUrl + " principalUrl: " + principalUrl);
		    	
				var surl = perfilMenuUrl;
				$http.get(surl).then(function(res){
					var dato = res.data;	
					
					$scope.programacion.items[0].activo = dato.programacionasistencia;
					$scope.programacion.items[1].activo = dato.programacioncapacitacion;
					$scope.programacion.items[2].activo = dato.programacionreunion;
					
					$scope.registro.items[0].activo = dato.registroasistencia;
					$scope.registro.items[1].activo = dato.registrocapacitacion;
					$scope.registro.items[2].activo = dato.registrocapacitacionpubli;
					$scope.registro.items[3].activo = dato.registroreunion;
					$scope.registro.items[4].activo = dato.registroconsulta;
					
					$scope.reportes.items[0].activo = (dato.reporteservicioresumen || dato.reporteserviciosede || dato.reporteserviciorepresentante);
					$scope.reportes.items[1].activo = dato.reportegenerico;
					$scope.reportes.items[2].activo = dato.reportemetas;
					$scope.reportes.items[3].activo = dato.reporteencuestas;
					$scope.reportes.items[4].activo = (dato.reporteentidadesgeozona || dato.reporteentidadescobertura) ;
					$scope.reportes.items[5].activo = (dato.reporteusuariosdirectorio || dato.reporteusuariosinterno || dato.reporteusuariosexterno);
					
					$scope.administracion.items[0].activo = (dato.usuarios || dato.usuariosexternos) ;
					$scope.administracion.items[1].activo = (dato.datossisadministrativo || dato.datostemas || dato.datossubtemas);
					$scope.administracion.items[2].activo = (dato.entidades || dato.datolocales || dato.datogeozona);
					$scope.administracion.items[3].activo = dato.datosede;
					$scope.administracion.items[4].activo = (dato.datometas || dato.datoindicadores) ;
					$scope.administracion.items[5].activo = dato.datoencuestas;
					$scope.administracion.items[6].activo = dato.datoproyectos;
					$scope.administracion.items[7].activo = dato.datoampliacion;
					
					$scope.configuracion.items[0].activo = dato.parametros;					
					$scope.configuracion.items[1].activo = dato.paises;
					$scope.configuracion.items[2].activo = dato.ubigeo;
					$scope.configuracion.items[3].activo = dato.feriados;
					$scope.configuracion.items[4].activo = dato.alerta;
					$scope.configuracion.items[5].activo = dato.mantenimiento;
					
					//SUBMENUS
					$scope.reporteServicios.items[0].activo = dato.reporteservicioresumen; 
					$scope.reporteServicios.items[1].activo = dato.reporteserviciosede;
					$scope.reporteServicios.items[2].activo = dato.reporteserviciorepresentante;
					
					$scope.reporteEntidades.items[0].activo = dato.reporteentidadesgeozona; 
					$scope.reporteEntidades.items[1].activo = dato.reporteentidadescobertura;
					
					$scope.reporteUsuarios.items[0].activo = dato.reporteusuariosdirectorio; 
					$scope.reporteUsuarios.items[1].activo = dato.reporteusuariosinterno;
					$scope.reporteUsuarios.items[2].activo = dato.reporteusuariosexterno;
					
					$scope.usuarios.items[0].activo = dato.usuarios;
					$scope.usuarios.items[1].activo = dato.usuariosexternos;
					
					$scope.datosServicios.items[0].activo = dato.datossisadministrativo; 
					$scope.datosServicios.items[1].activo = dato.datostemas;
					$scope.datosServicios.items[2].activo = dato.datossubtemas;
					
					$scope.entidadesLocales.items[0].activo = dato.entidades; 
					$scope.entidadesLocales.items[1].activo = dato.datolocales;
					$scope.entidadesLocales.items[2].activo = dato.datogeozona;
					
					$scope.metasIndicadores.items[0].activo = dato.datometas;
					$scope.metasIndicadores.items[1].activo = dato.datoindicadores;

					//PURIBE 04042024 - FIN
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
								.title('Cargar perfil de usurio')
								.textContent(dato.message)
								.ariaLabel('ERROR')
								.ok('OK')
								.targetEvent(ev)
						);
					}			           
				});			        			        	
			};		    
		    
		    $scope.showMenu = function($event, menu) {		    	
		      /**
		       * The request to open the panel has two arguments passed into it. The
		       * first is a preset name passed in as a string. This will request a
		       * cached preset and apply its configuration parameters. The second is an
		       * object containing parameters that can only be filled through a
		       * controller. These parameters represent configuration needs associated
		       * with user interaction, panel position, panel animation, and other
		       * miscellaneous needs.
		       */
		      var offsetwidth = ($event.srcElement.nodeName=="MD-ICON"?"16px":"1PX");
		      var offsetheight = ($event.srcElement.nodeName=="MD-ICON"?"-5px":"1PX");
		      $mdPanel.open('menuPanel', {
		        id: 'menu_' + menu.name,
		        position: $mdPanel.newPanelPosition()
		            .relativeTo($event.target)
		            .addPanelPosition(
		              $mdPanel.xPosition.OFFSET_END,
		              $mdPanel.yPosition.ALIGN_TOPS
		            ).withOffsetX(offsetwidth).withOffsetY(offsetheight),
		        locals: {
		          items: menu.items,
		          menuname: menu.name,
		          evento: $event
		        },
		        openFrom: $event
		      }).then(function(result) {
		          panelRef = result;
//		          panelRef.panelContainer.addClass('menu-panel-container-w');
//		          panelRef.panelContainer.css('width', '300px');
		          //panelRef.panelEl.css('width', '300px');
//		          panelRef.panelContainer[0].setAttribute('style', 'width:200px;');
//		          panelRef.panelEl.addClass('menu-panel-container-w');
		          var element = panelRef.panelEl;
		          setTimeout(function(){
		        	  element[0].style.transition= "width 0.4s linear";
			          element[0].style.width = "250px";
		          },200,"JavaScript");		          
		          console.log('Print '+element[0].style.cssText+' CLASS '+ element[0].className);		          
		        });;
		    };
		    
		    $scope.salir=function(){
		 	   window.location.href=pglogoff; 
		 	 };
		 	 
		 	$scope.$on("showMenuRM", function(obj, $event, data){ 
		 		console.log('obj '+obj.name);
		 		console.log('evt '+$event.srcElement.nodeName);
		 		console.log('data '+data.name);
		 		$scope.showMenu($event, data);
			});
		 	
		 	var panelRef;
		    var prevButton = null;
		 	$scope.$on("cambiarIcon", function(obj, $event, data){ 
		 		console.log('obj '+obj.name);
		 		console.log('evt '+$event.srcElement.nodeName);
		 		console.log('data '+data);
		 		var nombreEtiqueta = $event.srcElement.nodeName;
		 		var OBJDiv = null;
		 		if(nombreEtiqueta==="MD-ICON"){
//		 			OBJDiv = $event.srcElement.parentNode;
		 			OBJDiv = $event.srcElement;
		 		}else{
//		 			OBJDiv = $event.srcElement;
		 			OBJDiv = $event.srcElement.firstElementChild;
		 		}
		 		
//		 		OBJDiv.classList.add('active');
		 		OBJDiv.classList.add('blanco');
		    	if(prevButton !== null) {
		    		if(OBJDiv.parentNode.name !== prevButton.parentNode.name)
		    			prevButton.classList.remove('blanco');
//		    	    prevButton.classList.remove('active');  // Remove .active CSS Class
		    	  }		    	  
		        prevButton = OBJDiv;
		    	
//		    	var mihijo = $event.target.children;
//		    	if(mihijo!==null){
//		    		var posibleicon = mihijo[0];
//		    		if(posibleicon.tagName === "MD-ICON"){}
//		    	}	 		
			});
		 	
		 	$scope.marcarBlanco=function(){
		 		var pagina = window.location.pathname.substring(window.location.pathname.indexOf('/',2)+1,window.location.pathname.lastIndexOf('/'));
		 		console.log('pagina '+pagina);
		 		var idpagina = "id"+pagina;
		 		var OBJDiv = document.getElementById(idpagina);
		 		if(OBJDiv !==null){
		 			OBJDiv.classList.add('blanco');
		 		}
			 };
			 
			 $scope.$on('$viewContentLoaded',function(){
				 console.log('on $viewContentLoaded');
				 $scope.marcarBlanco();
			 });
			 $scope.$on('$routeChangeSuccess',function(){
				 console.log('on $routeChangeSuccess');
				 $scope.marcarBlanco();
			 });
			 $scope.$on('$stateChangeSuccess',function(){
				 console.log('on $stateChangeSuccess');
				 $scope.marcarBlanco();
			 });
			 $scope.$watch('$viewContentLoaded',function(){
				 console.log('watch $viewContentLoaded');
				 $scope.marcarBlanco();
			 });
			 
////ADICIONALES
			//11082023 LLEYVA INICIO
//				$scope.changePassword = function(ev) {		
//				    ev.target.disabled = true;
//				    
//				    var changePasswordRequest = {
//				        newPassword: $scope.msUsuariosPerfilJS.contrasenia,
//				        repeatPassword: $scope.msUsuariosPerfilJS.contraseniaConfir
//				    };
//
//				    console.log("Change password request = ", changePasswordRequest);	
//				    
//				    $http.post(changePasswordUrl, changePasswordRequest, {headers: {'Content-Type': 'application/json'}}).then(function(res) {
//				        var dato = res.data;
//				        $mdDialog.show(
//				            $mdDialog.alert()
//				            .parent(angular.element(document.body))
//				            .clickOutsideToClose(true)
//				            .title('Cambiar Contraseña')
//				            .textContent('La contraseña se cambió correctamente')
//				            .ariaLabel('Información')
//				            .ok('OK')
//				            .targetEvent(ev)
//				        );
//				    }, function error(errResponse) {
//				        console.log("Error response = ", errResponse);
//				        var dato = errResponse.data;
//				        if (typeof(dato) != 'undefined' && typeof(dato.message) != 'undefined') {
//				            $mdDialog.show(
//				                $mdDialog.alert()
//				                .parent(angular.element(document.body))
//				                .clickOutsideToClose(true)
//				                .title('Cambiar Contraseña')
//				                .textContent(dato.message)
//				                .ariaLabel('Error')
//				                .ok('OK')
//				                .targetEvent(ev)
//				            );
//				        }
//				    });
//				    
//				    ev.target.disabled = false;
//				};
				
				//11082023 LLEYVA FIN
		 			 
}]);

