package com.example.timkabor.unitstesttask.Presenter;


import android.content.Intent;
import android.os.Bundle;
import android.text.Html;

import com.example.timkabor.unitstesttask.App;
import com.example.timkabor.unitstesttask.Model.Label;
import com.example.timkabor.unitstesttask.View.DescriptionActivity;

import java.util.ArrayList;


public class DescriptionActivityPresenter {
    private DescriptionActivity view;
    public DescriptionActivityPresenter (DescriptionActivity view) {
        this.view = view;
    }
    public void updateData()
    {
        Bundle intent = view.getIntent().getExtras();
        String avatarUrl = intent.getString("userAvatar"),
                            login = intent.getString("userLogin"),
                            body = intent.getString("issueBody");
        ArrayList<String> namesOfLabels =  intent.getStringArrayList("labelsNames");
        App.loadImageFromURL(avatarUrl,view.getAvatar(),view);
        view.setLogin("Login : " + login);
        view.setBody2(body);
        String label = "";
        if(namesOfLabels.size()!=0){
            label += "<font> Labels : </font> <br>";
        }
        for(int i = 0; i < namesOfLabels.size() / 2;i++) {
            label += " <font color=#" + namesOfLabels.get(i+namesOfLabels.size() / 2) + " > " + namesOfLabels.get(i) + " </font> <br>";
        }
        view.setLabels(Html.fromHtml(label));
    }

}
