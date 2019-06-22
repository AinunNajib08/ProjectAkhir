<?php

defined('BASEPATH') or exit('No direct script access allowed');

require APPPATH . '/libraries/REST_Controller.php';
use Restserver\Libraries\REST_Controller;

class Pasienantri extends REST_Controller
{

    function __construct()
    {
        // Construct the parent class
        parent::__construct();
        // $this->auth();
        $this->load->database();
    }

    public function index_post()
    {
        $tanggal = date('Y-m-d');
        $poli = $this->post('poli');
        $item = $this->db->get_where('kunjungan_pasien', array('tanggal' => $tanggal, 'poli' => $poli))->result();
        $response['message'] = "success";
        $response['data'] = $item;

        $this->response($response, 200);
    }
}
