package jsp.supplychainmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp.supplychainmanagementsystem.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
