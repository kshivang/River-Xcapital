package com.xcapital.river.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.xcapital.river.R;
import com.xcapital.river.misc.LocalDatabase;

/**
 * Created by kshivang on 07/03/17.
 *
 */

public class SplashActivity extends AppCompatActivity {

    private Boolean isAnimationFinished = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        Animation bounceAnim = AnimationUtils
                .loadAnimation(getApplicationContext(), R.anim.bounce);

        findViewById(R.id.company_title).setAnimation(bounceAnim);

        bounceAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                animationsFinished();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void animationsFinished() {
        isAnimationFinished = true;
        //transit to another activity here
        //or do whatever you want
        LocalDatabase localDatabase = new LocalDatabase(SplashActivity.this);
        startActivity(new Intent(SplashActivity.this,
                localDatabase.checkFirstRun() ?
                        (localDatabase.checkLogin() ?
                                SwipeActivity.class :
                                LoginActivity.class) : BriefIntroActivity.class));
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(isAnimationFinished) {
            finish();
        }
    }

}
