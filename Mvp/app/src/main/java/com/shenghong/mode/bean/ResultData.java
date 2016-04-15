package com.shenghong.mode.bean;

/**
 * Created by lhy on 2016/3/29.
 */
public class ResultData {
    private String apkUrl;
    private String updateDesc;
    private String updateTime;
    private String version;

    public String getApkUrl() {
        return apkUrl;
    }

    public void setApkUrl(String apkUrl) {
        this.apkUrl = apkUrl;
    }

    public String getUpdateDesc() {
        return updateDesc;
    }

    public void setUpdateDesc(String updateDesc) {
        this.updateDesc = updateDesc;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "ResultData{" +
                "apkUrl='" + apkUrl + '\'' +
                ", updateDesc='" + updateDesc + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
