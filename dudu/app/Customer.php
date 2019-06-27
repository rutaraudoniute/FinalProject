<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Customer extends Model
{
    protected $table = 'customer';
    protected $primaryKey= 'id_customer';
    protected $fillable = array('first_name', 'last_name', 'street', 'codepost', 'city', 'number', 'email', 'gender');
    public $timestamps= true;

    public function product() {
      return $this->belongsToMany('App\Product');
    }
    public function orders(){
      return $this->hasMany('App\Orders');
    }
}
?>
