<?php

defined('BASEPATH') or exit('No direct script access allowed');

class Datakunjunganpoli4 extends CI_Controller
{
    public function __construct()
    {
        parent::__construct();
        if (!$this->session->logged_in) {
            redirect('login_controler');
        }
        $this->load->model("Mkunjungan_pasien");
        $this->load->library('form_validation');
    }

    public function index()
    {
        $data["kunjunganpoli4"] = $this->Mkunjungan_pasien->datakunjunganpoli4();
        $data['count'] = $this->Mkunjungan_pasien->get_count();
        $data['count1'] = $this->Mkunjungan_pasien->get_count1();
        $data['count2'] = $this->Mkunjungan_pasien->get_count2();
        $data['count3'] = $this->Mkunjungan_pasien->get_count3();
        $this->load->view("admin/datakunjunganpoli4", $data);
    }

    public function tambah()
    {
        $pasien = $this->Mkunjungan_pasien;
        $validation = $this->form_validation;
        $validation->set_rules($pasien->rules());

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

    public function delete($id_kunjungan = null)
    {
        if (!isset($id_kunjungan)) show_404();

        if ($this->Mkunjungan_pasien->delete($id_kunjungan)) {
            redirect(site_url('Datakunjungan'));
        }
    }
}
