package org.example.websample.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j // lombok
@RestController
public class SampleController {

//    @RequestMapping(value = "/order/1", method = RequestMethod.GET)
    @GetMapping("/order/{orderId}")
    public String getOrder(@PathVariable("orderId") String id) {
        log.info("Get some order : " + id);
        return "orderId: " + id + ", orderAmount1000";
    }

    @DeleteMapping("/order/{orderId}")
    public String deleteOrder(@PathVariable("orderId") String id) {
        log.info("Delete some order : " + id);
        return "Delete orderId: " + id;
    }

    @GetMapping("/order")
    public String getOrderWithRequestParam(@RequestParam(value = "orderId", required = false, defaultValue = "defaultId") String id,
                                           @RequestParam("orderAmount") Integer amount) {
        log.info("Get order : " + id + ", amount : " + amount);
        return "orderId: " + id + ", orderAmount: " + amount;
    }

    @PostMapping("/order")
    public String createOrder(@RequestBody CreateOrderRequest createOrderRequest,
                              @RequestHeader String userAccountId) {
        log.info("Create order : " + createOrderRequest + ", userAccountId : " + userAccountId);
        return "orderId: " + createOrderRequest.getOrderId() + ", orderAmount: " + createOrderRequest.getOrderAmount();
    }

    @PutMapping("/order")
    public String createOrder() {
        log.info("Create order");
        return "order created -> orderId:1, orderAmount1000";
    }

    @Data
    public static class CreateOrderRequest {
        private String orderId;
        private Integer orderAmount;



    }

}
