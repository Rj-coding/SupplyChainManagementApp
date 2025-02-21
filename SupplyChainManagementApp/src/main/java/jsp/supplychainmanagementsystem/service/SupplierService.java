package jsp.supplychainmanagementsystem.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import jsp.supplychainmanagementsystem.dao.SupplierDao;
import jsp.supplychainmanagementsystem.dto.ResponseStructure;
import jsp.supplychainmanagementsystem.entity.Supplier;
import jsp.supplychainmanagementsystem.exception.NoRecordFoundException;
import jsp.supplychainmanagementsystem.repository.SupplierRepository;

@Service
public class SupplierService {
	
	@Autowired
	private SupplierDao supplierDao;
	
	public ResponseEntity<ResponseStructure<Supplier>>saveSupplier(Supplier supplier){
		Supplier recieveSupplier=supplierDao.saveSupplier(supplier);
		
		ResponseStructure<Supplier>structure=new ResponseStructure<Supplier>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage(" Supplier save Successfully");
		structure.setData(recieveSupplier);
		return new ResponseEntity<ResponseStructure<Supplier>>(structure,HttpStatus.CREATED);
		
	}
	
	public ResponseEntity<ResponseStructure<List<Supplier>>>getAllSupplier(){
		List<Supplier>getSupplier=supplierDao.getAllSupplier();
		
		ResponseStructure<List<Supplier>>structure=new ResponseStructure<List<Supplier>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("All Supplier fetched Successfully");
		structure.setData(getSupplier);
		return new ResponseEntity<ResponseStructure<List<Supplier>>>(structure,HttpStatus.OK);
		
	}
	
	public ResponseEntity<ResponseStructure<Supplier>>getById(@PathVariable int id){
		Optional<Supplier>opt =supplierDao.getById(id);
		if(opt.isPresent()) {
			ResponseStructure<Supplier>structure=new ResponseStructure<Supplier>();
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			structure.setMessage("this is data with respective to id");
			structure.setData(opt.get());
			return new ResponseEntity<ResponseStructure<Supplier>>(structure,HttpStatus.ACCEPTED);
		}
		else {
			throw new NoRecordFoundException();
		}
	}
	//update by id
	public ResponseEntity<ResponseStructure<Supplier>>updateById(Supplier supplier){
		supplierDao.saveSupplier(supplier);
		ResponseStructure<Supplier>structure=new ResponseStructure<Supplier>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Data Updated Successfully");
		structure.setData(supplier);
		
		return new ResponseEntity<ResponseStructure<Supplier>>(structure,HttpStatus.OK);
		
	}
	
	public ResponseEntity<ResponseStructure<Supplier>>deleteById(@PathVariable int id){
		Optional<Supplier>opt=supplierDao.deleteById(id);
		ResponseStructure<Supplier>structure=new ResponseStructure<Supplier>();
		
		if(opt.isPresent()) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Record deleted successfully");
			structure.setData(opt.get());
			
			return new ResponseEntity<ResponseStructure<Supplier>>(structure,HttpStatus.OK);
		}
		else {
			throw new NoRecordFoundException();
		}
	}

}
