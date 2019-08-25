package com.example.pomik.nytmobipaper.model.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.example.pomik.nytmobipaper.model.retrofit.mostemailed.MostEmailedResult;
import com.example.pomik.nytmobipaper.model.retrofit.mostshared.MostSharedResult;
import com.example.pomik.nytmobipaper.model.retrofit.mostviewed.MostViewedResult;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String TAG = DatabaseHelper.class.getSimpleName();

    //имя файла базы данных который будет храниться в /data/data/APPNAME/DATABASE_NAME.db
    private static final String DATABASE_NAME ="favorites.db";

    //с каждым увеличением версии, при нахождении в устройстве БД с предыдущей версией будет выполнен метод onUpgrade();
    private static final int DATABASE_VERSION = 1;

    //ссылки на DAO соответсвующие сущностям, хранимым в БД
    private MostEmailedDAO mostEmailedDao = null;
    private MostSharedDAO mostSharedDao = null;
    private MostViewedDAO mostViewedDao = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, MostEmailedResult.class);
            TableUtils.createTable(connectionSource, MostSharedResult.class);
            TableUtils.createTable(connectionSource, MostViewedResult.class);
        } catch (SQLException e) {
            Log.e(TAG, "error creating DB " + DATABASE_NAME);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            //Так делают ленивые, гораздо предпочтительнее не удаляя БД аккуратно вносить изменения
            TableUtils.dropTable(connectionSource, MostEmailedResult.class, true);
            TableUtils.dropTable(connectionSource, MostSharedResult.class, true);
            TableUtils.dropTable(connectionSource, MostViewedResult.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            Log.e(TAG, "error upgrading db " + DATABASE_NAME + "from ver " + oldVersion);
            throw new RuntimeException(e);
        }
    }

    public MostEmailedDAO getMostEmailedDAO() throws SQLException {
        if (mostEmailedDao == null) {
            mostEmailedDao = new MostEmailedDAO(getConnectionSource(), MostEmailedResult.class);
        }
        return mostEmailedDao;
    }
    public MostSharedDAO getMostSharedDAO() throws SQLException {
        if (mostSharedDao == null) {
            mostSharedDao = new MostSharedDAO(getConnectionSource(), MostSharedResult.class);
        }
        return mostSharedDao;
    }
    public MostViewedDAO getMostViewedDAO() throws SQLException {
        if (mostViewedDao == null) {
            mostViewedDao = new MostViewedDAO(getConnectionSource(), MostViewedResult.class);
        }
        return mostViewedDao;
    }

    @Override
    public void close() {
        super.close();
        mostEmailedDao = null;
    }
}
