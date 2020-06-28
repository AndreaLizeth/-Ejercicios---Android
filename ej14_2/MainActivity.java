package com.example.ej14_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private EditText et1, et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
    }
    public void garbar(View view){
        String nomarchivo=et1.getText().toString();
        nomarchivo=nomarchivo.replace('/','-');
        try {
            OutputStreamWriter archivo= new OutputStreamWriter(openFileOutput(nomarchivo, Activity.MODE_PRIVATE));
            archivo.write(et2.getText().toString());
            archivo.flush();
            archivo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(this, "Los datos fueron grabados", Toast.LENGTH_SHORT).show();
        et1.setText("");
        et2.setText("");
    }

    public void recuperar( View v){
        String nomarchivo=et1.getText().toString();
        nomarchivo=nomarchivo.replace('/','-');
        boolean enco=false;
        String [] archivos= fileList();
        for (int f=0; f<archivos.length;f++)
            if (nomarchivo.equals(archivos[f]))
                enco=true;
        if (enco==true){
            try {
                InputStreamReader archivo = new InputStreamReader(openFileInput(nomarchivo));
                BufferedReader br= new BufferedReader(archivo);
                String linea= br.readLine();
                String todo= "";
                while (linea!= null){
                    todo= todo + linea+ "\n";
                    linea= br.readLine();
                }
                br.close();
                archivo.close();
                et2.setText(todo);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(this, "No hay datos para dicha fecha", Toast.LENGTH_SHORT).show();
            et2.setText("");
        }
    }
}