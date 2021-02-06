package com.performance.code.flowcode.Repository;

import com.performance.code.flowcode.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {
   Users findByLastName(String lastName);
}
