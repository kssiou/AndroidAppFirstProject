package com.a4iir9;

import static com.a4iir9.R.*;
import static com.a4iir9.R.id.txt1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    private static final String TAGNAME =MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        TextView texte = findViewById(txt1);

        texte.setText("here we go !!");
        Log.d(TAGNAME, "on est dans create");

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAGNAME, "on est dans onstart");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAGNAME, "on est dans ondestroyed");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAGNAME, "on est dans on Pause");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAGNAME, "on est dans on Resume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAGNAME, "on est dans OnRestart");

    }



    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAGNAME, "on est dans On Stop");

    }
}