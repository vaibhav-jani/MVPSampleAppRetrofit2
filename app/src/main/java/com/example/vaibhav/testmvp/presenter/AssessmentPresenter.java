package com.example.vaibhav.testmvp.presenter;

import android.os.Bundle;

import com.example.vaibhav.testmvp.activity.AssessmentActivity;
import com.example.vaibhav.testmvp.model.AssessmentModel;
import com.example.vaibhav.testmvp.model.QuestionModel;

import java.util.ArrayList;

import rx.Observable;
import rx.functions.Action2;
import rx.functions.Func0;

/**
 * Created by vaibhav on 1/6/16.
 */
public class AssessmentPresenter extends nucleus.presenter.RxPresenter<AssessmentActivity> {

    private final int testDataRequestId = 1;

    @Override
    protected void onCreate(Bundle savedState) {

        super.onCreate(savedState);

        if(savedState != null) {

        }

        cacheRequest();
    }

    private void cacheRequest() {

        restartableLatestCache(testDataRequestId,

                new Func0<Observable<AssessmentModel>>() {

                    @Override
                    public Observable<AssessmentModel> call() {

                        return getAssessmentObservable();
                    }
                },

                new Action2<AssessmentActivity, AssessmentModel>() {

                    @Override
                    public void call(AssessmentActivity view, AssessmentModel model) {

                        view.loadAssessment(model);
                    }
                },

                new Action2<AssessmentActivity, Throwable>() {

                    @Override
                    public void call(AssessmentActivity nucleusTestActivity, Throwable throwable) {

                        nucleusTestActivity.onError(throwable);
                    }
                }
        );
    }

    private Observable<AssessmentModel> getAssessmentObservable() {

        QuestionModel q1 = new QuestionModel();
        QuestionModel q2 = new QuestionModel();
        QuestionModel q3 = new QuestionModel();
        QuestionModel q4 = new QuestionModel();
        QuestionModel q5 = new QuestionModel();

        ArrayList<QuestionModel> qs = new ArrayList<>();
        qs.add(q1);
        qs.add(q2);
        qs.add(q3);
        qs.add(q4);
        qs.add(q5);

        AssessmentModel model = new AssessmentModel();
        model.setQuestionModels(qs);

        return Observable.just(model);
    }

    @Override
    protected void onSave(Bundle state) {

        super.onSave(state);
    }

    @Override
    protected void onTakeView(AssessmentActivity mvpTestActivity) {

        super.onTakeView(mvpTestActivity);
    }

    public void requestTestData() {

        start(testDataRequestId);
    }

}
