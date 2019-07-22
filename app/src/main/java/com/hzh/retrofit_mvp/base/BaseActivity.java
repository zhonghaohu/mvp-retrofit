package com.hzh.retrofit_mvp.base;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public abstract class BaseActivity<P extends BasePresenter, V extends IBaseView> extends Activity implements IBaseView{

    private P presenter;
    private V view;

    public P getPresenter() {
        return presenter;
    }

    @Override
    public void showToast(String string) {
        Toast.makeText(this,string,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (view == null) {
            view = initView();
        }
        if (presenter == null) {
            presenter = initPresenter();
        }
        presenter.attachView(view);

    }

    public abstract P initPresenter();
    public abstract V initView();

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.detachView();
    }
}
