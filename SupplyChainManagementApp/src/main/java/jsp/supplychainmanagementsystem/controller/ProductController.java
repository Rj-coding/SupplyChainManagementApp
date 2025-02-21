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
import jsp.supplychainmanagementsystem.entity.Product;
import jsp.supplychainmanagementsystem.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Product>>addProduct(@RequestBody Product product){
				
		return productService.saveProduct(product);
	}
	
	@GetMapping("/all")
	public ResponseEntity<ResponseStructure<List<Product>>>getAllSupplier(){
		return productService.getAllProduct();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Product>>getProductById(@PathVariable int id){
		return productService.getProductById(id);
	}
	
	@GetMapping("/supplier/{id}")
	public ResponseEntity<ResponseStructure<List<Product>>>getProductBySupplierId(@PathVariable int id){
		return productService.getProductBySupplierId(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Product>>updateProductById(@RequestBody Product product){
		return productService.updateProductById(product);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Product>>deleteProductById(@PathVariable int id){
		return productService.deleteProductById(id);
	}
}
