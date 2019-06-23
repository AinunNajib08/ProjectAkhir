package com.kesehatan.klinikhusada.Rest;
import com.kesehatan.klinikhusada.Model.GetPasien;
import com.kesehatan.klinikhusada.Model.PostPutDelPasien;
import com.kesehatan.klinikhusada.Model.PostUser;
import com.kesehatan.klinikhusada.apihelper.response.AntrianListResponse;
import com.kesehatan.klinikhusada.apihelper.response.ItemListResponse;
import com.kesehatan.klinikhusada.apihelper.response.StatusResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {
    @GET("pendaftaran")
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

    @FormUrlEncoded
    @POST("pendaftaran")
    Call<StatusResponse> postItem(@Field("keluhan") String keluhan,
                                  @Field("jenis_kunjungan") String jenis_kunjungan,
                                  @Field("poli") String poli,
                                  @Field("no_rm") String no_rm);

    @GET("pendaftaran")
    Call<ItemListResponse> getItem();

    @GET("pendaftarana")
    Call<ItemListResponse> getItema();

    @GET("pendaftaranb")
    Call<ItemListResponse> getItemb();

    @GET("pendaftaranc")
    Call<ItemListResponse> getItemc();

    @GET("antrian")
    Call<AntrianListResponse> getAntrian();

    @FormUrlEncoded
    @POST("Datapasien")
    Call<PostUser> postRegis(@Field("username") String username,
                             @Field("password") String password,
                             @Field("email") String email,
                             @Field("no_rm") String no_rm);
}
