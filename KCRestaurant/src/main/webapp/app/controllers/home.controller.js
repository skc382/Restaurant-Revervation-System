/**
 * Created by shreedhar on 12/13/2015.
 */

(function(){
    'use strict';

    angular.module('restaurant')
        .controller('HomePageCtrl', HomePageCtrl);

    HomePageCtrl.$inject = ['$rootScope', '$scope'];

    function HomePageCtrl($rootScope, $scope){
        var homeVm = this;
        homeVm.invalidLogin = false;
        homeVm.hasLoggedIn = false;

        $rootScope.$on('loggedin', function(event, args){
            console.log("logged in as: "+ args);
            homeVm.hasLoggedIn = args;
        });

        $rootScope.$on('invalidLogin', function(event, args){
            console.log("invalidLogin is: "+ args);
            homeVm.invalidLogin = args;
        });

        $scope.status = {
            isopen: false
        };

        $scope.toggled = function(open) {
            console.log('Dropdown is now: ', open);
        };

        $scope.toggleDropdown = function($event) {
            $event.preventDefault();
            $event.stopPropagation();
            $scope.status.isopen = !$scope.status.isopen;
        };
    }

})();