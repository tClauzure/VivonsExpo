package com.example.vivonsexpos;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import android.content.Intent;

public class MenuConnexion extends AppCompatActivity {
    String responseStr;
    OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button buttonValiderAuthentification = (Button) findViewById(R.id.buttonconnex);
        buttonValiderAuthentification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Appel de la function authentification
                try {
                    authentification();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
                .url("http://localhost/VivonsExpo_php/controleurs/connexion.php")
                .post(formBody)
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            public  void onResponse(Call call, Response response) throws IOException {
                responseStr = response.body().string();
                Log.d("Test",responseStr);
                if (responseStr.compareTo("false")!=0){
                    try {
                        JSONObject utilisateur = new JSONObject(responseStr);
                        Log.d("Test",utilisateur.getString("nom") + " est  connecté");
                        if(utilisateur.getString("typeUtilisateur").compareTo("staff")!=0) {
                            Intent intent = new Intent(MenuConnexion.this, MenuExposant.class);
                            intent.putExtra("utilisateur", utilisateur.toString());
                            startActivity(intent);
                        }
                        else {
                            Intent intent = new Intent(MenuConnexion.this, MenuStaff.class);
                            startActivity(intent);
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
