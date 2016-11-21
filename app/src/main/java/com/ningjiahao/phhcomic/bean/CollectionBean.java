package com.ningjiahao.phhcomic.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by HP on 2016/11/21.
 */

public class CollectionBean extends BmobObject {
    private String yzhid;
    private String name ;
    private String imageURL;

    public String getYzhid() {
        return yzhid;
    }

    public void setYzhid(String yzhid) {
        this.yzhid = yzhid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
