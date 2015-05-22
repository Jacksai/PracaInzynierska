(function(){
  'use strict';

  angular
    .module('CineMVC')
    .service('FinalizeReservationService', FinalizeReservationService);

    FinalizeReservationService.$inject = ['$http', 'Reservation'];

    function FinalizeReservationService($http, Reservation) {
        

    }

})();
