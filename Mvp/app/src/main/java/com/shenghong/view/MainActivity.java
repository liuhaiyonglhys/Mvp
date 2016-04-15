package com.shenghong.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.shenghong.mode.DataManager;
import com.shenghong.mode.Listener.ResultListener;
import com.shenghong.mode.bean.Result;
import com.shenghong.presenter.MainPresenter;
import com.shenghong.presenter.listener.IMainListener;

public class MainActivity extends AppCompatActivity implements IMainListener,View.OnClickListener{
    Activity activity;
    private MainPresenter mainPresenter = null;
    private Button button;
    private boolean isShow = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = MainPresenter.register(this);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(isShow){
            mainPresenter.showProcess();
            isShow = false;
        }else{
            mainPresenter.hideProcess();
            isShow = true;
        }
    }

    @Override
    public void showProcess() {
        button.setText("显示ShoProcess");
        DataManager.getInstance().test(new ResultListener() {
            @Override
            public void onSucess(Object result) {
                Result resultData = (Result) result;
                Log.e("成功请求完成",resultData.toString());
            }

            @Override
            public void onFailre(Object error) {

            }

            @Override
            public void onCompleted() {

            }
        });
    }

    @Override
    public void hideProcess() {
        button.setText("隐藏HideProcess");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MainPresenter.unregister();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
