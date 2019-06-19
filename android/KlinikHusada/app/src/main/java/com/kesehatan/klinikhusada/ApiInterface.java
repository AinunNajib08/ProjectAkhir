package com.kesehatan.klinikhusada;
import com.kesehatan.klinikhusada.Model.GetPasien;
import com.kesehatan.klinikhusada.Model.PostPutDelPasien;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {
    @GET("kontak_android")
    Call<GetPasien> getKontak();
    @FormUrlEncoded
    @POST("kontak")
    Call<PostPutDelPasien> postKontak(@Field("nama") String nama,
                                      @Field("nomor") String nomor);
    @FormUrlEncoded
    @PUT("kontak")
    Call<PostPutDelPasien> putKontak(@Field("id") String id,
                                     @Field("nama") String nama,
                                     @Field("nomor") String nomor);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "kontak", hasBody = true)
    Call<PostPutDelPasien> deleteKontak(@Field("id") String id);
}
