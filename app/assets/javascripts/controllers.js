angular.module('myApp', [])
.controller('MyController', ['$scope','$http','$location', function($scope, $http, $location) {
  $scope.update = function(loginId) {
    $scope.loginId = loginId;
    $http.post($location.protocol() + '://' + $location.host() + ':' + $location.port() + '/account/',{loginId:loginId}).
      success(function(data, status, headers, config) {
        $scope.status = status;
      }).
      error(function(data, status, headers, config) {
        $scope.status = status;
      });
  };
}]);