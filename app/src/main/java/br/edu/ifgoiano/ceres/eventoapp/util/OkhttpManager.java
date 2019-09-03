package br.edu.ifgoiano.ceres.eventoapp.util;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class OkhttpManager {
    public void getAsyncCall(String url, String[] headers, Callback callback) {
        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .addHeader(headers[0], headers[1])
                .url(url)
                .get()
                .build();

        httpClient.newCall(request).enqueue(callback);
    }

    public void postAsyncCall(String url, String[] headers, Callback callback, RequestBody requestBody) {
        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .addHeader(headers[0], headers[1])
                .url(url)
                .post(requestBody)
                .build();

        httpClient.newCall(request).enqueue(callback);
    }
}
