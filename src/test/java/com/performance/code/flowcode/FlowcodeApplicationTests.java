package com.performance.code.flowcode;

import com.performance.code.flowcode.Entity.Category;
import com.performance.code.flowcode.Entity.Dtos.CategoryDto;
import com.performance.code.flowcode.Entity.Product;
import com.performance.code.flowcode.Repository.CategoryRepository;
import com.performance.code.flowcode.Repository.ProductRepository;
import com.performance.code.flowcode.controllers.CategoryController;
import com.performance.code.flowcode.controllers.Declarative.DeclarativeCategoryImpl;
import com.performance.code.flowcode.controllers.Imperative.ImperativeCategoryImpl;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
//----------------------------------------------------------------------------------------------------------------------
    @RepeatedTest(10000)
    void testAddNewCategory() {
        Category category = new Category();
        category = podamFactory.manufacturePojo(Category.class);
        categoryRepository.save(category);
    }

    @RepeatedTest(100)
    void testAddProductAndCategory() {
        Product product = new Product();
        product = podamFactory.manufacturePojo(Product.class);
        productRepository.save(product);
    }
//----------------------------------------------------------------------------------------------------------------------

    //-------------------------------Change first letter to upper-------------------------------------------------------
    @RepeatedTest(1)
    void changeFirstLetterImeperative() {
        List<Category> categories = categoryRepository.findAll();
        List<String> emptyList = new ArrayList<>();
        ImperativeCategoryImpl imperativeCategory = new ImperativeCategoryImpl();
        for (Category c : categories) {
            emptyList.add(String.valueOf(c.getName()));
        }
        emptyList = imperativeCategory.changeFirstLetterFromListImp(emptyList);
        System.out.println(emptyList);
    }

    @RepeatedTest(1)
    void changeFirstLetterDeclarative() {
        List<Category> categories = categoryRepository.findAll();
        List<String> strings = new ArrayList<>();
        for (Category category : categories) {
            strings.add(category.getName());
        }

        List<String> firstChar = DeclarativeCategoryImpl.changeFirstLetterUpper(strings);
        System.out.println(firstChar);
    }
    //------------------------------------------------------------------------------------------------------------------


    @Test(threadPoolSize = 4)
    public void testInvocationCount() throws Exception {
        Thread.sleep(100);
        System.out.println("waitForAnswer");
    }
}
