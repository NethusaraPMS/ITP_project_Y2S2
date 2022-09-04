package com.simplecrud.controller.template_controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeliveryTemplateController {


    @RequestMapping("/deliver-status")
    public ModelAndView deliveryStatusView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("delivery/delivery-status");
        return modelAndView;
    }
}
