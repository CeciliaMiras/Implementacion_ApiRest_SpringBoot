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
    //Forma de hacerlo a nivel método
    //@RequestMapping(method = RequestMethod.GET)
    public List<Customer>getCustomers()
    {

        return customers;
    }


    //Muestra un cliente específico a traves de su username
    @GetMapping("/clientes/{username}")
    //Forma de hacerlo a nivel método
    //@RequestMapping(value = "/{username}",method = RequestMethod.GET)
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
    //Forma de hacerlo a nivel método
   // @RequestMapping(method = RequestMethod.POST)
    public Customer postCliente(@RequestBody  Customer customer){
        customers.add(customer);
        return customer;
    }
    //Modificar un cliente
    @PutMapping("/clientes/{username}")
    //Forma de hacerlo a nivel método
    //@RequestMapping(value = "/{username}",method = RequestMethod.PUT)
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
    //Eliminar un cliente
    @DeleteMapping("/clientes/{id}")
    //Forma de hacerlo a nivel método
    //@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Customer deleteCliente(@PathVariable int id){
        for(Customer c : customers){
            if(c.getId()==id){
                customers.remove(c);
                return c;
            }
        }
        return null;
    }

    //Modificaciones específicas
    @PatchMapping("/clientes")
    //Forma de hacerlo a nivel método
    //@RequestMapping(method = RequestMethod.PATCH)
    public Customer patchCliente(@RequestBody Customer customer){
        for(Customer c : customers){
            if(c.getId()==customer.getId()){
                if(customer.getName()!=null){
                    c.setName(customer.getName());
                }
                if(customer.getUsername()!=null){
                    c.setUsername(customer.getUsername());
                }
                if(customer.getPassword()!=null){
                    c.setPassword(customer.getPassword());
                }
                return c;
            }


        }
      return null;
    }

}
