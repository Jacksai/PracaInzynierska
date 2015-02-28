(function () {
    angular
        .module('CineMVC')
        .controller('IndexController', ['$scope', '$http', 'Movie', function ($scope, $http, Movie) {

        $scope.message = "HELLO WORLD";

    }]);
})();