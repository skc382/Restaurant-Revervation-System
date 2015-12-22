/**
 * Created by shreedhar on 12/12/2015.
 */
(function () {
    'use strict';

    angular.module('restaurant', ['ngRoute','angularUtils.directives.dirPagination'])
        .config(moduleConfig);

    moduleConfig.$inject = ['$routeProvider', '$httpProvider', '$locationProvider'];

    function moduleConfig($routeProvider, $httpProvider, $locationProvider) {
    	
    	
        $routeProvider
            .when('/home', {
                templateUrl: 'app/views/homepage.tmpl.html',
                controller: 'HomePageCtrl',
                controllerAs: 'homeVm'
            })
            .when('/login', {
                templateUrl: 'app/views/login.tmpl.html',
                controller: 'LoginPageCtrl',
                controllerAs: 'loginVm'
            })
            .when('/newReservation', {
                templateUrl: 'app/views/new.reservation.tmpl.html'
            })
            .when('/viewReservationCnfNumber', {
                templateUrl: 'app/views/view.reservations.cnf.number.tmpl.html',
                controller: 'ViewReservationCnfNumberCtrl',
                controllerAs: 'viewRsCnfVm'
            })
            .when('/viewReservationDisplay/:confirmationId', {
                templateUrl: 'app/views/view.reservations.display.tmpl.html',
                controller: 'ViewReservationDisplayCtrl',
                controllerAs: 'viewRsDisplayVm'
            })
            .when('/restaurantProfile', {
                templateUrl: 'app/views/restaurant.profile.tmpl.html',
                controller: 'RestaurantProfileCtrl',
                controllerAs: 'resProfileVm'
            })
            .when('/ownerReservations', {
                templateUrl: 'app/views/owner.reservations.tmpl.html',
                controller: 'OwnerReservationsCtrl',
                controllerAs: 'ownerRsVm'
            })
            .when('/ownerReservationsDetails/:confirmationId', {
                templateUrl: 'app/views/owner.reservations.details.tmpl.html',
                controller: 'OwnerReservationDetailsCtrl',
                controllerAs: 'ownerRsDtVm'
            })
            .otherwise({
            redirectTo: '/home'
        });
        $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';   
    }
})();