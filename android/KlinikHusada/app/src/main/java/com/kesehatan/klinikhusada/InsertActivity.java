package com.kesehatan.klinikhusada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kesehatan.klinikhusada.Model.PostPutDelPasien;
import com.kesehatan.klinikhusada.Rest.ApiClient;
import com.kesehatan.klinikhusada.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class InsertActivity extends AppCompatActivity {
    EditText editNama_Pasien, editUsia;
    Button btInsert, btBack;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        editNama_Pasien = (EditText) findViewById(R.id.edtNama);
        editUsia = (EditText) findViewById(R.id.edtNomor);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btInsert = (Button) findViewById(R.id.btInserting);
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelPasien> postKontakCall = mApiInterface.postPasien(editNama_Pasien.getText().toString(), editUsia.getText().toString());
                postKontakCall.enqueue(new Callback<PostPutDelPasien>() {
                    @Override
                    public void onResponse(Call<PostPutDelPasien> call, Response<PostPutDelPasien> response) {
                        ActivityPasien.ma.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelPasien> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        btBack = (Button) findViewById(R.id.btBackGo);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityPasien.ma.refresh();
                finish();
            }
        });
    }
}
