package com.ningjiahao.phhcomic.bean;

import android.support.v7.widget.RecyclerView;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by My on 2016/11/16.
 */

public class SearchResultBean {


    /**
     * s : 0
     * c : {"n":"2","s":[{"id":"347","name":"口袋摸鱼合集","pv":"2498","andpubtime":"1465315200","iospubtime":"1465315200","subscript":null,"updatestate":"1","appiconu":"image/20160824/1472035682516694.jpg","appicono":"look/icon/main_icon2016-06-07/5756b175c3e0e.jpg","appicons":"look/icon/main_iconq2016-06-07/5756b18752cb0.jpg","pcicons":"look/icon/main_banner_f2016-06-07/5756b1a301e83.png","pciconss":"look/icon/main_banner_b2016-06-07/5756b1b03401d.jpg","descr":"来自画师辰乐摸鱼的作品，充满了各种欢乐梗的口袋妖怪世界，请随时准备好大师球捕捉。","sicon":null,"cfyname":"搞笑","cyname":"中国","tname":"精灵宝可梦","cnname":"转载","author":"辰乐","score":"9.5","update":"0030000","partname":"【第39话】稻草皮卡","th":"41"},{"id":"128","name":"剑3摸鱼小条漫","pv":"33","andpubtime":"1448899200","iospubtime":"1448899200","subscript":null,"updatestate":"2","appiconu":"image/20160824/1472036435782200.jpg","appicono":"look/icon/main_icon2016-01-15/5698b5e5d47da.jpg","appicons":"look/icon/main_iconq2016-01-15/5698b5f69d64c.jpg","pcicons":"look/icon/main_banner_f2016-01-15/5698b621f0c7b.png","pciconss":"look/icon/main_banner_b2016-01-15/5698c1da5f83c.jpg","descr":"收录了作者同人本以外，摸鱼时绘制的一些剑3小条漫。小黄鸡忠实爱好者，欢迎同好留言勾搭。 ","sicon":null,"cfyname":"日常","cyname":"中国","tname":"剑侠情缘三","cnname":"转载","author":"若若秋","score":"9.3","update":"0000500","partname":"【第9话】愿归","th":"10"}]}
     */

    @SerializedName("s")
    private int s;
    @SerializedName("c")
    private CBean c;

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public CBean getC() {
        return c;
    }

    public void setC(CBean c) {
        this.c = c;
    }

    public static class CBean {
        /**
         * n : 2
         * s : [{"id":"347","name":"口袋摸鱼合集","pv":"2498","andpubtime":"1465315200","iospubtime":"1465315200","subscript":null,"updatestate":"1","appiconu":"image/20160824/1472035682516694.jpg","appicono":"look/icon/main_icon2016-06-07/5756b175c3e0e.jpg","appicons":"look/icon/main_iconq2016-06-07/5756b18752cb0.jpg","pcicons":"look/icon/main_banner_f2016-06-07/5756b1a301e83.png","pciconss":"look/icon/main_banner_b2016-06-07/5756b1b03401d.jpg","descr":"来自画师辰乐摸鱼的作品，充满了各种欢乐梗的口袋妖怪世界，请随时准备好大师球捕捉。","sicon":null,"cfyname":"搞笑","cyname":"中国","tname":"精灵宝可梦","cnname":"转载","author":"辰乐","score":"9.5","update":"0030000","partname":"【第39话】稻草皮卡","th":"41"},{"id":"128","name":"剑3摸鱼小条漫","pv":"33","andpubtime":"1448899200","iospubtime":"1448899200","subscript":null,"updatestate":"2","appiconu":"image/20160824/1472036435782200.jpg","appicono":"look/icon/main_icon2016-01-15/5698b5e5d47da.jpg","appicons":"look/icon/main_iconq2016-01-15/5698b5f69d64c.jpg","pcicons":"look/icon/main_banner_f2016-01-15/5698b621f0c7b.png","pciconss":"look/icon/main_banner_b2016-01-15/5698c1da5f83c.jpg","descr":"收录了作者同人本以外，摸鱼时绘制的一些剑3小条漫。小黄鸡忠实爱好者，欢迎同好留言勾搭。 ","sicon":null,"cfyname":"日常","cyname":"中国","tname":"剑侠情缘三","cnname":"转载","author":"若若秋","score":"9.3","update":"0000500","partname":"【第9话】愿归","th":"10"}]
         */

        @SerializedName("n")
        private String n;
        @SerializedName("s")
        private List<SBean> s;

        public String getN() {
            return n;
        }

        public void setN(String n) {
            this.n = n;
        }

        public List<SBean> getS() {
            return s;
        }

        public void setS(List<SBean> s) {
            this.s = s;
        }

        public static class SBean {
            /**
             * id : 347
             * name : 口袋摸鱼合集
             * pv : 2498
             * andpubtime : 1465315200
             * iospubtime : 1465315200
             * subscript : null
             * updatestate : 1
             * appiconu : image/20160824/1472035682516694.jpg
             * appicono : look/icon/main_icon2016-06-07/5756b175c3e0e.jpg
             * appicons : look/icon/main_iconq2016-06-07/5756b18752cb0.jpg
             * pcicons : look/icon/main_banner_f2016-06-07/5756b1a301e83.png
             * pciconss : look/icon/main_banner_b2016-06-07/5756b1b03401d.jpg
             * descr : 来自画师辰乐摸鱼的作品，充满了各种欢乐梗的口袋妖怪世界，请随时准备好大师球捕捉。
             * sicon : null
             * cfyname : 搞笑
             * cyname : 中国
             * tname : 精灵宝可梦
             * cnname : 转载
             * author : 辰乐
             * score : 9.5
             * update : 0030000
             * partname : 【第39话】稻草皮卡
             * th : 41
             */

            @SerializedName("id")
            private String id;
            @SerializedName("name")
            private String name;
            @SerializedName("pv")
            private String pv;
            @SerializedName("andpubtime")
            private String andpubtime;
            @SerializedName("iospubtime")
            private String iospubtime;
            @SerializedName("subscript")
            private Object subscript;
            @SerializedName("updatestate")
            private String updatestate;
            @SerializedName("appiconu")
            private String appiconu;
            @SerializedName("appicono")
            private String appicono;
            @SerializedName("appicons")
            private String appicons;
            @SerializedName("pcicons")
            private String pcicons;
            @SerializedName("pciconss")
            private String pciconss;
            @SerializedName("descr")
            private String descr;
            @SerializedName("sicon")
            private Object sicon;
            @SerializedName("cfyname")
            private String cfyname;
            @SerializedName("cyname")
            private String cyname;
            @SerializedName("tname")
            private String tname;
            @SerializedName("cnname")
            private String cnname;
            @SerializedName("author")
            private String author;
            @SerializedName("score")
            private String score;
            @SerializedName("update")
            private String update;
            @SerializedName("partname")
            private String partname;
            @SerializedName("th")
            private String th;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPv() {
                return pv;
            }

            public void setPv(String pv) {
                this.pv = pv;
            }

            public String getAndpubtime() {
                return andpubtime;
            }

            public void setAndpubtime(String andpubtime) {
                this.andpubtime = andpubtime;
            }

            public String getIospubtime() {
                return iospubtime;
            }

            public void setIospubtime(String iospubtime) {
                this.iospubtime = iospubtime;
            }

            public Object getSubscript() {
                return subscript;
            }

            public void setSubscript(Object subscript) {
                this.subscript = subscript;
            }

            public String getUpdatestate() {
                return updatestate;
            }

            public void setUpdatestate(String updatestate) {
                this.updatestate = updatestate;
            }

            public String getAppiconu() {
                return appiconu;
            }

            public void setAppiconu(String appiconu) {
                this.appiconu = appiconu;
            }

            public String getAppicono() {
                return appicono;
            }

            public void setAppicono(String appicono) {
                this.appicono = appicono;
            }

            public String getAppicons() {
                return appicons;
            }

            public void setAppicons(String appicons) {
                this.appicons = appicons;
            }

            public String getPcicons() {
                return pcicons;
            }

            public void setPcicons(String pcicons) {
                this.pcicons = pcicons;
            }

            public String getPciconss() {
                return pciconss;
            }

            public void setPciconss(String pciconss) {
                this.pciconss = pciconss;
            }

            public String getDescr() {
                return descr;
            }

            public void setDescr(String descr) {
                this.descr = descr;
            }

            public Object getSicon() {
                return sicon;
            }

            public void setSicon(Object sicon) {
                this.sicon = sicon;
            }

            public String getCfyname() {
                return cfyname;
            }

            public void setCfyname(String cfyname) {
                this.cfyname = cfyname;
            }

            public String getCyname() {
                return cyname;
            }

            public void setCyname(String cyname) {
                this.cyname = cyname;
            }

            public String getTname() {
                return tname;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public String getCnname() {
                return cnname;
            }

            public void setCnname(String cnname) {
                this.cnname = cnname;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getScore() {
                return score;
            }

            public void setScore(String score) {
                this.score = score;
            }

            public String getUpdate() {
                return update;
            }

            public void setUpdate(String update) {
                this.update = update;
            }

            public String getPartname() {
                return partname;
            }

            public void setPartname(String partname) {
                this.partname = partname;
            }

            public String getTh() {
                return th;
            }

            public void setTh(String th) {
                this.th = th;
            }
        }
    }
}
