package com.cdg.base.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/guest")
    public void forGuest(){
        System.out.println("guest");
    }

    @RequestMapping("/manager")
    public void forManager(){
        System.out.println("manager");
    }

    @RequestMapping("/admin")
    public void forAdmin(){
        System.out.println("admin");
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping("/adminSecret")
    public void forAdminSecret(){
        System.out.println("admin secret");
    }

    @Secured({"ROLE_MANAGER"})
    @RequestMapping("/managerSecret")
    public void forManagerSecret(){
        System.out.println("manager secret");
    }

}
