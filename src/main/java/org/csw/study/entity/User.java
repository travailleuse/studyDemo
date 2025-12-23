package org.csw.study.entity;

import lombok.*;
import org.csw.study.entity.base.BaseEntity;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity {
    private String id;
    private String name;
    private String email;
    private LocalDate birthAt;
    private List<Order> orders;
}
