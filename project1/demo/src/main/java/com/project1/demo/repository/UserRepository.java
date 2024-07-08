package com.project1.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project1.demo.model.User;
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM User c WHERE c.mail = :mail and c.password=:password")
    boolean existsByName(@Param("mail") String mail,@Param("password") String password);
}
