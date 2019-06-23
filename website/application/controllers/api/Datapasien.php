<?php

defined('BASEPATH') or exit('No direct script access allowed');

require APPPATH . '/libraries/REST_Controller.php';
use Restserver\Libraries\REST_Controller;

class Datapasien extends REST_Controller
{

    function __construct($config = 'rest')
    {
        parent::__construct($config);
        $this->load->database();
    }

    //Menampilkan data kontak
    function index_get()
    {
        $id = $this->get('no_rm');
        if ($id == '') {
            $pasien = $this->db->get('pasien')->result();
        } else {
            $this->db->where('id', $id);
            $pasien = $this->db->get('pasien')->result();
        }
        $this->response($pasien, 200);
    }

    function index_post()
    {
        $password = $this->post('password');
        $passwordEncrypt = password_hash($password, PASSWORD_DEFAULT);
        $data = array(
            'username'    => $this->post('username'),
            'password' =>  $passwordEncrypt,
            'email' => $this->post('email'),
            'no_rm' => $this->post('no_rm')
        );
        $insert = $this->db->insert('akun_user', $data);
        if ($insert) {
            $this->response($data, 200);
        } else {
            $this->response(array('status' => 'fail', 502));
        }
    }
}
