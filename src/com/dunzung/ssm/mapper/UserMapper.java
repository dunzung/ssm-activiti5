package com.dunzung.ssm.mapper;

import com.dunzung.ssm.entity.UserEntity;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

/**
 * Created by zhijund on 2019/5/22.
 */
//声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@MapperScan
@Repository
public interface UserMapper {

    UserEntity get(String name);

}

