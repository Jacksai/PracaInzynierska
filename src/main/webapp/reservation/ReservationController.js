(function () {
    'use strict';

    angular
        .module('CineMVC')
        .controller('ReservationController', ReservationController);

    ReservationController.$inject = ['$scope', 'Showing', '$location'];

    function ReservationController ($scope, Showing, $location) {

        var vm = $scope;

        vm.pendingShows = Showing.query();
        vm.reservation = reservation;

        function reservation (showing) {
            console.log(angular.toJson(showing));
            $location.path('reservation/'+ showing.id +'/seat');
        }

    }
})();
