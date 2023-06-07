package com.example.getfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FoodActivityDetails extends AppCompatActivity {




    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);
        textView=findViewById(R.id.textTips);
        Intent intent=getIntent();
        String dStory=getIntent().getStringExtra("story");
        textView.setText(dStory);

    }

    public void goback(View view) {
        Intent intent=new Intent(FoodActivityDetails.this,FoodActivity.class);
        startActivity(intent);
        finish();
    }
}