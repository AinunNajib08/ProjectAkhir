<?php defined('BASEPATH') or exit('No direct script access allowed');

class Mdatapasien extends CI_Model
{
    private $_table = "pasien";
    public $no_rm;
    public $no_asuransilain;
    public $nama_pasien;
    public $usia;
    public $tanggal_lahir;
    public $jenis_kelamin;
    public $agama;
    public $alamat;
    public $kota;
    public $provinsi;
    public $telepon;
    public $pekerjaan;
    public $tanggal_daftar;
    public $foto;
    public $email;
    public $orang_tua;
    public $status_kawin;
    public $status_tinggal;
    public function rules()
    {
        return [
            [
                'field' => 'no_rm',
                'label' => 'Name',
                'rules' => 'required'
            ],

            [
                'field' => 'no_al',
                'label' => 'no_al',
                'rules' => 'required'
            ]
        ];
    }

    public function getAll()
    {
        return $this->db->get($this->_table)->result();
    }

    public function getById($no_rm)
    {
        return $this->db->get_where($this->_table, ["no_rm" => $no_rm])->row();
    }

    public function save()
    {
        $usiadata = "12";
        $post = $this->input->post();
        // $usiapasien = date("Y-m-d") - $post["tgl_lahir"];
        $this->no_rm = $post["no_rm"];
        $this->no_asuransilain = $post["no_al"];
        $this->nama_pasien = $post["nama"];
        $this->usia = $usiadata;
        $this->tanggal_lahir = $post["tgl_lahir"];
        $this->jenis_kelamin = $post["jenis_kelamin"];
        $this->agama = $post["agama"];
        $this->alamat = $post["alamat"];
        $this->kota = $post["kota"];
        $this->provinsi = $post["provinsi"];
        $this->telepon = $post["telepon"];
        $this->pekerjaan = $post["pekerjaan"];
        $this->tanggal_daftar = date("Y-m-d");
        $this->foto = $post["foto"];
        $this->email = $post["email"];
        $this->orang_tua = $post["org_tua"];
        $this->status_kawin = $post["status_kawin"];
        $this->status_tinggal = $post["status_tinggal"];

        $this->db->insert($this->_table, $this);
    }

    public function update()
    {
        $post = $this->input->post();
        $this->no_rm = $post["no_rm"];
        $this->no_asuransilain = $post["no_al"];
        $this->nama_pasien = $post["nama"];
        $this->usia = $post["usia"];
        $this->tanggal_lahir = $post["tgl_lahir"];
        $this->jenis_kelamin = $post["jenis_kelamin"];
        $this->agama = $post["agama"];
        $this->alamat = $post["alamat"];
        $this->kota = $post["kota"];
        $this->provinsi = $post["provinsi"];
        $this->telepon = $post["telepon"];
        $this->pekerjaan = $post["pekerjaan"];
        $this->tanggal_daftar = date("Y-m-d");
        $this->foto = $post["foto"];
        $this->email = $post["email"];
        $this->orang_tua = $post["org_tua"];
        $this->status_kawin = $post["status_kawin"];
        $this->status_tinggal = $post["status_tinggal"];

        $this->db->update($this->_table, $this, array('no_rm' => $post['no_rm']));
    }

    public function delete($no_rm)
    {
        return $this->db->delete($this->_table, array("no_rm" => $no_rm));
    }
}
