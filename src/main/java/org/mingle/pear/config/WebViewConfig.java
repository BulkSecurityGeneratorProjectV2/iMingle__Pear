package org.mingle.pear.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.PathExtensionContentNegotiationStrategy;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.tiles3.SpringBeanPreparerFactory;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

import com.fasterxml.jackson.databind.ObjectMapper;

@EnableWebMvc
@Configuration
public class WebViewConfig extends WebMvcConfigurerAdapter {
	
	@Bean
	public ContentNegotiatingViewResolver contentNegotiatingViewResolver() {
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		Map<String, MediaType> mediaTypes = new HashMap<>();
		mediaTypes.put("xml", MediaType.APPLICATION_XML);
		mediaTypes.put("json", MediaType.APPLICATION_JSON);
		mediaTypes.put("html", MediaType.TEXT_HTML);
		mediaTypes.put("htm", MediaType.TEXT_HTML);
		mediaTypes.put("txt", MediaType.TEXT_PLAIN);
		ContentNegotiationManager manager = new ContentNegotiationManager(
			new HeaderContentNegotiationStrategy(), new PathExtensionContentNegotiationStrategy(mediaTypes));
		resolver.setContentNegotiationManager(manager);
		List<View> defaultViews = new ArrayList<>();
		MappingJackson2JsonView jackson2JsonView = new MappingJackson2JsonView();
		jackson2JsonView.setObjectMapper(new ObjectMapper());
		defaultViews.add(jackson2JsonView);
		resolver.setDefaultViews(defaultViews);
		
		return resolver;
	}
	
	@Bean
	public ResourceBundleViewResolver resourceBundleViewResolver() {
		ResourceBundleViewResolver resolver = new ResourceBundleViewResolver();
		resolver.setBasenames("views/excel", "views/word");
		resolver.setOrder(1);
		return resolver;
	}
	
	@Bean
	public BeanNameViewResolver BeanNameViewResolver() {
		BeanNameViewResolver resolver = new BeanNameViewResolver();
		resolver.setOrder(10);
		return resolver;
	}
	
	@Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    
    @Bean
    public UrlBasedViewResolver urlBasedViewResolver() {
    	UrlBasedViewResolver resolver = new UrlBasedViewResolver();
    	resolver.setViewClass(TilesView.class);
    	return resolver;
    }
    
    @Bean
    public static TilesConfigurer tilesConfigurer() {
    	TilesConfigurer configurer = new TilesConfigurer();
    	configurer.setDefinitions("/WEB-INF/**/*.xml");
    	configurer.setPreparerFactoryClass(SpringBeanPreparerFactory.class);
    	return configurer;
    }
}
