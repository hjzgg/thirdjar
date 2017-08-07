package com.hjzgg.test.thirdjar.core.dao;

import com.hjzgg.test.thirdjar.core.dao.mapper.PersonMapper;
import com.hjzgg.test.thirdjar.core.dto.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class PersonDao {

    @Autowired
    private PersonMapper personMapper;

    public PersonDto findOne(String username, String password) {
        return personMapper.findOne(username, password);
    }
}
