package com.example.mynbt.ui.personal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    private TextView myNickname, myGender, mySchool, myDepartment, myClass;

    static Connection connection = null;
    static {
        Thread thread = new Thread(() -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Log.d("MySQL", "驱动加载成功");
                connection = DriverManager.getConnection(
                        "jdbc:mysql://192.168.3.21:3306/MyNBT",
                        "root",
                        "password");
                Log.d("MySQL", "数据库连接成功");
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("MySQL", "数据库连接失败");
            }
        });
        thread.start();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final ImageView textView = binding.touxiang;
        myNickname = binding.myNickname;
        myGender = binding.myGender;
        mySchool = binding.mySchool;
        myDepartment = binding.myDepartment;
        myClass = binding.myClass;

        Intent intent = getActivity().getIntent();
        String username = intent.getStringExtra("USERNAME");

        if (connection != null) {
            Log.d("MySQL", "数据库连接成功");
            Thread thread1 = new Thread(() -> {
                ResultSet resultSet = null;
                try {
                    Statement statement = connection.createStatement();
                    String sql = String.format("SELECT * FROM personal_info WHERE username = '%s'", username);
                    resultSet = statement.executeQuery(sql);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    if (resultSet.next()) {
                        String nickname = resultSet.getString("nickname");
                        String gender = resultSet.getString("gender");
                        String school = resultSet.getString("school");
                        String college = resultSet.getString("college");
                        String major = resultSet.getString("major");
                        String class_ = resultSet.getString("class");

                        getActivity().runOnUiThread(() -> {
                            myNickname.setText(nickname);
                            myGender.setText(gender);
                            mySchool.setText(school);
                            myDepartment.setText(college);
                            String myClass_ = major + " " + class_;
                            myClass.setText(myClass_);
                        });
                        Log.d("MySQL", "nickname: " + nickname);
                        Log.d("MySQL", "gender: " + gender);
                        Log.d("MySQL", "school: " + school);
                        Log.d("MySQL", "college: " + college);
                        Log.d("MySQL", "major: " + major);
                        Log.d("MySQL", "class: " + class_);

                    } else {
                        Log.d("MySQL", "查询失败");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            thread1.start();
        } else {
            Log.d("MySQL", "数据库连接失败");
        }


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
