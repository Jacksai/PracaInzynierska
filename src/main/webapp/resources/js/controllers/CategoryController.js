(function () {
    'use strict';

    angular
        .module('CineMVC')
        .controller('CategoryController', CategoryController );

    CategoryController.$inject = ['$scope', 'Category', '$modal'];

    function CategoryController ($scope, Category, $modal) {

            var vm = $scope;

            vm.categories = [];
            vm.editCategory = editCategory;
            vm.deleteCategory = deleteCategory;
            vm.createCategory = createCategory;
            vm.newCategory = {};

            loadData();

            function loadData() {
                vm.categories = Category.query();
            }

            function editCategory(category) {
                console.log('Edit category: ' + JSON.stringify(category));

                var modalInstance = $modal.open({
                    templateUrl: 'createCategoryModal.html',
                    controller: 'CreateCategoryController',
                    resolve: {
                        category: function () {
                            return category;
                        }
                    }
                })

            }

            function deleteCategory(category) {
                category.$delete(function() {
                    loadData();
                });
            }

            function createCategory() {
                    var modalInstance = $modal.open({
                        templateUrl: 'createCategoryModal.html',
                        controller: 'CreateCategoryController',
                        resolve: {
                            category: function () {
                                return {};
                            }
                        }
                    })
            }
    }

    angular
        .module('CineMVC')
        .controller("CreateCategoryController", CreateCategoryController);

    CreateCategoryController.$inject = ['$scope', '$modalInstance', 'Category', 'category'];

    function CreateCategoryController($scope, $modalInstance, Category, category) {

        var vm = $scope;

        vm.category = category;
        vm.saveCategory = saveCategory;
        vm.cancel = cancel;
        vm.validationErros = null;

        var backupCategory = angular.copy(category);

        function saveCategory() {
            console.log("Saving movie: " + JSON.stringify($scope.category));

            Category.save(vm.category, function (successResult) {
                console.log("SAVING SUCCESS: " + JSON.stringify(successResult));
                $modalInstance.close(vm.category);
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
            category = backupCategory;
            $modalInstance.close();
        }
    }

})();