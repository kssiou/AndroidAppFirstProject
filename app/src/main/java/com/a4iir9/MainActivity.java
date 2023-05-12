package com.a4iir9;

import static com.a4iir9.R.*;
import static com.a4iir9.R.id.txt1;
import static com.a4iir9.R.id.txtNom;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ResponseDelivery;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAGNAME =MainActivity.class.getSimpleName();
    private static final String HTTP_URL = "https://belatar.name/rest/profile.php?login=test&passwd=test&id=9998";
    private static final String HTTP_IMAGES="https://belatar.name/images";
    private static final String HTTP_URL_NOTES = "https://belatar.name/rest/profile.php?login=test&passwd=test&id=9998&notes=true";

    private Student etd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
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

//                try {
//                    etd = new Student(response.getInt("id"),
//                    response.getString("nom"),response.getString("prenom"),
//                    response.getString("classe"),response.getString("phone"),
//                    null);
//                    VolleySingleton.getInstance(getApplicationContext()).getImageLoader().get(HTTP_IMAGES+response.getString("photo"), new ImageLoader.ImageListener() {
//                        @Override
//                        public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
//                            Log.d(TAGNAME, "on est dans on response");
//                            etd.setPhoto(response.getBitmap());
//                            ImageView img = findViewById(id.image);
//                            img.setImageBitmap(etd.getPhoto());
//
//                        }
//
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//                            Log.d(TAGNAME, "on est dans on error response");
//                        }
//                    });
//
//                    EditText txtNom = findViewById(id.LabelNom);
//                    EditText txtPrenom = findViewById(id.LabelPrenom);
//                    EditText txtClasse = findViewById(id.Labelclasse);
//                    txtNom.setText(etd.getNom());
//                    txtPrenom.setText(etd.getPrenom());
//                    txtClasse.setText(etd.getClasse());
//
//
//
//                } catch (JSONException e) {
//                   e.printStackTrace();
//                }
                super.onResume();

                if (getResources().getConfiguration().orientation == 2) {
                    Toast.makeText(this, "horizental", Toast.LENGTH_SHORT).show();

                    JsonObjectRequest req_notes = new JsonObjectRequest(Request.Method.GET, HTTP_URL_NOTES, null,
                            response -> {
                                Log.d("MainActivity", "onResponse() called with: response = [" + response + "]");
                                ListView list = findViewById(R.id.listeNotes);
                                List<String> data = new ArrayList<>();
                                try {
                                    JSONArray notesArray = response.getJSONArray("notes");
                                    for (int i = 0; i < notesArray.length(); i++) {
                                        JSONObject note = notesArray.getJSONObject(i);
                                        String matiere = note.getString("matiere");
                                        String score = note.getString("score");
                                        data.add(matiere + " : " + score);
                                    }
                                } catch (Exception e) {
                                    Log.d("MainActivity", "onResponse() called with: response = [" + response + "]");
                                }
                                ArrayAdapter<String> adapter = new ArrayAdapter<>(list.getContext(), R.layout.notes_line, data);
                                list.setAdapter(adapter);
                            },
                            error -> Log.d("MainActivity", "onErrorResponse() called with: error = [" + error + "]")
                    );
                    VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(req_notes);

                } else {
                    JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, HTTP_URL, null,
                            response -> Log.d("MainActivity", "onResponse() called with: response = [" + response + "]"),
                            error -> Log.d("MainActivity", "onErrorResponse() called with: error = [" + error + "]")
                    );
                    VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(request);
                }
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