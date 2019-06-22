package com.kesehatan.klinikhusada.Model;

import java.io.Serializable;

/**
 * Created by Mahmudinm on 20/12/2018.
 */

public class Item implements Serializable {

    String id_kunjungan;
    String keluhan;
    String jenis_kunjugan;
    String poli;

    public String getId_kunjungan() {
        return id_kunjungan;
    }

    public void setId_kunjungan(String id_kunjungan) {
        this.id_kunjungan = id_kunjungan;
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
