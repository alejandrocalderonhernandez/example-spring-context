package com.debuggeandoideas.configs;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;

@Configuration
public class TomcatConfig {

    @Bean
    public Tomcat tomcat() {
        Tomcat tomcat = new Tomcat();

        tomcat.setPort(8080);

        String baseDir = System.getProperty("java.io.tmpdir");

        tomcat.setBaseDir(baseDir);

        String contextPath = "";
        String docBase = new File(".").getAbsolutePath();

        Context context = tomcat.addContext(contextPath, docBase);

        GenericWebApplicationContext webAppContext =
                new GenericWebApplicationContext();

        webAppContext.registerBean(WebConfig.class);

        DispatcherServlet dispatcherServlet =  new DispatcherServlet(webAppContext);

        String servlet = "dispatcher";

        tomcat.addServlet(contextPath, servlet, dispatcherServlet);

        context.addServletMappingDecoded("/*", servlet);

        return tomcat;
    }
}
