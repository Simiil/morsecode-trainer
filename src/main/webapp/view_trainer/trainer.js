'use strict';

angular.module('morsecodeTrainer.trainer', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/trainer', {
    templateUrl: 'view_trainer/trainer.html',
    controller: 'TrainerCtrl'
  });
}])

.controller('TrainerCtrl', ['$scope', function($scope) {
  $scope.challenge = '---';
  $scope.itu = {
    A: ".-",
    B: "-...",
    C: "-.-.",
    D: "-..",
    E: ".",
    F: "..-.",
    G: "--.",
    H: "....",
    I: "..",
    J: ".---",
    K: "-.-",
    L: ".-..",
    M: "--",
    N: "-.",
    O: "---",
    P: ".--.",
    Q: "--.-",
    R: ".-.",
    S: "...",
    T: "-",
    U: "..-",
    V: "...-",
    W: ".--",
    X: "-..-",
    Y: "-.--",
    Z: "--..",

    1: ".----",
    2: "..---",
    3: "...--",
    4: "....-",
    5: ".....",
    6: "-....",
    7: "--...",
    8: "---..",
    9: "----.",
    0: "-----",
  };

  $scope.setChallenge = function(letter) {
    $scope.challenge = $scope.itu[letter];
  };
}]);
