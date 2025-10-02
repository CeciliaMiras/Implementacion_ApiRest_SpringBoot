package com.ImplementacionApiRest.controllers;

import com.ImplementacionApiRest.domian.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("clientes")
    public List<Customer>getCustomers(){
        return customers;
    }
    @GetMapping("clientes/{username}")
    public Customer getCliente(@PathVariable String username){
        for(Customer c:customers){
            if(c.getUsername().equalsIgnoreCase(username)){
                return c;
            }

        }
        return null;

    }
}
