package com.basic.basiccore.order.service;

import com.basic.basiccore.order.domain.Order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);
}
