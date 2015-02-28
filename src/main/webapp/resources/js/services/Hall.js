(function () {
    'use strict';

    angular
        .module('CineMVC')
        .factory('Hall', function($resource) {
        return $resource('/api/halls/:id');
    });

})();