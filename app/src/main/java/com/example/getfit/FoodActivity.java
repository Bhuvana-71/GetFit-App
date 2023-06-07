package com.example.getfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class FoodActivity extends AppCompatActivity {

    ListView listView;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);


        String []  tStory=getResources().getStringArray(R.array.title_story);
      final   String[] dStory=getResources().getStringArray(R.array.details_story);

        listView=findViewById(R.id.list);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.row,R.id.rowtxt,tStory);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

             String t=dStory[i];
             //position on item
                Intent intent=new Intent(FoodActivity.this,FoodActivityDetails.class);
                intent.putExtra("story",t);
                startActivity(intent);
                finish();




            }
        });


              mAdView=findViewById(R.id.adView);
        AdRequest adRequest=new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);






    }

    public void foodgoback(View view) {

       Intent intent=new Intent(FoodActivity.this,MainActivity.class);
       startActivity(intent);
       finish();


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(FoodActivity.this,MainActivity.class);
        startActivity(intent);
        finish();


    }
}