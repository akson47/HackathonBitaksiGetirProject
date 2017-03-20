package com.yusufakson.hackathonbitaksigetirproject.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lenovo on 20.3.2017.
 *
 * @author yusuf akson
 */

public class Elements implements Serializable{
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("inviteCode")
    @Expose
    private String inviteCode;
    @SerializedName("elements")
    @Expose
    private List<ItemElements> elements = null;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public List<ItemElements> getElements() {
        return elements;
    }

    public void setElements(List<ItemElements> elements) {
        this.elements = elements;
    }
}
