package com.kesehatan.klinikhusada;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.kesehatan.klinikhusada.Model.Item;
import com.kesehatan.klinikhusada.Rest.ApiClient;
import com.kesehatan.klinikhusada.Rest.ApiInterface;
import com.kesehatan.klinikhusada.adapter.AdapterItem;
import com.kesehatan.klinikhusada.apihelper.response.ItemListResponse;
import com.kesehatan.klinikhusada.utils.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityAtrianb extends AppCompatActivity {

    //CountUP

    private TextView mTextViewCountDown;

    private CountDownTimer mCountDownTimer;

    private boolean mTimerRunning;

    private long mTimeLeftInMillis;
    private long mEndTime;

    //Insert

    private RecyclerView mRecycler;
    private AdapterItem mAdapter;
    private RecyclerView.LayoutManager mManager;
    private List<Item> mItems = new ArrayList<>();
    ProgressDialog progressDialog;

    private static final int REQUEST_CODE_ADD = 1;
    private static final int REQUEST_CODE_EDIT = 2;

    public ActivityAtrianb() {
        // Required empty public constructor
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atrianb);

        //CountUP

        mTextViewCountDown = findViewById(R.id.text_view_countdown);


        progressDialog = new ProgressDialog(ActivityAtrianb.this);
        mRecycler = findViewById(R.id.itemRecycler);
        mManager = new LinearLayoutManager(ActivityAtrianb.this, LinearLayoutManager.VERTICAL, false);
        mRecycler.setLayoutManager(mManager);

        load();
    }

    private void load() {
        progressDialog.setMessage("Loading ...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        ApiInterface api = ApiClient.getClient().create(ApiInterface.class);
        Call<ItemListResponse> getItem = api.getItemb();
        getItem.enqueue(new Callback<ItemListResponse>() {
            @Override
            public void onResponse(Call<ItemListResponse> call, Response<ItemListResponse> response) {
                progressDialog.hide();
                Log.d("Response", "onResponse: " + response.body().getData());

                Toast.makeText(ActivityAtrianb.this, "berhasil ambil data", Toast.LENGTH_SHORT).show();

                mItems = response.body().getData();

                mAdapter = new AdapterItem(mItems);
                mRecycler.setAdapter(mAdapter);
                mRecycler.addOnItemTouchListener(new RecyclerItemClickListener(ActivityAtrianb.this, new
                        RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Item item = mAdapter.getItem(position);
                                Intent intent = new Intent(ActivityAtrianb.this, PendaftaranPasien.class);
                                intent.putExtra("item", item);
                                startActivityForResult(intent, REQUEST_CODE_EDIT);
                            }
                        }));

                mAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ItemListResponse> call, Throwable t) {
                progressDialog.hide();
                Toast.makeText(ActivityAtrianb.this, "gagal ambil data", Toast.LENGTH_SHORT).show();


            }
        });


    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CODE_ADD: {
                if (resultCode == RESULT_OK && null != data) {
                    if (data.getStringExtra("refreshFlag").equals("1")) {
                        load();
                    }
                }
                break;
            }
            case REQUEST_CODE_EDIT: {
                if (resultCode == RESULT_OK && null != data) {
                    if (data.getStringExtra("refreshFlag").equals("1")) {
                        load();
                    }
                }
                break;
            }
        }
    }
}
