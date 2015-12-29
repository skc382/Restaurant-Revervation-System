/**
 * Created by shreedhar on 12/13/2015.
 */

(function () {
	'use strict';

	angular.module('restaurant')
	.controller('OwnerReservationDetailsCtrl', OwnerReservationDetailsCtrl);

	OwnerReservationDetailsCtrl.$inject = ['dataServices', '$routeParams', '$location'];

	function OwnerReservationDetailsCtrl(dataServices, $routeParams, $location) {
		var ownerRsDtVm = this;
		ownerRsDtVm.details = {};
		ownerRsDtVm.back = function(){
			$location.path('/ownerReservations');
		}

		execute();
		function execute(){
			console.log('Confirmation number is: ');
			console.log($routeParams.confirmationId);
			dataServices.getOwnerReservationDetails($routeParams.confirmationId)
			.then(function(data){
				ownerRsDtVm.details = data;
				console.log('These is the Reservations: ');
				console.dir(ownerRsDtVm.details);
			});
		}
	}

})();