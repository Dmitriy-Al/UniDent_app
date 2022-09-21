package com.example.unident;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Promotion extends AppCompatActivity {

    ImageView banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion);

        banner = findViewById(R.id.banner);



//////////////////////////////////////////////////////////////////////

        new Thread(new Runnable(){//create a new thread so we can do network operations
            @Override
            public void run() {//main thread function
                try {//attempt to do network stuff
                    URL url =  new URL("http://https://ibb.co/y8P7pgZ");//create aURL object with the path to your banner  Узнать про объект URL
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();//create the connection object from the url
                    con.setReadTimeout(1000);
                    con.setConnectTimeout(1000);
                    con.setRequestMethod("GET");
                    con.setDoInput(true);
                    con.connect();//connect to the server
                    InputStream is = con.getInputStream();//get the stream so we can read the image  Узнать про InputStream
                    Drawable d = Drawable.createFromStream(is, "MyBanner");//create a drawable from the image  Узнать про Drawable
                    Bitmap bmp = ((BitmapDrawable) d).getBitmap();//create a bitmap from the drawable Узнать про Bitmap
                    final Drawable dS = new BitmapDrawable(Bitmap.createScaledBitmap(bmp, 192, 192, true));//scale it to whatever size you need
                    con.disconnect();//disconnect now that we're done
                    runOnUiThread(new Runnable(){//run UI update code on the main thread
                        @Override
                        public void run() {
                            banner.setImageDrawable(dS);//set the imageview to the banner we downloaded
                        }
                    });
                } catch (MalformedURLException e) {//catch url error
                    e.printStackTrace();
                } catch (IOException e) {//catch io error when downloading
                    e.printStackTrace();
                }
            }
        }).start();//run the thread

    }
}