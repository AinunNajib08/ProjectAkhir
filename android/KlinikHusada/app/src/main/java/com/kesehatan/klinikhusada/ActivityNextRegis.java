package com.kesehatan.klinikhusada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class ActivityNextRegis extends AppCompatActivity {

    public static final String EXTRA_NORM = "extra_norm";
    public static final String EXTRA_TGL = "extra_tgl";
    Random r = new Random();
    int i1 = (r.nextInt(999999));
    TextView unique;
    EditText verifikasi, pass, pass1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_regis);

        unique = findViewById(R.id.uniq);
        verifikasi = findViewById(R.id.verif);
        pass = findViewById(R.id.pass);
        pass1 = findViewById(R.id.pass1);

        unique.setText(""+i1);

        String data = getIntent().getStringExtra(EXTRA_NORM);
        String tgl = getIntent().getStringExtra(EXTRA_TGL);

    }

    public void Simpan(View view) {
        if (pass.getText().toString().isEmpty() || pass1.getText().toString().isEmpty()) {



        }
//            if (pass.getText().toString().equals(pass1.getText().toString())) {
//                if (verifikasi.getText().toString().equals("" + i1)) {
//                    Toast.makeText(getApplicationContext(), "Benar", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(getApplicationContext(), "Salah", Toast.LENGTH_SHORT).show();
//                    verifikasi.setText("" + i1);
//                }
//            } else {
//                Toast.makeText(getApplicationContext(), "Samakan Pass", Toast.LENGTH_SHORT).show();
//            }
//        } else {
//            Toast.makeText(getApplicationContext(), "Skuy", Toast.LENGTH_SHORT).show();
//        }



    }
}
