package com.compassit;

import android.app.Activity;
import android.content.res.AssetManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.compassit.API.hh.APIService;
import com.compassit.API.hh.GETVacancy.Vacancy;
import com.compassit.Realm.VacancysSkills;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.List;


import io.realm.Realm;
import io.realm.RealmResults;

public class SplashActivity extends Activity {

    private APIService service;
    List<Skill> masskills = new ArrayList<Skill>();
    public static ArrayList<String> stackskills = new ArrayList<String >();
    public static Realm mRealm;
    private Button getTop;
    public static TextView txt_percentage;
    public static String allStack;

    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.splash);

        getTop = (Button) findViewById(R.id.getTop);
        txt_percentage= (TextView) findViewById(R.id.txt_percentage);

        ParseStackFromFile();

        Skill skill = new Skill();
        skill.setSkill("android");
        masskills.add(skill);

        SearchID searchID = new SearchID();
        searchID.execute("android");

        mRealm = Realm.getInstance(this);

        getTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRealm.beginTransaction();

                RealmResults<VacancysSkills> books = mRealm.allObjects(VacancysSkills.class);

                if(!books.isEmpty()) {

                    for(int i = books.size() - 1; i >= 0; i--) {

                        String skills = books.get(i).getSkills();
                        String area = books.get(i).getArea();
                        int pos=0;
                        for(int k=0; k<skills.length();k++){
                            if(skills.charAt(k)==','){
                                String sub = skills.substring(pos,k).toLowerCase();
                                boolean meet = false;
                                for(int p=0; p<masskills.size(); p++){
                                    //Log.i("code", masskills.get(p).getSkill()+" "+ sub);
                                    if(masskills.get(p).getSkill().equals(sub)){
                                        masskills.get(p).addCount();
                                        meet = true;
                                        break;
                                    }
                                    else {

                                    }
                                }
                                if(!meet){
                                    Skill skill = new Skill();
                                    skill.setSkill(sub);
                                    skill.addCount();
                                    masskills.add(skill);
                                }
                                pos=k+1;
                            }
                        }
                    }
//                    Collections.sort(masskills, new Comparator<Skill>() {
//                        @Override
//                        public int compare(Skill o1, Skill o2) {
//                            return o1.toString().compareTo(o2.toString());
//                        }
//                    });
                    for(int p=0; p<masskills.size(); p++){
                        Log.i("code", "s: "+masskills.get(p).getSkill()+ " c: "+masskills.get(p).getCount());
                    }
                }
                mRealm.commitTransaction();
            }
        });

    }
    void ParseStackFromFile(){
        AssetManager am = this.getAssets();
        InputStream is = null;
        try {
            is = am.open("parser.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader r = new BufferedReader(new InputStreamReader(is));
        StringBuilder total = new StringBuilder();
        String line = "+";
        try {
            while ((line = r.readLine()) != null) {
                total.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        allStack = total.toString();
        int pos=0;
        for(int i=0; i<allStack.length(); i++){
            if(allStack.charAt(i)==','){
                stackskills.add(allStack.substring(pos, i));
                pos=i+1;
            }
        }
    }
}