package com.yaoxinjia.repository.impl;

import com.yaoxinjia.entity.Book;
import com.yaoxinjia.entity.BookCase;

import com.yaoxinjia.repository.BookRepository;
import com.yaoxinjia.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @date 2020/2/17 0017 - 下午 10:52
 */
public class BookRepositoryImpl implements BookRepository {

    @Override
    public List<Book> findAll(int index,int limit) {
        Connection connection = JDBCTools.getConnection();
        String sql = "select * from book,bookcase where book.bookcaseid = bookcase.id limit ?,?";
        PreparedStatement preparedStatement = null;
        ResultSet resultset = null;
        List<Book> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,index);
            preparedStatement.setInt(2,limit);
            resultset = preparedStatement.executeQuery();
            while (resultset.next()) {
                list.add(new Book(resultset.getInt(1),resultset.getString(2),resultset.getString(3),resultset.getString(4),resultset.getInt(5),resultset.getDouble(6),new BookCase(resultset.getInt(9),resultset.getString(10))));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,resultset);
        }
        return list;
    }

    @Override
    public int count() {
        Connection connection = JDBCTools.getConnection();
        String sql = "select count(*) from book,bookcase where book.bookcaseid = bookcase.id";
        PreparedStatement preparedStatement = null;
        ResultSet resultset = null;
        int count = 0;
        List<Book> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultset = preparedStatement.executeQuery();
            while (resultset.next()) {
                count  = resultset.getInt(1);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,resultset);
        }
        return count;
    }
}
