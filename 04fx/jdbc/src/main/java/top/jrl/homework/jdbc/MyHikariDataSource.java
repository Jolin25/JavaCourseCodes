package top.jrl.homework.jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * https://www.baeldung.com/hikaricp
 *
 * @author jrl
 * @date Create in 14:16 2022/4/23
 */
public class MyHikariDataSource {
    // let's look at HikariCP, a lightning-fast JDBC connection pooling framework
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {
        config.setJdbcUrl("jdbc:mysql://47.115.148.27:3306/base1");
        config.setUsername("joly1");
        config.setPassword("some_pass");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
