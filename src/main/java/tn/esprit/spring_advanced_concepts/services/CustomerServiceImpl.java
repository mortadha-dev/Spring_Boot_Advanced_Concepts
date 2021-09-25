package tn.esprit.spring_advanced_concepts.services;

import org.springframework.stereotype.Service;
import tn.esprit.spring_advanced_concepts.dto.CustomerRequestDTO;
import tn.esprit.spring_advanced_concepts.dto.CustomerResponseDTO;
import tn.esprit.spring_advanced_concepts.entities.Customer;
import tn.esprit.spring_advanced_concepts.mappers.CustomerMapper;
import tn.esprit.spring_advanced_concepts.repositories.CustomerRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final  CustomerMapper customerMapper ;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
        /*
        Mapping Objet_Objet manuellement sans mapstruct
        Customer customer = new Customer();
        customer.setId(customerRequestDTO.getId());
        customer.setName((customerRequestDTO.getName()));
        customer.setEmail((customerRequestDTO.getEmail()));
        Customer saveCustomer = customerRepository.save(customer);
        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
        customerResponseDTO.setId(saveCustomer.getId());
        customerResponseDTO.setName(saveCustomer.getName());
        customerResponseDTO.setEmail(saveCustomer.getEmail());
         */
        var customer = customerMapper.customerRequestDTOCustomer(customerRequestDTO);
        customer.setId(UUID.randomUUID().toString());
        var saveCustomer = customerRepository.save(customer);
        return customerMapper.customerToCustomerResponseDTO(saveCustomer);
    }

    @Override
    public CustomerResponseDTO getCustomer(String id) {
        Customer customer = customerRepository.findById(id).get();
        return customerMapper.customerToCustomerResponseDTO(customer);
    }

    @Override
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerMapper.customerRequestDTOCustomer(customerRequestDTO);
        Customer updatedCustomer = customerRepository.save(customer);
        return customerMapper.customerToCustomerResponseDTO(updatedCustomer);
    }

    @Override
    public List<CustomerResponseDTO> listCustomers() {

        List<Customer> customers = customerRepository.findAll();
        return  customers.stream()
                .map(customerMapper::customerToCustomerResponseDTO)
                .collect(Collectors.toList());

    }
}
