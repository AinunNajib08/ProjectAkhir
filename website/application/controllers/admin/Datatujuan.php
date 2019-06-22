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

        $data["poli"] = $this->Mdatatujuan->getAll();
        $this->load->view("admin/datatujuan", $data);
    }

    public function add()
    {
        $poli = $this->Mdatapoli;
        $validation = $this->form_validation;
		$validation->set_rules($poli->rules());

        if ($validation->run()) {
            $poli->save();
            $this->session->set_flashdata('success', 'Berhasil Ditambah');
        } else {
            $this->session->set_flashdata('error', 'Error');
        }

        $this->load->view("admin/tambahpoli");
    }

    public function edit($id_poli = null)
    {
        if (!isset($id_poli)) redirect('admin/datapoli');

        $poli = $this->Mdatatujuan;
        $validation = $this->form_validation;
        $validation->set_rules($poli->rules());

        if ($validation->run()) {
            $poli->update();
            $this->session->set_flashdata('success', 'Berhasil disimpan');
        }

        $data["poli"] = $poli->getById($id_poli);
        if (!$data["poli"]) show_404();

        $this->load->view("admin/editpoli", $data);
    }

    public function delete($id_poli = null)
    {
        if (!isset($id_poli)) show_404();

        if ($this->Mdatapoli->delete($id_poli)) {
            redirect(site_url('admin/Datatujuan'));
        }
    }
}
