/**
 * Created by CiJiao_Hu on 2015/7/9.
 */
var app = angular.module('app', ['ui.router', 'bookselfModule','bookModule']);
app.config([ '$stateProvider', '$urlRouterProvider', '$httpProvider',
     		function($stateProvider, $urlRouterProvider, $httpProvider) {
	
	$urlRouterProvider.otherwise('index');

    $stateProvider.state('index', {
        url : "/index",
        templateUrl : "partial/index.html"
    }).state('bookself',{
    	url : "/bookself",
    	templateUrl : 'partial/bookself/bookself.html'
    }).state('book',{
    	url : "/book",
    	templateUrl : 'partial/book/book.html'
    });
    
    // cors跨域
	$httpProvider.defaults.useXDomain = true;
	delete $httpProvider.defaults.headers.common['X-Requested-With'];
} ]);
