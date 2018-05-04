package com.ssh.controller;

import com.ssh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by XRog
 * On 2/1/2017.12:36 AM
 */
@Controller
public class MainController {

    @Autowired
    private PersonService personService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "savePerson", method = RequestMethod.GET)
    @ResponseBody
    public String savePerson(){
        personService.save();
        return "success!";
    }

    @RequestMapping(value = "saveUser", method = RequestMethod.GET)
    @ResponseBody
    public String saveUser(){
        userService.save();
        return "success!";
    }
}