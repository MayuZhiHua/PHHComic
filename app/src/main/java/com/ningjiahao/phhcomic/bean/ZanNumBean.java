package com.ningjiahao.phhcomic.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 甯宁寧 on 2016-11-16.
 */

public class ZanNumBean {

    /**
     * s : 0
     * c : {"zaned":false,"zan_num":574,"discuss_num":164,"collected":false}
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
         * zaned : false
         * zan_num : 574
         * discuss_num : 164
         * collected : false
         */

        @SerializedName("zaned")
        private boolean zaned;
        @SerializedName("zan_num")
        private int zanNum;
        @SerializedName("discuss_num")
        private int discussNum;
        @SerializedName("collected")
        private boolean collected;

        public boolean isZaned() {
            return zaned;
        }

        public void setZaned(boolean zaned) {
            this.zaned = zaned;
        }

        public int getZanNum() {
            return zanNum;
        }

        public void setZanNum(int zanNum) {
            this.zanNum = zanNum;
        }

        public int getDiscussNum() {
            return discussNum;
        }

        public void setDiscussNum(int discussNum) {
            this.discussNum = discussNum;
        }

        public boolean isCollected() {
            return collected;
        }

        public void setCollected(boolean collected) {
            this.collected = collected;
        }
    }
}
