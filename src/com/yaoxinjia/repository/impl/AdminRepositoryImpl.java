package com.yaoxinjia.repository.impl;

import com.yaoxinjia.entity.Admin;
import com.yaoxinjia.repository.AdminRepository;
import com.yaoxinjia.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author shkstart
 * @date 2020/2/17 0017 - 下午 7:42
 */
public class AdminRepositoryImpl implements AdminRepository {

    @Override
    public Admin login(String username, String password) {
        Connection connection = JDBCTools.getConnection();
        String sql = "select * from bookadmin where username= ? and password = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Admin admin = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            statement.setString(2,password);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                admin = new Admin(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,statement,resultSet);
        }
        return admin;
    }
}
