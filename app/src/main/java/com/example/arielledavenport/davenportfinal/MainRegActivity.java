package com.example.arielledavenport.davenportfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.*;

public class MainRegActivity extends AppCompatActivity {
    Button submit;
    EditText first;
    EditText last;
    EditText email;
    EditText pass1;
    EditText pass2;
    String f;
    String l;
    String e;
    String p1;
    String p2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_reg);
        first = (EditText) findViewById(R.id.first_name);
        last = (EditText) findViewById(R.id.last_name);
        email = (EditText) findViewById(R.id.email_user);
        pass1 = (EditText) findViewById(R.id.user_password);
        pass2 = (EditText) findViewById(R.id.con_password);

        submit = (Button) findViewById(R.id.btn_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f = first.getText().toString();
                l = last.getText().toString();
                e = email.getText().toString();
                p1 = pass1.getText().toString();
                p2 = pass2.getText().toString();
                if(!(f.matches("")) && !(l.matches("")) && !(e.matches("")) && !(p1.matches("")) && !(p2.matches(""))) {
                    if(p1.equals(p2)){
                        Intent intent = new Intent(MainRegActivity.this, MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(), "Passwords Don't Match!", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Please Fill in Form!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_quiz, menu);
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
