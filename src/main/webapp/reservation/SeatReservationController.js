(function(){
    'use strict';

    angular
        .module('CineMVC')
        .controller('SeatReservationController', SeatReservationController);

    SeatReservationController.$inject = ['$scope', '$routeParams', 'Showing', 'Reservation', '$modal'];

    function SeatReservationController($scope, $routeParams, Showing, Reservation, $modal) {

        var vm = $scope;

        vm.showId = $routeParams.showId;
        vm.hall = {};
        vm.showing = {};
        vm.selectedSeats = [];
        vm.reservation = {};
        vm.reservationStep = 1;

        vm.onSeatClick = onSeatClick;
        vm.isSeatSelected = isSeatSelected;
        vm.bookSeats = bookSeats;
        vm.backStep = backStep;
        vm.confirmBooking = confirmBooking;


        init();

        function init() {
            Showing.get({'id': vm.showId}).$promise.then(function (data) {
                vm.hall = data.hall;
                vm.hallHeight = vm.hall.yLength;
                vm.hallWidth = vm.hall.xLength;
                vm.reservation.show = data;
                console.log(vm);
            });
        }

        function onSeatClick(x, y) {
            if(!isSeatSelected(x, y)) {
                vm.selectedSeats.push({'x': x, 'y': y});
            } else {
                var obj = vm.selectedSeats.filter(function (seat) {
                    return seat.x === x && seat.y === y;
                })[0];

                var index = vm.selectedSeats.indexOf(obj);
                if(index > -1) {
                    vm.selectedSeats.splice(index, 1);
                }
            }

        }

        function isSeatSelected(x, y) {
           return  vm.selectedSeats.filter(function (seat) {
                return seat.x === x && seat.y === y;
            }).length > 0;
        }

        function bookSeats() {
            console.log('Booking seats' + angular.toJson(vm.selectedSeats));
            vm.reservationStep = 2;
        }

        function backStep() {
            vm.reservationStep = vm.reservationStep - 1;
        }

        function confirmBooking() {
            console.log('Reservations: ' + angular.toJson(vm.reservation));
            calculateSeatCount();
            Reservation.save(vm.reservation).$promise.then(function (data) {
                vm.savedReservation = data;

                var modalInstance = $modal.open({
                    templateUrl: 'reservation/summation/summationModal.html',
                    controller: 'SummationController',
                    resolve: {
                        reservation: function () {
                            return vm.savedReservation;
                        }
                    }
                }).result.then(function () {
                        console.log('Closed ziom');
                    });

            });
        }

        function calculateSeatCount() {
            vm.reservation.seatCount = vm.selectedSeats.length;
        }

    }

})();