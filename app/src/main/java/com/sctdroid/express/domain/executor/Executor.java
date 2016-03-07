package com.sctdroid.express.domain.executor;

import com.sctdroid.express.domain.interactor.base.AbstractInteractor;

/**
 * Created by lixindong on 3/4/16.
 */
public interface Executor {
    void execute(final AbstractInteractor interactor);
}
