CineMVC.controller('MovieController', ['$scope', '$http', '$modal', 'Movie', function ($scope, $http, $modal, Movie) {

    $scope.movies = Movie.query();

    $scope.editMovie = function(movie) {
        console.log("Create movie" + movie);
    }

    $scope.deleteMovie = function(movie) {
        console.log("Delete movie" + movie);
    }

    $scope.createMovie = function() {
        var modalInstance = $modal.open({
            templateUrl: 'createMovieModal.html',
            controller: 'CreateMovieController',
            resolve: {
                movie: function () {
                    return $scope.newMovie;
                }
            }
        })
    }

}]);

CineMVC.controller("CreateMovieController",  function ($scope, $modalInstance, movie) {
    $scope.saveMovie = function () {
        console.log("Saving movie: " + movie);
        $modalInstance.close(movie);
    };

    $scope.cancel = function () {
        $modalInstance.close();
    };
});

