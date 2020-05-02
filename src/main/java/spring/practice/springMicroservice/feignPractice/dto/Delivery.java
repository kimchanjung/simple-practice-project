package spring.practice.springMicroservice.feignPractice.dto;

import lombok.Getter;

/**
 * Created by kimchanjung on 2020-04-16 3:32 오후
 */
@Getter
public class Delivery {
    private long deliveryId;
    private String name;
    private String address;
    private Integer age;

    public void setDeliveryId(long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
