package com.example.mynbt.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mynbt.ClassTableActivity;
import com.example.mynbt.ExamArrangementActivity;
import com.example.mynbt.ScoreSearchActivity;
import com.example.mynbt.tools.Weather;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private Button imageButton1, imageButton2, imageButton3;
    private TextView weatherText;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


//        测试跳转
        ImageButton imageButton1 = binding.imageButton1;
        imageButton1.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), ClassTableActivity.class);
            startActivity(intent);
        });
        ImageButton imageButton2 = binding.imageButton2;
        imageButton2.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), ScoreSearchActivity.class);
            startActivity(intent);
        });
        ImageButton imageButton3 = binding.imageButton3;
        imageButton3.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), ExamArrangementActivity.class);
            startActivity(intent);
        });

        weatherText = binding.textWeather;
        String url = "http://www.zj121.com/public/getTownWeather?location=%E5%AE%81%E6%B3%A2&_=1670165257662";

        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String respString = Objects.requireNonNull(response.body()).string();

                Gson gson = new Gson();
                Weather weather = gson.fromJson(respString, Weather.class);
                List<Weather.DataDTO.AreaDTO> myWeather = weather.getData().getArea();

                StringBuilder info = new StringBuilder("");
                for (Weather.DataDTO.AreaDTO i : myWeather) {
                    List<Weather.DataDTO.AreaDTO.WeatherDTO> test = i.getWeather();
                    if (i.getName().equals("宁波")) {
                        for (Weather.DataDTO.AreaDTO.WeatherDTO j : test) {
                            info.append(i.getName()).append(": ").append(j.getMinTemp()).append("~").append(j.getMaxTemp()).append("℃");
//                            System.out.println(i.getName() + " Max: " + j.getMaxTemp() + " Min: " + j.getMinTemp());
                            break;
                        }
                    }
                }
                weatherText.setText(info.toString());
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}