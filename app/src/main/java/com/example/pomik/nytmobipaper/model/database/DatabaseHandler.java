package com.example.pomik.nytmobipaper.model.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.example.pomik.nytmobipaper.model.Favorite;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper implements IDatabaseHandler {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "favoriteDB";
    private static final String TABLE_FAVORITES = "favorites";
    private static final String KEY_ID = "id";
    private static final String TITLE = "title";
    private static final String ABSTRACT = "abstract";
    private static final String IMAGE_URI = "image_uri";
    private static final String PUBLISHED_DATE = "published_date";

    private static volatile DatabaseHandler instance;

    private DatabaseHandler(Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DatabaseHandler getInstance(Context context) {
        if (instance == null)
            synchronized (DatabaseHandler.class) {
                if (instance == null)
                    instance = new DatabaseHandler(context);
            }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d("favorite_log", "--- onCreate database ---");
        String CREATE_FAVORITES_TABLE = "CREATE TABLE " + TABLE_FAVORITES + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + TITLE + " TEXT,"
                + ABSTRACT + " TEXT," + IMAGE_URI + " TEXT,"
                + PUBLISHED_DATE + " TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_FAVORITES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_FAVORITES);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void addFavorite(Favorite favorite) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID, favorite.getId());
        values.put(TITLE, favorite.getTitle());
        values.put(ABSTRACT, favorite.getArticleAbstract());
        values.put(IMAGE_URI, favorite.getArticleIconAddres());
        values.put(PUBLISHED_DATE, favorite.getPublishedDate());

        db.insert(TABLE_FAVORITES, null, values);
        db.close();
    }

    @Override
    public Favorite getFavorite(int id) {
        return null;
    }

    @Override
    public List<Favorite> getAllFavorites() {
        List<Favorite> favoriteList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_FAVORITES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()) {
            do {
                int i = 0;
                Favorite favorite = new Favorite();
                favorite.setId(Long.parseLong(cursor.getString(i++)));
                favorite.setTitle(cursor.getString(i++));
                favorite.setArticleAbstract(cursor.getString(i++));
                favorite.setArticleIconAddres(cursor.getString(i++));
                favorite.setPublishedDate(cursor.getString(i++));
                favoriteList.add(favorite);
            } while (cursor.moveToNext());
        }
        return favoriteList;
    }

    @Override
    public int getCountFavorites() {
        String countQuety = "SELECT * FROM " + TABLE_FAVORITES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuety, null);
        db.close();
        return cursor.getCount();
    }

    @Override
    public void deleteFavorite(Favorite favorite) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_FAVORITES, KEY_ID + " = ?", new String[] {String.valueOf(favorite.getId())});
        db.close();
    }

    @Override
    public boolean isContains(String string) {
        return false;
    }
}
