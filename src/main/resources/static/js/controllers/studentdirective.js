var app = angular.module("ypsconnect.controllers");

app.directive("studentSearch", studentSearch);
	app.directive("studentDisplay", studentDisplay);
	app.directive("studentAdd", addStudent);


function studentSearch(){
	return {
		templateUrl: "student-search.html"
	};
}

function studentDisplay(){
	return {
		templateUrl: "student-display.html"
	};
}

function addStudent(){
	return {
		templateUrl: "student-add.html"
	};
	}