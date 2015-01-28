var CineMVC = angular.module("CineMVC",['ngRoute', 'ngResource']);

CineMVC.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'partials/index.html',
                controller: 'IndexController'
            })
            .otherwise({
                redirectTo: '/'
            });
    }]);
