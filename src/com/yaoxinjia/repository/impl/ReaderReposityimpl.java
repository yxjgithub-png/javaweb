package com.yaoxinjia.repository.impl;

import com.yaoxinjia.entity.Reader;
import com.yaoxinjia.repository.ReaderRepository;
import com.yaoxinjia.utils.JDBCTools;

import java.sql.*;

/**
 * @author shkstart
 * @date 2020/2/17 0017 - 上午 11:27
 */
public class ReaderReposityimpl implements ReaderRepository {

    @Override
    public Reader login(String username, String password) {
        Connection connection = JDBCTools.getConnection();
        String sql = "select * from reader where username= ? and password = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Reader reader = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            statement.setString(2,password);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                reader = new Reader(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,statement,resultSet);
        }
        return reader;
    }
}
