package tn.esprit.spring_advanced_concepts;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tn.esprit.spring_advanced_concepts.dto.CustomerRequestDTO;
import tn.esprit.spring_advanced_concepts.services.CustomerService;
import tn.esprit.spring_advanced_concepts.services.CustomerServiceImpl;

@SpringBootApplication

public class SpringAdvancedConceptsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAdvancedConceptsApplication.class, args);
    }




    @Bean
    CommandLineRunner start(CustomerServiceImpl customerService){
        return  args -> {
            customerService.save(new CustomerRequestDTO("T01a", "Mortadhaa", "mortadha@esprit.tn"));
            customerService.save(new CustomerRequestDTO("T02e", "Oussemaf", "Oussema@esprit.tn"));

        };


    }

}
