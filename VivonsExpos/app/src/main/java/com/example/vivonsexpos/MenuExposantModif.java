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

public class MenuExposantModif extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultation_stand);

        try {
            final JSONObject user = new JSONObject(getIntent().getStringExtra("user"));

            final Button buttonEnvoyer = findViewById(R.id.buttonEnvoyer);
            buttonEnvoyer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MenuExposantModif.this, MenuExposant.class);
                    startActivity(intent);

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
}
