package com.ningjiahao.phhcomic.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by My on 2016/11/18.
 */

public class DetaiListBean {

    /**
     * s : 0
     * c : [{"id":"11072","name":"【第12话】老掉牙的方式","th":"14","icon":"image/20161115/1479176288416311.jpg","andpubtime":"1479398400"},{"id":"10923","name":"【第11话】玩押注的好处","th":"13","icon":"image/20161110/1478756376418699.jpg","andpubtime":"1478793600"},{"id":"10580","name":"【第10话】谣言会杀人","th":"12","icon":"image/20161102/1478066709265974.jpg","andpubtime":"1478188800"},{"id":"10307","name":"【番外】用我的粉红亮瞎你的眼","th":"11","icon":"image/20161025/1477362711292794.jpg","andpubtime":"1477584000"},{"id":"10155","name":"【第9话】魔鬼训练开始","th":"10","icon":"image/20161020/1476954729128887.jpg","andpubtime":"1476979200"},{"id":"9943","name":"【第8话】多功能老板","th":"9","icon":"image/20161013/1476352916882178.jpg","andpubtime":"1476374400"},{"id":"9609","name":"【第7话】输掉比赛之后的好消息","th":"8","icon":"image/20160930/1475208226446340.jpg","andpubtime":"1475769600"},{"id":"9488","name":"【第6话】神算不如教练算","th":"7","icon":"image/20160928/1475049314915344.jpg","andpubtime":"1475164800"},{"id":"9210","name":"【第5话】轻敌的后果","th":"6","icon":"image/20160922/1474530153728927.jpg","andpubtime":"1474560000"},{"id":"8929","name":"【第4话 下】SCREAM正赛上演","th":"5","icon":"image/20160914/1473835687986085.jpg","andpubtime":"1473955200"},{"id":"8481","name":"【第4话 上】Hit然后Run","th":"4","icon":"image/20160906/1473151818837811.jpg","andpubtime":"1473350400"},{"id":"8337","name":"【第3话】女主角登场居然这么囧","th":"3","icon":"image/20160901/1472715812246767.jpg","andpubtime":"1472745600"},{"id":"7987","name":"【第2话】黄金右手","th":"2","icon":"image/20160826/1472179173673969.jpg","andpubtime":"1472140800"},{"id":"7320","name":"【第1话】车载赫的故事","th":"1","icon":"image/20160816/1471312311955673.jpg","andpubtime":"1471449600"}]
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
         * id : 11072
         * name : 【第12话】老掉牙的方式
         * th : 14
         * icon : image/20161115/1479176288416311.jpg
         * andpubtime : 1479398400
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
