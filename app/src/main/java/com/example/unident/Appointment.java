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

    ImageButton button_call, button_mail;
    EditText edit_text_name, edit_text_phone;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);


        button_call = findViewById(R.id.button_call);
        edit_text_name = findViewById(R.id.edit_text_name);
        edit_text_phone = findViewById(R.id.edit_text_phone);
        button_mail = findViewById(R.id.button_mail);

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

        button_mail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String mail = "al.dimitry@ya.ru";// поля с неконстантами вынести в отдельный класс
                    String subject = edit_text_name.getText().toString();
                    String body = edit_text_phone.getText().toString();
                    String mailTo = "mailto:" + mail + "?&subject=" + Uri.encode(subject) + "&body=" + Uri.encode(body);
                    Intent emailIntent = new Intent(Intent.ACTION_VIEW);
                    emailIntent.setData(Uri.parse(mailTo));
                    startActivity(emailIntent);

                }
            });



    }
}