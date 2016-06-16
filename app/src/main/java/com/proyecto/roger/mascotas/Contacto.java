package com.proyecto.roger.mascotas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Contacto extends AppCompatActivity {

    Button btn;
    EditText nombre,para,comentario;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        toolbar = (Toolbar) findViewById(R.id.miToolbar);
        toolbar.setTitle("Contactar");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn = (Button) findViewById(R.id.submit);
        nombre = (EditText) findViewById(R.id.nombre);
        para = (EditText) findViewById(R.id.email_address);
        comentario = (EditText)findViewById(R.id.comentario);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
    }

    public void sendEmail(){

        //Getting content for email
        String email = para.getText().toString().trim();
        String subject = nombre.getText().toString().trim();
        String message = comentario.getText().toString().trim();

        //Creating SendMail object
        SendMail sm = new SendMail(this, email, subject, message);

        //Executing sendmail to send email
        sm.execute();

    }
}
