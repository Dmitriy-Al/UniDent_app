package com.example.unident;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text_clicker_service;
    TextView text_clicker_about_us;
    TextView text_clicker_about_app;
    ImageButton button_promotion;
    ImageButton button_address;
    ImageButton button_appointment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        text_clicker_service = findViewById(R.id.text_clicker_service);
        text_clicker_about_us = findViewById(R.id.text_clicker_about_us);
        text_clicker_about_app = findViewById(R.id.text_clicker_about_app);
        button_promotion = findViewById(R.id.button_promotion);
        button_address = findViewById(R.id.button_address);
        button_appointment = findViewById(R.id.button_appointment);


        ActivityResultLauncher<Intent> ActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                        }
                    }
                });


        text_clicker_service.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, AllService.class);
                ActivityResultLauncher.launch(intent);
            }
        });

        text_clicker_about_us.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, AboutUs.class);
                ActivityResultLauncher.launch(intent);
            }
        });

        text_clicker_about_app.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, AboutApp.class);
                ActivityResultLauncher.launch(intent);
            }
        });

        button_promotion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, Promotion.class);
                ActivityResultLauncher.launch(intent);
            }
        });

        button_address.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, Address.class);
                ActivityResultLauncher.launch(intent);
            }
        });

        button_appointment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, Appointment.class);
                ActivityResultLauncher.launch(intent);
            }
        });

    }
}