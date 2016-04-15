package com.shenghong.mode.base.network;

import com.shenghong.helper.utils.Configuration;
import com.shenghong.mode.base.network.interfaces.RequestService;
import retrofit.GsonConverterFactory;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by lhy on 2016/3/29.
 */
public class NetWorkManager {
    private static NetWorkManager INSTANCE = null;
    private NetWorkManager(){

    }
    public static NetWorkManager getInstance(){
        if(INSTANCE == null){
            synchronized (NetWorkManager.class){
                if(INSTANCE == null){
                    INSTANCE = new NetWorkManager();
                }
            }
        }
        return INSTANCE;
    }

    public RequestService test(){
        retrofit.Retrofit retrofit = new retrofit.Retrofit.Builder().baseUrl(Configuration.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        RequestService service = retrofit.create(RequestService.class);
        return service;
    }
}
