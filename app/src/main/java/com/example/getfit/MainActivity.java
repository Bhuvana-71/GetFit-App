package com.example.getfit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        button1=findViewById(R.id.startyogaone);
        button2=findViewById(R.id.startYogaTwo);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
                //i am creating
                finish();


            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SecondActivity1.class);
                startActivity(intent);
                //i am creating
                finish();

            }
        });






    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      getMenuInflater().inflate(R.menu.main,menu);

     return true;


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();
        if(id==R.id.id_privacy)
        {

            Intent intent =new Intent(Intent.ACTION_VIEW, Uri.parse("https://getfitprivacypolicy.blogspot.com/2023/06/get-fit-privacy-policy-page.html"));
        startActivity(intent);


            return true;
        }
        if(id==R.id.id_term)
        {

            Intent intent =new Intent(Intent.ACTION_VIEW, Uri.parse("https://getfittermsandcondition.blogspot.com/2023/06/get-fit-terms-and-condition.html"));
            startActivity(intent);
            return true;
        }
        if(id==R.id.rate)
        {
            try{
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("market://details?id="+ getPackageName())));

            }
            catch(Exception e)
            {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=" +getPackageName())));

            }




            return true;
        }
        if(id==R.id.more)
        {
            Intent intent =new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=Leap+Fitness+Group"));
            startActivity(intent);

            return true;
        }
        if(id==R.id.share)
        {

            Intent myIntent=new Intent(Intent.ACTION_SEND);
            myIntent.setType("text/GetFit");
           String shareBody="This is the Best App for Yoga\n By This App you can Get Overall Fitness to Your Body\nThis is The free app Download Now\n"+"https://play.google.com/store/apps/details?id="+getPackageName();
           String sharehub="Get Fit";
           myIntent.putExtra(Intent.EXTRA_SUBJECT,sharehub);
           myIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
           startActivity(Intent.createChooser(myIntent,"share using"));



            return true;
        }



return true;

    }

    public void beforeAge18(View view) {

        Intent intent=new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
        //i am creating
        finish();







    }

    public void afterAge18(View view) {
        Intent intent=new Intent(MainActivity.this,SecondActivity1.class);
        startActivity(intent);
        //i am creating
        finish();



    }

    public void food(View view) {

              Intent intent=new Intent(MainActivity.this,FoodActivity.class);
              startActivity(intent);
        //i am creating
        finish();

    }
}