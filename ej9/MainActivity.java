package com.example.ej9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button boton1;
    private EditText et1;
    private int num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
        num = (int) (Math.random() * 100001);
        String cadena = String.valueOf(num);
        Toast notificacion = Toast.makeText(this, cadena, Toast.LENGTH_LONG);
        notificacion.show();
    }

    public void controler(View view){
        String valorIngresado=et1.getText().toString();
        int valor=Integer.parseInt(valorIngresado);
        if(valor==num){
            Toast notificacion=Toast.makeText(this, "Muy bien recordaste el número",Toast.LENGTH_LONG);
            notificacion.show();

        }
        else {
            Toast notificacion= Toast.makeText(this, "Lo siento pero no es el número mostrado", Toast.LENGTH_SHORT);
            notificacion.show();
        }
    }
}