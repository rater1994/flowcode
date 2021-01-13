package com.performance.code.flowcode.Repository;

import com.performance.code.flowcode.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
