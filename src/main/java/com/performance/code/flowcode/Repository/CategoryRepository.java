package com.performance.code.flowcode.Repository;

import com.performance.code.flowcode.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
