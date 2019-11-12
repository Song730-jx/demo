package com.song.demo.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) throws Exception {
        //1、使用连接池建立数据库连接
        MyDataSource myDataSource = new MyDataSource();
        Connection conn = myDataSource.getConnection();
        //2、创建状态
        Statement state = conn.createStatement();
        //3、查询数据库并返回结果
        ResultSet result = state.executeQuery("select * from tbstudent");
        //4、输出查询结果
        while (result.next()) {
            System.out.println(result.getString("name"));
        }
        //5、断开数据库连接
        result.close();
        state.close();
        //6、归还数据库连接给连接池
        myDataSource.releaseConnection(conn);

        Connection conn1 = myDataSource.getConnection();
        //2、创建状态
        Statement state1 = conn.createStatement();
        //3、查询数据库并返回结果
        ResultSet result1 = state1.executeQuery("select * from tbstudent");
        //4、输出查询结果
        while (result1.next()) {
            System.out.println(result1.getString("name"));
        }
        //5、断开数据库连接
        result1.close();
        state1.close();
        //6、归还数据库连接给连接池
        myDataSource.releaseConnection(conn);
    }
}
