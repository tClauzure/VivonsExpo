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

public class MenuInscription extends AppCompatActivity {
    String responseStr;
    OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        final Button buttonEnvoyer = (Button) findViewById(R.id.buttonEnvoyer);
        buttonEnvoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Appel de la function Inscription
                try {
                    Inscription();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void Inscription() throws IOException {
        final EditText textLogin = findViewById(R.id.TextLogin);
        final EditText textMdp = findViewById(R.id.TextPassword);
        final EditText textNom = findViewById(R.id.TextNom);
        final EditText textPrenom = findViewById(R.id.TextPrenom);
        final EditText textTel = findViewById(R.id.TextTel);
        final EditText textMail = findViewById(R.id.TextEmail);
        final EditText textRaisonSociale = findViewById(R.id.TextRaisonSociale);
        final EditText textActivite = findViewById(R.id.TextActivite);
        final EditText textSiteInternet = findViewById(R.id.TextSite);

        RequestBody formBody = new FormBody.Builder()
                .add("login", textLogin.getText().toString())
                .add("mdp",  textMdp.getText().toString())
                .add("nom",  textNom.getText().toString())
                .add("prenom",  textPrenom.getText().toString())
                .add("telephone",  textTel.getText().toString())
                .add("mail",  textMail.getText().toString())
                .add("raisonSociale",  textRaisonSociale.getText().toString())
                .add("activite",  textActivite.getText().toString())
                .add("siteInternet",  textSiteInternet.getText().toString())
                .build();
        Request request = new Request.Builder()
                .url("http://192.168.56.1/VivonsExpo_php/controleurs/inscription.php")
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
                        Log.d("Test",utilisateur.getString("nom") + " est  inscrit");

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
                Log.d("Test","erreur!!! inscription impossible");
                Log.d("Test",e.getMessage());
            }

        });
    }
}
