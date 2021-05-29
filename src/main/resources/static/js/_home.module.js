'use strict';
var app = angular.module("ypsconnect", ["ngRoute", "ui.bootstrap","ypsconnect.controllers"]);
app.config(function($routeProvider) {
$routeProvider
 
.when('/', {
templateUrl : 'admin.html',
controller : 'adminCtrl'
})
 
.when('/Students', {
templateUrl : 'student-view.html',
controller : 'studentCtrl'
})
 
.when('/Admission', {
templateUrl : 'admission.html',
controller : 'admissionCtrl'
})
 
.otherwise({redirectTo: '/'});
});
