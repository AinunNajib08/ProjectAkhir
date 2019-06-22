package com.kesehatan.klinikhusada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kesehatan.klinikhusada.Model.PostPutDelPasien;
import com.kesehatan.klinikhusada.Rest.ApiClient;
import com.kesehatan.klinikhusada.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditActivity extends AppCompatActivity {

    EditText editNo_rm, editNama_pasien, editUsia;
    Button btUpdate, btDelete, btBack;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        editNo_rm = (EditText) findViewById(R.id.edtId);
        editNama_pasien = (EditText) findViewById(R.id.edtNama);
        editUsia = (EditText) findViewById(R.id.edtNomor);
        Intent mIntent = getIntent();
        editNo_rm.setText(mIntent.getStringExtra("Id"));
        editNo_rm.setTag(editNo_rm.getKeyListener());
        editNo_rm.setKeyListener(null);
        editNama_pasien.setText(mIntent.getStringExtra("Nama Pasien"));
        editUsia.setText(mIntent.getStringExtra("Usia"));
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btUpdate = (Button) findViewById(R.id.btUpdate2);
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelPasien> updatePasienCall = mApiInterface.putpasien(
                        editNo_rm.getText().toString(),
                        editNama_pasien.getText().toString(),
                        editUsia.getText().toString());
                updatePasienCall.enqueue(new Callback<PostPutDelPasien>() {
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
        btDelete = (Button) findViewById(R.id.btDelete2);
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editNo_rm.getText().toString().trim().isEmpty()==false){
                    Call<PostPutDelPasien> deleteKontak = mApiInterface.deletePasien(editNo_rm.getText().toString());
                    deleteKontak.enqueue(new Callback<PostPutDelPasien>() {
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
                }else{
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
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
