package com.compassit.API.stackoverflow;

import com.compassit.API.hh.Vacancy;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Севастьян on 30.09.2017.
 */

public interface APIStackoverflow {
    @GET("/2.2/tags?order=desc&sort=popular&site=stackoverflow")
    Call<ListStack> getStackPage(@Query("page") int page);
}
