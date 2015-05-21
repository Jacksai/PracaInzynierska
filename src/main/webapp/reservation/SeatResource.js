(function () {
    'use strict';

    angular
        .module('CineMVC')
        .factory('Seat', Seat);

    Seat.$inject = ['$resource'];

    function Seat($resource) {
        return $resource('/api/seats/:id', {id: '@id'});
    }
})();