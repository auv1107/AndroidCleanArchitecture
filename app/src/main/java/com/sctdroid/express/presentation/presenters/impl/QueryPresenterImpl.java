package com.sctdroid.express.presentation.presenters.impl;

import com.sctdroid.express.domain.executor.Executor;
import com.sctdroid.express.domain.executor.MainThread;
import com.sctdroid.express.domain.interactor.QueryInteractor;
import com.sctdroid.express.domain.interactor.impl.QueryInteractorImpl;
import com.sctdroid.express.domain.repository.DataRepository;
import com.sctdroid.express.presentation.presenters.QueryPresenter;
import com.sctdroid.express.presentation.presenters.base.AbstractPresenter;

/**
 * Created by lixindong on 3/4/16.
 */
public class QueryPresenterImpl extends AbstractPresenter implements QueryPresenter, QueryInteractor.Callback{
    private View mView;
    private DataRepository mDataRepository;

    public QueryPresenterImpl(Executor executor, MainThread mainThread, View view, DataRepository dataRepository) {
        super(executor, mainThread);
        mView = view;
        mDataRepository = dataRepository;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onDataRetrieved(String data) {
        mView.displayData(data);
    }

    @Override
    public void onRetrievalFailed(String data) {
        mView.showError(data);
    }

    @Override
    public void query() {
        QueryInteractor interactor = new QueryInteractorImpl(mExecutor, mMainThread, this, mDataRepository);
        interactor.setParams(mView.obtainQueryData());
        interactor.execute();
    }
}
