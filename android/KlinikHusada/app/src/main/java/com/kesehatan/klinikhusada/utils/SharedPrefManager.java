package com.kesehatan.klinikhusada.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by fariz ramadhan.
 * website : www.farizdotid.com
 * github : https://github.com/farizdotid
 * linkedin : https://www.linkedin.com/in/farizramadhan/
 */


public class SharedPrefManager {

    public static final String SP_USER_PASIEN = "spUserPasien";

    public static final String SP_USERNAMA = "spUsername";
    public static final String SP_NO_RM = "spNorm";
    public static final String SP_EMAIL = "spEmail";
    public static final String SP_POLI = "spPoli";
    public static final String SP_KELUHAN = "spKeluhan";

    public static final String SP_SUDAH_LOGIN = "spSudahLogin";

    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public SharedPrefManager(Context context){
        sp = context.getSharedPreferences(SP_USER_PASIEN, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }

    public void saveSPString(String keySP, String value){
        spEditor.putString(keySP, value);
        spEditor.commit();
    }

    public void saveSPInt(String keySP, int value){
        spEditor.putInt(keySP, value);
        spEditor.commit();
    }

    public void saveSPBoolean(String keySP, boolean value){
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }

    public String getSpUsernama(){
        return sp.getString(SP_USERNAMA, "");
    }
    public String getSpNoRm(){
        return sp.getString(SP_NO_RM, "");
    }
    public String getSpPoli(){
        return sp.getString(SP_POLI, "");
    }
    public String getSpKeluhan(){
        return sp.getString(SP_KELUHAN, "");
    }

    public String getSPEmail(){
        return sp.getString(SP_EMAIL, "");
    }

    public Boolean getSPSudahLogin(){
        return sp.getBoolean(SP_SUDAH_LOGIN, false);
    }
}
