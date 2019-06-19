package com.kesehatan.klinikhusada.Model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import com.kesehatan.klinikhusada.R;

public class GetPasien extends AppCompatActivity {
    @SerializedName("no_rm")
    String status;
    @SerializedName("nama_pasien")
    List<Pasien> listDataPasien;
    @SerializedName("usia")
    String message;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public List<Pasien> getListDataPasien() {
        return listDataPasien;
    }
    public void setListDataPasien(List<Pasien> listDataPasien) {
        this.listDataPasien = listDataPasien;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_pasien);
    }
}
