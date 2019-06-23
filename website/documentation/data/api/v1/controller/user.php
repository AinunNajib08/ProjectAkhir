<?php

/*
API REGISTER
 */

$app->post('/api/v1/register', function ($request, $response) {
    $data = $request->getParsedBody();
    $no_rm = $data['no_rm'];
    $tanggal_lahir = $data['tanggal_lahir'];
    /*
    Melalukan pengecekan email/password jika kosong maka
    proses login tidak akan dilakukan.
     */
    if (empty($no_rm) || empty($tanggal_lahir)) {
        $result = array(
            "status" => false,
            "message" => "Masukan Nomor Rekam Medik dan Tanggal Lahir",
            "data" => [],
        );
        return $response->withStatus(200)->withJson($result);
    } else {
        /*
        Count disini dimaksudkan untuk mengecek apakah email sudah ada di
        database apa belum. Count disini akan membalikan jumlah data, 
        jika jumlah datanya 1 maka ada, jika jumlah datanya 0 maka kita asumsikan
        dengan tidak ada.
        */
        $count = M_login::where('no_rm', $no_rm)->count();
        if ($count > 0) {
            /*
            Disini kita akan mengambil data berdasarkan kecocokan email.
            */
            $users = M_login::where('no_rm', $no_rm)->take(1)->get();
            foreach ($users as $user) {
                $passwordHash = $user->tanggal_lahir;
                if ($passwordHash == $tanggal_lahir) {
                    $result = array(
                        "status" => true,
                        "message" => "Login Berhasil",
                        "data" => $users,
                    );
                    return $response->withStatus(200)->withJson($result);
                } else {
                    $result = array(
                        "status" => false,
                        "message" => "Tanggal Lahir anda Tidak Valid dengan Nomor Rekam Medik",
                        "data" => []
                    );
                    return $response->withStatus(200)->withJson($result);
                }
            }
        } else {
            $result = array(
                "status" => false,
                "message" => "Nomor Rekam Medik anda Salah",
                "data" => [],
            );
            return $response->withStatus(200)->withJson($result);
        }
    }
});

/*
API LOGIN
 */
$app->post('/api/v1/login', function ($request, $response) {
    $data = $request->getParsedBody();
    $username = $data['username'];
    $password = $data['password'];
    /*
    Melalukan pengecekan email/password jika kosong maka
    proses login tidak akan dilakukan.
     */
    if (empty($username) || empty($password)) {
        $result = array(
            "status" => false,
            "message" => "Form tidak boleh kosong",
            "data" => [],
        );
        return $response->withStatus(200)->withJson($result);
    } else {
        /*
        Count disini dimaksudkan untuk mengecek apakah email sudah ada di
        database apa belum. Count disini akan membalikan jumlah data, 
        jika jumlah datanya 1 maka ada, jika jumlah datanya 0 maka kita asumsikan
        dengan tidak ada.
        */
        $count = M_user::where('username', $username)->count();
        if ($count > 0) {
            /*
            Disini kita akan mengambil data berdasarkan kecocokan email.
            */
            $users = M_user::where('username', $username)->take(1)->get();
            foreach ($users as $user) {
                $passwordHash = $user->password;
                if (password_verify($password, $passwordHash)) {
                    $result = array(
                        "status" => true,
                        "message" => "Login Berhasil",
                        "data" => $users,
                    );
                    return $response->withStatus(200)->withJson($result);
                } else {
                    $result = array(
                        "status" => false,
                        "message" => "Password Salah",
                        "data" => []
                    );
                    return $response->withStatus(200)->withJson($result);
                }
            }
        } else {
            $result = array(
                "status" => false,
                "message" => "Email belum terdaftar",
                "data" => [],
            );
            return $response->withStatus(200)->withJson($result);
        }
    }
});

/*
    Regis
*/


/*
API REGISTER
 */
$app->post('/api/v1/regis', function ($request, $response) {
    $data = $request->getParsedBody();
    $username = $data['username'];
    $password = $data['password'];
    $email = $data['email'];
    $no_rm = $data['no_rm'];
    /*
    Melalukan pengecekan nama/jurusan/email/password jika kosong maka
    proses simpan tidak akan dilakukan.
     */
    if (empty($username) || empty($password) || empty($email) || empty($no_rm)) {
        $result = array(
            "status" => false,
            "message" => "Form tidak boleh kosong",
            "data" => [],
        );
        return $response->withStatus(200)->withJson($result);
    } else {
        $user = new M_user();
        $user->username = $username;
        /*
        passwordEncrypt ini berfungsi untuk meng-generate inputan password
        yang ditulis oleh user menjadi hash password.
        */
        $passwordEncrypt = password_hash($password, PASSWORD_DEFAULT);
        $user->password = $passwordEncrypt;
        $user->email = $email;
        $user->no_rm = $no_rm;
        $aVar = mysqli_connect('localhost', 'root', '', 'klinik');
        $result = mysqli_query($aVar, "SELECT count(*) as total from akun_user WHERE no_rm='$no_rm'");
        $hasil = mysqli_fetch_assoc($result);

        if ($hasil['total'] = 0) {
            $user->save();
            $result = array(
                "status" => true,
                "message" => "Registrasi Berhasil",
                "data" => $user,
            );
        } else {
            $result = array(
                "status" => false,
                "message" => "No Rekam Medik Sudah Terdaftar",
                "data" => [],
            );
        }

        return $response->withStatus(201)->withJson($result);
    }
});
