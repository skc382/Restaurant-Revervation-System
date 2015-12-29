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
        self.getRestaurantProfile = getRestaurantProfile;
        self.getOwnerReservations = getOwnerReservations;
        self.getOwnerReservationDetails = getOwnerReservationDetails;
        self.createNewReservation = createNewReservation;

        function validateOwner(ownerid, ownerpwd) {
            var defer = $q.defer();
            $http({
                    method: 'GET',
                    url: 'http://localhost:8080/KCRestaurant/rest/api/loginn',
                    data: {
                        "emailId": ownerid,
                        "password": ownerpwd,
                        "userName": null,
                        "phone": null,
                        "userType": "o"
                    }
                }
            ).success(function (data) {
                    defer.resolve({"arry": data});
                }
            ).error(function (err) {
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
                    defer.resolve(data);
                }
            ).error(function (err) {
                defer.reject(err)
            });
            return defer.promise;
        }

        function getOwnerReservationDetails(confirmationNumber) {
            var defer = $q.defer();

            $http({
                    method: 'GET',
                    url: 'http://localhost:8080/KCRestaurant/rest/api/owner/reservations/details',
                    params: {conf_number: confirmationNumber}
                }
            ).success(function (data) {
                    defer.resolve(data);
                }
            ).error(function (err) {
            	
                defer.reject(err)
            });
            return defer.promise;

        }

        function createNewReservation(reservationString)
        {
            var defer = $q.defer();

            $http({
                    method: 'Post',
                    url: 'http://localhost:8080/KCRestaurant/rest/api/owner/reservations/create',
                   data: reservationString
                }
            ).success(function (data) {
                    defer.resolve(data);
                }
            ).error(function (err, status) {
            	console.log("This is error");
            	console.log(err);
                console.log(status);
                defer.reject("time-un-available");
            });
            return defer.promise;
        }



    }
})();