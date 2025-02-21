package jsp.supplychainmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import jsp.supplychainmanagementsystem.dao.ProductDao;
import jsp.supplychainmanagementsystem.dao.SupplierDao;
import jsp.supplychainmanagementsystem.dto.ResponseStructure;
import jsp.supplychainmanagementsystem.entity.Orders;
import jsp.supplychainmanagementsystem.entity.Product;
import jsp.supplychainmanagementsystem.entity.Supplier;
import jsp.supplychainmanagementsystem.exception.IdNotFoundException;
import jsp.supplychainmanagementsystem.exception.IdNotFoundException;
import jsp.supplychainmanagementsystem.exception.NoRecordFoundException;
import jsp.supplychainmanagementsystem.repository.OrderRepository;
import jsp.supplychainmanagementsystem.repository.SupplierRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao;
	@Autowired
	private SupplierRepository supplierRepository;
	@Autowired
	private OrderRepository orderRepository;
	
	//add product
	public ResponseEntity<ResponseStructure<Product>>saveProduct(Product product){
		 if (product.getSupplier() != null && product.getSupplier().getId() != 0) {
		        Optional<Supplier> supplierOpt = supplierRepository.findById(product.getSupplier().getId());
		        if (supplierOpt.isPresent()) {
		            product.setSupplier(supplierOpt.get());
		        } else {
		            throw new IdNotFoundException();
		        }
		    }
//		 if (product.getOrder() != null && product.getOrder().getId() != 0) {
//		        Optional<Orders> orderOpt = orderRepository.findById(product.getOrder().getId());
//		        if (orderOpt.isPresent()) {
//		            product.setOrder(orderOpt.get());
//		        } else {
//		            throw new IdNotFoundException();
//		        }
//		    }
		
		
        Product recieveProduct=productDao.addProduct(product);
		
		ResponseStructure<Product>structure=new ResponseStructure<Product>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage(" Product added Successfully");
		structure.setData(recieveProduct);
		return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.CREATED);
	}
	
	//Get Product by id
	public ResponseEntity<ResponseStructure<Product>>getProductById(@PathVariable int id){
		Optional<Product>opt =productDao.getProductById(id);
		if(opt.isPresent()) {
			ResponseStructure<Product>structure=new ResponseStructure<Product>();
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			structure.setMessage("this is Product data with respective to id");
			structure.setData(opt.get());
			return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.ACCEPTED);
		}
		else {
			throw new NoRecordFoundException();
		}
	}
	
	//Get All Product
	public ResponseEntity<ResponseStructure<List<Product>>>getAllProduct(){
		List<Product>getSupplier=productDao.getAllproduct();
		
		ResponseStructure<List<Product>>structure=new ResponseStructure<List<Product>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("All Supplier fetched Successfully");
		structure.setData(getSupplier);
		return new ResponseEntity<ResponseStructure<List<Product>>>(structure,HttpStatus.OK);
		
	}
	
	//Get Product by Supplier id
	public ResponseEntity<ResponseStructure<List<Product>>>getProductBySupplierId(@PathVariable int id){
		List<Product>list =productDao.getProductBySupplierId(id);
		
			ResponseStructure<List<Product>>structure=new ResponseStructure<List<Product>>();
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			structure.setMessage("this is Product data with respective to id");
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Product>>>(structure,HttpStatus.ACCEPTED);
		
	}
	
	//update product
	public ResponseEntity<ResponseStructure<Product>>updateProductById(Product product){
		productDao.updateProduct(product);
		ResponseStructure<Product>structure=new ResponseStructure<Product>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Product Data Updated Successfully");
		structure.setData(product);
		
		return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.OK);
		
	}
	//delete product by id
	public ResponseEntity<ResponseStructure<Product>>deleteProductById(@PathVariable int id){
		Optional<Product>opt=productDao.deleteProductById(id);
		ResponseStructure<Product>structure=new ResponseStructure<Product>();
		
		if(opt.isPresent()) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Product Record deleted successfully");
			structure.setData(opt.get());
			
			return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.OK);
		}
		else {
			throw new NoRecordFoundException();
		}
	}

}
