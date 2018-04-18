package com.example.timkabor.unitstesttask.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spanned;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.timkabor.unitstesttask.Presenter.DescriptionActivityPresenter;
import com.example.timkabor.unitstesttask.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DescriptionActivity extends AppCompatActivity {
    @BindView(R.id.avatar) ImageView avatar;
    @BindView(R.id.login) TextView login;
    @BindView(R.id.labels) TextView labels;
    @BindView(R.id.body2) TextView body2;
    private Bundle arguments;
    DescriptionActivityPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description_activity);
        ButterKnife.bind(this);
        Bundle extras = getIntent().getExtras();
        System.out.println(extras + " hello");
        System.out.println(extras.getString("userAvatar"));
        presenter = new DescriptionActivityPresenter(this);
        presenter.updateData();
    }

    public ImageView getAvatar() {
        return avatar;
    }

    public void setAvatar(ImageView avatar) {
        this.avatar = avatar;
    }

    public TextView getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login.setText(login);
    }

    public TextView getLabels() {
        return labels;
    }

    public void setLabels(Spanned labels) {
        this.labels.setText(labels);
    }

    public TextView getBody2() {
        return body2;
    }

    public void setBody2(String body2) {
        this.body2.setText(body2);
    }

}
