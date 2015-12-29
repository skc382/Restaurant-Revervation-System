/**
 * Created by shreedhar on 12/12/2015.
 */

(function () {
    'use strict';

    angular.module('restaurant')
        .controller('LoginPageCtrl', LoginPageCtrl);

    LoginPageCtrl.$inject = ['$rootScope', 'dataServices', '$location', '$timeout'];

    function LoginPageCtrl($rootScope, dataServices, $location, $timeout) {
        var loginVm = this;

        loginVm.invalidLogin = false;
        loginVm.owner = {};

        loginVm.submit = function () {
            dataServices
                .validateOwner(loginVm.owner.name, loginVm.owner.password)
                .then(function (ret) {
                    console.log("Data received from server is: "+ ret);
                    if (ret) {
                        $location.path('/restaurantProfile');
                        $timeout(function () {
                            $rootScope.$broadcast('sendingRestaurantProfile', ret);
                            $rootScope.$broadcast('loggedin', true);
                            loginVm.invalidLogin = false;
                            console.log("sent event" + ret);
                        }, 100);
                    }else{
                        loginVm.invalidLogin = true;
                    }
                });


        }
        loginVm.cancel = function () {
            $location.path('/home');
        }
    }

})();
