(function () {
    'use strict';

    angular
        .module('CineMVC')
        .controller('ShowingController', ShowingController);

    ShowingController.$inject = ['$scope', 'Showing', 'Movie', 'Hall'];

    function ShowingController ($scope, Showing, Movie, Hall) {

        var vm = $scope;

        vm.showings = [];
        vm.editShow = editShow;
        vm.deleteShow = deleteShow;
        vm.createNewShow = createNewShow;

        init();

        function editShow(show) {

        }

        function deleteShow(show) {

        }

        function createNewShow() {

        }

        function init() {
            vm.showings = Showing.query();
        }



    }

})();