<?php

use Illuminate\Database\Eloquent\Model;

defined('BASEPATH') or exit('No direct script access allowed');

class Datakunjungantoday extends CI_Controller
{
	function __construct()
	{
		parent::__construct();
		$this->load->model('Mkunjungan_pasien');
		$this->load->helper('url');
	}

	function edit($no_rm, $no_antrian, $poli)
	{

		$tanggal = date('Y-m-d');
		$where = array('tanggal' => $tanggal, 'poli' => $poli);
		$this->db->select('no_rm, COUNT(no_rm) as total');
		$this->db->from('kunjungan_pasien');
		$this->db->where($where);
		$test = $this->db->count_all_results();
		$this->load->model('Mkunjungan_pasien');
		$estimasinew = 900000;
		for ($i = 0; $i < $test + 1; ++$i) {
			$no_antrian;
			$no_antriannew = $no_antrian - 1;
			$estimasi = 0;
			$selesai = 0;
			if ($no_antrian == 1) {
				$estimasi = 0;
				$selesai = 1;
			} else if ($no_antrian == 2) {
				$estimasi = 0;
				$selesai = 0;
			} else {
				$estimasi = 90000;
			}
			$this->db->query("UPDATE kunjungan_pasien SET no_antrian = '$no_antriannew' , estimasi = '$estimasi', selesai = '$selesai' WHERE tanggal ='$tanggal' AND poli = $poli AND no_antrian = '$no_antrian'");
			++$no_antrian;
		}
		redirect('admin/datakunjungan');
	}
}
