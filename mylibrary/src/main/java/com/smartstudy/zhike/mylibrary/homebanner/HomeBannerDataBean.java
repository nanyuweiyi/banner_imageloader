package com.smartstudy.zhike.mylibrary.homebanner;

import java.io.Serializable;

/**
 * Created by tnn on 2016/6/23.
 * email:nanyuweiyi@126.com
 */
public class HomeBannerDataBean implements Serializable {
    private String picture;
    private String link;

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
