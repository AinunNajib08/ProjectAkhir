<?php

defined('BASEPATH') or exit('No direct script access allowed');

class Searchpasien extends CI_Controller
{
    public function __construct()
    {
        parent::__construct();
        if (!$this->session->logged_in) {
            redirect('login_controler');
        }
        $this->load->model("Mdatapasien");
        $this->load->library('form_validation');
        $this->load->helper('url');
        $this->load->helper('form');
    }
    public function index()
    {
        $data['pasien'] = $this->Mdatapasien->getAll();
        $this->load->view("admin/datapasien", $data);
    }

    public function pencarian()
    {
        $data['kategori'] = $this->input->post("kategori");
        $data['keywoard'] = $this->input->post("keywoard");

        $data["pasien"] = $this->Mdatapasien->searchpasien($data['kategori'], $data['keywoard'])->result();
        $data["jumlah"] = count($data["pasien"]);
        $this->load->view("admin/datapasien", $data);
    }
}
