(function () {
    'use strict';

    angular
        .module('CineMVC')
        .controller('CategoryController', CategoryController );

    CategoryController.$inject = ['$scope', 'Category', '$modal'];

    function CategoryController ($scope, Category, $modal) {

            var vm = $scope;

            vm.categories = Category.query();
            vm.editCategory = editCategory;
            vm.deleteCategory = deleteCategory;

            function editCategory(category) {
                console.log('Edit category: ' + JSON.stringify(category));
            }

            function deleteCategory(category) {
                console.log('Delete category: ' + JSON.stringify(category));
            }

        }

})();