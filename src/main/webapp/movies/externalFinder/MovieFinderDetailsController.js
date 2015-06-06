(function () {
    'use strict';

    angular
        .module('CineMVC')
        .controller('MovieFinderDetailsController', MovieFinderDetailsController);

    MovieFinderDetailsController.$inject = ['$scope', 'ExternalMovieFinderService', '$routeParams'];

    function MovieFinderDetailsController($scope, ExternalMovieFinderService, $routeParams) {

        var vm = $scope;

        vm.save = save;

        vm.movieId = $routeParams.movieId;
        vm.movieDetalis = {};

        init();

        function save() {
            console.log('Saving movie');
        }

        function init() {
            ExternalMovieFinderService.getMovieDetails(vm.movieId)
                .then(function (data) {
                    vm.movieDetails = data;
                })
        }



    }
})();