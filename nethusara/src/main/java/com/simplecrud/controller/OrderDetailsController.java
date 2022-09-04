package com.simplecrud.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplecrud.entity.OrderDetails;
import com.simplecrud.entity.enums.PaymentMethodType;
import com.simplecrud.service.OrderDetailService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class OrderDetailsController {

    @Autowired
    private OrderDetailService orderDetailService;


    @GetMapping("/order_detail")
    public ResponseEntity<List<OrderDetails>> getAllOrderDetails() {
        return orderDetailService.getAllOrderDetails();
    }

    @PostMapping("/order_detail")
    public ResponseEntity<OrderDetails> createOrderDetails(@RequestBody OrderDetails orderDetails) {
        System.out.println("OrderDetailsDTO = [" + orderDetails + "]");

        if(orderDetails.getPaymentMethod().equals(PaymentMethodType.PAY_ONLINE)){
            orderDetails.setPaymentMethod(PaymentMethodType.PAY_ONLINE);
        }
        if(orderDetails.getPaymentMethod().equals(PaymentMethodType.CASH_ON_DELIVERY)){
            orderDetails.setPaymentMethod(PaymentMethodType.CASH_ON_DELIVERY);
        }
        return orderDetailService.createOrderDetails(orderDetails);
    }

    @PutMapping("/order_detail/{orderDetailID}")
    public ResponseEntity<OrderDetails> updateOrderDetail(@PathVariable("orderDetailID") Long orderDetailID,
                                                          @RequestBody OrderDetails orderDetailDTO) {
        System.out.println("OrderDetailsDTO = [" + orderDetailDTO + "]");
        return orderDetailService.updateOrderDetails(orderDetailID, orderDetailDTO);
    }

    @DeleteMapping("order_detail/{orderDetailID}")
    public Map<String, Boolean> deleteOrderDetail(@PathVariable("orderDetailID") Long orderDetailID) {
        return orderDetailService.deleteOrderDetails(orderDetailID);
    }

    @GetMapping("/order_detail/{orderDetailID}")
    public ResponseEntity<OrderDetails> searchOrderDetail(@PathVariable("orderDetailID") Long orderDetailID) {
        return orderDetailService.searchOrderDetails(orderDetailID);
    }

}
