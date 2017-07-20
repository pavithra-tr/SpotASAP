package com.mobileapp.cloudmaster.spotsoon;

/**
 * Created by Pavithra on 22-05-2017.
 */

public class DataModel {

    String name;
    String des;
    String rate;
    int id_;
    int image;

    public DataModel(String name, String des, String rate, int id_, int image) {
        this.name = name;
        this.des = des;
        this.rate = rate;
        this.id_ = id_;
        this.image = image;
    }

    public String getDes() {
        return des;
    }

    public int getid() {
        return id_;
    }

    public String getRate() {
        return rate;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return des;
    }

    public int getImage() {
        return image;
    }

    public int getId() {
        return id_;
    }
}
