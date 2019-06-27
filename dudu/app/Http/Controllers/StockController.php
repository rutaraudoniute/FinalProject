<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Stock;

class StockController extends Controller
{
  public function index(){
  try {
    $stocks = Stock::all();
     return response()->json($stocks, 200);
   } catch (Exception $e) {
     return response()->json("Could not access stocks list.", 500);
   } }

   public function show($id){
   try {
     $stock = Stock::find($id);
     return response()->json($stock, 200);
   } catch (ModelNotFoundException $e) {
     return response()->json("ID parameter with errors.", 422);
   } catch (Exception $e) {
     return response()->json("Unable to show data for the desired stock.", 500);
   } }

   public function store(Request $request){
   try {
     $stock = Stock::create($request->all());
     return response()->json($stock, 201);
   } catch (ModelNotFoundException $e) {
     return response()->json("Parameters with errors.", 422);
   } catch (Exception $e) {
     return response()->json("Unable to show data for the desired stock.", 500);
   } }

   public function update(Request $request, $id) {
   try {
     $stock = Stock::findOrFail($id);
     $stock = $stock->update($request->all());
     return response()->json($stock, 200);
   } catch (ModelNotFoundException $e) {
     return response()->json("Parameters with errors.", 422);
   } catch (Exception $e) {
     return response()->json("Unable to show data for the desired stock.", 500);
   } }

   public function delete(Request $request, $id) {
   try {
     $stock = Stock::findOrFail($id);
     $stock->delete();
     return response()->json("Stock deleted successfully.", 201);
   } catch (ModelNotFoundException $e) {
     return response()->json("Parameters with errors.", 422);
   } catch (Exception $e) {
     return response()->json("Unable to show data for the desired stock.", 500);
   } }
}
?>
