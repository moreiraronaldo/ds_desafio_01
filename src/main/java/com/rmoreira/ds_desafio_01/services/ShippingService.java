package com.rmoreira.ds_desafio_01.services;

import com.rmoreira.ds_desafio_01.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public Double shipment(Order order) {
        Double result = 0.0;

        if(order.getBasic()<100.00) {
            result = 20.00;
        } else if(order.getBasic()>=100 && order.getBasic()<200.00) {
            result = 12.00;
        }
        return result;
    }
}
