package com.yaoxinjia.entity;

/**
 * @author shkstart
 * @date 2020/2/17 0017 - 下午 10:26
 */
public class BookCase {
    private Integer id;
    private String name;

    public BookCase(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
