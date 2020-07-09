package com.windyoffice.springboot.webservice.config;

import com.windyoffice.springboot.webservice.service.impl.UserServiceImpl;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class WebServiceConfig {



    @Autowired
    private UserServiceImpl userService;


    @Bean("cxfServletRegistrtBean")
    public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/webservice/*");
    }

    @Bean
    public SpringBus cxf(){
        return  new SpringBus();
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(cxf(), userService);
        endpoint.publish("/userservice");
        return endpoint;
    }
}
