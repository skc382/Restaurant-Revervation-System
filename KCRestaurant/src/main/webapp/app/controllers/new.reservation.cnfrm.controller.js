/**
 * Created by shreedhar on 12/13/2015.
 */

(function () {
    'use strict';

    angular.module('restaurant')
        .controller('ConfirmReservationCtrl', ConfirmReservationCtrl);

    ConfirmReservationCtrl.$inject = ['dataServices', '$routeParams', '$location'];

    function ConfirmReservationCtrl(dataServices, $routeParams, $location) {
        var cnfrmRsVm = this;
        cnfrmRsVm.reservation = {};
        execute($routeParams.reservationObj);

        function execute(reservationObj){
            console.log("reservation objec is");
            console.dir(reservationObj.Reservations);
            cnfrmRsVm.reservation = reservationObj.Reservations;
        }

        cnfrmRsVm.okay = function(){
            $location.path('/home');
        }
    }

})();