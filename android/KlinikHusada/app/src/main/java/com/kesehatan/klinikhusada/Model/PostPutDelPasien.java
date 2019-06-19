package com.kesehatan.klinikhusada.Model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.google.gson.annotations.SerializedName;
import com.kesehatan.klinikhusada.R;

public class PostPutDelPasien extends AppCompatActivity {
    public class PostPutDelKontak {
        @SerializedName("no_rm")
        String status;
        @SerializedName("nama_pasien")
        Pasien mPasien;
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
        public Pasien getKontak() {
            return mPasien;
        }
        public void setKontak(Pasien Pasien) {
            mPasien = Pasien;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_put_del_pasien);
    }
}
