package com.simplecrud.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.simplecrud.entity.enums.DeliveryStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "delivery")
public class Delivery {

    @Id
    private String deliveryID;
    private String destination;
    private String driverName;
    private Date driverDate;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;


}

