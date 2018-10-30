package com.bolo1.tweet_app.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 菠萝 on 2018/6/22.
 */

public class Joke implements Serializable {

    /**
     * showapi_res_error :
     * showapi_res_id : ed8e688b75b743ca9ea6d3f2764f581e
     * showapi_res_code : 0
     * showapi_res_body : {"allNum":1587,"contentlist":[{"title":"老板：说人话~","id":"5bd6f64f6e36a1e17ded6ff2","img":"https://www.zbjuran.com/uploads/allimg/181029/2-1Q02919430G56.png","ct":"2018-10-29 20:00:15.252","type":2},{"title":"高收入群体的一张合影，知道是什么职业吗","id":"5bd6f64f6e36a1e17ded6ff1","img":"https://www.zbjuran.com/uploads/allimg/181029/2-1Q029194213H5.jpg","ct":"2018-10-29 20:00:15.252","type":2},{"title":"可以把我的脸P到第一张图上吗","id":"5bd6f64f6e36a1e17ded6ff0","img":"https://www.zbjuran.com/uploads/allimg/181029/2-1Q029194513213.png","ct":"2018-10-29 20:00:15.251","type":2},{"title":"老师：emmm..........","id":"5bd6f64f6e36a1e17ded6fef","img":"https://www.zbjuran.com/uploads/allimg/181029/2-1Q029194344F4.png","ct":"2018-10-29 20:00:15.251","type":2},{"title":"都说了不要和豪猪玩~~唉~","id":"5bd6f64f6e36a1e17ded6fee","img":"https://www.zbjuran.com/uploads/allimg/181029/2-1Q029194632409.png","ct":"2018-10-29 20:00:15.251","type":2},{"title":"在一起10年了，第一次分开","id":"5bd5358c6e36a1e17deca562","img":"https://www.zbjuran.com/uploads/allimg/181028/2-1Q02Q1301c46.png","ct":"2018-10-28 12:05:32.270","type":2},{"title":"消防管还可以这么玩","id":"5bd5358c6e36a1e17deca561","img":"https://www.zbjuran.com/uploads/allimg/181028/2-1Q02Q1310L47.png","ct":"2018-10-28 12:05:32.270","type":2},{"title":"我身份证上的照片不忍直视","id":"5bd52d426e36a1e17deca343","img":"https://www.zbjuran.com/uploads/allimg/181028/2-1Q02Q12K2312.jpg","ct":"2018-10-28 11:30:10.814","type":2},{"title":"原来~~~","id":"5bd52d426e36a1e17deca342","img":"https://www.zbjuran.com/uploads/allimg/181028/2-1Q02Q1260Y07.png","ct":"2018-10-28 11:30:10.814","type":2},{"title":"这也能还价~！","id":"5bd52d426e36a1e17deca341","img":"https://www.zbjuran.com/uploads/allimg/181028/2-1Q02Q1252VC.png","ct":"2018-10-28 11:30:10.813","type":2}],"ret_code":0,"currentPage":1,"allPages":159,"maxResult":10}
     */

    private String showapi_res_error;
    private String showapi_res_id;
    private int showapi_res_code;
    private ShowapiResBodyBean showapi_res_body;

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public String getShowapi_res_id() {
        return showapi_res_id;
    }

    public void setShowapi_res_id(String showapi_res_id) {
        this.showapi_res_id = showapi_res_id;
    }

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean {
        /**
         * allNum : 1587
         * contentlist : [{"title":"老板：说人话~","id":"5bd6f64f6e36a1e17ded6ff2","img":"https://www.zbjuran.com/uploads/allimg/181029/2-1Q02919430G56.png","ct":"2018-10-29 20:00:15.252","type":2},{"title":"高收入群体的一张合影，知道是什么职业吗","id":"5bd6f64f6e36a1e17ded6ff1","img":"https://www.zbjuran.com/uploads/allimg/181029/2-1Q029194213H5.jpg","ct":"2018-10-29 20:00:15.252","type":2},{"title":"可以把我的脸P到第一张图上吗","id":"5bd6f64f6e36a1e17ded6ff0","img":"https://www.zbjuran.com/uploads/allimg/181029/2-1Q029194513213.png","ct":"2018-10-29 20:00:15.251","type":2},{"title":"老师：emmm..........","id":"5bd6f64f6e36a1e17ded6fef","img":"https://www.zbjuran.com/uploads/allimg/181029/2-1Q029194344F4.png","ct":"2018-10-29 20:00:15.251","type":2},{"title":"都说了不要和豪猪玩~~唉~","id":"5bd6f64f6e36a1e17ded6fee","img":"https://www.zbjuran.com/uploads/allimg/181029/2-1Q029194632409.png","ct":"2018-10-29 20:00:15.251","type":2},{"title":"在一起10年了，第一次分开","id":"5bd5358c6e36a1e17deca562","img":"https://www.zbjuran.com/uploads/allimg/181028/2-1Q02Q1301c46.png","ct":"2018-10-28 12:05:32.270","type":2},{"title":"消防管还可以这么玩","id":"5bd5358c6e36a1e17deca561","img":"https://www.zbjuran.com/uploads/allimg/181028/2-1Q02Q1310L47.png","ct":"2018-10-28 12:05:32.270","type":2},{"title":"我身份证上的照片不忍直视","id":"5bd52d426e36a1e17deca343","img":"https://www.zbjuran.com/uploads/allimg/181028/2-1Q02Q12K2312.jpg","ct":"2018-10-28 11:30:10.814","type":2},{"title":"原来~~~","id":"5bd52d426e36a1e17deca342","img":"https://www.zbjuran.com/uploads/allimg/181028/2-1Q02Q1260Y07.png","ct":"2018-10-28 11:30:10.814","type":2},{"title":"这也能还价~！","id":"5bd52d426e36a1e17deca341","img":"https://www.zbjuran.com/uploads/allimg/181028/2-1Q02Q1252VC.png","ct":"2018-10-28 11:30:10.813","type":2}]
         * ret_code : 0
         * currentPage : 1
         * allPages : 159
         * maxResult : 10
         */

        private int allNum;
        private int ret_code;
        private int currentPage;
        private int allPages;
        private int maxResult;
        private List<ContentlistBean> contentlist;

        public int getAllNum() {
            return allNum;
        }

        public void setAllNum(int allNum) {
            this.allNum = allNum;
        }

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        @Override
        public String toString() {
            return "ShowapiResBodyBean{" +
                    "allNum=" + allNum +
                    ", ret_code=" + ret_code +
                    ", currentPage=" + currentPage +
                    ", allPages=" + allPages +
                    ", maxResult=" + maxResult +
                    ", contentlist=" + contentlist +
                    '}';
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public int getAllPages() {
            return allPages;
        }

        public void setAllPages(int allPages) {
            this.allPages = allPages;
        }

        public int getMaxResult() {
            return maxResult;
        }

        public void setMaxResult(int maxResult) {
            this.maxResult = maxResult;
        }

        public List<ContentlistBean> getContentlist() {
            return contentlist;
        }

        public void setContentlist(List<ContentlistBean> contentlist) {
            this.contentlist = contentlist;
        }

        public static class ContentlistBean {
            /**
             * title : 老板：说人话~
             * id : 5bd6f64f6e36a1e17ded6ff2
             * img : https://www.zbjuran.com/uploads/allimg/181029/2-1Q02919430G56.png
             * ct : 2018-10-29 20:00:15.252
             * type : 2
             */

            private String title;
            private String id;
            private String img;
            private String ct;
            private int type;
            public String text;

            public String getText() {
                return text;
            }

            @Override
            public String toString() {
                return "ContentlistBean{" +
                        "title='" + title + '\'' +
                        ", id='" + id + '\'' +
                        ", img='" + img + '\'' +
                        ", ct='" + ct + '\'' +
                        ", type=" + type +
                        ", text='" + text + '\'' +
                        '}';
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }
    }
}
