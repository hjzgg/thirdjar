package com.hjzgg.test.thirdjar.core.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(exclude={"self"})
@ToString(callSuper=true, exclude="self")
public class PersonDto {
    private Integer id;
    private String name;
    private String password;

    private Double self;
}