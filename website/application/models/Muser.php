<?php

use Illuminate\Database\Eloquent\Model;

class Muser extends Model
{
    protected $table = 'akun_user';
    public $timestamps = false;
    protected $fillable = [
        'id_akun',
        'username',
        'password',
        'email',
        'no_telepon',
        'status',
        'kode_verifikasi',
        'no_rm'
    ];
}
