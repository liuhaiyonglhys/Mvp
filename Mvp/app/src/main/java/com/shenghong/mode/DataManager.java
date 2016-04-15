package com.shenghong.mode;

import com.shenghong.mode.Listener.ResultListener;
import com.shenghong.mode.base.network.NetWorkManager;
import com.shenghong.mode.base.network.interfaces.RequestService;
import com.shenghong.mode.bean.Result;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lhy on 2016/3/30.
 */
public class DataManager {
    private static DataManager INSTANCE = null;
    private DataManager(){

    }
    public static DataManager getInstance(){
        if(INSTANCE == null){
            synchronized (DataManager.class){
                if(INSTANCE == null){
                    INSTANCE = new DataManager();
                }
            }
        }
        return INSTANCE;
    }

    public void test(final ResultListener resultListener){
        RequestService requestService= NetWorkManager.getInstance().test();
        Observable<Result> resultObservable =  requestService.listRepos();
        resultObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Result>() {
                    @Override
                    public void onCompleted() {
                        resultListener.onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        resultListener.onFailre(e);
                    }

                    @Override
                    public void onNext(Result weather) {
                        resultListener.onSucess(weather);
                    }
                });
    }
}
