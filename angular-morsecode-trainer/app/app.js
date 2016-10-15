'use strict';

// Declare app level module which depends on views, and components
angular.module('morsecodeTrainer', [
  'ngRoute',
  'morsecodeTrainer.view1',
  'morsecodeTrainer.view2',
  'morsecodeTrainer.auth',
  // 'morsecodeTrainer.version'
]).
config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
  $locationProvider.hashPrefix('!');

  $routeProvider.otherwise({redirectTo: '/auth'});
}]);
