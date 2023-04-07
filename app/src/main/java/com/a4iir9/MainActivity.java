package com.a4iir9;

import static com.a4iir9.R.*;
import static com.a4iir9.R.id.txt1;
import static com.a4iir9.R.id.txtNom;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ResponseDelivery;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private static final String TAGNAME =MainActivity.class.getSimpleName();
    private static final String HTTP_URL = "https://belatar.name/rest/profile.php?login=test&passwd=test&id=9998";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        TextView texte = findViewById(txtNom);

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
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, HTTP_URL, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(MainActivity.class.getSimpleName(), response.toString());

            }

        }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(MainActivity.class.getSimpleName(), error.getMessage());

            }
        });
        VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(request);
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