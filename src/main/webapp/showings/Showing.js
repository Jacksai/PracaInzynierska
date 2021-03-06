(function () {
    'use strict';

    angular
        .module('CineMVC')
        .factory('Showing', Showing);

    Showing.$inject = ['$resource'];

    function Showing( $resource) {
        return $resource('/api/showings/:id', {id: '@id'}, {
            freeSeats: {method: 'GET', params: {id: '@id'}, url: '/api/showings/:id/freeSeats', isArray: true}
        });
    }

})();