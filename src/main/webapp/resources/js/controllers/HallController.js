(function () {
    'use strict';

    angular
        .module('CineMVC')
        .controller('HallController', ['$scope', '$http', 'Hall', function ($scope, $http, Halsza ) {

        $scope.halls = Hall.query();

    }]);


})();

