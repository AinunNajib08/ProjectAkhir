<?php defined('BASEPATH') OR exit('No direct script access allowed');

class Mkunjungan_pasien extends CI_Model
{
    private $_table = "kunjungan_pasien";

    public $id_kunjungan;
    public $no_urutkunjungan;
    public $tanggal;
    public $no_antrian;
    public $keluhan;
    public $jenis_kunjungan;
    public $kode_tujuan;
    public $no_rm;

    public function rules()
    {
        return [
            ['field' => 'id_kunjungan',
            'label' => 'id_kunjungan',
            'rules' => 'required'],

            ['field' => 'no_urutkunjungan',
            'label' => 'no_urutkunjungan',
            'rules' => 'required'],
            
            ['field' => 'tanggal',
            'label' => 'tanggal',
            'rules' => 'required'],

            ['field' => 'no_antrian',
            'label' => 'no_antrian',
            'rules' => 'required'],

            ['field' => 'keluhan',
            'label' => 'keluhan',
            'rules' => 'required'],

            ['field' => 'jenis_kunjungan',
            'label' => 'jenis_kunjungan',
            'rules' => 'required'],

            ['field' => 'kede_tujuan',
            'label' => 'kode_tujuan',
            'rules' => 'required'],
            
            ['field' => 'no_rm',
            'label' => 'no_rm',
            'rules' => 'required']
        ];
    }

    public function getAll()
    {
        return $this->db->get($this->_table)->result();
    }
    
    public function getById($id_kunjungan)
    {
        return $this->db->get_where($this->_table, ["id_kunjungan" => $id_kunjungan])->row();
    }

    public function save()
    {
        $post = $this->input->post();
        $this->id_kunjungan = $post["id_kunjungan"];
        $this->no_urutkunjungan = $post["no_urutkunjungan"];
        $this->tanggal = $post["tanggal"];
        $this->no_antrian = $post["no_antrian"];
        $this->keluhan = $post["keluhan"];
        $this->jenis_kunjungan = $post["jenis_kunjungan"];
        $this->kode_tujuan = $post["kode_tujuan"];
        $this->no_rm = $post["no_rm"];

        $this->db->insert($this->_table, $this);
    }

    public function update()
    {
        $post = $this->input->post();
        $this->id_kunjungan = $post["id_kunjungan"];
        $this->no_urutkunjungan = $post["no_urutkunjungan"];
        $this->tanggal = $post["tanggal"];
        $this->no_antrian = $post["no_antrian"];
        $this->keluhan = $post["keluhan"];
        $this->jenis_kunjungan = $post["jenis_kunjungan"];
        $this->kode_tujuan = $post["kode_tujuan"];
        $this->no_rm = $post["no_rm"];

        $this->db->update($this->_table, $this, array('id_kunjungan' => $post['id_kunjungan']));
    }

    public function delete($id_kunjungan)
    {
        return $this->db->delete($this->_table, array("id_kunjungan" => $id_kunjungan));
    }
}