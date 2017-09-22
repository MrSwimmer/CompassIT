package com.compassit.Intro;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.compassit.R;
import com.compassit.Slides.LevelSlide;
import com.compassit.Slides.ProfessionSlide;

import agency.tango.materialintroscreen.MaterialIntroActivity;
import agency.tango.materialintroscreen.SlideFragmentBuilder;
import agency.tango.materialintroscreen.animations.IViewTranslation;

public class FirstStartActivity extends MaterialIntroActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enableLastSlideAlphaExitTransition(true);
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        Boolean YesOrNo = sharedPref.getBoolean("firststart", false);
        Log.i("choice", YesOrNo.toString());
        if(!YesOrNo){
            getBackButtonTranslationWrapper()
                    .setEnterTranslation(new IViewTranslation() {
                        @Override
                        public void translate(View view, @FloatRange(from = 0, to = 1.0) float percentage) {
                            view.setAlpha(percentage);
                        }
                    });
            addSlide(new SlideFragmentBuilder()
                    .backgroundColor(R.color.first_slide_background)
                    .buttonsColor(R.color.first_slide_buttons)
                    .title("IT Компас")
                    .description("Найди себя в IT!")
                    .build());
            addSlide(new SlideFragmentBuilder()
                    .backgroundColor(R.color.second_slide_background)
                    .buttonsColor(R.color.second_slide_buttons)
                    .title("Кто ты?")
                    .description("Новичок Junior? Продвинутый Middle или Гуру-Senior? Неважно, здесь каждый найдет ответы!")
                    .build());

            addSlide(new SlideFragmentBuilder()
                    .backgroundColor(R.color.third_slide_background)
                    .buttonsColor(R.color.third_slide_buttons)
//                        .possiblePermissions(new String[]{Manifest.permission.CALL_PHONE, Manifest.permission.READ_SMS})
//                        .neededPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})
                    .title("Годный стэк технологий")
                    .description("Если вы ищете направление для развития, то подборка популярных технологий его вам предоставит!")
                    .build());

            addSlide(new ProfessionSlide());
            addSlide(new );
        }
        else {

        }
    }

    @Override
    public void onFinish() {
        super.onFinish();
        Toast.makeText(this, "Try this library in your project! :)", Toast.LENGTH_SHORT).show();
    }
}