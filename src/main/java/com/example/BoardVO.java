package com.example;


import java.util.Date;

public class BoardVO {
    private int seq;
    private String title;
    private String writer;
    private String content;

    private String gender;
    private Date regdate;

    private String category;
    private Date editdate;
    private int cnt;

    public int getSeq() {
        return seq;
    }
    public void setSeq(int seq) {
        this.seq = seq;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {this.gender = gender;}

    public Date getRegdate() {return regdate;}
    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }
    public Date getEditdate() {return editdate;}
    public void setEditdate(Date editdate) {
        this.editdate = editdate;
    }

    public int getCnt() {
        return cnt;
    }
    public void setCnt(int cnt) {
        this.cnt = cnt;
    }


    public void setPhoto(String filename) {
    }
}

