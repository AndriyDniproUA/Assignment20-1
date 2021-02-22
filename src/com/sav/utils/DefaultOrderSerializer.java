package com.sav.utils;

import com.sav.entities.Order;

public class DefaultOrderSerializer implements OrderSerializer {
    @Override
    public String serialize(Order o) {
        return String.format("%s[%s:%s]",
                o.getID(),
                o.getFrom(),
                o.getText());

    }

    @Override
    public Order deserialize(String s) {
        String[] parts = s.split("\\[|:|\\||\\]");
        return OrderBuilder.builder()
                .ID(parts[0])
                .from(parts[1])
                .text(parts[2])
                .build();
    }
}
