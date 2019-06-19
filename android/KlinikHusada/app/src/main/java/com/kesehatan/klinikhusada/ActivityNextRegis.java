package com.kesehatan.klinikhusada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityNextRegis extends AppCompatActivity {

    public static final String EXTRA_NORM = "extra_norm";
    public static final String EXTRA_TGL = "extra_tgl";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_regis);
    }
}
