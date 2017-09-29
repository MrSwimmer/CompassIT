package com.compassit.API;

import com.compassit.API.GETPage.PageV;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Севастьян on 26.09.2017.
 */

public interface APIService {

    @GET("/vacancies/{id}")
    Call<Vacancy> getVacancy(@Path("id") long groupId);
    @GET("/vacancies")
    Call<PageV> getListURL(@Query("text") String text, @Query("page") int page);
}