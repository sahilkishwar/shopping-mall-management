package Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tns.cg.smms.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
