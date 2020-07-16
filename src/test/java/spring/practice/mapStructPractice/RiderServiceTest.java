package spring.practice.mapStructPractice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by kimchanjung on 2020-07-16 2:13 오후
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest
class RiderServiceTest {

    @Autowired
    private RiderService riderService;

    @Test
    public void 라이더DTO_로_정상적인_매핑이_된다() {
        RiderDto rider = riderService.findRider();

        assertEquals("김찬정", rider.getRiderName());
    }
}