'use strict';

// Declare app level module which depends on views, and components
angular.module('morsecodeTrainer', [
  'ngRoute',
  'morsecodeTrainer.trainer'
  // 'morsecodeTrainer.version'
]).
config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
  $locationProvider.hashPrefix('!');

  $routeProvider.otherwise({redirectTo: '/trainer'});
}]);
