package com.scienjus.smartqq.response.domain;

public class MessageRes {
    private Long groupid;
    private String content;
    private Long userid;




    public Long getGroupid() {
        return groupid;
    }

    public void setGroupid(Long groupid) {
        this.groupid = groupid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "message{" +
                "groupid=" + groupid +
                ", content='" + content + '\'' +
                ", userid=" + userid +
                '}';
    }
}
