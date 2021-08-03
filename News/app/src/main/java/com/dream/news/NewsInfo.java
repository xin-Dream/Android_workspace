package com.dream.news;

public class NewsInfo {
    private String icon;
    private String title;
    private String content;
    private int type;
    private long comment;

    public NewsInfo(String icon,String title,String content,int type,long comment){
        this.icon=icon;
        this.comment=comment;
        this.type=type;
        this.title=title;
        this.content=content;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getComment() {
        return comment;
    }

    public void setComment(long comment) {
        this.comment = comment;
    }
}
