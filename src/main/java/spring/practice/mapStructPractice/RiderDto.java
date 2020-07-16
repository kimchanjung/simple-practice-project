package spring.practice.mapStructPractice;

import lombok.*;

/**
 * Created by kimchanjung on 2020-07-15 7:47 오후
 */
@Builder
@AllArgsConstructor
@Getter
public class RiderDto {
    private long id;
    private String riderName;

    public RiderDto() {
    }
}
