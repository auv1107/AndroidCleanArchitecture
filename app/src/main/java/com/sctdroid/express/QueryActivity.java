package com.sctdroid.express;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.sctdroid.express.domain.executor.Executor;
import com.sctdroid.express.domain.executor.impl.ThreadExecutor;
import com.sctdroid.express.presentation.presenters.QueryPresenter;
import com.sctdroid.express.presentation.presenters.impl.QueryPresenterImpl;
import com.sctdroid.express.presentation.ui.BaseView;
import com.sctdroid.express.storage.QueryDataRepository;
import com.sctdroid.express.thread.MainThreadImpl;

public class QueryActivity extends AppCompatActivity implements BaseView, QueryPresenter.View {

    EditText mInputBox;
    TextView mSubmitBtn;
    TextView mResultBox;
    QueryPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        initViews();
        mPresenter = new QueryPresenterImpl(ThreadExecutor.getInstance(), MainThreadImpl.getInstance(), this, new QueryDataRepository());
    }

    private void initViews() {
        mInputBox = (EditText) findViewById(R.id.input_box);
        mSubmitBtn = (TextView) findViewById(R.id.query_btn);
        mResultBox = (TextView) findViewById(R.id.result_box);

        mSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPresenter != null)
                    mPresenter.query();
            }
        });
    }

    @Override
    public void showError(String data) {
        mResultBox.setText("Query error!");
    }

    @Override
    public String obtainQueryData() {
        return mInputBox.getText().toString();
    }

    @Override
    public void displayData(String data) {
        mResultBox.setText(data);
    }
}
