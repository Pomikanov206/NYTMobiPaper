package com.example.pomik.nytmobipaper.service;

import com.example.pomik.nytmobipaper.model.retrofit.mostemailed.MostEmailed;
import com.example.pomik.nytmobipaper.model.retrofit.mostshared.MostShared;
import com.example.pomik.nytmobipaper.model.retrofit.mostviewed.MostViewed;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NYTService {
    @GET("emailed/30.json")
    Call<MostEmailed> mostEmailed(@Query("api-key") String api_key);

    @GET("shared/30.json")
    Call<MostShared> mostShared(@Query("api-key") String api_key);

    @GET("viewed/30.json")
    Call<MostViewed> mostViewed(@Query("api-key") String api_key);
}
