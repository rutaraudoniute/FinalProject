<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Product extends Model
{
    protected $table = 'product';
    protected $primaryKey= 'id_product';
    protected $fillable = array('name', 'size', 'price', 'image', 'description','quantity', 'gender');
    public $timestamps= true;

// ?
    public function orders() {
      return $this->belongsToMany('App\Orders');
    }
    public function category() {
      return $this->hasMany('App\Category');
    }
}
?>
