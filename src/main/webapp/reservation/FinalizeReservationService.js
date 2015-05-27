(function(){
  'use strict';

  angular
    .module('CineMVC')
    .service('FinalizeReservationService', FinalizeReservationService);

    FinalizeReservationService.$inject = ['$http', 'Reservation', '$q'];

    function FinalizeReservationService($http, Reservation, $q) {

        this.finalize = function (reservation, seats) {

            console.log('Finalizing reservation:');

            var hallId = reservation.show.hall.id;
            var show = reservation.show;
            var seatsToReserve = [];
            var savedSeats = 0;
            var deffered = $q.defer();

            //Zajmij krzesłą
            console.log('HallId' + hallId);
            console.log('Seats:' + angular.toJson(seats));

            $http.get('/api/halls/' + hallId + '/seats')
                .success(function (data, status, headers, config) {
                    //filtrowanie siedzen
                    seatsToReserve = data.filter(function (seatResource) {
                        for (var i = 0; i < seats.length; i++) {
                            if (seats[i].x == seatResource.xPosition && seats[i].y == seatResource.yPosition) {
                                return true;
                            }
                        }
                        return false;
                    });

                    console.log('Pobrane resourcy ' + angular.toJson(seatsToReserve));

                    var seatsReservation = [];

                    for (var i = 0; i < seatsToReserve.length; i++) {
                        seatsReservation.push({
                            'reservation': reservation,
                            'seat': seatsToReserve[i],
                            'show': show
                        });
                    }

                    $http.post('/api/seatReservations/list', seatsReservation)
                        .success(function (data) {
                            deffered.resolve(data);
                        });
                });

            return deffered.promise;
        };

        return this;

    }

})();
