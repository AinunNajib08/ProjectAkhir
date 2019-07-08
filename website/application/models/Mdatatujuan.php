<?php defined('BASEPATH') or exit('No direct script access allowed');

class Mdatatujuan extends CI_Model
{
    private $_table = "tujuan_pelayanan";
    public $kode_tujuan;
    public $tujuan_pelayanan;

    public function rules()
    {

        return [
            [
                'field' => 'kode_tujuan',
                'label' => 'kode_tujuan',
                'rules' => 'required'
            ],

            [
                'field' => 'tujuan_pelayanan',
                'label' => 'tujuan_pelayanan',
                'rules' => 'required'
            ],

            [
                'field' => 'id_poli',
                'label' => 'id_poli',
                'rules' => 'required'
            ]
        ];
    }

    public function getAll()
    {
        return $this->db->get($this->_table)->result();
    }

    public function getById($kode_tujuan)
    {
        return $this->db->get_where($this->_table, ["kode_tujuan" => $kode_tujuan])->row();
    }



    public function save()
    {
        $post = $this->input->post();
        $this->kode_tujuan = $post["kode_tujuan"];
        $this->tujuan_pelayanan = $post["tujuan_pelayanan"];
        $this->id_poli = $post["poli"];

        $this->db->insert($this->_table, $this);
    }

    public function update()
    {
        $post = $this->input->post();
        $this->kode_tujuan = $post["kode_tujuan"];
        $this->tujuan_pelayanan = $post["tujuan_pelayanan"];
        $this->id_poli = $post["id_poli"];

        $this->db->update($this->_table, $this, array('kode_tujuan' => $post['kode_tujuan']));
    }

    public function delete($kode_tujuan)
    {
        return $this->db->delete($this->_table, array("kode_tujuan" => $kode_tujuan));
    }

    public function get_count()
    {
        $sql = "SELECT count(no_rm) as count FROM pasien";
        $result = $this->db->query($sql);
        return $result->row()->count;

    }

    public function get_count1()
    {
        $sql1 = "SELECT count(id_kunjungan) as count FROM kunjungan_pasien";
        $resultt = $this->db->query($sql1);
        return $resultt->row()->count;
    }

    public function get_count2()
    {
        $sql2 = "SELECT count(id_poli) as count FROM poli";
        $results = $this->db->query($sql2);
        return $results->row()->count;
    }

    public function get_count3()
    {
        $sql3 = "SELECT count(kode_tujuan) as count FROM tujuan_pelayanan";
        $resulth = $this->db->query($sql3);
        return $resulth->row()->count;
    }
}
