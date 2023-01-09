package com.example.mynbt;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mynbt.R;
import com.example.mynbt.tools.PasswordMD5;

public class LoginActivity extends AppCompatActivity {
    // Connect to the local MySQL database
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText username = findViewById(R.id.edit_username);
        EditText password = findViewById(R.id.edit_password);
        Button loginButton = findViewById(R.id.btn_login);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredUsername = username.getText().toString();
                PasswordMD5 p = new PasswordMD5(password.getText().toString());
                p.passwordMD5();
                // Encrypt the entered password using MD5
                String enteredPassword = p.getPasswordMD5();
                Log.d("MySQL", "md5: " + enteredPassword);

                if (connection != null) {
                    // Query the "users" table in the database to check if the entered username and password are correct
                    Thread thread1 = new Thread(() -> {
                        ResultSet resultSet = null;
                        try {
                            Statement statement = connection.createStatement();
                            String sql = String.format("SELECT * FROM users WHERE username='%s' AND password='%s'", enteredUsername, enteredPassword);
                            resultSet = statement.executeQuery(sql);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        try {
                            if (resultSet.next()) {
                                String username = resultSet.getString("username");
                                Log.d("MySQL", "username: " + username);
                                // The entered username and password are correct
//                                Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                                runOnUiThread(() -> {
                                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                });
                                Log.d("MySQL", "Login successful");
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                intent.putExtra("USERNAME",enteredUsername);
                                startActivity(intent);
                                finish();
                            } else {
                                // The entered username and password are incorrect
//                                Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                                runOnUiThread(() -> {
                                    Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                                });
                                Log.d("MySQL", "Invalid username or password");
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    });
                    thread1.start();
                } else {
                    // Could not connect to the database
                    Toast.makeText(LoginActivity.this, "Error connecting to the database", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
