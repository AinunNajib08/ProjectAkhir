package com.kesehatan.klinikhusada;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kesehatan.klinikhusada.apihelper.BaseApiService;
import com.kesehatan.klinikhusada.apihelper.UtilsApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityRegis extends AppCompatActivity {

    EditText no_rm, tanggal;
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    Button btnlogin;
    Context mcontext;
    BaseApiService mbaseApiService;
    ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);

        no_rm = (EditText) findViewById(R.id.no_rm);
        tanggal = (EditText) findViewById(R.id.tgl);
        btnlogin = (Button) findViewById(R.id.buttonlog);

        mcontext = this;
        mbaseApiService = UtilsApi.getAPIService();
        initComponents();

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        tanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
            }
        });

    }

    public void initComponents(){



        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading = ProgressDialog.show(mcontext,null , "Harap Tunggu ...", true, false);
                requestLogin();
            }
        });
    }

    private void showDateDialog(){
        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                tanggal.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }

    public void requestLogin(){

            mbaseApiService.loginRequest(no_rm.getText().toString(), tanggal.getText().toString())
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

                                            int id = jsonObject.getInt("id_akun");
                                            String nama = jsonObject.getString("username");
                                            Toast.makeText(mcontext, "BERHASIL LOGIN", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(mcontext, ActivityDashboard.class);
                                            intent.putExtra("hasil_nama", nama);
                                            startActivity(intent);
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


    public void daftar(View view) {
    }

    public void lupapassword(View view) {
    }
}
