package com.example.user.thursdayam;

import org.json.JSONObject;

/**
 * Created by user on 2016-08-04.*/
 public interface onNetworkResponseListener {
 void onSuccess(String api_key, JSONObject response);
 void onFailure(String api_key, String error_cd, String error_msg);
 }