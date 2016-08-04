package com.example.user.thursdayam;

import android.app.Activity;
import android.os.Looper;
import android.support.annotation.NonNull;

import com.example.user.thursdayam.onNetworkResponseListener;

import org.json.JSONObject;

import java.io.IOException;
import java.util.logging.Handler;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by dilky on 2016-08-03.
 * 공통 통신 모듈
 */
public class CommNetwork {

    /**
     * API KEY
     */
    private String apiKey;

    /**
     * 입력 파라미터
     */
    private JSONObject inputObject;

    /**
     * HttpRequest 통신 객체
     */
    private final OkHttpClient client = new OkHttpClient();

    private Activity activity;
    private onNetworkResponseListener listener;
    public CommNetwork(@NonNull Activity atvt, @NonNull onNetworkResponseListener i) {
        activity = atvt;
        listener = i;
    }



    public void requestToServer(String api_key, JSONObject requestObject) throws Exception {
        apiKey = api_key;
        inputObject = new JSONObject();
        inputObject.put("API_KEY", apiKey);
        inputObject.put("REQ_DATA", requestObject);

        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    request();
                }
            });
        } else {
            // TODO : 화면이 없는 경우
        }
    }


    private void request() {

        Request request = new Request.Builder()
                .url("http://61.84.24.77:8888/daelim2016/gateway.jsp?json_data=" + inputObject.toString())
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(Call call, final IOException e) {
                //결과를 mainThread로 전송한다.
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (listener != null) {
                            listener.onFailure(apiKey, "T999", e.getMessage());
                        }
                    }
                });
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                //결과를 mainThread로 전송한다.
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (!response.isSuccessful()) {
                            if (listener != null) {
                                listener.onFailure(apiKey, String.valueOf(response.code()), response.message());
                            }
                            return;
                        }

                        //Headers responseHeaders = response.headers();
                        //for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                        //    System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                        //}

                        //
                        // 응답에 성공한 경우
                        //
                        if (listener != null) {
                            try {
                                JSONObject outputObject = new JSONObject(response.body().string());
                                if (!outputObject.has("RESP_DATA") || outputObject.isNull("RESP_DATA")) {
                                    listener.onFailure(apiKey, "1000", "응답부가 존재하지 않습니다.");
                                    return;
                                }
                                listener.onSuccess(apiKey, outputObject.getJSONObject("RESP_DATA"));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }
        });
    }

}
