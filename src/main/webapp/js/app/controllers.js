'use strict';

pasteApp.controller("newPasteController" ,function ($scope, $location, Paste) {

    $scope.addPaste = function (paste) {
        Paste.create(paste)
            .success(function (savedPaste) {
                alert("Your content has been saved!");
                $scope.paste = {};
            })
            .error(function(resp, statusCode) {
                // FIXME show error Message
                alert(resp);
            });
    };

});


