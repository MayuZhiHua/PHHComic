package com.ningjiahao.phhcomic.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 甯宁寧 on 2016-11-17.
 */

public class ManHuaBean {

    /**
     * s : 0
     * c : {"id":"10586","comicid":"322","name":"【第24话】警察来学校了","th":"25","icon":"image/20161102/1478068441612049.jpg","status":"0","content":["comic/spec32210586/default/0.jpg?v=1478068709","comic/spec32210586/default/1.jpg?v=1478068709","comic/spec32210586/default/2.jpg?v=1478068709","comic/spec32210586/default/3.jpg?v=1478068709","comic/spec32210586/default/4.jpg?v=1478068709","comic/spec32210586/default/5.jpg?v=1478068709","comic/spec32210586/default/6.jpg?v=1478068709","comic/spec32210586/default/7.jpg?v=1478068709","comic/spec32210586/default/8.jpg?v=1478068709","comic/spec32210586/default/9.jpg?v=1478068709","comic/spec32210586/default/10.jpg?v=1478068709","comic/spec32210586/default/11.jpg?v=1478068709","comic/spec32210586/default/12.jpg?v=1478068709","comic/spec32210586/default/13.jpg?v=1478068709","comic/spec32210586/default/14.jpg?v=1478068709","comic/spec32210586/default/15.jpg?v=1478068709","comic/spec32210586/default/16.jpg?v=1478068709","comic/spec32210586/default/17.jpg?v=1478068709","comic/spec32210586/default/18.jpg?v=1478068709","comic/spec32210586/default/19.jpg?v=1478068709","comic/spec32210586/default/20.jpg?v=1478068709","comic/spec32210586/default/21.jpg?v=1478068709","comic/spec32210586/default/22.jpg?v=1478068709","comic/spec32210586/default/23.jpg?v=1478068709","comic/spec32210586/default/24.jpg?v=1478068709","comic/spec32210586/default/25.jpg?v=1478068709","comic/spec32210586/default/26.jpg?v=1478068709","comic/spec32210586/default/27.jpg?v=1478068709","comic/spec32210586/default/28.jpg?v=1478068709","comic/spec32210586/default/29.jpg?v=1478068709","comic/spec32210586/default/30.jpg?v=1478068709","comic/spec32210586/default/31.jpg?v=1478068709","comic/spec32210586/default/32.jpg?v=1478068709","comic/spec32210586/default/33.jpg?v=1478068709","comic/spec32210586/default/34.jpg?v=1478068709","comic/spec32210586/default/35.jpg?v=1478068709","comic/spec32210586/default/36.jpg?v=1478068709","comic/spec32210586/default/37.jpg?v=1478068709","comic/spec32210586/default/38.jpg?v=1478068709"],"size":[{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1424}]}
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
         * id : 10586
         * comicid : 322
         * name : 【第24话】警察来学校了
         * th : 25
         * icon : image/20161102/1478068441612049.jpg
         * status : 0
         * content : ["comic/spec32210586/default/0.jpg?v=1478068709","comic/spec32210586/default/1.jpg?v=1478068709","comic/spec32210586/default/2.jpg?v=1478068709","comic/spec32210586/default/3.jpg?v=1478068709","comic/spec32210586/default/4.jpg?v=1478068709","comic/spec32210586/default/5.jpg?v=1478068709","comic/spec32210586/default/6.jpg?v=1478068709","comic/spec32210586/default/7.jpg?v=1478068709","comic/spec32210586/default/8.jpg?v=1478068709","comic/spec32210586/default/9.jpg?v=1478068709","comic/spec32210586/default/10.jpg?v=1478068709","comic/spec32210586/default/11.jpg?v=1478068709","comic/spec32210586/default/12.jpg?v=1478068709","comic/spec32210586/default/13.jpg?v=1478068709","comic/spec32210586/default/14.jpg?v=1478068709","comic/spec32210586/default/15.jpg?v=1478068709","comic/spec32210586/default/16.jpg?v=1478068709","comic/spec32210586/default/17.jpg?v=1478068709","comic/spec32210586/default/18.jpg?v=1478068709","comic/spec32210586/default/19.jpg?v=1478068709","comic/spec32210586/default/20.jpg?v=1478068709","comic/spec32210586/default/21.jpg?v=1478068709","comic/spec32210586/default/22.jpg?v=1478068709","comic/spec32210586/default/23.jpg?v=1478068709","comic/spec32210586/default/24.jpg?v=1478068709","comic/spec32210586/default/25.jpg?v=1478068709","comic/spec32210586/default/26.jpg?v=1478068709","comic/spec32210586/default/27.jpg?v=1478068709","comic/spec32210586/default/28.jpg?v=1478068709","comic/spec32210586/default/29.jpg?v=1478068709","comic/spec32210586/default/30.jpg?v=1478068709","comic/spec32210586/default/31.jpg?v=1478068709","comic/spec32210586/default/32.jpg?v=1478068709","comic/spec32210586/default/33.jpg?v=1478068709","comic/spec32210586/default/34.jpg?v=1478068709","comic/spec32210586/default/35.jpg?v=1478068709","comic/spec32210586/default/36.jpg?v=1478068709","comic/spec32210586/default/37.jpg?v=1478068709","comic/spec32210586/default/38.jpg?v=1478068709"]
         * size : [{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1332},{"w":640,"h":1333},{"w":640,"h":1424}]
         */

        @SerializedName("id")
        private String id;
        @SerializedName("comicid")
        private String comicid;
        @SerializedName("name")
        private String name;
        @SerializedName("th")
        private String th;
        @SerializedName("icon")
        private String icon;
        @SerializedName("status")
        private String status;
        @SerializedName("content")
        private List<String> content;
        @SerializedName("size")
        private List<SizeBean> size;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getComicid() {
            return comicid;
        }

        public void setComicid(String comicid) {
            this.comicid = comicid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTh() {
            return th;
        }

        public void setTh(String th) {
            this.th = th;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public List<String> getContent() {
            return content;
        }

        public void setContent(List<String> content) {
            this.content = content;
        }

        public List<SizeBean> getSize() {
            return size;
        }

        public void setSize(List<SizeBean> size) {
            this.size = size;
        }

        public static class SizeBean {
            /**
             * w : 640
             * h : 1332
             */

            @SerializedName("w")
            private int w;
            @SerializedName("h")
            private int h;

            public int getW() {
                return w;
            }

            public void setW(int w) {
                this.w = w;
            }

            public int getH() {
                return h;
            }

            public void setH(int h) {
                this.h = h;
            }
        }
    }
}
