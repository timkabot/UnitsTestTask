package com.example.timkabor.unitstesttask;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import com.squareup.picasso.Picasso;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Timkabor on 4/17/2018.
 */


public class App extends Application {

    private static Retrofit mRetrofit;
    private static APIService sService;
    public static final String BASE_URL = "https://api.github.com/";
    private static Resources resources;
    private static ColorDrawable placeholder ;

    @Override
    public void onCreate() {
        super.onCreate();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        resources = this.getResources();
        sService = mRetrofit.create(APIService.class);
    }
    /**
     * Загрузка изображений с помощью Picasso
     * @param url ссылка на изображение
     * @param imageView компонент, в который будет загружено изображение
     */
    public static void loadImageFromURL(String url, ImageView imageView, Context context) {
        Picasso.get().load(url).into(imageView);
    }

    public static APIService getAPI() {
        return sService;
    }
    public static Retrofit getmRetrofit() {
        return mRetrofit;
    }

    public void setmRetrofit(Retrofit mRetrofit) {
        this.mRetrofit = mRetrofit;
    }

    public static APIService getsService() {
        return sService;
    }

    public static void setsService(APIService sService) {
        App.sService = sService;
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static void setResources(Resources resources) {
        App.resources = resources;
    }
}
