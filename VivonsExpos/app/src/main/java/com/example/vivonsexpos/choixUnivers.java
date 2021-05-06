package com.example.vivonsexpos;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class choixUnivers extends AppCompatActivity {

    String responseStr;
    OkHttpClient client = new OkHttpClient();
    ArrayList<String> arrayListListUnivers;
    ListView listViewUnivers;
    JSONArray jsonArrayUnivers;
    JSONObject jsonObjectUnivers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choix_univers);

        try {
            listUnivers();
        }catch (IOException e) {
            e.printStackTrace();
        }


        final Button buttonRetour = (Button) findViewById(R.id.buttonback);
        buttonRetour.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                choixUnivers.this.finish();
            }
        });
    }

    public void listUnivers() throws IOException{
        Request request = new Request.Builder()
                .url("http://192.168.1.23/php/listeInscription.php")
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                responseStr = response.body().string();

                arrayListListUnivers = new ArrayList<String>();
                listViewUnivers = findViewById(R.id.listCandidat);

                try{
                    jsonArrayUnivers = new JSONArray(responseStr);
                    for (int i = 0; i< jsonArrayUnivers.length();i++){
                        jsonObjectUnivers = jsonArrayUnivers.getJSONObject(i);
                        arrayListListUnivers.add("Nom: "+jsonObjectUnivers.getString("nom")+" prenom: "+jsonObjectUnivers.getString("prenom")+" raisonSocial: "+jsonObjectUnivers.getString("raisonSociale")+" activite: "+jsonObjectUnivers.getString("activite")+" secteur: "+jsonObjectUnivers.getString("libelleS"));
                    }
                }
                catch (JSONException e){
                    Log.d("Test", e.getMessage());
                }

                ArrayAdapter<String> arrayAdapterInscrit = new
                        ArrayAdapter<String>(choixUnivers.this, android.R.layout.simple_list_item_1,arrayListListUnivers);
                runOnUiThread(()->{listViewUnivers.setAdapter(arrayAdapterInscrit);});
            }



            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

        });
    }
}
