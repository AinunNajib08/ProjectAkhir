package com.kesehatan.klinikhusada.Volley;

/**
 * Created by muhammadyusuf on 01/19/2017.
 * kodingindonesia
 */

public class konfigurasi {

    //Dibawah ini merupakan Pengalamatan dimana Lokasi Skrip CRUD PHP disimpan
    //Pada tutorial Kali ini, karena kita membuat localhost maka alamatnya tertuju ke IP komputer
    //dimana File PHP tersebut berada
    //PENTING! JANGAN LUPA GANTI IP SESUAI DENGAN IP KOMPUTER DIMANA DATA PHP BERADA
    public static final String URL_ADD="http://192.168.43.2/Android/pegawai/tambahPgw.php";
    public static final String URL_GET_ALL = "http://192.168.43.2/Android/pegawai/tampilSemuaPgw.php";
    public static final String URL_GET_EMP = "http://192.168.43.2/Android/pegawai/tampilPgw.php?id=";
    public static final String URL_UPDATE_EMP = "http://192.168.43.2/Android/pegawai/updatePgw.php";
    public static final String URL_DELETE_EMP = "http://192.168.43.2/Android/pegawai/hapusPgw.php?id=";

    //Dibawah ini merupakan Kunci yang akan digunakan untuk mengirim permintaan ke Skrip PHP
    public static final String KEY_EMP_ID_TRANS = "id_trans";
    public static final String KEY_EMP_NOHP = "no_hp";
    public static final String KEY_EMP_PROVIDER = "provider";
    public static final String KEY_EMP_JUMLAH = "jumlah"; //desg itu variabel untuk posisi

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID_TRANS = "id_trans";
    public static final String TAG_NOHP = "no_hp";
    public static final String TAG_PROVIDER = "provider";
    public static final String TAG_JUMLAH = "salary";

    //ID karyawan
    //emp itu singkatan dari Employee
    public static final String EMP_ID = "emp_id";
}
