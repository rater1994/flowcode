package com.performance.code.flowcode;

import com.performance.code.flowcode.Entity.Category;
import com.performance.code.flowcode.Entity.Dtos.CategoryDto;
import com.performance.code.flowcode.Entity.Dtos.ProductDto;
import com.performance.code.flowcode.Entity.Product;
import com.performance.code.flowcode.Repository.CategoryRepository;
import com.performance.code.flowcode.Repository.ProductRepository;
import com.performance.code.flowcode.controllers.CategoryController;
import com.performance.code.flowcode.controllers.Declarative.DeclarativeCategoryImpl;
import com.performance.code.flowcode.util.RandoNumberG;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import uk.co.jemos.podam.common.PodamShortValue;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @RepeatedTest(100)
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

    @RepeatedTest(1)
    void changeFirstLetterImeperative() {
        List<Category> categories = new ArrayList<>();
        categories = categoryRepository.findAll();

//        Iterator<Category> iterator = categories.iterator();
//        while (iterator.hasNext()) {
//            Category category = iterator.next();
//            System.out.println(category.getName());
//        }

        for (int i = 0; i < categories.size(); i++) {
            Category c = new Category();

        }


    }

    @RepeatedTest(1)
    void changeFirstLetterDeclarative() {
        List<Category> categories = categoryRepository.findAll();
        List<String> strings =  new ArrayList<>();
        for (Category category: categories) {
            strings.add(category.getName());
        }

        List<String> firstChar = DeclarativeCategoryImpl.test(strings);
        System.out.println(firstChar);

    }


    @Test(timeOut = 1000, invocationCount = 100, successPercentage = 98)
    public void testInvocationCount() throws Exception {
        Thread.sleep(100);
        System.out.println("waitForAnswer");
    }
}
