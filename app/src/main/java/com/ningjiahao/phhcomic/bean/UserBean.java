package com.ningjiahao.phhcomic.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by HP on 2016/11/18.
 */

public class UserBean {

    /**
     * s : 0
     * c : {"face":"http://q.qlogo.cn/qqapp/1104807351/88EEE201AFE9289F8CFB4C71A0FC757D/100","oid":"146849325256980","motto":"","nick":"武斗战神孙悟空","gender":"男","changed":"0","ct":"1474907935","background":"","groupid":"","zan_count":0,"follow_me":false,"follow_him":false,"zaned":false}
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
         * face : http://q.qlogo.cn/qqapp/1104807351/88EEE201AFE9289F8CFB4C71A0FC757D/100
         * oid : 146849325256980
         * motto :
         * nick : 武斗战神孙悟空
         * gender : 男
         * changed : 0
         * ct : 1474907935
         * background :
         * groupid :
         * zan_count : 0
         * follow_me : false
         * follow_him : false
         * zaned : false
         */

        @SerializedName("face")
        private String face;
        @SerializedName("oid")
        private String oid;
        @SerializedName("motto")
        private String motto;
        @SerializedName("nick")
        private String nick;
        @SerializedName("gender")
        private String gender;
        @SerializedName("changed")
        private String changed;
        @SerializedName("ct")
        private String ct;
        @SerializedName("background")
        private String background;
        @SerializedName("groupid")
        private String groupid;
        @SerializedName("zan_count")
        private int zanCount;
        @SerializedName("follow_me")
        private boolean followMe;
        @SerializedName("follow_him")
        private boolean followHim;
        @SerializedName("zaned")
        private boolean zaned;

        public String getFace() {
            return face;
        }

        public void setFace(String face) {
            this.face = face;
        }

        public String getOid() {
            return oid;
        }

        public void setOid(String oid) {
            this.oid = oid;
        }

        public String getMotto() {
            return motto;
        }

        public void setMotto(String motto) {
            this.motto = motto;
        }

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getChanged() {
            return changed;
        }

        public void setChanged(String changed) {
            this.changed = changed;
        }

        public String getCt() {
            return ct;
        }

        public void setCt(String ct) {
            this.ct = ct;
        }

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }

        public String getGroupid() {
            return groupid;
        }

        public void setGroupid(String groupid) {
            this.groupid = groupid;
        }

        public int getZanCount() {
            return zanCount;
        }

        public void setZanCount(int zanCount) {
            this.zanCount = zanCount;
        }

        public boolean isFollowMe() {
            return followMe;
        }

        public void setFollowMe(boolean followMe) {
            this.followMe = followMe;
        }

        public boolean isFollowHim() {
            return followHim;
        }

        public void setFollowHim(boolean followHim) {
            this.followHim = followHim;
        }

        public boolean isZaned() {
            return zaned;
        }

        public void setZaned(boolean zaned) {
            this.zaned = zaned;
        }
    }
}
