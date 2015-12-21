/**
 * Created by shreedhar on 12/12/2015.
 */

(function () {
	angular.module('restaurant')
	.service('dataServices', dataServiceFn);

	dataServiceFn.$inject = ['$http', '$q'];

	function dataServiceFn($http, $q) {
		var self = this;

		self.validateOwner = validateOwner;
		self.getOwnerReservations = getOwnerReservations;
		self.getOwnerReservationDetails = getOwnerReservationDetails;
		self.getRestaurantProfile = getRestaurantProfile;

		function validateOwner(ownerid, ownerpwd) {
			var defer = $q.defer();
			$http({
				method: 'POST',
				url: 'http://localhost:8080/KCRestaurant/rest/api/loginn',
				data: {
					"emailId": ownerid,
					"password": ownerpwd,
					"userName": null,
					"phone": null,
					"userType": "o"
				}
			}).success(function (data) {
				defer.resolve(true);

			}).error(function (err) {
				defer.reject(err)
			});
			return defer.promise;
		}

		function getRestaurantProfile() {
			var defer = $q.defer();
			$http({
				method: 'GET',
				url: 'http://localhost:8080/KCRestaurant/rest/api/owner/restaurant/details'
			}
			).success(function (data) {
				defer.resolve(data);
			}
			).error(function (err) {
				defer.reject(err)
			});
			return defer.promise;
		}

		function getOwnerReservations() {
			var defer = $q.defer();
			$http({
				method: 'GET',
				url: 'http://localhost:8080/KCRestaurant/rest/api/owner/reservations'
			}
			).success(function (data) {
				defer.resolve({"arry": data});
			}
			).error(function (err) {
				defer.reject(err)
			});
			return defer.promise;
		}

		function getOwnerReservationDetails(confirmationNumber) {
			var defer = $q.defer();
			$http({
				url: 'http://localhost:8080/KCRestaurant/rest/api/owner/reservations/details',
				method: 'GET',                   
				params: {conf_number : confirmationNumber}
			}
			).success(function (data) {
				console.log('The reservation is: ');
				console.log(data);
				defer.resolve(data);
			}
			).error(function (err) {
				defer.reject(err)
			});
			return defer.promise;

		}
	}
})
();