package com.example.funnymath;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class WelcomeActivity extends Activity{

    Animation loadAnimation;//实现动画效果
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        requestWindowFeature(Window.FEATURE_NO_TITLE);//使界面无标题

        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        image = (ImageView) findViewById(R.id.image);
        loadAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
        image.startAnimation(loadAnimation);//加载动画，scale动画属性设置

        new Thread() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                super.run();
                try {
                    Thread.sleep(2000);//暂停20s，换到下一个界面去
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }
}
