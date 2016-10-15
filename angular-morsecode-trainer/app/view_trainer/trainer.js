'use strict';

angular.module('morsecodeTrainer.trainer', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/trainer', {
    templateUrl: 'view_trainer/trainer.html',
    controller: 'TrainerCtrl'
  });
}])

.controller('TrainerCtrl', ['$scope', function($scope) {
    $scope.greet = "thats the angular BEGIN";
    $scope.username = 'World';

    $scope.sayHello = function() {
        $scope.greeting = 'Hello ' + $scope.username + '!';
  };
}]);
