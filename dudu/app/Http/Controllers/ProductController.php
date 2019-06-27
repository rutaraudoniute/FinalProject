<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Product;

class ProductController extends Controller
{
  public function index(){
  try {
    $products = Product::all();
     return response()->json($products, 200);
   } catch (Exception $e) {
     return response()->json("Could not access products list.", 500);
   } }

   public function show($id){
   try {
     $product = Product::find($id);
     return response()->json($product, 200);
   } catch (ModelNotFoundException $e) {
     return response()->json("ID parameter with errors.", 422);
   } catch (Exception $e) {
     return response()->json("Unable to show data for the desired product.", 500);
   } }

   public function store(Request $request){
   try {
     $product = Product::create($request->all());
     return response()->json($product, 201);
   } catch (ModelNotFoundException $e) {
     return response()->json("Parameters with errors.", 422);
   } catch (Exception $e) {
     return response()->json("Unable to show data for the desired product.", 500);
   } }

// ?
   public function update(Request $request, $id) {
   try {
     $product = Product::findOrFail($id);
     $product = $product->update($request->all());
     return response()->json($product, 200);
   } catch (ModelNotFoundException $e) {
     return response()->json("Parameters with errors.", 422);
   } catch (Exception $e) {
     return response()->json("Unable to show data for the desired product.", 500);
   } }

   public function delete(Request $request, $id) {
   try {
     $product = Product::findOrFail($id);
     $product->delete();
     return response()->json("Product deleted successfully.", 201);
   } catch (ModelNotFoundException $e) {
     return response()->json("Parameters with errors.", 422);
   } catch (Exception $e) {
     return response()->json("Unable to show data for the desired product.", 500);
   } }

   public function showProductByCategoryId($id_category){
   try {
     $product = Product::find($id_category);
     return response()->json($product, 200);
   } catch (ModelNotFoundException $e) {
     return response()->json("Category id parameter with errors.", 422);
   } catch (Exception $e) {
     return response()->json("Unable to get data for the desired product.", 500);
   } }
}
?>
