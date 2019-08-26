package com.example.pomik.nytmobipaper.model.database;

import com.example.pomik.nytmobipaper.model.Favorite;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

public class FavoritesDAO extends BaseDaoImpl<Favorite, Integer> {
    protected FavoritesDAO(ConnectionSource connectionSource, Class<Favorite> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<Favorite> getAllFavorites() throws SQLException {
        return this.queryForAll();
    }
}
