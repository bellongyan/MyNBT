package com.example.mynbt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mynbt.R;
import com.example.mynbt.tools.BaiduEncode;
import com.example.mynbt.tools.BaiduTranslate;
import com.example.mynbt.tools.YoudaoChineseSentenceTranslate;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class TranslateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);

        final EditText sentence = findViewById(R.id.sentenceInput);
        final Button zh2en = findViewById(R.id.search_zh2en);
        final Button en2zh = findViewById(R.id.search_en2zh);
        final TextView baiduOutput = findViewById(R.id.wordTranslatedByBaidu);
        final TextView youdaoOutput = findViewById(R.id.wordTranslatedByYoudao);

//        百度开发者平台申请的翻译 appid 和 pwd
        String appid = "";
        String pwd = "";


        // 有道数据处理
        String youdaoTransApiUrl = "https://aidemo.youdao.com/trans";
        HashMap<String, String> parmas = new HashMap<>();

        zh2en.setOnClickListener(v -> {

            Gson gson = new Gson();
            // 百度中翻英
            String word = sentence.getText().toString();

            BaiduEncode b = new BaiduEncode(appid, word, pwd);
            b.encodeMD5();
            try {
                b.encodeURL();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            String urlWord = b.getWord();

            String baiduTransApiUrl = "http://api.fanyi.baidu.com/api/trans/vip/translate?q=" + urlWord + "&from=zh&to=en&appid=" + appid + "&salt=" + b.getSalt() + "&sign=" + b.getMD5();

            OkHttpClient okHttpClient = new OkHttpClient();

            Request baiduTransRequest = new Request.Builder()
                    .url(baiduTransApiUrl)
                    .build();

            Call baiduTransCall = okHttpClient.newCall(baiduTransRequest);

            baiduTransCall.enqueue(new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    String myBaiduResp = Objects.requireNonNull(response.body()).string();

                    BaiduTranslate baidu = gson.fromJson(myBaiduResp, BaiduTranslate.class);

                    List<BaiduTranslate.TransResultBean> myBaiduTrans = baidu.getTrans_result();
                    if (myBaiduTrans != null) {
                        for (BaiduTranslate.TransResultBean i : myBaiduTrans) {
                            baiduOutput.setText(i.getDst());
                        }
                    } else {
                        baiduOutput.setText(baiduTransApiUrl);
                    }
                }
            });

            // 有道中翻英
            parmas.put("q", word);
            parmas.put("from", "Auto");
            parmas.put("to", "Auto");
            FormBody.Builder builder = new FormBody.Builder();
            for (String key : parmas.keySet()) {
                //追加表单信息
                builder.add(key, Objects.requireNonNull(parmas.get(key)));
            }
            OkHttpClient client = new OkHttpClient();
            RequestBody formBody = builder.build();

            Request youdaoTransRequest = new Request.Builder()
                    .url(youdaoTransApiUrl)
                    .post(formBody)
                    .build();
            Call youdaoTransCall = client.newCall(youdaoTransRequest);
            youdaoTransCall.enqueue(new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    String youdaoTransResp = Objects.requireNonNull(response.body()).string();

                    YoudaoChineseSentenceTranslate youdao = gson.fromJson(youdaoTransResp, YoudaoChineseSentenceTranslate.class);
                    StringBuilder youdaoResult = new StringBuilder();
                    for (String s : youdao.getTranslation()) {
                        youdaoResult.append(s);
                    }

                    youdaoOutput.setText(youdaoResult.toString());
                }
            });
        });

        en2zh.setOnClickListener(v -> {
            Gson gson = new Gson();
            // 百度英翻中
            String word = sentence.getText().toString();

            BaiduEncode b = new BaiduEncode(appid, word, pwd);
            b.encodeMD5();
            try {
                b.encodeURL();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            String urlWord = b.getWord();

            String baiduTransApiUrl = "http://api.fanyi.baidu.com/api/trans/vip/translate?q=" + urlWord + "&from=en&to=zh&appid=" + appid + "&salt=" + b.getSalt() + "&sign=" + b.getMD5();


            OkHttpClient okHttpClient = new OkHttpClient();

            Request baiduTransRequest = new Request.Builder()
                    .url(baiduTransApiUrl)
                    .build();

            Call baiduTransCall = okHttpClient.newCall(baiduTransRequest);


            baiduTransCall.enqueue(new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    String myBaiduResp = Objects.requireNonNull(response.body()).string();

                    BaiduTranslate baidu = gson.fromJson(myBaiduResp, BaiduTranslate.class);

                    List<BaiduTranslate.TransResultBean> myTrans = baidu.getTrans_result();
                    if (myTrans != null) {
                        for (BaiduTranslate.TransResultBean i : myTrans) {
                            baiduOutput.setText(i.getDst());
                        }
                    } else {
                        baiduOutput.setText(baiduTransApiUrl);
                    }
                }
            });

            // 有道英翻中
            parmas.put("q", word);
            parmas.put("from", "Auto");
            parmas.put("to", "Auto");
            FormBody.Builder builder = new FormBody.Builder();
            for (String key : parmas.keySet()) {
                //追加表单信息
                builder.add(key, Objects.requireNonNull(parmas.get(key)));
            }
            OkHttpClient client = new OkHttpClient();
            RequestBody formBody = builder.build();

            Request youdaoTransRequest = new Request.Builder()
                    .url(youdaoTransApiUrl)
                    .post(formBody)
                    .build();
            Call youdaoTransCall = client.newCall(youdaoTransRequest);
            youdaoTransCall.enqueue(new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    String youdaoTransResp = Objects.requireNonNull(response.body()).string();

                    YoudaoChineseSentenceTranslate youdao = gson.fromJson(youdaoTransResp, YoudaoChineseSentenceTranslate.class);
                    StringBuilder youdaoResult = new StringBuilder();
                    for (String s : youdao.getTranslation()) {
                        youdaoResult.append(s);
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            youdaoOutput.setText(youdaoResult.toString());
                        }
                    });
                }
            });
        });

    }
}