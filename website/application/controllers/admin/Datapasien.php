<?php

defined('BASEPATH') or exit('No direct script access allowed');

class Datapasien extends CI_Controller
{
    public function __construct()
    {
        parent::__construct();
        if (!$this->session->logged_in) {
            redirect('login_controler');
        }
        $this->load->model("Mdatapasien");
        $this->load->library('form_validation');
    }

    public function index()
    {

        $data["pasien"] = $this->Mdatapasien->getAll();
        $this->load->view("admin/datapasien", $data);
    }

    public function add()
    {
        $pasien = $this->Mdatapasien;
        $validation = $this->form_validation;
        $validation->set_rules($pasien->rules());

        if ($validation->run()) {
            $pasien->save();
            $this->session->set_flashdata('success', 'Berhasil disimpan');
        } else {
            $this->session->set_flashdata('error', 'Error');
        }

        $this->load->view("admin/tambahpasien");
    }

    public function edit($no_rm = null)
    {
        if (!isset($no_rm)) redirect('admin/datapasien');

        $pasien = $this->Mdatapasien;
        $validation = $this->form_validation;
        $validation->set_rules($pasien->rules());

        if ($validation->run()) {
            $pasien->update();
            $this->session->set_flashdata('success', 'Berhasil disimpan');
        }

        $data["pasien"] = $pasien->getById($no_rm);
        if (!$data["pasien"]) show_404();

        $this->load->view("admin/editkunjungan", $data);
    }

    public function delete($no_rm = null)
    {
        if (!isset($no_rm)) show_404();

        if ($this->Mdatapasien->delete($no_rm)) {
            redirect(site_url('admin/products'));
        }
    }
}