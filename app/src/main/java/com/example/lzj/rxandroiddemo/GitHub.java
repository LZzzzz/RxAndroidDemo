package com.example.lzj.rxandroiddemo;

import com.example.lzj.rxandroiddemo.bean.Contributor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by LZJ on 2016/9/4.
 */
public interface GitHub {
    @GET("/repos/{owner}/{repo}/contributors")
    Call<List<Contributor>> contributors(@Path("owner") String owner,@Path("repo") String repo);

    //使用 RxJava 的方法,返回一个 Observable
    @GET("/repos/{owner}/{repo}/contributors")
    Observable<List<Contributor>> RxContributors(@Path("owner") String owner, @Path("repo") String repo);


}


