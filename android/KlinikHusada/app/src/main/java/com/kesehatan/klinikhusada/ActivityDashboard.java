package com.kesehatan.klinikhusada;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kesehatan.klinikhusada.utils.SharedPrefManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityDashboard extends AppCompatActivity {

//    @BindView(R.id.tvResultNama)
//    TextView tvResultNama;
//    @BindView(R.id.btnLogout)
//    Button btnLogout;
//    @BindView(R.id.btnLihatDosen)
//    Button btnLihatDosen;
//    @BindView(R.id.btnLihatMatkul)
//    Button btnLihatMatkul;
//
//    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);

        BottomNavigationView navView = findViewById(R.id.nav_menu);
        navView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_cointainer,
                new DashboardFragment()).commit();
//        ButterKnife.bind(this);
//        sharedPrefManager = new SharedPrefManager(this);
//
//        String namasaya = sharedPrefManager.getSpUsernama();
//
//        tvResultNama.setText(namasaya);
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
    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()){
                        case R.id.navigation_dashboard:
                            selectedFragment = new DashboardFragment();
                            break;
                        case R.id.navigation_profile:
                            selectedFragment = new ProfileFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_cointainer,
                            selectedFragment).commit();

                    return true;
                }
            };
}
