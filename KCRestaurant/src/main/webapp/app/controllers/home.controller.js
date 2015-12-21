/**
 * Created by shreedhar on 12/13/2015.
 */

(function(){
    'use strict';

    angular.module('restaurant')
        .controller('HomePageCtrl', HomePageCtrl);

    HomePageCtrl.$inject = ['$rootScope'];

    function HomePageCtrl($rootScope){
        var homeVm = this;
        homeVm.invalidLogin = false;
        homeVm.hasLoggedIn = false;

        homeVm.toggleHasLoggedIn = function(){
        	homeVm.hasLoggedIn = !homeVm.hasLoggedIn; 
        };
        
        $rootScope.$on('loggedin', function(event, args){
            console.log("logged in is: "+ args);
            homeVm.hasLoggedIn = args;
        });

        $rootScope.$on('invalidLogin', function(event, args){
            console.log("invalidLogin is: "+ args);
            homeVm.invalidLogin = args;
        });
    }

})();