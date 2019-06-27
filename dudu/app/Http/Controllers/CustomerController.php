<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Customer;

class CustomerController extends Controller
{
  public function index(){
  try {
     $customers = Customer::all();
     return response()->json($customers, 200);
   } catch (Exception $e) {
     return response()->json("Could not access customers list.", 500);
   } }

   public function show($id){
   try {
     $customer = Customer::find($id);
     return response()->json($customer, 200);
   } catch (ModelNotFoundException $e) {
     return response()->json("ID parameter with errors.", 422);
   } catch (Exception $e) {
     return response()->json("Unable to show data for the desired customer.", 500);
   } }

   public function store(Request $request){
   try {
     $customer = Customer::create($request->all());
     return response()->json($customer, 201);
   } catch (ModelNotFoundException $e) {
     return response()->json("Parameters with errors.", 422);
   } catch (Exception $e) {
     return response()->json("Unable to show data for the desired customer.", 500);
   } }

   public function update(Request $request, $id) {
   try {
     $customer = Customer::findOrFail($id);
     $customer = $customer->update($request->all());
     return response()->json($customer, 200);
   } catch (ModelNotFoundException $e) {
     return response()->json("Parameters with errors.", 422);
   } catch (Exception $e) {
     return response()->json("Unable to show data for the desired customer.", 500);
   } }

   public function delete(Request $request, $id) {
   try {
     $customer = Customer::findOrFail($id);
     $customer->delete();
     return response()->json("Customer deleted successfully.", 201);
   } catch (ModelNotFoundException $e) {
     return response()->json("Parameters with errors.", 422);
   } catch (Exception $e) {
     return response()->json("Unable to show data for the desired customer.", 500);
   } }
}
?>
