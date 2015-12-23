(function () {
    'use strict';

    angular.module('restaurant')
        .controller('ViewReservationDisplayCtrl', ViewReservationDisplayCtrl);

    ViewReservationDisplayCtrl.$inject = ['dataServices', '$routeParams', '$route'];

    function ViewReservationDisplayCtrl(dataServices, $routeParams, $route) {
        var viewRsDisplayVm = this;
        viewRsDisplayVm.isEditable = false;
        viewRsDisplayVm.details = {};

        execute($routeParams.confirmationId);

        function execute(cnfId) {
            //dataServices.getOwnerReservationDetails(cnfId)
            //    .then(function (data) {
            //        viewRsDisplayVm.details = data;
            //        console.log('These is the view Reservations: ');
            //        console.dir(viewRsDisplayVm.details);
            //    });
            viewRsDisplayVm.details = {
                obj: {
                    cnfName: $routeParams.confirmationId,
                    name: "shredhar",
                    email: "email blah",
                    phoneNumber: "8622011954",
                    startTime: "23:20:00",
                    endTime: "00:00:00",
                    tableSize: "3"
                }

            };
        }

        viewRsDisplayVm.edit = function () {
            viewRsDisplayVm.isEditable = true;
        }

        viewRsDisplayVm.save = function () {
            viewRsDisplayVm.isEditable = false;
        }

        viewRsDisplayVm.cancel = function () {
        	$route.reload();
        }
    }
})();