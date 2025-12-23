package org.csw.study.server;

import org.csw.study.entity.Order;

import java.util.List;
public interface OrderServer {
    List<Order> findAllOrders();
}
