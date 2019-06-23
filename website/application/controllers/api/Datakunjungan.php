<?php

defined('BASEPATH') or exit('No direct script access allowed');

require APPPATH . '/libraries/REST_Controller.php';
use Restserver\Libraries\REST_Controller;

class Datakunjungan extends REST_Controller
{

    function __construct($config = 'rest')
    {
        parent::__construct($config);
        $this->load->database();
    }

    function index_get()
    {
        $id = $this->get('id_kunjungan');
        $keluhan = $this->get('keluhan');
        if ($id == '') {
            $kunjungan = $this->db->get('kunjungan_pasien')->result();
        } else {
            $this->db->get_where('id_kunjungan', array('keluhan' => $keluhan));
            $kunjungan = $this->db->get('kunjungan_pasien')->result();
        }
        $this->response($kunjungan, 200);
    }


    function index_put()
    {
        $id = $this->put('id_kunjungan');
        $data = array(
            'id_kunjungan'       => $this->put('id_kunjungan'),
            'no_urutkunjungan'       => $this->put('no_urutkunjungan'),
            'tanggal'       => $this->put('tanggal'),
            'no_antrian'       => $this->put('no_antrian'),
            'keluhan'    => $this->put('keluhan'),
            'jenis_kunjungan'       => $this->put('jenis_kunjungan'),
            'kode_tujuan'       => $this->put('kode_tujuan'),
            'no_rm'       => $this->put('no_rm')
        );
        $this->db->where('id_kunjungan', $id);
        $update = $this->db->update('kunjungan_pasien', $data);
        if ($update) {
            $this->response($data, 200);
        } else {
            $this->response(array('status' => 'fail', 502));
        }
    }

    function index_delete()
    {
        $id = $this->delete('id_kunjungan');
        $this->db->where('id_kunjungan', $id);
        $delete = $this->db->delete('kunjungan_pasien');
        if ($delete) {
            $this->response(array('status' => 'success'), 201);
        } else {
            $this->response(array('status' => 'fail', 502));
        }
    }
}
