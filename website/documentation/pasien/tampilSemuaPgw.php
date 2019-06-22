<?php

/*

 penulis: Muhammad yusuf
 website: http://www.kodingindonesia.com/

 */

//Import File Koneksi Database
require_once('koneksi.php');

//Membuat SQL Query
$sql = "SELECT * FROM tb_pegawai ORDER BY id DESC LIMIT 1";

//Mendapatkan Hasil
$r = mysqli_query($con, $sql);

//Membuat Array Kosong
$result = array();

while ($row = mysqli_fetch_array($r)) {

	//Memasukkan Nama dan ID kedalam Array Kosong yang telah dibuat
	array_push($result, array(
		"id_trans" => $row['id_trans'],
		"no_hp" => $row['no_hp'],
		"provider" => $row['provider'],
		"jumlah" => $row['jumlah'],
		"status" => $row['status']
	));
}

//Menampilkan Array dalam Format JSON
echo json_encode(array('result' => $result));

mysqli_close($con);
