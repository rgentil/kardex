app.controller('AddStockController', function($scope , $location, DataStockFactory, AddStockFactory, $route ){
	this.addStock = function(addNewStockCtrl){
		AddStockFactory.save(addNewStockCtrl);
		DataStockFactory.addStock(addNewStockCtrl);

		window.setTimeout(function() {
			$location.path('/');
        }, 10);

	};
});

app.controller('EditStockController', function($scope, $location, ListStockByIdFactory, EditStockFactory, $route, $routeParams ){
			//Retrieve selected stock
	var selectedStock = ListStockByIdFactory.query({id:$routeParams.id});
	selectedStock.$promise.then(function(result){
			//Populate scope variables
		$scope.editStockCtrl = $scope.editStockCtrl || {};
		$scope.editStockCtrl.name = result.name;
		$scope.editStockCtrl.currentPrice = result.currentPrice;
			$scope.editStockCtrl.currentAmount = result.currentAmount;
	});

	this.editStock = function(editStockCtrl){
		EditStockFactory.update({id:$routeParams.id},editStockCtrl);

		window.setTimeout(function() {
			$location.path('/');
        }, 10);

	};
});

app.controller('ListStockController', function($scope, $location,  DataStockFactory, ListStockFactory, $route){
	var stock = ListStockFactory.query();
	stock.$promise.then(function (result) {
		DataStockFactory.init(result);
	    $scope.stocks = DataStockFactory.getStocks();
	});
});

app.controller('DeleteItemController', function($scope, $location, DeleteItemFactory) {

    $scope.deleteItem = function(stockid) {
        DeleteItemFactory.delete_item({id:stockid},null);

		window.setTimeout(function() {
			location.reload(true);
        }, 10);

     };
});
app.controller('StockActionsController', function($scope, $location, ListStockByIdFactory, DeleteStockFactory) {

    // <<-- EditStock has its separate controller: EditStockController.
//console.log("here--->"+stockid);

    $scope.deleteStock = function(stockid) {
        DeleteStockFactory.delete_stock({id:stockid},null);

		window.setTimeout(function() {
			location.reload(true);
        }, 10);

     };
});

app.controller('AddItemController', function($scope, $location, AddItemFactory) {
    $scope.addItem = function(stockid) {
        AddItemFactory.add_item({id:stockid},null);

		window.setTimeout(function() {
			location.reload(true);
        }, 10);

     };
});
