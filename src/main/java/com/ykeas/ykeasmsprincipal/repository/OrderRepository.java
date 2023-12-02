package com.ykeas.ykeasmsprincipal.repository;

import com.ykeas.ykeasmsprincipal.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    public List<Order> findByClientNameContains(String clientName);
}
