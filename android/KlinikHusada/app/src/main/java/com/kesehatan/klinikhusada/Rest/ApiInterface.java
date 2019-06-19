package com.kesehatan.klinikhusada.Rest;
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
    @GET("Datapasien")
    Call<GetPasien> getPasien();
    @FormUrlEncoded
    @POST("pasien")
    Call<PostPutDelPasien> postPasien(@Field("nama_pasien") String nama_pasien,
                                      @Field("usia") String usia);
    @FormUrlEncoded
    @PUT("pasien")
    Call<PostPutDelPasien> putpasien(@Field("no_rm") String no_rm,
                                     @Field("nama_pasien") String nama_pasien,
                                     @Field("usia") String usia);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "kontak", hasBody = true)
    Call<PostPutDelPasien> deletePasien(@Field("id") String id);
}
