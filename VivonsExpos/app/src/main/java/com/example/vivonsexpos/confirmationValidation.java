package com.example.vivonsexpos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class confirmationValidation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Button buttonRetour = (Button) findViewById(R.id.buttonback);
        buttonRetour.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                confirmationValidation.this.finish();
            }
        });

        final Button buttonConfirmer = (Button) findViewById(R.id.buttonConfirmer);
        buttonConfirmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    enregistrerInscrit();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void enregistrerInscrit() throws IOException{


    }


}
