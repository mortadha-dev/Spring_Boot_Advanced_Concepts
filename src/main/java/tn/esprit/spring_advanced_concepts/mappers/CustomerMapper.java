package tn.esprit.spring_advanced_concepts.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import tn.esprit.spring_advanced_concepts.dto.CustomerRequestDTO;
import tn.esprit.spring_advanced_concepts.dto.CustomerResponseDTO;
import tn.esprit.spring_advanced_concepts.entities.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer customerRequestDTOCustomer(CustomerRequestDTO customerRequestDTO) ;
    CustomerResponseDTO customerToCustomerResponseDTO(Customer customer) ;

}
