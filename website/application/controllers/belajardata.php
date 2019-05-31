<?php
defined('BASEPATH') or exit('No direct script access allowed');

class Belajardata extends CI_Controller
{

    function dataipa()
    {
        $this->load->view("index");
        // $this->load->view("admin/dataipa");
    }
}
