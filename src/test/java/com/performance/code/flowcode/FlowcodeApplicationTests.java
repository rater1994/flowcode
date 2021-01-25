package com.performance.code.flowcode;

import com.performance.code.flowcode.Entity.Category;
import com.performance.code.flowcode.Entity.Product;
import com.performance.code.flowcode.Entity.Users;
import com.performance.code.flowcode.Repository.CategoryRepository;
import com.performance.code.flowcode.Repository.ProductRepository;
import com.performance.code.flowcode.Repository.UsersRepository;
import com.performance.code.flowcode.controllers.CategoryController;
import com.performance.code.flowcode.controllers.Declarative.DeclarativeCategoryImpl;
import com.performance.code.flowcode.controllers.Declarative.DeclarativeProductImpl;
import com.performance.code.flowcode.controllers.Declarative.DeclarativeUsersImpl;
import com.performance.code.flowcode.controllers.Imperative.ImperativeCategoryImpl;
import com.performance.code.flowcode.controllers.Imperative.ImperativeProductImpl;
import com.performance.code.flowcode.controllers.Imperative.ImperativeUsersImpl;
import com.performance.code.flowcode.util.RandoNumberG;
import com.performance.code.flowcode.util.service.ExtractDataDb;
import com.performance.code.flowcode.util.security.EncryptionUtils;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class FlowcodeApplicationTests {

    @Autowired
    ExtractDataDb extractDb;

    @Autowired
    UsersRepository usersRepository;

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

    @RepeatedTest(1)
    void testPodam() {
//        CategoryDto category = podamFactory.manufacturePojo(CategoryDto.class);
//        categoryController.addCategory(category);
//        System.out.println("TEST: " + category.getName());

        Users users = podamFactory.manufacturePojo(Users.class);
        System.out.println(users.toString());
    }

    // Good info: https://stackoverflow.com/questions/4970907/concurrent-junit-testing
//----------------------------------------------------------------------------------------------------------------------
    @RepeatedTest(10000)
    void testAddNewCategory() {
        Category category = new Category();
        category = podamFactory.manufacturePojo(Category.class);
        categoryRepository.save(category);
    }

    @RepeatedTest(1)
    void addUsers() {
        Users users = new Users();
        Product product = new Product();
        Category category = new Category();
        long randomNumber = RandoNumberG.generateNumber();

        Optional<Product> findProduct = productRepository.findById(randomNumber);
        Optional<Category> findCategory = categoryRepository.findById(randomNumber);
        if (findProduct.isPresent() && findCategory.isPresent()) {
            product = findProduct.get();
            category = findCategory.get();
            users = podamFactory.manufacturePojo(Users.class);
            product.setCategory(category);
            users.setProducts(Collections.singletonList(product));
            usersRepository.save(users);
        }
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
        List<Category> categories = extractDb.gettAllCategory();
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

    @RepeatedTest(1)
    void encryptPasswordDeclarative() {
        List<Users> users = usersRepository.findAll();
        DeclarativeUsersImpl declarativeUsers = new DeclarativeUsersImpl();
        declarativeUsers.encryptPasswordUsersDec(users);
        usersRepository.saveAll(users);
    }

    @RepeatedTest(1)
    void encryptPasswordImperative() {
        List<Users> users = usersRepository.findAll();
        ImperativeUsersImpl imperativeUsers = new ImperativeUsersImpl();
        imperativeUsers.encryptPasswordImperative(users);
        usersRepository.saveAll(users);
    }


    //------------------------------------------------------------------------------------------------------------------

    @RepeatedTest(1)
    void findAndSortByPriceDeclarative() {
        List<Product> products = productRepository.findAll();
        DeclarativeProductImpl declarativeProduct = new DeclarativeProductImpl();
        declarativeProduct.sortPrices(products);
        products.forEach((product) -> System.out.println(product.getPrice()));
    }


    @RepeatedTest(1)
    void findAndSortByPriceImperative() {
        List<Product> products = productRepository.findAll();
        ImperativeProductImpl imperativeProduct = new ImperativeProductImpl();
        imperativeProduct.sortPrices(products);
        products.forEach((product -> System.out.println(product.getPrice())));
    }

    @RepeatedTest(1)
    void findFirstImperative() {
        List<Users> users = usersRepository.findAll();
        ImperativeUsersImpl imperativeUsers = new ImperativeUsersImpl();
        List<String> a = imperativeUsers.findFirstCharacters(users, "Cyv");
        System.out.println(a);
    }

    @RepeatedTest(1)
    void findFirstDeclarative() {
        List<Users> users = usersRepository.findAll();
        DeclarativeUsersImpl declarativeUsers = new DeclarativeUsersImpl();
        List<Users> cyv = declarativeUsers.findFirstCharacters(users, "Cyv");
        System.out.println(cyv);
    }

    @RepeatedTest(1)
    void filterPricesDeclarative() {
        List<Product> products = productRepository.findAll();
        DeclarativeProductImpl declarativeProduct = new DeclarativeProductImpl();
        List<Product> prices = declarativeProduct.filterByPrices(products, 50.00, 500.00);
        List<Double> d = new ArrayList<>();

        for (Product p : prices) {
            d.add(p.getPrice());
        }

        System.out.println(d);

    }

    @RepeatedTest(1)
    void filterPricesImperative() {
        List<Product> products = productRepository.findAll();
        ImperativeProductImpl imperativeProduct = new ImperativeProductImpl();
        List<Double> prices = imperativeProduct.filterByPrices(products, 50.00, 500.00);
        System.out.println(prices);
    }


    @Test(threadPoolSize = 4)
    public void testInvocationCount() throws Exception {
        Thread.sleep(100);
        System.out.println("waitForAnswer");
    }


    @RepeatedTest(1)
    void testEncryptData() {
        EncryptionUtils encryptionUtils = new EncryptionUtils();
        List<Users> users = usersRepository.findAll();

        for (Users u : users) {
            u.setPassword(encryptionUtils.encoder().encode(u.getPassword()));
            System.out.println("Username: " + u.getFirstName() + " " + u.getPassword());
        }


    }
}
