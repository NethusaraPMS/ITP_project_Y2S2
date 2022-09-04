package com.simplecrud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.simplecrud.entity.Delivery;
import com.simplecrud.repository.DeliveryRepo;
import com.simplecrud.service.DeliveryService;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryRepo deliveryRepo;


    @Override
    public ResponseEntity<List<Delivery>> getAllDeliveries() {
        return new ResponseEntity(deliveryRepo.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Delivery> createDelivery(Delivery deliveryDTO) {
        Delivery savedDelivery = deliveryRepo.save(deliveryDTO);
        return new ResponseEntity(savedDelivery, HttpStatus.OK);
    }
}
