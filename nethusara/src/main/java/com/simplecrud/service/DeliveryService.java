package com.simplecrud.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.simplecrud.entity.Delivery;


public interface DeliveryService {

    ResponseEntity<List<Delivery>> getAllDeliveries();

    ResponseEntity<Delivery> createDelivery(Delivery deliveryDTO);
}
