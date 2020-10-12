package com.techdenovo.app.customerportalspringboot.repository;

import com.techdenovo.app.customerportalspringboot.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
