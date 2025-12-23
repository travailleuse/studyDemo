package org.csw.study.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.csw.study.entity.base.BaseEntity;

@Setter
@Getter
@NoArgsConstructor
public class Course extends BaseEntity {
    private String id;
    private String name;
    private String description;
}
