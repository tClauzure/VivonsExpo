package com.example.vivonsexpos;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vivonsexpos.DTO.Inscrits;

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

        final Inscrits lesGroupes = new Inscrits();

;    }
}
