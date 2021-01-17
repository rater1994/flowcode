package com.performance.code.flowcode;

import com.performance.code.flowcode.Entity.Category;
import com.performance.code.flowcode.Entity.Dtos.CategoryDto;
import com.performance.code.flowcode.Entity.Product;
import com.performance.code.flowcode.Repository.CategoryRepository;
import com.performance.code.flowcode.Repository.ProductRepository;
import com.performance.code.flowcode.controllers.CategoryController;
import com.performance.code.flowcode.util.RandoNumberG;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import uk.co.jemos.podam.common.PodamShortValue;

@SpringBootTest
class FlowcodeApplicationTests {

    @Autowired
    CategoryController categoryController;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    private PodamFactoryImpl podamFactory = new PodamFactoryImpl();

    @BeforeClass
    public void setUp() {
        // code that will be invoked when this test is instantiated
    }


    @Test
    void contextLoads() {
    }


    @RepeatedTest(2)
    void testPodam() {
        CategoryDto category = podamFactory.manufacturePojo(CategoryDto.class);
        categoryController.addCategory(category);
        System.out.println("TEST: " + category.getName());
    }


    // Good info: https://stackoverflow.com/questions/4970907/concurrent-junit-testing

    @RepeatedTest(10000)
    void testAddNewCategory() {
        Category category = new Category();
        category = podamFactory.manufacturePojo(Category.class);
        categoryRepository.save(category);
    }

    @RepeatedTest(10000)
    void testAddProduct() {
        Product product = new Product();
        Category category = new Category();
        product = podamFactory.manufacturePojo(Product.class);
        productRepository.save(product);
    }

    @RepeatedTest(1)
    void testAddIdForEachProduct() {

    }

    @RepeatedTest(1)
    void changeFirstLetterImeprtive(){

    }

    @RepeatedTest(1)
    void changeFirstLetterDeclarative() {

    }


    @Test(timeOut = 1000, invocationCount = 100, successPercentage = 98)
    public void testInvocationCount() throws Exception {
        Thread.sleep(100);
        System.out.println("waitForAnswer");
    }
}
