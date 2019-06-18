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
        $usiadata = "12";
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

    public function delete($no_rm)
    {
        return $this->db->delete($this->_table, array("id_poli" => $id_poli));
    }
}
