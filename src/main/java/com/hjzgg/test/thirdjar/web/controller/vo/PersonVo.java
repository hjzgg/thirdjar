package com.hjzgg.test.thirdjar.web.controller.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(exclude={"self"})
@ToString(callSuper=true, exclude="self")
public class PersonVo {
    private Integer id;
    private String name;
    private String password;

    private Double self;
}