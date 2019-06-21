package com.kesehatan.klinikhusada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class PendaftaranPasien extends AppCompatActivity {

    Spinner poli;
    EditText error, error2;
    TextView nyimpen;
    int nilaipoli = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran_pasien);

        poli = findViewById(R.id.poli);
        error = findViewById(R.id.pass);
        error2 = findViewById(R.id.pass1);
        nyimpen = findViewById(R.id.nyimpendata);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        poli.setAdapter(adapter);
    }


    public void daftarpasien(View view) {
        if (poli.getSelectedItem().toString().trim().equals("Poli Mata")){
            nyimpen.setText("0");
        } else if (poli.getSelectedItem().toString().trim().equals("Poli Paru")){
            nyimpen.setText("1");
        } else if (poli.getSelectedItem().toString().trim().equals("Poli Saraf")){
            nyimpen.setText("2");
        } else if (poli.getSelectedItem().toString().trim().equals("Poli Bedah")){
            nyimpen.setText("3");
        } else {
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT);
        }
        String errors = nyimpen.getText().toString();
        error2.setText(errors);
    }
}
