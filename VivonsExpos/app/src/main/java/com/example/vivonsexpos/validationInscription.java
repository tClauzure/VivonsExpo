package com.example.vivonsexpos;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vivonsexpos.DTO.Utilisateur;

import org.jetbrains.annotations.NotNull;
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

public class validationInscription extends AppCompatActivity {
    String responseStr;
    OkHttpClient client = new OkHttpClient();
    ArrayList<String> arrayListListInscrit;
    ListView listViewInscrit;
    JSONArray jsonArrayInscrit;
    JSONObject jsonObjectInscrit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.validation_inscription);

        try {
            listInscrit();
        }catch (IOException e) {
            e.printStackTrace();
        }


        final Button buttonRetour = (Button) findViewById(R.id.buttonback);
        buttonRetour.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                validationInscription.this.finish();
            }
        });
    }

    public void listInscrit() throws IOException{


        Request request = new Request.Builder()
                .url("http://192.168.1.23/php/listeInscription.php")
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                responseStr = response.body().string();

                arrayListListInscrit = new ArrayList<String>();
                listViewInscrit = findViewById(R.id.listCandidat);

                try{
                    jsonArrayInscrit = new JSONArray(responseStr);
                    for (int i = 0; i< jsonArrayInscrit.length();i++){
                        jsonObjectInscrit = jsonArrayInscrit.getJSONObject(i);
                        arrayListListInscrit.add("Nom: "+jsonObjectInscrit.getString("nom")+" prenom: "+jsonObjectInscrit.getString("prenom")+" raisonSocial: "+jsonObjectInscrit.getString("raisonSociale")+" activite: "+jsonObjectInscrit.getString("activite")+" secteur: "+jsonObjectInscrit.getString("libelleS"));
                    }
                }
                catch (JSONException e){
                    Log.d("Test", e.getMessage());
                }

                ArrayAdapter<String> arrayAdapterInscrit = new
                        ArrayAdapter<String>(validationInscription.this, android.R.layout.simple_list_item_1,arrayListListInscrit);
                runOnUiThread(()->{listViewInscrit.setAdapter(arrayAdapterInscrit);});
            }



            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

        });

    }
}
