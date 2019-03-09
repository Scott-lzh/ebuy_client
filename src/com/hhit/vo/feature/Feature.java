package com.hhit.vo.feature;

import com.hhit.vo.goods.Goods;

public class Feature {

    //商品特价
    private double price;
    //商品特价简介
    private String reason;
    //商品
    private Goods good;

    public Feature(double price, String reason, Goods good) {
        this.price = price;
        this.reason = reason;
        this.good = good;
    }

    public Goods getGood() {
        return good;

    }

    public void setGood(Goods good) {
        this.good = good;
    }

    public Feature() {
    }





    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
