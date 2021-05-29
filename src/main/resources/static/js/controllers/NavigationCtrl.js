'use strict';
var app = angular.module('ypsconnect.controllers');

app.controller('NavigationCtrl', function($rootScope, $scope, $http, $location, $route){ 

	$rootScope.authenticated = true;
	$scope.credentials = {};

	$scope.logout = function() {
		$rootScope.authenticated = false;
		$http.post('/logout', {}).success(function() {
				 $location.path('/login');
			$location.url('/login');
	$window.location.href = '/login';
			$rootScope.authenticated = false;
  			}).error(function(data) {
  				$rootScope.authenticated = false;
  			});
	
  		}
  		
  		 $scope.ShowAboutAlert = function () {
	
                alert("This student management project is developed by SURESH KUMAR KARNAN to Yamuna Play school" );
            }
});