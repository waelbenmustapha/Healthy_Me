package com.example.healthhealth;

public class MyListData {


    private String description;
    private String name;
    private String color;
    private int imgId;
    public MyListData(String description, int imgId,String name,String color) {
        this.description = description;
        this.imgId = imgId;
        this.color=color;
        this.name=name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public int getImgId() {
        return imgId;
    }
    public void setImgId(int imgId) {
        this.imgId = imgId;
    }


}
