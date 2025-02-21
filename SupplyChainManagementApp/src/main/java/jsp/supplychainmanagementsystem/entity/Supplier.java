package jsp.supplychainmanagementsystem.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Supplier {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String name;
   private long contact;
   private String email;
   private String CompanyName;
   
   @OneToMany(mappedBy="supplier", cascade=CascadeType.ALL)
//   @JsonIgnore
   @JsonManagedReference("supplier-products")
   private List<Product> products;
   
  /* 
   {
	    "name":"Rsonsal warehouse",
	    "contact":76789549,
	    "email":"per678@gmail.com",
	    "CompanyName":"LUI",
	    "products":["shirt","paint","Jeans"]

	}
*/
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

public long getContact() {
	return contact;
}

public void setContact(long contact) {
	this.contact = contact;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getCompanyName() {
	return CompanyName;
}

public void setCompanyName(String companyName) {
	CompanyName = companyName;
}

public List<Product> getProducts() {
	return products;
}

public void setProducts(List<Product> products) {
	this.products = products;
}
   
   
   
   
}
