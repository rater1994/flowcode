package com.performance.code.flowcode.Repository;

import com.performance.code.flowcode.Entity.MockData;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MockDataRepository extends JpaRepository<MockData, Long> {
}
