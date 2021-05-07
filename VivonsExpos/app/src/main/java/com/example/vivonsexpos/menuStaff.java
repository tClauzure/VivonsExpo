package com.example.vivonsexpos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class menuStaff extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_staff);

        final Button buttonAffectationStand = (Button) findViewById(R.id.btnAffectationStand);
        buttonAffectationStand.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Intent intent = new Intent(menuStaff.this, affectationStand.class);
                startActivity(intent);
            }
        });

        final Button buttonModifStand = (Button) findViewById(R.id.btnModificationStand);
        buttonModifStand.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Intent intent = new Intent(menuStaff.this, modifStand.class);
                startActivity(intent);
            }
        });

        final Button buttonValidationInscription = (Button) findViewById(R.id.btnValidationInscription);
        buttonValidationInscription.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Intent intent = new Intent(menuStaff.this, validationInscription.class);
                startActivity(intent);
            }
        });

        final Button buttonGestionSecteur = (Button) findViewById(R.id.btnGestionSecteur);
        buttonGestionSecteur.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Intent intent = new Intent(menuStaff.this, choixUnivers.class);
                startActivity(intent);
            }
        });

        final Button buttonRetour = (Button) findViewById(R.id.buttonback);
        buttonRetour.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                menuStaff.this.finish();
            }
        });

    }
}
