<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Orders;

class OrdersController extends Controller
{
  public function index(){
  try {
     $orderss = Orders::all();
     return response()->json($orderss, 200);
   } catch (Exception $e) {
     return response()->json("Could not access orders list.", 500);
   } }

   public function show($id){
   try {
     $orders = Orders::find($id);
     return response()->json($orders, 200);
   } catch (ModelNotFoundException $e) {
     return response()->json("ID parameter with errors.", 422);
   } catch (Exception $e) {
     return response()->json("Unable to show data for the desired order.", 500);
   } }

   public function store(Request $request){
   try {
     $orders = Orders::create($request->all());
     return response()->json($orders, 201);
   } catch (ModelNotFoundException $e) {
     return response()->json("Parameters with errors.", 422);
   } catch (Exception $e) {
     return response()->json("Unable to show data for the desired order.", 500);
   } }

   public function update(Request $request, $id) {
   try {
     $orders = Orders::findOrFail($id);
     $orders = $orders->update($request->all());
     return response()->json($orders, 200);
   } catch (ModelNotFoundException $e) {
     return response()->json("Parameters with errors.", 422);
   } catch (Exception $e) {
     return response()->json("Unable to show data for the desired order.", 500);
   } }

   public function delete(Request $request, $id) {
   try {
     $orders = Orders::findOrFail($id);
     $orders->delete();
     return response()->json("Order deleted successfully.", 201);
   } catch (ModelNotFoundException $e) {
     return response()->json("Parameters with errors.", 422);
   } catch (Exception $e) {
     return response()->json("Unable to show data for the desired order.", 500);
   } }

   public function showOrdersByCustomerId($id_customer){
   try {
     $orders = Orders::find($id_customer);
     return response()->json($orders, 200);
   } catch (ModelNotFoundException $e) {
     return response()->json("Customer id parameter with errors.", 422);
   } catch (Exception $e) {
     return response()->json("Unable to get data for the desired order.", 500);
   } }
}
?>
