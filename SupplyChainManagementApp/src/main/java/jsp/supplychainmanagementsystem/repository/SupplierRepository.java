package jsp.supplychainmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp.supplychainmanagementsystem.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

}
