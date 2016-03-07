package com.sctdroid.express.domain.interactor.base;

import com.sctdroid.express.domain.executor.Executor;
import com.sctdroid.express.domain.executor.MainThread;

/**
 * Created by lixindong on 3/4/16.
 */
public abstract class AbstractInteractor implements Interactor {
    protected Executor mThreadExecutor;
    protected MainThread mMainThread;

    protected volatile boolean mIsCanceled;
    protected volatile boolean mIsRunning;

    public AbstractInteractor(Executor executor, MainThread mainThread) {
        mThreadExecutor = executor;
        mMainThread = mainThread;
    }
    @Override
    public void execute() {
        this.mIsRunning = true;
        mThreadExecutor.execute(this);
    }

    public abstract void run();

    public void cancel() {
        mIsCanceled = true;
        mIsRunning = false;
    }

    public boolean isRunning() {
        return mIsRunning;
    }

    public void onFinished() {
        mIsCanceled = false;
        mIsRunning = false;
    }
}
