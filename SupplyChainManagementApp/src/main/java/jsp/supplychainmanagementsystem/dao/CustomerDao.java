package jsp.supplychainmanagementsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jsp.supplychainmanagementsystem.entity.Customer;
import jsp.supplychainmanagementsystem.exception.IdNotFoundException;
import jsp.supplychainmanagementsystem.repository.CustomerRepository;

@Repository
public class CustomerDao {

	@Autowired
	private CustomerRepository customerRepository;
	
	
	//Add Customer
	public Customer addCustomer(Customer customer) {
	    customerRepository.save(customer);
	    return customer;
	}

	//Get customer By Id
	public Optional<Customer> getCustomerById(int id) {
	    Optional<Customer> opt = customerRepository.findById(id);
	    return opt;
	} 

	//Get All Customers
	public List<Customer> getAllCustomers() {
	    List<Customer> customers = customerRepository.findAll();
	    return customers;
	}



	//update customer
	public Customer updateCustomer(Customer customer) {
	    customerRepository.save(customer);
	    return customer;
	}

	//delete customer
	public Optional<Customer> deleteCustomerById(int id) {
	    Optional<Customer> opt = customerRepository.findById(id);
	    
	    if (opt.isPresent()) {
	        customerRepository.delete(opt.get());
	        return opt;
	    } else {
	        throw new IdNotFoundException();
	    }
	}

	
	
}
