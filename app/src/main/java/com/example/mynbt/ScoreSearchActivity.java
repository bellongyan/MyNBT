package com.example.mynbt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.mynbt.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ScoreSearchActivity extends AppCompatActivity {
    private TextView scoreShow;
    private Spinner selectYear;
    private Spinner selectSemester;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_search);

        // 绑定控件
        final TextView scoreShow = findViewById(R.id.text);
        final Spinner selectYear = findViewById(R.id.spinner_year);
        final Spinner selectSemester = findViewById(R.id.spinner_semester);
        final Button btnSemester = findViewById(R.id.button_semester);
        final Button btnYear = findViewById(R.id.button_year);
        final Button btnHistory = findViewById(R.id.button_history);

        // 设置下拉列表数据并定义适配器
        String[] years = {"","2022-2023" , "2021-2022", "2020-2021"};
        ArrayAdapter<String> adapterYear = new ArrayAdapter<String>(ScoreSearchActivity.this, android.R.layout.simple_spinner_item, years);

        String[] semesters = {"", "1", "2", "3"};
        ArrayAdapter<String> adapterSemester = new ArrayAdapter<String>(ScoreSearchActivity.this, android.R.layout.simple_spinner_item, semesters);

        // 显示数据
        selectYear.setAdapter(adapterYear);
        selectSemester.setAdapter(adapterSemester);

        final String[] year = new String[1];
        final String[] semester = new String[1];

        selectYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                TextView txt1 = (TextView) arg1;
                year[0] = txt1.getText().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        selectSemester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                TextView txt1 = (TextView) arg1;
                semester[0] = txt1.getText().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

//        教务系统查询成绩API接口
        String url = "";
        HashMap<String, String> info = new HashMap<>();

        btnSemester.setOnClickListener(new View.OnClickListener() {
            @Override
//            请求头数据，后面还有，请不要忘记替换
            public void onClick(View v) {
                info.put("__VIEWSTATE", "");
                info.put("__VIEWSTATEGENERATOR", "");
                info.put("ddlXN", "");
                info.put("ddlXQ", "");
                info.put("Button1", "");

                info.remove("Button5");
                info.remove("Button2");

                FormBody.Builder builder = new FormBody.Builder();
                for (String key : info.keySet()) {
                    //追加表单信息
                    builder.add(key, Objects.requireNonNull(info.get(key)));
                }
                OkHttpClient client = new OkHttpClient();
                RequestBody formBody = builder.build();

                Request request = new Request.Builder()
                        .url(url)
                        .post(formBody)
                        .build();
                Call call = client.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(@NonNull Call call, @NonNull IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                        if (response.isSuccessful()) {
                            String myResponse = Objects.requireNonNull(response.body()).string();
                            ScoreSearchActivity.this.runOnUiThread(() -> {
                                String pattern = "<td>.*?</td><td>.*?</td><td>.*?</td><td>(.*?)</td><td>.*?</td><td>.*?</td><td>.*?<td class=\\\"text-right\\\">(.*?)</td><td class=\\\"text-right\\\">(.*?)</td>";
                                Pattern r = Pattern.compile(pattern);
                                Matcher m = r.matcher(myResponse);
                                StringBuilder sb = new StringBuilder();
                                sb.append("绩点\t" + "成绩\t" + "课程名称\n\n");
                                while (m.find()) {
                                    sb.append(m.group(3)).append("\t").append(m.group(2)).append("\t").append(m.group(1)).append("\n");
                                }
                                scoreShow.setText(sb.toString().replace("&nbsp;", "无"));
                            });
                        }
                    }
                });
            }
        });

        btnYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                请求头数据
                info.put("__VIEWSTATE", "");
                info.put("__VIEWSTATEGENERATOR", "");
                info.put("ddlXN", "");
                info.put("ddlXQ", "");
                info.put("Button5", "");

                info.remove("Button1");
                info.remove("Button2");

                FormBody.Builder builder = new FormBody.Builder();
                for (String key : info.keySet()) {
                    //追加表单信息
                    builder.add(key, Objects.requireNonNull(info.get(key)));
                }
                OkHttpClient client = new OkHttpClient();
                RequestBody formBody = builder.build();

                Request request = new Request.Builder()
                        .url(url)
                        .post(formBody)
                        .build();
                Call call = client.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(@NonNull Call call, @NonNull IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                        if (response.isSuccessful()) {
                            String myResponse = Objects.requireNonNull(response.body()).string();
                            ScoreSearchActivity.this.runOnUiThread(() -> {
                                String pattern = "<td>.*?</td><td>.*?</td><td>.*?</td><td>(.*?)</td><td>.*?</td><td>.*?</td><td>.*?<td class=\\\"text-right\\\">(.*?)</td><td class=\\\"text-right\\\">(.*?)</td>";
                                Pattern r = Pattern.compile(pattern);
                                Matcher m = r.matcher(myResponse);
                                StringBuilder sb = new StringBuilder();
                                sb.append("绩点\t" + "成绩\t" + "课程名称\n\n");
                                while (m.find()) {
                                    sb.append(m.group(3)).append("\t").append(m.group(2)).append("\t").append(m.group(1)).append("\n");
                                }
                                scoreShow.setText(sb.toString().replace("&nbsp;", "无"));
                            });
                        } else {
                            scoreShow.setText("成绩未找到");
                        }
                    }
                });
            }
        });

        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                请求头数据
                info.put("__VIEWSTATE", "");
                info.put("__VIEWSTATEGENERATOR", "");
                info.put("ddlXN", "");
                info.put("ddlXQ", "");
                info.put("Button2", "");

                info.remove("Button5");
                info.remove("Button1");

                FormBody.Builder builder = new FormBody.Builder();
                for (String key : info.keySet()) {
                    //追加表单信息
                    builder.add(key, Objects.requireNonNull(info.get(key)));
                }
                OkHttpClient client = new OkHttpClient();
                RequestBody formBody = builder.build();

                Request request = new Request.Builder()
                        .url(url)
                        .post(formBody)
                        .build();
                Call call = client.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(@NonNull Call call, @NonNull IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                        if (response.isSuccessful()) {
                            String myResponse = Objects.requireNonNull(response.body()).string();
                            ScoreSearchActivity.this.runOnUiThread(() -> {
                                String pattern = "<td>.*?</td><td>.*?</td><td>.*?</td><td>(.*?)</td><td>.*?</td><td>.*?</td><td>.*?<td class=\\\"text-right\\\">(.*?)</td><td class=\\\"text-right\\\">(.*?)</td>";
                                Pattern r = Pattern.compile(pattern);
                                Matcher m = r.matcher(myResponse);
                                StringBuilder sb = new StringBuilder();
                                sb.append("绩点\t" + "成绩\t" + "课程名称\n\n");
                                while (m.find()) {
                                    sb.append(m.group(3)).append("\t").append(m.group(2)).append("\t").append(m.group(1)).append("\n");
                                }
                                scoreShow.setText(sb.toString().replace("&nbsp;", "无"));
                            });
                        } else {
                            scoreShow.setText("成绩未找到");
                        }
                    }
                });
            }
        });
    }
}