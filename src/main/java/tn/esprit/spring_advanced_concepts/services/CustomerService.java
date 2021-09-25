package tn.esprit.spring_advanced_concepts.services;

import tn.esprit.spring_advanced_concepts.dto.CustomerRequestDTO;
import tn.esprit.spring_advanced_concepts.dto.CustomerResponseDTO;
import tn.esprit.spring_advanced_concepts.entities.Customer;

import java.util.List;

public interface CustomerService {
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) ;
    public CustomerResponseDTO getCustomer(String id ) ;
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) ;
    public List<CustomerResponseDTO> listCustomers();



}
