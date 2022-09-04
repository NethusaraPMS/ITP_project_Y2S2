package com.simplecrud.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplecrud.entity.Delivery;

@Repository
public interface DeliveryRepo extends JpaRepository<Delivery , String> {
}
