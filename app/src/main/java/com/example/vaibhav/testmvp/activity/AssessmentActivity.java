package com.example.vaibhav.testmvp.activity;

import android.support.v4.view.ViewPager;

import com.example.vaibhav.testmvp.R;
import com.example.vaibhav.testmvp.adapter.QuestionPagerAdapter;
import com.example.vaibhav.testmvp.model.AssessmentModel;
import com.example.vaibhav.testmvp.model.QuestionModel;
import com.example.vaibhav.testmvp.presenter.AssessmentPresenter;

import java.util.ArrayList;

import nucleus.factory.RequiresPresenter;

@RequiresPresenter(AssessmentPresenter.class)
public class AssessmentActivity extends BaseActivity<AssessmentPresenter> {

    private QuestionPagerAdapter pagerAdapter;

    @Override
    protected void bindData() {

        AssessmentPresenter presenter = getPresenter();
        presenter.requestTestData();
    }

    @Override
    protected void initViews() {

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        assert viewPager != null;
        pagerAdapter = new QuestionPagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);
    }

    @Override
    protected int getContentView() {

        return R.layout.activity_test;
    }

    public void loadAssessment(AssessmentModel assessmentModel) {

        if(assessmentModel == null) {

            return;
        }

        ArrayList<QuestionModel> models = assessmentModel.getQuestionModels();
        pagerAdapter.setQuestionModels(models);
    }

    public void onError(Throwable throwable) {

    }
}
