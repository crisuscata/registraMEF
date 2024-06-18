var myapp = angular.module('MyApp');
myapp.controller('ThemeDemoCtrl', function ($scope, $mdColorPalette) {
    $scope.colors = Object.keys($mdColorPalette);

    $scope.mdURL = 'https://material.io/archive/guidelines/style/color.html#color-color-palette';
    $scope.primary = 'purple';
    $scope.accent = 'green';

    $scope.isPrimary = true;

    $scope.selectTheme = function (color) {
      if ($scope.isPrimary) {
        $scope.primary = color;

        $scope.isPrimary = false;
      }
      else {
        $scope.accent = color;

        $scope.isPrimary = true;
      }
    };
  })
  .directive('themePreview', function () {
    return {
      restrict: 'E',
      templateUrl: 'color/colortemplate.html',
      scope: {
        primary: '=',
        accent: '='
      },
      controller: function ($scope, $mdColors, $mdColorUtil) {
        $scope.getColor = function (color) {
          return $mdColorUtil.rgbaToHex($mdColors.getThemeColor(color));
        };
      }
    };
  })
  .directive('mdJustified', function() {
    return {
      restrict : 'A',
      compile : function(element, attrs)  {
        var layoutDirection = 'layout-'+ (attrs.mdJustified || "row");

        element.removeAttr('md-justified');
        element.addClass(layoutDirection);
        element.addClass("layout-align-space-between-stretch");

        return angular.noop;
      }
    };
  });

myapp.controller('AppCtrl', function($scope) {

    $scope.items = [1,2,3,4,5];
      $scope.selected = [];

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
});