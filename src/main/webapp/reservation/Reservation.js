(function () {
    'use strict';

    angular
        .module('CineMVC')
        .factory('Reservation', Reservation);

    Reservation.$inject = ['$resource'];

    function Reservation ($resource) {
        return $resource('/api/reservations/:id', {id: '@id'});
    }
})();