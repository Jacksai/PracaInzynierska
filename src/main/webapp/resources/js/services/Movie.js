CineMVC.factory('Movie', function($resource) {
    return $resource('/api/movies/:id');
});