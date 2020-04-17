package spring.practice.springMicroservice.feignPractice;

import org.springframework.stereotype.Service;

import javax.websocket.server.ServerEndpoint;

/**
 * Created by kimchanjung on 2020-04-16 4:05 오후
 */
@Service
public class TestService {

    public Integer getValue() {
        return 10;
    }
}
