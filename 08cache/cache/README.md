# Ehcache
* Ehcache,a widely used, open-source Java-based cache. It features memory and disk stores, listeners, cache loaders, RESTful and SOAP APIs and other very useful features.
* 类似于 Redis，Redis的数据存在了Redis中，哈哈哈哈哈
* 数据存在了JVM中
# 项目内容
1. mybatis 结合 ehcache 实现数据缓存功能（mybatis二级缓存）
    1. 看 UserMapper.java && UserMapper.xml && ehcache.xml
2. Spring cache 利用 ehcache(或者redis) 实现数据缓存功能（方法级别缓存）
    1. 看CacheConfig.java 进行全局配置，UserServiceImpl.java &&  UserService.java 进行配置和使用，CacheApplication.java 开启缓存
3. 结合 wrk 压测 REST 接口性能，来感受度
  