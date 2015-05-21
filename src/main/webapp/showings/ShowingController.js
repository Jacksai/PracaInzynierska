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
            console.log('Editing show: ' + angular.toJson(show));
            openModal(show);       }

        function deleteShow(show) {
            show.$delete().then(function () {
                loadShows();
            });

        }

        function createNewShow() {
            openModal({});
        }

        function openModal(showToEdit) {
            var modalInstance = $modal.open({
                templateUrl: 'showings/createShowingModal.html',
                controller: 'CreateShowController',
                resolve: {
                    showing: function () {
                        return showToEdit;
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

    CreateShowController.$inject = ['$scope', 'showing', 'Showing','Movie', 'Hall', '$modalInstance'];

    function CreateShowController ($scope, showing, Showing, Movie, Hall, $modalInstance) {

        var vm = $scope;

        vm.halls = Hall.query();
        vm.movies = Movie.query();
        vm.showing = showing;
        vm.saveShow = saveShow;
        vm.cancel = cancel;
        vm.validationErrors = [];

        init();

        function init() {
            console.log('Showing' + angular.toJson(vm.showing));
        }

        function saveShow () {
            console.log('Saving show: ' + angular.toJson(vm.showing));

            Showing.save(vm.showing, function (data) {
                //Successful save
                console.log("SAVING SUCCESS: " + JSON.stringify(data));
                $modalInstance.close(vm.showing);

            }, function (reason) {
                //Save failed
                if(reason.data.ValidationErrors) {
                    //VALIDATION ERRORS
                    console.log("ValidationErrors" + JSON.stringify(reason.data.ValidationErrors));
                    $scope.validationErrors = reason.data.ValidationErrors ;
                }
            });
        }

        function cancel() {
            $modalInstance.close();
        }
    }

})();
