package com.smartstudy.zhike.banner.bean.homebanner;


import java.io.Serializable;
import java.util.List;

/**
 * 主页轮播图
 */
public class HomeBannerBean extends DataCodeMsg implements Serializable {

    private String apiVersion;

    private List<HomeBannerDataBean> data;

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public List<HomeBannerDataBean> getData() {
        return data;
    }

    public void setData(List<HomeBannerDataBean> data) {
        this.data = data;
    }
}
