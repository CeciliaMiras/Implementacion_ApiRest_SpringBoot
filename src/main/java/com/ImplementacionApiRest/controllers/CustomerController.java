package com.ImplementacionApiRest.controllers;

import com.ImplementacionApiRest.domian.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@RestController
public class CustomerController {
    private List<Customer> customers=new ArrayList<>(Arrays.asList(
            new Customer(123, "Gerardo Lopez", "gerardol", "cont"),
            new Customer(456, "Alejandra Garcia", "alegarcia", "1234"),
            new Customer(789, "Laura Sandoval", "lauras", "secret"),
            new Customer(234, "Carlos Martinez", "carlosm", "pass")
    ));
    //Muestra la lista completa de los clientes
    @GetMapping("/clientes")
    public List<Customer>getCustomers(){
        return customers;
    }
    //Muestra un cliente específico a traves de su username
    @GetMapping("/clientes/{username}")
    public Customer getCliente(@PathVariable String username){
        for(Customer c:customers){
            if(c.getUsername().equalsIgnoreCase(username)){
                return c;
            }

        }
        return null;

    }
    //Agregar un cliente a una lista o una base de datos
    @PostMapping("/clientes")
    public Customer postCliente(@RequestBody  Customer customer){
        customers.add(customer);
        return customer;
    }
    //Modificar un cliente
    @PutMapping("/clientes/{username}")
    public Customer putCliente(@PathVariable String username,@RequestBody Customer customer){
        for(Customer c: customers){
          if(c.getId()==customer.getId()){
              c.setName(customer.getName());
              c.setUsername(customer.getUsername());
              c.setPassword(c.getPassword());
              return c;
          }
        }
        return null;
    }
}
