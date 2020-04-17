package spring.practice.springMicroservice.feignPractice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.practice.springMicroservice.feignPractice.dto.Delivery;

import java.util.List;

/**
 * Created by kimchanjung on 2020-04-16 3:29 오후
 */
@FeignClient(name = "deliveryClient", url="localhost:8080")
public interface DeliveryClient {
    @RequestMapping(method = RequestMethod.GET, value = "/deliveries")
    List<Delivery> getDeliveries();

    @RequestMapping(method = RequestMethod.GET, value = "/deliveries/{deliveryId}", consumes = "application/json")
    Delivery getDeliveryById(@PathVariable("deliveryId") Long deliveryId);
}
