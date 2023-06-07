package com.example.getfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {




    String buttonValue;

Button startButton;
private CountDownTimer countDownTimer;
TextView  mtextView;
private boolean mTimeRunning;
        private long mTimeLeftinmillis;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        Intent intent=getIntent();
        buttonValue=intent.getStringExtra("value");



        int intValue=Integer.valueOf(buttonValue);



        switch (intValue){



            case 1:
                setContentView(R.layout.activity_bow);
                break;
            case 2:
                setContentView(R.layout.activity_bridge);
                break;
            case 3:
                setContentView(R.layout.activity_chair);
                break;
            case 4:
                setContentView(R.layout.activity_child);
                break;
            case 5:
                setContentView(R.layout.activity_cobbler);
                break;
            case 6:
                setContentView(R.layout.activity_cow);
                break;
            case 7:
                setContentView(R.layout.activity_playji);
                break;
            case 8:
                setContentView(R.layout.activity_pauseji);
                break;
            case 9:
                setContentView(R.layout.activity_plank);
                break;
            case 10:
                setContentView(R.layout.activity_crunches);
                break;
            case 11:
                setContentView(R.layout.activity_situp);
                break;
            case 12:
                setContentView(R.layout.activity_rotation);
                break;
            case 13:
                setContentView(R.layout.activity_twist);
                break;
            case 14:
                setContentView(R.layout.activity_windwill);
                break;
            case 15:
                setContentView(R.layout.activity_legup);
                break;






        }

startButton=findViewById(R.id.startButton);
        mtextView=findViewById(R.id.time);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mTimeRunning)
                {

                    stoptimer();


                }
                else
                {
                      startTimer();
                }
            }
        });













    }
    private void stoptimer()
    {

        countDownTimer.cancel();
        mTimeRunning=false;
        startButton.setText("START");


    }
    private void startTimer()
    {
        final CharSequence value1=mtextView.getText();
        String num1=value1.toString();
        String num2=num1.substring(0,2);
        String num3=num1.substring(3,5);


        final int number=Integer.valueOf(num2)*60+Integer.valueOf(num3);
        mTimeLeftinmillis=number*1000;

        countDownTimer=new CountDownTimer(mTimeLeftinmillis,1000) {
            @Override
            public void onTick(long l) {


                mTimeLeftinmillis=l;
                updateTimer();


            }

            @Override
            public void onFinish() {


                int newvalue=Integer.valueOf(buttonValue)+1;
                if(newvalue<=15)
                {
                    Intent intent=new Intent(ThirdActivity.this,ThirdActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newvalue));
                    startActivity(intent);
                    //here again i dont want any othere to open
                    finish();

                }
                else {
                    newvalue=1;

                    Intent intent=new Intent(ThirdActivity.this,ThirdActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newvalue));

                    startActivity(intent);
                    //here again i dont want any othere to open
                    finish();



                }




            }
        }.start();

        startButton.setText("Pause");
        mTimeRunning=true;




    }
    private void updateTimer()
    {
        int minutes=(int)mTimeLeftinmillis/60000;
        int seconds=(int) mTimeLeftinmillis%60000/1000;
        String timeLeftText="";
        if(minutes<10) {
            timeLeftText = "0";
        }
            timeLeftText=timeLeftText+minutes+":";


        if(seconds<10)
        {
            timeLeftText+="0";
        }
        timeLeftText+=seconds;
        mtextView.setText(timeLeftText);






    }


        @Override
        public void onBackPressed() {
            super.onBackPressed();

            Intent intent=new Intent(ThirdActivity.this,SecondActivity.class);

            startActivity(intent);
            finish();



        }





}