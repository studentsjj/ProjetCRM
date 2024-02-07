package com.example.CRM.Controller;


import com.example.CRM.model.Client;
import com.example.CRM.model.Order;
import com.example.CRM.service.ClientService;
import com.example.CRM.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    ClientService clientService;

    @GetMapping("orders")
    public List<Order> findAll() {
        return orderService.findAll();
    }
    @GetMapping("orders/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
        Optional<Order> o = orderService.findById(id);
        if (o.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(o.get());
        }
    }


    @PostMapping("orders")
    public ResponseEntity<?> add(@RequestBody Order order) {
       Integer id = order.getClient().getId();
       Optional<Client> optionalClient = clientService.findById(id);
       if(optionalClient.isEmpty()) return ResponseEntity.badRequest().build();
        orderService.add(order);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("orders/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody Order order) {
        Optional<Order> o = orderService.findById(id);
        if (o.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            if (!id.equals(order.getId())) {
                return ResponseEntity.badRequest().build();
            } else {
                orderService.update(order);
                return ResponseEntity.ok(o.get());
            }
        }
    }

    @DeleteMapping("orders/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        Optional<Order> o = orderService.findById(id);
        if (o.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            orderService.delete(id);
            return ResponseEntity.ok().build();
        }
    }
}



