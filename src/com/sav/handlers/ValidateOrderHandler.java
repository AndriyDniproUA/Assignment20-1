package com.sav.handlers;

import com.sav.entities.Order;

public class ValidateOrderHandler extends OrderHandler{
    @Override
    public void handle(Order o) {
        if (o.getID()==null || o.getFrom()==null||o.getText()==null) {
            System.out.println("The order is not valid");
        } else {
            System.out.println("Order is valid");
            if (next !=null) next.handle(o);
        }
    }
}
