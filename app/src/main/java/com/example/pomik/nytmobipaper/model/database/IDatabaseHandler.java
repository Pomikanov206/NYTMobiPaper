package com.example.pomik.nytmobipaper.model.database;

import com.example.pomik.nytmobipaper.model.retrofit.mostemailed.MostEmailedResult;
import com.example.pomik.nytmobipaper.model.retrofit.mostshared.MostSharedResult;
import com.example.pomik.nytmobipaper.model.retrofit.mostviewed.MostViewedResult;

import java.util.List;

public interface IDatabaseHandler {
    void addMostEmailed(MostEmailedResult mostEmailed);
    void addMostShared(MostSharedResult mostShared);
    void addMostViewed(MostViewedResult mostViewed);

    MostEmailedResult getMostEmailed(int id);
    MostSharedResult getMostShared(int id);
    MostViewedResult getMostViewed(int id);

    List<MostEmailedResult> getAllMostEmailed();
    List<MostSharedResult> getAllMostShared();
    List<MostViewedResult> getAllMostViewed();

    int getCountMostEmailed();
    int getCountMostShared();
    int getCountMostViewed();

    void deleteMostEmailed(MostEmailedResult mostEmailed);
    void deleteMostShared(MostSharedResult mostShared);
    void deleteMostViewed(MostViewedResult mostViewed);
}
