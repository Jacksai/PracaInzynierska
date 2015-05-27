(function () {
    'use strict';

    angular
        .module('CineMVC')
        .controller('SummationController', SummationController);

    SummationController.$inject = ['$scope', '$modalInstance', 'reservation', 'seats', 'FinalizeReservationService'];

    function SummationController ($scope, $modalInstance, reservation, seats, FinalizeReservationService) {

        var vm = $scope;

        vm.reservation = reservation;
        vm.seats = seats;
        vm.confirmReservation = confirmReservation;

        vm.close = close;

        init();

        function init() {
            console.log('Summation Controller Init');
            console.log("Reservation" + angular.toJson(reservation));
            console.log("Seats" + angular.toJson(seats));
        }

        function close() {
            $modalInstance.close();
        }

        function confirmReservation() {
            FinalizeReservationService.finalize(vm.reservation, vm.seats)
                .then(function(data) {
                    $modalInstance.close();
                    //Add modal with confirmation of reservation:
                });

        }

    }

})();
