package com.performance.code.flowcode;

import com.performance.code.flowcode.Entity.Category;
import com.performance.code.flowcode.Entity.Dtos.CategoryDto;
import com.performance.code.flowcode.Repository.CategoryRepository;
import com.performance.code.flowcode.controllers.CategoryController;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@SpringBootTest
class FlowcodeApplicationTests {

    @Autowired
    CategoryController categoryController;

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
    }


    @RepeatedTest(2)
    void testPodam() {
        PodamFactoryImpl podamFactory = new PodamFactoryImpl();
        CategoryDto category = podamFactory.manufacturePojo(CategoryDto.class);
        categoryController.addCategory(category);
        System.out.println("TEST: " + category.getName());
    }


    // Good info: https://stackoverflow.com/questions/4970907/concurrent-junit-testing

    @Test()
    void doSomethsad() {

    }
}
