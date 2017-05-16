package com.smartstudy.zhike.mylibrary.homebanner;


import java.io.Serializable;

/**
 * Created by chenhong on 16/6/1.
 */
public class DataCodeMsg implements Serializable {
    public String code;
    public String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "DataCodeMsg{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
