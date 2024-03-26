package br.com.calto.vendas_online.config;

import jakarta.validation.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class ValidatorConfig {

  @Bean
  public Validator validatorFactory() {
    LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
    //	    bean.setValidationMessageSource(messageSource);
    return bean;
  }
}
