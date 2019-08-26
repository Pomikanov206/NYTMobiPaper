package com.example.pomik.nytmobipaper.model.database;

import android.content.Context;
import com.example.pomik.nytmobipaper.model.Favorite;

import java.sql.SQLException;
import java.util.List;

public class FavoritesDatabaseModel{
    private Context context;
    private DatabaseHelper databaseHandler;

    private static volatile FavoritesDatabaseModel instance;

    private FavoritesDatabaseModel(){
        if (databaseHandler == null)
            databaseHandler = new DatabaseHelper(context);
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public static FavoritesDatabaseModel getInstance() {
        if (instance == null)
            synchronized (FavoritesDatabaseModel.class) {
                if(instance == null)
                    instance = new FavoritesDatabaseModel();
            }
        return instance;
    }

    public void addToDB(Favorite favorite) {
        try {
            System.out.println(favorite.getTitle());
            databaseHandler.getFavoritesDAO().create(favorite);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeFromDB(Favorite favorite) {
        try {
            databaseHandler.getFavoritesDAO().delete(favorite);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Favorite> getAllFromDB(){
        try {
            return databaseHandler.getFavoritesDAO().getAllFavorites();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
