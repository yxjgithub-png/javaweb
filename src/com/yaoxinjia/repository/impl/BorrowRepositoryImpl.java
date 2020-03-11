package com.yaoxinjia.repository.impl;

import com.yaoxinjia.entity.Book;
import com.yaoxinjia.entity.Borrow;
import com.yaoxinjia.entity.Reader;
import com.yaoxinjia.repository.BorrowRepository;
import com.yaoxinjia.utils.JDBCTools;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @date 2020/2/18 0018 - 下午 1:12
 */
public class BorrowRepositoryImpl implements BorrowRepository {


    @Override
    public void insert(Integer bookid, Integer readerid, String borrwtime, String returntime, Integer adminid, Integer state) {
        Connection connection = JDBCTools.getConnection();
        String sql = "insert  into borrow(bookid,readerid,borrowtime,returntime,state) values(?,?,?,?,0)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bookid);
            preparedStatement.setInt(2, readerid);
            preparedStatement.setString(3, borrwtime);
            preparedStatement.setString(4, returntime);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            JDBCTools.release(connection, preparedStatement, null);
        }
    }

    @Override
    public List<Borrow> findAllByReaderId(Integer id, Integer index, Integer limit) {
        Connection connection = JDBCTools.getConnection();
        String sql = "select br.id,b.name,b.author,b.publish,br.borrowtime,br.returntime,r.name,r.tel,r.cardid,br.state from borrow br,book b,reader r where readerid = ? and b.id = br.bookid and r.id = br.readerid limit ?,?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Borrow> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, index);
            preparedStatement.setInt(3, limit);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new Borrow(resultSet.getInt(1),
                        new Book(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)),
                        new Reader(resultSet.getString(7), resultSet.getString(8), resultSet.getString(9)),
                        resultSet.getString(5),
                        resultSet.getString(6), resultSet.getInt(10)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection, preparedStatement, resultSet);
        }


        return list;
    }

    @Override
    public int count(Integer readerid) {
        Connection connection = JDBCTools.getConnection();
        String sql = "select count(*) from borrow br,book b,reader r where readerid = ? and b.id = br.bookid and r.id = br.readerid";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, readerid);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection, preparedStatement, resultSet);
        }
        return count;
    }

    @Override
    public List<Borrow> findAllByState(Integer state, Integer index, Integer limit) {
        Connection connection = JDBCTools.getConnection();
        String sql = "select br.id,b.name,b.author,b.publish,br.borrowtime,br.returntime,r.name,r.tel,r.cardid,br.state from borrow br,book b,reader r where state = ? and b.id = br.bookid and r.id = br.readerid limit ?,?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Borrow> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, state);
            preparedStatement.setInt(2, index);
            preparedStatement.setInt(3, limit);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new Borrow(resultSet.getInt(1),
                        new Book(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)),
                        new Reader(resultSet.getString(7), resultSet.getString(8), resultSet.getString(9)),
                        resultSet.getString(5),
                        resultSet.getString(6), resultSet.getInt(10)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection, preparedStatement, resultSet);
        }


        return list;
    }

    @Override
    public int countByState(Integer state) {
        Connection connection = JDBCTools.getConnection();
        String sql = "select count(*) from borrow br,book b,reader r where state = ? and b.id = br.bookid and r.id = br.readerid";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, state);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection, preparedStatement, resultSet);
        }
        return count;
    }

    @Override
    public void handle(Integer borrowId, Integer state, Integer adminId) {
        Connection connection = JDBCTools.getConnection();
        String sql = "update borrow set state = ?,adminid = ? where id = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,state);
            preparedStatement.setInt(2,adminId);
            preparedStatement.setInt(3,borrowId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection,preparedStatement,null);
        }


    }
}
