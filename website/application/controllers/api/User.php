<?php

defined('BASEPATH') or exit('No direct script access allowed');

require APPPATH . '/libraries/REST_Controller.php';
use Restserver\Libraries\REST_Controller;

class User extends REST_Controller
{

    function __construct($config = 'rest')
    {
        parent::__construct($config);
        $this->load->database();
    }

    //Menampilkan data kontak
    function index_get()
    {
        $id = $this->get('id_akun');
        if ($id == '') {
            $pasien = $this->db->get('akun_user')->result();
        } else {
            $this->db->where('id', $id);
            $pasien = $this->db->get('akun_user')->result();
        }
        $this->response($pasien, 200);
    }
}
