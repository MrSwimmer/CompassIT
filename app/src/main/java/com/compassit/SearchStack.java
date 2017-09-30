package com.compassit;

import android.os.AsyncTask;
import android.util.Log;

import com.compassit.API.hh.APIService;
import com.compassit.API.stackoverflow.APIStackoverflow;
import com.compassit.API.stackoverflow.ListStack;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Севастьян on 30.09.2017.
 */

public class SearchStack extends AsyncTask<Void, Integer, Integer> {
    ArrayList<String> mastech = new ArrayList<String>();
    private APIStackoverflow service;

    @Override
    protected Integer doInBackground(Void... params) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.stackexchange.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(APIStackoverflow.class);
        for(int i=1; i<1600; i++){
            Call<ListStack> call = service.getStackPage(i);
            final int finalI = i;
            Log.i("code", call.request().toString());
            call.enqueue(new Callback<ListStack>() {
                @Override
                public void onResponse(Call<ListStack> call, Response<ListStack> response) {
                    Log.i("code", call.request().toString() + " ");
                    //ListStack listStack = response.body();
                    //Log.i("code", response.body().getItems().get(1).getName());
//                    for(int j=0; j<10; j++){
//                        String name = listStack.getItems().get(j).getName();
//                        Log.i("code", "name: "+name);
//                    }
                }

                @Override
                public void onFailure(Call<ListStack> call, Throwable t) {
                    Log.i("code", "err "+t.toString());
                }
            });
        }
        return null;
    }
}
