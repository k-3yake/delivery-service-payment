angular.module('myApp', [])
.controller('MyController', ['$scope','$http', function($scope, $http) {
  $scope.update = function(loginId) {
    $scope.loginId = loginId;
    $http.post('http://localhost:9000/account/',{loginId:loginId}).
      success(function(data, status, headers, config) {
        $scope.status = status;
      }).
      error(function(data, status, headers, config) {
        $scope.status = status;
      });
  };
}]);