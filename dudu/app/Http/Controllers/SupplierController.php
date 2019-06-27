<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Supplier;

class SupplierController extends Controller
{
  public function index(){
  try {
    $suppliers = Supplier::all();
     return response()->json($suppliers, 200);
   } catch (Exception $e) {
     return response()->json("Could not access suppliers list.", 500);
   } }

   public function show($id){
   try {
     $supplier = Supplier::find($id);
     return response()->json($supplier, 200);
   } catch (ModelNotFoundException $e) {
     return response()->json("ID parameter with errors.", 422);
   } catch (Exception $e) {
     return response()->json("Unable to show data for the desired supplier.", 500);
   } }

   public function store(Request $request){
   try {
     $supplier = Supplier::create($request->all());
     return response()->json($supplier, 201);
   } catch (ModelNotFoundException $e) {
     return response()->json("Parameters with errors.", 422);
   } catch (Exception $e) {
     return response()->json("Unable to show data for the desired supplier.", 500);
   } }

   public function update(Request $request, $id) {
   try {
     $supplier = Supplier::findOrFail($id);
     $supplier = $supplier->update($request->all());
     return response()->json($supplier, 200);
   } catch (ModelNotFoundException $e) {
     return response()->json("Parameters with errors.", 422);
   } catch (Exception $e) {
     return response()->json("Unable to show data for the desired supplier.", 500);
   } }

   public function delete(Request $request, $id) {
   try {
     $supplier = Supplier::findOrFail($id);
     $supplier->delete();
     return response()->json("Supplier deleted successfully.", 201);
   } catch (ModelNotFoundException $e) {
     return response()->json("Parameters with errors.", 422);
   } catch (Exception $e) {
     return response()->json("Unable to show data for the desired supplier.", 500);
   } }
}
?>
