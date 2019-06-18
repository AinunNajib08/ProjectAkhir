<?php


defined('BASEPATH') or exit('No direct script access allowed');

class daftar extends CI_Controller
{

    function regis()
    {
        $post = $this->input->post();
        $username = $this->username = $post["username"];
        $password = $this->password = $post["password"];
        $email = $this->email = $post["email"];
        /*
    Melalukan pengecekan nama/jurusan/email/password jika kosong maka
    proses simpan tidak akan dilakukan.
     */
        if (empty($username) || empty($password) || empty($email)) {
            $result = array(
                "status" => false,
                "message" => "Form tidak boleh kosong",
                "data" => [],
            );
            return $this->response($result);
        } else {
            $user = new Muser();
            $user->username = $username;
            $user->password = $password;
            $user->email = $email;
            /*
        passwordEncrypt ini berfungsi untuk meng-generate inputan password
        yang ditulis oleh user menjadi hash password.
        */
            $passwordEncrypt = password_hash($password, PASSWORD_DEFAULT);
            $user->password = $passwordEncrypt;
            $user->save();

            $result = array(
                "status" => true,
                "message" => "Registrasi Berhasil",
                "data" => $user,
            );
            return $this->response($result);
        }
    }
}
