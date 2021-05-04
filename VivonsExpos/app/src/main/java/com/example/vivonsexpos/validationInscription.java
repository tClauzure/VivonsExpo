package com.example.vivonsexpos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
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

public class validationInscription extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.validation_inscription);

        final Button buttonRetour = (Button) findViewById(R.id.buttonback);
        buttonRetour.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                validationInscription.this.finish();
            }
        });
    }

    public void listInscrit() throws IOException{
        OkHttpClient client = new OkHttpClient();
        String login = null;

        Request request = new Request.Builder()
                .url("http://192.168.1.23/php/listeInscription.php")
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {


            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                String responseStr = response.body().string();
                ArrayList arrayListListInscrit;
                ListView listViewInscrit;
                JSONArray jsonArrayInscrit;
                JSONObject jsonObjectInscrit;
                arrayListListInscrit = new ArrayList<String>();
                listViewInscrit = findViewById(R.id.listCandidat);

                try{
                    jsonArrayInscrit = new JSONArray(responseStr);
                    for (int i = 0; i< jsonArrayInscrit.length();i++){
                        jsonObjectInscrit = jsonArrayInscrit.getJSONObject(i);
                        arrayListListInscrit.add("Nom: "+jsonObjectInscrit.getString("nom")+" prenom: "+jsonObjectInscrit.getString("prenom")+" raisonSocial: "+jsonObjectInscrit.getString("raisonSociale")+" activite: "+jsonObjectInscrit.getString("activite")+" secteur: "+jsonObjectInscrit.getString("libelleS"));
                    }
                }
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

        });

    }
}
