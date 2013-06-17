'use strict';

var pasteApp = angular.module('pasteApp', []);

pasteApp.config(function($routeProvider) {
    $routeProvider
        .when('/paste/new', {
            templateUrl: 'views/paste-new.html',
            controller : 'newPasteController'
        })
        .otherwise({
            redirectTo: '/paste/new'
        }
        );
});