package com.yaoxinjia.repository;

import com.yaoxinjia.entity.Borrow;

import java.util.List;

/**
 * @author shkstart
 * @date 2020/2/18 0018 - 下午 1:07
 */
public interface BorrowRepository {
    public void insert(Integer bookid,Integer readerid,String borrwtime,String returntime,Integer adminid,Integer state);
    public List<Borrow> findAllByReaderId(Integer id,Integer index,Integer limit);
    public int count(Integer readerid);
    public List<Borrow> findAllByState(Integer state,Integer index,Integer limit);
    public int countByState(Integer state);

    public void handle(Integer borrowId, Integer state, Integer adminId);
}
