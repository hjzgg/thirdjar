package com.hjzgg.test.thirdjar.core.service;


import com.hjzgg.test.thirdjar.core.dao.PersonDao;
import com.hjzgg.test.thirdjar.core.dto.PersonDto;
import com.hjzgg.test.thirdjar.retrofit.api.PersonApi;
import com.hjzgg.test.thirdjar.retrofit.build.RetrofitBuild;
import com.hjzgg.test.thirdjar.web.controller.vo.PersonVo;
import com.hjzgg.test.thirdjar.web.controller.vo.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;

import java.io.IOException;

@Service
public class PersonService {

    @Autowired
    private PersonDao personDao;

    private PersonApi personApi = RetrofitBuild.build(PersonApi.class);

    public PersonVo findOne(String username, String password) {
        PersonDto personDto = personDao.findOne(username, password);
        PersonVo personVo = new PersonVo();
        BeanUtils.copyProperties(personDto, personVo);
        return personVo;
    }

//  retrofit api test
    public PersonVo findOne() {
        Call<Result<PersonVo>> call = personApi.findOne("hjz", "123");
        PersonVo personVo = null;
        try {
            Result result = call.execute().body();
            personVo = (PersonVo) result.getData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personVo;
    }

    public PersonVo findOne2() {
        PersonVo personVo = new PersonVo();
        personVo.setName("hjz");
        personVo.setPassword("123");

        Call<Result<PersonVo>> call = personApi.findOne2(personVo);

        try {
            Result result = call.execute().body();
            personVo = (PersonVo) result.getData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personVo;
    }
}
