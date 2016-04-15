package com.shenghong.presenter;

import com.shenghong.presenter.listener.IMainListener;

/**
 * Created by lhy on 2016/3/29.
 */
public class MainPresenter {
    private static MainPresenter INSTANCE = null;
    private static IMainListener iMainInterface = null;
    private MainPresenter(IMainListener iMainInterface){
        MainPresenter.iMainInterface = iMainInterface;
    }

    public static MainPresenter register(IMainListener iMainInterface){
        if(INSTANCE == null){
            synchronized (MainPresenter.class){
                if(INSTANCE == null){
                    INSTANCE = new MainPresenter(iMainInterface);
                }
            }
        }
        return INSTANCE;
    }

    public static void unregister(){
        INSTANCE = null;
        iMainInterface = null;
    }

    /**
     * 显示进度条
     */
    public void showProcess(){
        iMainInterface.showProcess();
    }

    /**
     * 隐藏进度条
     */
    public void hideProcess(){
        iMainInterface.hideProcess();
    }
}
