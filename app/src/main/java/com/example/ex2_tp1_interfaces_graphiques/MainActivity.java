package com.example.ex2_tp1_interfaces_graphiques;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText nom,surface,adresse,nbrPiece;
    private CheckBox piscine;
    private Button calcul;
    private TextView imptSup,imptBase,imptTot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        nom=findViewById(R.id.nom);
        surface=findViewById(R.id.surface);
        adresse=findViewById(R.id.adresse);
        calcul=findViewById(R.id.button);
        piscine=findViewById(R.id.piscine);
        nbrPiece=findViewById(R.id.nbrPiece);
        imptBase=findViewById(R.id.textView7);
        imptSup=findViewById(R.id.textView8);
        imptTot=findViewById(R.id.textView9);



        calcul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalculImpot();

            }
        });



    }

    private void CalculImpot(){
        try {

            double srf=Double.parseDouble(surface.getText().toString());
            boolean psc=piscine.isChecked();
            int nbr=Integer.parseInt(nbrPiece.getText().toString());
            double impotDeBase=srf*2;
            int impotSupl=nbr*50;
            if (psc){
                impotSupl+=100;
            }
            double impotTotale=impotDeBase+impotSupl;

            imptBase.setText("Impot de base = "+impotDeBase);
            imptSup.setText("Impot suplémentaire = "+impotSupl);
            imptTot.setText("Impot Total ="+impotTotale);



        } catch (NumberFormatException e){

            Toast.makeText(MainActivity.this, "Veuillez entrer des valeurs valides!", Toast.LENGTH_SHORT).show();



        }
    }
}