package tn.esprit.spring_advanced_concepts.controllers;


import org.springframework.web.bind.annotation.*;
import tn.esprit.spring_advanced_concepts.dto.CustomerRequestDTO;
import tn.esprit.spring_advanced_concepts.dto.CustomerResponseDTO;
import tn.esprit.spring_advanced_concepts.services.CustomerService;
import tn.esprit.spring_advanced_concepts.services.CustomerServiceImpl;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class CustomerController {
    private  final CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/customers")
    public List<CustomerResponseDTO> allCustomers(){
        return  customerService.listCustomers();
    }


    @PostMapping(path = "/addCustomer")
    public CustomerResponseDTO save(@RequestBody CustomerRequestDTO customerRequestDTO){
       return customerService.save(customerRequestDTO);
    }
    @GetMapping(path = "/findCustomer/{id}")
    public CustomerResponseDTO findCustomer(@PathVariable String id){
        return customerService.getCustomer(id) ;

    }






}
