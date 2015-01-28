CineMVC.controller('IndexController', ['$scope', '$http', 'Movie', function ($scope, $http, Movie) {

    $scope.message = "HELLO WORLD";
    $scope.movies = Movie.query();

}]);