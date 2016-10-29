'use strict';

angular.module('morsecodeTrainer.trainer', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/trainer', {
    templateUrl: 'view_trainer/trainer.html',
    controller: 'TrainerCtrl'
  });
}])

.controller('TrainerCtrl', ['$scope', '$http', function($scope, $http) {


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
        $scope.alphabet = $scope.itu;

        $scope.getChallenge = function(){
          $http.get("/api/morse/game/gettone/foo").then(function(response) {
              $scope.aktChallenge = response.data;
              console.log($scope.aktChallenge);
          });
      }

      $scope.putChallenge = function(character){

          var req = {
             method: 'PUT',
             url: '/api/morse/game/gettone/foo',
             headers: {
               'Content-Type': "application/json"
             },
             data: {
                	"character": character,
                  	"id": $scope.aktChallenge.id
                }
            }

            var responseData;

            $http(req).then(function(response) {
                console.log("Sending Successful");
                responseData = response.data;
                console.log(responseData);
                return responseData;
            });
      }

      $scope.setChallenge = function(letter) {
        $scope.lastChallenge =  $scope.putChallenge(letter);
        $scope.challenge = $scope.itu[letter] + $scope.lastChallenge;
        $scope.getChallenge();
      };


      $scope.onInit = function(){
          $scope.getChallenge().then(function(response){
                $scope.challenge = response.data.character.tone;
                console.log("hier wurden daten abgefragt!");
          });
      };
      $scope.onInit();
}]);
