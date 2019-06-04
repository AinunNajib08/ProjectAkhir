<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class login_controler extends CI_Controller
{
	public function _construct() 
	{
		parent::_construct();
	}

    public function index()
    {
        $this->load->view("admin/login/login");
    }

    public function proses_login()
    {

    }
}
?>