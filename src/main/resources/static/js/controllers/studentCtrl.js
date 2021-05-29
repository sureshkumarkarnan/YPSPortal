'use strict';
var app = angular.module('ypsconnect.controllers');

app.controller('studentCtrl', function($scope,$rootScope, $http) {

	 $scope.students = {};
     $rootScope.editorEnabled = [];
	 $rootScope.orderBy = orderBy;
     $scope.student = {};

	function orderBy(myOrder) {
		$rootScope.ordering = myOrder;
	}
	$scope.updateStudent = function() {
		$http.get("/students").then(success, failed);

		function success(response) {
			$scope.students = response.data;
			console.log($scope.students);
		};

		function failed(response) {
			console.log(response);

		};
	};

	$scope.getStudent = function(x) {
		$http.get('/students/' + x.regId).then(success, failed);

		function success(response) {
			$scope.student = response.data;
			console.log($scope.student);
		};

		function failed(response) {
			console.log(response);

		};
	};
	
	$scope.addStudent = function() {
		console.log($scope.student);
		$http.post('/students',$scope.student).then(success, failed);

		function success(response) {
			 alert('Student saved successfully.');
			 $scope.updateStudent();
			console.log('Student saved successfully.');
		};

		function failed(response) {
			console.log(response);

		};
	}
	$scope.editStudent = function($index,student) {

		$http.put('/students/' + student.regId, student).then(success, failed);
		function success(response) {
			$rootScope.editorEnabled[$index]= false;
		};

		function failed(response) {
			console.log(response);
		};

	};

	$scope.deleteStudent = function(x) {

		$http.delete('/students/' + x.regId).then(success, failed);
		function success(success) {
			$scope.updateStudent();
		};

		function failed(response) {
			console.log(response);
		};
	};
	
	
	$scope.enableEditor = function($index){
	   
	$rootScope.editorEnabled[$index]= true;
	};

	$scope.disableEditor = function($index){
		$rootScope.editorEnabled[$index] = false;
	};
	
	$scope.resetForm = function () {
		console.log('form reset');
                $scope.student = {};
            };
	$scope.updateStudent();
});


