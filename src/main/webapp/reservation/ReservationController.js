(function () {
    'use strict';

    angular
        .module('CineMVC')
        .controller('ReservationController', ReservationController);

    ReservationController.$inject = ['$scope', 'Showing'];

    function ReservationController ($scope, Showing) {

        var vm = $scope;

        vm.pendingShows = Showing.query();


    }
})();
