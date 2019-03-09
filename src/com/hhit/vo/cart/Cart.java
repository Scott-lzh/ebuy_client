package com.hhit.vo.cart;

import com.hhit.vo.goods.Goods;
import com.hhit.vo.user.User;

public class Cart {
        private int id;
        private User user;
        private Goods good;
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", user=" + user +
                ", good=" + good +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Goods getGood() {
        return good;
    }

    public void setGood(Goods good) {
        this.good = good;
    }


}
