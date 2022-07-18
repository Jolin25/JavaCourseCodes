package io.kimmking.cache.redission;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class RedissionDemo1 {

    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://47.115.148.27:6379");

        final RedissonClient client = Redisson.create(config);
        // DONE_Joly: 虽然是两个JVM，但是这个lock应该是在Redis哪里做的统一的吧，所以RedissionDemo和RedissionDemo1应该只有一个能够获得锁的呀
        // ---> 是的呀，这就是分布式锁呀，就是只有一个JVM拿到了锁呀
        RLock lock = client.getLock("lock1");

        try{
            lock.lock();

            RMap<String, String> rmap = client.getMap("map1");

            for (int i = 0; i < 15; i++) {
                rmap.put("rkey:"+i, "rvalue:22222-"+i);
            }

            System.out.println(rmap.get("rkey:10"));

        }finally{
            lock.unlock();
        }
    }

}
