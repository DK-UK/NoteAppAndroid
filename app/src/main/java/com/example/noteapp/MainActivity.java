package com.example.noteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.noteapp.models.nota;
import com.example.noteapp.operations.NotaOperations;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listNotas;
    Button btnForm;
    private nota model;
    private NotaOperations notaOperations;
    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listNotas = findViewById(R.id.listnotas);
        btnForm = findViewById(R.id.form);

        listNotas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), list.get(i), Toast.LENGTH_SHORT).show();
            }
        });

        btnForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Form.class);
                startActivity(intent);
            }
        });
        NotaOperations ops = new NotaOperations(this);
        CargarListado(ops.list());
    }

    private void CargarListado(ArrayList<String> Listado){
        list = Listado;
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, list);
        listNotas.setAdapter(adapter);
    }


}