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
import jsp.supplychainmanagementsystem.entity.Orders;
import jsp.supplychainmanagementsystem.service.CustomerService;
import jsp.supplychainmanagementsystem.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Orders>> addOrder(@RequestBody Orders order) {
	    return orderService.saveOrder(order);
	}

	@GetMapping("/all")
	public ResponseEntity<ResponseStructure<List<Orders>>> getAllOrders() {
	    return orderService.getAllOrders();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Orders>> getOrderById(@PathVariable int id) {
	    return orderService.getOrderById(id);
	}
	@GetMapping("/customer/{id}")
	public ResponseEntity<ResponseStructure<List<Orders>>> getOrderByCustomerId(@PathVariable int id) {
	    return orderService.getOrderCustomerById(id);
	}
	
	//get order by tracking no
     @GetMapping("tracking/{trackingNumber}")
     public ResponseEntity<ResponseStructure<Orders>> getOrderByTrackingNumber(@PathVariable String trackingNumber) {
        return  orderService.getOrderByTrackingNumber(trackingNumber);
         
 
     }


	@PutMapping
	public ResponseEntity<ResponseStructure<Orders>> updateOrderById(@RequestBody Orders order) {
	    return orderService.updateOrderById(order);
	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Orders>> deleteOrderById(@PathVariable int id) {
	    return orderService.deleteOrderById(id);
	}

}
