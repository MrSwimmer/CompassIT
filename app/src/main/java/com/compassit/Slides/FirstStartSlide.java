package com.compassit.Slides;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.compassit.Intro.FirstStartActivity;
import com.compassit.Intro.WhoActivityIntro;
import com.compassit.R;

import agency.tango.materialintroscreen.SlideFragment;



/**
 * Created by Севастьян on 21.09.2017.
 */

public class FirstStartSlide extends SlideFragment {
    Button Yes, No;
    final String SAVED_TEXT = "saved_text";
    public static boolean Choice;
    SharedPreferences sPref;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_first_start, container, false);
        Yes = (Button) view.findViewById(R.id.yesbut);
        No = (Button) view.findViewById(R.id.nobut);
        Yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), WhoActivityIntro.class);
                startActivity(i);
                getActivity().finish();
            }
        });
        No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }



    @Override
    public int backgroundColor() {
        return R.color.custom_slide_background;
    }

    @Override
    public int buttonsColor() {
        return R.color.custom_slide_buttons;
    }

    @Override
    public String cantMoveFurtherErrorMessage() {
        return getString(R.string.error_message);
    }
}
