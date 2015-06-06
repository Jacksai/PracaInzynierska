(function () {

    angular
        .module('CineMVC')
        .service('ExternalMovieFinderService', ExternalMovieFinderService);

    ExternalMovieFinderService.$inject = ['$http', '$q'];

    function ExternalMovieFinderService($http, $q) {

        this.findMovie = function(title) {

            var defered = $q.defer();

            $http.get('/api/externalMovieFinder/' + title)
                .success(function(data) {
                   defered.resolve(data);
                });

            return defered.promise;
        };

        this.getMovieDetails = function (movieId) {
            var defered = $q.defer();

            $http.get('/api/externalMovieFinder/id/' + movieId)
                .success(function (data) {
                    defered.resolve(data);
                });

            return defered.promise;
        };

        return this;
    }


})();