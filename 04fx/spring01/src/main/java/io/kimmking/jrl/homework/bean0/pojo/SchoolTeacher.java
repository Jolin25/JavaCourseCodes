package io.kimmking.jrl.homework.bean0.pojo;

import io.kimmking.spring01.Student;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jrl
 * @date Create in 14:24 2022/4/9
 */
@Component
@Data
public class SchoolTeacher {
    @Autowired
    Student favoriteStudent;
}
