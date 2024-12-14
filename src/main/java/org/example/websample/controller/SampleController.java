package org.example.websample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j // lombok
@RestController
public class SampleController {

//    @RequestMapping(value = "/order/1", method = RequestMethod.GET)
    @GetMapping("/order/1")
    public String getOrder() {
        log.info("Get some order");
        return "orderId:1, orderAmount1000";
    }

    @PostMapping("/order")
    public String createOrder() {
        log.info("Create order");
        return "order created -> orderId:1, orderAmount1000";
    }
}
