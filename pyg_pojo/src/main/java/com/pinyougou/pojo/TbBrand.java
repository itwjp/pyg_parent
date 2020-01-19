package com.pinyougou.pojo;

import java.io.Serializable;

/**
 * @ClassName: TbBrand
 * @author: itXiaoKe
 * @date: 2020/1/19 11:23
 * @Description: no description
 * @Version: 1.0
 */
public class TbBrand implements Serializable {
    private long id;
    private String name;
    private String firstChar;

    @Override
    public String toString() {
        return "TbBrand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstChar='" + firstChar + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstChar() {
        return firstChar;
    }

    public void setFirstChar(String firstChar) {
        this.firstChar = firstChar;
    }
}
