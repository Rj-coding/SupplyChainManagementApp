package jsp.supplychainmanagementsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jsp.supplychainmanagementsystem.entity.Product;
import jsp.supplychainmanagementsystem.entity.Supplier;
import jsp.supplychainmanagementsystem.exception.IdNotFoundException;
import jsp.supplychainmanagementsystem.repository.ProductRepository;
import jsp.supplychainmanagementsystem.repository.SupplierRepository;

@Repository
public class ProductDao {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	private SupplierRepository supplierRepository;
	
	//Add Product
	public Product addProduct(Product product) {
		productRepository.save(product);

		return product;
	}
	
	//Get product By Id
	public Optional<Product> getProductById(int id) {
		Optional<Product>opt= productRepository.findById(id);
		return opt;
	} 
	
	
	//Get All Product
	public List<Product>getAllproduct(){
		List<Product>products=productRepository.findAll();
		return products;
	}
	
	
	//Get Product by Supplier 
    public List<Product>getProductBySupplierId(int id){
    	Optional<Supplier>opt=supplierRepository.findById(id);
    	Supplier supplier=opt.get();
    	return supplier.getProducts();
    }
	
	
	//update product
    public Product updateProduct(Product product) {
    	productRepository.save(product);
    	return product;
    }
	
	
	//delete product
    public Optional<Product>deleteProductById(int id){
    Optional<Product>opt=productRepository.findById(id);
		
		if(opt.isPresent()) {
			productRepository.delete(opt.get());;
			return opt;
		}
		else {
		throw new IdNotFoundException();
		}
    }

}
