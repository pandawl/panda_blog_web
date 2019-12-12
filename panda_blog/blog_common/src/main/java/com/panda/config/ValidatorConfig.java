package com.panda.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @program: blog-panda
 * @description: 校验
 * @author: Mr.Wang
 * @create: 2019-06-23 16:17
 **/
@Configuration
public class ValidatorConfig {

    public Validator validator() {
        ValidatorFactory factory = Validation.byProvider(HibernateValidator.class).configure()
                .addProperty("hibernate.validator.fail_fast", "true")
                .buildValidatorFactory();
        return factory.getValidator();
    }
}
