'use strict';

pasteApp.factory("Paste", function ($http) {
    var API_URI = 'api/paste';
    return {
         fetchLast : function(id) {
            return $http.get(API_URI + '/last');
        },

        fetchOne : function(id) {
            return $http.get(API_URI + '/' + id);
        },

        create : function(paste) {
            return $http.post(API_URI, paste);
        }
    };
});

pasteApp.factory('mySharedService', function($rootScope) {
    var sharedService = {};

    sharedService.paste = '';

    sharedService.prepForBroadcast = function(paste) {
        this.paste = paste;
        this.broadcastItem();
    };

    sharedService.broadcastItem = function() {
        $rootScope.$broadcast('handleBroadcast');
    };

    return sharedService;
});

