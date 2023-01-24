package io.kimmking.jrl.ioc0.bean0;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ¼Ò
 *
 * @author jrl
 * @date Create in 14:33 2023/1/24
 */

public class Home {
    Relative relativeOne;
    String name;

    public void setRelativeOne(Relative relativeOne) {
        this.relativeOne = relativeOne;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Relative getRelativeOne() {
        return relativeOne;
    }

    public String getName() {
        return name;
    }
}
