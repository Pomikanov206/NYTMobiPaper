package com.example.pomik.nytmobipaper.presenter;

import com.example.pomik.nytmobipaper.model.retrofit.RetrofitController;
import com.example.pomik.nytmobipaper.model.retrofit.mostviewed.MostViewed;
import com.example.pomik.nytmobipaper.view.MostViewedFragment;

public class MostViewedPresenter implements MostViewedRequester{
    private MostViewedFragment view;
    private RetrofitController model;

    public MostViewedPresenter(MostViewedFragment view) {
        this.view = view;
        model = RetrofitController.getInstance();
    }

    public void showMostViewed(MostViewed mostViewed) {
        view.showMostViewed(mostViewed);
    }

    public void requestMostViewed(){
        model.requestMostViewed(this);
    }
}
