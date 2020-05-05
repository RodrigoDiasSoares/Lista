package com.example.lista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.Serializable;
import java.util.ArrayList;

public class NovoItem extends AppCompatActivity{
    private TextInputLayout novoItem;
    private Button salvar;
    private ArrayList<String> list;
    private Crud crud = new Crud();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_item);
        novoItem = findViewById(R.id.textInput);
        salvar = findViewById(R.id.btn_salvar);
        Bundle b = getIntent().getExtras();
        crud = (Crud) b.getSerializable("obj");
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String text = novoItem.getEditText().getText().toString().trim();
               Intent intent = new Intent(getApplicationContext(), MainActivity.class);
               crud.novoItem(text);
               intent.putExtra("crud",crud);
               startActivity(intent);
            }
        });
    }
}
