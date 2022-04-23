package top.jrl.homework.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jrl
 * @date Create in 11:37 2022/4/23
 */
public class BasicConnectionPool implements ConnectionPool {
    private String url;
    private String user;
    private String password;
    // 剩下还没被用的connection
    private List<Connection> connectionPool;
    // 正在被用的connection
    private List<Connection> usedConnections = new ArrayList<>();
    private static int INITIAL_POOL_SIZE = 10;

    /**
     * 初始化数据库连接池：创建多个连接，并放入连接池（容器）中
     * As it's much better to keep the creation of connections database agnostic,
     * we've used the former within the create() static factory method.
     *
     * @param
     * @return
     * @date 2022/4/23
     */
    public static BasicConnectionPool create(
            String url, String user,
            String password) throws SQLException {

        List<Connection> pool = new ArrayList<>(INITIAL_POOL_SIZE);
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            pool.add(createConnection(url, user, password));
        }
        return new BasicConnectionPool(url, user, password, pool);
    }

    private static Connection createConnection(
            String url, String user, String password)
            throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public Connection getConnection() {
        // 从数据库连接池中拿出来一个连接
        Connection connection = connectionPool
                .remove(connectionPool.size() - 1);
        // 把这个连接放到已使用连接池中
        usedConnections.add(connection);
        return connection;
    }

    @Override
    public boolean releaseConnection(Connection connection) {
        // 把这个连接放回数据库连接池
        connectionPool.add(connection);
        // 从已经使用连接池中把这个连接移除掉
        return usedConnections.remove(connection);
    }

    /**
     * 数据库连接池总大小是剩下的➕已使用的
     *
     * @param
     * @return
     * @date 2022/4/23
     */
    public int getSize() {
        return connectionPool.size() + usedConnections.size();
    }

    @Override
    public String getUrl() {
        return null;
    }

    @Override
    public String getUser() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    public BasicConnectionPool(String url, String user, String password, List<Connection> connectionPool) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.connectionPool = connectionPool;

    }


}
