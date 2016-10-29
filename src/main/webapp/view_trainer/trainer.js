'use strict';

angular.module('morsecodeTrainer.trainer', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/trainer', {
        templateUrl: 'view_trainer/trainer.html',
        controller: 'TrainerCtrl'
    });
}])

.controller('TrainerCtrl', ['$scope', '$http', function($scope, $http) {
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

    $scope.dropDownMenus = {};
    $scope.dropDownMenus = {
        "code": {
            "ITU": "ITU",
            "Morse": "Morse",
            "Gerke": "Gerke"
        },
        "speed": {
            1: "fa fa-wheelchair",
            2: "fa fa-bicycle",
            3: "fa fa-car",
            4: "fa fa-plane",
            5: "fa fa-rocket"
        },
        "noise": {
            1: "fa fa-circle",
            2: "fa fa-certificate",
            3: "fa fa-asterisk"
        }
    };

    $scope.dropDownCodeActive = $scope.dropDownMenus["code"]["ITU"];
    $scope.dropDownSpeedActive = $scope.dropDownMenus["speed"][1];
    $scope.dropDownNoiseActive = $scope.dropDownMenus["noise"][1];
    $scope.codeVisibilityStatus = true;
    $scope.sheetVisibilityStatus = true;

    function boolToMorse(bool) {
        return (bool == true ? '-' : '•');
    }

    function challengeDataToCode(challengeData) {
        challenge = "";
        for (var l in challengeData.character.tone) {
            if (challengeData.character.tone.hasOwnProperty(l)) {
                challenge = challenge + boolToMorse(challengeData.character.tone[l]);
            }
        }
        return challenge;
    }

    // gets a new challenge morse code
    $scope.getChallenge = function() {
        $http.get("/api/morse/game/gettone/foo").then(function(response) {
            $scope.challengeData = response.data;
            console.log($scope.challengeData);
            $scope.challenge = challengeDataToCode($scope.challengeData);
            return $scope.challengeData.character.tone[0].toString();
        });
    }

    $scope.putChallenge = function(character) {
        var req = {
            method: 'PUT',
            url: '/api/morse/game/gettone/foo',
            headers: {
                'Content-Type': "application/json"
            },
            data: {
                "character": character,
                "id": $scope.challengeData.id
            }
        }

        var responseData;
        $http(req).then(function(response) {
            responseData = response.data;
            return responseData;
        });
    }

    $scope.setChallenge = function(letter) {
        $scope.lastChallenge = $scope.putChallenge(letter);
        $scope.challenge = $scope.itu[letter] + $scope.lastChallenge;
        $scope.getChallenge();
    };

    $scope.onInit = function() {
        $scope.getChallenge();
    };

    $scope.onInit();

    $scope.setChallenge = function(letter) {
        $scope.challenge = $scope.itu[letter];
    };

    $scope.setCode = function(key) {
        $scope.dropDownCodeActive = $scope.dropDownMenus["code"][key];
    }

    $scope.setSpeed = function(key) {
        $scope.dropDownSpeedActive = $scope.dropDownMenus["speed"][key];
    }

    $scope.setNoise = function(key) {
        $scope.dropDownNoiseActive = $scope.dropDownMenus["noise"][key];
    }
}]);
