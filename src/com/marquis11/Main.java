package com.marquis11;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/world?serverTimezone = GMT&useUnicode=true&characterEncoding=utf-8";
            String user="sa";
            String password = "root";
            Connection conn = DriverManager.getConnection(url, user, password);
            //执行SQL语句的步骤
            //第一步
            Statement stat = conn.createStatement();
            //第二步
            String command = "select * from school";
            //第三步
            ResultSet result =  stat.executeQuery(command);
            //按行读取查询结果当中的数据
            while(result.next()) {
                //使用访问器方法获取信息
                System.out.println(result.getString(1) + " " +  result.getString(2) + " " + result.getString(3) );
            }
            result.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException s) {
            s.printStackTrace();
        }

    }
}
