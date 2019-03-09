package com.hhit.vo.type;

import com.hhit.vo.goods.Goods;

import java.util.List;

public class Type {

private int id;
private String name;
private List<Goods> goodsList;
    public Type() {
    }

    public Type(int id, String name, List<Goods> goodsList) {
        this.id = id;
        this.name = name;
        this.goodsList = goodsList;
    }

    public Type(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
