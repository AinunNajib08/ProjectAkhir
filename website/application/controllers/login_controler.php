<?php
defined('BASEPATH') or exit('No direct script access allowed');

class login_controler extends CI_Controller
{
	public function __construct()
	{
		parent::__construct();
		$this->load->library('form_validation');
		$this->load->library('session');
	}

	public function index()
	{
		$this->form_validation->set_rules('username', 'Username', 'trim|required');
		$this->form_validation->set_rules('password', 'Password', 'trim|required');


		if ($this->form_validation->run() == false) {
			$this->load->view('admin/login');
		} else {

			//jika sudah tervalidasi
			$this->_proses_login();
		}
	}

	private function _proses_login()
	{

		$username = $this->input->post('username');
		$password = $this->input->post('password');

		$admin = $this->db->get_where('akun_admin', ['username' => $username])->row_array();
		$cekpass = $this->db->get_where('akun_admin', array('password' => $password));

		if ($admin) {

			if ($admin['active'] == 1) {

				if ($cekpass->num_rows() > 0) {

					$data = [
						'username' => $admin['username']
					];
					$data['logged_in'] = TRUE;
					$this->session->set_userdata($data);
					redirect('admin/Datakunjungan');
				} else {
					$this->session->set_flashdata('message', '<div class="alert alert-danger" role="alert">Maaf password yang anda masukkan salah!</div>');
					redirect('login_controler');
				}
			} else {

				$this->session->set_flashdata('message', '<div class="alert alert-danger" role="alert">Maaf username yang anda masukkan tidak aktif!</div>');
				redirect('login_controler');
			}
		} else {

			$this->session->set_flashdata('message', '<div class="alert alert-danger" role="alert">Maaf username yang anda masukkan salah!</div>');
			redirect('login_controler');
		}
	}

	public function logout()
	{
		$this->session->unset_userdata('username');

		$this->session->set_flashdata('message', '<div class="alert alert-primary" role="alert">anda telah logged out</div>');
		redirect('login_controler');
	}
}
