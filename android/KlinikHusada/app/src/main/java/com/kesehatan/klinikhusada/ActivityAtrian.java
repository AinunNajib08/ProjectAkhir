package com.kesehatan.klinikhusada;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.kesehatan.klinikhusada.Model.Item;
import com.kesehatan.klinikhusada.Rest.ApiClient;
import com.kesehatan.klinikhusada.Rest.ApiInterface;
import com.kesehatan.klinikhusada.adapter.AdapterItem;
import com.kesehatan.klinikhusada.apihelper.BaseApiService;
import com.kesehatan.klinikhusada.apihelper.UtilsApi;
import com.kesehatan.klinikhusada.apihelper.response.ItemListResponse;
import com.kesehatan.klinikhusada.utils.RecyclerItemClickListener;
import com.kesehatan.klinikhusada.utils.SharedPrefManager;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityAtrian extends AppCompatActivity {

    private RecyclerView mRecycler;
    private AdapterItem mAdapter;
    private RecyclerView.LayoutManager mManager;
    private List<Item> mItems = new ArrayList<>();
    ProgressDialog progressDialog;

    private static final int REQUEST_CODE_EDIT = 2;

    private static final String TAG = "DemoActivity";
    private SlidingUpPanelLayout mLayout;

    private long   mTimeLeftInMillis;

    BaseApiService mbaseApiService;
    ProgressDialog loading;
    Context mcontext;
    SharedPrefManager sharedPrefManager;
    TextView tvAntrian, tvTime;

    public ActivityAtrian() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atrian);

        tvAntrian = findViewById(R.id.no_antrian);
        mbaseApiService = UtilsApi.getAPIService();
        loading = new ProgressDialog(ActivityAtrian.this);
        mcontext = this;

        progressDialog = new ProgressDialog(ActivityAtrian.this);
        sharedPrefManager = new SharedPrefManager(this);
        tvTime = findViewById(R.id.time);
        NgampilData();

        mRecycler = findViewById(R.id.itemRecycler);
        mManager = new LinearLayoutManager(ActivityAtrian.this, LinearLayoutManager.VERTICAL, false);
        mRecycler.setLayoutManager(mManager);
        load();


        mLayout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        mLayout.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
                Log.i(TAG, "onPanelSlide, offset " + slideOffset);
            }

            @Override
            public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {
                Log.i(TAG, "onPanelStateChanged " + newState);
            }
        });
        mLayout.setFadeOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
            }
        });

        TextView t = findViewById(R.id.name);
        t.setText(Html.fromHtml(getString(R.string.hello)));
        Button f = findViewById(R.id.follow);
        f.setText(Html.fromHtml(getString(R.string.follow)));
        f.setMovementMethod(LinkMovementMethod.getInstance());
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://www.twitter.com/umanoapp"));
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.demo, menu);
        MenuItem item = menu.findItem(R.id.action_toggle);
        if (mLayout != null) {
            if (mLayout.getPanelState() == SlidingUpPanelLayout.PanelState.HIDDEN) {
                item.setTitle(R.string.action_show);
            } else {
                item.setTitle(R.string.action_hide);
            }
        }
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_toggle: {
                if (mLayout != null) {
                    if (mLayout.getPanelState() != SlidingUpPanelLayout.PanelState.HIDDEN) {
                        mLayout.setPanelState(SlidingUpPanelLayout.PanelState.HIDDEN);
                        item.setTitle(R.string.action_show);
                    } else {
                        mLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
                        item.setTitle(R.string.action_hide);
                    }
                }
                return true;
            }
            case R.id.action_anchor: {
                if (mLayout != null) {
                    if (mLayout.getAnchorPoint() == 1.0f) {
                        mLayout.setAnchorPoint(0.7f);
                        mLayout.setPanelState(SlidingUpPanelLayout.PanelState.ANCHORED);
                        item.setTitle(R.string.action_anchor_disable);
                    } else {
                        mLayout.setAnchorPoint(1.0f);
                        mLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
                        item.setTitle(R.string.action_anchor_enable);
                    }
                }
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (mLayout != null &&
                (mLayout.getPanelState() == SlidingUpPanelLayout.PanelState.EXPANDED || mLayout.getPanelState() == SlidingUpPanelLayout.PanelState.ANCHORED)) {
            mLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
        } else {
            super.onBackPressed();
        }
    }

    public void NgampilData(){

        String keluhan = sharedPrefManager.getSpKeluhan();
        String poli = sharedPrefManager.getSpKeluhan();
        String no_rm = sharedPrefManager.getSpNoRm();
        loading = ProgressDialog.show(mcontext,null , "Harap Tunggu ...", true, false);
        mbaseApiService.getAntrian(keluhan, poli, no_rm)
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
                                        String waktu = jsonObject.getString("estimasi");
                                        String antrian = jsonObject.getString("no_antrian");
                                        int gae = Integer.parseInt(waktu);
                                        mTimeLeftInMillis = gae;
                                        tvAntrian.setText(antrian);
                                        Timer();

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

    public void Timer(){

        CountDownTimer timer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(final long millSecondsLeftToFinish) {
                mTimeLeftInMillis = millSecondsLeftToFinish;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                tvTime.setText("Silahkan Datang");
            }
        };
        timer.start();
    }

    private void updateCountDownText() {
        int hour = (int) (mTimeLeftInMillis / 1000) / 3600;
        int minutes = (int) ((mTimeLeftInMillis / 1000) / 60) % 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d:%02d", hour, minutes, seconds);

        tvTime.setText(timeLeftFormatted);
    }

    private void load() {
        progressDialog.setMessage("Loading ...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        ApiInterface api = ApiClient.getClient().create(ApiInterface.class);
        Call<ItemListResponse> getItem = api.getItem();
        getItem.enqueue(new Callback<ItemListResponse>() {
            @Override
            public void onResponse(Call<ItemListResponse> call, Response<ItemListResponse> response) {
                progressDialog.hide();
                Log.d("Response", "onResponse: " + response.body().getData());

                mItems = response.body().getData();

                mAdapter = new AdapterItem(mItems);
                mRecycler.setAdapter(mAdapter);
                mRecycler.addOnItemTouchListener(new RecyclerItemClickListener(ActivityAtrian.this, new
                        RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Item item = mAdapter.getItem(position);
                                Intent intent = new Intent(ActivityAtrian.this, PendaftaranPasien.class);
                                intent.putExtra("item", item);
                                startActivityForResult(intent, REQUEST_CODE_EDIT);
                            }
                        }));

                mAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ItemListResponse> call, Throwable t) {
                progressDialog.hide();
                Toast.makeText(ActivityAtrian.this, "gagal ambil data", Toast.LENGTH_SHORT).show();


            }
        });


    }
}


