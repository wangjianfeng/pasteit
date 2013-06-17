'use strict';

pasteApp.controller("pasteController" ,function ($scope, $location, Paste, mySharedService) {

    Paste.fetchLast().success(function(resp){
        $scope.lastPasteList = resp.content;
    });

    $scope.viewPaste = function (id) {
        $location.path('/paste/'+id)
    };

    $scope.$on('handleBroadcast', function() {
        $scope.lastPasteList.unshift(mySharedService.paste);   // ajoute au debut du tableau
        $scope.lastPasteList.pop(); // supprime le dernier element
    });

});

pasteApp.controller("newPasteController" ,function ($scope, $location, Paste, mySharedService) {

    $scope.addPaste = function (paste) {
        Paste.create(paste)
            .success(function (paste2) {
                mySharedService.prepForBroadcast(paste2);

                $scope.paste = {};
            })
            .error(function(resp, statusCode) {
                // TODO show error Message
                alert(resp);
            });
    };


});




pasteApp.controller("pasteDetailController" ,function ($scope, $routeParams, Paste) {

    var pasteId = $routeParams.id;

    Paste.fetchOne(pasteId).success(function(paste){
        $scope.paste = paste;
    });


});
