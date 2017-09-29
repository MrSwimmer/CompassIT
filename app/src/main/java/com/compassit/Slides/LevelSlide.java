package com.compassit.Slides;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.compassit.R;

import agency.tango.materialintroscreen.SlideFragment;

/**
 * Created by Севастьян on 22.09.2017.
 */

public class LevelSlide extends SlideFragment {
    Button Begginer, Junior, Middle, Senior;
    String Choice = "nothing";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.level_slide, container, false);

        Begginer = (Button) view.findViewById(R.id.beginer);
        Junior = (Button) view.findViewById(R.id.junior);
        Middle = (Button) view.findViewById(R.id.middle);
        Senior = (Button) view.findViewById(R.id.senior);

        Begginer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Choice = "beginer";
            }
        });
        return view;
    }
    @Override
    public boolean canMoveFurther() {
        return Choice!="nothing";
    }
    @Override
    public String cantMoveFurtherErrorMessage() {
        return "Выберете вариант";
    }
    @Override
    public int backgroundColor() {
        return R.color.custom_slide_background;
    }

    @Override
    public int buttonsColor() {
        return R.color.custom_slide_buttons;
    }

}
