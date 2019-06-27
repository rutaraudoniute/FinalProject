package com.example.eshop;

public class Model {

    String title;
    String price;
    int icon;

    public Model (String title, String price, int icon) {
        this.title = title;
        this.price = price;
        this.icon = icon;
    }


    public String getTitle() {
        return this.title;
    }

    public String getPrice() {
        return this.price;
    }

    public int getIcon() {
        return this.icon;
    }

}
