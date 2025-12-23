package org.csw.study.server.impl;

import org.csw.study.entity.Order;
import org.csw.study.mapStruct.OrderMapStruct;
import org.csw.study.mapper.OrderMapper;
import org.csw.study.server.OrderServer;
import org.csw.study.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServerImpl implements OrderServer {

    private final OrderMapper orderMapper;
    private final OrderMapStruct orderMapStruct;

    @Autowired
    public OrderServerImpl(OrderMapper orderMapper, OrderMapStruct orderMapStruct) {
        this.orderMapper = orderMapper;
        this.orderMapStruct = orderMapStruct;
    }

    @Override
    public List<Order> findAllOrders() {
        return orderMapper.findAllOrders();
    }
}
