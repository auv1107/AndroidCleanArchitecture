package com.sctdroid.express.domain.interactor;

import com.sctdroid.express.domain.interactor.base.Interactor;

/**
 * Created by lixindong on 3/4/16.
 */
public interface QueryInteractor extends Interactor {
    interface Callback {
        void onDataRetrieved(String data);
        void onRetrievalFailed(String data);
    }
    void setParams(String params);
}
