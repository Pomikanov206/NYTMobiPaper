package com.example.pomik.nytmobipaper.presenter;

import com.example.pomik.nytmobipaper.model.retrofit.RetrofitController;
import com.example.pomik.nytmobipaper.model.retrofit.mostemailed.MostEmailed;
import com.example.pomik.nytmobipaper.view.MostEmailedFragment;

public class MostEmailedPresenter implements MostEmailedRequester{
    private MostEmailedFragment view;
    private RetrofitController model;

    public MostEmailedPresenter(MostEmailedFragment view) {
        this.view = view;
        model = RetrofitController.getInstance();
    }

    public void showMostEmailed(MostEmailed mostEmailed){
        view.showMostEmailed(mostEmailed);
    }

    public void requestMostEmailed() {
        model.requestMostEmailed(this);
    }
}
