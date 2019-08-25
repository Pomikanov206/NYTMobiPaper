package com.example.pomik.nytmobipaper.view;

import com.example.pomik.nytmobipaper.model.retrofit.mostemailed.MostEmailed;
import com.example.pomik.nytmobipaper.model.retrofit.mostshared.MostShared;
import com.example.pomik.nytmobipaper.model.retrofit.mostviewed.MostViewed;

public interface MostPopularDisplayed {
    interface MostEmailedDisplayed extends MostPopularDisplayed{
        void showMostEmailed(MostEmailed mostEmailed);
    }
    public interface MostSharedDisplayed extends MostPopularDisplayed{
        void showMostShared(MostShared mostShared);
    }
    public interface MostViewdDisplayed extends MostPopularDisplayed{
        void showMostViewed(MostViewed mostViewed);
    }

    interface FavoritesDisplayed extends MostPopularDisplayed {
        void showFavorites();
    }
}
