package jsp.supplychainmanagementsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jsp.supplychainmanagementsystem.entity.Customer;
import jsp.supplychainmanagementsystem.entity.Orders;
import jsp.supplychainmanagementsystem.exception.IdNotFoundException;
import jsp.supplychainmanagementsystem.exception.IdNotFoundException;
import jsp.supplychainmanagementsystem.repository.CustomerRepository;
import jsp.supplychainmanagementsystem.repository.OrderRepository;

@Repository
public class OrderDao {

	
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CustomerRepository customerRepository;
	
	
	//Add Customer
	public Orders addOrder(Orders order) {
	    orderRepository.save(order);
	    return order;
	}

	//Get customer By Id
	public Optional<Orders> getOrderById(int id) {
	    Optional<Orders> opt = orderRepository.findById(id);
	    return opt;
	} 
	
	//Get All Orders
	public List<Orders> getAllOrders() {
	    List<Orders> orders = orderRepository.findAll();
	    return orders;
	}
	
	//get order by customer id
	public List<Orders> getOrderByCustomerId(int id) {
		Optional<Customer>opt=customerRepository.findById(id);
		Customer customer=opt.get();		
		
		return customer.getOrders();		
	}
	
	//get order by tracking number
	public Orders getOrderByTrackingNumber(String trackingNumber) {
	    return orderRepository.findByTrackingNumber(trackingNumber).orElse(null);
	}


	//update order
	public Orders updateOrder(Orders order) {
	    orderRepository.save(order);
	    return order;
	}

	//delete order
	public Optional<Orders> deleteOrderById(int id) {
	    Optional<Orders> opt = orderRepository.findById(id);
	    
	    if (opt.isPresent()) {
	    	Orders order=opt.get();
	        orderRepository.delete(opt.get());
	        return opt;
	    } else {
	        throw new IdNotFoundException();
	    }
	}

}
