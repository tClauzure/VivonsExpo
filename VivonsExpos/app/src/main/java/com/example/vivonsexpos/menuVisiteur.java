package com.example.vivonsexpos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class menuVisiteur extends AppCompatActivity {
   @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visiteur);
        final Button buttonMenuBackVisiteur = (Button) findViewById(R.id.buttonBack2);
        buttonMenuBackVisiteur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menuVisiteur.this, MainActivity.class);
                startActivity(intent);
            }
        });

      /* try{
            final JSONObject vivonsexpos =new JSONObject (getIntent().getStringExtra("visiteur"));
            final TextView textRecherche = findViewById(R.id.textRecherche);
            String texteRecherche = vivonsexpos.getString("typeutilisateur");
            textRecherche.setText(texteRecherche);
        }
        catch(JSONException e){
            Toast.makeText(menuVisiteur.this,"message!",Toast.LENGTH_SHORT).show();
       }*/

    }

}
