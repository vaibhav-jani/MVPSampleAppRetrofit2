package com.example.vaibhav.testmvp.activity;

import android.os.Bundle;

import nucleus.view.NucleusAppCompatActivity;

/**
 * Created by vaibhav on 1/6/16.
 */
public abstract class BaseActivity<Presenter extends nucleus.presenter.RxPresenter> extends NucleusAppCompatActivity<Presenter> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(getContentView());

        initViews();

        bindData();
    }

    protected abstract void bindData();

    protected abstract void initViews();

    protected abstract int getContentView();

}
