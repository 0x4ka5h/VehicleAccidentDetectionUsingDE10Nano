package com.example.alarm;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.*;


public class MainActivity extends AppCompatActivity {

    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService(new Intent(this, YourService.class));
       textview = (TextView)findViewById(R.id.view);
       textview.setText("Everything is Fine");
       if (!Python.isStarted()) {

            Python.start(new AndroidPlatform(this));
        }
       Python py=Python.getInstance();
        final MediaPlayer tone = MediaPlayer.create(this,R.raw.song);

        PyObject pyobj=py.getModule("retrieve");
        PyObject obj= pyobj.callAttr("function_request");
        if (obj.toString().equals("accident occured")){
            textview.setText(obj.toString());
            tone.start();
        }
    }
}