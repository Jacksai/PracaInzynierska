(function () {
    'use strict';

    angular
        .module('CineMVC')
        .factory('Showing', function($resource) {
            return $resource('/api/showings/:id', {id: '@id'});
        });

})();