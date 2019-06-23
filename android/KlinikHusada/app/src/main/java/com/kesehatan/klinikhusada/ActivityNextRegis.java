package com.kesehatan.klinikhusada;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.kesehatan.klinikhusada.apihelper.BaseApiService;
import com.kesehatan.klinikhusada.apihelper.UtilsApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Random;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityNextRegis extends AppCompatActivity {
    BaseApiService mbaseApiService;
    ProgressDialog loading;
    Context mcontext;
    Button btnlog;
    public static final String EXTRA_NORM = "extra_norm";
    public static final String EXTRA_TGL = "extra_tgl";
    Random r = new Random();
    int i1 = (r.nextInt(999999));
    TextView unique;
    EditText verifikasi, pass, pass1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_regis);

        unique = findViewById(R.id.uniq);
        verifikasi = findViewById(R.id.verif);
        pass = findViewById(R.id.pass);
        pass1 = findViewById(R.id.pass1);
        btnlog = findViewById(R.id.buttonlog);

        unique.setText(""+i1);

        initComponents();
    }

    public void Simpan(View view) {

        if (pass.getText().toString().isEmpty() || pass1.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Skuy", Toast.LENGTH_SHORT).show();
        } else if (!pass.getText().toString().equals(pass1.getText().toString())){
            Toast.makeText(getApplicationContext(), "Samakan Pass", Toast.LENGTH_SHORT).show();
            requestLogin();
        } else if (verifikasi.getText().toString().equals("" + i1)){
            requestLogin();
        } else {
            Toast.makeText(getApplicationContext(), "Salah", Toast.LENGTH_SHORT).show();
            verifikasi.setText("" + i1);
        }

    }

    public void initComponents(){
        mbaseApiService = UtilsApi.getAPIService();
        loading = new ProgressDialog(ActivityNextRegis.this);
        mcontext = this;

        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestLogin();
            }
        });
    }

    public void requestLogin(){
        String no_rm = getIntent().getStringExtra(EXTRA_NORM);
        String tanggal_lahir = getIntent().getStringExtra(EXTRA_TGL);

        loading = ProgressDialog.show(mcontext,null , "Harap Tunggu ...", true, false);
        mbaseApiService.registerRequest(no_rm, tanggal_lahir)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            loading.dismiss();
                            try {
                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                if (jsonRESULTS.getString("status").equals("true")){
                                    JSONArray data = jsonRESULTS.getJSONArray("data");
                                    for (int i=0; i <data.length(); i++) {
                                        JSONObject jsonObject = data.getJSONObject(i);
                                        String no_rm = jsonObject.getString("no_rm");
                                        verifikasi.setText("" + no_rm);
                                        }

                                } else {
                                    String error_message = jsonRESULTS.getString("message");
                                    Toast.makeText(mcontext, error_message, Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            loading.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.toString());
                        loading.dismiss();
                    }
                });
    }

}
