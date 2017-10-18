package com.mytutorial.components.service;

import com.mytutorial.components.model.Order;

public class OrderService {

    private static OrderService INSTANCE;

    private static int version;

    private Order storedOrder;

    private OrderService() {

    }

    public static OrderService get() {
        if (INSTANCE == null) {
            INSTANCE = new OrderService();
        }
        return INSTANCE;
    }

    public void storeOrder(Order order) {
        version++;
        order.setVersion(version);
        storedOrder = order;
    }

    public Order loadOrder() {
        return storedOrder;
    }

}
