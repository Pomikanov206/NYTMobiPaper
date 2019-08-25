package com.example.pomik.nytmobipaper.model.database;

import com.example.pomik.nytmobipaper.model.retrofit.mostshared.MostSharedResult;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

public class MostSharedDAO extends BaseDaoImpl<MostSharedResult, Integer> {
    protected MostSharedDAO(ConnectionSource connectionSource,
                            Class<MostSharedResult> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<MostSharedResult> getAllMostShared() throws SQLException {
        return this.queryForAll();
    }
}
