package io.kimmking.java8;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 演示Guava
 *
 * @author Joly
 * @date 2022/4/26
 */
@Slf4j
public class GuavaDemo {
    // 常规情况下，一个项目用一个EventBus就够了
    static EventBus bus = new EventBus();

    static {
        // 被调用方（类似于消费者）向EventBus注册
        bus.register(new GuavaDemo());
    }


    @SneakyThrows
    public static void main(String[] args) throws IOException {

        List<String> lists = testString();

        List<Integer> list = testList();

        testMap(list);

        testBiMap(lists);

        testEventBus();

    }

    private static void testEventBus() {
        log.info("=====testEventBus=====");
        // EventBus
        // SPI+service loader
        // Callback/Listener
        // 
        Student student2 = new Student(2, "KK02");
        System.out.println(Thread.currentThread().getName() + " I want " + student2 + " run now.");
        bus.post(new AEvent(student2));
        int a = 1;
    }

    private static void testBiMap(List<String> lists) {
        log.info("=====testBiMap=====");
        // Guava里的双向Map
        BiMap<String, Integer> words = HashBiMap.create();
        words.put("First", 1);
        words.put("Second", 2);
        words.put("Third", 3);

        System.out.println(words.get("Second").intValue());
        // 翻转key和value（也就是说key和value相互换值），从而根据原来的value可以找到原来的key
        System.out.println(words.inverse().get(3));

        Map<String, String> map1 = Maps.toMap(lists.listIterator(), a -> a + "-value");
        //Exception in thread "main" java.lang.UnsupportedOperationException
        // 	at com.google.common.collect.ImmutableMap.put(ImmutableMap.java:529)
        // 因为这是一个immutable的Map，所以不可以对这个map进行任何更新操作
        // map1.put("34344","changed");
        // map1.put("12345","11");
        print(map1);
    }

    private static void testMap(List<Integer> list) {
        log.info("=====testMap=====");
        //Map map = list.stream().collect(Collectors.toMap(a->a,a->(a+1)));
        // 用Guava创建了多值的map：在放入用一个key，value的时候不会覆盖上一个value，而是增加一个value
        Multimap<Integer, Integer> multimap = ArrayListMultimap.create();
        list.forEach(
                a -> multimap.put(a, a + 1)
        );
        print(multimap);
    }

    private static List<Integer> testList() {
        log.info("=====testList=====");
        // 更强的集合操作
        // 简化 创建

        List<Integer> list = Lists.newArrayList(4, 2, 3, 5, 1, 2, 2, 7, 6);
        // 分片，把list拆成了三个list。在对一大堆数据进行分组的时候非常的有用。
        List<List<Integer>> list1 = Lists.partition(list, 3);

        print(list1);
        return list;
    }

    private static List<String> testString() {
        log.info("=====testString=====");
        // 字符串处理
        //
        List<String> lists = Lists.newArrayList("a", "b", "g", "8", "9");
        lists.set(1, "aaaaaa");
        String result = Joiner.on(",").join(lists);
        System.out.println(result);

        String test = "34344,,,34,34,哈哈";
        lists = Splitter.on(",").splitToList(test);
        System.out.println(lists);
        return lists;
    }

    private static void print(Object obj) {
        System.out.println(JSON.toJSONString(obj));
    }


    @Data
    @AllArgsConstructor
    public static class AEvent {
        private Student student;
    }

    @Subscribe
    public void handle(AEvent ae) {
        System.out.println(Thread.currentThread().getName() + " " + ae.student + " is running.");
    }


}
