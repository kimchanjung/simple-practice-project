package spring.practice.mapStructPractice;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by kimchanjung on 2020-07-15 7:53 오후
 */
class RiderMapperTest {

    private final RiderMapper riderMapper = Mappers.getMapper(RiderMapper.class);

    @Test
    public void test() {
        RiderEntity 김찬정 = RiderEntity.of("김찬정");
        RiderDto riderDto1 = new RiderDto();

        RiderDto riderDto = riderMapper.riderToDto(김찬정);

        assertEquals("김찬정", riderDto.getRiderName());


    }
}