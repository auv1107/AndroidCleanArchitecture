package com.sctdroid.express.presentation.presenters;

import com.sctdroid.express.presentation.presenters.base.BasePresenter;
import com.sctdroid.express.presentation.ui.BaseView;

/**
 * Created by lixindong on 3/4/16.
 */
public interface QueryPresenter extends BasePresenter {
    interface View extends BaseView {
        void displayData(String data);
    }
    void query(String params);
}
