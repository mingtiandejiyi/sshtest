package com.ssh.controller;

import com.ssh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private UserService userService;

    /**
     * @return
     */
    @RequestMapping(value = "index", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public String login(Model model) {
        model.addAttribute("error","");
        return "index";
    }

    @RequestMapping(value = "saveUser", method = RequestMethod.GET)
    @ResponseBody
    public String saveUser(){
        userService.save();
        return "success!";
    }
}