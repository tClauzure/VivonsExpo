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

public class MenuExposantMesStands extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultation_stand);

        try {
            final JSONObject user = new JSONObject(getIntent().getStringExtra("user"));

            final TextView textNum = findViewById(R.id.TextNum);
            String texteNum = user.getString("numS");
            textNum.setText(texteNum);

            final TextView textHall = findViewById(R.id.TextHall);
            String texteHall = user.getString("numH");
            textHall.setText(texteHall);

            final TextView textSecteur = findViewById(R.id.TextSecteur);
            String texteSecteur = user.getString("libelleS");
            textSecteur.setText(texteSecteur);

            final TextView textTravee = findViewById(R.id.TextTravee);
            String texteTravee = user.getString("numT");
            textTravee.setText(texteTravee);

            final Button buttonRetour = findViewById(R.id.buttonback);
            buttonRetour.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MenuExposantMesStands.this, MenuExposant.class);
                    startActivity(intent);

                }
            });


        } catch (JSONException e) {
            Toast.makeText(MenuExposantMesStands.this, "message !", Toast.LENGTH_SHORT).show();
        }
    }
}
