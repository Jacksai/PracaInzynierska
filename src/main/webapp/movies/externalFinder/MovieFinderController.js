(function () {
    'use strict';

    angular
        .module('CineMVC')
        .controller('MovieFinderController', MovieFinderController);

    MovieFinderController.$inject = ['$scope', 'ExternalMovieFinderService'];

    function MovieFinderController($scope, ExternalMovieFinderService) {

        var vm = $scope;

        vm.movieTitle = '';
        vm.foundMovies = '';
        vm.requestCompleted = false;

        vm.searchMovie = searchMovie;

        init();

        function searchMovie() {
            vm.requestCompleted = false;

            ExternalMovieFinderService.findMovie(vm.movieTitle).then(function(data) {
                vm.requestCompleted = true;
                vm.foundMovies = data.results;
            });
        }

        //For development only
        function init() {
            vm.movieTitle = 'Titanic';
            searchMovie();
        }

    }


})();