package com.example.unident;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class Appointment extends AppCompatActivity {

    //String email = "a.dmitriy.viktorovich@gmail.com";

    ImageButton button_call;
    EditText edit_text_name, edit_text_phone;
    Button button_send;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);


        button_call = findViewById(R.id.button_call);
        edit_text_name = findViewById(R.id.edit_text_name);
        edit_text_phone = findViewById(R.id.edit_text_phone);
        button_send = findViewById(R.id.button_send);

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

        button_call.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view){
               Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+78124073113")); //посмотреть что за класс Uri
               if (intent.resolveActivity(getPackageManager()) != null) {} //посмотреть что за resolveActivity
                   startActivity(intent);

           }
        });



            button_send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                   Intent intent = new Intent(android.content.Intent.ACTION_SENDTO);
                    intent.setType("message/rfc822");

                    intent.setType("plain/text");
                    intent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"al.dimitry@ya.ru"});
                    intent.putExtra(android.content.Intent.EXTRA_SUBJECT, edit_text_name.getText().toString());
                    intent.putExtra(android.content.Intent.EXTRA_TEXT, edit_text_phone.getText().toString());
                    intent.setData(Uri.parse("mailto:al.dimitry@ya.ru"));
                    Appointment.this.startActivity(Intent.createChooser(intent, "Отправка Email..."));
                   //////////////////////////
                /*     Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:al.dimitry@ya.ru"));
                    //intent.putExtra(Intent.EXTRA_SUBJECT, edit_text_name.getText().toString());
                    //intent.putExtra(Intent.EXTRA_TEXT, edit_text_phone.getText().toString());
                    intent.putExtra(android.content.Intent.EXTRA_SUBJECT, edit_text_name.getText().toString());
                    intent.putExtra(android.content.Intent.EXTRA_TEXT, edit_text_phone.getText().toString());
                    //Appointment.this.startActivity(Intent.createChooser(intent, "Отправка Email..."));
                    startActivity(Intent.createChooser(intent, "Send Email"));
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }*/


                }
            });



    }
}