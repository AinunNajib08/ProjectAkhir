<?php

/*
API REGISTER
 */
$app->post('/api/v1/register', function ($request, $response) {
    $data = $request->getParsedBody();
    $username = $data['username'];
    $password = $data['password'];
    $email = $data['email'];
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
        return $response->withStatus(200)->withJson($result);
    } else {
        $user = new M_user();
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
        return $response->withStatus(201)->withJson($result);
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
