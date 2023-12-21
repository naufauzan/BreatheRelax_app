package com.spencerstudios.breatherelax;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
//import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
//import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;


public class StopAct extends AppCompatActivity {

    Button  btnstart, btnstop;
    ImageView icanchor,bgcircle;
    Animation roundingalone,atg,in;
    TextView inhale;
    //Chronometer timehere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop);

        btnstart = findViewById(R.id.btnstart);
        btnstop = findViewById(R.id.btnstop);
        icanchor = findViewById(R.id.icanchor);
        bgcircle = findViewById(R.id.bgcircle);
        inhale = findViewById(R.id.inhale);

        //optional anim
            btnstop.setAlpha(0);
            inhale.setAlpha(0);

        //load anim
       roundingalone = AnimationUtils.loadAnimation(this,R.anim.roundingalone);
       atg = AnimationUtils.loadAnimation(this,R.anim.atg);
       in = AnimationUtils.loadAnimation(this,R.anim.in);

        //pass
       bgcircle.startAnimation(atg);
       icanchor.startAnimation(atg);

        //import font
        Typeface MMedium = Typeface.createFromAsset(getAssets(),"fonts/MMedium.ttf");

        //custom size
        btnstart.setTypeface(MMedium);
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //pass anim
                icanchor.startAnimation(roundingalone);
                btnstop.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnstart.animate().alpha(0).setDuration(300);
                inhale.animate().alpha(1);
                inhale.startAnimation(in);

            }
        });

        //custom size
        btnstop.setTypeface(MMedium);
        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //stop anim
                icanchor.clearAnimation();
                btnstart.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnstop.animate().alpha(0).setDuration(300);
                inhale.setAlpha(0);
                inhale.clearAnimation();
               // timehere.stop();
                
            }
        });
    }
}