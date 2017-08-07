package com.hjzgg.test.thirdjar.core.dao.mapper;

import com.hjzgg.test.thirdjar.core.dao.provider.PersonProvider;
import com.hjzgg.test.thirdjar.core.dto.PersonDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;


@Mapper
public interface PersonMapper {
    @SelectProvider(type = PersonProvider.class, method = "findOne")
    PersonDto findOne(@Param("name") String username, @Param("password") String password);
}
