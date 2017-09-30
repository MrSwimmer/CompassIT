package com.compassit;

import android.app.Activity;

import com.compassit.API.hh.APIService;
import com.compassit.API.hh.Vacancy;

import java.util.ArrayList;

public class SplashActivity extends Activity {

    private APIService service;
    ArrayList<String> masid = new ArrayList<String>();
    ArrayList<Vacancy> masvac = new ArrayList<Vacancy>();
    String KeyWords[] = new String[10];
    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.splash);
        SearchStack searchStack = new SearchStack();
        searchStack.execute();
       //////////////////////////////////////////
//        SearchID searchID = new SearchID();
//        searchID.execute();
        ///////////////////////////////////////////

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://api.hh.ru")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        service = retrofit.create(APIService.class);
//        for(int i=1; i<70; i++){
//            Call<PageV> call = service.getListURL("Android разработчик", i);
//            final int finalI = i;
//            //Log.i("code", "req: " +" json: "+call.request().toString());
//            call.enqueue(new Callback<PageV>() {
//                @Override
//                public void onResponse(Call<PageV> call, Response<PageV> response) {
//                    PageV page = response.body();
//                    //Log.i("code", "page: "+ finalI +" json: "+page.getItems().get(1).getName().toString());
//                    for(int j=0; j<20; j++) {
//                        String buf = page.getItems().get(j).getName();
//                        if(buf.contains("Android")||buf.contains("Андроид")||buf.contains("Андроид")){
//                            Log.i("code", buf);
//                            masid.add(page.getItems().get(j).getId().toString());
//                        }
//                    }
//                    //Log.i("code", "page: "+ finalI +" json: "+buf);
//                }
//                @Override
//                public void onFailure(Call<PageV> call, Throwable t) {
//                    Log.i("code", t.toString());
//                }
//            });
//        }

//        final TaskStackBuilder task = TaskStackBuilder.create(getApplicationContext())
//                .addNextIntentWithParentStack(new Intent(getApplicationContext(), MainActivity.class));
//                //.addNextIntent(new Intent(getApplicationContext(), FirstStartActivity.class));
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                task.startActivities();
//            }
//        }, 2000);
    }
}