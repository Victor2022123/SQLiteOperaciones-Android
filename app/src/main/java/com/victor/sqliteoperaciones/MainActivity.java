package com.victor.sqliteoperaciones;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText usuario, password;
    DbAdapter helper;
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = (EditText) findViewById(R.id.usuarioNombre);
        password= (EditText) findViewById(R.id.usuarioPassword);

        helper= new DbAdapter(this);
    }
    public void agregarUsuario(View view){
    //    Mensaje.aviso(this, "Insercion Exitosa");
        String datoUsuario =usuario.getText().toString();
        String datoPassword =password.getText().toString();
        if (datoUsuario.isEmpty() || datoPassword.isEmpty())
        {
            Mensaje.aviso(this, "Ingrese Tanto el nombre como la Contrasena");
        }else{
            long  resultado = helper.insertarDatos(datoUsuario,datoPassword);
            if(resultado<=0){
                Mensaje.aviso(this, "Insercion Fallida");
                usuario.setText("");
                password.setText("");

            }else{
                Mensaje.aviso(this, "Insercion Exitosa");
                usuario.setText("");
                password.setText("");

            }
        }
    }
    public void  verDatos(View view){
        String datos = helper.getData();
        Mensaje.aviso(this, datos);
    }
}
