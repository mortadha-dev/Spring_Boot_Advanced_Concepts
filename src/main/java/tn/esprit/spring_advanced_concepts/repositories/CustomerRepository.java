package tn.esprit.spring_advanced_concepts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring_advanced_concepts.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
}
