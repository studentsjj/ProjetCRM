package com.example.CRM.Controller;

import com.example.CRM.model.Client;
import com.example.CRM.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("clients")
    public List<Client> findAll() {
        return clientService.findAll();
    }
    @GetMapping("clients/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
        Optional<Client> c = clientService.findById(id);
        if (c.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(c.get());
        }
    }

    @PostMapping("clients")
    public ResponseEntity<?> add(@RequestBody Client client) {
        clientService.add(client);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("clients/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody Client client) {
        Optional<Client> c = clientService.findById(id);
        if (c.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            if (!id.equals(client.getId())) {
                return ResponseEntity.badRequest().build();
            } else {
                clientService.update(client);
                return ResponseEntity.ok(c.get());
            }
        }
    }

    @DeleteMapping("clients/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        Optional<Client> c = clientService.findById(id);
        if (c.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            clientService.delete(id);
            return ResponseEntity.ok().build();
        }
    }
}


