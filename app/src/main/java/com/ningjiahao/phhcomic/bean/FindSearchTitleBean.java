package com.ningjiahao.phhcomic.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by My on 2016/11/16.
 */

public class FindSearchTitleBean {

    /**
     * s : 0
     * c : ["LOL","布里茨安妮","魔王！魔王！","帮帮我 慎先生","癌细胞LOL漫画","潘黛蕾","守望先锋十万个冷屁股","LOL四格漫画"]
     */

    @SerializedName("s")
    private int s;
    @SerializedName("c")
    private List<String> c;

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public List<String> getC() {
        return c;
    }

    public void setC(List<String> c) {
        this.c = c;
    }
}
