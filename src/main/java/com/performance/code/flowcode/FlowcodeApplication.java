package com.performance.code.flowcode;

import com.performance.code.flowcode.controllers.Declarative.DeclarativeCategoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class FlowcodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlowcodeApplication.class, args);



    }

}
