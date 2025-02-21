package jsp.supplychainmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import jsp.supplychainmanagementsystem.dao.CustomerDao;
import jsp.supplychainmanagementsystem.dto.ResponseStructure;
import jsp.supplychainmanagementsystem.entity.Customer;
import jsp.supplychainmanagementsystem.exception.NoRecordFoundException;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDao customerDao;

	//add customer
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody Customer customer) {
	    Customer receivedCustomer = customerDao.addCustomer(customer);
	    
	    ResponseStructure<Customer> structure = new ResponseStructure<Customer>();
	    structure.setStatusCode(HttpStatus.CREATED.value());
	    structure.setMessage("Customer added Successfully");
	    structure.setData(receivedCustomer);
	    return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.CREATED);
	}

	//Get customer by id
	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(@PathVariable int id) {
	    Optional<Customer> opt = customerDao.getCustomerById(id);
	    if (opt.isPresent()) {
	        ResponseStructure<Customer> structure = new ResponseStructure<Customer>();
	        structure.setStatusCode(HttpStatus.ACCEPTED.value());
	        structure.setMessage("This is customer data with respect to the ID");
	        structure.setData(opt.get());
	        return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.ACCEPTED);
	    } else {
	        throw new NoRecordFoundException();
	    }
	}

	//Get All Customers
	public ResponseEntity<ResponseStructure<List<Customer>>> getAllCustomers() {
	    List<Customer> getCustomers = customerDao.getAllCustomers();
	    
	    ResponseStructure<List<Customer>> structure = new ResponseStructure<List<Customer>>();
	    structure.setStatusCode(HttpStatus.OK.value());
	    structure.setMessage("All Customers fetched Successfully");
	    structure.setData(getCustomers);
	    return new ResponseEntity<ResponseStructure<List<Customer>>>(structure, HttpStatus.OK);
	}



	//update customer
	public ResponseEntity<ResponseStructure<Customer>> updateCustomerById(Customer customer) {
	    customerDao.updateCustomer(customer);
	    ResponseStructure<Customer> structure = new ResponseStructure<Customer>();
	    structure.setStatusCode(HttpStatus.OK.value());
	    structure.setMessage("Customer data updated successfully");
	    structure.setData(customer);
	    
	    return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.OK);
	}

	//delete customer by id
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomerById(@PathVariable int id) {
	    Optional<Customer> opt = customerDao.deleteCustomerById(id);
	    ResponseStructure<Customer> structure = new ResponseStructure<Customer>();
	    
	    if (opt.isPresent()) {
	        structure.setStatusCode(HttpStatus.OK.value());
	        structure.setMessage("Customer record deleted successfully");
	        structure.setData(opt.get());
	        
	        return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.OK);
	    } else {
	        throw new NoRecordFoundException();
	    }
	}


}
