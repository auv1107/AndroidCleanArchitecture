package com.sctdroid.express.presentation.presenters.base;

import com.sctdroid.express.domain.executor.Executor;
import com.sctdroid.express.domain.executor.MainThread;

/**
 * Created by lixindong on 3/4/16.
 */
public abstract class AbstractPresenter {
    protected Executor mExecutor;
    protected MainThread mMainThread;

    public AbstractPresenter(Executor executor, MainThread mainThread) {
        mExecutor = executor;
        mMainThread = mainThread;
    }
}
