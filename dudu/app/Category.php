<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Category extends Model
{
    protected $table = 'category';
    protected $primaryKey= 'id_category';
    protected $fillable = array('type');

    public $timestamps= true;
    public function product() {
      return $this->hasMany('App\Product');
    }
}
?>
