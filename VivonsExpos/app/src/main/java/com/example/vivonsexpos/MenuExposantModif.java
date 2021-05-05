package com.example.vivonsexpos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.OkHttpClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MenuExposantModif extends AppCompatActivity {
    String responseStr ;
    OkHttpClient client = new OkHttpClient();
    ArrayList<String> arrayList = new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultation_stand);

        try {
            final JSONObject user = new JSONObject(getIntent().getStringExtra("user"));
            final JSONObject exposant = new JSONObject(getIntent().getStringExtra("utilisateur"));

                try {
                    lesDemandes(exposant);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            final Button buttonEnvoyer = findViewById(R.id.buttonEnvoyer);
            buttonEnvoyer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MenuExposantModif.this, MenuExposant.class);
                    try {
                        demandeModif(exposant);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Intent intent_menu = new Intent(MenuExposantModif.this, MenuExposantModif.class );
                    intent_menu.putExtra("utilisateur", exposant.toString());
                    startActivity(intent_menu);

                }
            });

            final Button buttonRetour = findViewById(R.id.buttonback);
            buttonRetour.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MenuExposantModif.this, MenuExposant.class);
                    startActivity(intent);

                }
            });

        } catch (JSONException e) {
            Toast.makeText(MenuExposantModif.this, "message !", Toast.LENGTH_SHORT).show();
        }
    }

    public void lesDemandes(JSONObject unExposant) throws IOException {

        listView = (ListView) findViewById(R.id.listViewDemandes);
        try {


            RequestBody formBody = new FormBody.Builder()
                    .add("login", unExposant.getString("login"))
                    .build();
            Request request = new Request.Builder()
                    .url("http://192.168.43.101/PHP_VivonsExpo/controleurs/LesDemandes.php")
                    .post(formBody)
                    .build();

            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                public void onResponse(Call call, Response response) throws IOException {
                    responseStr = response.body().string();
                    if (responseStr != null) {
                        try {
                            JSONArray lesDemandes = new JSONArray(responseStr);

                            for (int i = 0; i < lesDemandes.length(); i++) {
                                if (arrayList.size() < 3) {
                                    arrayList.add("Demande n° " + lesDemandes.getJSONObject(i).getString("numD") + ", Motif :" + lesDemandes.getJSONObject(i).getString("motif"));

                                } else {
                                    Log.d("alerte", "3 demandes max ! ");
                                }
                            }

                        } catch (JSONException e) {

                        }
                    } else {
                        Log.d("Test", "Aucune demande n'a été trouvé!");
                    }
                }

                public void onFailure(Call call, IOException e) {
                    Log.d("Test", "erreur!!!");
                }
            });

            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);

            listView.setAdapter(arrayAdapter);
        } catch (JSONException e) {

        }
    }

    public void demandeModif(JSONObject unExposant) throws IOException {

        final EditText textRaison = findViewById(R.id.TextRaison);
        try {

            if (arrayList.size() < 3) {
                RequestBody formBody = new FormBody.Builder()
                        .add("login", unExposant.getString("login"))
                        .add("motif", textRaison.getText().toString())
                        .build();
                Request request = new Request.Builder()
                        .url("http://192.168.43.101/PHP_VivonsExpo/controleurs/DemandeModif.php")
                        .post(formBody)
                        .build();

                Call call = client.newCall(request);
                call.enqueue(new Callback() {
                    public  void onResponse(Call call, Response response) throws IOException {
                        responseStr = response.body().string();
                        if (responseStr != null){
                            try {
                                JSONObject ajoute = new JSONObject(responseStr);
                                Log.d("test", ajoute.getString("motif"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        } else {
                            Log.d("Test","Aucune demande n'a été trouvé!");
                        }
                    }

                    public void onFailure(Call call, IOException e)
                    {
                        Log.d("Test","erreur!!!");
                    }
                });

                lesDemandes(unExposant);
            }else {
                Log.d("test", "ajoutDemande: 3 demandes deja effctuées");
            }
        }catch (JSONException e){

        }
    }
}
