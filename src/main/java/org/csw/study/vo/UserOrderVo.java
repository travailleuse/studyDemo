package org.csw.study.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserOrderVo {
    private String id;
    private String name;
    private String email;
    private LocalDate birthAt;
    private List<OrderVo> orders;
}
