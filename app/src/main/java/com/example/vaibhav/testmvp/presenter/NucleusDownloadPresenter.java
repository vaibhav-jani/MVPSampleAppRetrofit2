package com.example.vaibhav.testmvp.presenter;

import android.os.Bundle;

import com.example.vaibhav.testmvp.activity.NucleusDownloadActivity;
import com.example.vaibhav.testmvp.ws.AppWs;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action2;
import rx.functions.Func0;
import rx.schedulers.Schedulers;

/**
 * Created by vaibhav on 30/5/16.
 */
public class NucleusDownloadPresenter extends nucleus.presenter.RxPresenter<NucleusDownloadActivity> {

    private final int requestId = 1;

    @Override
    protected void onCreate(Bundle savedState) {

        super.onCreate(savedState);

        if(savedState != null) {

        }

        cacheRequest();
    }

    private void cacheRequest() {

        restartableLatestCache(requestId,

                new Func0<Observable<String>>() {

                    @Override
                    public Observable<String> call() {

                        return getObservable();
                    }
                },

                new Action2<NucleusDownloadActivity, String>() {

                    @Override
                    public void call(NucleusDownloadActivity activity, String sampleResponse) {

                        activity.showProgress(sampleResponse);
                    }
                },

                new Action2<NucleusDownloadActivity, Throwable>() {

                    @Override
                    public void call(NucleusDownloadActivity activity, Throwable throwable) {

                        activity.onError(throwable);
                    }
                }
        );
    }

    private Observable<String> getObservable() {

        return AppWs.download()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    protected void onSave(Bundle state) {

        super.onSave(state);
    }

    @Override
    protected void onTakeView(NucleusDownloadActivity activity) {

        super.onTakeView(activity);
    }

    public void download() {

        start(requestId);
    }

}
