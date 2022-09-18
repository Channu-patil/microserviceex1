package com.citius;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class APIRouteLocatorConfiguration {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		Function<PredicateSpec, Buildable<Route>> routeFunc = (path) -> path.path("/get").uri("http://httpbin.org");
		Function<PredicateSpec, Buildable<Route>> routeFunc2 = (path) -> path.path("/getCompany/{id}")
				.filters(f->f.addRequestHeader("MyKey", "MyValue"))
				.uri("lb://company-service/**");
		Function<PredicateSpec, Buildable<Route>> routeFunc3 = (path) -> path.path("/companyData/{id}")
				.filters(f->f.rewritePath("/companyData/?<segment>.*", "/getCompany/${segment}"))
				.uri("lb://company-service/**");
		return builder.routes().route(routeFunc).route(routeFunc2).route(routeFunc3).build();
	}
}
