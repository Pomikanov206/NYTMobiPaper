package com.example.pomik.nytmobipaper.model.database;

import com.example.pomik.nytmobipaper.model.Favorite;

import java.util.List;

public interface IDatabaseHandler {
    void addFavorite(Favorite favorite);

    Favorite getFavorite(int id);

    List<Favorite> getAllFavorites();

    int getCountFavorites();

    void deleteFavorite(Favorite favorite);

    boolean isContains(String string);
}
