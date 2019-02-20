package com.example.aplicaciones3.examen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    TextView lb2, lb1;
    Integer valor=0, i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        lb2 = findViewById(R.id.lb2);
        lb1 = findViewById(R.id.lb1);

        findViewById(R.id.btnreiniciar).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        i++;
        v.setEnabled(false);
        //v.setEnabled(false);
        //Button b=(Button) v;
        Random r = new Random();
        Integer numero = r.nextInt(9) + 1;
        //lb2.setText(String.valueOf(numero));
        lb2.setText(numero.toString());
        valor += numero;
        lb1.setText(valor.toString());
        boolean st = Statusbotones();

        Log.d("re",String.valueOf(st));

        if(valor > 21)
        {
            Toast.makeText(this,"PERDISTE",Toast.LENGTH_LONG).show();
        }

        if(!st && valor <= 21)
        {
            Toast.makeText(this,"GANASTE",Toast.LENGTH_LONG).show();
        }

        if( valor == 21)
        {
            Toast.makeText(this,"GANASTE",Toast.LENGTH_LONG).show();
        }




    }

    public boolean Statusbotones()
    {
        boolean r=false;
        ViewGroup vp = (ViewGroup) findViewById(R.id.contenedor);
        int t=vp.getChildCount();

        for (int i=0; i<t; i++)
        {
            View view = vp.getChildAt(i);
            if(view instanceof Button)
            {
                if(view.isEnabled())
                {
                    r= true;
                }
            }
        }
        return r;
    }
}
