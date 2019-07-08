<?php

defined('BASEPATH') or exit('No direct script access allowed');

require APPPATH . '/libraries/REST_Controller.php';

use Restserver\Libraries\REST_Controller;

class Pendaftaranc extends REST_Controller
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
        $tanggal = date('Y-m-d');
        $this->db->select('*'); // <-- There is never any reason to write this line!
        $this->db->from('kunjungan_pasien');
        $array = array('poli' => '3', 'tanggal' => $tanggal, 'selesai' => '0');
        $this->db->where($array);
        $this->db->join('pasien', 'kunjungan_pasien.no_rm = pasien.no_rm');
        $query = $this->db->get()->result();
        $response['message'] = "success";
        $response['data'] = $query;

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
        $no_antriannew = $no_antrian['total'] + 1;
        $data = [
            'id_kunjungan' => "",
            'no_urutkunjungan' => $hasil['total'],
            'tanggal' => $tanggal,
            'no_antrian' => $no_antriannew,
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
