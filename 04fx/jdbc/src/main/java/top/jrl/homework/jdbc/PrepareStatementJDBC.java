package top.jrl.homework.jdbc;


import java.sql.*;
import java.util.Arrays;
import java.util.Random;

/**
 * 2）使用事务，PrepareStatement 方式，批处理方式，改进上述操作。
 * 3）配置 Hikari 连接池，改进上述操作。
 *
 * @author jrl
 * @date Create in 13:59 2022/4/22
 */

public class PrepareStatementJDBC {

    public static void main(String[] args) throws SQLException {
        //2.获取连接对象
        // String url = "jdbc:mysql://47.115.148.27:3306/base1";
        // Connection connection = DriverManager.getConnection(url, "joly1", "some_pass");
        Connection connection = MyHikariDataSource.getConnection();
        //3.获取执行SQL语句
        String sql = "select * from person where age = ? ";
        String updateSql = "update person set age = ? where name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        PreparedStatement preparedStatement1 = connection.prepareStatement(updateSql);
        //4.调用执行者对象方法,执行SQL语句获取结果集
        //5.处理结果集
        //4.1 查
        preparedStatement.setInt(1, 25);
        ResultSet resultSet = preparedStatement.executeQuery();
        //4.2 更新
        for (int i = 0; i < 3; i++) {
            preparedStatement1.setInt(1, new Random().nextInt(100));
            preparedStatement1.setString(2, "Jolin" + "-" + i);
            connection.setAutoCommit(false);
            int executeUpdate = preparedStatement1.executeUpdate();
            if (executeUpdate != 0) {
                System.out.println(executeUpdate);

            }
            if (new Random().nextInt(10) > 5) {
                connection.commit();
                System.out.println("commit" + i);
            } else {
                connection.rollback();
                System.out.println("rollback" + i);
            }
        }
        // 4.3 使用批处理
        connection.setAutoCommit(false);
        for (int i = 0; i < 3; i++) {
            preparedStatement1.setInt(1, new Random().nextInt(100));
            preparedStatement1.setString(2, "Jolin" + "-" + i);
            preparedStatement1.addBatch();
        }
        int[] ints = preparedStatement1.executeBatch();
        connection.commit();
        Arrays.stream(ints).forEach(
                System.out::println
        );

        //5.1 查
        while (resultSet.next()) {
            int age = resultSet.getInt("age");
            System.out.println(age);
        }

        //6.关闭资源
        // 使用Hikari的情况下，就会去调用Hikari的实现。因为这个close是个抽象方法呀
        connection.close();

    }
}
