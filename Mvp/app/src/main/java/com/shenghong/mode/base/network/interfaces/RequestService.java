package com.shenghong.mode.base.network.interfaces;


import com.shenghong.mode.bean.Result;

import retrofit.http.GET;
import rx.Observable;

/**
 * Created by lhy on 2016/3/29.
 */
public interface RequestService {
    @GET("fairyCartoonServer/version/info")
    Observable<Result> listRepos();
}
