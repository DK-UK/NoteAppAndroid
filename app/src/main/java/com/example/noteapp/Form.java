package com.example.noteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.noteapp.models.nota;
import com.example.noteapp.operations.NotaOperations;

import java.util.ArrayList;

public class Form extends AppCompatActivity {
    EditText TituloNota, ContenidoNota;
    Button BTNAgregarNota;

    private nota model;
    private NotaOperations notaOperations;
    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        TituloNota = findViewById(R.id.etTitulo);
        ContenidoNota = findViewById(R.id.etContenido);
        BTNAgregarNota = findViewById(R.id.btnAddNota);

        BTNAgregarNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titulo = TituloNota.getText().toString();
                String contenido = ContenidoNota.getText().toString();

                if(!titulo.isEmpty()){
                    NotaOperations ops = new NotaOperations(getApplicationContext());
                    nota model = new nota(titulo, contenido);

                    int r = ops.insert(model);

                    if (r > 0) {
                        Toast.makeText(getApplicationContext(), "Guardado Correctamente", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_LONG).show();
                        TituloNota.setText("");
                        ContenidoNota.setText("");
                    }
                }

                else{
                    Toast.makeText(getApplicationContext(), "Debes llenar la Información Primero!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}