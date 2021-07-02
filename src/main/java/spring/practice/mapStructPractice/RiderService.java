package spring.practice.mapStructPractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kimchanjung on 2020-07-16 2:11 오후
 */
@Service
public class RiderService {

    private final RiderMapper riderMapper;

    public RiderService(RiderMapper riderMapper) {
        this.riderMapper = riderMapper;
    }


    public RiderDto findRider() {
        return riderMapper.riderToDto(RiderEntity.of("김찬정"));
    }

}
