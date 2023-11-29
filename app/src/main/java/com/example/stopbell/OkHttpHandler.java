package com.example.stopbell;

import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpHandler extends AsyncTask<String, Void, String> {
    OkHttpClient client = new OkHttpClient();

    @Override
    protected String doInBackground(String... params) {
        MediaType MEDIA_TYPE = MediaType.parse("application/json");
        String url = params[0];



        Request request = new Request.Builder()
                .url(url)

                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .build();

        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        // 결과 처리
    }
}

