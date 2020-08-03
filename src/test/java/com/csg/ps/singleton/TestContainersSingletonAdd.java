package com.csg.ps.singleton;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.csg.ps.TestContainersDBUtil.countEntries;
import static com.csg.ps.singleton.TestContainersSingleton.ORACLE_CONTAINER;

public class TestContainersSingletonAdd {

    @Test
    void addOperation() throws SQLException {
        final Connection connection = DriverManager.getConnection(ORACLE_CONTAINER.getJdbcUrl(),
                ORACLE_CONTAINER.getUsername(), ORACLE_CONTAINER.getPassword());
        countEntries(connection);

        connection.createStatement().execute("INSERT INTO CLIENT_INFO VALUES ('012345678924', 'Z')");

        countEntries(connection);
    }

    @Test
    void addOperation2() throws SQLException {
        final Connection connection = DriverManager.getConnection(ORACLE_CONTAINER.getJdbcUrl(),
                ORACLE_CONTAINER.getUsername(), ORACLE_CONTAINER.getPassword());
        countEntries(connection);

        connection.createStatement().execute("INSERT INTO CLIENT_INFO VALUES ('012345678924', 'Z')");

        countEntries(connection);
    }

}
