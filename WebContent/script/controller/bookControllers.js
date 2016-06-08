var bookModule = angular.module('bookModule',[]);
bookModule.controller('bookController',
		['$rootScope','$scope','$http',
		 function($rootScope,$scope,$http){
			
	$scope.loadList=function(){
		var url = 'book/list';
		
		$http.get(url).success(function(data){
			
			$scope.books = data;
		
		}).error(function(){
			
		});
	}
	
	$scope.loadList();

	$scope.del=function(id){
		var url = 'book/del/' + id;
		$http({url:url,method:'DELETE'}).success(function(data){
			$scope.loadList();
		}).error(function(){
			
		});
	};
	
}]);