package org.csw.study.vo;

import lombok.Getter;
import lombok.Setter;
import org.csw.study.entity.base.BaseEntity;

import java.time.LocalDate;

@Getter
@Setter
public class UserVo extends BaseEntity {
    private String id;
    private String name;
    private String email;
    private LocalDate birthAt;
}
