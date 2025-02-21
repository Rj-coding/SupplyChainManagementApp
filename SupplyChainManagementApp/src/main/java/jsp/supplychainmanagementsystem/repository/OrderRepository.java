package jsp.supplychainmanagementsystem.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp.supplychainmanagementsystem.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
	Optional<Orders> findByTrackingNumber(String trackingNumber);

}
