package com.ningjiahao.phhcomic.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 甯宁寧 on 2016-11-17.
 */

public class ManHuaChapterBean {

    /**
     * s : 0
     * c : [{"id":"10931","name":"【第25话】两个噩耗","th":"26","icon":"image/20161110/1478758843723523.jpg","andpubtime":"1478880000"},{"id":"10586","name":"【第24话】警察来学校了","th":"25","icon":"image/20161102/1478068441612049.jpg","andpubtime":"1478275200"},{"id":"10429","name":"【第23话】谁还想回到从前呢","th":"24","icon":"image/20161028/1477636882900717.jpg","andpubtime":"1477670400"},{"id":"10168","name":"【第22话】如果有猪肉味冰激凌","th":"23","icon":"image/20161021/1477017381378964.jpg","andpubtime":"1477065600"},{"id":"9986","name":"【第21话】小心隔墙有耳","th":"22","icon":"image/20161014/1476424215691254.jpg","andpubtime":"1476460800"},{"id":"9495","name":"【第20话】振烈的挑战","th":"21","icon":"image/20160928/1475051925759288.jpg","andpubtime":"1475856000"},{"id":"9494","name":"【第19话】以毒攻毒","th":"20","icon":"image/20160928/1475051471106975.jpg","andpubtime":"1475251200"},{"id":"9215","name":"【第18话】离开药丸依旧是菜鸟","th":"19","icon":"image/20160922/1474532165985482.jpg","andpubtime":"1474646400"},{"id":"8934","name":"【第17话】不要随便学别人做网络直播","th":"18","icon":"image/20160914/1473836912565338.jpg","andpubtime":"1474041600"},{"id":"8485","name":"【第16话】一夜爆红","th":"17","icon":"image/20160906/1473152518508025.jpg","andpubtime":"1473436800"},{"id":"8377","name":"【第15话】上直播了","th":"16","icon":"image/20160902/1472795881841982.jpg","andpubtime":"1472832000"},{"id":"7952","name":"【第14话】鼻毛老师的人生哲理","th":"15","icon":"image/20160825/1472093939678989.jpg","andpubtime":"1472227200"},{"id":"7326","name":"【第13话】鼓起勇气终于开口\u2026\u2026","th":"14","icon":"image/20160816/1471315207706030.jpg","andpubtime":"1471622400"},{"id":"6891","name":"【第12话】出现幻觉","th":"13","icon":"image/20160810/1470794272407366.jpg","andpubtime":"1471017600"},{"id":"6378","name":"【第11话】丛林法则","th":"12","icon":"image/20160802/1470106428612289.jpg","andpubtime":"1470412800"},{"id":"5955","name":"【第10话】不曾体会过的心情","th":"11","icon":"image/20160726/1469500354157628.jpg","andpubtime":"1469808000"},{"id":"5576","name":"【第9话】得到认可","th":"10","icon":"image/20160719/1468894961779272.jpg","andpubtime":"1469203200"},{"id":"5167","name":"【第8话】咸鱼翻身的时机","th":"9","icon":"image/20160712/1468290724441478.jpg","andpubtime":"1468598400"},{"id":"4806","name":"【第7话】学生也有留胡子的权利","th":"8","icon":"image/20160706/1467771354372119.jpg","andpubtime":"1467993600"},{"id":"4206","name":"【第6话】我有小弟了","th":"7","icon":"image/20160628/1467084615173570.jpg","andpubtime":"1467388800"},{"id":"4093","name":"【第5话】请赐予我黄金至尊手！","th":"6","icon":"look/icon/detail_icon2016-06-23/576bacc67b93f.jpg","andpubtime":"1466784000"},{"id":"3824","name":"【第4话】这世界真不公平","th":"5","icon":"look/icon/detail_icon2016-06-15/5760cf42e8afb.jpg","andpubtime":"1466211600"},{"id":"3653","name":"【第3话】药丸","th":"4","icon":"look/icon/detail_icon2016-06-08/5757770874f66.jpg","andpubtime":"1465606800"},{"id":"3490","name":"【第2话】秘密空间","th":"3","icon":"look/icon/detail_icon2016-06-02/574f9d94018c6.jpg","andpubtime":"1465002000"},{"id":"3313","name":"【第1话】在臭水沟里打滚的玩偶","th":"2","icon":"look/icon/detail_icon2016-05-27/5747da5ec98db.jpg","andpubtime":"1464397200"},{"id":"3072","name":"【序章】弱鸡男主","th":"1","icon":"look/icon/detail_icon2016-05-20/573e75ee1cbde.jpg","andpubtime":"1463792400"}]
     */

    @SerializedName("s")
    private int s;
    @SerializedName("c")
    private List<CBean> c;

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public List<CBean> getC() {
        return c;
    }

    public void setC(List<CBean> c) {
        this.c = c;
    }

    public static class CBean {
        /**
         * id : 10931
         * name : 【第25话】两个噩耗
         * th : 26
         * icon : image/20161110/1478758843723523.jpg
         * andpubtime : 1478880000
         */

        @SerializedName("id")
        private String id;
        @SerializedName("name")
        private String name;
        @SerializedName("th")
        private String th;
        @SerializedName("icon")
        private String icon;
        @SerializedName("andpubtime")
        private String andpubtime;

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

        public String getAndpubtime() {
            return andpubtime;
        }

        public void setAndpubtime(String andpubtime) {
            this.andpubtime = andpubtime;
        }
    }
}
