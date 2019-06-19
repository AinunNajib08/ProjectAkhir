package com.kesehatan.klinikhusada.Model;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kesehatan.klinikhusada.R;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public class ApiInterface extends AppCompatActivity {
    @GET("pasien_android")
    Call<GetPasien> getPasien() {
        return null;
    }

    @FormUrlEncoded
    @POST("pasien")
    Call<PostPutDelPasien> postPasien(@Field("nama_pasien") String nama_pasien,
                                      @Field("usia") String usia) {
        return null;
    }

    @FormUrlEncoded
    @PUT("pasien")
    Call<PostPutDelPasien> putPasien(@Field("no_rm") String no_rm,
                                     @Field("nama_pasien") String nama_pasien,
                                     @Field("usia") String usia) {
        return null;
    }

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "pasien", hasBody = true)
    Call<PostPutDelPasien> deletePasien(@Field("no_rm") String no_rm) {
        return null;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_interface);
    }
}
