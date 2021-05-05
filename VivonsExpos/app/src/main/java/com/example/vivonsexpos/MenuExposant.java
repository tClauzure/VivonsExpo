package com.example.vivonsexpos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class MenuExposant extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultation_stand);

        try {
            final JSONObject user = new JSONObject(getIntent().getStringExtra("utilisateur"));

            final TextView textIdentification = findViewById(R.id.textIdentification);
            String texteIdentification = exposant.getString("prenom") + " " + exposant.getString("nom");
            textIdentification.setText(texteIdentification);

            final Button buttonMesStand = findViewById(R.id.buttonMesStands);
            buttonMesStand.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MenuExposant.this, MenuExposantMesStands.class);
                    intent.putExtra("utilisateur", exposant.toString());
                    startActivity(intent);

                }
            });

            final Button buttonModif = findViewById(R.id.buttonDemandeMotdif);
            buttonModif.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MenuExposant.this, MenuExposantModif.class);
                    startActivity(intent);

                }
            });

            final Button buttonRetour = findViewById(R.id.buttonback);
            buttonRetour.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MenuExposant.this, MenuConnexion.class);
                    startActivity(intent);

                }
            });


        } catch (JSONException e) {
            Toast.makeText(MenuExposant.this, "message !", Toast.LENGTH_SHORT).show();
        }

    }
}

