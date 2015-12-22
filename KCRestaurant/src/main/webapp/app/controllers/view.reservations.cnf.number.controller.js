/**
 * Created by shreedhar on 12/13/2015.
 */

(function () {
    'use strict';

    angular.module('restaurant')
        .controller('ViewReservationCnfNumberCtrl', ViewReservationCnfNumberCtrl);

    ViewReservationCnfNumberCtrl.$inject = ['$location'];

    function ViewReservationCnfNumberCtrl($location) {
        var viewRsCnfVm = this;
        viewRsCnfVm.showWarning = false;
        viewRsCnfVm;

        viewRsCnfVm.submit = function () {
            if(!viewRsCnfVm.cnfNumber){
                viewRsCnfVm.showWarning = true;
            }
            else{
                console.log("Redirecting to view display ");
                $location.path('/viewReservationDisplay/'+viewRsCnfVm.cnfNumber);
            }
        }
    }

})();