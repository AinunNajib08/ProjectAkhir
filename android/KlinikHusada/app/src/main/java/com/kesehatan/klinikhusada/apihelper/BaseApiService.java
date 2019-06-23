package com.kesehatan.klinikhusada.apihelper;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface BaseApiService {

    // Fungsi ini untuk memanggil API http://10.0.2.2/mahasiswa/login.php
    @FormUrlEncoded
    @POST("login")
    Call<ResponseBody> loginRequest(@Field("username") String username,
                                    @Field("password") String password);

    // Fungsi ini untuk memanggil API http://10.0.2.2/mahasiswa/register.php
    @FormUrlEncoded
    @POST("register")
    Call<ResponseBody> registerRequest(@Field("no_rm") String no_rm,
                                       @Field("tanggal_lahir") String tanggal_lahir);
    @FormUrlEncoded
    @POST("regis")
    Call<ResponseBody> regisRequest(@Field("username") String username,
                                    @Field("password") String password,
                                    @Field("email") String email,
                                    @Field("no_rm") String no_rm);

    @FormUrlEncoded
    @POST("antrian")
    Call<ResponseBody> getAntrian(@Field("keluhan") String keluhan,
                                    @Field("poli") String poli,
                                    @Field("no_rm") String no_rm);



}
