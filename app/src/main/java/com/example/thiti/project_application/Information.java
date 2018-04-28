package com.example.thiti.project_application;


public class Information {
    private Long ID;
    private String Topic;
    private String ShortDesc;
    private String LongDesc;
    private String LinkImg;

    public Information() {
    }

    public Information(Long ID, String topic, String shortDesc, String longDesc, String linkImg) {
        this.ID = ID;
        this.Topic = topic;
        this.ShortDesc = shortDesc;
        this.LongDesc = longDesc;
        this.LinkImg = linkImg;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long id) {
        this.ID = id;
    }

    public String getTopic() {
        return Topic;
    }

    public void setTopic(String topic) {
        this.Topic = topic;
    }

    public String getShortDesc() {
        return ShortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.ShortDesc = shortDesc;
    }

    public String getLongDesc() {
        return LongDesc;
    }

    public void setLongDesc(String longDesc) {
        this.LongDesc = longDesc;
    }

    public String getLinkImg() {
        return LinkImg;
    }

    public void setLinkImg(String linkImg) {
        this.LinkImg = linkImg;
    }
}