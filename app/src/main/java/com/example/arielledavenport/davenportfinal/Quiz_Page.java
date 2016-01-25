package com.example.arielledavenport.davenportfinal;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.content.*;
public class Quiz_Page extends AppCompatActivity  {
    Button next;
    RadioGroup q1;
    RadioGroup q2;
    RadioGroup q3;
    RadioGroup q4;
    RadioButton rad_1;
    RadioButton rad_2;
    RadioButton rad_3;
    RadioButton rad_4;
    int answera = 0;
    int answersb = 0;
    int answersc = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz__page);

        q1 = (RadioGroup) findViewById(R.id.question_1);
        q2 = (RadioGroup) findViewById(R.id.question_2);
        q3 = (RadioGroup) findViewById(R.id.question_3);
        q4 = (RadioGroup) findViewById(R.id.question_4);
        next = (Button) findViewById(R.id.btn_next);






            next.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {



                    if(q1.getCheckedRadioButtonId() == -1 || q2.getCheckedRadioButtonId() == -1 || q3.getCheckedRadioButtonId() == -1 || q4.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(getApplicationContext(), "Oops, some question(s) not answered", Toast.LENGTH_LONG).show();
                    }else{
                        //start looking for answers
                        rad_1 = (RadioButton) findViewById(q1.getCheckedRadioButtonId());
                        final String ques_1 = rad_1.getText().toString();

                        rad_2 = (RadioButton) findViewById(q2.getCheckedRadioButtonId());
                        final String ques_2 = rad_2.getText().toString();

                        rad_3 = (RadioButton) findViewById(q3.getCheckedRadioButtonId());
                        final String ques_3 = rad_3.getText().toString();

                        rad_4 = (RadioButton) findViewById(q4.getCheckedRadioButtonId());
                        final String ques_4 = rad_4.getText().toString();

                        Intent intent = new Intent(Quiz_Page.this, Loading_page.class);
                        intent.putExtra("question_1", ques_1);
                        intent.putExtra("question_2", ques_2);
                        intent.putExtra("question_3", ques_3);
                        intent.putExtra("question_4", ques_4);
                        startActivity(intent);

                }
            }

         });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz__page, menu);
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
