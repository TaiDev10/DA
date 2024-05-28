const app = angular.module("shopping-cart-app",[]);

app.controller("shopping-cart-ctrl",function($scope, $http){
	
	/*QUẢN LÝ GIỎ HÀNG*/
	$scope.cart = {
		items:[],
		
	//Thêm vào giỏ hàng
	add: function(id) {
            var idPro = id;
            var item = this.items.find(item => item.id == idPro);
            if (item) {
                item.qty++;
                this.saveToLocalStorage();
            } else {
                $http.get("/rest/products/" + idPro).then(resp => {
                    resp.data.qty = 1;
                    this.items.push(resp.data);
                    this.saveToLocalStorage();
                });
            }
        },
	// xóa sản phẩm
	remove(id){
		var index = this.items.findIndex(item => item.id == id);
		this.items.splice(index,1);
		this.saveToLocalStorage();
	},
	// Xóa sạch giỏ hàng
	clear(){
		this.items = [];
		this.saveToLocalStorage();
	},
	// Get count tính tổng số lượng các mặt hàng trong giỏi
	get count(){
		return this.items
		.map(item => item.qty)
		.reduce((total,qty)=> total += qty,0);
	},

	//Get amount
	get amount(){
		return this.items
		.map(item => item.qty * item.price)
		.reduce((total,qty)=> total += qty,0);
	},
	
	
	
	
	
	
	
	// Lưu giỏ hàng vào saveToLocalStorage
	saveToLocalStorage(){
		var json = JSON.stringify(angular.copy(this.items));
		localStorage.setItem("cart",json);
	},
	//Đọc giỏ hành từ LocalStorage
	loadFormLocalStorage(){
		var json = localStorage.getItem("cart");
		this.items = json ? JSON.parse(json):[];
	},
	}
	$scope.cart.loadFormLocalStorage();
})