'use strict';

pasteApp.controller("newPasteController" ,function ($scope, $location, Paste) {

    $scope.addPaste = function (paste) {
        Paste.create(paste)
            .success(function (savedPaste) {
                $scope.paste = {};
            })
            .error(function(resp, statusCode) {
                // FIXME show error Message
                alert(resp);
            });
    };

});


