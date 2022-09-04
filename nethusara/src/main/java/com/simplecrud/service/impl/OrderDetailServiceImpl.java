package com.simplecrud.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.simplecrud.entity.OrderDetails;
import com.simplecrud.repository.OrderDetailsRepo;
import com.simplecrud.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    @Override
    public ResponseEntity<List<OrderDetails>> getAllOrderDetails() {
        return new ResponseEntity(orderDetailsRepo.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OrderDetails> createOrderDetails(OrderDetails orderDetailsDTO) {

        OrderDetails saveOrderDetail = orderDetailsRepo.save(orderDetailsDTO);
        return new ResponseEntity<>(saveOrderDetail, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OrderDetails> updateOrderDetails(Long orderDetailID, OrderDetails orderDetailsDTO) {
        if (orderDetailsRepo.findById(orderDetailID).isPresent()) {
            Optional<OrderDetails> orderDetails = orderDetailsRepo.findById(orderDetailID);

            orderDetails.get().setReceiverFirstName(orderDetailsDTO.getReceiverFirstName());
            orderDetails.get().setReceiverLastName(orderDetailsDTO.getReceiverLastName());
            orderDetails.get().setDeliveryAddress(orderDetailsDTO.getDeliveryAddress());
            orderDetails.get().setProvince(orderDetailsDTO.getProvince());
            orderDetails.get().setCity(orderDetailsDTO.getCity());
            orderDetails.get().setProductID(orderDetailsDTO.getProductID());
            orderDetails.get().setPostalCode(orderDetailsDTO.getPostalCode());
            orderDetails.get().setMobileNo(orderDetailsDTO.getMobileNo());
            orderDetails.get().setPaymentMethod(orderDetailsDTO.getPaymentMethod());

            OrderDetails updatedOrderDetails = orderDetailsRepo.save(orderDetails.get());
            return new ResponseEntity<>(updatedOrderDetails, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public Map<String, Boolean> deleteOrderDetails(Long orderDetailID) {
        Map<String, Boolean> map = new HashMap<>();
        if (orderDetailsRepo.findById(orderDetailID).isPresent()) {
            orderDetailsRepo.deleteById(orderDetailID);
            map.put("isDeleted", Boolean.TRUE);
            return map;
        }
        map.put("isDeleted", Boolean.FALSE);
        return map;
    }

    @Override
    public ResponseEntity<OrderDetails> searchOrderDetails(Long orderDetailID) {
        return new ResponseEntity<>(orderDetailsRepo.findById(orderDetailID).get(), HttpStatus.OK);
    }
}
