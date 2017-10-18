package com.mytutorial.components;

import org.apache.wicket.model.LoadableDetachableModel;

import com.mytutorial.components.model.Order;
import com.mytutorial.components.service.OrderService;

public class OrderModel extends LoadableDetachableModel<Order>{

    public OrderModel(Order order) {
        super(order);
    }

    @Override
    protected Order load() {
        return  OrderService.get().loadOrder();
    }

    @Override
    public void detach() {
        super.detach();
    }

    @Override
    protected void onDetach() {
        OrderService.get().storeOrder(getObject());
        super.onDetach();
    }
    
   
    
    @Override
    public void setObject(Order object) {
    	// TODO Auto-generated method stub
    	super.setObject(object);
    }
    

}
