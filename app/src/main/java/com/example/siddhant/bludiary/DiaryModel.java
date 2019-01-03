package com.example.siddhant.bludiary;


public class DiaryModel {
    public String heading;
    public String desc;

    public DiaryModel() {

    }

    public DiaryModel(String heading, String desc){
        this.heading = heading;
        this.desc = desc;
    }

    public String getHeading(){
        return heading;
    }
    public void setHeading(String heading){
        this.heading=heading;
    }
    public String getDesc(){
        return desc;
    }
    public void setDesc(String desc){
        this.desc=desc;
    }

}
