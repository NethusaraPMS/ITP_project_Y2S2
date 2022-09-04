package com.simplecrud.service;


import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.simplecrud.entity.OrderDetails;

public interface OrderDetailService  {

    ResponseEntity<List<OrderDetails>> getAllOrderDetails();

    ResponseEntity<OrderDetails> createOrderDetails(OrderDetails orderDetailsDTO);

    ResponseEntity<OrderDetails> updateOrderDetails(Long orderDetailID, OrderDetails orderDetailsDTO);

    Map<String , Boolean> deleteOrderDetails(Long orderDetailID);

    ResponseEntity<OrderDetails> searchOrderDetails(Long orderDetailID);
}
