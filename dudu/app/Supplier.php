<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Supplier extends Model
{
    protected $table = 'supplier';
    protected $primaryKey= 'id_supplier';
    protected $fillable = array('name', 'address', 'number', 'bank_account', 'date_inserted', 'date_updated');
    public $timestamps= true;

    public function product() {
      return $this->belongsToMany('App\Product');
    }//
}
?>
