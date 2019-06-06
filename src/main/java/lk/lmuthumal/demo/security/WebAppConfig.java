package lk.lmuthumal.demo.security;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@ComponentScan("lk.lmuthumal.demo")
@EnableWebMvc
@EnableWebSecurity
public class WebAppConfig {
}
