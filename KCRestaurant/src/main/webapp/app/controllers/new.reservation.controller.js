/**
 * Created by shreedhar on 12/12/2015.
 */

(function () {
    'use strict';

    angular.module('restaurant')
        .controller('NewReservationCtrl', NewReservationCtrl);

    NewReservationCtrl.$inject = ['dataServices', '$route', '$filter', '$location', '$rootScope', '$timeout'];

    function NewReservationCtrl(dataServices, $route, $filter, $location, $rootScope, $timeout) {
        var newRsVm = this;
        newRsVm.isTimeAvailable = false;
        newRsVm.placeholder = {};
        newRsVm.reservationString = { };
        newRsVm.reservationString.reservation = {};

        newRsVm.today = function() {
            newRsVm.reservationString.reservation.date = new Date();
        };

        newRsVm.today();

        // Disable weekend selection
        newRsVm.disabled = function(date, mode) {
            return ( mode === 'day' && ( date.getDay() === 0 || date.getDay() === 6 ) );
        };

        newRsVm.toggleMin = function() {
            newRsVm.minDate = newRsVm.minDate ? null : new Date();
        };

        newRsVm.toggleMin();
        newRsVm.maxDate = new Date(2020, 5, 22);

        newRsVm.open = function($event) {
            newRsVm.status.opened = true;
        };

        newRsVm.setDate = function(year, month, day) {
            newRsVm.reservationString.reservation.date = new Date(year, month, day);
        };

        newRsVm.dateOptions = {
            formatYear: 'yy',
            startingDay: 1
        };

        newRsVm.formats = ['yyyy-MM-dd', 'dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
        newRsVm.format = newRsVm.formats[0];

        newRsVm.status = {
            opened: false
        };

        newRsVm.submit = function()
        {
            newRsVm.reservationString.reservation.date = newRsVm.reservationString.reservation.date.toISOString().slice(0,10);
            newRsVm.reservationString.reservation.endTime =
                $filter('date')( newRsVm.placeholder.endTime, "HH:mm:ss");
            newRsVm.reservationString.reservation.startTime =
                $filter('date')( newRsVm.placeholder.startTime, "HH:mm:ss");

            newRsVm.isTimeAvailable = false;
            console.log("The reservation String is");
            console.dir(newRsVm.reservationString);
            dataServices.createNewReservation(newRsVm.reservationString)
                .then(function(data){
                    console.log("Received data");
                    console.log(data);
                    $location.path('/newReservation/cnfrm/');
                    $timeout(function () {
                    	//Event will be caught by New Reservation Cnfrm Controller.
                    	$rootScope.$broadcast('sendingReservationConfimationObject', data); 
                    }, 100);
                    
                }, function(error){
                    if(error === "time-un-available"){
                        newRsVm.isTimeAvailable = true;
                    }
                });
        }

        newRsVm.discard = function(){
            $route.reload();
        }

    }

})();
