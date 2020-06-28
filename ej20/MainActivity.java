package com.example.ej20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView iv1;
    private Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv1=(ImageView)findViewById(R.id.iv1);
        b1=(Button)findViewById(R.id.b1);

    }

    public void ocultar(View view){
        b1.setVisibility(View.INVISIBLE);
        iv1.setVisibility(view.VISIBLE);
    }
}