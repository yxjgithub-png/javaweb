package com.yaoxinjia.repository;

import com.yaoxinjia.entity.Book;

import java.util.List;

/**
 * @author shkstart
 * @date 2020/2/17 0017 - 下午 10:50
 */
public interface BookRepository {
    public List<Book> findAll(int index,int LIMIT);
    public int count();
}
