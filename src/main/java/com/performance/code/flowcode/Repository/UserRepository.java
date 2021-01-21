package com.performance.code.flowcode.Repository;

import com.performance.code.flowcode.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
