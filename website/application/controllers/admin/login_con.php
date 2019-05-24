<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class login_con extends CI_Controller{
    public function login(){
        $this->load->view("admin/login/login");
    }
}
?>