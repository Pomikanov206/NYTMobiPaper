package com.example.pomik.nytmobipaper.model.database;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class FavoritesDatabaseModel extends Service {
    private Context context;
    private DatabaseHandler databaseHandler;

    @Override
    public void onCreate() {
        context = getApplicationContext();
        databaseHandler = new DatabaseHandler(context);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
