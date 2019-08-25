package com.example.pomik.nytmobipaper.model.database;

import com.example.pomik.nytmobipaper.model.retrofit.mostemailed.MostEmailedResult;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

public class MostEmailedDAO extends BaseDaoImpl<MostEmailedResult, Integer> {
    protected MostEmailedDAO (ConnectionSource connectionSource,
                              Class<MostEmailedResult> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<MostEmailedResult> getAllMostEmailed() throws SQLException {
        return this.queryForAll();
    }
}
