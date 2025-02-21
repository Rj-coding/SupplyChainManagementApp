package jsp.supplychainmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {

	
	@Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private int id;
	   private String name;
	   private double price;
	   private int stockQuantity;
	   
	   
	   @ManyToOne
//	   @JsonIgnore 
	   @JsonBackReference ("supplier-products") 
	   @JoinColumn(name="supplier_id", nullable = false)
	   private Supplier supplier;
	   
	   
	   @ManyToOne
	   @JsonBackReference("order-products")
	   @JoinColumn(name="order_id")
	   private Orders order;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getStockQuantity() {
		return stockQuantity;
	}


	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}


	public Supplier getSupplier() {
		return supplier;
	}


	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}


	public Orders getOrder() {
		return order;
	}


	public void setOrder(Orders order) {
		this.order = order;
	}
}

/*{
{
   "id":18,
    "name": "T-Shirt",
    "price": 1200.50,
    "stockQuantity": 150,
    "supplier": {
        "id": 1
      
    },
    "order": {
        "id": 3
        
    }
}


*/
