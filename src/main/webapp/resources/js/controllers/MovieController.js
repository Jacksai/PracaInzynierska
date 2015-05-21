(function () {
    'use strict';

    angular
        .module('CineMVC')
        .controller('MovieController', MovieController);

    MovieController.$inject = ['$scope', '$http', '$modal', 'Movie','Category'];

    function MovieController($scope, $http, $modal, Movie, Category) {

        var vm = $scope;

        vm.movies = Movie.query();
        vm.editMovie = editMovie;
        vm.deleteMovie = deleteMovie;
        vm.createMovie = createMovie;

        function editMovie (movie) {
            console.log("Edit movie" + JSON.stringify(movie));

            var modalInstance = $modal.open({
                templateUrl: 'createMovieModal.html',
                controller: 'CreateMovieController',
                resolve: {
                    movie: function () {
                        return movie;
                    }
                }
            })
        }

        function deleteMovie(movie) {
            console.log("Delete movie" + JSON.stringify(movie));
            Movie.delete(movie);
        }

        function createMovie() {
            var modalInstance = $modal.open({
                templateUrl: 'createMovieModal.html',
                controller: 'CreateMovieController',
                resolve: {
                    movie: function () {
                        return {};
                    }
                }
            })
        }

    }

    angular
        .module('CineMVC')
        .controller("CreateMovieController",CreateMovieController);

    CreateMovieController.$inject = ['$scope', '$modalInstance', 'Category', 'Movie', 'movie'];

    function CreateMovieController($scope, $modalInstance, Category, Movie, movie) {

        var vm = $scope;

        vm.movie = movie;
        vm.categories =  Category.query();
        vm.saveMovie = saveMovie;
        vm.cancel = cancel;
        vm.validationErros = null;

         function saveMovie() {
            console.log("Saving movie: " + JSON.stringify($scope.movie));

            Movie.save(vm.movie, function (successResult) {
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
        }

       function cancel() {
            $modalInstance.close();
        }
    }

})();