package com.example.humor.sanmarcos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText user,pass;
    Button iniciar,registr;
    String username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);
        iniciar = (Button) findViewById(R.id.iniciar);
        registr = (Button) findViewById(R.id.registr);

        //Bundle extras = getIntent().getExtras();
    }

    public void regist(View view) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivityForResult(intent,1);
    }

    public void iniciarSes(View view) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivityForResult(intent,2);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if ((requestCode == 1)&&(resultCode == RESULT_OK)){
            username = data.getExtras().getString("username");
            password = data.getExtras().getString("password");
            user.setText(username);
            pass.setText(password);
        }else if((requestCode == 1)&&(resultCode == RESULT_CANCELED)){
            Toast.makeText(getApplicationContext(),"Registro cancelado",Toast.LENGTH_SHORT).show();
        }else if((requestCode == 2)&&(resultCode == RESULT_CANCELED)){
            Toast.makeText(getApplicationContext(),"Sesión cerrada",Toast.LENGTH_SHORT).show();
        }
    }
}
