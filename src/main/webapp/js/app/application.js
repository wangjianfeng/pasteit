'use strict';

var pasteApp = angular.module('pasteApp', []);

pasteApp.config(function($routeProvider) {
    $routeProvider
        .when('/paste/new', {
            templateUrl: 'views/paste-new.html',
            controller : 'newPasteController'
        })
        .when('/paste/:id', {
            templateUrl: 'views/paste-detail.html',
            controller : 'pasteDetailController'
        })
        .otherwise({
            redirectTo: '/paste/new'
        }
        );
});