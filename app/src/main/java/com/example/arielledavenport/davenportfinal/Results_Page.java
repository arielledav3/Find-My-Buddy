package com.example.arielledavenport.davenportfinal;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.net.*;
import android.widget.*;
import android.text.*;
import android.text.method.*;
public class Results_Page extends AppCompatActivity {
    TextView pet_nam;
    TextView pet_ag;
    ImageView new_image;
    TextView pet_email;
    String url;
    Button local;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results__page);
        pet_nam = (TextView)findViewById(R.id.pet_name);
        pet_ag = (TextView)findViewById(R.id.pet_age);
        pet_email = (TextView)findViewById(R.id.email);
        new_image = (ImageView) findViewById(R.id.imageView);
        String local_name = null;

        Intent intent = getIntent();
        String question_1 = intent.getStringExtra("question_1");
        String question_2 = intent.getStringExtra("question_2");
        String question_3 = intent.getStringExtra("question_3");
        String question_4 = intent.getStringExtra("question_4");

        if(question_2.equals("Cat")){
            if(question_1.contains("Big City")){
                //new_image.setImageResource(R.drawable.cat1);
                pet_nam.setText("Felicia");
                pet_ag.setText("5 years old");
                pet_email.setText("paws_and_claws123@shelter.org");
                url ="https://www.google.com/maps/dir/''/420+Industrial+Dr,+Naperville,+IL+60563/@41.7782697,-88.2854539,12z/data=!3m1!4b1!4m8!4m7!1m0!1m5!1m1!1s0x880ef9afbc0e3f6f:0x58a0c169741a6a03!2m2!1d-88.215414!2d41.778291";

            }else{
                new_image.setImageResource(R.drawable.cat2);
                pet_nam.setText("Garfield");
                pet_ag.setText("18 months old");
                pet_email.setText("catluvs@adopt.com");
                url = "https://www.google.com/maps/dir/''/22+N+Elm+St,+Hinsdale,+IL+60521/@41.8049407,-87.9928629,12z/data=!3m1!4b1!4m8!4m7!1m0!1m5!1m1!1s0x880e4946153d49b1:0x7ba10c262efec0c1!2m2!1d-87.922823!2d41.804962";
            }
        }

        if(question_2.equals("Dog")){
            if(question_1.contains("Country")){
                new_image.setImageResource(R.drawable.dog1);
                pet_nam.setText("Severus");
                pet_ag.setText("8 weeks old");
                pet_email.setText("pottersdog@gmail.com");
                url = "https://www.google.com/maps/dir/''/157+W+Grand+Ave,+Chicago,+IL+60654/@41.8914235,-87.7033831,12z/data=!3m1!4b1!4m8!4m7!1m0!1m5!1m1!1s0x880e2cb3f50b55c7:0xbac7d75f1281490e!2m2!1d-87.6333432!2d41.8914448";
            }else{
                new_image.setImageResource(R.drawable.dog3);
                pet_nam.setText("Hermoine");
                pet_email.setText("adopt_not_kill@yahoo.co.uk");
                pet_ag.setText("3 years old");
                url = "https://www.google.com/maps/dir/''/1997+N+Clybourn+Ave,+Chicago,+IL+60614/@41.9177417,-87.7287366,12z/data=!3m1!4b1!4m8!4m7!1m0!1m5!1m1!1s0x880fd2e0310f2835:0xd0f75d030a39f577!2m2!1d-87.6586967!2d41.917763";
            }//end if
        }//end if

        local = (Button) findViewById(R.id.location);

        local.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent myintent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(url));
                startActivity(myintent);
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_results__page, menu);
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
