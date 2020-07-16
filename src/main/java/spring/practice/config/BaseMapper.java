package spring.practice.config;

import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

/**
 * Created by kimchanjung on 2020-07-16 2:31 오후
 * 개별 매퍼에 옵션을 줄 수 있지만
 * 공통옵션을 선언하여 개별 매퍼가 import할 수 있다.
 * * componentModel
 *  *  - 옵션을 통해서 빈으로 사용이 가능 하게 된다
 *  *  - 스프링 빈으로 사용하려면 componentModel = "spring" 옵션을 준다.
 *  *
 */

@MapperConfig(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface BaseMapper {
}
