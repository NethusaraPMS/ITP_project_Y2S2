package com.simplecrud.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplecrud.entity.Delivery;
import com.simplecrud.entity.enums.DeliveryStatus;
import com.simplecrud.service.DeliveryService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;


    @GetMapping("/delivery")
    public ResponseEntity<List<Delivery>> getAllDelivery(){
        return deliveryService.getAllDeliveries();
    }

    @PostMapping("/delivery")
    public ResponseEntity<Delivery> createDelivery(@RequestBody Delivery deliveryDTO ){
        System.out.println("DeliveryDTO = [" + deliveryDTO + "]");

        if(deliveryDTO.getDeliveryStatus().equals(DeliveryStatus.COMPLETED)){
            deliveryDTO.setDeliveryStatus(DeliveryStatus.COMPLETED);
        }
        if(deliveryDTO.getDeliveryStatus().equals(DeliveryStatus.INCOMPLETE)){
            deliveryDTO.setDeliveryStatus(DeliveryStatus.INCOMPLETE);
        }

        return deliveryService.createDelivery(deliveryDTO);
    }


}
