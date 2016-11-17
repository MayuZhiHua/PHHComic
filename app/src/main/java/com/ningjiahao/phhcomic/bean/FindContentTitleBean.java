package com.ningjiahao.phhcomic.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by My on 2016/11/16.
 */

public class FindContentTitleBean {


    /**
     * s : 0
     * c : {"n":"11","s":[{"id":"1","comicnum":"76","name":"恋爱"},{"id":"2","comicnum":"104","name":"日常"},{"id":"3","comicnum":"179","name":"搞笑"},{"id":"4","comicnum":"43","name":"动作"},{"id":"5","comicnum":"66","name":"剧情"},{"id":"6","comicnum":"20","name":"悬疑"},{"id":"7","comicnum":"14","name":"萌系"},{"id":"8","comicnum":"22","name":"插画"},{"id":"9","comicnum":"43","name":"腐向"},{"id":"17","comicnum":"61","name":"奇幻"},{"id":"18","comicnum":"4","name":"武侠"}]}
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
         * n : 11
         * s : [{"id":"1","comicnum":"76","name":"恋爱"},{"id":"2","comicnum":"104","name":"日常"},{"id":"3","comicnum":"179","name":"搞笑"},{"id":"4","comicnum":"43","name":"动作"},{"id":"5","comicnum":"66","name":"剧情"},{"id":"6","comicnum":"20","name":"悬疑"},{"id":"7","comicnum":"14","name":"萌系"},{"id":"8","comicnum":"22","name":"插画"},{"id":"9","comicnum":"43","name":"腐向"},{"id":"17","comicnum":"61","name":"奇幻"},{"id":"18","comicnum":"4","name":"武侠"}]
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
             * id : 1
             * comicnum : 76
             * name : 恋爱
             */

            @SerializedName("id")
            private String id;
            @SerializedName("comicnum")
            private String comicnum;
            @SerializedName("name")
            private String name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getComicnum() {
                return comicnum;
            }

            public void setComicnum(String comicnum) {
                this.comicnum = comicnum;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
