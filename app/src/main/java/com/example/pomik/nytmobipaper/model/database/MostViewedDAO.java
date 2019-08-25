package com.example.pomik.nytmobipaper.model.database;

import com.example.pomik.nytmobipaper.model.retrofit.mostviewed.MostViewedResult;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

public class MostViewedDAO extends BaseDaoImpl<MostViewedResult, Integer> {
    protected MostViewedDAO(ConnectionSource connectionSource,
                            Class<MostViewedResult> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<MostViewedResult> getAllMostViewed() throws SQLException {
        return this.queryForAll();
    }
}
