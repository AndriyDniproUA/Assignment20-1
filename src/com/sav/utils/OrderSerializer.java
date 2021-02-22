package com.sav.utils;

import com.sav.entities.Order;

public interface OrderSerializer {
    String serialize (Order o);
    Order deserialize (String s);
}
