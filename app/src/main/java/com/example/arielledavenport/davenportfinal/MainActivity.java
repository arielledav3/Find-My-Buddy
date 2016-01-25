package com.example.arielledavenport.davenportfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText login;
    EditText password;
    Button btn_login;
    Button btn_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //start adding values
        login = (EditText) findViewById(R.id.login);
        password = (EditText) findViewById(R.id.password);

        btn_login = (Button) findViewById(R.id.button);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(login.getText().toString().equals("admin") && password.getText().toString().equals("admin") ) {
                    Intent myintent = new Intent(MainActivity.this, Quiz_Page.class);
                    startActivity(myintent);
                }else {
                    Toast.makeText(getApplicationContext(), "login: 'admin' & password:'admin' ", Toast.LENGTH_LONG).show();
                }
            }
        });

        btn_register = (Button) findViewById(R.id.button2);
        btn_register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent myintent = new Intent(MainActivity.this, MainRegActivity.class);
                startActivity(myintent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
