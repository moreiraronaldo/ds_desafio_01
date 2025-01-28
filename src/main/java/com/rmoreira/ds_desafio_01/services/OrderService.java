package com.rmoreira.ds_desafio_01.services;

import com.rmoreira.ds_desafio_01.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public Double total(Order order) {
        Double total = (order.getBasic() * ((100- order.getDiscount()) / 100));
        order.setBasic(total);
        return total + shippingService.shipment(order);
    }
}
