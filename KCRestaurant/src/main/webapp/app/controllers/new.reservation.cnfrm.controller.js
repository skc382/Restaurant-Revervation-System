/**
 * Created by shreedhar on 12/13/2015.
 */

(function () {
    'use strict';

    angular.module('restaurant')
        .controller('ConfirmReservationCtrl', ConfirmReservationCtrl);

    ConfirmReservationCtrl.$inject = ['dataServices', '$routeParams', '$location', '$rootScope'];

    function ConfirmReservationCtrl(dataServices, $routeParams, $location, $rootScope) {
        var cnfrmRsVm = this;
        cnfrmRsVm.reservation = {};
        
        $rootScope.$on('sendingReservationConfimationObject', function(event, args){
            console.log("reservation objec is");
            console.log(args);
            cnfrmRsVm.reservation = args;
            console.log("The Cnfrm Vm obj is :");
            console.log(cnfrmRsVm.reservation);
        });

        cnfrmRsVm.okay = function(){
            $location.path('/home');
        }
    }

})();