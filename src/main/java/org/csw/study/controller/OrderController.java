package org.csw.study.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.csw.study.entity.Order;
import org.csw.study.mapStruct.OrderMapStruct;
import org.csw.study.server.OrderServer;
import org.csw.study.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
@Tag(name = "订单", description = "订单管理")
public class OrderController {

    private final OrderServer orderServer;
    private final OrderMapStruct orderMapStruct;

    @Autowired
    public OrderController(OrderServer orderServer, OrderMapStruct orderMapStruct) {
        this.orderServer = orderServer;
        this.orderMapStruct = orderMapStruct;
    }

    @GetMapping("")
    public ResponseEntity<List<OrderVo>> findAllOrders() {
        List<Order> orders = orderServer.findAllOrders();
        List<OrderVo> orderVos = orderMapStruct.toOrderVos(orders);
        return ResponseEntity.ok(orderVos);
    }
}
