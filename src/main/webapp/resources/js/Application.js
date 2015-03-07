(function () {
    'use strict';

    angular
        .module('CineMVC',['ngRoute', 'ngResource', 'ui.bootstrap']);

    angular
        .module('CineMVC')
        .config(['$routeProvider',
        function($routeProvider) {
            $routeProvider
                .when('/', {
                    templateUrl: 'partials/index.html',
                    controller: 'IndexController'
                })
                .when('/movies', {
                    templateUrl: 'partials/movies.html',
                    controller: 'MovieController'
                })
                .when('/halls',{
                    templateUrl: 'partials/hall.html',
                    controller: 'HallController'
                })
                .when('/categories', {
                    templateUrl: 'partials/category.html',
                    controller: 'CategoryController'
                })
                .otherwise({
                    redirectTo: '/'
                });
        }]);

})();



