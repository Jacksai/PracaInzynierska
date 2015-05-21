(function () {
    'use strict';

    angular
        .module('CineMVC')
        .filter('range', Range);

    function Range () {
        return function(input, total) {
            total = parseInt(total);
            for (var i=0; i<total; i++)
                input.push(i);
            return input;
        };
    }
})();