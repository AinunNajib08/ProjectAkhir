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
import android.widget.Toast;

import com.kesehatan.klinikhusada.apihelper.BaseApiService;
import com.kesehatan.klinikhusada.apihelper.UtilsApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityLogin extends AppCompatActivity {

    EditText username, password;
    Button btnlogin;
    Context mcontext;
    BaseApiService mbaseApiService;
    ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mcontext = this;
        mbaseApiService = UtilsApi.getAPIService();
        initComponents();
    }

    public void initComponents(){

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        btnlogin = (Button) findViewById(R.id.buttonlog);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading = ProgressDialog.show(mcontext,null , "Harap Tunggu ...", true, false);
                requestLogin();
            }
        });
    }

    public void requestLogin(){

            mbaseApiService.loginRequest(username.getText().toString(), password.getText().toString())
                    .enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            if (response.isSuccessful()){
                                loading.dismiss();
                                try {
                                    JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                    if (jsonRESULTS.getString("error").equals("false")){
                                        // Jika login berhasil maka data nama yang ada di response API
                                        // akan diparsing ke activity selanjutnya.
                                        Toast.makeText(mcontext, "BERHASIL LOGIN", Toast.LENGTH_SHORT).show();
                                        String nama = jsonRESULTS.getJSONObject("user").getString("nama");
                                        Intent intent = new Intent(mcontext, MainActivity.class);
                                        intent.putExtra("result_nama", nama);
                                        startActivity(intent);
                                    } else {
                                        // Jika login gagal
                                        String error_message = jsonRESULTS.getString("error_msg");
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


    public void daftar(View view) {
    }

    public void lupapassword(View view) {
    }
}
