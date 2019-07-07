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
        $tanggal = date('Y-m-d');
        $this->db->select('*'); // <-- There is never any reason to write this line!
        $this->db->from('kunjungan_pasien');
        $array = array('poli' => '1', 'tanggal' => $tanggal, 'selesai' => '0');
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

        $antri = mysqli_query($aVar, "SELECT count(*) as total from kunjungan_pasien WHERE tanggal='$tanggal' AND poli='$poli' AND selesai = '0'");
        $no_antrian = mysqli_fetch_assoc($antri);
        $no_rm = $this->post('no_rm');

        $no_antriyan = mysqli_query($aVar, "SELECT count(*) as total from kunjungan_pasien WHERE tanggal='$tanggal' AND poli='$poli'");
        $no_antrianyan = mysqli_fetch_assoc($no_antriyan);

        $estimasi = 0;
        if ($no_antrian['total'] == 1) {
            $estimasi = 900000;
        } else if ($no_antrian['total'] == 2) {
            $estimasi = 1800000;
        } else if ($no_antrian['total'] == 3) {
            $estimasi = 2700000;
        } else if ($no_antrian['total'] == 4) {
            $estimasi = 3600000;
        } else if ($no_antrian['total'] == 5) {
            $estimasi = 4500000;
        } else if ($no_antrian['total'] == 6) {
            $estimasi = 5400000;
        } else if ($no_antrian['total'] == 7) {
            $estimasi = 6300000;
        } else if ($no_antrian['total'] == 8) {
            $estimasi = 7200000;
        } else if ($no_antrian['total'] == 9) {
            $estimasi = 8100000;
        } else if ($no_antrian['total'] == 10) {
            $estimasi = 9000000;
        } else if ($no_antrian['total'] == 11) {
            $estimasi = 99000000;
        } else if ($no_antrian['total'] == 12) {
            $estimasi = 11700000;
        } else if ($no_antrian['total'] == 13) {
            $estimasi = 12600000;
        } else if ($no_antrian['total'] == 14) {
            $estimasi = 13500000;
        }

        $poli = $this->post('poli');
        $data = [
            'id_kunjungan' => "",
            'no_urutkunjungan' => $hasil['total'],
            'tanggal' => $tanggal,
            'no_antrian' => $no_antrianyan['total'],
            'keluhan' => $this->post('keluhan'),
            'jenis_kunjungan' => $this->post('jenis_kunjungan'),
            'poli' => $poli,
            'no_rm' => $no_rm,
            'estimasi' => $estimasi
        ];

        $validasi = mysqli_query($aVar, "SELECT count(*) as total from kunjungan_pasien WHERE tanggal='$tanggal' AND no_rm='$no_rm'");
        $validasireg = mysqli_fetch_assoc($validasi);

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
