package com.example.arielledavenport.davenportfinal;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.util.Log;

public class Loading_page extends AppCompatActivity {
    String question_1;
    String question_2;
    String question_3;
    String question_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_load);
        Intent intent = getIntent();
        question_1 = intent.getStringExtra("question_1");
        question_2 = intent.getStringExtra("question_2");
        question_3 = intent.getStringExtra("question_3");
        question_4 = intent.getStringExtra("question_4");

        Thread logoTimer = new Thread() {
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    Log.d("Exception", "Exception" + e);
                } finally {
                    Intent myintent = new Intent(Loading_page.this, Results_Page.class);
                    myintent.putExtra("question_1", question_1);
                    myintent.putExtra("question_2", question_2);
                    myintent.putExtra("question_3", question_3);
                    myintent.putExtra("question_4", question_4);
                    startActivity(myintent);
                }
                finish();
            }
        };
        logoTimer.start();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
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
