<?php

defined('BASEPATH') OR exit('No direct script access allowed');

class Datakunjungan extends CI_Controller
{
    public function __construct()
    {
        parent::__construct();
        $this->load->model("Mkunjungan_pasien");
        $this->load->library('form_validation');
    }

    public function index()
    {
        $data["kunjungan_pasien"] = $this->Mkunjungan_pasien->getAll();
        $this->load->view("admin/datakunjunganpasien", $data);
    }

    public function add()
    {
        $pasien = $this->Mkunjungan_pasien;
        $validation = $this->form_validation;
        $validation->set_rules($kunjungan_pasien->rules());

        if ($validation->run()) {
            $pasien->save();
            $this->session->set_flashdata('success', 'Berhasil disimpan');
        } else {
            $this->session->set_flashdata('error', 'Error');
        }

        $this->load->view("admin/tambahkunjungan");
    }

    public function edit($id_kunjungan = null)
    {
        if (!isset($id_kunjungan)) redirect('admin/datakunjunganpasien');

        $kunjungan_pasien = $this->Mkunjungan_pasien;
        $validation = $this->form_validation;
        $validation->set_rules($kunjungan_pasien->rules());

        if ($validation->run()) {
            $kunjungan_pasien->update();
            $this->session->set_flashdata('success', 'Berhasil disimpan');
        }

        $data["kunjungan_pasien"] = $kunjungan_pasien->getById($id_kunjungan);
        if (!$data["kunjungan_pasien"]) show_404();
        
        $this->load->view("admin/editkunjungan", $data);
    }

    public function delete($id=null)
    {
        if (!isset($id)) show_404();
        
        if ($this->product_model->delete($id)) {
            redirect(site_url('admin/products'));
        }
    }
}