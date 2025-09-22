package Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tns.cg.smms.entities.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {

}
