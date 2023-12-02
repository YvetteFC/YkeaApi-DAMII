package com.ykeas.ykeasmsprincipal.controller;

import com.ykeas.ykeasmsprincipal.model.entity.Order;
import com.ykeas.ykeasmsprincipal.model.request.OrderRequest;
import com.ykeas.ykeasmsprincipal.service.IOrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/pedido")
public class OrderController {

    private IOrderService orderService;

    @GetMapping("/listado")
    public List<Order> index() {
        return orderService.index();
    }

    @GetMapping("/listado/{clientName}")
    public List<Order> indexByClientName(@PathVariable String clientName) {
        return orderService.indexByClientName(clientName);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Order> save(@Validated @RequestBody OrderRequest orderRequest) {
        return new ResponseEntity<>(orderService.save(orderRequest), HttpStatus.CREATED);
    }
}
