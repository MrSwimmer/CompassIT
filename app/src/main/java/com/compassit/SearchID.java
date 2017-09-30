package com.compassit;

import android.os.AsyncTask;
import android.util.Log;

import com.compassit.API.hh.APIService;
import com.compassit.API.hh.PageV;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Севастьян on 29.09.2017.
 */

public class SearchID extends AsyncTask<Void, Integer, Integer> {

    private APIService service;
    ArrayList<String> masid = new ArrayList<String>();
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }
    @Override
    protected Integer doInBackground(Void... params) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.hh.ru")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(APIService.class);
        for(int i=1; i<70; i++){
            Call<PageV> call = service.getListURL("Android разработчик", i);
            final int finalI = i;
            //Log.i("code", "req: " +" json: "+call.request().toString());
            call.enqueue(new Callback<PageV>() {
                @Override
                public void onResponse(Call<PageV> call, Response<PageV> response) {
                    PageV page = response.body();
                    //Log.i("code", "page: "+ finalI +" json: "+page.getItems().get(1).getName().toString());
                    for(int j=0; j<20; j++) {
                        String buf = page.getItems().get(j).getName();
                        Log.i("code", buf);
                        masid.add(page.getItems().get(j).getId());
                        }
                    }
                    //Log.i("code", "page: "+ finalI +" json: "+buf);
                @Override
                public void onFailure(Call<PageV> call, Throwable t) {
                    Log.i("code", t.toString());
                }
            });
        }
        return null;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);

    }

}