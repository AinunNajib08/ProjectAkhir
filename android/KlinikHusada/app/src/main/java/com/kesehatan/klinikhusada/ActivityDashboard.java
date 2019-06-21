package com.kesehatan.klinikhusada;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kesehatan.klinikhusada.utils.SharedPrefManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityDashboard extends AppCompatActivity {

    @BindView(R.id.tvResultNama)
    TextView tvResultNama;
//    @BindView(R.id.btnLogout)
//    Button btnLogout;
//    @BindView(R.id.btnLihatDosen)
//    Button btnLihatDosen;
//    @BindView(R.id.btnLihatMatkul)
//    Button btnLihatMatkul;
//
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        LinearLayout linearLayout = findViewById(R.id.linear3);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.bottomtoup);
        linearLayout.startAnimation(animation);

        LinearLayout linearLayout4 = findViewById(R.id.linear4);
        Animation animation4 = AnimationUtils.loadAnimation(this, R.anim.bottomtoup2);
        linearLayout4.startAnimation(animation4);
        ButterKnife.bind(this);
        sharedPrefManager = new SharedPrefManager(this);

        String namasaya = sharedPrefManager.getSpUsernama();

        tvResultNama.setText(namasaya);
//
//        btnLogout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, false);
//                startActivity(new Intent(ActivityDashboard.this, ActivityLogin.class)
//                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
//                finish();
//            }
//        });
//
//        btnLihatDosen.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(ActivityDashboard.this, MainActivity.class));
//            }
//        });
//
//        btnLihatMatkul.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(ActivityDashboard.this, MainActivity.class));
//            }
//        });
    }

    public void daftar(View view) {
        Intent intent = new Intent(ActivityDashboard.this, PendaftaranPasien.class);
        startActivity(intent);
    }
}
