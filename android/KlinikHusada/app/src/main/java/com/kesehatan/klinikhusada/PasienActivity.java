package com.kesehatan.klinikhusada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.kesehatan.klinikhusada.PasienAdapter;
import com.kesehatan.klinikhusada.Model.GetPasien;
import com.kesehatan.klinikhusada.Model.Pasien;
import com.kesehatan.klinikhusada.Rest.ApiInterface;
import com.kesehatan.klinikhusada.Rest.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class PasienActivity extends AppCompatActivity {
    Button btIns;
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static PasienActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasien);


    btIns = (Button) findViewById(R.id.btIns);
        btIns.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(PasienActivity.this, InsertActivity.class));
        }
    });
    mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
    mApiInterface = (ApiInterface) ApiClient.getClient().create(ApiInterface.class);
    ma=this;
    refresh();
}

    public void refresh() {
        Call<GetPasien> pasienCall = mApiInterface.getPasien();
        pasienCall.enqueue(new Callback<GetPasien>() {
            @Override
            public void onResponse(Call<GetPasien> call, Response<GetPasien>
                    response) {
                List<Pasien> KontakList = response.body().getListDataPasien();
                Log.d("Retrofit Get", "Jumlah data Kontak: " +
                        String.valueOf(KontakList.size()));
                mAdapter = new PasienAdapter(KontakList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetPasien> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}
