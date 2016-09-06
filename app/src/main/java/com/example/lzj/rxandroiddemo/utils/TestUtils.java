package com.example.lzj.rxandroiddemo.utils;


import android.util.Log;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

import com.example.lzj.rxandroiddemo.GitHub;
import com.example.lzj.rxandroiddemo.bean.Contributor;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by LZJ on 2016/9/3.
 */
public class TestUtils {
    private OkHttpClient client;
    private Observable<List<Contributor>> listObservable;

    public TestUtils() {
        client = new OkHttpClient();
    }

    public void Test(String path) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())//添加 json 转换器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//添加 RxJava 适配器
                .build();
        GitHub gitHub = retrofit.create(GitHub.class);
        gitHub.RxContributors("square", "retrofit")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Contributor>>() {
                    @Override
                    public void onCompleted() {
                        Log.i("TAG", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<Contributor> contributors) {
                        for (Contributor c : contributors) {
                            Log.i("TAG", "RxJava-->" + c.getLogin() + "  " + c.getId() + "  " + c.getContributions());
                        }
                    }
                });
    }
}
