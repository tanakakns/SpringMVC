package hello;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan(basePackages = { "hello" })
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	@Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//        configurer.favorPathExtension(true).
//        ignoreAcceptHeader(true).
//        useJaf(false).
//        defaultContentType(MediaType.TEXT_HTML).
//        mediaType("html", MediaType.TEXT_HTML).
//        mediaType("xml", MediaType.APPLICATION_XML).
//        mediaType("json", MediaType.APPLICATION_JSON);
        configurer.ignoreAcceptHeader(true).defaultContentType(MediaType.APPLICATION_JSON).mediaType("xml", MediaType.APPLICATION_XML);
    }
}