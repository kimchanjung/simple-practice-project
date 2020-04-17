package spring.practice.springMicroservice.feignPractice;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring.practice.springMicroservice.feignPractice.dto.Delivery;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kimchanjung on 2020-04-16 3:39 오후
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DeliveryClientTest {


    private final static WireMockServer wireMockServer = new WireMockServer();

    @Autowired
    private TestService testService;
    @Autowired
    private DeliveryClient deliveryClient;

    @BeforeAll
    public static void init() {
        wireMockServer.start();
    }

    @Test
    public void 배달목록을_정상적으로_가져온다() {
        //Given
        wireMockServer.stubFor(get(urlPathMatching("/deliveries"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("[{\"deliveryId\": 1},{\"deliveryId\": 2}]")));
        //When
        List<Delivery> deliveries = deliveryClient.getDeliveries();

        //Then
        assertThat(deliveries.size()).isEqualTo(2);
        assertThat(deliveries.get(1).getDeliveryId()).isEqualTo(2);
    }

    @Test
    public void 하나의_배달을_정상적으로_가져온다() {
        //Given
        wireMockServer.stubFor(get(urlPathMatching("/deliveries/.*"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"deliveryId\": 1}")));
        //When
        Delivery delivery = deliveryClient.getDeliveryById(1L);

        //Then
        assertThat(delivery.getDeliveryId()).isEqualTo(1L);
    }

}