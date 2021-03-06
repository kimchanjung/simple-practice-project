package spring.practice.mapStructPractice;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import spring.practice.config.BaseMapper;

/**
 * Created by kimchanjung on 2020-07-15 7:48 오후
 */

@Mapper(config = BaseMapper.class)
public interface RiderMapper {
    RiderMapper INSTANCE = Mappers.getMapper( RiderMapper.class );

    // 컴럼명이 다르면 이렇게 수동으로 매핑할 수 있다.
    @Mapping(source = "name", target = "riderName")
    RiderDto riderToDto(RiderEntity riderEntity);
}
