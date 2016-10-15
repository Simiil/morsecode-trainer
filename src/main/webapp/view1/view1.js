'use strict';

angular.module('morsecodeTrainer.view1', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view1', {
    templateUrl: 'view1/view1.html',
    controller: 'View1Ctrl'
  });
}])

.controller('View1Ctrl', ['$scope', function($scope) {
    console.log("THE FUCK?!");

    $scope.message = {};
    $scope.message.test = 'bla';

    $scope.greet = "thats the angular BEGIN";
    $scope.username = 'World';

    $scope.sayHello = function() {
        $scope.greeting = 'Hello ' + $scope.username + '!';
  };
}]);
