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
                    templateUrl: 'index/index.html',
                    controller: 'IndexController'
                })
                .when('/movies', {
                    templateUrl: 'movies/movies.html',
                    controller: 'MovieController'
                })
                .when('/halls',{
                    templateUrl: 'halls/hall.html',
                    controller: 'HallController'
                })
                .when('/categories', {
                    templateUrl: 'categories/categories.html',
                    controller: 'CategoryController'
                })
                .when('/showings', {
                    templateUrl: 'showings/showings.html',
                    controller: 'ShowingController'
                })
                .otherwise({
                    redirectTo: '/'
                });
        }]);

})();



