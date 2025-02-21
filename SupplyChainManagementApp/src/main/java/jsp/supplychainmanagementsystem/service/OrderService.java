package jsp.supplychainmanagementsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import jsp.supplychainmanagementsystem.dao.OrderDao;
import jsp.supplychainmanagementsystem.dto.ResponseStructure;
import jsp.supplychainmanagementsystem.entity.Customer;
import jsp.supplychainmanagementsystem.entity.Orders;
import jsp.supplychainmanagementsystem.entity.Product;
import jsp.supplychainmanagementsystem.exception.IdNotFoundException;
import jsp.supplychainmanagementsystem.exception.NoRecordFoundException;
import jsp.supplychainmanagementsystem.repository.CustomerRepository;
import jsp.supplychainmanagementsystem.repository.ProductRepository;

@Service
public class OrderService {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProductRepository productRepository;

	// add order
	public ResponseEntity<ResponseStructure<Orders>> saveOrder(@RequestBody Orders order) {
		// checking for customer present
		if (order.getCustomer() != null && order.getCustomer().getId() != 0) {
			Optional<Customer> optcustomer = customerRepository.findById(order.getCustomer().getId());
			if (optcustomer.isPresent()) {
				order.setCustomer(optcustomer.get());
			} else {
				throw new IdNotFoundException();
			}
		}
		// checking and adding orders
		if (order.getListproducts() != null && order.getListproducts().size() > 0) {
			List<Product> listProductId = order.getListproducts();
			List<Product> listProduct = new ArrayList<Product>();
			for (Product product : listProductId) {
				Optional<Product> opt = productRepository.findById(product.getId());
				if (opt.isPresent()) {
					listProduct.add(opt.get());
				}
			}
			order.setListproducts(listProduct);
		} else {
			throw new IdNotFoundException();
		}

		Orders receivedOrder = orderDao.addOrder(order);

		ResponseStructure<Orders> structure = new ResponseStructure<Orders>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Order added Successfully");
		structure.setData(receivedOrder);
		return new ResponseEntity<ResponseStructure<Orders>>(structure, HttpStatus.CREATED);
	}

	// Get order by id
	public ResponseEntity<ResponseStructure<Orders>> getOrderById(@PathVariable int id) {
		Optional<Orders> opt = orderDao.getOrderById(id);
		if (opt.isPresent()) {
			ResponseStructure<Orders> structure = new ResponseStructure<Orders>();
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			structure.setMessage("This is order data with respect to the ID");
			structure.setData(opt.get());
			return new ResponseEntity<ResponseStructure<Orders>>(structure, HttpStatus.ACCEPTED);
		} else {
			throw new NoRecordFoundException();
		}
	}

	// Get All Orders
	public ResponseEntity<ResponseStructure<List<Orders>>> getAllOrders() {
		List<Orders> getOrders = orderDao.getAllOrders();

		ResponseStructure<List<Orders>> structure = new ResponseStructure<List<Orders>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("All Orders fetched Successfully");
		structure.setData(getOrders);
		return new ResponseEntity<ResponseStructure<List<Orders>>>(structure, HttpStatus.OK);
	}

	// get order by customer id
	public ResponseEntity<ResponseStructure<List<Orders>>> getOrderCustomerById(@PathVariable int id) {
		List<Orders> list = orderDao.getOrderByCustomerId(id);

		ResponseStructure<List<Orders>> structure = new ResponseStructure<List<Orders>>();
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		structure.setMessage("This is order data with respect to the customer ID");
		structure.setData(list);
		return new ResponseEntity<ResponseStructure<List<Orders>>>(structure, HttpStatus.ACCEPTED);

	}

	// get order by tracking no
	public ResponseEntity<ResponseStructure<Orders>> getOrderByTrackingNumber(String trackingNumber) {
		Orders order = orderDao.getOrderByTrackingNumber(trackingNumber);
		ResponseStructure<Orders> structure = new ResponseStructure<>();

		if (order != null) {
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setMessage("Order found for tracking number: " + trackingNumber);
			structure.setData(order);
			return new ResponseEntity<ResponseStructure<Orders>>(structure, HttpStatus.FOUND);
		} else {
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setMessage("Order not found for tracking number: " + trackingNumber);
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<Orders>>(structure, HttpStatus.NOT_FOUND);
		}
	}

	// update order
	public ResponseEntity<ResponseStructure<Orders>> updateOrderById(Orders order) {
		if (order.getCustomer() != null && order.getCustomer().getId() != 0) {
			Optional<Customer> optcustomer = customerRepository.findById(order.getCustomer().getId());
			if (optcustomer.isPresent()) {
				order.setCustomer(optcustomer.get());
			} else {
				throw new IdNotFoundException();
			}
		}
		// checking and updating orders
		if (order.getListproducts() != null && order.getListproducts().size() > 0) {
			List<Product> listProductId = order.getListproducts();
			List<Product> listProduct = new ArrayList<Product>();
			for (Product product : listProductId) {
				Optional<Product> opt = productRepository.findById(product.getId());
				if (opt.isPresent()) {
					listProduct.add(opt.get());
				}
			}
			order.setListproducts(listProduct);
		} else {
			throw new IdNotFoundException();
		}

		Orders updateOrder =orderDao.updateOrder(order);
		ResponseStructure<Orders> structure = new ResponseStructure<Orders>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Order data updated successfully");
		structure.setData(updateOrder);

		return new ResponseEntity<ResponseStructure<Orders>>(structure, HttpStatus.OK);
	}

	// delete order by id
	public ResponseEntity<ResponseStructure<Orders>> deleteOrderById(@PathVariable int id) {
		Optional<Orders> opt = orderDao.deleteOrderById(id);
		ResponseStructure<Orders> structure = new ResponseStructure<Orders>();

		if (opt.isPresent()) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Order record deleted successfully");
			structure.setData(opt.get());

			return new ResponseEntity<ResponseStructure<Orders>>(structure, HttpStatus.OK);
		} else {
			throw new NoRecordFoundException();
		}
	}
}
