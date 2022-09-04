package com.simplecrud.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.simplecrud.entity.enums.PaymentMethodType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "OrderDetails")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderDetailID;
    private String receiverFirstName;
    private String receiverLastName;
    private String deliveryAddress;
    private String province;
    private String city;
    private String productID;
    private String postalCode;
    private String mobileNo;

    @Enumerated(EnumType.STRING)
    private PaymentMethodType paymentMethod;

}
