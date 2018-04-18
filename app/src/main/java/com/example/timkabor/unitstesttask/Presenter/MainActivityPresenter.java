package com.example.timkabor.unitstesttask.Presenter;

import android.util.Log;

import  io.reactivex.Observable;

import com.example.timkabor.unitstesttask.App;
import com.example.timkabor.unitstesttask.Model.Issue;
import com.example.timkabor.unitstesttask.View.MainActivity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivityPresenter {
    private MainActivity view;
    ArrayList<Issue> issues = new ArrayList<>();

    public MainActivityPresenter(MainActivity view) {
        this.view = view;
    }
    public void loadData()
    {
        Observable< ArrayList<Issue> > issuesObservable = App.getAPI().issuesList("ReactiveX","RxJava");
        issuesObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(issueData ->
                        {
                            issues.addAll(issueData);
                            view.updateRecycler(issues); }
                        ,  showNetworkError -> view.showNoConnectionMessage()
                );
    }

    public MainActivity getView() {
        return view;
    }

    public void setView(MainActivity view) {
        this.view = view;
    }

    public ArrayList<Issue> getIssues() {
        return issues;
    }

    public void setIssues(ArrayList<Issue> issues) {
        this.issues = issues;
    }
}
