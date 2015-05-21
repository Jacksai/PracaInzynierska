(function () {
    'use strict';

    angular
        .module('CineMVC')
        .controller('ShowingDetailController', ShowingDetailController);

    ShowingDetailController.$inject = ['$scope', '$routeParams', 'Showing'];

    function ShowingDetailController($scope, $routeParams, Showing) {

        var vm = $scope;

        vm.showId = $routeParams.showId;
        vm.showing = Showing.get({'id': vm.showId}).$promise.then(function (data) {
            console.log('Pobrano' + angular.toJson(data));
        });

        init();

        function init() {

        }

    }

})();