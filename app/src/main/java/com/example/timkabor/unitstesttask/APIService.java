package com.example.timkabor.unitstesttask;


import com.example.timkabor.unitstesttask.Model.Issue;

import java.util.ArrayList;
import java.util.List;
import  io.reactivex.Observable;

import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Timkabor on 5/24/2017.
 */

public interface APIService {
    /**
     * Список всех достопримечательностей
     * @return
     */
    @GET("repos/{user}/{repo}/issues")
    Observable<ArrayList<Issue>> issuesList(@Path("user") String user, @Path("repo") String repo);

}