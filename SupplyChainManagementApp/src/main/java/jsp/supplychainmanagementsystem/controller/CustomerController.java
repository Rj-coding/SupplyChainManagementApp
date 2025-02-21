package jsp.supplychainmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jsp.supplychainmanagementsystem.dto.ResponseStructure;
import jsp.supplychainmanagementsystem.entity.Customer;
import jsp.supplychainmanagementsystem.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	
	@Autowired
	private CustomerService customerService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Customer>> addCustomer(@RequestBody Customer customer) {
	    return customerService.saveCustomer(customer);
	}

	@GetMapping("/all")
	public ResponseEntity<ResponseStructure<List<Customer>>> getAllCustomers() {
	    return customerService.getAllCustomers();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(@PathVariable int id) {
	    return customerService.getCustomerById(id);
	}

	

	@PutMapping
	public ResponseEntity<ResponseStructure<Customer>> updateCustomerById(@RequestBody Customer customer) {
	    return customerService.updateCustomerById(customer);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomerById(@PathVariable int id) {
	    return customerService.deleteCustomerById(id);
	}

}
