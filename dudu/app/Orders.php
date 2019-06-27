<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Orders extends Model
{
    protected $table = 'orders';
    protected $primaryKey= 'id_orders';
    protected $fillable = array('order_date', 'date_inserted', 'date_updated');

    public $timestamps= true;
    public function product() {
      return $this->belongsToMany('App\Product');
    }
    public function customer() {
      return $this->hasMany('App\Customer');
    }//
}
?>
