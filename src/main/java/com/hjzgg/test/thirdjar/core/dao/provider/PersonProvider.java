package com.hjzgg.test.thirdjar.core.dao.provider;


import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class PersonProvider {

    public String findOne(Map<String, String> params) {
        return new SQL() {{
            SELECT("*")
                    .FROM("person")
                    .WHERE("name = #{name}")
                    .WHERE("password = #{password}");
        }}.toString();
    }
}
