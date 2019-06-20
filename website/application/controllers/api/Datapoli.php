<?php

defined('BASEPATH') OR exit('No direct script access allowed');

require APPPATH . '/libraries/REST_Controller.php';
use Restserver\Libraries\REST_Controller;

class Datapoli extends REST_Controller {

    function __construct($config = 'rest') {
        parent::__construct($config);
        $this->load->database();
    }

    function index_get() {
        $id = $this->get('id_poli');
        if ($id == '') {
            $poli = $this->db->get('poli')->result();
        } else {
            $this->db->where('id_poli', $id);
            $poli = $this->db->get('poli')->result();
        }
        $this->response($poli, 200);
    }

    function index_post() {
        $data = array(
                    'id_poli'           => $this->post('id_poli'),
                    'poli'          => $this->post('poli'));
        $insert = $this->db->insert('poli', $data);
        if ($insert) {
            $this->response($data, 200);
        } else {
            $this->response(array('status' => 'fail', 502));
        }
    }

    function index_put() {
        $id = $this->put('id_poli');
        $data = array(
                    'id_poli'       => $this->put('id_poli'),
                    'poli'    => $this->put('poli'));
        $this->db->where('id_poli', $id);
        $update = $this->db->update('poli', $data);
        if ($update) {
            $this->response($data, 200);
        } else {
            $this->response(array('status' => 'fail', 502));
        }
    }

    function index_delete() {
        $id = $this->delete('id_poli');
        $this->db->where('id_poli', $id);
        $delete = $this->db->delete('poli');
        if ($delete) {
            $this->response(array('status' => 'success'), 201);
        } else {
            $this->response(array('status' => 'fail', 502));
        }
    }

}
?>