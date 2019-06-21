package com.kesehatan.klinikhusada;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.linear);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fadeout);

        linearLayout.startAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent open = new Intent(MainActivity.this, ActivityLogin.class);
                startActivity(open);
                finish();
            }
        }, 5000);
    }

}
