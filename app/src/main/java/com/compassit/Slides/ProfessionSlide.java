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

public class ProfessionSlide extends SlideFragment {
    Button Boss, PM, QA, SQL, Writer, Proger, UIUX, HR, Unknow;
    String Choice = "nothing";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.profession_slide, container, false);

        Boss = (Button) view.findViewById(R.id.boss);
        PM = (Button) view.findViewById(R.id.pm);
        QA = (Button) view.findViewById(R.id.QA);
        SQL = (Button) view.findViewById(R.id.sql);
        Writer = (Button) view.findViewById(R.id.writer);
        Proger = (Button) view.findViewById(R.id.proger);
        UIUX = (Button) view.findViewById(R.id.uiux);
        HR = (Button) view.findViewById(R.id.hr);
        Unknow = (Button) view.findViewById(R.id.unknow);

        Boss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Choice = "boss";
            }
        });
        Unknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Choice = "lamer";
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
