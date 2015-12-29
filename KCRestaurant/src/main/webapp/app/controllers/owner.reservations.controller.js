/**
 * Created by shreedhar on 12/13/2015.
 */

(function () {
    'use strict';

    angular.module('restaurant')
        .controller('OwnerReservationsCtrl', OwnerReservationsCtrl);

    OwnerReservationsCtrl.$inject = ['dataServices', '$scope'];

    function OwnerReservationsCtrl(dataServices, $scope) {
        var ownerRsVm = this;
        ownerRsVm.reservations = {};
        execute();

        function execute(){
        	dataServices.getOwnerReservations()
            .then(function (data) {
                ownerRsVm.reservations = data;
            });
        }

        $scope.sort = function(key){
            $scope.sortKey = key;
            $scope.reverse = !$scope.reverse;
        }
    }

})();