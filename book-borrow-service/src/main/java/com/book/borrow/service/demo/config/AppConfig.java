package com.book.borrow.service.demo.config;

import com.library.service.demo.facade.BookFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:applicationContext.xml")
public class AppConfig {

}
