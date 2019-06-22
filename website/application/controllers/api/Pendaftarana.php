<?php

defined('BASEPATH') or exit('No direct script access allowed');

require APPPATH . '/libraries/REST_Controller.php';
use Restserver\Libraries\REST_Controller;

class Pendaftarana extends REST_Controller
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
        $item = $this->db->get_where('kunjungan_pasien', array('poli' => '1'))->result();
        $response['message'] = "success";
        $response['data'] = $item;

        $this->response($response, 200);
    }

    public function index_post()
    {
        $tanggal = date('Y-m-d');
        $poli = $this->post('poli');
        $aVar = mysqli_connect('localhost', 'root', '', 'klinik');
        $result = mysqli_query($aVar, "SELECT count(*) as total from kunjungan_pasien WHERE tanggal='$tanggal'");
        $hasil = mysqli_fetch_assoc($result);

        $antri = mysqli_query($aVar, "SELECT count(*) as total from kunjungan_pasien WHERE tanggal='$tanggal' AND poli='$poli'");
        $no_antrian = mysqli_fetch_assoc($antri);

        $poli = $this->post('poli');
        $data = [
            'id_kunjungan' => "",
            'no_urutkunjungan' => $hasil['total'],
            'tanggal' => $tanggal,
            'no_antrian' => $no_antrian['total'],
            'keluhan' => $this->post('keluhan'),
            'jenis_kunjungan' => $this->post('jenis_kunjungan'),
            'poli' => $poli,
            'no_rm' => $this->post('no_rm')
        ];

        $insert = $this->db->insert('kunjungan_pasien', $data);

        if ($insert) {
            $this->response(['status' => 'success'], 200);
        } else {
            $this->response(['status' => 'fail', 502]);
        }
    }

    public function index_put()
    {
        $id = $this->put('id');
        $data = [
            'id' => $this->put('id'),
            'nama' => $this->put('nama'),
            'harga' => $this->put('harga')
        ];

        $this->db->where('id', $id);
        $update = $this->db->update('item', $data);

        if ($update) {
            $this->response(['status' => 'success'], 200);
        } else {
            $this->response(['status' => 'fail'], 504);
        }
    }

    public function index_delete()
    {
        $id = $this->delete('id');

        $this->db->where('id', $id);
        $delete = $this->db->delete('item');

        if ($delete) {
            $this->response(['status' => 'success'], 201);
        } else {
            $this->response(['status' => 'fail'], 502);
        }
    }
}
