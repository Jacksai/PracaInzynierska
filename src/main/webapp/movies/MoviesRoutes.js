(function () {
    angular
        .module('CineMVC')
        .config(['$routeProvider', function ($routeProvider) {

            $routeProvider
                .when('/movies', {
                    templateUrl: 'movies/movies.html',
                    controller: 'MovieController'
                })
                .when('/movies/external', {
                    templateUrl: 'movies/externalFinder/movieFinder.html',
                    controller: 'MovieFinderController'
                })
                .when('/movies/external/:movieId', {
                    templateUrl: 'movies/externalFinder/movieFinderDetails.html',
                    controller: 'MovieFinderDetailsController'
                })
        }]);
})();
