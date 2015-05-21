(function () {
    'use strict';

    angular
        .module('CineMVC')
        .factory('Hall', HallResource);

    HallResource.$inject = ['$resource'];

    function HallResource($resource) {
        return $resource('/api/halls/:id');
    }

})();