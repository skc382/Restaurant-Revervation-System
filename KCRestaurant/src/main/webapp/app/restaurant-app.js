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