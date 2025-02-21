package jsp.supplychainmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp.supplychainmanagementsystem.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
