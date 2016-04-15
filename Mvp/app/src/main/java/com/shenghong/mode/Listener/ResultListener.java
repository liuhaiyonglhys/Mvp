package com.shenghong.mode.Listener;

/**
 * Created by liuha on 2016/3/30.
 */
public interface ResultListener<T> {
    void onSucess(T result);
    void onFailre(T error);
    void onCompleted();
}
