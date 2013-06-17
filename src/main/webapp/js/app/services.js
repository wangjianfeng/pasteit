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