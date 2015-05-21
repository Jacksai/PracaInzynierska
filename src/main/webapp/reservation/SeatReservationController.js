(function(){
    'use strict';

    angular
        .module('CineMVC')
        .controller('SeatReservationController', SeatReservationController);

    SeatReservationController.$inject = ['$scope', '$routeParams', 'Showing'];

    function SeatReservationController($scope, $routeParams, Showing) {

        var vm = $scope;

        vm.showId = $routeParams.showId;
        vm.hall = {};
        vm.showing = {};
        vm.onSeatClick = onSeatClick;
        vm.isSeatSelected = isSeatSelected;
        vm.selectedSeats = [];

        init();

        function init() {
            Showing.get({'id': vm.showId}).$promise.then(function (data) {
                vm.hall = data.hall;
                vm.hallHeight = vm.hall.yLength;
                vm.hallWidth = vm.hall.xLength;
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

    }

})();