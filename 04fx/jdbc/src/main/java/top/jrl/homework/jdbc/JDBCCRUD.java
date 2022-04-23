package top.jrl.homework.jdbc;

import java.sql.*;

/**
 * 使用 JDBC 原生接口，实现数据库的增删改查操作。
 *
 * @author jrl
 * @date Create in 22:12 2022/4/21
 */
public class JDBCCRUD {
    public static void main(String[] args) throws SQLException {
        //1.注册驱动(mysql针对JDBC提供的驱动)
        // Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接对象
        String url = "jdbc:mysql://47.115.148.27:3306/base1";
        Connection connection = DriverManager.getConnection(url, "joly1", "some_pass");
        //3.获取执行SQL语句
        Statement statement = connection.createStatement();
        String sql = "select * from person where age = '25' ";
        //4.调用执行者对象方法,执行SQL语句获取结果集
        //5.处理结果集
        //4.1 查
        ResultSet resultSet = statement.executeQuery(sql);
        // TODO_Joly:这里有个顺序bug，我不知道为什么。都执行完了sql以后再去处理结果集就会报错。
        // TODO_Joly:说连接已经断开了
        //5.1 查
        while (resultSet.next()) {
            int age = resultSet.getInt("age");
            System.out.println(age);
        }
        //4.2 增
        int executeUpdate = statement.executeUpdate("insert into person values (26,'Jolin-super',0)");
        //5.2 增
        if (executeUpdate != -1){
            System.out.println(executeUpdate);
        }
        //6.关闭资源
        // TODO_Joly:resultSet\statement为什么要关闭，这俩本质是啥.我可能还不太明白关闭到底意味着什么。
        resultSet.close();
        statement.close();
        connection.close();
    }
}
