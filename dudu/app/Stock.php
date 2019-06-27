<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Stock extends Model
{
    protected $table = 'stock';
    protected $primaryKey= 'id_stock';
    protected $fillable = array('quantity', 'date_received', 'date_updated');

    public $timestamps= true;
    public function product() {
      return $this->belongsToMany('App\Product');
    }

}
?>
