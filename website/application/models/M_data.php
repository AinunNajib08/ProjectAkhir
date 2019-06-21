<?php defined('BASEPATH') or exit('No direct script access allowed');

class M_data extends CI_Model
{
    public function hitungJumlahInventori()
    {
        $this->db->select_sum('stok');
        $query = $this->db->get('tb_habispakai');
        if ($query->num_rows() > 0) {
            return $query->row()->stok;
        } else {
            return 0;
        }
    }
}
