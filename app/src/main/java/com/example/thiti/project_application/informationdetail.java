package com.example.thiti.project_application;



public class informationdetail {
    private int information_id;
    private String title;
    private String shortdesc;
    private String fulldesc;
    private String image;

    public informationdetail(int id, String title, String shortdesc, String fulldesc, String image) {
        this.information_id = id;
        this.title = title;
        this.shortdesc = shortdesc;
        this.fulldesc = fulldesc;
        this.image = image;
    }

    public int getId() {
        return information_id;
    }

    public String getTitle() {
        return title;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public String getFulldesc() {
        return fulldesc;
    }

    public String getImage() {
        return image;
    }
}