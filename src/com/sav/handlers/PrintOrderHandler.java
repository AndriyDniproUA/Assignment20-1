package com.sav.handlers;

import com.sav.entities.Order;

public class PrintOrderHandler extends OrderHandler{
    @Override
    public void handle(Order o) {
        System.out.println("This is your order");
        System.out.println("Order ID: "+o.getID());
        System.out.println("Client: "+o.getFrom());
        System.out.println("Order contents: "+o.getText());
        if (next!=null) next.handle(o);
    }
}
