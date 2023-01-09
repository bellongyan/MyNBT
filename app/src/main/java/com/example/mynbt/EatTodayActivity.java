package com.example.mynbt;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.mynbt.R;

import java.util.Random;

public class EatTodayActivity extends AppCompatActivity {
    private ProgressBar progress;
    private TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eat_today);

        show = findViewById(R.id.showEatToday);
        progress = findViewById(R.id.progressBar);
        final Button start = findViewById(R.id.start);

//        食堂点名数据存储在dishes数据中
        start.setOnClickListener(v -> {
            String[] dishes = {"test1", "test2", "test3"};
            progress.setVisibility(View.VISIBLE);
            Random random = new Random();
            int num = random.nextInt(dishes.length);
            new Thread() {
                int p = 0;

                @Override
                public void run() {
                    super.run();
                    while (p <= 100) {
                        p++;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                progress.setProgress(p);
                            }
                        });
                        try {
                            Thread.sleep(15);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            show.setText(dishes[num]);
                        }
                    });
                }
            }.start();
        });
    }
}