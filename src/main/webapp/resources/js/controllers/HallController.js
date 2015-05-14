(function () {
    'use strict';

    angular
        .module('CineMVC')
        .controller('HallController', ['$scope', '$http', 'Hall','$modal', function ($scope, $http, Hall, $modal) {

            var vm = $scope;

            vm.halls = [];
            vm.createHall = createHall;
            vm.deleteHall = deleteHall;

            reloadHalls();

            function reloadHalls() {
                vm.halls = Hall.query();
            }


            function createHall() {
                var modalInstance = $modal.open({
                    templateUrl: 'createHallModal.html',
                    controller: 'CreateHallController',
                    resolve: {
                        hall: function () {
                            return {};
                        }
                    }
                })
            }

            function deleteHall(hall) {
                Hall.delete(hall);
               setTimeout(reloadHalls(), 1000);
            }

    }])
        .controller('CreateHallController', ['$scope', '$modalInstance', 'hall', 'Hall',function($scope,$modalInstance , hall, Hall){

            var vm = $scope;
            vm.hall = hall;
            vm.saveHall = saveHall;
            vm.cancel = cancel;
            vm.validationErrors

            function saveHall() {
                console.log('Saving hall' + angular.toJson(hall));

                Hall.save(hall, function(succesResult) {
                    //Saving successfully
                    console.log("Hall saved successfully : " + angular.toJson(hall));
                    $modalInstance.close(vm.hall)
                }, function(errorResult) {
                    //Error in saving
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

        }]);

})();

