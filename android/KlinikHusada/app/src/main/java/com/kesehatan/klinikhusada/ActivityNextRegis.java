package com.kesehatan.klinikhusada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityNextRegis extends AppCompatActivity {

    public static final String EXTRA_NORM = "extra_norm";
    public static final String EXTRA_TGL = "extra_tgl";
    TextView datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_regis);

        datas = findViewById(R.id.no_rm);

        String data = getIntent().getStringExtra(EXTRA_NORM);
        String tgl = getIntent().getStringExtra(EXTRA_TGL);

        datas.setText(tgl);
    }

    public void Simpan(View view) {

    }
}
