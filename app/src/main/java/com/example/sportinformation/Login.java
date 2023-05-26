package com.example.sportinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;


public class Login extends AppCompatActivity {

    private EditText editTextUsername, editTextPassword;
    private Button buttonLogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = findViewById(R.id.Username);
        editTextPassword = findViewById(R.id.Password);
        buttonLogin = findViewById(R.id.btnLog);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                //hit API Login
                AndroidNetworking.post("https://mediadwi.com/api/latihan/login?username=admin&password=admin")
                        .addBodyParameter("username", username)
                        .addBodyParameter("password", password)
                        .setPriority(Priority.MEDIUM)
                        .build()
                        .getAsJSONObject(new JSONObjectRequestListener() {
                            @Override
                            public void onResponse(JSONObject response) {
                                // Handle the response
                                // ...
                                Log.d("Login Sukses!!!!!!!!!!", "onResponse: "+response.toString());
                                try {
                                    boolean status = response.getBoolean("status");
                                    String message = response.getString("message");
                                    if (status){
                                        // Login berhasil
                                        Toast.makeText(Login.this, "Login successful", Toast.LENGTH_SHORT).show();
                                        // Lanjutkan ke aktivitas selanjutnya
                                        Intent intent = new Intent(Login.this, MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }else{
                                        Toast.makeText(Login.this, message, Toast.LENGTH_SHORT).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                buttonLogin.setEnabled(true);
                            }

                            @Override
                            public void onError(ANError error) {
                                Toast.makeText(Login.this, "Error", Toast.LENGTH_SHORT).show();
                            }
                        });

//                // Lakukan verifikasi login di sini
//                if (username.equals("admin") && password.equals("admin")) {
//
//                } else {
//                    // Login gagal
//                    Toast.makeText(Login.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
//                }
            }
        });
    }
}