package com.yaoxinjia.service;

import com.yaoxinjia.entity.Book;
import com.yaoxinjia.entity.Borrow;

import java.util.List;

/**
 * @author shkstart
 * @date 2020/2/17 0017 - 下午 10:20
 */
public interface BookService {
    public List<Book> findAll(int page);
    public int getPages();
    public int getBorrowPages(Integer readerid);
    public void addBorrow(Integer bookid,Integer readerid);
    public List<Borrow> findAllBorrowByReadId(Integer id,Integer page);
    public List<Borrow> findAllBorrowByState(Integer state,Integer page);
    public int getBorrowPagesByState(Integer state);

    public void handleBorrow(Integer borrowId, Integer state,Integer adminId);
}
