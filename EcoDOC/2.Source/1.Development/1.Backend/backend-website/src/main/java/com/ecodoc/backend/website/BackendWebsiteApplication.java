package com.ecodoc.backend.website;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.ecodoc.backend.core.auth.TokenHelper;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EntityScan(basePackages = { "com.ecodoc" })
@ComponentScan(basePackages = { "com.ecodoc" })
@EnableJpaRepositories(basePackages = { "com.ecodoc" })
@EnableConfigurationProperties
@EnableJpaAuditing
@EnableWebMvc
@EnableCaching
@EnableSwagger2
@EnableScheduling
@EnableAsync
public class BackendWebsiteApplication{
	

	private ApplicationContext context;

	@Autowired
	public TokenHelper tokenHelper;
	
	public static void main(String[] args) {
		SpringApplication.run(BackendWebsiteApplication.class, args);
	}
	


	
}
