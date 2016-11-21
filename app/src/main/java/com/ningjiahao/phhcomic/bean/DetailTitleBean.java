package com.ningjiahao.phhcomic.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by My on 2016/11/18.
 */

public class DetailTitleBean {

    /**
     * s : 0
     * c : {"id":"538","name":"杂草","webpubtime":"1471449600","subscript":"独家","sicon":"image/20160715/1468577408249932.png","appiconu":"image/20160824/1472035251335678.jpg","appicono":"image/20160816/1471312129837649.jpg","appicons":"image/20160816/1471312132862949.jpg","pcicons":"image/20160816/1471312135305820.png","pciconss":"image/20160816/1471312141238145.jpg","descr":"前途无量的新秀车载赫在即将开启绚丽的职业生涯时，不幸遭受了一场飞来横祸。然而他并没有就此放弃，而是重振旗鼓，带领一群问题少年刮起了一阵冷门旋风\u2026\u2026","ut":"2016-11-10 13:01:00","update":"5","cfyname":"剧情","cyname":"韩国","tname":"英雄联盟","cnname":"翻译","tag":"","author":"Mozza","score":"9.6","updatestate":"1","weight":"13000","partname":"【第12话】老掉牙的方式","th":"14"}
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
         * id : 538
         * name : 杂草
         * webpubtime : 1471449600
         * subscript : 独家
         * sicon : image/20160715/1468577408249932.png
         * appiconu : image/20160824/1472035251335678.jpg
         * appicono : image/20160816/1471312129837649.jpg
         * appicons : image/20160816/1471312132862949.jpg
         * pcicons : image/20160816/1471312135305820.png
         * pciconss : image/20160816/1471312141238145.jpg
         * descr : 前途无量的新秀车载赫在即将开启绚丽的职业生涯时，不幸遭受了一场飞来横祸。然而他并没有就此放弃，而是重振旗鼓，带领一群问题少年刮起了一阵冷门旋风……
         * ut : 2016-11-10 13:01:00
         * update : 5
         * cfyname : 剧情
         * cyname : 韩国
         * tname : 英雄联盟
         * cnname : 翻译
         * tag :
         * author : Mozza
         * score : 9.6
         * updatestate : 1
         * weight : 13000
         * partname : 【第12话】老掉牙的方式
         * th : 14
         */

        @SerializedName("id")
        private String id;
        @SerializedName("name")
        private String name;
        @SerializedName("webpubtime")
        private String webpubtime;
        @SerializedName("subscript")
        private String subscript;
        @SerializedName("sicon")
        private String sicon;
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
        @SerializedName("ut")
        private String ut;
        @SerializedName("update")
        private String update;
        @SerializedName("cfyname")
        private String cfyname;
        @SerializedName("cyname")
        private String cyname;
        @SerializedName("tname")
        private String tname;
        @SerializedName("cnname")
        private String cnname;
        @SerializedName("tag")
        private String tag;
        @SerializedName("author")
        private String author;
        @SerializedName("score")
        private String score;
        @SerializedName("updatestate")
        private String updatestate;
        @SerializedName("weight")
        private String weight;
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

        public String getWebpubtime() {
            return webpubtime;
        }

        public void setWebpubtime(String webpubtime) {
            this.webpubtime = webpubtime;
        }

        public String getSubscript() {
            return subscript;
        }

        public void setSubscript(String subscript) {
            this.subscript = subscript;
        }

        public String getSicon() {
            return sicon;
        }

        public void setSicon(String sicon) {
            this.sicon = sicon;
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

        public String getUt() {
            return ut;
        }

        public void setUt(String ut) {
            this.ut = ut;
        }

        public String getUpdate() {
            return update;
        }

        public void setUpdate(String update) {
            this.update = update;
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

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
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

        public String getUpdatestate() {
            return updatestate;
        }

        public void setUpdatestate(String updatestate) {
            this.updatestate = updatestate;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
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
