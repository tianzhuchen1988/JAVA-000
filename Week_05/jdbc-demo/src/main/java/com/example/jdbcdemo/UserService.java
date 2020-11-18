package com.example.jdbcdemo;

import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chentz
 * @version v1.0
 * @date 2020/11/18 16:19
 */
@Component
public class UserService {

    public Connection getConnection() {
        Connection conn = null;
        try {
            // 加载JDBC的驱动
            Class.forName("org.h2.Driver");

            String url = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;MODE=MySQL";
            String username = "sa";
            String password = "sa";

            // 创建与数据库的连接类的实例
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return conn;
    }

    /**
     * 使用原生jdbc进行保存
     *
     * @author chentz
     * @date 2020/11/18 17:12
     * @param
     * @return void
     */
    public void save() {
        Connection conn = getConnection();
        try {
            Statement sqlStatement = conn.createStatement();
            sqlStatement.executeUpdate("insert into person values(10,'aabb', 88)");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                // 关闭连接
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 使用原生jdbc进行保存, PreparedStatement替代Statement
     *
     * @author chentz
     * @date 2020/11/18 17:12
     * @param
     * @return void
     */
    public void insert() {
        Connection conn = getConnection();
        try {
            String sql = "INSERT INTO person(name, age) VALUES(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "chentz001");
            ps.setInt(2, 18);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                // 关闭连接
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 使用原生jdbc进行查询
     *
     * @author chentz
     * @date 2020/11/18 17:13
     * @param
     * @return java.util.List<com.example.jdbcdemo.Person>
     */
    public List<Person> query() {
        Connection conn = getConnection();
        List<Person> personList = new ArrayList<>();
        try {
            Statement sqlStatement = conn.createStatement();
            String query = "select * from person";
            ResultSet result = sqlStatement.executeQuery(query);
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                Integer age = result.getInt("age");
                Person person = new Person();
                person.setId(id);
                person.setAge(age);
                person.setName(name);
                personList.add(person);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                // 关闭连接
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return personList;
    }


}
