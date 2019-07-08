<?php

defined('BASEPATH') or exit('No direct script access allowed');

class Datatujuan extends CI_Controller
{
    public function __construct()
    {
        parent::__construct();
        if (!$this->session->logged_in) {
            redirect('login_controler');
        }
        $this->load->model("Mdatatujuan");
        $this->load->library('form_validation');
    }

    public function index()
    {

        $data["tujuan_pelayanan"] = $this->Mdatatujuan->getAll();
        $data['count'] = $this->Mdatatujuan->get_count();
        $this->load->view("admin/datatujuan", $data);
    }
}
