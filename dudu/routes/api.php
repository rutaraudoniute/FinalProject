<?php

use Illuminate\Http\Request;
use App\Category;
use App\Customer;
use App\Orders;
use App\Product;
use App\Stock;
use App\Supplier;

Route::get('category', 'CategoryController@index');
Route::get('category/{category}', 'CategoryController@show');
Route::get('category/{id_product}', 'CategoryController@showCategoryByProductId');
Route::post('category', 'CategoryController@store');
Route::put('category/{category}', 'CategoryController@update');
Route::delete('category/{category}', 'CategoryController@delete');

Route::get('customer', 'CustomerController@index');
Route::get('customer/{customer}', 'CustomerController@show');
Route::post('customer', 'CustomerController@store');
Route::put('customer/{customer}', 'CustomerController@update');
Route::delete('customer/{customer}', 'CustomerController@delete');

Route::get('orders', 'OrdersController@index');
Route::get('orders/{orders}', 'OrdersController@show');
Route::get('orders/{id_customer}', 'OrdersController@showOrdersByCustomerId');
Route::post('orders', 'OrdersController@store');
Route::put('orders/{orders}', 'OrdersController@update');
Route::delete('orders/{orders}', 'OrdersController@delete');

Route::get('product', 'ProductController@index');
Route::get('product/{product}', 'ProductController@show');
Route::get('product/{id_category}', 'ProductController@showProductByCategoryId');
Route::post('product', 'ProductController@store');
Route::put('product/{product}', 'ProductController@update');
Route::delete('product/{product}', 'ProductController@delete');

Route::get('stock', 'StockController@index');
Route::get('stock/{stock}', 'StockController@show');
Route::post('stock', 'StockController@store');
Route::put('stock/{stock}', 'StockController@update');
Route::delete('stock/{stock}', 'StockController@delete');

Route::get('supplier', 'SupplierController@index');
Route::get('supplier/{supplier}', 'SupplierController@show');
Route::post('supplier', 'SupplierController@store');
Route::put('supplier/{supplier}', 'SupplierController@update');
Route::delete('supplier/{supplier}', 'SupplierController@delete');
/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::middleware('auth:api')->get('/user', function (Request $request) {
    return $request->user();
});
?>
