package com.example.direccionesip;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ip nueva = new ip();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCalcular = (Button) findViewById(R.id.btnCalcular);
    }

        btnCalcular.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick (View view){

        TextView txtRed = (TextView) findViewById(R.id.txtRed);
        TextView txtDirIP = (TextView) findViewById(R.id.txtDirIP);
        TextView txtPrefijo = (TextView) findViewById(R.id.txtPrefijo);
        String red, dir, clas, val;
        int p;
        dir = txtDirIP.getText().toString();
        p = Integer.parseInt(txtPrefijo.getText().toString());
        red = txtRed.getText().toString();

        double h, s;
        String strmsg1, s1, v, s3, o;
        int prefijo;

        nueva.recibedatos(dir);
        nueva.validarip();
        strmsg1 = nueva.clasedered();
        nueva.setPrefijo(p);
        nueva.validarip();
        prefijo = nueva.getPrefijo();
        h = nueva.numHost();
        s = nueva.numSubRedes();
        v = nueva.validap();
        s1 = nueva.subnet();
        s3 = nueva.calc();

        o = nueva.getStrmsg1();
        Intent vista1 = new Intent(MainActivity.this, Resultados.class);
        vista1.putExtra("datoNombre", red);
        vista1.putExtra("datoDirIP", dir);
        vista1.putExtra("datoPrefijo", p);
        vista1.putExtra("datoClase", strmsg1);
        vista1.putExtra("datoValid", o);
        vista1.putExtra("datoPrefix", prefijo);
        vista1.putExtra("datoHost", h);
        vista1.putExtra("datoRed", s);
        vista1.putExtra("datoValidp", v);
        vista1.putExtra("datoValidSub", s1);
        vista1.putExtra("datoMascara", s3);
        startActivity(vista1);
    }


    });

}
