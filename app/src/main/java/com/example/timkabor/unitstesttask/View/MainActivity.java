package com.example.timkabor.unitstesttask.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.widget.Toast;

import com.example.timkabor.unitstesttask.Adapter.MainAdapter;
import com.example.timkabor.unitstesttask.Model.Issue;
import com.example.timkabor.unitstesttask.Presenter.MainActivityPresenter;
import com.example.timkabor.unitstesttask.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recycler_view) RecyclerView recyclerView;

    private MainActivityPresenter presenter;
    private MainAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainActivityPresenter(this);
        presenter.loadData();

    }
    public void showNoConnectionMessage() {
        Toast.makeText(getApplicationContext(), "No Connection", Toast.LENGTH_LONG).show();
    }
    public void updateRecycler(ArrayList<Issue> issuesList) {

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MainAdapter(issuesList,this);
        recyclerView.setAdapter(mAdapter);
    }
    public void changeScreen(Bundle arguments) {
        Intent myIntent = new Intent(this, DescriptionActivity.class);
        myIntent.putExtras(arguments);
        startActivity(myIntent);
    }

}
