var bookselfModule = angular.module('bookselfModule',[]);
bookselfModule.controller('bookselfController',
		['$rootScope','$scope','$http',
		 function($rootScope,$scope,$http){
			
	$scope.loadList=function(){
		var url = 'bookself/list';
		
		$http.get(url).success(function(data){
			
			$scope.bookselfs = data;
		
		}).error(function(){
			
		});
	}
	
	$scope.loadList();
	
	$scope.add=function(){
		var url = 'bookself/add';
		$http.post(url,$scope.nobj).success(function(data){
			$scope.loadList();
		}).error(function(){
			
		});
	};

	$scope.del=function(id){
		var url = 'bookself/del/' + id;
		$http({url:url,method:'DELETE'}).success(function(data){
			$scope.loadList();
		}).error(function(){
			
		});
	};
	
	$scope.preBookAdd=function(bs){
		$scope.selectedBookself = bs;
	};
	
	$scope.addBook=function(){
		var url = 'book/addToSelf?sid=' +$scope.selectedBookself.id;
		$http.post(url,$scope.bobj).success(function(data){
			if( data.status == 'success' ){
				window.alert('增加成功');
			}
		}).error(function(){
			window.alert('增加失败');
		})
	}
}]);