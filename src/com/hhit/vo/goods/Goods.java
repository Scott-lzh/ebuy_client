package com.hhit.vo.goods;

public class Goods {
    //商品的ID
    private int Id;
    //商品的名称
    private String Name;
    //商品的类型ID
    private int TypeId;
    //商品的积分
    private int Credits;
    //商品的价格
    private double Price;
    //商品的简介
    private String Synopsis;
    //商品的生产地方
    private String Area;

    @Override
    public String toString() {
        return "Goods{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", TypeId=" + TypeId +
                ", Credits=" + Credits +
                ", Price=" + Price +
                ", Synopsis='" + Synopsis + '\'' +
                ", Area='" + Area + '\'' +
                '}';
    }

    public Goods(int id, String name, int typeId, int credits, double price, String synopsis, String area) {
        Id = id;
        Name = name;
        TypeId = typeId;
        Credits = credits;
        Price = price;
        Synopsis = synopsis;
        Area = area;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getTypeId() {
        return TypeId;
    }

    public void setTypeId(int typeId) {
        TypeId = typeId;
    }

    public int getCredits() {
        return Credits;
    }

    public void setCredits(int credits) {
        Credits = credits;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getSynopsis() {
        return Synopsis;
    }

    public void setSynopsis(String synopsis) {
        Synopsis = synopsis;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public Goods() {
    }
}
