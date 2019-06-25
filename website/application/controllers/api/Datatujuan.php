<?php

defined('BASEPATH') or exit('No direct script access allowed');

require APPPATH . '/libraries/REST_Controller.php';
use Restserver\Libraries\REST_Controller;

class Datatujuan extends REST_Controller
{

    function __construct($config = 'rest')
    {
        parent::__construct($config);
        $this->load->database();
    }


    function index_get()
    {
        $id = $this->get('kode_tujuan');
        if ($id == '') {
            $tujuan_pelayanan = $this->db->get('tujuan_pelayanan')->result();
        } else {
            $this->db->where('kode_tujuan', $id);
            $tujuan_pelayanan = $this->db->get('tujuan_pelayanan')->result();
        }
        $this->response($tujuan_pelayanan, 200);
    }
}