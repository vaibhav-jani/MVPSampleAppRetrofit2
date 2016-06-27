package com.example.vaibhav.testmvp.presenter;

import android.os.Bundle;

import com.example.vaibhav.testmvp.activity.NucleusTestActivity;
import com.example.vaibhav.testmvp.ws.AppWs;
import com.example.vaibhav.testmvp.ws.entity.SampleRequest;
import com.example.vaibhav.testmvp.ws.entity.SampleResponse;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action2;
import rx.functions.Func0;
import rx.schedulers.Schedulers;

/**
 * Created by vaibhav on 30/5/16.
 */
public class NucleusTestPresenter extends nucleus.presenter.RxPresenter<NucleusTestActivity> {

    private static final String KEY_SAMPLE_REQUEST = "key_sample_request";

    private SampleRequest sampleRequest;

    private final int sampleRequestId = 1;

    @Override
    protected void onCreate(Bundle savedState) {

        super.onCreate(savedState);

        if(savedState != null) {

            this.sampleRequest = (SampleRequest) savedState.getSerializable(KEY_SAMPLE_REQUEST);

        }

        cacheRequest();
    }

    private void cacheRequest() {

        restartableLatestCache(sampleRequestId,

                new Func0<Observable<SampleResponse>>() {

                    @Override
                    public Observable<SampleResponse> call() {

                        return getObservable();
                    }
                },

                new Action2<NucleusTestActivity, SampleResponse>() {

                    @Override
                    public void call(NucleusTestActivity nucleusTestActivity, SampleResponse sampleResponse) {

                        nucleusTestActivity.showSampleData(sampleResponse.getItems());
                    }
                },

                new Action2<NucleusTestActivity, Throwable>() {

                    @Override
                    public void call(NucleusTestActivity nucleusTestActivity, Throwable throwable) {

                        nucleusTestActivity.onError(throwable, sampleRequest);
                    }
                }
        );
    }

    private Observable<SampleResponse> getObservable() {

        return AppWs.getSampleEndPointResponse(sampleRequest)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    protected void onSave(Bundle state) {

        super.onSave(state);

        state.putSerializable(KEY_SAMPLE_REQUEST, sampleRequest);
    }

    @Override
    protected void onTakeView(NucleusTestActivity nucleusTestActivity) {

        super.onTakeView(nucleusTestActivity);
    }

    public void requestData(SampleRequest request) {

        this.sampleRequest = request;

        start(sampleRequestId);
    }

}
