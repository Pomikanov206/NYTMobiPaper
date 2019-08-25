package com.example.pomik.nytmobipaper.model.retrofit;

import com.example.pomik.nytmobipaper.deserializer.MostEmailedResultDeserializer;
import com.example.pomik.nytmobipaper.deserializer.MostSharedResultDeserializer;
import com.example.pomik.nytmobipaper.deserializer.MostViewedResultDeserializer;
import com.example.pomik.nytmobipaper.model.retrofit.mostemailed.MostEmailed;
import com.example.pomik.nytmobipaper.model.retrofit.mostemailed.MostEmailedResult;
import com.example.pomik.nytmobipaper.model.retrofit.mostshared.MostShared;
import com.example.pomik.nytmobipaper.model.retrofit.mostshared.MostSharedResult;
import com.example.pomik.nytmobipaper.model.retrofit.mostviewed.MostViewed;
import com.example.pomik.nytmobipaper.model.retrofit.mostviewed.MostViewedResult;
import com.example.pomik.nytmobipaper.presenter.MostEmailedRequester;
import com.example.pomik.nytmobipaper.presenter.MostSharedRequester;
import com.example.pomik.nytmobipaper.presenter.MostViewedRequester;
import com.example.pomik.nytmobipaper.service.NYTService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitController {
    private static volatile RetrofitController instance;

    private static final String API_KEY = "G7ImcMtFLiHwR4pJBJeK1PGhg6wCdyiG";
    private static final String BASE_URL = "https://api.nytimes.com/svc/mostpopular/v2/";

    private NYTService nytService;
    private MostEmailed emailed;
    private MostShared shared;
    private MostViewed viewed;

    private RetrofitController(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder
                .registerTypeAdapter(MostEmailedResult.class, new MostEmailedResultDeserializer())
                .registerTypeAdapter(MostSharedResult.class, new MostSharedResultDeserializer())
                .registerTypeAdapter(MostViewedResult.class, new MostViewedResultDeserializer());
        Gson gson = gsonBuilder.create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        nytService = retrofit.create(NYTService.class);
    }

    public static RetrofitController getInstance() {
        if (instance == null)
            synchronized (RetrofitController.class) {
            if(instance == null)
                instance = new RetrofitController();
            }
        return instance;
    }

    public void requestMostEmailed(MostEmailedRequester presenter){
        nytService.mostEmailed(API_KEY).enqueue(new Callback<MostEmailed>() {
            @Override
            public void onResponse(Call<MostEmailed> call, Response<MostEmailed> response) {
                if(response.isSuccessful()) {
                    if (response.body() == null)
                        System.out.println("NULL");
                    emailed = response.body();
                    presenter.showMostEmailed(emailed);
                } else {
                    switch (response.code()) {
                        case 401:
                            System.out.println("401");break;
                        case 429:
                            System.out.println("429");break;
                            default: {
                                System.out.println(response.message());
                                System.out.println(response.errorBody());
                            }
                    }
                }
            }

            @Override
            public void onFailure(Call<MostEmailed> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void requestMostShared(MostSharedRequester presenter){
        nytService.mostShared(API_KEY).enqueue(new Callback<MostShared>() {
            @Override
            public void onResponse(Call<MostShared> call, Response<MostShared> response) {
                if(response.isSuccessful()) {
                    if (response.body() == null)
                        System.out.println("NULL");
                    shared = response.body();
                    presenter.showMostShared(shared);
                } else {
                    switch (response.code()) {
                        case 401:
                            System.out.println("401");break;
                        case 429:
                            System.out.println("429");break;
                            default: {
                                System.out.println(response.message());
                                System.out.println(response.errorBody());
                            }
                    }
                }
            }

            @Override
            public void onFailure(Call<MostShared> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void requestMostViewed(MostViewedRequester presenter){
        nytService.mostViewed(API_KEY).enqueue(new Callback<MostViewed>() {
            @Override
            public void onResponse(Call<MostViewed> call, Response<MostViewed> response) {
                if(response.isSuccessful()) {
                    if (response.body() == null)
                        System.out.println("NULL");
                    viewed = response.body();
                    presenter.showMostViewed(viewed);
                } else {
                    switch (response.code()) {
                        case 401:
                            System.out.println("401");break;
                        case 429:
                            System.out.println("429");break;
                            default: {
                                System.out.println(response.message());
                                System.out.println(response.errorBody());
                            }
                    }
                }
            }

            @Override
            public void onFailure(Call<MostViewed> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
