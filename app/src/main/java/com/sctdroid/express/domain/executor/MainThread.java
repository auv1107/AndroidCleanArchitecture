package com.sctdroid.express.domain.executor;

/**
 * Created by lixindong on 3/4/16.
 */
public interface MainThread {
    void post(final Runnable runnable);
}
