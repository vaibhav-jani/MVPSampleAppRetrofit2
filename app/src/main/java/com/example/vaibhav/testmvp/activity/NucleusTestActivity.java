package com.example.vaibhav.testmvp.activity;

import android.app.ProgressDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.vaibhav.testmvp.R;
import com.example.vaibhav.testmvp.adapter.SampleAdapter;
import com.example.vaibhav.testmvp.bean.SampleBean;
import com.example.vaibhav.testmvp.presenter.NucleusTestPresenter;
import com.example.vaibhav.testmvp.ui.DividerScroll;
import com.example.vaibhav.testmvp.utils.Logger;
import com.example.vaibhav.testmvp.utils.Notify;
import com.example.vaibhav.testmvp.ws.entity.SampleRequest;

import java.util.ArrayList;

import nucleus.factory.RequiresPresenter;

@RequiresPresenter(NucleusTestPresenter.class)
public class NucleusTestActivity extends BaseActivity<NucleusTestPresenter> {

    private SampleAdapter sampleAdapter;

    private ProgressDialog progressDialog;

    @Override
    protected void initViews() {

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        assert recyclerView != null;
        recyclerView.setLayoutManager(layoutManager);

        sampleAdapter = new SampleAdapter(this);
        recyclerView.setAdapter(sampleAdapter);

        DividerScroll.decorate(recyclerView, R.drawable.divider1, false, true);

        Button btnStart = (Button) findViewById(R.id.btnStart);
        assert btnStart != null;
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bindData();
            }
        });
    }

    @Override
    protected int getContentView() {

        return R.layout.activity_nucleaous_test;
    }


    @Override
    protected void bindData() {

        SampleRequest sampleRequest = new SampleRequest();
        sampleRequest.setFirstName("Rajanikant");
        sampleRequest.setLastName("");

        showProgressDialog();
        getPresenter().requestData(sampleRequest);
    }

    public void showProgressDialog(){

        if(progressDialog == null) {

            progressDialog = new ProgressDialog(this);
        }

        progressDialog.setMessage(getString(R.string.loading));

        progressDialog.show();
    }

    public void dismissProgressDialog(){

        try {

            if(progressDialog != null && progressDialog.isShowing()) {

                progressDialog.dismiss();
            }

        } catch (Exception e) {

            Logger.e(e);
        }
    }

    public void showSampleData(ArrayList<SampleBean> items) {

        dismissProgressDialog();
        sampleAdapter.setSampleBeans(items);
    }

    public void onError(Throwable throwable, SampleRequest sampleRequest) {

        dismissProgressDialog();
        Notify.toast("On Error", this);
    }
}
