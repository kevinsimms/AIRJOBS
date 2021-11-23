package com.kevinsimms.airjobs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView creeuncompte;

    private TextView motdepassoublie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        creeuncompte = findViewById(R.id.creeuncompte);
        motdepassoublie = findViewById(R.id.motdepassoublie);


        creeuncompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });


        motdepassoublie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity3();

            }
        });






    }
        public void openActivity2(){
            Intent intent = new Intent(this, Creeuncompte.class);
            startActivity(intent);
        }





        public void openActivity3(){
            Intent intent = new Intent(this, Recuperationmotdepasse.class);
            startActivity(intent);
        }

}



