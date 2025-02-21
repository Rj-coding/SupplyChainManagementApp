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
import jsp.supplychainmanagementsystem.entity.Supplier;
import jsp.supplychainmanagementsystem.service.SupplierService;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
	@Autowired
	private SupplierService supplierService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Supplier>>saveSupplier(@RequestBody Supplier supplier){
				
		return supplierService.saveSupplier(supplier);
	}
	
	@GetMapping("/all")
	public ResponseEntity<ResponseStructure<List<Supplier>>>getAllSupplier(){
		return supplierService.getAllSupplier();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Supplier>>getSupplierById(@PathVariable int id){
		return supplierService.getById(id);
	}
	
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Supplier>>updateById(@RequestBody Supplier supplier){
		return supplierService.updateById(supplier);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Supplier>>deleteById(@PathVariable int id){
		return supplierService.deleteById(id);
	}

}
