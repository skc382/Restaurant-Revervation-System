/**
 * Created by shreedhar on 12/13/2015.
 */
(function () {

    angular.module('restaurant')
        .controller('RestaurantProfileCtrl', RestaurantProfileCtrl);

    RestaurantProfileCtrl.$inject = ['$rootScope', 'dataServices', '$route', '$templateCache'];

    function RestaurantProfileCtrl($rootScope, dataServices, $route, $templateCache) {
        var resProfileVm = this;
        resProfileVm.isEditable = false;
        resProfileVm.restaurantProfile = {
                restaurantdetails:{
                    name:{}, description:{},phone:{}
                },
                timings:{
                    monday:{start:{}, end:{}},
                    tuesday:{start:{}, end:{}},
                    wednesday:{start:{}, end:{}},
                    thursday:{start:{}, end:{}},
                    friday:{start:{}, end:{}},
                    saturday:{start:{}, end:{}}
                }
            };
        
        execute();

        function execute() {
            dataServices.getRestaurantProfile()
                .then(function (data) {
                    resProfileVm.setRestaurantProfile(data);
                });
        }

        resProfileVm.setRestaurantProfile = function (data) {
            resProfileVm.restaurantProfile.restaurantdetails.name = data[0].restaurant.name;
            resProfileVm.restaurantProfile.restaurantdetails.description = data[0].restaurant.description;
            resProfileVm.restaurantProfile.restaurantdetails.phone = data[0].restaurant.phoneNumber;

            resProfileVm.restaurantProfile.timings.monday.start = data[0].startTime;
            resProfileVm.restaurantProfile.timings.monday.end = data[0].endTime;

            resProfileVm.restaurantProfile.timings.tuesday.start = data[1].startTime;
            resProfileVm.restaurantProfile.timings.tuesday.end = data[1].endTime;

            resProfileVm.restaurantProfile.timings.wednesday.start = data[2].startTime;
            resProfileVm.restaurantProfile.timings.wednesday.end = data[2].endTime;

            resProfileVm.restaurantProfile.timings.thursday.start = data[3].startTime;
            resProfileVm.restaurantProfile.timings.thursday.end = data[3].endTime;

            resProfileVm.restaurantProfile.timings.friday.start = data[4].startTime;
            resProfileVm.restaurantProfile.timings.friday.end = data[4].endTime;

            resProfileVm.restaurantProfile.timings.saturday.start = data[5].startTime;
            resProfileVm.restaurantProfile.timings.saturday.end = data[5].endTime;

        }

        resProfileVm.submit = function () {
        	resProfileVm.isEditable = false;
        }
        
        resProfileVm.cancel = function () {
            resProfileVm.isEditable = false;
            $route.reload();
        }
        
        resProfileVm.edit = function () {
            resProfileVm.isEditable = true;
        }
        
    }

})();


//$rootScope.$on('sendingRestaurantProfile', function (event, args) {
//    console.log('received event ' + args);
//    resProfileVm.setRestaurantProfile(args);
//});

//resProfileVm.restaurantProfile = {};
//
//resProfileVm.setRestaurantProfile = function (resProfile) {
//    resProfileVm.restaurantProfile = resProfile;
//    resProfileVm.restaurantProfile.restaurantdetails.timings.monday = new Date(1970, 0, 1, resProfileVm.restaurantProfile.restaurantdetails.timings.monday.start1, resProfileVm.restaurantProfile.restaurantdetails.timings.monday.start2, 0);
//    resProfileVm.restaurantProfile.restaurantdetails.timings.tuesday = new Date(1970, 0, 1, resProfileVm.restaurantProfile.restaurantdetails.timings.tuesday.start1, resProfileVm.restaurantProfile.restaurantdetails.timings.tuesday.start2, 0);
//    resProfileVm.restaurantProfile.restaurantdetails.timings.wednesday = new Date(1970, 0, 1, resProfileVm.restaurantProfile.restaurantdetails.timings.wednesday.start1, resProfileVm.restaurantProfile.restaurantdetails.timings.wednesday.start2, 0);
//    resProfileVm.restaurantProfile.restaurantdetails.timings.thursday = new Date(1970, 0, 1, resProfileVm.restaurantProfile.restaurantdetails.timings.thursday.start1, resProfileVm.restaurantProfile.restaurantdetails.timings.thursday.start2, 0);
//    resProfileVm.restaurantProfile.restaurantdetails.timings.friday = new Date(1970, 0, 1, resProfileVm.restaurantProfile.restaurantdetails.timings.friday.start1, resProfileVm.restaurantProfile.restaurantdetails.timings.friday.start2, 0);
//    resProfileVm.restaurantProfile.restaurantdetails.timings.saturday = new Date(1970, 0, 1, resProfileVm.restaurantProfile.restaurantdetails.timings.saturday.start1, resProfileVm.restaurantProfile.restaurantdetails.timings.saturday.start2, 0);
//    console.dir(resProfileVm.restaurantProfile.restaurantdetails.timings.saturday);
//}