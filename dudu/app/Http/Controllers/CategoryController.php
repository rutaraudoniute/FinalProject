<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Category;

class CategoryController extends Controller
{
  public function index(){
  try {
    $categories = Category::all();
     return response()->json($categories, 200);
   } catch (Exception $e) {
     return response()->json("Could not access categories list.", 500);
   } }

   public function show($id){
   try {
     $category = Category::find($id);
     return response()->json($category, 200);
   } catch (ModelNotFoundException $e) {
     return response()->json("ID parameter with errors.", 422);
   } catch (Exception $e) {
     return response()->json("Unable to show data for the desired category.", 500);
   } }

   public function store(Request $request){
   try {
     $category = Category::create($request->all());
     return response()->json($category, 201);
   } catch (ModelNotFoundException $e) {
     return response()->json("Parameters with errors.", 422);
   } catch (Exception $e) {
     return response()->json("Unable to get data for the desired category.", 500);
   } }

   public function update(Request $request, $id) {
   try {
     $category = Category::findOrFail($id);
     $category = $category->update($request->all());
     return response()->json($category, 200);
   } catch (ModelNotFoundException $e) {
     return response()->json("Parameters with errors.", 422);
   } catch (Exception $e) {
     return response()->json("Unable to update data for the desired category.", 500);
   } }

   public function delete(Request $request, $id) {
   try {
     $category = Category::findOrFail($id);
     $category->delete();
     return response()->json("Category deleted successfully.", 201);
   } catch (ModelNotFoundException $e) {
     return response()->json("Parameters with errors.", 422);
   } catch (Exception $e) {
     return response()->json("Unable to delete data for the desired category.", 500);
   } }

   public function showCategoryByProductId($id_product){
   try {
     $category = Category::find($id_product);
     return response()->json($category, 200);
   } catch (ModelNotFoundException $e) {
     return response()->json("Product id parameter with errors.", 422);
   } catch (Exception $e) {
     return response()->json("Unable to get data for the desired category.", 500);
   } }
}
?>
