package com.sav.utils;

import com.sav.entities.Order;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderBuilder {
    Order order;

    public OrderBuilder ID(String ID) {
        order.setID(ID);
        return this;
    }

    public OrderBuilder from(String from) {
        order.setFrom(from);
        return this;
    }

    public OrderBuilder text(String text) {
        order.setText(text);
        return this;
    }

    public Order build() {
        return order;
    }

    public static OrderBuilder builder() {
        return new OrderBuilder(new Order());
    }



}
