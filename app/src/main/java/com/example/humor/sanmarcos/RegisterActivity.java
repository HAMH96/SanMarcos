package com.example.humor.sanmarcos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText user,pass,rptPass,mail;
    Button cancel,regist;
    String username,password,rptPassword,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        user = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);
        rptPass = (EditText) findViewById(R.id.rptPassword);
        mail = (EditText) findViewById(R.id.email);
        regist = (Button) findViewById(R.id.registr);
        cancel = (Button) findViewById(R.id.cancel);
    }

    public void regis(View view){
        username = user.getText().toString();
        password = pass.getText().toString();
        rptPassword = rptPass.getText().toString();
        email = mail.getText().toString();

        if(!(username.equals(""))&&!(password.equals(""))&&!(rptPassword.equals(""))&&!(email.equals(""))){
            if(password.equals(rptPassword)){
                Intent intent = new Intent();
                intent.putExtra("username",username);
                intent.putExtra("password",password);
                setResult(RESULT_OK,intent);
                finish();
            }else{
                Toast.makeText(getApplicationContext(),"Las contraseñas no coinciden",Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getApplicationContext(),"Hay campos sin llenar",Toast.LENGTH_SHORT).show();
        }
    }

    public void canc(View view){
        Intent intent = new Intent();
        setResult(RESULT_CANCELED,intent);
        finish();
    }
}
