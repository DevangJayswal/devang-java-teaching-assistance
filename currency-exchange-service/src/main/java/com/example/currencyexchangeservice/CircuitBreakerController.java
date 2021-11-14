package com.example.currencyexchangeservice;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    // let's add in simple Logger call
    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    // USE CASE:
    // we are implementing Circuit Breaker
    // is means that if the service or endpoint is down
    // it should retry

    // @Retry: Useful when service is momentary down,
    // you just give the service a little time and then call it again


    /**
     * Circuit Breaker
     * when service is down for a long time
     * fire a lot of request to this api using `watch` command in unix terminal,
     * `watch -n 0.1 curl [url]` -> 10 request per second,
     * or we can try 100-200 quick requests from the browser by quickly refreshing
     * <p>
     * what will happen
     * you would see that there are no method calls
     * Circuit Breaker is returning the response back without even calling this method
     * directly the fallbackMethod is being called and the response is returned
     * however you can see that request are being fired
     * and that is what the Circuit Breaker framework allows us to do
     * if the microservice is down then Circuit Breaker thinks that microservice calls are failing
     * then why do i need to call it and add load to it why can't i return default response back directly
     * that is what the Circuit Breaker does, it will break the circuit and
     * wil directly return a response back
     * you  might be wondering how do I know if the microservice is up again, and I can call it again
     * <p>
     * LIFECYCLE: CLOSE -> OPEN <-> HALF_OPEN -> CLOSE
     *
     * Initially it would be CLOSE, the moment it would identify that method is failing it would try
     * to OPEN the circuit. In the OPEN state method will not be called at all and fallback method will be called
     * directly in order to release the load. Then it would observe in the HALF_OPEN state that is it still failing
     * or not. If it fails again then it switches back to OPEN state. If in the HALF_OPEN state it successfully be able
     * to execute without failing then it will switch to CLOSE state.
     * Please read the documentation
     *
     */

    /**
     * @return
     * @RateLimiter: Let's say I in 10 seconds, I would want to only allow 10,000 calls to the sample-api
     * For all the APIs present in here, we can set different rate limits. We can have different names
     * for each of these APIs. Initially we have @RateLimiter(name="default") but we can have @RateLimiter(name="sample-api")
     * and for other APIs in the same microservices, we can have different names, and we can configure different limits for
     * them. The way we can do that is by specifying in application.properties
     */

    // let's say sample-api is down temporarily and sometimes if we invoke the same thing multiple times
    // it might give us a response back
    // in this kind of situation we can use @Retry
    @GetMapping("/sample-api")
    // @Retry(name = "default")
    // we can also configure fallback method
    // @Retry(name = "sample-api", fallbackMethod = "hardCodedResponse")
    // we are using `default` configuration for @Retry
    // @CircuitBreaker(name = "default", fallbackMethod = "hardCodedResponse")
    // 10s -> 10,000 calls to the sample-api

    public String sampleApi() {
        // we are adding this logger because @Retry will try multiple time this sampleApi when it fails
        // so in console we can see how many times it retries when it fails
        // (3 times in the case of `default` @Retry configuration)
        logger.info("Sample API call received");
        // let's make this API fail so that we can implement Retry
        // let's call some dummy API so that it fails
        ResponseEntity<String> forEntity = new RestTemplate()
                .getForEntity("http://localhost:8080/some-dummy-url", String.class);

        // when user make request to `.../sample-api` it will call dummy url and will fail
        // In the case of `default` @Retry configuration,
        // if there is an exceptions in the above code, then it wil retry for three times
        // and if the retry fails all the times, only then it would return an error back
        return forEntity.getBody();
    }

    /**
     * we can configure how many concurrent calls are allowed that is called @BulkHead
     * configure in application.properties
     * @return
     */

    @GetMapping("/sample-api2")
//    @RateLimiter(name = "default")
    @Bulkhead(name = "default")
    public String sampleApi2() {
        return "sample-api2";
    }

    // it will give an error saying,
    // NoSuchMethodException ...hardCodedResponse
    // we will have to pass `Exception` as method parameter
    // we know Exception extends Throwable,
    // so we can use Exception
    // we can use any Exception here, and we can have different responses returned for different kinds
    // of exception
    public String hardCodedResponse(Exception ex) {
        return "fallback-response";
    }
}
