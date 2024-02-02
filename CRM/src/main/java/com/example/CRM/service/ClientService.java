package com.example.CRM.service;

import com.example.CRM.dao.ClientRepository;
import com.example.CRM.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public void add (Client client){
    clientRepository.save(client);
    }

    public List<Client> findAll(){
        return clientRepository.findAll();
    }
    public Optional<Client> findById(Integer id){
        return clientRepository.findById(id);
    }
    public void update (Client client){
        clientRepository.save(client);
    }
    public void delete (Integer id){
        clientRepository.deleteById(id);
    }
}
