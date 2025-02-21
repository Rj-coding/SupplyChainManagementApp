package jsp.supplychainmanagementsystem.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Orders {
	
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private int id;
	   private LocalDate orderDate;
	   private double amount;
	   private String trackingNumber;
	   
	   @ManyToOne	  
	   @JoinColumn(name="customer_id")
	   @JsonBackReference("customer-orders")
	   private Customer customer;
	   
	   
	    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	    @JsonManagedReference("order-products")  // Parent Side
	    private List<Product> listproducts;
	   
	   public int getId() {
		return id;
	}

	public List<Product> getListproducts() {
		return listproducts;
	}

	public void setListproducts(List<Product> listproducts) {
		this.listproducts = listproducts;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	

}

/*
{

"orderDate": "2024-02-19",
"amount": 2401.00,
"trackingNumber": "TRK123456",
"customer": {
    "id": 3,

},
"listproducts": [
    {
        "id": 2,

        }
    
    {
        "id": 3,
        
    }
]
}
*/