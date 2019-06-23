<?php

use Illuminate\Database\Eloquent\Model;

class M_kunjungan extends Model
{
    protected $table = 'kunjungan_pasien';
    public $timestamps = false;
    protected $fillable = [
        'id_kunjungan',
        'no_urutkunjungan',
        'tanggal',
        'no_antrian',
        'keluhan',
        'jenis_kunjungan',
        'poli',
        'kode_tujuan',
        'estimasi',
        'no_rm',
        'selesai'

    ];
}
