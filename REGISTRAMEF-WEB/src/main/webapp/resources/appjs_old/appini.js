/**
 * De forma predeterminada, los tonos 500, 300, 800 y A100 se usan para las intenciones principales y de advertencia, mientras que A200, A100, A400 y A700 se usan para acentuar.
$mdThemingProvider.theme('default')
    .primaryPalette('pink', {
      'default': '400', // por defecto, use el tono 400 de la paleta rosa para las intenciones principales
      'hue-1': '100', // usa el tono 100 para la clase <code>md-hue-1</code>
      'hue-2': '600', // usa el tono 600 para la clase <code>md-hue-2</code>
      'hue-3': 'A100' // usa el tono A100 para la clase <code>md-hue-3</code>
    })
    // Si especifica menos de todas las claves, heredará del
    // tonos predeterminados
    .accentPalette('purple', {
      'default': '200' // use el tono 200 por defecto y mantenga todos los demás tonos iguales
    });
 */

var myapp = angular.module('MyApp', ['ngMaterial', 'md.data.table', 'ngRoute', 'ngMessages']);

myapp.config(['$mdThemingProvider', function ($mdThemingProvider) {
    'use strict';    
    
    var neonRedMap = $mdThemingProvider.extendPalette('cyan', {
	    '700':'#007DAF',
	    '800':'#4E8BA4',
	    '900':'#009688'
	  });

	  // Register the new color palette map with the name <code>neonRed</code>
   $mdThemingProvider.definePalette('neonred', neonRedMap);

	  // Use that theme for the primary intentions
   $mdThemingProvider.theme('default').primaryPalette('neonred');
    
//    $mdThemingProvider.generateThemesOnDemand(true);
    $mdThemingProvider.alwaysWatchTheme(true);
}]);
