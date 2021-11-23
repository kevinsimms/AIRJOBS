package com.kevinsimms.airjobs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class MainActivity extends AppCompatActivity {

private EditText login;
private EditText motdepasselog;

    private FirebaseFirestore db;
    private DocumentReference noteRef;
    private CollectionReference noteCollectionRef;



    private TextView creeuncompte;
    private TextView motdepassoublie;


    private Button buttonlog;

    private String logi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        creeuncompte = findViewById(R.id.creeuncompte);
        motdepassoublie = findViewById(R.id.motdepassoublie);
        buttonlog=findViewById(R.id.buttonlog);

        login=findViewById(R.id.login);
        motdepasselog=findViewById(R.id.motdepasselog);


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


        buttonlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                noteCollectionRef.get()
                        .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                            @Override
                            public void onSuccess(QuerySnapshot listeSnapshots) {
                                String notes = "";
                                for (QueryDocumentSnapshot documentSnapshot : listeSnapshots) {
                                    // pour chaque element(snapshot) de la liste

                                    Modelcreeruncompte contenuNote = documentSnapshot.toObject(Modelcreeruncompte.class);

                                    String getIdentifiant = contenuNote.getIdentifiant();
                                    logi=login.toString();
                                    if (getIdentifiant == logi) {
//                                    contenuNote.setDocumentId(documentSnapshot.getId());
//
//                                    String documentId= contenuNote.getDocumentId();
//                                    String titre = contenuNote.getTitre();
//                                    String note = contenuNote.getNote();


                                        // notes += documentId + "\nTitre : "+titre + "\nNote : " +note +"\n\n";
                                        Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();

                                    } else {
                                        Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show();

                                    }
                                    // tvSavedNote.setText(notes);
                                }
                            }
                        });














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



