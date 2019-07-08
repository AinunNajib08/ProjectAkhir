<?php defined('BASEPATH') or exit('No direct script access allowed');

class Mkunjungan_pasien extends CI_Model
{
    private $_table = "kunjungan_pasien";

    public $id_kunjungan;
    public $no_urutkunjungan;
    public $tanggal;
    public $no_antrian;
    public $keluhan;
    public $jenis_kunjungan;
    public $kode_tujuan;
    public $no_rm;
    public $poli;

    public function rules()
    {
        return [
            [
                'field' => 'id_kunjungan',
                'label' => 'id_kunjungan',
                'rules' => 'required'
            ],

            [
                'field' => 'no_urutkunjungan',
                'label' => 'no_urutkunjungan',
                'rules' => 'required'
            ],

            [
                'field' => 'tanggal',
                'label' => 'tanggal',
                'rules' => 'required'
            ],

            [
                'field' => 'no_antrian',
                'label' => 'no_antrian',
                'rules' => 'required'
            ],

            [
                'field' => 'keluhan',
                'label' => 'keluhan',
                'rules' => 'required'
            ],

            [
                'field' => 'jenis_kunjungan',
                'label' => 'jenis_kunjungan',
                'rules' => 'required'
            ],

            [
                'field' => 'kede_tujuan',
                'label' => 'kode_tujuan',
                'rules' => 'required'
            ],

            [
                'field' => 'no_rm',
                'label' => 'no_rm',
                'rules' => 'required'
            ],
            [
                'field' => 'poli',
                'label' => 'poli',
                'rules' => 'required'
            ]
        ];
    }

    public function getAll()
    {
        return $this->db->get($this->_table)->result();
    }

    public function getById($id_kunjungan)
    {
        return $this->db->get_where($this->_table, ["id_kunjungan" => $id_kunjungan])->row();
    }

    public function save()
    {
        $post = $this->input->post();
        $this->id_kunjungan = $post["id_kunjungan"];
        $this->no_urutkunjungan = $post["no_urutkunjungan"];
        $this->tanggal = $post["tanggal"];
        $this->no_antrian = $post["no_antrian"];
        $this->keluhan = $post["keluhan"];
        $this->jenis_kunjungan = $post["jenis_kunjungan"];
        $this->kode_tujuan = $post["kode_tujuan"];
        $this->no_rm = $post["no_rm"];
        $this->poli = $post["poli"];

        $this->db->insert($this->_table, $this);
    }

    public function update()
    {
        $post = $this->input->post();
        $this->id_kunjungan = $post["id_kunjungan"];
        $this->no_urutkunjungan = $post["no_urutkunjungan"];
        $this->tanggal = $post["tanggal"];
        $this->no_antrian = $post["no_antrian"];
        $this->keluhan = $post["keluhan"];
        $this->jenis_kunjungan = $post["jenis_kunjungan"];
        $this->kode_tujuan = $post["kode_tujuan"];
        $this->no_rm = $post["no_rm"];
        $this->poli = $post["poli"];

        $this->db->update($this->_table, $this, array('id_kunjungan' => $post['id_kunjungan']));
    }

    public function delete($id_kunjungan)
    {
        return $this->db->delete($this->_table, array("id_kunjungan" => $id_kunjungan));
    }

    public function datakunjunganpoli1()
    {
        $kunjunganpoli1 = $this->db->query("SELECT kunjungan_pasien.id_kunjungan, kunjungan_pasien.no_rm, kunjungan_pasien.no_urutkunjungan, kunjungan_pasien.tanggal, kunjungan_pasien.no_antrian, kunjungan_pasien.keluhan, kunjungan_pasien.jenis_kunjungan, kunjungan_pasien.kode_tujuan, kunjungan_pasien.poli, poli.poli, poli.poli FROM kunjungan_pasien, poli WHERE poli.poli=kunjungan_pasien.poli AND kunjungan_pasien.poli=1 ")->result();

        return $kunjunganpoli1;
    }

    public function datakunjunganpoli2()
    {
        $kunjunganpoli2 = $this->db->query("SELECT kunjungan_pasien.id_kunjungan, kunjungan_pasien.no_rm, kunjungan_pasien.no_urutkunjungan, kunjungan_pasien.tanggal, kunjungan_pasien.no_antrian, kunjungan_pasien.keluhan, kunjungan_pasien.jenis_kunjungan, kunjungan_pasien.kode_tujuan, kunjungan_pasien.poli, poli.poli, poli.poli FROM kunjungan_pasien, poli WHERE poli.poli=kunjungan_pasien.poli AND kunjungan_pasien.poli=2 ")->result();

        return $kunjunganpoli2;
    }

    public function datakunjunganpoli3()
    {
        $kunjunganpoli3 = $this->db->query("SELECT kunjungan_pasien.id_kunjungan, kunjungan_pasien.no_rm, kunjungan_pasien.no_urutkunjungan, kunjungan_pasien.tanggal, kunjungan_pasien.no_antrian, kunjungan_pasien.keluhan, kunjungan_pasien.jenis_kunjungan, kunjungan_pasien.kode_tujuan, kunjungan_pasien.poli, poli.poli, poli.poli FROM kunjungan_pasien, poli WHERE poli.poli=kunjungan_pasien.poli AND kunjungan_pasien.poli=3 ")->result();

        return $kunjunganpoli3;
    }

    public function datakunjunganpoli4()
    {
        $tanggal = date('Y-m-d');
        $kunjunganpoli4 = $this->db->query("SELECT kunjungan_pasien.id_kunjungan, kunjungan_pasien.no_rm, kunjungan_pasien.no_urutkunjungan, kunjungan_pasien.tanggal, kunjungan_pasien.no_antrian, kunjungan_pasien.keluhan, kunjungan_pasien.jenis_kunjungan, kunjungan_pasien.kode_tujuan, kunjungan_pasien.poli FROM kunjungan_pasien WHERE tanggal = '$tanggal' AND kunjungan_pasien.poli=3 ")->result();
        return $kunjunganpoli4;
    }
}
