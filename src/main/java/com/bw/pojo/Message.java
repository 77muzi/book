package com.bw.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:lihongqiong
 * @Description:
 * @Date:create in 11:03 2017/8/16
 */
public class Message {
    private int mid;
    private String content;
    private Date createtime;
    private int argent;
    private User user;

    private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy:MM:dd hh:mm:ss");

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatetime() {
        return sdf.format(createtime);
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public int getArgent() {
        return argent;
    }

    public void setArgent(int argent) {
        this.argent = argent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Message{" +
                "mid=" + mid +
                ", content='" + content + '\'' +
                ", createtime=" + createtime +
                ", argent=" + argent +
                ", user=" + user +
                '}';
    }
}
