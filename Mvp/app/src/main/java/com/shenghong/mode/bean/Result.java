package com.shenghong.mode.bean;

import java.util.List;

/**
 * Created by lhy on 2016/3/29.
 */
public class Result {
    private String resultCode;
    private List<ResultData> resultData;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public List<ResultData> getResultData() {
        return resultData;
    }

    public void setResultData(List<ResultData> resultData) {
        this.resultData = resultData;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultCode='" + resultCode + '\'' +
                ", resultData=" + resultData +
                '}';
    }
}
