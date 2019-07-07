package com.kesehatan.klinikhusada.Model;

import java.io.Serializable;

/**
 * Created by Mahmudinm on 20/12/2018.
 */

public class Item implements Serializable {
    String nama_pasien;

    public String getNama_pasien() {
        return nama_pasien;
    }

    public void setNama_pasien(String nama_pasien) {
        this.nama_pasien = nama_pasien;
    }

    String no_antrian;
    String keluhan;
    String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    String jenis_kunjugan;
    String poli;

    public String getId_kunjungan() {
        return no_antrian;
    }

    public void setId_kunjungan(String no_antrian) {
        this.no_antrian = no_antrian;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public String getJenis_kunjugan() {
        return jenis_kunjugan;
    }

    public void setJenis_kunjugan(String jenis_kunjugan) {
        this.jenis_kunjugan = jenis_kunjugan;
    }

    public String getPoli() {
        return poli;
    }

    public void setPoli(String poli) {
        this.poli = poli;
    }

    public String getNo_rm() {
        return no_rm;
    }

    public void setNo_rm(String no_rm) {
        this.no_rm = no_rm;
    }

    String no_rm;
}
