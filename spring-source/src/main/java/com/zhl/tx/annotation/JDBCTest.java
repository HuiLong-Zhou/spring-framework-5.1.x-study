package com.zhl.tx.annotation;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-07 20:36
 */
public class JDBCTest {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
        conn.setReadOnly(false);
//        conn.setNetworkTimeout();
    }
}
