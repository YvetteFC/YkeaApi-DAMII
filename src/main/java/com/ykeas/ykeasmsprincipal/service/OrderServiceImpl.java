package com.ykeas.ykeasmsprincipal.service;

import com.ykeas.ykeasmsprincipal.model.entity.Order;
import com.ykeas.ykeasmsprincipal.model.entity.Plate;
import com.ykeas.ykeasmsprincipal.model.entity.User;
import com.ykeas.ykeasmsprincipal.model.request.OrderRequest;
import com.ykeas.ykeasmsprincipal.repository.OrderRepository;
import com.ykeas.ykeasmsprincipal.repository.PlateRepository;
import com.ykeas.ykeasmsprincipal.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements IOrderService{

    private OrderRepository orderRepository;
    private UserRepository userRepository;
    private PlateRepository plateRepository;
    @Override
    public List<Order> index() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> indexByClientName(String clientName) {
        return orderRepository.findByClientNameContains(clientName);
    }

    @Override
    @Transactional
    public Order save(OrderRequest request) {
        User user = userRepository.findById(request.getUserId()).orElse(null);
        Plate plate = plateRepository.findById(request.getPlateId()).orElse(null);

        Order order = new Order();
        order.setPlate(plate);
        order.setUser(user);
        order.setClientName(request.getClientName());
        order.setPlatePrice(plate.getPrice());
        order.setQuantity(request.getQuantity());
        order.setAmount(request.getQuantity() * plate.getPrice());

        if(plate.getStock() >= request.getQuantity()) {
            plate.setStock(plate.getStock() - request.getQuantity());
            plateRepository.save(plate);
        } else {
            return null;
        }
        return orderRepository.save(order);
    }

    @Override
    public Order update(Long orderIr, OrderRequest orderRequest) {
        return null;
    }
}
