package io.kimmking.cache.service;

import io.kimmking.cache.entity.User;
import org.springframework.cache.annotation.CacheConfig;

import java.util.List;
// TODO_Joly: cacheNames 拿来干嘛的
// Spring cache 提供的方法级别的统一操作
@CacheConfig(cacheNames = "users")
public interface UserService {

    User find(int id);

    List<User> list();

}
