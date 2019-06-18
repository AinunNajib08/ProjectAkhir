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
    function index_post($request, $response)
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
}
