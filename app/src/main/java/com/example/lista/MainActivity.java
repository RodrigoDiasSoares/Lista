package com.example.lista;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity{
    private FloatingActionButton btn;
    private ListView list;
    private ArrayList<String> lista_default = new ArrayList<>();
    private Crud c = new Crud();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle bundle = getIntent().getExtras();
        btn = findViewById(R.id.button);
        list = findViewById(R.id.listToDo);
        if(bundle != null){
            c = (Crud) bundle.getSerializable("crud");
            lista_default = c.getList();
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    getApplicationContext(),
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,
                    lista_default
            );
            list.setAdapter(adapter);
        }else {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    getApplicationContext(),
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,
                    c.getList()
            );
            list.setAdapter(adapter);
        }
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String valor = list.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),valor, Toast.LENGTH_LONG).show();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NovoItem.class);
                intent.putExtra("obj", c);
                startActivity(intent);
            }
        });
    }
}
