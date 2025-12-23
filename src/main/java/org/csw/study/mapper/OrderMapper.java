package org.csw.study.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.csw.study.entity.Order;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<Order> findAllOrders();
}
