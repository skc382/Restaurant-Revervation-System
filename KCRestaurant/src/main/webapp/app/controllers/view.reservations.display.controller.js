(function () {
    'use strict';

    angular.module('restaurant')
        .controller('ViewReservationDisplayCtrl', ViewReservationDisplayCtrl);

    ViewReservationDisplayCtrl.$inject = ['dataServices', '$location', '$rootScope', '$timeout', '$route'];

    function ViewReservationDisplayCtrl(dataServices, $location, $rootScope, $timeout, $route) {
        var viewRsDisplayVm = this;
        viewRsDisplayVm.isEditable = false;
        viewRsDisplayVm.details = {};

        $rootScope.$on('customerReservationsEvent', function(event, args){
            console.log("Received customer reservation data: "+ args);
            viewRsDisplayVm.details = args;
        });

        viewRsDisplayVm.edit = function () {
            viewRsDisplayVm.isEditable = true;
        }

        viewRsDisplayVm.save = function () {
            viewRsDisplayVm.isEditable = false;
        }

        viewRsDisplayVm.cancel = function () {
        	 var that = viewRsDisplayVm.details;
             $route.reload();
             $timeout(function () {
                 //Event will be caught by view reservation display Controller.
                 $rootScope.$broadcast('customerReservationsEvent', that);
             }, 100);
        }
    }
})();