package com.kesehatan.klinikhusada.Model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;
    @SerializedName("email")
    private String email;
    @SerializedName("no_rm")
    private String no_rm;

    public User(){}

    public User(String username, String password, String email, String no_rm){
        this.username = username;
        this.password = password;
        this.email = email;
        this.no_rm = no_rm;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword (String password){
        this.password = password;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getNo_rm(){
        return no_rm;
    }

    public void setNo_rm(String no_rm){
        this.no_rm = no_rm;
    }


}
