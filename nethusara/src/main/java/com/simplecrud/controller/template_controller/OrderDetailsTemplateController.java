package com.simplecrud.controller.template_controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderDetailsTemplateController {

    @RequestMapping("/order-details")
    public ModelAndView orderDetailsView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("order-details/order-details");
        return modelAndView;

    }
}
