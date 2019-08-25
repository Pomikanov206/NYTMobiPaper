package com.example.pomik.nytmobipaper.view.console;

import com.example.pomik.nytmobipaper.model.retrofit.mostemailed.MostEmailed;
import com.example.pomik.nytmobipaper.model.retrofit.mostshared.MostShared;
import com.example.pomik.nytmobipaper.model.retrofit.mostviewed.MostViewed;

public interface ConsoleView {
    void showMostEmailed(MostEmailed mostEmailed);
    void showMostShared(MostShared mostShared);
    void showMostViewed(MostViewed mostViewed);
}
