package com.kesehatan.klinikhusada.Model;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface1 {
    @FormUrlEncoded
    @GET("pasien_android")
    Call<GetPasien> getPasien() ;

    @FormUrlEncoded
    @POST("pasien")
    Call<PostPutDelPasien> postPasien(@Field("nama_pasien") String nama_pasien,
                                      @Field("usia") String usia);

    @FormUrlEncoded
    @PUT("pasien")
    Call<PostPutDelPasien> putPasien(@Field("no_rm") String no_rm,
                                     @Field("nama_pasien") String nama_pasien,
                                     @Field("usia") String usia);

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "pasien", hasBody = true)
    Call<PostPutDelPasien> deletePasien(@Field("no_rm") String no_rm);

}

