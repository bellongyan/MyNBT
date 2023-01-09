package com.example.mynbt;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import java.io.IOException;
import java.util.Objects;

import com.example.mynbt.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ClassTableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_table);

//        教务系统对应url
        String url = "";

        final WebView tableClass = findViewById(R.id.classTable);

        OkHttpClient client = new OkHttpClient();

//        对应的请求头
        Request request = new Request.Builder()
                .url(url)
                .addHeader("User-Agent", "")
                .addHeader("Cookie", "")
                .addHeader("Referer", "")
                .addHeader("Host", "")
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String myResponse = Objects.requireNonNull(response.body()).string();
                ClassTableActivity.this.runOnUiThread(() -> {
                    tableClass.loadDataWithBaseURL(null, myResponse.toString(), "text/html", "utf-8", null);
                });
            }
        });
    }
}