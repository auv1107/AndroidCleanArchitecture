package com.sctdroid.express.domain.interactor.impl;

import com.sctdroid.express.domain.executor.Executor;
import com.sctdroid.express.domain.executor.MainThread;
import com.sctdroid.express.domain.interactor.QueryInteractor;
import com.sctdroid.express.domain.interactor.base.AbstractInteractor;
import com.sctdroid.express.domain.repository.DataRepository;

/**
 * Created by lixindong on 3/4/16.
 */
public class QueryInteractorImpl extends AbstractInteractor implements QueryInteractor {
    DataRepository mDataRepository;
    Callback mCallback;
    String mParams;

    public QueryInteractorImpl(Executor executor, MainThread mainThread, QueryInteractor.Callback callback, DataRepository dataRepository) {
        super(executor, mainThread);
        mDataRepository = dataRepository;
        mCallback = callback;
    }

    @Override
    public void setParams(String params) {
        mParams = params;
    }

    @Override
    public void run() {
        String data = mDataRepository.getData(mParams);
        if (data == null || data.length() == 0) {
            showError(data);
            return;
        }

        postData(data);
    }

    private void postData(final String data) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onDataRetrieved(data);
            }
        });
    }

    private void showError(final String data) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onRetrievalFailed(data);
            }
        });
    }
}
