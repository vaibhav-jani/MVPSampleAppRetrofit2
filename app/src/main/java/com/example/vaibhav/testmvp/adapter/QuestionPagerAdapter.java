package com.example.vaibhav.testmvp.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vaibhav.testmvp.R;
import com.example.vaibhav.testmvp.activity.AssessmentActivity;
import com.example.vaibhav.testmvp.model.QuestionModel;

import java.util.ArrayList;

public class QuestionPagerAdapter extends PagerAdapter {

    private ArrayList<QuestionModel> questionModels = new ArrayList<>();

    private AssessmentActivity activity;

    private final LayoutInflater layoutInflater;

    public QuestionPagerAdapter(AssessmentActivity context) {

        activity = context;

        layoutInflater = LayoutInflater.from(activity);
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {

        QuestionModel questionModel = questionModels.get(position);

        ViewGroup layout = (ViewGroup) layoutInflater.inflate(R.layout.layout_question, collection, false);

        collection.addView(layout);

        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {

        collection.removeView((View) view);
    }

    @Override
    public int getCount() {

        return questionModels.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return String.valueOf(position+1);
    }

    public ArrayList<QuestionModel> getQuestionModels() {

        return questionModels;
    }

    public void setQuestionModels(ArrayList<QuestionModel> questionModels) {

        if(questionModels == null) {

            questionModels = new ArrayList<>();
        }

        this.questionModels = questionModels;

        notifyDataSetChanged();
    }
}