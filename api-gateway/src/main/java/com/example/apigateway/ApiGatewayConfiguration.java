package com.example.apigateway;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ApiGatewayConfiguration {


    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        // using `builder` we can customise routes which we want to use
        Function<PredicateSpec, Buildable<Route>> routeFunction = predicateSpec -> predicateSpec
                // if path is `/get` Try `/sites`
                .path("/get")
                // so before routing the request to the new URL,
                // adding header and request parameter
                .filters(f -> f
                        .addRequestHeader("MyHeader", "MyURI")
                        .addRequestParameter("Param", "MyValue"))
                // before calling `http://httpbin.org:80` it will add above header `MyHeader`
                // then will redirect to `http://httpbin.org:80` Try `http://google.com`
                .uri("http://httpbin.org:80");
        // it will redirect to http://httpbin.org:80/get

        // USE CASE:
        // URI can be our microservice, and we can add authentication header

        return builder.routes()
                //using route() we can customize
                // adding route by passing Function as argument
                .route(routeFunction)
                // adding route by creating function using lambda expression
                .route(predicateSpec -> predicateSpec
                                // at this point, we can disable
                                // ...locator.lowerCaseServiceId=true and
                                // ...locator.enabled=true
                                // in application.properties file

                                // if a request URI starts with `currency-exchange`, we would redirect it using the naming server,
                                // and also it would do load balance
                                .path("/currency-exchange/**")
                                // lb://[name_of_the_registration_on_eureka_server]
                                .uri("lb://currency-exchange")

                        // if a request starts with localhost:8765/currency-exchange/** then it would talk to eureka
                        // will load balance and  will return the location of the service (instance)
                        // then on that location e.g. currency-exchange is on localhost:8000 then
                        // path will be applied on that location i.e. localhost:8000/currency-exchange/**
                )
                .route(predicateSpec -> predicateSpec
                                .path("/currency-conversion/**")
                                .uri("lb://currency-conversion"))
                .route(predicateSpec -> predicateSpec
                        .path("/currency-conversion-feign/**")
                        .uri("lb://currency-conversion"))

                .route(predicateSpec -> predicateSpec
                        .path("/currency-conversion-new/**")
                        // let's say instead of `currency-conversion-feign` your user is calling `currency-conversion-new`
                        // and you want it to redirect to feign
                        .filters(f-> f.rewritePath(
                                // string to be replaced, additionally we will have to define the regular expression
                                // identifying the next thing as a segment
                                "/currency-conversion-new/(?<segment>.*)",
                                // what it should be replaced with
                                // following above segment we applied, we want to use the same segment
                                // so whatever follows `currency-conversion-new` we want to append it to
                                // `currency-conversion-feign` by ${segment}
                                "/currency-conversion-feign/${segment}"))
                        .uri("lb://currency-conversion"))

                // how do you define a regular expression identifying this as a specific segment
                // (?<segment>.*)

                .build();

        // this is when we are not customizing any routes
        // return builder.routes().build();


    }

}
