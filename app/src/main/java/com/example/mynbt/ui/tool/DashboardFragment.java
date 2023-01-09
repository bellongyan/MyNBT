package com.example.mynbt.ui.tool;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mynbt.EatTodayActivity;
import com.example.mynbt.PhysiqueCalculatorActivity;
import com.example.mynbt.TranslateActivity;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private Button button4,button5,button6;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel toolViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        Button button4 = binding.button4;
        button4.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), PhysiqueCalculatorActivity.class);
            startActivity(intent);
        });
        Button button5 = binding.button5;
        button5.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), TranslateActivity.class);
            startActivity(intent);
        });
        Button button6 = binding.button6;
        button6.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), EatTodayActivity.class);
            startActivity(intent);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}