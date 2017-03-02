package com.example.humor.sanmarcos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private String username;
    private String correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Bundle extras = getIntent().getExtras();

    //username = extras.getString("username");
    //correo = extras.getString("correo");

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        Intent intent;
        switch(id){
            case R.id.mPerfil:
                intent = new Intent(MainActivity.this,ProfileActivity.class);
                startActivity(intent);
                intent.putExtra("username",username);
                intent.putExtra("correo",correo);
                break;
            case R.id.cerrarSesion:
                intent = new Intent(MainActivity.this,LoginActivity.class);
                setResult(RESULT_CANCELED,intent);
                startActivity(intent);
                finish();
                break;
        }
        return true;
    }
}
