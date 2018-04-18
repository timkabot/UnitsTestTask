package com.example.timkabor.unitstesttask.Adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.timkabor.unitstesttask.Model.Issue;
import com.example.timkabor.unitstesttask.R;
import com.example.timkabor.unitstesttask.View.MainActivity;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder>  {

    private List<Issue> issuesList;
    private MainActivity mainActivity;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.title) TextView title;
        @BindView(R.id.body) TextView body;
        @BindView(R.id.created_at) TextView created_at;
        @BindView(R.id.state) TextView state;
        public MyViewHolder(CardView view) {
            super(view);
            ButterKnife.bind(this,view);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext().getApplicationContext(), "No Connection", Toast.LENGTH_LONG).show();
            Issue issue = issuesList.get(getAdapterPosition());

            Bundle arguments = new Bundle();
            arguments.putString("issueBody", issue.getBody());
            arguments.putString("userLogin", issue.getUser().getLogin());
            arguments.putString("userAvatar", issue.getUser().getAvatar_url());

            ArrayList<String> namesOfLabels = new ArrayList<>();
            for(int i=0;i<issue.getLabels().size();i++) {
                namesOfLabels.add(issue.getLabels().get(i).getName());
            }

            ArrayList<String> colorsOfLabels = new ArrayList<>();
            for(int i=0;i<issue.getLabels().size();i++)
                namesOfLabels.add(issue.getLabels().get(i).getColor());

            arguments.putStringArrayList("labelsNames",namesOfLabels);
            mainActivity.changeScreen(arguments);


        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView itemView = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.issue_list_row, parent, false);
        return new MyViewHolder(itemView);
    }
    public MainAdapter(List<Issue> list, MainActivity  activity) {
        mainActivity = activity;
        this.issuesList = list;

    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)  {
        Issue issue = issuesList.get(position);
        holder.title.setText(issue.getTitle());
        holder.body.setText(issue.getBody());
        holder.state.setText("State : " + issue.getState());
        holder.created_at.setText("Created at : " + issue.getCreated_at().replaceAll("T","").replaceAll("Z",""));
    }

    @Override
    public int getItemCount() {
        return issuesList.size();
    }


}
