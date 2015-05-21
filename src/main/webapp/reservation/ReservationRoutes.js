(function () {
    angular
        .module('CineMVC')
        .config(['$routeProvider', function ($routeProvider) {

            $routeProvider
                .when('/reservation', {
                    templateUrl: 'reservation/reservation.html',
                    controller: 'ReservationController'
                });
    }]);
})();
