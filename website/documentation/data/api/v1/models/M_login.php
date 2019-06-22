<?php

use Illuminate\Database\Eloquent\Model;

class M_user extends Model
{
    protected $table = 'pasien';
    public $timestamps = false;
    protected $fillable = [
        'no_rm',
        'no_asuransi',
        'nama_pasien',
        'usia',
        'tanggal_lahir',
        'jenis_kelamin',
        'agama',
        'alamat',
        'kota',
        'provinsi',
        'telepon',
        'pekerjaan',
        'tanggal_daftar',
        'foto',
        'email',
        'orang_tua',
        'status_kawin',
        'status_tinggal',
        'status'
    ];
}
