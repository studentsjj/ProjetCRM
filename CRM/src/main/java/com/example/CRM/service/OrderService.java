package com.example.CRM.service;

import com.example.CRM.dao.OrderRepository;
import com.example.CRM.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public void add (Order order){
        orderRepository.save(order);
    }
    public List<Order> findAll(){
       return orderRepository.findAll();
    }

    public Optional<Order> findById(Integer id){
        return orderRepository.findById(id);
    }

    public void update (Order order){
        orderRepository.save(order);
    }

    public void delete (Integer id){
        orderRepository.deleteById(id);
    }

}
