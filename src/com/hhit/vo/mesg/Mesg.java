package com.hhit.vo.mesg;

import java.sql.Date;

public class Mesg {
    //资讯的ID
    private int Id;
    //资讯的标题
    private String Title;
    //资讯的时间
    private Date Time;
    //资讯的作者id
    private int AId;
    //资讯的作者名
    private String Author;
    //资讯的点击数
    private int ClickNum;
    //资讯的内容
    private String text;

    public int getId() {
        return Id;
    }

    public String getTitle() {
        return Title;
    }

    public Date getTime() {
        return Time;
    }

    public int getAId() {
        return AId;
    }

    public String getAuthor() {
        return Author;
    }

    public int getClickNum() {
        return ClickNum;
    }

    public String getText() {
        return text;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setTime(Date time) {
        Time = time;
    }

    public void setAId(int AId) {
        this.AId = AId;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public void setClickNum(int clickNum) {
        ClickNum = clickNum;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Mesg{" +
                "Id=" + Id +
                ", Title='" + Title + '\'' +
                ", Time=" + Time +
                ", AId=" + AId +
                ", Author='" + Author + '\'' +
                ", ClickNum=" + ClickNum +
                ", text='" + text + '\'' +
                '}';
    }
}
