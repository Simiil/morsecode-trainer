'use strict';

angular.module('morsecodeTrainer.auth', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/auth', {
    templateUrl: 'view_auth/auth.html',
    controller: 'AuthCtrl'
  });
}])

.controller('AuthCtrl', ['$scope', function($scope) {
    console.log("THE FUCK?!");

    $scope.message = {};
    $scope.message.test = 'bla';

    $scope.greet = "thats the angular BEGIN";
    $scope.username = 'World';

    $scope.sayHello = function() {
        $scope.greeting = 'Hello ' + $scope.username + '!';
  };
}]);
