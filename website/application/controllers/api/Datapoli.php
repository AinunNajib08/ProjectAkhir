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
        $id = $this->get('id_poli');
        if ($id == '') {
            $poli = $this->db->get('poli')->result();
        } else {
            $this->db->where('id_poli', $id);
            $poli = $this->db->get('poli')->result();
        }
        $this->response($poli, 200);
    }
}
