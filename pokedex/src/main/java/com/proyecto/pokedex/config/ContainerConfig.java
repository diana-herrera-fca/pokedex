package com.proyecto.pokedex.config;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ContainerConfig {

    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> containerCustomizer() {
        return factory -> {
            factory.addErrorPages(
                    new ErrorPage(HttpStatus.NOT_FOUND, "/error404.html"),
                    new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error500.html")
            );
        };
    }
}

