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

            ['field' => 'jenis_kunjungan',
            'label' => 'jenis_kunjungan',
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
    
    public function getById($id)
    {
        return $this->db->get_where($this->_table, ["product_id" => $id])->row();
    }

    public function save()
    {
        $post = $this->input->post();
        $this->product_id = uniqid();
        $this->name = $post["name"];
        $this->price = $post["price"];
        $this->description = $post["description"];
        $this->db->insert($this->_table, $this);
    }

    public function update()
    {
        $post = $this->input->post();
        $this->product_id = $post["id"];
        $this->name = $post["name"];
        $this->price = $post["price"];
        $this->description = $post["description"];
        $this->db->update($this->_table, $this, array('product_id' => $post['id']));
    }

    public function delete($id)
    {
        return $this->db->delete($this->_table, array("product_id" => $id));
    }
}