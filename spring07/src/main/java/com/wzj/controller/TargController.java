package com.wzj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TargController {
    @RequestMapping("/target")
    public ModelAndView show(){
      System.out.println("正在执行");
      ModelAndView modelAndView =new ModelAndView();
      modelAndView.addObject("name","itcast");
      modelAndView.setViewName("index");
      return modelAndView;
    }
}

