package com.example.direccionesip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Resultados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        recibeDatos();
    }
    public void recibeDatos(){
        Bundle parametros=getIntent().getExtras();

        String Nombre=parametros.getString("datoNombre");
        String DirIP=parametros.getString("datoDirIP");

        String Clas=parametros.getString("datoClase");
        String V=parametros.getString("datoValid");
        int prefix=parametros.getInt("datoPrefix");
        double host=parametros.getDouble("datoHost");
        double red=parametros.getDouble("datoRed");
        String Vp=parametros.getString("datoValidp");
        String Vs=parametros.getString("datoValidSub");
        String Mascara=parametros.getString("datoMascara");

        TextView txtRed2=(TextView)findViewById(R.id.txtRed2);
        txtRed2.setText(Nombre);
        TextView txtDirIP2=(TextView)findViewById(R.id.txtDirIP2);
        txtDirIP2.setText(DirIP);
        TextView txtPrefijo2=(TextView)findViewById(R.id.txtPrefijo2);
        txtPrefijo2.setText(prefix);
        TextView txtClase=(TextView)findViewById(R.id.txtClase);
        txtClase.setText(Clas);
        TextView txtValid=(TextView)findViewById(R.id.txtValid);
        txtValid.setText(V);
        TextView txtMascara=(TextView)findViewById(R.id.txtMascara);
        txtMascara.setText(Mascara);
        TextView Host=(TextView)findViewById(R.id.Host);

    }
    public void regresar(View view){
            Intent vista1=new Intent(Resultados.this,MainActivity.class);
            startActivity(vista1);
    }
}
