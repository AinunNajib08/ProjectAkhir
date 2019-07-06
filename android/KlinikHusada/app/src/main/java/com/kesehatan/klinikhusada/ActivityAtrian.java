package com.kesehatan.klinikhusada;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
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
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityAtrian extends AppCompatActivity {

    private static final String TAG = "DemoActivity";
    private SlidingUpPanelLayout mLayout;
    private static final long START_TIME_IN_MILLIS = 600000;
    private TextView mTextViewCountDown;
    private Button mButtonStartPause;
    private Button mButtonReset;

    private CountDownTimer mCountDownTimer;

    private boolean mTimerRunning;

    private long mTimeLeftInMillis;
    private long mEndTime;

    //

    BaseApiService mbaseApiService;
    ApiInterface mApiInterface;
    ProgressDialog loading;
    Context mcontext;
    SharedPrefManager sharedPrefManager;

    private RecyclerView mRecycler;
    private AdapterItem mAdapter;
    private RecyclerView.LayoutManager mManager;
    private List<Item> mItems = new ArrayList<>();
    ProgressDialog progressDialog;

    private static final int REQUEST_CODE_ADD = 1;
    private static final int REQUEST_CODE_EDIT = 2;

    public ActivityAtrian() {
        // Required empty public constructor
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atrian);


        ListView lv = (ListView) findViewById(R.id.list);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ActivityAtrian.this, "onItemClick", Toast.LENGTH_SHORT).show();
            }
        });

        List<String> your_array_list = Arrays.asList(
                "This",
                "Is",
                "An",
                "Example",
                "ListView",
                "That",
                "You",
                "Can",
                "Scroll",
                ".",
                "It",
                "Shows",
                "How",
                "Any",
                "Scrollable",
                "View",
                "Can",
                "Be",
                "Included",
                "As",
                "A",
                "Child",
                "Of",
                "SlidingUpPanelLayout"
        );

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                your_array_list );

        lv.setAdapter(arrayAdapter);

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

        TextView t = (TextView) findViewById(R.id.name);
        t.setText(Html.fromHtml(getString(R.string.hello)));
        Button f = (Button) findViewById(R.id.follow);
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
                                        String antrian = jsonObject.getString("antran");

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


//        mbaseApiService = UtilsApi.getAPIService();
//        loading = new ProgressDialog(ActivityAtrian.this);
//        mcontext = this;
//
//        progressDialog = new ProgressDialog(ActivityAtrian.this);
//        mRecycler = findViewById(R.id.itemRecycler);
//        mTextViewCountDown = findViewById(R.id.text_view_countdown);
//        mButtonStartPause = findViewById(R.id.button_start_pause);
//        mButtonReset = findViewById(R.id.button_reset);
//        mManager = new LinearLayoutManager(ActivityAtrian.this, LinearLayoutManager.VERTICAL, false);
//        mRecycler.setLayoutManager(mManager);
//        sharedPrefManager = new SharedPrefManager(this);
//
//        load();
//        NgampilData();
//        if (mTimerRunning=true){
//            startTimer();
//        } else {
//            if (START_TIME_IN_MILLIS != 0){
//                resetTimer();
//                startTimer();
//            } else {
//                startTimer();
//            }
//        }
//
//        startTimer();
//        startTimer();
//
//        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mTimerRunning) {
//                    pauseTimer();
//                } else {
//                    startTimer();
//                }
//            }
//        });
//
//        mButtonReset.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                resetTimer();
//            }
//        });
    }

//    private void load() {
//        progressDialog.setMessage("Loading ...");
//        progressDialog.setCancelable(false);
//        progressDialog.show();
//
//        ApiInterface api = ApiClient.getClient().create(ApiInterface.class);
//        Call<ItemListResponse> getItem = api.getItem();
//        getItem.enqueue(new Callback<ItemListResponse>() {
//            @Override
//            public void onResponse(Call<ItemListResponse> call, Response<ItemListResponse> response) {
//                progressDialog.hide();
//                Log.d("Response", "onResponse: " + response.body().getData());
//
//                Toast.makeText(ActivityAtrian.this, "berhasil ambil data", Toast.LENGTH_SHORT).show();
//
//                mItems = response.body().getData();
//
//                mAdapter = new AdapterItem(mItems);
//                mRecycler.setAdapter(mAdapter);
//
//                mAdapter.notifyDataSetChanged();
//
//            }
//
//            @Override
//            public void onFailure(Call<ItemListResponse> call, Throwable t) {
//                progressDialog.hide();
//                Toast.makeText(ActivityAtrian.this, "gagal ambil data", Toast.LENGTH_SHORT).show();
//
//
//            }
//        });
//
//
//    }
//
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        switch (requestCode) {
//            case REQUEST_CODE_ADD: {
//                if (resultCode == RESULT_OK && null != data) {
//                    if (data.getStringExtra("refreshFlag").equals("1")) {
//                        load();
//                    }
//                }
//                break;
//            }
//            case REQUEST_CODE_EDIT: {
//                if (resultCode == RESULT_OK && null != data) {
//                    if (data.getStringExtra("refreshFlag").equals("1")) {
//                        load();
//                    }
//                }
//                break;
//            }
//        }
//    }
//
//    public void NgampilData(){
//
//        String keluhan = sharedPrefManager.getSpKeluhan();
//        String poli = sharedPrefManager.getSpKeluhan();
//        String no_rm = sharedPrefManager.getSpNoRm();
//        loading = ProgressDialog.show(mcontext,null , "Harap Tunggu ...", true, false);
//        mbaseApiService.getAntrian(keluhan, poli, no_rm)
//                .enqueue(new Callback<ResponseBody>() {
//                    @Override
//                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                        if (response.isSuccessful()){
//                            loading.dismiss();
//                            try {
//                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
//                                if (jsonRESULTS.getString("status").equals("true")){
//                                    JSONArray data = jsonRESULTS.getJSONArray("data");
//                                    for (int i=0; i <data.length(); i++) {
//                                        JSONObject jsonObject = data.getJSONObject(i);
//                                        String no_rm = jsonObject.getString("no_rm");
//                                    }
//
//                                } else {
//                                    String error_message = jsonRESULTS.getString("message");
//                                    Toast.makeText(mcontext, error_message, Toast.LENGTH_SHORT).show();
//                                }
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        } else {
//                            loading.dismiss();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseBody> call, Throwable t) {
//                        Log.e("debug", "onFailure: ERROR > " + t.toString());
//                        loading.dismiss();
//                    }
//                });
//    }
//
//    public void startTimer() {
//        mEndTime = System.currentTimeMillis() + mTimeLeftInMillis;
//
//        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//                mTimeLeftInMillis = millisUntilFinished;
//                updateCountDownText();
//            }
//
//            @Override
//            public void onFinish() {
//                mTimerRunning = false;
//                updateButtons();
//            }
//        }.start();
//
//        mTimerRunning = true;
//        updateButtons();
//    }
//
//    private void pauseTimer() {
//        mCountDownTimer.cancel();
//        mTimerRunning = false;
//        updateButtons();
//    }
//
//    public void resetTimer() {
//        mTimeLeftInMillis = START_TIME_IN_MILLIS;
//        updateCountDownText();
//        updateButtons();
//    }
//
//    private void updateCountDownText() {
//        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
//        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;
//
//        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
//
//        mTextViewCountDown.setText(timeLeftFormatted);
//    }
//
//    private void updateButtons() {
//        if (mTimerRunning) {
//            mButtonReset.setVisibility(View.INVISIBLE);
//            mButtonStartPause.setText("Pause");
//        } else {
//            mButtonStartPause.setText("Start");
//
//            if (mTimeLeftInMillis < 1000) {
//                mButtonStartPause.setVisibility(View.INVISIBLE);
//            } else {
//                mButtonStartPause.setVisibility(View.VISIBLE);
//            }
//
//            if (mTimeLeftInMillis < START_TIME_IN_MILLIS) {
//                mButtonReset.setVisibility(View.VISIBLE);
//            } else {
//                mButtonReset.setVisibility(View.INVISIBLE);
//            }
//        }
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//
//        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
//        SharedPreferences.Editor editor = prefs.edit();
//
//        editor.putLong("millisLeft", mTimeLeftInMillis);
//        editor.putBoolean("timerRunning", mTimerRunning);
//        editor.putLong("endTime", mEndTime);
//
//        editor.apply();
//
//        if (mCountDownTimer != null) {
//            mCountDownTimer.cancel();
//        }
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
//
//        mTimeLeftInMillis = prefs.getLong("millisLeft", START_TIME_IN_MILLIS);
//        mTimerRunning = prefs.getBoolean("timerRunning", false);
//
//        updateCountDownText();
//        updateButtons();
//
//        if (mTimerRunning) {
//            mEndTime = prefs.getLong("endTime", 0);
//            mTimeLeftInMillis = mEndTime - System.currentTimeMillis();
//
//            if (mTimeLeftInMillis < 0) {
//                mTimeLeftInMillis = 0;
//                mTimerRunning = false;
//                updateCountDownText();
//                updateButtons();
//            } else {
//                startTimer();
//            }
//        }
//    }


