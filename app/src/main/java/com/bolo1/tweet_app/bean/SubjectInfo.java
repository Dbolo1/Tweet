package com.bolo1.tweet_app.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 菠萝 on 2017/10/27.
 */

public class SubjectInfo {

    /**
     * tag1 : 缇庡コ
     * tag2 : 鍏ㄩ儴
     * totalNum : 16870
     * start_index : 1
     * return_number : 10
     * data : [{"id":"9561443190","setId":"-1","pn":1,"abs":"婕備寒MM娓呮柊椋庢牸鍐欑湡","desc":"婕備寒MM娓呮柊椋庢牸鍐欑湡","tags":["鐢滅礌绾�"],"tag":"鍏ㄩ儴","date":"2016-10-25","like_num":"","is_single":"","fashion_id":"","dress_id":"","fushi_obj_num":"","fushi_obj_array":"null","dress_buy_link":"","dress_price":"","dress_tag":"","dress_num":"","dress_discount":"","dress_other":"","dress_extend_type":"","dress_extend_name":"","children_vote":"","dislike_num":"","image_url":"http://g.hiphotos.baidu.com/image/pic/item/3b87e950352ac65c6633bb7af9f2b21193138a81.jpg","image_width":650,"image_height":951,"download_url":"http://g.hiphotos.baidu.com/image/pic/item/3b87e950352ac65c6633bb7af9f2b21193138a81.jpg","thumbnail_url":"http://imgt6.bdstatic.com/it/u=2,971508598&fm=25&gp=0.jpg","thumbnail_width":230,"thumbnail_height":336,"thumb_large_width":310,"thumb_large_height":453,"thumb_large_url":"http://imgt7.bdstatic.com/it/u=2,971508598&fm=19&gp=0.jpg","site_name":"","site_logo":"","site_url":"http://www.yjz9.com","from_url":"http://www.yjz9.com/2012/photo_xg_0417/2727.shtml","obj_url":"http://www.yjz9.com/uploadfile/2013/0115/20130115124254562.jpg","share_url":"http://g.hiphotos.baidu.com/image/s=550;c=wantu,8,95/sign=d74f450d5b82b2b7a39f39c10196a8d2/3b87e950352ac65c6633bb7af9f2b21193138a81.jpg?referer=ed5ba7fbd7628535cbf7e711f69f","download_num":0,"collect_num":0,"start_index":1,"return_number":10,"album_di":"","can_album_id":"","album_obj_num":"0","user_id":"814563409","app_id":"","colum":"缇庡コ","photo_id":"9561443190","is_album":0,"is_vip":0,"from_name":0,"hostname":"www.yjz9.com","parent_tag":"","desc_info":"","other_urls":[],"isAdapted":1}]
     */

    private String tag1;
    private String tag2;
    private int totalNum;
    private int start_index;
    private int return_number;
    private List<DataBean> data;

    public String getTag1() {
        return tag1;
    }

    public void setTag1(String tag1) {
        this.tag1 = tag1;
    }

    public String getTag2() {
        return tag2;
    }

    public void setTag2(String tag2) {
        this.tag2 = tag2;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getStart_index() {
        return start_index;
    }

    public void setStart_index(int start_index) {
        this.start_index = start_index;
    }

    public int getReturn_number() {
        return return_number;
    }

    public void setReturn_number(int return_number) {
        this.return_number = return_number;
    }

    public List<DataBean> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "SubjectInfo{" +
                "tag1='" + tag1 + '\'' +
                ", tag2='" + tag2 + '\'' +
                ", totalNum=" + totalNum +
                ", start_index=" + start_index +
                ", return_number=" + return_number +
                ", data=" + data +
                '}';
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 9561443190
         * setId : -1
         * pn : 1
         * abs : 婕備寒MM娓呮柊椋庢牸鍐欑湡0
         * desc : 婕備寒MM娓呮柊椋庢牸鍐欑湡
         * tags : ["鐢滅礌绾�"]000
         * tag : 鍏ㄩ儴
         * date : 2016-10-25
         * like_num :
         * is_single :
         * fashion_id :
         * dress_id :
         * fushi_obj_num :
         * fushi_obj_array : null
         * dress_buy_link :
         * dress_price :
         * dress_tag :
         * dress_num :
         * dress_discount :
         * dress_other :
         * dress_extend_type :
         * dress_extend_name :
         * children_vote :
         * dislike_num :
         * image_url : http://g.hiphotos.baidu.com/image/pic/item/3b87e950352ac65c6633bb7af9f2b21193138a81.jpg
         * image_width : 650
         * image_height : 951
         * download_url : http://g.hiphotos.baidu.com/image/pic/item/3b87e950352ac65c6633bb7af9f2b21193138a81.jpg
         * thumbnail_url : http://imgt6.bdstatic.com/it/u=2,971508598&fm=25&gp=0.jpg
         * thumbnail_width : 230
         * thumbnail_height : 336
         * thumb_large_width : 310
         * thumb_large_height : 453
         * thumb_large_url : http://imgt7.bdstatic.com/it/u=2,971508598&fm=19&gp=0.jpg
         * site_name :
         * site_logo :
         * site_url : http://www.yjz9.com
         * from_url : http://www.yjz9.com/2012/photo_xg_0417/2727.shtml
         * obj_url : http://www.yjz9.com/uploadfile/2013/0115/20130115124254562.jpg
         * share_url : http://g.hiphotos.baidu.com/image/s=550;c=wantu,8,95/sign=d74f450d5b82b2b7a39f39c10196a8d2/3b87e950352ac65c6633bb7af9f2b21193138a81.jpg?referer=ed5ba7fbd7628535cbf7e711f69f
         * download_num : 0
         * collect_num : 0
         * start_index : 1
         * return_number : 10
         * album_di :
         * can_album_id :
         * album_obj_num : 0
         * user_id : 814563409
         * app_id :
         * colum : 缇庡コ
         * photo_id : 9561443190
         * is_album : 0
         * is_vip : 0
         * from_name : 0
         * hostname : www.yjz9.com
         * parent_tag :
         * desc_info :
         * other_urls : []
         * isAdapted : 1
         */

        private String id;
        private String setId;
        private int pn;
        private String abs;
        @SerializedName("desc")
        private String descX;
        private String tag;
        private String date;
        private String like_num;
        private String is_single;
        private String fashion_id;
        private String dress_id;
        private String fushi_obj_num;
        private String fushi_obj_array;
        private String dress_buy_link;
        private String dress_price;
        private String dress_tag;
        private String dress_num;
        private String dress_discount;
        private String dress_other;
        private String dress_extend_type;
        private String dress_extend_name;
        private String children_vote;
        private String dislike_num;
        @SerializedName("image_url")
        private String image_urlX;
        private int image_width;
        private int image_height;
        private String download_url;
        private String thumbnail_url;
        private int thumbnail_width;
        private int thumbnail_height;
        private int thumb_large_width;
        private int thumb_large_height;
        private String thumb_large_url;
        private String site_name;
        private String site_logo;
        private String site_url;
        private String from_url;
        private String obj_url;
        private String share_url;
        private int download_num;
        private int collect_num;
        private int start_index;
        private int return_number;
        private String album_di;
        private String can_album_id;
        private String album_obj_num;
        private String user_id;
        private String app_id;
        private String colum;
        private String photo_id;
        private int is_album;
        private int is_vip;
        private int from_name;
        private String hostname;
        private String parent_tag;
        private String desc_info;
        private int isAdapted;
        private List<String> tags;
        private List<?> other_urls;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSetId() {
            return setId;
        }

        public void setSetId(String setId) {
            this.setId = setId;
        }

        public int getPn() {
            return pn;
        }

        public void setPn(int pn) {
            this.pn = pn;
        }

        public String getAbs() {
            return abs;
        }

        public void setAbs(String abs) {
            this.abs = abs;
        }

        public String getDescX() {
            return descX;
        }

        public void setDescX(String descX) {
            this.descX = descX;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getLike_num() {
            return like_num;
        }

        public void setLike_num(String like_num) {
            this.like_num = like_num;
        }

        public String getIs_single() {
            return is_single;
        }

        public void setIs_single(String is_single) {
            this.is_single = is_single;
        }

        public String getFashion_id() {
            return fashion_id;
        }

        public void setFashion_id(String fashion_id) {
            this.fashion_id = fashion_id;
        }

        public String getDress_id() {
            return dress_id;
        }

        public void setDress_id(String dress_id) {
            this.dress_id = dress_id;
        }

        public String getFushi_obj_num() {
            return fushi_obj_num;
        }

        public void setFushi_obj_num(String fushi_obj_num) {
            this.fushi_obj_num = fushi_obj_num;
        }

        public String getFushi_obj_array() {
            return fushi_obj_array;
        }

        public void setFushi_obj_array(String fushi_obj_array) {
            this.fushi_obj_array = fushi_obj_array;
        }

        public String getDress_buy_link() {
            return dress_buy_link;
        }

        public void setDress_buy_link(String dress_buy_link) {
            this.dress_buy_link = dress_buy_link;
        }

        public String getDress_price() {
            return dress_price;
        }

        public void setDress_price(String dress_price) {
            this.dress_price = dress_price;
        }

        public String getDress_tag() {
            return dress_tag;
        }

        public void setDress_tag(String dress_tag) {
            this.dress_tag = dress_tag;
        }

        public String getDress_num() {
            return dress_num;
        }

        public void setDress_num(String dress_num) {
            this.dress_num = dress_num;
        }

        public String getDress_discount() {
            return dress_discount;
        }

        public void setDress_discount(String dress_discount) {
            this.dress_discount = dress_discount;
        }

        public String getDress_other() {
            return dress_other;
        }

        public void setDress_other(String dress_other) {
            this.dress_other = dress_other;
        }

        public String getDress_extend_type() {
            return dress_extend_type;
        }

        public void setDress_extend_type(String dress_extend_type) {
            this.dress_extend_type = dress_extend_type;
        }

        public String getDress_extend_name() {
            return dress_extend_name;
        }

        public void setDress_extend_name(String dress_extend_name) {
            this.dress_extend_name = dress_extend_name;
        }

        public String getChildren_vote() {
            return children_vote;
        }

        public void setChildren_vote(String children_vote) {
            this.children_vote = children_vote;
        }

        public String getDislike_num() {
            return dislike_num;
        }

        public void setDislike_num(String dislike_num) {
            this.dislike_num = dislike_num;
        }

        public String getImage_urlX() {
            return image_urlX;
        }

        public void setImage_urlX(String image_urlX) {
            this.image_urlX = image_urlX;
        }

        public int getImage_width() {
            return image_width;
        }

        public void setImage_width(int image_width) {
            this.image_width = image_width;
        }

        public int getImage_height() {
            return image_height;
        }

        public void setImage_height(int image_height) {
            this.image_height = image_height;
        }

        public String getDownload_url() {
            return download_url;
        }

        public void setDownload_url(String download_url) {
            this.download_url = download_url;
        }

        public String getThumbnail_url() {
            return thumbnail_url;
        }

        public void setThumbnail_url(String thumbnail_url) {
            this.thumbnail_url = thumbnail_url;
        }

        public int getThumbnail_width() {
            return thumbnail_width;
        }

        public void setThumbnail_width(int thumbnail_width) {
            this.thumbnail_width = thumbnail_width;
        }

        public int getThumbnail_height() {
            return thumbnail_height;
        }

        public void setThumbnail_height(int thumbnail_height) {
            this.thumbnail_height = thumbnail_height;
        }

        public int getThumb_large_width() {
            return thumb_large_width;
        }

        public void setThumb_large_width(int thumb_large_width) {
            this.thumb_large_width = thumb_large_width;
        }

        public int getThumb_large_height() {
            return thumb_large_height;
        }

        public void setThumb_large_height(int thumb_large_height) {
            this.thumb_large_height = thumb_large_height;
        }

        public String getThumb_large_url() {
            return thumb_large_url;
        }

        public void setThumb_large_url(String thumb_large_url) {
            this.thumb_large_url = thumb_large_url;
        }

        public String getSite_name() {
            return site_name;
        }

        public void setSite_name(String site_name) {
            this.site_name = site_name;
        }

        public String getSite_logo() {
            return site_logo;
        }

        public void setSite_logo(String site_logo) {
            this.site_logo = site_logo;
        }

        public String getSite_url() {
            return site_url;
        }

        public void setSite_url(String site_url) {
            this.site_url = site_url;
        }

        public String getFrom_url() {
            return from_url;
        }

        public void setFrom_url(String from_url) {
            this.from_url = from_url;
        }

        public String getObj_url() {
            return obj_url;
        }

        public void setObj_url(String obj_url) {
            this.obj_url = obj_url;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public int getDownload_num() {
            return download_num;
        }

        public void setDownload_num(int download_num) {
            this.download_num = download_num;
        }

        public int getCollect_num() {
            return collect_num;
        }

        public void setCollect_num(int collect_num) {
            this.collect_num = collect_num;
        }

        public int getStart_index() {
            return start_index;
        }

        public void setStart_index(int start_index) {
            this.start_index = start_index;
        }

        public int getReturn_number() {
            return return_number;
        }

        public void setReturn_number(int return_number) {
            this.return_number = return_number;
        }

        public String getAlbum_di() {
            return album_di;
        }

        public void setAlbum_di(String album_di) {
            this.album_di = album_di;
        }

        public String getCan_album_id() {
            return can_album_id;
        }

        public void setCan_album_id(String can_album_id) {
            this.can_album_id = can_album_id;
        }

        public String getAlbum_obj_num() {
            return album_obj_num;
        }

        public void setAlbum_obj_num(String album_obj_num) {
            this.album_obj_num = album_obj_num;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getApp_id() {
            return app_id;
        }

        public void setApp_id(String app_id) {
            this.app_id = app_id;
        }

        public String getColum() {
            return colum;
        }

        public void setColum(String colum) {
            this.colum = colum;
        }

        public String getPhoto_id() {
            return photo_id;
        }

        public void setPhoto_id(String photo_id) {
            this.photo_id = photo_id;
        }

        public int getIs_album() {
            return is_album;
        }

        public void setIs_album(int is_album) {
            this.is_album = is_album;
        }

        public int getIs_vip() {
            return is_vip;
        }

        public void setIs_vip(int is_vip) {
            this.is_vip = is_vip;
        }

        public int getFrom_name() {
            return from_name;
        }

        public void setFrom_name(int from_name) {
            this.from_name = from_name;
        }

        public String getHostname() {
            return hostname;
        }

        public void setHostname(String hostname) {
            this.hostname = hostname;
        }

        public String getParent_tag() {
            return parent_tag;
        }

        public void setParent_tag(String parent_tag) {
            this.parent_tag = parent_tag;
        }

        public String getDesc_info() {
            return desc_info;
        }

        public void setDesc_info(String desc_info) {
            this.desc_info = desc_info;
        }

        public int getIsAdapted() {
            return isAdapted;
        }

        public void setIsAdapted(int isAdapted) {
            this.isAdapted = isAdapted;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        public List<?> getOther_urls() {
            return other_urls;
        }

        public void setOther_urls(List<?> other_urls) {
            this.other_urls = other_urls;
        }
    }
}
