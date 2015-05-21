(function () {
    'use strict';

    angular
        .module('CineMVC')
        .controller('ShowingController', ShowingController)
        .controller('CreateShowController', CreateShowController);

    ShowingController.$inject = ['$scope', 'Showing', 'Movie', 'Hall', '$modal'];

    function ShowingController ($scope, Showing, Movie, Hall, $modal) {

        var vm = $scope;

        vm.showings = [];
        vm.editShow = editShow;
        vm.deleteShow = deleteShow;
        vm.createNewShow = createNewShow;

        loadShows();

        function editShow(show) {

        }

        function deleteShow(show) {

        }

        function createNewShow() {
            console.log('Creating new show');

            var modalInstance = $modal.open({
                templateUrl: 'partials/createShowingModal.html',
                controller: 'CreateShowController',
                resolve: {
                    showing: function () {
                        return {};
                    }
                }
            }).result.then(function () {
                    loadShows();
                });

        }

        function loadShows() {
            vm.showings = Showing.query();
        }



    }

    CreateShowController.$inject = ['$scope', 'showing', 'Showing','Movie', 'Hall'];

    function CreateShowController ($scope, showing, Showing, Movie, Hall) {

        var vm = $scope;

        vm.showing = showing;



    }

})();