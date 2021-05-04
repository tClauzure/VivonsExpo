package com.example.vivonsexpos;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import okhttp3.Call;
import android.util.Log;
import android.view.View;
import android.view.textclassifier.ConversationActions;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class pageConnex extends AppCompatActivity {
    String responseStr;
    OkHttpClient client = new OkHttpClient();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_connex);


        final Button buttonConnexion = (Button) findViewById(R.id.buttonconnex);
        buttonConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                try {
                    authentification();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        final Button buttonRetour = (Button) findViewById(R.id.buttonback);
        buttonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                pageConnex.this.finish();
            }
        });
    }

    public void authentification() throws IOException {
        final EditText textLogin = findViewById(R.id.TextLogin);
        final EditText textMdp = findViewById(R.id.TextMdp);

        RequestBody formBody = new FormBody.Builder()
                .add("login", textLogin.getText().toString())
                .add("mdp",  textMdp.getText().toString())
                .build();
                 Request request = new Request.Builder()
                .url("http://192.168.1.23/php/authentification.php")
                .post(formBody)
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            public  void onResponse(Call call, Response response) throws IOException {
                responseStr = response.body().string();
                Log.d("Test",responseStr);
                if (responseStr.compareTo("false")!=0){
                    try {
                        JSONObject staff = new JSONObject(responseStr);
                        Log.d("Test",staff.getString("nom") + " est  connecté");
                        Log.d("typeUtilisateur",staff.getString("typeUtilisateur"));
                        if(staff.getString("typeUtilisateur").compareTo("staff")==0) {
                            Intent intent = new Intent(pageConnex.this, menuStaff.class);
                            intent.putExtra("staff", staff.toString());
                            startActivity(intent);
                        }
                        else {
                            Intent intent = new Intent(pageConnex.this, menuStaff.class);
                        }
                    }
                    catch(JSONException e){
                        // Toast.makeText(MainActivity.this, "Erreur de connexion !!!! !", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.d("Test","Login ou mot de  passe non valide !");
                }
            }

            public void onFailure(Call call, IOException e)
            {
                Log.d("Test","erreur!!! connexion impossible");
                Log.d("Test",e.getMessage());
            }

        });
    }



}
