package com.ykeas.ykeasmsprincipal.service;

import com.ykeas.ykeasmsprincipal.model.entity.Order;
import com.ykeas.ykeasmsprincipal.model.request.OrderRequest;

import java.util.List;

public interface IOrderService {
    public List<Order> index();
    public List<Order> indexByClientName(String clientName);
    public Order save(OrderRequest request);
    public Order update(Long orderIr, OrderRequest orderRequest);
}
