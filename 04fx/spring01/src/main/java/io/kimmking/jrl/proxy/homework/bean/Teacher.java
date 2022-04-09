package io.kimmking.jrl.proxy.homework.bean;

import io.kimmking.spring01.Student;
import lombok.Data;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jrl
 * @date Create in 14:24 2022/4/9
 */
// TODO_Joly:没有setter可以吗
@Component
@Data
public class Teacher {
    @Autowired
    Student student;
}
