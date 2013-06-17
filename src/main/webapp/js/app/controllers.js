'use strict';

pasteApp.controller("newPasteController" ,function ($scope, $location, Paste, mySharedService) {

    $scope.addPaste = function (paste) {
        Paste.create(paste)
            .success(function (savedPaste) {
                mySharedService.prepForBroadcast(savedPaste);
                $scope.paste = {};
                alert("Your content has been saved!");

            })
            .error(function(resp, statusCode) {
                // FIXME show error Message
                alert(resp);
            });
    };

});

pasteApp.controller("pasteController" ,function ($scope, $location, Paste, mySharedService) {

    Paste.fetchLast().success(function(resp){
        $scope.lastPasteList = resp.content;
    });

    $scope.viewPaste = function (id) {
        $location.path('/paste/'+id)
    };

    $scope.$on('handleBroadcast', function() {
        $scope.lastPasteList.unshift(mySharedService.paste);
        $scope.lastPasteList.pop(); // delete last item
    });

});


