package com.kesehatan.klinikhusada;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.kesehatan.klinikhusada.Model.PostUser;
import com.kesehatan.klinikhusada.Rest.ApiClient;
import com.kesehatan.klinikhusada.Rest.ApiInterface;
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
    ApiInterface mApiInterface;
    ProgressDialog loading;
    Context mcontext;
    Button btnlog;
    public static final String EXTRA_NORM = "extra_norm";
    public static final String EXTRA_TGL = "extra_tgl";
    Random r = new Random();
    int i1 = (r.nextInt(999999));
    TextView unique, usernamev, passwordv, emailv, no_rmv;
    EditText verifikasi, pass, pass1, user, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_regis);

        unique = findViewById(R.id.uniq);
        verifikasi = findViewById(R.id.verif);
        pass = findViewById(R.id.pass);
        pass1 = findViewById(R.id.pass1);
        btnlog = findViewById(R.id.buttonlog);
        user = findViewById(R.id.user);
        usernamev = findViewById(R.id.usernamev);
        email = findViewById(R.id.email);

        unique.setText(""+i1);

        initComponents();
    }

    public void Simpan(View view) {



    }

    public void initComponents(){
        mbaseApiService = UtilsApi.getAPIService();
        loading = new ProgressDialog(ActivityNextRegis.this);
        mcontext = this;


        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(email.getText())) {
                    email.setError("Silahkan Masukan Email Anda !");
                }
                if (TextUtils.isEmpty(user.getText())) {
                    user.setError("Silahkan Masukan User Anda !");
                }
                if (pass.getText().toString().equals(pass1.getText().toString())) {
                    if (verifikasi.getText().toString().equals("" + i1)) {
                        requestLogin();
                    } else {
                        verifikasi.setError( "Kode Verifikasi Anda Salah !" );
                    }
                } else {
                    pass1.setError( "Password anda Tidak Sama !" );
                }
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
                                        usernamev.setText("" + no_rm);
                                        SaveData();
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

    public void SaveData(){
        mbaseApiService = UtilsApi.getAPIService();
        mbaseApiService.regisRequest(user.getText().toString(), pass.getText().toString(), email.getText().toString(),
                usernamev.getText().toString())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            Log.i("debug", "onResponse: BERHASIL");
                            loading.dismiss();
                            try {
                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                if (jsonRESULTS.getString("status").equals("true")){
                                    Toast.makeText(mcontext, "BERHASIL REGISTRASI", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(mcontext, ActivityLogin.class));
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
                            Log.i("debug", "onResponse: GA BERHASIL");
                            loading.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.getMessage());
                        Toast.makeText(mcontext, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
                    }
                });

    }

}
