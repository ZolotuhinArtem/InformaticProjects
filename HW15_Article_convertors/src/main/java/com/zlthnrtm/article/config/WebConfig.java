/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.article.config;

import com.zlthnrtm.article.utils.UniversalConvertor;
import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author arch
 */
@Configuration
@EnableWebMvc
@ComponentScan({"com.zlthnrtm.article.controller"})
public class WebConfig extends WebMvcConfigurerAdapter{
    
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        resolver.setRedirectContextRelative(false);
        return resolver;
    }
    
    @Bean
    public LocaleResolver localeResolver(){
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setCookieName("lang");
        localeResolver.setDefaultLocale(new Locale("ru", "RU"));
        return localeResolver;
    }
    
    @Bean 
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource msgRsr = new ReloadableResourceBundleMessageSource();
        msgRsr.setBasename("classpath:i18n/message");
        msgRsr.setDefaultEncoding("UTF-8");
        msgRsr.setCacheSeconds(0);
        msgRsr.setUseCodeAsDefaultMessage(false);
        
        return msgRsr;
    }
    
    @Bean
    public MessageSourceAccessor messageSourceAccessor(MessageSource ms){
        return new MessageSourceAccessor(ms);
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        registry.addInterceptor(interceptor);
    }
    
    @Bean
    public UniversalConvertor universalConvertor(){
        return new UniversalConvertor();
    }
    
    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {
      formatterRegistry.addConverter(universalConvertor());
    }
//
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("main");
//    }
    
    
}
