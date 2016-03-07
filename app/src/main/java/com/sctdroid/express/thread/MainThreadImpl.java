package com.sctdroid.express.thread;

import android.os.Handler;
import android.os.Looper;

import com.sctdroid.express.domain.executor.MainThread;

/**
 * Created by lixindong on 3/4/16.
 */
public class MainThreadImpl implements MainThread {
    private static MainThread sMainThread;

    private Handler mHandler;

    @Override
    public void post(Runnable runnable) {
        mHandler.post(runnable);
    }

    private MainThreadImpl() {
        mHandler = new Handler(Looper.getMainLooper());
    }

    public static MainThread getInstance() {
        if (sMainThread == null) {
            sMainThread = new MainThreadImpl();
        }
        return sMainThread;
    }
}
