(function () {
    'use strict';

    angular
        .module('CineMVC')
        .controller('SummationController', SummationController);

    SummationController.$inject = ['$scope', '$modalInstance', 'reservation'];

    function SummationController ($scope, $modalInstance, reservation) {

        var vm = $scope;

        vm.close = close;

        init();

        function init() {
            console.log("Reservation" + angular.toJson(reservation));
        }

        function close() {
            $modalInstance.close();
        }

    }

})();
