package com.kesehatan.klinikhusada.Model;

import com.google.gson.annotations.SerializedName;

public class Pasien {



    @SerializedName("no_rm")
    private String no_rm;
    @SerializedName("nama_pasien")
    private String nama_pasien;
    @SerializedName("usia")
    private String usia;

    public Pasien(){}

    public Pasien(String no_rm, String nama_pasien, String usia) {
        this.no_rm = no_rm;
        this.nama_pasien = nama_pasien;
        this.usia = usia;
    }
    public String getNo_rm() {
        return no_rm;
    }

    public void setNo_rm(String no_rm) {
        this.no_rm = no_rm;
    }

    public String getNama_pasien() {
        return nama_pasien;
    }

    public void setNama_pasien(String nama_pasien) {
        this.nama_pasien = nama_pasien;
    }

    public String getUsia() {
        return usia;
    }

    public void setUsia(String usia) {
        this.usia = usia;
    }

}
