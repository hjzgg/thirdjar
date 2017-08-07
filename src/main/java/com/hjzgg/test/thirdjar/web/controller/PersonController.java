package com.hjzgg.test.thirdjar.web.controller;

import com.hjzgg.test.thirdjar.core.service.PersonService;
import com.hjzgg.test.thirdjar.web.controller.vo.PersonVo;
import com.hjzgg.test.thirdjar.web.controller.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public Object index() {
        return Result.success(personService.findOne("hjz", "123"));
    }

    @RequestMapping(value = "findOne", method = RequestMethod.POST)
    public Object findOne(@RequestParam String username, @RequestParam String password) {
        return Result.success(personService.findOne(username, password));
    }

    @RequestMapping(value = "findOne2", method = RequestMethod.POST)
    public Object findOne2(@RequestBody PersonVo personVo) {
        return Result.success(personService.findOne(personVo.getName(), personVo.getPassword()));
    }
}
