package com.example.vaibhav.testmvp.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.vaibhav.testmvp.R;
import com.example.vaibhav.testmvp.bean.SampleBean;
import com.example.vaibhav.testmvp.presenter.NucleusDownloadPresenter;
import com.example.vaibhav.testmvp.utils.Logger;
import com.example.vaibhav.testmvp.utils.Notify;

import java.util.ArrayList;

import nucleus.factory.RequiresPresenter;

@RequiresPresenter(NucleusDownloadPresenter.class)
public class NucleusDownloadActivity extends BaseActivity<NucleusDownloadPresenter> {

    private ProgressBar progressBar;

    @Override
    protected void initViews() {

        Button btnDownload = (Button) findViewById(R.id.btnDownload);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        assert btnDownload != null;
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                download();
            }
        });
    }

    @Override
    protected int getContentView() {

        return R.layout.activity_download;
    }

    @Override
    protected void bindData() {

        //download();
    }

    private void download() {

        NucleusDownloadPresenter presenter = getPresenter();
        presenter.download();
    }

    public void showSampleData(ArrayList<SampleBean> items) {

        for (SampleBean sampleBean : items) {

            Logger.d("Rx:", sampleBean.toString());
        }
    }

    public void onError(Throwable throwable) {

        Notify.toast("On Error", this);
    }

    public void showProgress(String progress) {

        Logger.d("Rx:", progress);

        progressBar.setProgress(Integer.parseInt(progress));
    }
}
