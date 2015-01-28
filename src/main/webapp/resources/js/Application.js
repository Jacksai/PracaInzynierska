var CineMVC = angular.module("CineMVC",['ngRoute', 'ngResource', 'ui.bootstrap']);

CineMVC.config(['$routeProvider',
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
            .otherwise({
                redirectTo: '/'
            });
    }]);
