package com.kesehatan.klinikhusada;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.kesehatan.klinikhusada.Model.Antrian;
import com.kesehatan.klinikhusada.Rest.ApiClient;
import com.kesehatan.klinikhusada.Rest.ApiInterface;
import com.kesehatan.klinikhusada.adapter.AdapterItem;
import com.kesehatan.klinikhusada.apihelper.response.AntrianListResponse;
import com.kesehatan.klinikhusada.apihelper.response.ItemListResponse;
import com.kesehatan.klinikhusada.apihelper.response.StatusResponse;
import com.kesehatan.klinikhusada.utils.RecyclerItemClickListener;
import com.kesehatan.klinikhusada.utils.SharedPrefManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PendaftaranPasien extends AppCompatActivity {

    Spinner poli;
    EditText error, error2;
    TextView nyimpen;
    int nilaipoli = 0;
    ProgressDialog progressDialog;
    SharedPrefManager sharedPrefManager;
    private List<Antrian> mItems = new ArrayList<>();
    private RecyclerView mRecycler;
    private AdapterItem mAdapter;
    private RecyclerView.LayoutManager mManager;

    private String refreshFlag = "0";
    String id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran_pasien);

        poli = findViewById(R.id.poli);
        error = findViewById(R.id.pass);
        error2 = findViewById(R.id.pass1);
        nyimpen = findViewById(R.id.nyimpendata);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        poli.setAdapter(adapter);
        load();

        //Insert Data
        progressDialog = new ProgressDialog(this);


    }


    public void daftarpasien(View view) {

        if( TextUtils.isEmpty(error.getText())){
            /**
             *   You can Toast a message here that the Username is Empty
             **/

            error.setError( "Silahkan Masukan Keluhan Anda !" );

        }else {

            if (poli.getSelectedItem().toString().trim().equals("Poli Umum")) {
                nyimpen.setText("0");
            } else if (poli.getSelectedItem().toString().trim().equals("Poli Ibu dan Anak")) {
                nyimpen.setText("1");
            } else if (poli.getSelectedItem().toString().trim().equals("Poli Gigi")) {
                nyimpen.setText("2");
            } else if (poli.getSelectedItem().toString().trim().equals("Poli Mata")) {
                nyimpen.setText("3");
            } else {
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT);
            }
            String errors = nyimpen.getText().toString();

            progressDialog.setMessage("Loading ...");
            progressDialog.setCancelable(false);
            progressDialog.show();

            refreshFlag = "1";



            sharedPrefManager = new SharedPrefManager(this);
            String no_rm = sharedPrefManager.getSpNoRm();
            String keluhan = error.getText().toString();
            String jenis_kunjungan = error2.getText().toString();
            String poli = nyimpen.getText().toString();
            ApiInterface api = ApiClient.getClient().create(ApiInterface.class);
            Call<StatusResponse> postItem = api.postItem(keluhan, jenis_kunjungan, poli, no_rm);
            postItem.enqueue(new Callback<StatusResponse>() {
                @Override
                public void onResponse(Call<StatusResponse> call, Response<StatusResponse> response) {
                    progressDialog.dismiss();
                    String status = response.body().getStatus();

                    if (status.equals("success")) {
                        String keluhan = error.getText().toString();
                        String jenis_kunjungan = error2.getText().toString();
                        String poli = nyimpen.getText().toString();
                        sharedPrefManager.saveSPString(SharedPrefManager.SP_POLI, poli);
                        sharedPrefManager.saveSPString(SharedPrefManager.SP_KELUHAN, keluhan);
                        Toast.makeText(PendaftaranPasien.this, "Terimakasih Sudah Mendaftar", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(PendaftaranPasien.this, "Anda Sudah Mencapai Limit Pendaftaran", Toast
                                .LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onFailure(Call<StatusResponse> call, Throwable t) {
                    Log.e("debug", "onFailure: ERROR > " + t.toString());
                    progressDialog.dismiss();

                }
            });
        }
    }

    private void load() {
        ApiInterface api = ApiClient.getClient().create(ApiInterface.class);
        Call<AntrianListResponse> getAntrian = api.getAntrian();
        getAntrian.enqueue(new Callback<AntrianListResponse>() {
            @Override
            public void onResponse(Call<AntrianListResponse> call, Response<AntrianListResponse> response) {
                progressDialog.hide();
                Toast.makeText(PendaftaranPasien.this, "berhasil ambil data", Toast.LENGTH_SHORT).show();

            }


            @Override
            public void onFailure(Call<AntrianListResponse> call, Throwable t) {
                progressDialog.hide();
//                Toast.makeText(PendaftaranPasien.this, "gagal ambil data", Toast.LENGTH_SHORT).show();


            }
        });
    }

}
