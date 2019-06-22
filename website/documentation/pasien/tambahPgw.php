<?php

/*

 penulis: Muhammad yusuf
 website: http://www.kodingindonesia.com/

 */

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

	//Mendapatkan Nilai Variable
	$trans = $_POST['trans'];
	$no = $_POST['no'];
	$prov = $_POST['prov'];
	$jum = $_POST['jum'];
	$status = "Berhasil";

	//Pembuatan Syntax SQL
	$sql = "INSERT INTO tb_pegawai (id, id_trans, no_hp, provider, jumlah, status) VALUES ('','$trans','$no','$prov','$jum', '$status')";

	//Import File Koneksi database
	require_once('koneksi.php');

	//Eksekusi Query database
	if (mysqli_query($con, $sql)) {
		echo 'Berhasil Menambahkan Pegawai';
	} else {
		echo 'Gagal Menambahkan Pegawai';
	}

	mysqli_close($con);
}
