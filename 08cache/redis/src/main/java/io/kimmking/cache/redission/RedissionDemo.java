package io.kimmking.cache.redission;

import lombok.SneakyThrows;
import org.redisson.Redisson;
import org.redisson.RedissonMap;
import org.redisson.api.RLock;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class RedissionDemo {

    @SneakyThrows
    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://47.115.148.27:6379");

        final RedissonClient client = Redisson.create(config);
        RMap<String, String> rmap = client.getMap("map1");
        RLock lock = client.getLock("lock1");
        try{
            lock.lock();

            for (int i = 0; i < 15; i++) {
                rmap.put("rkey:"+i, "111rvalue:"+i);
            }

            // 如果代码块 W1 在这里会怎么样？
            // 代码块 W1
            while(true) {
                Thread.sleep(2000);
                System.out.println(rmap.get("rkey:10"));
            }

        }finally{
            lock.unlock();
        }



    }

    // 可参阅：https://www.jianshu.com/p/47fd7f86c848

}
