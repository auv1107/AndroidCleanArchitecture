package com.sctdroid.express.storage;

import com.sctdroid.express.domain.repository.DataRepository;

/**
 * Created by lixindong on 3/4/16.
 */
public class QueryDataRepository implements DataRepository {
    @Override
    public String getData(String params) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (params == null || params.length() == 0) {
            return null;
        }

        return "Your params are " + params;
    }
}
