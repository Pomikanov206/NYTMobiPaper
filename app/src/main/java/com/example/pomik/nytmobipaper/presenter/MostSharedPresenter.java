package com.example.pomik.nytmobipaper.presenter;

import com.example.pomik.nytmobipaper.model.retrofit.RetrofitController;
import com.example.pomik.nytmobipaper.model.retrofit.mostshared.MostShared;
import com.example.pomik.nytmobipaper.view.MostSharedFragment;

public class MostSharedPresenter implements MostSharedRequester{
    private MostSharedFragment view;
    private RetrofitController model;

    public MostSharedPresenter(MostSharedFragment view) {
        this.view = view;
        model = RetrofitController.getInstance();
    }

    public void showMostShared(MostShared mostShared) {
        view.showMostShared(mostShared);
    }
    public void requestMostShared(){
        model.requestMostShared(this);
    }
}
