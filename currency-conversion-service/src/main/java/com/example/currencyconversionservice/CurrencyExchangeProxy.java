package com.example.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//feign client config before naming server eureka
//@FeignClient(name = "currency-exchange", url="localhost:8000")

//feign client config after setting up naming server eureka
// it will automatically get the instance of currency-exchange
// feign client will talk to eureka and pickup the instances of currency-exchange
// and do load balancing between them
@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveExchangeValue(@PathVariable String from,
                                                  @PathVariable String to);
}
