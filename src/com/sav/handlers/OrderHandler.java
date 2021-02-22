package com.sav.handlers;

import com.sav.entities.Order;
import lombok.Setter;

@Setter
abstract public class OrderHandler {
    protected OrderHandler next;
    abstract public void handle (Order o);
    protected void next (Order o) {
        next.handle(o);
    }

}
