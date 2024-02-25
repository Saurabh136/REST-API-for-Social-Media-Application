package com.apiproject.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Rest API
@RestController   //this annotation will help connect to the url
public class HelloWorldController {
	
	private MessageSource messageSource;
	
	//constructor injection
	public HelloWorldController(MessageSource messageSource) {
		this.messageSource= messageSource;	
		}
	
	//If anybody type /hello-world in browser , the result would be
	
	@GetMapping(path = "/hello-world")  // this will map the url request and respond to it
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	//path parameters
	// /user/{id}/todos/{id} => /users/2/todos/200
	// /hello-world/path-variable/{name}
	
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
		
	}
	
	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
		//return "Hello World V2";
		
		//example : 'en' -English (Good Morning) in many different languages
		
		
	}

}
