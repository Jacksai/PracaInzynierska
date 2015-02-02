CineMVC.controller('MovieController', ['$scope', '$http', '$modal', 'Movie','Category', function ($scope, $http, $modal, Movie, Category) {

    $scope.movies = Movie.query();

    $scope.editMovie = function(movie) {
        console.log("Edit movie" + JSON.stringify(movie));
    }

    $scope.deleteMovie = function(movie) {
        console.log("Delete movie" + JSON.stringify(movie));
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

CineMVC.controller("CreateMovieController",  function ($scope, $modalInstance, Category,Movie, movie) {

    $scope.movie = {active : true}
    $scope.categories =  Category.query();

    $scope.saveMovie = function () {
        console.log("Saving movie: " + JSON.stringify($scope.movie));

        Movie.save($scope.movie, function (successResult) {
            console.log("SAVING SUCCESS: " + JSON.stringify(successResult));
            $modalInstance.close($scope.movie);
        }, function (errorResult) {

            console.log("ERROR:" + JSON.stringify(errorResult));

            if(errorResult.data.ValidationErrors) {
                //VALIDATION ERRORS
                console.log("ValidationErrors" + JSON.stringify(errorResult.data.ValidationErrors))
                $scope.validationErrors = errorResult.data.ValidationErrors ;
            }

        });
    };

    $scope.cancel = function () {
        $modalInstance.close();
    };
});

