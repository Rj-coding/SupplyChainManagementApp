package jsp.supplychainmanagementsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jsp.supplychainmanagementsystem.entity.Supplier;
import jsp.supplychainmanagementsystem.exception.IdNotFoundException;
import jsp.supplychainmanagementsystem.repository.SupplierRepository;

@Repository
public class SupplierDao {

	@Autowired
	private SupplierRepository supplierRepository;
	
	//save supplier
	public Supplier saveSupplier(Supplier supplier) {
		supplierRepository.save(supplier);
		return supplier;
	}
	
	//getAll
	public List<Supplier>getAllSupplier(){
		List<Supplier> list=supplierRepository.findAll();
		return list;
	}
	
	//Get By Id
	public Optional<Supplier>getById(int id){
		Optional<Supplier>opt=supplierRepository.findById(id);
		return opt;
	}
	
	//updateById
	public Supplier updateById(Supplier supplier) {
		supplierRepository.save(supplier);
		return supplier;
	}
	
	//DeleteById
	public Optional<Supplier> deleteById(int id){
		Optional<Supplier>opt=supplierRepository.findById(id);
		
		if(opt.isPresent()) {
			supplierRepository.delete(opt.get());;
			return opt;
		}
		else {
		throw new IdNotFoundException();
		}
		
	}
				
	
	
}
