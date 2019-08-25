package com.example.pomik.nytmobipaper.model.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.example.pomik.nytmobipaper.model.retrofit.mostemailed.MostEmailedResult;
import com.example.pomik.nytmobipaper.model.retrofit.mostshared.MostSharedResult;
import com.example.pomik.nytmobipaper.model.retrofit.mostviewed.MostViewedResult;

import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper implements IDatabaseHandler {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "favoriteDB";


    public DatabaseHandler(Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d("favorite_log", "--- onCreate database ---");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    @Override
    public void addMostEmailed(MostEmailedResult mostEmailed) {

    }

    @Override
    public void addMostShared(MostSharedResult mostShared) {

    }

    @Override
    public void addMostViewed(MostViewedResult mostViewed) {

    }

    @Override
    public MostEmailedResult getMostEmailed(int id) {
        return null;
    }

    @Override
    public MostSharedResult getMostShared(int id) {
        return null;
    }

    @Override
    public MostViewedResult getMostViewed(int id) {
        return null;
    }

    @Override
    public List<MostEmailedResult> getAllMostEmailed() {
        return null;
    }

    @Override
    public List<MostSharedResult> getAllMostShared() {
        return null;
    }

    @Override
    public List<MostViewedResult> getAllMostViewed() {
        return null;
    }

    @Override
    public int getCountMostEmailed() {
        return 0;
    }

    @Override
    public int getCountMostShared() {
        return 0;
    }

    @Override
    public int getCountMostViewed() {
        return 0;
    }

    @Override
    public void deleteMostEmailed(MostEmailedResult mostEmailed) {

    }

    @Override
    public void deleteMostShared(MostSharedResult mostShared) {

    }

    @Override
    public void deleteMostViewed(MostViewedResult mostViewed) {

    }
}
