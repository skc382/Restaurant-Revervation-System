/**
 * Created by shreedhar on 12/13/2015.
 */

(function () {
    'use strict';

    angular.module('restaurant')
        .controller('ViewReservationCnfNumberCtrl', ViewReservationCnfNumberCtrl);

    ViewReservationCnfNumberCtrl.$inject = ['$location', 'dataServices', '$rootScope', '$timeout'];

    function ViewReservationCnfNumberCtrl($location, dataServices, $rootScope, $timeout) {
        var viewRsCnfVm = this;
        viewRsCnfVm.isCnfrmInvalid = false;
        viewRsCnfVm.showWarning = false;
        viewRsCnfVm;

        viewRsCnfVm.submit = function () {
            dataServices.getCustomerReservationDetails(viewRsCnfVm.cnfNumber)
                .then(function (data) {
                    console.log('getCustomerReservationDetails is ');
                    console.dir(data);
                    $location.path('/viewReservationDisplay/');
                    $timeout(function () {
                        //Event will be caught by view reservation display Controller.
                        $rootScope.$broadcast('customerReservationsEvent', data);
                    }, 100);
                }, function(err, status){
                    console.log(err);
                    viewRsCnfVm.isCnfrmInvalid = true;
                });

        }
    }

})();