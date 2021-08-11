package com.bank.fin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"com.bank.fin"})
@EntityScan({"com.bank.fin.model"})
@EnableJpaRepositories(value = "com.bank.fin.repositories")
@EnableScheduling
public class FinancialServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancialServicesApplication.class, args);
	}

//	@Bean
//	ServletRegistrationBean jsfServletRegistration (ServletContext servletContext) {
//		//spring boot only works if this is set
//		servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
//
//		//registration
//		ServletRegistrationBean srb = new ServletRegistrationBean();
//		srb.setServlet(new FacesServlet());
//		srb.setUrlMappings(Arrays.asList("*.xhtml"));
//		srb.setLoadOnStartup(1);
//		return srb;
//	}
//
//	@Bean
//	public com.sun.faces.config.ConfigureListener mojarraConfigureListener() {
//		return new com.sun.faces.config.ConfigureListener();
//	}

}
