package com.bolo1.tweet_app.bean;

import java.util.ArrayList;
import java.util.List;

public class Video {
    /**
     * retcode : 000000
     * pageToken : 2
     * hasNext : true
     * appCode : miaopai
     * data : [{"url":null,"commentCount":0,"catPathKey":null,"catId1":null,"catName1":null,"videoUrls":["http://gslb.miaopai.com/stream/z4PvM~XwJMykD~pcFkivrwt-RxyGZgro~Q6-Aw__.mp4?vend=miaopai&ssig=9df43c3b8b80c58275a788172c127769&time_stamp=1540458803682"],"description":"#搞笑##搞笑#","favoriteCount":null,"publishDate":1538270409,"posterScreenName":"游来游去015","memberOnly":null,"dislikeCount":null,"viewCount":0,"likeCount":0,"title":"#搞笑[超话]#[允悲]","id":"z4PvM~XwJMykD~pcFkivrwt-RxyGZgro~Q6-Aw__","publishDateStr":"2018-09-30T01:20:09","location":null,"tags":["搞笑[超话]","搞笑"],"mediaType":"2","partList":null,"danmakuCount":null,"durationMin":9,"isFree":null,"posterId":"nt5Brgc5Cu210IIF6ZFaruLC6Q2VEyM0","coverUrl":"http://imgaliyuncdn.miaopai.com/images/z4PvM~XwJMykD~pcFkivrwt-RxyGZgro~Q6-Aw___wjej.jpg"}]
     */

    private String retcode;
    private String pageToken;
    private boolean hasNext;
    private String appCode;
    private ArrayList<DataBean> data;

    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }

    public String getPageToken() {
        return pageToken;
    }

    public void setPageToken(String pageToken) {
        this.pageToken = pageToken;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public ArrayList<DataBean> getData() {
        return data;
    }

    public void setData(ArrayList<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * url : null
         * commentCount : 0
         * catPathKey : null
         * catId1 : null
         * catName1 : null
         * videoUrls : ["http://gslb.miaopai.com/stream/z4PvM~XwJMykD~pcFkivrwt-RxyGZgro~Q6-Aw__.mp4?vend=miaopai&ssig=9df43c3b8b80c58275a788172c127769&time_stamp=1540458803682"]
         * description : #搞笑##搞笑#
         * favoriteCount : null
         * publishDate : 1538270409
         * posterScreenName : 游来游去015
         * memberOnly : null
         * dislikeCount : null
         * viewCount : 0
         * likeCount : 0
         * title : #搞笑[超话]#[允悲]
         * id : z4PvM~XwJMykD~pcFkivrwt-RxyGZgro~Q6-Aw__
         * publishDateStr : 2018-09-30T01:20:09
         * location : null
         * tags : ["搞笑[超话]","搞笑"]
         * mediaType : 2
         * partList : null
         * danmakuCount : null
         * durationMin : 9
         * isFree : null
         * posterId : nt5Brgc5Cu210IIF6ZFaruLC6Q2VEyM0
         * coverUrl : http://imgaliyuncdn.miaopai.com/images/z4PvM~XwJMykD~pcFkivrwt-RxyGZgro~Q6-Aw___wjej.jpg
         */

        private String url;
        private int commentCount;
        private Object catPathKey;
        private Object catId1;
        private Object catName1;
        private String description;
        private Object favoriteCount;
        private int publishDate;
        private String posterScreenName;
        private Object memberOnly;
        private Object dislikeCount;
        private int viewCount;
        private int likeCount;
        private String title;
        private String id;
        private String publishDateStr;
        private Object location;
        private String mediaType;
        private Object partList;
        private Object danmakuCount;
        private int durationMin;
        private Object isFree;
        private String posterId;
        private String coverUrl;
        private List<String> videoUrls;
        private List<String> tags;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public Object getCatPathKey() {
            return catPathKey;
        }

        public void setCatPathKey(Object catPathKey) {
            this.catPathKey = catPathKey;
        }

        public Object getCatId1() {
            return catId1;
        }

        public void setCatId1(Object catId1) {
            this.catId1 = catId1;
        }

        public Object getCatName1() {
            return catName1;
        }

        public void setCatName1(Object catName1) {
            this.catName1 = catName1;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Object getFavoriteCount() {
            return favoriteCount;
        }

        public void setFavoriteCount(Object favoriteCount) {
            this.favoriteCount = favoriteCount;
        }

        public int getPublishDate() {
            return publishDate;
        }

        public void setPublishDate(int publishDate) {
            this.publishDate = publishDate;
        }

        public String getPosterScreenName() {
            return posterScreenName;
        }

        public void setPosterScreenName(String posterScreenName) {
            this.posterScreenName = posterScreenName;
        }

        public Object getMemberOnly() {
            return memberOnly;
        }

        public void setMemberOnly(Object memberOnly) {
            this.memberOnly = memberOnly;
        }

        public Object getDislikeCount() {
            return dislikeCount;
        }

        public void setDislikeCount(Object dislikeCount) {
            this.dislikeCount = dislikeCount;
        }

        public int getViewCount() {
            return viewCount;
        }

        public void setViewCount(int viewCount) {
            this.viewCount = viewCount;
        }

        public int getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
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

        public String getPublishDateStr() {
            return publishDateStr;
        }

        public void setPublishDateStr(String publishDateStr) {
            this.publishDateStr = publishDateStr;
        }

        public Object getLocation() {
            return location;
        }

        public void setLocation(Object location) {
            this.location = location;
        }

        public String getMediaType() {
            return mediaType;
        }

        public void setMediaType(String mediaType) {
            this.mediaType = mediaType;
        }

        public Object getPartList() {
            return partList;
        }

        public void setPartList(Object partList) {
            this.partList = partList;
        }

        public Object getDanmakuCount() {
            return danmakuCount;
        }

        public void setDanmakuCount(Object danmakuCount) {
            this.danmakuCount = danmakuCount;
        }

        public int getDurationMin() {
            return durationMin;
        }

        public void setDurationMin(int durationMin) {
            this.durationMin = durationMin;
        }

        public Object getIsFree() {
            return isFree;
        }

        public void setIsFree(Object isFree) {
            this.isFree = isFree;
        }

        public String getPosterId() {
            return posterId;
        }

        public void setPosterId(String posterId) {
            this.posterId = posterId;
        }

        public String getCoverUrl() {
            return coverUrl;
        }

        public void setCoverUrl(String coverUrl) {
            this.coverUrl = coverUrl;
        }

        public List<String> getVideoUrls() {
            return videoUrls;
        }

        public void setVideoUrls(List<String> videoUrls) {
            this.videoUrls = videoUrls;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }
    }


}
