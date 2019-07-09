<?php defined('BASEPATH') or exit('No direct script access allowed');

class Mdatapasien extends CI_Model
{
    private $_table = "pasien";
    public $no_rm;
    public $no_asuransilain;
    public $nama_pasien;
    public $usia;
    public $tanggal_lahir;
    public $jenis_kelamin;
    public $agama;
    public $alamat;
    public $kota;
    public $provinsi;
    public $telepon;
    public $pekerjaan;
    public $tanggal_daftar;
    public $foto;
    public $email;
    public $orang_tua;
    public $status_kawin;
    public $status_tinggal;
    public function rules()
    {
        return [
            [
                'field' => 'no_rm',
                'label' => 'Name',
                'rules' => 'required'
            ],

            [
                'field' => 'no_al',
                'label' => 'no_al',
                'rules' => 'required'
            ]
        ];
    }

    public function getAll()
    {
        return $this->db->get($this->_table)->result();
    }

    public function getById($no_rm)
    {
        return $this->db->get_where($this->_table, ["no_rm" => $no_rm])->row();
    }

    public function save()
    {
        $usiadata = "12";
        $post = $this->input->post();
        // $usiapasien = date("Y-m-d") - $post["tgl_lahir"];
        $this->no_rm = $post["no_rm"];
        $this->no_asuransilain = $post["no_al"];
        $this->nama_pasien = $post["nama"];
        $this->usia = $usiadata;
        $this->tanggal_lahir = $post["tgl_lahir"];
        $this->jenis_kelamin = $post["jenis_kelamin"];
        $this->agama = $post["agama"];
        $this->alamat = $post["alamat"];
        $this->kota = $post["kota"];
        $this->provinsi = $post["provinsi"];
        $this->telepon = $post["telepon"];
        $this->pekerjaan = $post["pekerjaan"];
        $this->tanggal_daftar = date("Y-m-d");
        $this->foto = $this->UploadFoto();
        $this->email = $post["email"];
        $this->orang_tua = $post["org_tua"];
        $this->status_kawin = $post["status_kawin"];
        $this->status_tinggal = $post["status_tinggal"];

        $this->db->insert($this->_table, $this);
    }

    public function update()
    {
        $post = $this->input->post();
        $this->no_rm = $post["no_rm"];
        $this->no_asuransilain = $post["no_al"];
        $this->nama_pasien = $post["nama"];
        $this->usia = $post["usia"];
        $this->tanggal_lahir = $post["tgl_lahir"];
        $this->jenis_kelamin = $post["jenis_kelamin"];
        $this->agama = $post["agama"];
        $this->alamat = $post["alamat"];
        $this->kota = $post["kota"];
        $this->provinsi = $post["provinsi"];
        $this->telepon = $post["telepon"];
        $this->pekerjaan = $post["pekerjaan"];
        $this->tanggal_daftar = date("Y-m-d");
        if (!empty($_FILES["foto"]["name"])) {
            $this->foto = $this->UploadFoto()();
        } else {
            $this->foto = $post["foto"];
        };
        $this->email = $post["email"];
        $this->orang_tua = $post["org_tua"];
        $this->status_kawin = $post["status_kawin"];
        $this->status_tinggal = $post["status_tinggal"];

        $this->db->update($this->_table, $this, array('no_rm' => $post['no_rm']));
    }

    public function delete($no_rm)
    {
        return $this->db->delete($this->_table, array("no_rm" => $no_rm));
    }

    private function UploadFoto()
    {
        $config['upload_path']          = '.upload/datapasien/';
        $config['allowed_types']        = 'gif|png|jpg';
        $config['file_name']            = $this->no_rm;
        $config['overwrite']            = true;
        $config['max_size']             = 1024;

        $this->load->library('upload', $config);

        if ($this->upload->do_upload('foto')) {
            return $this->upload->data('file_name');
        }
        return "default.jpg";
    }

    public function get_count()
    {
        $sql = "SELECT count(no_rm) as count FROM pasien";
        $result = $this->db->query($sql);
        return $result->row()->count;

    }

    public function get_count1()
    {
        $sql1 = "SELECT count(id_kunjungan) as count FROM kunjungan_pasien";
        $resultt = $this->db->query($sql1);
        return $resultt->row()->count;
    }

    public function get_count2()
    {
        $sql2 = "SELECT count(id_poli) as count FROM poli";
        $results = $this->db->query($sql2);
        return $results->row()->count;
    }

    public function get_count3()
    {
        $sql3 = "SELECT count(kode_tujuan) as count FROM tujuan_pelayanan";
        $resulth = $this->db->query($sql3);
        return $resulth->row()->count;
    }
}
