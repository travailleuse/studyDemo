package org.csw.study.entity;

import lombok.*;
import org.csw.study.entity.base.BaseEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseEntity {
    private String id;
    private String name;
    private String address;
    private String phone;
    private User user;
}
