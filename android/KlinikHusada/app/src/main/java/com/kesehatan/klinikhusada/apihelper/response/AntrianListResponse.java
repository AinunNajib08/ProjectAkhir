package com.kesehatan.klinikhusada.apihelper.response;

import com.kesehatan.klinikhusada.Model.Antrian;

import java.util.List;

/**
 * Created by Mahmudinm on 20/12/2018.
 */

public class AntrianListResponse {

    private String message;
    List<Antrian> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Antrian> getDataSis() {
        return data;
    }

    public void setData(List<Antrian> data) {
        this.data = data;
    }
}
