package io.kimmking.utilsJ;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
/**
 * knowledge point:
 * 可以将对象转为json形式的字符串，
 * 也可以将json形式的字符串转为map形式的对象(也可以通过传Class对象，转成对应的类型)
 */

/**
 * @author jrl
 * @date Create in 18:47 2021-11-23
 */
public class fastjson {
    public static void main(String[] args) {
        //将json形式的字符串转为map形式的对象
        JSONObject jsonObject = JSON.parseObject("{\"age\":11,\"name\":\"mona\"}");
        //(也可以通过传Class对象，转成对应的类型)
        Person person = JSON.parseObject("{\"age\":11,\"name\":\"mona\"}", Person.class);
        System.out.println(jsonObject);
        Object name = jsonObject.get("name");
        System.out.println(name);
        System.out.println(person.getAge());
        Person p = new Person(11, "mona");
        //将对象转为json形式的字符串
        String s = JSON.toJSONString(p);
        System.out.println(s);
    }
}
