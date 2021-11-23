package com.kevinsimms.airjobs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Creeuncompte extends AppCompatActivity {


    private FirebaseFirestore db;
    private DocumentReference noteRef;
    private CollectionReference noteCollectionRef;

private EditText Email, Identifiant, motdepasse;


private void init(){

    Email=findViewById(R.id.login);
    Identifiant=findViewById(R.id.motdepasselog);
    motdepasse=findViewById(R.id.motdepasse);


    db=FirebaseFirestore.getInstance();

    noteCollectionRef = db.collection("notes");



}







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creeuncompte);

        init();

    }


    public void addcompte(View view){

        String Email1 = Email.getText().toString().trim();
        String Identifiant1 = Identifiant.getText().toString().trim();
        String motdepasse1 = motdepasse.getText().toString().trim();


        Modelcreeruncompte contenuNote = new Modelcreeruncompte(Email1, Identifiant1,motdepasse1 );

        noteCollectionRef.add(contenuNote)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(Creeuncompte.this, "Success", Toast.LENGTH_SHORT).show();
                    }
                });


    }





}