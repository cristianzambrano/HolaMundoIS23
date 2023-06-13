package com.example.holamundois23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btEnviar(View view){



        EditText txtNombre = (EditText)findViewById(R.id.txtNombre);
        EditText txtPassowrd = (EditText)findViewById(R.id.txtPassword);
        RadioButton rbMasc = (RadioButton)findViewById(R.id.rbMasc);
        Switch swNotificacion = (Switch)findViewById(R.id.swNotificaciones);

        String Nombre= txtNombre.getText().toString();
        String Password= txtPassowrd.getText().toString();

        //Para sacar el género Seleccionado??
        String Genero =  rbMasc.isChecked()?"Masculino":"Femenino";
        //Sacar si recibe o no Notificaciones
        String notificaciones = swNotificacion.isChecked()?"SI":"NO";

        Toast.makeText(this.getApplicationContext(),
                "Nombre: " + Nombre + ", " +
                        "Password: " + Password + ", " +
                        "Género: " + Genero + ", " +
                        "Notificaciones: " + notificaciones,
                Toast.LENGTH_LONG).show();

        Intent intent = new Intent(MainActivity.this,
                                    MainActivity2.class);
        Bundle b = new Bundle();
        b.putString("NOMBRE", Nombre);
        b.putString("PASSWORD", Password);
        b.putString("GENERO", Genero);
        b.putString("NOTIFICA", notificaciones);
        intent.putExtras(b);
        startActivity(intent);
    }
}