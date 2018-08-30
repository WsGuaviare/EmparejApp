package com.example.worldskills.emparejapp.Pantallas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.worldskills.emparejapp.R;

public class Inicio extends AppCompatActivity {

    EditText player1,player2;
    Button ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        player1 = findViewById(R.id.player1);
        player2 = findViewById(R.id.player2);
        ingresar = findViewById(R.id.ingresar);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu();
            }
        });
    }


    //metodo para pasar al activity menu, haciendo las respectivas validaciones
    private void menu() {
        if (player1.getText().toString().trim().equals("") || player2.getText().toString().trim().equals("")){
            Toast.makeText(getApplicationContext(),"No pueden haber campos vacios!",Toast.LENGTH_SHORT).show();
        }else if (player1.getText().toString().trim().equals(player2.getText().toString().trim())){
            Toast.makeText(getApplicationContext(),"Los nombres no pueden ser iguales",Toast.LENGTH_SHORT).show();
        }else {
            Intent menu = new Intent(getApplicationContext(),Menu.class);
                menu.putExtra("player1",player1.getText().toString());
                menu.putExtra("player2",player2.getText().toString());
            startActivity(menu);
            finish();
        }
    }
}
