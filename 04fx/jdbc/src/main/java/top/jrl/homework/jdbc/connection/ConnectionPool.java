package top.jrl.homework.jdbc.connection;

import java.sql.Connection;

/**
 * 自制数据库连接池
 * https://www.baeldung.com/java-connection-pooling
 * @author jrl
 * @date Create in 11:35 2022/4/23
 */
public interface ConnectionPool {
    Connection getConnection();

    boolean releaseConnection(Connection connection);

    // DONE_Joly:数据库地址
    String getUrl();

    // DONE_Joly:数据库用户名
    String getUser();

    // DONE_Joly:数据库密码
    String getPassword();
}
