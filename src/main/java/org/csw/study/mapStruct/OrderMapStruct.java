package org.csw.study.mapStruct;

import org.csw.study.entity.Order;
import org.csw.study.vo.OrderVo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapStruct {

    List<OrderVo> toOrderVos(List<Order> orderVos);
    List<Order> toOrders(List<OrderVo> orderVos);
}
