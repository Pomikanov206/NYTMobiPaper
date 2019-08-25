package com.example.pomik.nytmobipaper.presenter;

import com.example.pomik.nytmobipaper.model.retrofit.RetrofitController;
import com.example.pomik.nytmobipaper.model.retrofit.mostemailed.MostEmailed;
import com.example.pomik.nytmobipaper.model.retrofit.mostshared.MostShared;
import com.example.pomik.nytmobipaper.model.retrofit.mostviewed.MostViewed;
import com.example.pomik.nytmobipaper.view.console.ConsoleView;

public class ConsolePresenter implements MostEmailedRequester, MostSharedRequester, MostViewedRequester {
    private ConsoleView consoleView;
    private RetrofitController controller;

    public ConsolePresenter(ConsoleView consoleView) {
        controller = RetrofitController.getInstance();
        this.consoleView = consoleView;
    }

    public void showMostEmailed(MostEmailed mostEmailed){
        consoleView.showMostEmailed(mostEmailed);
    }
    public void showMostShared(MostShared mostShared){
        consoleView.showMostShared(mostShared);
    }
    public void showMostViewed(MostViewed mostViewed){
        consoleView.showMostViewed(mostViewed);
    }

    public void requestMostEmailed() {
        controller.requestMostEmailed(this);
    }
    public void requestMostShared() {
            controller.requestMostShared(this);
        }
    public void requestMostViewed() {
            controller.requestMostViewed(this);
        }

}
