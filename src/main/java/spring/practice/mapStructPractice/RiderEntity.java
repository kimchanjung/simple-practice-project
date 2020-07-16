package spring.practice.mapStructPractice;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by kimchanjung on 2020-07-15 7:46 오후
 */
@Getter
@Entity
public class RiderEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;

    public static RiderEntity of(String name) {
        RiderEntity riderEntity = new RiderEntity();
        riderEntity.name = name;
        return riderEntity;
    }
}
