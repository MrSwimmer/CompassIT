package com.compassit;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.TaskStackBuilder;

import com.compassit.Intro.FirstStartActivity;

public class SplashActivity extends Activity {

    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.splash);
        final TaskStackBuilder task = TaskStackBuilder.create(getApplicationContext())
                .addNextIntentWithParentStack(new Intent(getApplicationContext(), MainActivity.class))
                .addNextIntent(new Intent(getApplicationContext(), FirstStartActivity.class));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                task.startActivities();
            }
        }, 2000);
    }


}