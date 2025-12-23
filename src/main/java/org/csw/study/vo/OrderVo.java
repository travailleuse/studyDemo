package org.csw.study.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.csw.study.entity.base.BaseEntity;

@Getter
@Setter
@NoArgsConstructor
public class OrderVo extends BaseEntity {
    private String id;
    private String name;
    private String address;
    private String phone;
    UserVo user;
}
