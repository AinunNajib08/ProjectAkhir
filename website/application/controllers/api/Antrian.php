<?php

defined('BASEPATH') or exit('No direct script access allowed');

require APPPATH . '/libraries/REST_Controller.php';
use Restserver\Libraries\REST_Controller;

class Antrian extends REST_Controller
{

    function __construct()
    {
        // Construct the parent class
        parent::__construct();
        // $this->auth();
        $this->load->database();
    }

    public function index_get()
    {
        $aVar = mysqli_connect('localhost', 'root', '', 'klinik');
        $tanggal = date('Y-m-d');
        $no_rm = $this->post('no_rm');
        $result = mysqli_query($aVar, "SELECT count(*) as total from kunjungan_pasien WHERE tanggal='$tanggal'");
        $hasil = mysqli_fetch_assoc($result);
        // $item = $result->result();

        // $item = $this->db->get_where('kunjungan_pasien', array('tanggal' => $tanggal, 'no_rm' => $no_rm))->result();
        $response['message'] = "success";
        $response['data'] = $hasil;

        $this->response($response, 200);
    }
}
