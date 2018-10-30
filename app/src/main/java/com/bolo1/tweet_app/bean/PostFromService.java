package com.bolo1.tweet_app.bean;

/**
 * Created by 菠萝 on 2018/6/26.
 */

public class PostFromService{

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public String getData_type() {
        return data_type;
    }

    public void setData_type(String data_type) {
        this.data_type = data_type;
    }


    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    private String type;//请求类型
    private int pageSize;//请求数据的大小
    private int currentPage;//当前请求的页
    private String data_type;
   private String body;//需要发送的消息
    private int limit_start;
    private int limit_end;
    //更具文章id查询用户信息
    @Override
    public String toString() {
        return "{" +
                "\"type\":\""+ type +"\"" +
                ",\"pageSize\":\""+ pageSize +"\"" +
                ",\"currentPage\":\""+ currentPage +"\"" +
                ",\"data_type\":\""+ data_type +"\"" +
                ",\"body\":\""+ body +"\"" +
                ",\"limit_start\":\""+ limit_start +"\"" +
                ",\"limit_end\":\""+ limit_end +"\"" +
                ",\"State\":\""+ State +"\"" +
                '}';
    }

    public int getLimit_start() {
        return limit_start;
    }

    public void setLimit_start(int limit_start) {
        this.limit_start = limit_start;
    }

    public int getLimit_end() {
        return limit_end;
    }

    public void setLimit_end(int limit_end) {
        this.limit_end = limit_end;
    }

    public String getBody() {

        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    private String State;//返回的状态;

}
