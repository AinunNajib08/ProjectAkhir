<?php defined('BASEPATH') or exit('No direct script access allowed');

class Mdatapoli extends CI_Model
{
    private $_table = "poli";
    public $id_poli;
    public $poli;

    public function rules()
    {
        
        return [
            [
                'field' => 'id_poli',
                'label' => 'id_poli',
                'rules' => 'required'
            ],

            [
                'field' => 'poli',
                'label' => 'poli',
                'rules' => 'required'
            ]
        ];
    }

    public function getAll()
    {
        return $this->db->get($this->_table)->result();
    }

    public function getById($id_poli)
    {
        return $this->db->get_where($this->_table, ["id_poli" => $id_poli])->row();
    }

    public function save()
    {
        $post = $this->input->post();
        $this->id_poli = $post["id_poli"];
        $this->poli = $post["poli"];

        $this->db->insert($this->_table, $this);
    }

    public function update()
    {
        $post = $this->input->post();
        $this->id_poli = $post["id_poli"];
        $this->poli = $post["poli"];

        $this->db->update($this->_table, $this, array('id_poli' => $post['id_poli']));
    }

    public function delete($id_poli)
    {
        return $this->db->delete($this->_table, array("id_poli" => $id_poli));
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
